package Relationships_ObjectBehaviour.Practice;

import java.util.ArrayList;
import java.util.List;

class University {
    private List<College> colleges;
    private String name;
    University(String name) {
        this.name = name;
        colleges = new ArrayList<>();
    }
    public void addCollege(String collegeName, String collegeId) {
        // adding a college to university's list of colleges
        colleges.add(new College(collegeName, collegeId));
    }
    public void displayDetails() {
        System.out.println("University Name : " + name);
        for(College x: colleges){
            x.displayDetails();
        }
    }
}

class College {
    private String name;
    private String id;
    College(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public void displayDetails() {
        System.out.println("College Name : " + name);
        System.out.println("College ID : " + id);
    }
}

public class Composition {
    public static void main(String[] args) {
        String universityName = "MM";
        String[] collegeNames = { "MMEC", "MMIMSR", "MMCP", "MMIM", "HM" };
        String[] collegeIds = { "EC123", "SR787", "CP879", "IM568", "HM675" };

        //creating the object of class University with the name as constructor argument
        University university = new University(universityName);
        
        //adding the collge names and id using the addCollege mthod called through the university object
        for (int i = 0; i < collegeNames.length; i++) {
            university.addCollege(collegeNames[i], collegeIds[i]);
        }

        //calling the method displayDetails through the university object
        university.displayDetails();
    }
}