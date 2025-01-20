package server;

import record.ARecord;
import record.DNSRecord;

// Authoritative Server
public class AuthoritativeServer extends DNSServer {
    @Override
    public DNSRecord handleRequest(String domain) {
        log("server.AuthoritativeServer handling request for: " + domain);
        if (domain.equals("www.example.com")) {
            return new ARecord("192.0.2.1", 300);
        }
        return null;
    }
}