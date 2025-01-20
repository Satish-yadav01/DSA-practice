package storage;

import java.util.HashMap;
import java.util.Map;

public class Database {
     Map<String,String> urlMapping = new HashMap<>();

     public void saveUrlMapping(String shortUrl, String longUrl) {
         urlMapping.put(shortUrl, longUrl);
         System.out.println("Saved url mapping: " + shortUrl + " -> " + longUrl);
     }

     public String getUrlMapping(String shortUrl) {
         return urlMapping.get(shortUrl);
     }

    public Map<String, String> getUrlMapping() {
        return urlMapping;
    }
}
