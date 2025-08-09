import datasource.DataSource;
import datasource.DatabaseDataSource;
import provider.AutoCompleteProvider;
import provider.CacheProvider;
import provider.InMemoryAutoCompleteProvider;
import service.SearchService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Step 1: Set up the data source
        DataSource dataSource = new DatabaseDataSource(); // Fetch data from database

        // Step 2: Create the auto-complete provider
        AutoCompleteProvider baseProvider = new InMemoryAutoCompleteProvider(dataSource);

        // Step 3: Add caching functionality (optional)
        AutoCompleteProvider cachedProvider = new CacheProvider(baseProvider);

        // Step 4: Initialize the search service
        SearchService searchService = new SearchService(cachedProvider);

        // Step 5: Simulate user queries and display suggestions
        String[] testQueries = {"app", "ban", "apple", "cat"};

        for (String query : testQueries) {
            List<String> suggestions = searchService.fetchSuggestions(query);
            System.out.println("Query: " + query);
            System.out.println("Suggestions: " + suggestions);
            System.out.println("----------------------");
        }

    }
}