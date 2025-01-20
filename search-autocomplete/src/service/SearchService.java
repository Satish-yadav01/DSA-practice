package service;

import provider.AutoCompleteProvider;

import java.util.List;

public class SearchService {
    private final AutoCompleteProvider autoCompleteProvider;

    public SearchService(AutoCompleteProvider autoCompleteProvider) {
        this.autoCompleteProvider = autoCompleteProvider;
    }

    public List<String> fetchSuggestions(String query) {
        return autoCompleteProvider.getSuggestions(query);
    }
}

