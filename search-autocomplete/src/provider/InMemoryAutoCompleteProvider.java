package provider;

import datasource.DataSource;
import trie.Trie;

import java.util.List;

public class InMemoryAutoCompleteProvider implements AutoCompleteProvider {
    private final Trie trie;

    public InMemoryAutoCompleteProvider(DataSource dataSource) {
        this.trie = new Trie();
        initializeTrie(dataSource.fetchData());
    }

    private void initializeTrie(List<String> data) {
        for (String word : data) {
            trie.insert(word);
        }
    }

    @Override
    public List<String> getSuggestions(String text) {
        return trie.search(text);
    }
}
