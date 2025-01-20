package hash;

public class HashFunction2 implements HashFunction {
    @Override
    public int hash(String key) {
        return key.hashCode() & 0x7ffffff; // Positive hash value
    }
}
