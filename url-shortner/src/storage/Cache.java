package storage;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    Map<String, String> cache = new HashMap<>();

    public void saveInCache(String key, String value) {
        cache.put(key, value);
    }

    public String getFromCache(String key) {
        return cache.get(key);
    }
}
