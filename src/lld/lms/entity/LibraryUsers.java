package lld.lms.entity;

import java.util.ArrayList;
import java.util.List;

public class LibraryUsers {
    private List<Librarian> librarians;
    private List<Member> members;

    public LibraryUsers() {
        this.librarians = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public LibraryUsers(List<Librarian> librarians) {
        this.librarians = librarians;
    }

    public LibraryUsers(List<Librarian> librarians, List<Member> members) {
        this.librarians = librarians;
        this.members = members;
    }

    public List<Librarian> getALlLibrarians() {
        return librarians;
    }

    public List<Member> getAllMembers() {
        return members;
    }

    public void addMember(Member member){
        members.add(member);
        System.out.println("Member added with id:" + member.getUserid());
    }

    public Member removeMember(Member member){
        for(int i = 0; i < members.size(); i++){
            if(members.get(i).getUserid() == member.getUserid()){
                return members.remove(i);
            }
        }
        return null;
    }

    public List<Member> getMembersByName(String username) {
        List<Member> members = new ArrayList<>();
        for(Member member : members){
            if(member.getUsername().equals(username)){
                members.add(member);
            }
        }
        return members;
    }

    public Member getMemberById(int id) {
        for(Member member : members){
            if(member.getUserid() == id){
                return member;
            }
        }
        return null;
    }
}
