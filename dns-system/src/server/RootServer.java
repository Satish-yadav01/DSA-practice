package server;

import record.CNAMERecord;
import record.DNSRecord;

// Root Server
public class RootServer extends DNSServer {
    @Override
    public DNSRecord handleRequest(String domain) {
        log("server.RootServer handling request for: " + domain);
        if (domain.endsWith(".com")) {
            return new CNAMERecord("com.tld.server", 3600);
        }
        return null;
    }
}