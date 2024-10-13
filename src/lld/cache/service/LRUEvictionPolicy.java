package lld.cache.service;

import lld.cache.data.CacheEntry;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K,V> implements EvictionPolicy<K,V> {

    private final Map<K,Long> keyAccessedmap = new HashMap<>();

    @Override
    public void keyAccessed(K key) {
        keyAccessedmap.put(key, System.currentTimeMillis());
    }

    @Override
    public K evict(Map<K, CacheEntry<K, V>> cacheStorage) {
        return keyAccessedmap.entrySet().stream()
                .min(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(IllegalStateException::new);
    }
}
