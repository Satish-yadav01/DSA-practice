package provider;

import java.util.List;

public interface AutoCompleteProvider {
    List<String> getSuggestions(String text);
}
