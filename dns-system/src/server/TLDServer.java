package server;

import record.CNAMERecord;
import record.DNSRecord;

// TLD Server
public class TLDServer extends DNSServer {
    @Override
    public DNSRecord handleRequest(String domain) {
        log("server.TLDServer handling request for: " + domain);
        if (domain.equals("example.com")) {
            return new CNAMERecord("auth.example.com", 3600);
        }
        return null;
    }
}