package lld.lms.repo;

import lld.lms.entity.Copy;

import java.util.List;

public interface User {
    String getUsername();
    int getUserid();
    List<Copy> searchBookByName(String bookName);
}
