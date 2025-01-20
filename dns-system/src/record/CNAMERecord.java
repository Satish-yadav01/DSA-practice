package record;

public class CNAMERecord implements DNSRecord {
    private final String canonicalName;
    private final int ttl;

    public CNAMERecord(String canonicalName, int ttl) {
        this.canonicalName = canonicalName;
        this.ttl = ttl;
    }

    @Override
    public String getType() {
        return "CNAME";
    }

    @Override
    public String getValue() {
        return canonicalName;
    }

    @Override
    public int getTTL() {
        return ttl;
    }
}