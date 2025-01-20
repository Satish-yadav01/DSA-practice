package server;

import record.DNSRecord;

// Abstract DNS Server
public abstract class DNSServer {
    public abstract DNSRecord handleRequest(String domain);

    protected void log(String message) {
        System.out.println("[LOG] " + message);
    }
}