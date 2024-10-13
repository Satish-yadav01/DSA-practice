package lld.cache;

import lld.cache.factory.CacheFactory;
import lld.cache.model.Cache;

public class Driver {
    public static void main(String[] args) {
        CacheFactory<String, String> factory = new CacheFactory<>();
        Cache<String, String> cache = factory.createCache("LFU", 10);

        for (int i = 0; i < 20; i++) {
            cache.put("key" + i, "value" + i);
        }

        cache.cachePrint();
    }
}
