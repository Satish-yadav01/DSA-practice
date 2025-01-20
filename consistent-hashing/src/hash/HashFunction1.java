package hash;

public class HashFunction1 implements HashFunction {
    @Override
    public int hash(String key) {
        return Math.abs(key.hashCode() % 1000); // Positive hash value
    }
}
