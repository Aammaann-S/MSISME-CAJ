package Lab3;

public class Employee {
    int employeeId;
    String name;
    String designation;
    double salary;

    // Constructor
    public Employee(int employeeId, String name, String designation, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
    public String getDesignation() {
        return designation;
    }
    public double getSalary() {
        return salary;
    }

    // Setters
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display Employee Details
    public void displayEmployeeDetails(){
        System.out.println("Employee - "+employeeId);
        System.out.println("Name - "+name);
        System.out.println("Designation - "+designation);
        System.out.println("Salary - "+salary);
    }

    @Override // overriding a base function(?)
    public String toString(){
        return "ID: "+getEmployeeId()+",\nName: "+getName()+",\nDesignation: "+getDesignation()+",\nSalary: "+getSalary();
    }

    public boolean searchEmployeeById(int employeeId){
        if(this.employeeId == employeeId)
            return true;
        return false;
    }

    public void incrementSalary(int percentage){
        this.salary=this.salary + (this.salary * ((double) percentage /100));
    }
}

