package lld.lms.entity;

import lld.lms.repo.User;

import java.util.ArrayList;
import java.util.List;

public class Member implements User {
    private final int id;
    private final String userName;
    private final List<Copy> copies;



    public Member(int id,String userName) {
        this.id = id;
        this.userName = userName;
        this.copies = new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public int getUserid() {
        return id;
    }

    @Override
    public List<Copy> searchBookByName(String bookName) {
        return List.of();
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void addCopy(Copy copy) {
        copies.add(copy);
        System.out.println("Copy is assigned to Member with id" + id);
    }

}
