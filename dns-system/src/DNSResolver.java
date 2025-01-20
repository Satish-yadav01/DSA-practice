import cache.DNSCache;
import record.DNSRecord;
import server.AuthoritativeServer;
import server.DNSServer;
import server.RootServer;
import server.TLDServer;

import java.util.ArrayList;
import java.util.List;

public class DNSResolver {
    private final List<DNSServer> servers;

    public DNSResolver() {
        servers = new ArrayList<>();
        servers.add(new RootServer());
        servers.add(new TLDServer());
        servers.add(new AuthoritativeServer());
    }

    public DNSRecord resolve(String domain) {
        DNSCache cache = DNSCache.getInstance();
        DNSRecord cachedRecord = cache.getRecord(domain);

        if (cachedRecord != null) {
            System.out.println("[CACHE HIT] Record found for: " + domain);
            return cachedRecord;
        }

        for (DNSServer server : servers) {
            DNSRecord record = server.handleRequest(domain);
            if (record != null) {
                System.out.println("[RESOLVED] Record found for: " + domain);
                cache.addRecord(domain, record);
                return record;
            }
        }

        System.out.println("[NOT FOUND] No record found for: " + domain);
        return null;
    }
}
