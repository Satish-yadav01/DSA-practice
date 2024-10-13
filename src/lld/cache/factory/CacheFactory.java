package lld.cache.factory;

import lld.cache.model.Cache;
import lld.cache.model.InMemoryCache;
import lld.cache.service.EvictionPolicy;
import lld.cache.service.LFUEvictionPolicy;
import lld.cache.service.LRUEvictionPolicy;

public class CacheFactory<K,V> {
    public Cache<K, V> createCache(String evictionPolicyType, int maxCapacity) {
        EvictionPolicy<K,V> evictionPolicy;
        switch (evictionPolicyType) {
            case "LRU":
                evictionPolicy = new LRUEvictionPolicy<>();
                break;
            case "LFU":
                evictionPolicy = new LFUEvictionPolicy<>();
                break;
            default:
                throw new IllegalArgumentException("Invalid eviction policy type");
        }
        return new InMemoryCache<>(evictionPolicy, maxCapacity);
    }
}
