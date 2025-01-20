package cache;

import record.DNSRecord;

import java.util.HashMap;
import java.util.Map;

public class DNSCache {
    private static DNSCache instance;
    private final Map<String, DNSRecord> cache;

    private DNSCache() {
        this.cache = new HashMap<>();
    }

    public static synchronized DNSCache getInstance() {
        if (instance == null) {
            instance = new DNSCache();
        }
        return instance;
    }

    public void addRecord(String domain, DNSRecord record) {
        cache.put(domain, record);
    }

    public DNSRecord getRecord(String domain) {
        return cache.get(domain);
    }
}