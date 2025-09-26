package Relationships_ObjectBehaviour.Association;

// one to one 
class Passport {
    private String passportNumber;
    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    public String getPassportNumber() {
        return passportNumber;
    }
}

class Person {
    private String name;
    // a person has a single passport
    private Passport passport;// a passport obj is taken as attribute
    Person(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }
    public void displayDetails() {
        System.out.println("Person name: "+ name);
        System.out.println("Person passport number: "+ passport.getPassportNumber());
    }
}

public class OneToOne {
    public static void main(String[] args) {
        Passport passport = new Passport("18234712984");
        Person person = new Person("Chetan", passport);
        person.displayDetails();
    }
}
