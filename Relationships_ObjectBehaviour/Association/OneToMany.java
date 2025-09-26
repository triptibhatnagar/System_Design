package Relationships_ObjectBehaviour.Association;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private String id;
    Student(String name, String id) {
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
    private List<Student> students;
    College(String name) {
        this.name = name;
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void displayAllStudents() {
        for(Student x: students) {
            System.out.println("Name: "+x.getName()+", ID: "+x.getId());
        }
    }
}

public class OneToMany {
    public static void main(String[] args) {
        Student s1 = new Student("Tripti", "2747");
        Student s2 = new Student("Selena", "8326");
        College clg = new College("MMDU");
        clg.addStudent(s1);
        clg.addStudent(s2);
        clg.displayAllStudents();
    }
}