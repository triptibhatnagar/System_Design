package Relationships_ObjectBehaviour.Association;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    // a student -> can be enrolled in mutliple courses
    private List<Course> courses;
    Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }
    public void enrollCourse(Course course) {
        courses.add(course);
    }
    public String getName() {
        return name;
    }
    public void displayAllCourses() {
        for(int i=0; i<courses.size(); i++) {
            System.out.println("Name: "+courses.get(i).getName());
        }
    }
}

class Course {
    private String name;
    // a course -> multiple students can be enrolled into it
    private List<Student> students;
    Course(String name) {
        this.name = name;
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void displayAllStudents() {
        for(Student x: students) {
            System.out.println("Name: "+x.getName()+" enrolled in "+name);
        }
    }
    public String getName() {
        return name;
    }
}

public class ManyToMany {
    public static void main(String[] args) {
        Course c1 = new Course("BTech");
        Course c2 = new Course("BSc");

        Student s1 = new Student("Raj");
        Student s2 = new Student("Ram");
        Student s3 = new Student("Krishn");

        c1.addStudent(s1);
        c2.addStudent(s1);
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);

        c1.addStudent(s2);
        s2.enrollCourse(c1);

        c2.addStudent(s3);
        s3.enrollCourse(c2);

        c1.displayAllStudents();
        c2.displayAllStudents();

        s1.displayAllCourses();
    }
}