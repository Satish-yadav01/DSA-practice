package record;

// Interface for DNS Records
public interface DNSRecord {
    String getType();
    String getValue();
    int getTTL();
}
