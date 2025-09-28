package Relationships_ObjectBehaviour.Object_Cloning;
class Pasport implements Cloneable{
    String pasportNumber;
    Pasport(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    String name;
    Pasport pasport;
    Person(String name, Pasport pasport) {
        this.name = name;
        this.pasport = pasport;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // return super.clone();

        // this is also creating shallow copy
        /*
        Person Person = (Person) super.clone();
        return Person;
        */

        // Person is cloned but we had issue with the pasport
        Person person = (Person) super.clone();
        // make sure to clone password also
        // INDIVIDUALLY CLONE ALL THE OBJECTS Until the parent class
        person.pasport = (Pasport) pasport.clone();
        return person;
    }
}

public class DeepCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Pasport pasport = new Pasport("37643");
        Person person = new Person("Ram", pasport);
        Person clonedPerson = (Person) person.clone();

        System.out.println("Person name: "+person.name+" with pasport number: "+person.pasport.pasportNumber);
        System.out.println("Cloned Person name: "+clonedPerson.name+" with pasport number: "+clonedPerson.pasport.pasportNumber);
        /*
        Person name: Ram with pasport number: 37643
        Cloned Person name: Ram with pasport number: 37643
        */

        System.out.println();

        clonedPerson.name = "Raj";// only name changed
        clonedPerson.pasport.pasportNumber = "78678";// both original and cloned pasport number changed
        System.out.println("Person name: "+person.name+" with pasport number: "+person.pasport.pasportNumber);
        System.out.println("Cloned Person name: "+clonedPerson.name+" with pasport number: "+clonedPerson.pasport.pasportNumber);
        /*
        Person name: Ram with pasport number: 37643
        Cloned Person name: Raj with pasport number: 78678 
        */
    }
}