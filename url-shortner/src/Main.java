import hash.Base62Encoder;
import storage.Cache;
import storage.Database;
import url.UrlGenerator;
import url.UrlService;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        UrlService urlService = new UrlService(new UrlGenerator(new Base62Encoder()),database , new Cache());
        String shortUrl = urlService.createShortUrl("https://www.google.com");
        String shortUrl1 = urlService.createShortUrl("https://www.apple.com");
        String shortUrl2 = urlService.createShortUrl("https://www.mongo.com");

        System.out.println("shortUrl: " + shortUrl+ "\n shortUrl1: " + shortUrl1+ "\n shortUrl2: " + shortUrl2);
        System.out.println();

        System.out.println(database.getUrlMapping());


        String originalUrl = urlService.getOriginalUrl(shortUrl);
        System.out.println(" short url : %s and originalUrl: %s".formatted(shortUrl, originalUrl));
        System.out.println(" short url : %s and originalUrl: %s".formatted(shortUrl1, urlService.getOriginalUrl(shortUrl1)));
        System.out.println(" short url : %s and originalUrl: %s".formatted(shortUrl2, urlService.getOriginalUrl(shortUrl2)));

    }
}