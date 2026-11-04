package Submissions.Assignment2;

import java.sql.Date;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CollegeDAO dao = new CollegeDAO();

        int choice;

        do {
            System.out.println("\n========== COLLEGE EXAMINATION AND RESULT MANAGEMENT ==========");
            System.out.println("1.  Add Student");
            System.out.println("2.  Update Student");
            System.out.println("3.  Add Subject");
            System.out.println("4.  Update Subject");
            System.out.println("5.  Add Examination");
            System.out.println("6.  Update Examination");
            System.out.println("7.  Enter / Update Student Marks");
            System.out.println("8.  Calculate Subject-wise Average Marks");
            System.out.println("9.  Find Highest-scoring Students");
            System.out.println("10. Display Table Contents");
            System.out.println("11. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- ADD STUDENT ---");

                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();

                    System.out.print("Enter Student Name: ");
                    String sname = sc.next();

                    System.out.print("Enter Program: ");
                    String program = sc.next();

                    System.out.print("Enter Semester: ");
                    int semester = sc.nextInt();

                    System.out.print("Enter Email: ");
                    String email = sc.next();

                    dao.AddStudentRecord(sid, sname, program, semester, email);
                    break;

                case 2:
                    System.out.println("\n--- UPDATE STUDENT ---");

                    System.out.print("Enter Student ID: ");
                    sid = sc.nextInt();

                    System.out.print("Enter New Name: ");
                    sname = sc.next();

                    System.out.print("Enter New Program: ");
                    program = sc.next();

                    System.out.print("Enter New Semester: ");
                    semester = sc.nextInt();

                    System.out.print("Enter New Email: ");
                    email = sc.next();

                    dao.UpdateStudentRecord(sid, sname, program, semester, email);
                    break;

                case 3:
                    System.out.println("\n--- ADD SUBJECT ---");

                    System.out.print("Enter Subject ID: ");
                    int subjectID = sc.nextInt();

                    System.out.print("Enter Subject Name: ");
                    String subjectName = sc.next();

                    System.out.print("Enter Credits: ");
                    int credits = sc.nextInt();

                    System.out.print("Enter Semester: ");
                    semester = sc.nextInt();

                    dao.AddSubjectRecord(subjectID, subjectName, credits, semester);
                    break;

                case 4:
                    System.out.println("\n--- UPDATE SUBJECT ---");

                    System.out.print("Enter Subject ID: ");
                    subjectID = sc.nextInt();

                    System.out.print("Enter New Subject Name: ");
                    subjectName = sc.next();

                    System.out.print("Enter New Credits: ");
                    credits = sc.nextInt();

                    System.out.print("Enter New Semester: ");
                    semester = sc.nextInt();

                    dao.UpdateSubjectRecord(subjectID, subjectName, credits, semester);
                    break;

                case 5:
                    System.out.println("\n--- ADD EXAMINATION ---");

                    System.out.print("Enter Exam ID: ");
                    int examID = sc.nextInt();

                    System.out.print("Enter Subject ID: ");
                    subjectID = sc.nextInt();

                    System.out.print("Enter Exam Date (yyyy-mm-dd): ");
                    Date examDate = Date.valueOf(sc.next());

                    System.out.print("Enter Maximum Marks: ");
                    int maxMarks = sc.nextInt();

                    dao.AddExaminationRecord(examID, subjectID, examDate, maxMarks);
                    break;

                case 6:
                    System.out.println("\n--- UPDATE EXAMINATION ---");

                    System.out.print("Enter Exam ID: ");
                    examID = sc.nextInt();

                    System.out.print("Enter New Subject ID: ");
                    subjectID = sc.nextInt();

                    System.out.print("Enter New Exam Date (yyyy-mm-dd): ");
                    examDate = Date.valueOf(sc.next());

                    System.out.print("Enter New Maximum Marks: ");
                    maxMarks = sc.nextInt();

                    dao.UpdateExaminationRecord(examID, subjectID, examDate, maxMarks);
                    break;

                case 7:
                    System.out.println("\n--- ENTER / UPDATE STUDENT MARKS ---");

                    System.out.print("Enter Student ID: ");
                    sid = sc.nextInt();

                    System.out.print("Enter Exam ID: ");
                    examID = sc.nextInt();

                    System.out.print("Enter Marks Obtained: ");
                    int marks = sc.nextInt();

                    System.out.print("Enter Grade: ");
                    String grade = sc.next();

                    dao.EnterUpdateStudentMarks(sid, examID, marks, grade);
                    break;

                case 8:
                    dao.calculateSubjectAverage();
                    break;

                case 9:
                    dao.findHighestScoringStudents();
                    break;

                case 10:
                    System.out.println("\n========== DISPLAY TABLE CONTENTS ==========");
                    System.out.println("1. Display Student Table");
                    System.out.println("2. Display Subject Table");
                    System.out.println("3. Display Examination Table");
                    System.out.println("4. Display Result Table");

                    System.out.print("\nEnter your choice: ");
                    int tableChoice = sc.nextInt();

                    switch (tableChoice) {
                        case 1:
                            dao.DisplayTable("Student");
                            break;

                        case 2:
                            dao.DisplayTable("Subject");
                            break;

                        case 3:
                            dao.DisplayTable("Examination");
                            break;

                        case 4:
                            dao.DisplayTable("Result");
                            break;

                        default:
                            System.out.println("Invalid Table Choice!");
                    }

                    break;

                case 11:
                    System.out.println("Exiting Application...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 11);

        sc.close();
    }
}
