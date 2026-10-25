package Lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q12 {
    static List<Employee> emp = new ArrayList<Employee>();
    static int option;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n>>> EIS <<<");
        System.out.print("Number of Employees: ");
        int eno = sc.nextInt();
        for (int i = 0;i<eno;i++){
            System.out.print("Employees "+(i+1)+"'s Employee Id:");
            int id = sc.nextInt();
            System.out.print("Employees "+(i+1)+"'s Name:");
            String name = sc.next();
            System.out.print("Employees "+(i+1)+"'s Designation:");
            String designation = sc.next();
            System.out.print("Employees "+(i+1)+"'s Salary:");
            double salary = sc.nextDouble();
            System.out.println("Adding Employee "+(i+1)+"'s Data...");
            emp.add(new Employee(id,name,designation,salary));
            System.out.println("Employee "+(i+1)+" Added.");
        }
        do {
            System.out.println("\nMENU Options>>>");
            System.out.println("1. Display Employees");
            System.out.println("2. Search By Id");
            System.out.println("3. Increment Salary");
            System.out.println("4. Add Employee");
            System.out.println("5. Remove Employee");
            System.out.println("6. Exit");

            System.out.print("\nEnter your option: ");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.println("\nAll Employee Details:");
                    for(Employee e:emp){
                        System.out.println(e);
                        System.out.println("---------------------");
                    }
                    break;

                case 2:
                    System.out.println("\nSearching Employee >>>");
                    System.out.println("\nGive Employee Id:");
                    int id2 = sc.nextInt();
                    for(Employee e:emp){
                        if(e.searchEmployeeById(id2)){
                            System.out.println(e);
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nSalary Increment >>>");
                    System.out.println("\nGive Employee Id:");
                    int id3 = sc.nextInt();
                    System.out.println("\nGive Increment Percentage:");
                    int incperc = sc.nextInt();
                    for(Employee e:emp){
                        if(e.searchEmployeeById(id3)){
                            System.out.println("Employee Before Increment:");
                            System.out.println(e);
                            System.out.println("---------------------");
                            e.incrementSalary(incperc);
                            System.out.println("Employee After Increment:");
                            System.out.println(e);
                            System.out.println("---------------------");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Add Employee >>>");

                    System.out.println("New Employees's Employee Id:");
                    int id = sc.nextInt();
                    System.out.println("New Employees's Name:");
                    String name = sc.next();
                    System.out.println("New Employees's Designation:");
                    String designation = sc.next();
                    System.out.println("New Employees's Salary:");
                    double salary = sc.nextDouble();
                    System.out.println("Adding New Employee's Data...");
                    emp.add(new Employee(id,name,designation,salary));
                    System.out.println("New Employee Added.");
                    break;

                case 5:
                    System.out.println("Delete Employee >>>");
                    System.out.println("\nGive Employee Id:");
                    int id5 = sc.nextInt();
                    for(Employee e:emp) {
                        if(e.searchEmployeeById(id5)){
                            emp.remove(e);
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thank you!");
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid Option!");
            }

        } while (option != 6);
    }
}

