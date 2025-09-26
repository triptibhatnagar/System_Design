package Relationships_ObjectBehaviour.Composition;

class Passport {
    private String passportNumber;
    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}

class Person {
    private String name;
    // Person has Passport class within it but does not owns it
    private Passport passport;
    Person(String name, String passportNumber) {
        this.name = name;
        this.passport = new Passport(passportNumber);
    }
    // Passport class is inside the Person class and it is owning it up Because passport instance is created within the Person class
    // Strong relationship
    // If student will be gone then that instance of Passport class will also be gone

}

public class Example_Comp {
    public static void main(String[] args) {
        Person person = new Person("Chetan", "18234712984");
    }
}