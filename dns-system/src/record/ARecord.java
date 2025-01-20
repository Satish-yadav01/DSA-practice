package record;

public class ARecord implements DNSRecord {

    private final String ipAddress;
    private final int ttl;

    public ARecord(String ipAddress, int ttl) {
        this.ipAddress = ipAddress;
        this.ttl = ttl;
    }

    @Override
    public String getType() {
        return "A";
    }

    @Override
    public String getValue() {
        return ipAddress;
    }

    @Override
    public int getTTL() {
        return ttl;
    }
}
