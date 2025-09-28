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

        System.out.println("Student name: "+student.name+" with passport number: "+student.passport.passportNumber);
        System.out.println("Cloned student name: "+clonedStudent.name+" with passport number: "+clonedStudent.passport.passportNumber);

        System.out.println();
        //  modify

        clonedStudent.name = "Ram";// Only cloned student name was modified as name was a field
        clonedStudent.passport.passportNumber = "112233";// Both cloned student and original student passport number modified as passport was a reference to another object, so only the reference was copied
        // Any other objects are not copied rather the references are copied
        // So if you change anything in that reference it will be reflected in original object also
        System.out.println("Student name: "+student.name+" with passport number: "+student.passport.passportNumber);
        System.out.println("Cloned student name: "+clonedStudent.name+" with passport number: "+clonedStudent.passport.passportNumber);
    }
}


/**
 * OBJECT CLONING
 * 1. “Mujhe clone karna hai”
Sabse pehle dimaag me aata hai → Java me har class Object ko extend karti hai.
To obvious soch → clone() to Object me hoga, wahi use karenge.

2. “Object me clone() protected hai”
Matlab → direct s1.clone() main me call karne se error.
Compiler ye galti pakad ke tujhko hint deta hai.
Tera kaam hai us hint ko step bana lena.

3. “Implement Cloneable”
Next thought → kyu CloneNotSupportedException aa raha hai?
Kyunki Object.clone() by default allow nahi karta unless class Cloneable implement karti hai.
To tu add karta hai → implements Cloneable.

4. “Override clone() aur throws add karna”
Ab tu apni class me clone override karega.
Lekin compiler bolta hai → “Unhandled exception CloneNotSupportedException”.
Iska matlab hai → method signature me throws likhna hi hoga.

5. “Type cast”
clone() ka return type Object hai.
Lekin tujhe Student chahiye.
Soch logical hai: “Arre return Object aa raha hai, mujhe Student banana padega.”
Isiliye (Student) cast karega.

6. “Exception in main()”
Jab tu s1.clone() main me call karega → compiler bolega “bhai tu clone() call kar raha hai jo throws karta hai, tu handle kar”.
To fir tu choose karega: throws laga du ya try-catch.
 */