package lld.cache.service;

import lld.cache.data.CacheEntry;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LFUEvictionPolicy<K,V> implements EvictionPolicy<K,V> {
    private final Map<K, Integer> keyUsageCountMap = new HashMap<>();

    @Override
    public void keyAccessed(K key) {
        keyUsageCountMap.put(key, keyUsageCountMap.getOrDefault(key, 0) + 1);
    }

    @Override
    public K evict(Map<K, CacheEntry<K,V>> cacheStorage) {
        return keyUsageCountMap.entrySet().stream()
                .min(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(IllegalStateException::new);
    }
}
