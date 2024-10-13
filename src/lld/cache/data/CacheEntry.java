package lld.cache.data;

public class CacheEntry<K,V> {
    public final K key;
    public final V value;
    private long lastAccessTime; // For LRU
    private int accessCount;

    public CacheEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.lastAccessTime = System.currentTimeMillis();
        this.accessCount = 1;
    }

    public void updateAccessTime() {
        this.lastAccessTime = System.currentTimeMillis();
        this.accessCount++;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
