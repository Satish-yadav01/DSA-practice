package lld.lms;

import lld.lms.entity.Book;
import lld.lms.entity.Copy;
import lld.lms.entity.Librarian;
import lld.lms.entity.Member;

import java.util.List;

public class LMSDriver {
    public static void main(String[] args) {
        System.out.println("-----start----");
        Librarian librarian = new Librarian(1, "Abhay");
        for (int i = 0; i < 10; i++) {
            librarian.addBook(new Copy(i,new Book("c"+i,"drevid"+i,2001+i)));
        }

        librarian.addBook(new Copy(11,new Book("c0","drevid0",2001)));

        List<Copy> inventory = librarian.getInventory();
        for (Copy c : inventory) {
            System.out.println(c.toString());
        }

        System.out.println("-----end----");
        librarian.searchBookByName("c0").forEach(System.out::println);

        librarian.addMember(new Member(1,"satish"));
        librarian.addMember(new Member(2,"Naman"));
        librarian.addMember(new Member(3,"Abhishek"));

        System.out.println("Member names----->");
        List<Member> allMembers = librarian.getAllMembers();
        allMembers.forEach(member -> System.out.println(member.getUsername()));


        Member member = librarian.getMemberById(1);
        System.out.println(member.getUsername());

        System.out.println("Assigning copies to Members");

        librarian.assignBookToMember("c0",member);
        librarian.searchBookByName("c0").forEach(System.out::println);
    }
}
