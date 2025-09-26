package Relationships_ObjectBehaviour.Association;

import java.util.ArrayList;
import java.util.List;

class Member {
    private String name;
    private String id;
    Member(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
}

class College {
    private String name;
    // a college consists of multiple students 
    private List<Member> members;
    College(String name) {
        this.name = name;
        members = new ArrayList<>();
    }
    public void addMember(Member member) {
        members.add(member);
    }
    public void displayAllMembers() {
        for(Member x: members) {
            System.out.println("Name: "+x.getName()+", ID: "+x.getId());
        }
    }
}

public class OneToMany {
    public static void main(String[] args) {
        Member s1 = new Member("Tripti", "2747");
        Member s2 = new Member("Selena", "8326");
        College clg = new College("MMDU");
        clg.addMember(s1);
        clg.addMember(s2);
        clg.displayAllMembers();
    }
}