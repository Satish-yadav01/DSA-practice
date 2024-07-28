package lld.lms.entity;

import lld.lms.repo.Inventory;

import java.util.ArrayList;
import java.util.List;

public class BooksInventory implements Inventory<Copy> {

    private final List<Copy> copies = new ArrayList<>();

    @Override
    public boolean isAvailable(String bookName) {
        for (Copy copy : copies) {
            if (copy.getBook().getBookName().equalsIgnoreCase(bookName)){
                return true;
            }
        }
        return false;
    }

    public List<Copy> getCopiesByBookName(String bookName) {
        List<Copy> listOfCopy = new ArrayList<>();
        for (Copy copy : copies) {
            if (copy.getBook().getBookName().equalsIgnoreCase(bookName)){
                listOfCopy.add(copy);
            }
        }
        return listOfCopy.isEmpty()?null:listOfCopy;
    }

    public boolean removeCopyById(int id) {
        return copies.removeIf(copy -> copy.getId() == id);

    }

    @Override
    public void addToInventory(Copy copy) {
        copies.add(copy);
        System.out.println("Added copies to inventory with id " + copy.getId());
    }

    @Override
    public Copy removeFromInventory(Copy copy) {
        for (int i = 0; i < copies.size(); i++) {
            if (copies.get(i).getId() == copy.getId()) {
                return copies.remove(i);
            }
        }
        return null;
    }

    @Override
    public List<Copy> getInventory() {
        return copies;
    }

    @Override
    public Copy updateInventory(Copy copy) {
        for (int i = 0; i < copies.size(); i++) {
            if (copies.get(i).getId() == copy.getId()) {
                return copies.set(i, copy);
            }
        }
        return null;
    }

}
