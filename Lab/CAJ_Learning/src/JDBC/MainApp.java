package JDBC;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistrationDAO dao = new RegistrationDAO();

        int choice;

        do {
            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Register Student for Course");
            System.out.println("4. Cancel Registration");
            System.out.println("5. View Students");
            System.out.println("6. View Courses");
            System.out.println("7. View Registrations (JOIN)");
            System.out.println("8. View Activity Log");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    dao.saveStudent(studentId, name, email, phone);
                    break;

                case 2:
                    System.out.print("Enter Course ID: ");
                    int courseId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = sc.nextLine();

                    System.out.print("Enter Credits (1-6): ");
                    int credits = sc.nextInt();

                    System.out.print("Enter Capacity: ");
                    int capacity = sc.nextInt();

                    dao.addCourse(courseId, courseName, credits, capacity);
                    break;

                case 3:
                    System.out.print("Enter Registration ID: ");
                    int registrationId = sc.nextInt();

                    System.out.print("Enter Student ID: ");
                    int registerStudentId = sc.nextInt();

                    System.out.print("Enter Course ID: ");
                    int registerCourseId = sc.nextInt();

                    dao.registerStudent(
                            registrationId,
                            registerStudentId,
                            registerCourseId
                    );
                    break;

                case 4:
                    System.out.print("Enter Registration ID to cancel: ");
                    int cancelId = sc.nextInt();

                    dao.cancelRegistration(cancelId);
                    break;

                case 5:
                    dao.viewStudents();
                    break;

                case 6:
                    dao.viewCourses();
                    break;

                case 7:
                    dao.viewRegistrations();
                    break;

                case 8:
                    dao.viewActivityLog();
                    break;

                case 9:
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 9);

        sc.close();
    }
}
