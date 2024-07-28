package lld.lms.repo;

import java.util.List;

public interface Inventory<X> {
    boolean isAvailable(String name);
    void addToInventory(X obj);
    X removeFromInventory(X obj);
    List<X> getInventory();
    X updateInventory(X obj);
}
