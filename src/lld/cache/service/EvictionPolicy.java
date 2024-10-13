package lld.cache.service;

import lld.cache.data.CacheEntry;

import java.util.Map;

public interface EvictionPolicy<K,V> {
    void keyAccessed(K key); // Update policy when key is accessed
    K evict(Map<K, CacheEntry<K, V>> cacheStorage); // Determines which key to evict
}
