package url;

import storage.Cache;
import storage.Database;

public class UrlService {
    private final UrlGenerator urlGenerator;
    private final Database database;
    private final Cache cache;

    public UrlService(UrlGenerator urlGenerator, Database database, Cache cache) {
        this.urlGenerator = urlGenerator;
        this.database = database;
        this.cache = cache;
    }

    public String createShortUrl(String longUrl){
        String shortUrl = urlGenerator.generateKey(longUrl);
        database.saveUrlMapping(shortUrl,longUrl);
        return shortUrl;
    }

    public String getOriginalUrl(String shortUrl){
        String originalUrl = cache.getFromCache(shortUrl);
        if(originalUrl == null){
            originalUrl = database.getUrlMapping(shortUrl);
            if(originalUrl != null){
                cache.saveInCache(shortUrl,originalUrl);
            }else {
                String s = "%s not found in DB also".formatted(shortUrl);
                System.out.println(s);
                return s;
            }
        }

        return originalUrl;
    }
}
