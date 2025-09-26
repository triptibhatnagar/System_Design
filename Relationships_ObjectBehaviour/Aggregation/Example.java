package Relationships_ObjectBehaviour.Aggregation;

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
    Person(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }
}

public class Example {
    public static void main(String[] args) {
        // Passport is standing independently
        // If Person is gone, Passport will still be there
        Passport passport = new Passport("18234712984");
        Person person = new Person("Chetan", passport);
        // Both the Passport an dperson class are standing independently
    }
}