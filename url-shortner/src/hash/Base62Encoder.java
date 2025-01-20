package hash;

public class Base62Encoder {
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String encode(long number) {
        StringBuilder encoded = new StringBuilder();
        while (number > 0) {
            int remainder = (int) (number % 62);
            encoded.append(CHAR_SET.charAt(remainder));
            number /= 62;
        }
        return encoded.reverse().toString();
    }

    public long decode(String shortUrl) {
        long decoded = 0;
        for (char c : shortUrl.toCharArray()) {
            decoded = decoded * 62 + CHAR_SET.indexOf(c);
        }
        return decoded;
    }
}
