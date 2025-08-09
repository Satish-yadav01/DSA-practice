import record.DNSRecord;

public class Main {
    public static void main(String[] args) {
        DNSResolver resolver = new DNSResolver();

        // Resolve a domain
        System.out.println("Resolving 'www.example.com'...");
        DNSRecord record1 = resolver.resolve("www.example.com");
        printRecord(record1);

        // Resolve again to hit the cache
        System.out.println("\nResolving 'www.example.com' again...");
        DNSRecord record2 = resolver.resolve("www.example.com");
        printRecord(record2);

        // Resolve a non-existent domain
        System.out.println("\nResolving 'nonexistent.example.com'...");
        DNSRecord record3 = resolver.resolve("nonexistent.example.com");
        printRecord(record3);
    }

    private static void printRecord(DNSRecord record) {
        if (record != null) {
            System.out.printf("Type: %s, Value: %s, TTL: %d%n", record.getType(), record.getValue(), record.getTTL());
        } else {
            System.out.println("No record found.");
        }
    }
}