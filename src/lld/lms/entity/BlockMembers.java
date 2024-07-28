package lld.lms.entity;

import java.util.List;

public class BlockMembers {
    private List<Integer> memberId;


    public void blockMember(Member member) {
        System.out.println("Blocking member with userid :" + member.getUserid());
        memberId.add(member.getUserid());
    }
}
