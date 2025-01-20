package datasource;

import java.util.List;

public class DatabaseDataSource implements DataSource {
    @Override
    public List<String> fetchData() {
        // Implementation for fetching data from the database
        return List.of("apple", "application", "appreciate", "banana");
    }
}
