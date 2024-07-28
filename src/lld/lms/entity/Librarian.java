package lld.lms.entity;

import lld.lms.repo.User;

import java.util.ArrayList;
import java.util.List;


public class Librarian implements User {
    private final int id;
    private final String userName;
    private final BooksInventory booksInventory = new BooksInventory();
    private final BlockMembers blockMembers = new BlockMembers();
    private final LibraryUsers libraryUsers = new LibraryUsers();


    public Librarian(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public int getUserid() {
        return id;
    }

    public void addBook(Copy book) {
        booksInventory.addToInventory(book);
    }

    public void removeBook(Copy book) {
        booksInventory.removeFromInventory(book);
    }

    public void updateBook(Copy book) {
        booksInventory.updateInventory(book);
    }

    public List<Copy> getInventory() {
        return booksInventory.getInventory();
    }

    public void addMember(Member member) {
        libraryUsers.addMember(member);
    }

    public Member removeMember(Member member) {
        return libraryUsers.removeMember(member);
    }

    public void blockMember(Member member) {
        blockMembers.blockMember(member);
    }

    @Override
    public List<Copy> searchBookByName(String bookName) {
        List<Copy> searchList = new ArrayList<>();
        List<Copy> inventory = booksInventory.getInventory();

        for (Copy copy : inventory) {
            if(copy.getBook().getBookName().equals(bookName)){
                searchList.add(copy);
            }
        }
        return searchList;
    }

    public boolean assignBookToMember(String bookName,Member member) {
        if(booksInventory.isAvailable(bookName)){
            List<Copy> availableCopies = booksInventory.getCopiesByBookName(bookName);
            member.addCopy(availableCopies.getFirst());
            booksInventory.removeCopyById(availableCopies.getFirst().getId());
            return true;
        }
        System.out.println("Book " + bookName + " is not available");
        return false;
    }

    public List<Member> getAllMembers() {
        return libraryUsers.getAllMembers();
    }

    public Member getMemberById(int memberId) {
        return libraryUsers.getMemberById(memberId);
    }
}
