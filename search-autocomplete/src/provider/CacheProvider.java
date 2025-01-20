package provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheProvider implements AutoCompleteProvider {
    private final AutoCompleteProvider autoCompleteProvider;
    private final Map<String, List<String>> cache = new HashMap<>();

    public CacheProvider(AutoCompleteProvider autoCompleteProvider) {
        this.autoCompleteProvider = autoCompleteProvider;
    }

    @Override
    public List<String> getSuggestions(String query) {
        if (cache.containsKey(query)) {
            return cache.get(query);
        }
        List<String> suggestions = autoCompleteProvider.getSuggestions(query);
        cache.put(query, suggestions);
        return suggestions;
    }
}

