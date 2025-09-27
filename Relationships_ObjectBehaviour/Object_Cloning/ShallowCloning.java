package Relationships_ObjectBehaviour.Object_Cloning;

class Passport {
    String passportNumber;
    Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}

class Student implements Cloneable {
    String name;
    Passport passport;
    Student(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class ShallowCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Passport passport = new Passport("2876387");
        Student student = new Student("Raj", passport);

        // way 1
        // what if after original obj, most of business logic is written, manually check that what changes were done, and then again update clonedStudent -> Tedious
        // Student clonedStudent = new Student("Raj", passport);


        // way 2
        Student clonedStudent = (Student) student.clone();
        /* for student.clone(), 
         * go to Student class and implement Cloneable
         * override clone() method (will give error : Unhandled exception type CloneNotSupportedException)
         * so add throws CloneNotSupportedException
         * type mismatch in student.clone() -> (Object)
         * add exception in main() method also
         *  */ 

        System.out.println(student.name);
        System.out.println(student.passport.passportNumber);
        System.out.println(clonedStudent.name);
        System.out.println(clonedStudent.passport.passportNumber);

        System.out.println();
        //  modify
        clonedStudent.name = "Ram";// Only cloned student name was modified as name was a field
        clonedStudent.passport.passportNumber = "112233";// Both cloned student and original student passport number modified as passport was a reference to another object, so only the reference was copied
        // Any other objects are not copied rather the references are copied
        // So if you change anything in that reference it will be reflected in original object also
        System.out.println(student.name);
        System.out.println(student.passport.passportNumber);
        System.out.println(clonedStudent.name);
        System.out.println(clonedStudent.passport.passportNumber);
    }
}