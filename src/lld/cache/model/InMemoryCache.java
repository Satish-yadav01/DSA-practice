package lld.cache.model;

import lld.cache.data.CacheEntry;
import lld.cache.service.EvictionPolicy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache<K,V> implements Cache<K,V> {

    private final Map<K, CacheEntry<K, V>> cacheStorage;
    private final EvictionPolicy<K,V> evictionPolicy;
    private final int maxCapacity;

    public InMemoryCache(EvictionPolicy<K,V> evictionPolicy, int maxCapacity) {
        this.evictionPolicy = evictionPolicy;
        this.maxCapacity = maxCapacity;
        this.cacheStorage = new ConcurrentHashMap<K, CacheEntry<K, V>>();
    }


    @Override
    public void put(K key, V value) {
        if (cacheStorage.size() >= maxCapacity) {
            K evict = evictionPolicy.evict(cacheStorage);
            cacheStorage.remove(evict);
        }
        cacheStorage.put(key, new CacheEntry<>(key, value));
        evictionPolicy.keyAccessed(key);
    }

    @Override
    public V get(K key) {
        if (!cacheStorage.containsKey(key)) {
            return null; // Cache miss
        }
        evictionPolicy.keyAccessed(key); // Update policy for access tracking
        return cacheStorage.get(key).getValue();
    }

    @Override
    public void evict(K key) {
        cacheStorage.remove(key);
    }

    @Override
    public int size() {
        return cacheStorage.size();
    }

    @Override
    public void cachePrint(){
        for(K key : cacheStorage.keySet()){
            CacheEntry<K, V> entry = cacheStorage.get(key);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "InMemoryCache{" +
                "cacheStorage=" + cacheStorage +
                ", evictionPolicy=" + evictionPolicy +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
