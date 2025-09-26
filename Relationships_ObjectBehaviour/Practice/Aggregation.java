package Relationships_ObjectBehaviour.Practice;

class Department {
    private String name;
    private String id;
    Department(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public void displayDetails() {
        System.out.println("Department Name : "+name);
        System.out.println("Department Id : "+id);
    }
}

class Employee {
    private String name;
    private int id;
    private Department department;
    Employee(String name, int id, Department department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }
    public void displayDetails() {
        System.out.println("Employee Name : "+name);
        System.out.println("Employee Id : "+id);
        department.displayDetails();
    }
}

public class Aggregation {
    public static void main(String[] args) {
    
    String E_name = "Raj", D_name = "Tech", D_id = "ABC123";
    int E_id = 63546;

    //creats a object of Department class with D_name, D_id as the arguments
    Department department = new Department(D_name, D_id);
        
    //creates a object of Employee class with E_name, E_id, department as the arguments
    Employee employee = new Employee(E_name, E_id, department);
        
    //calls the display method using the employee object
    employee.displayDetails();

    }
}