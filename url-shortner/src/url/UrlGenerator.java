package url;

import hash.Base62Encoder;

public class UrlGenerator {

    private Base62Encoder encoder;

    public UrlGenerator(Base62Encoder encoder) {
        this.encoder = encoder;
    }

    public String generateKey(String originalUrl) {
        long hash = originalUrl.hashCode();
        System.out.println("Hash: " + hash + " created for url: " + originalUrl);
        return encoder.encode(Math.abs(hash));
    }

    public boolean validateKey(String key) {
        return key != null && key.matches("^[a-zA-Z0-9]+$");
    }

    public static void main(String[] args) {
        UrlGenerator generator = new UrlGenerator(new Base62Encoder());
        generator.generateKey("https://www.google.com");
    }
}
