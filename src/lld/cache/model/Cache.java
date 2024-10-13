package lld.cache.model;

public interface Cache<K,V> {
    void put(K key, V value);
    V get(K key);
    void evict(K key);
    int size();
    void cachePrint();
}
