package Lab6;

import java.io.*;
import java.util.Scanner;

//Q20: SIS
public class Q20 {

    private static BufferedReader br = null;
    private static BufferedReader brl = null;
    private static BufferedWriter bwl = null;
    private static Scanner sc = new Scanner(System.in);
    private static int choice;

    public static void initStream(){
        try {
            br = new BufferedReader(new FileReader("D:\\Storage\\Projects\\MSIS\\CAJ\\MSISME-CAJ\\Lab\\CAJ_Assignments\\src\\Lab6\\login.txt"));
            brl = new BufferedReader(new FileReader("D:\\Storage\\Projects\\MSIS\\CAJ\\MSISME-CAJ\\Lab\\CAJ_Assignments\\src\\Lab6\\students_details.txt"));
            bwl = new BufferedWriter(new FileWriter("D:\\Storage\\Projects\\MSIS\\CAJ\\MSISME-CAJ\\Lab\\CAJ_Assignments\\src\\Lab6\\students_details.txt",true));
        }
        catch (FileNotFoundException e){
            // throw new RuntimeException(e);
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static boolean authenticate(){
        System.out.println("Enter Username");
        String user = sc.next();
        System.out.println("Enter Password");
        String password = sc.next();

        try {
            String credentials = br.readLine();
            while(credentials!=null){
                String[] profile = credentials.split(" ");
                if(profile[0].equals(user) && profile[1].equals(password)){
                    return true;
                }
                credentials = br.readLine();
            }
        }
        catch (IOException e){
            System.out.println(e);
        }

        return false;

    }

    public static void displayRecord() {
        try {
            BufferedReader tempReader = new BufferedReader(
                    new FileReader(
                            "D:\\Storage\\Projects\\MSIS\\CAJ\\MSISME-CAJ\\Lab\\CAJ_Assignments\\src\\Lab6\\students_details.txt"
                    )
            );

            String student;
            boolean found = false;

            System.out.println("\nStudent Records:");

            while ((student = tempReader.readLine()) != null) {
                if (!student.trim().isEmpty()) {
                    String[] profile = student.split(" ");

                    if (profile.length >= 3) {
                        System.out.println("Registration Number: " + profile[0]);
                        System.out.println("Name: " + profile[1]);
                        System.out.println("Place: " + profile[2]);
                        System.out.println("----------------------");
                        found = true;
                    }
                }
            }

            tempReader.close();

            if (!found) {
                System.out.println("No Records Found.");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void insertRecord(){
        System.out.println("Enter Registration Number");
        String regno = sc.next();
        System.out.println("Enter Name");
        String name = sc.next();
        System.out.println("Enter Place");
        String place = sc.next();

        String insertRecord = regno + " " + name + " " + place;

        try {
            bwl.write(insertRecord);
            bwl.newLine();
            bwl.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

//    public static void updateRecord(){
//        System.out.println("Enter Registration Number Update");
//        String upregno = sc.next();
//        System.out.println("Enter new Name");
//        String newname = sc.next();
//        System.out.println("Enter new Place");
//        String newplace = sc.next();
//        String updatedRecord = upregno + " " + newname + " " + newplace;
//
//        try {
//            String student = brl.readLine();
//            while(student!=null){
//                String[] profile = student.split(" ");
//                if(profile[0].equals(upregno)){
//                    bwl.write(updatedRecord);
//                    bwl.newLine();
//                    bwl.flush();
//                    break;
//                }
//                student = br.readLine();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    public static void updateRecord() {
        System.out.println("Enter Registration Number Update");
        String upregno = sc.next();

        System.out.println("Enter new Name");
        String newname = sc.next();

        System.out.println("Enter new Place");
        String newplace = sc.next();

        String updatedRecord = upregno + " " + newname + " " + newplace;

        try {
            File file = new File(
                    "D:\\Storage\\Projects\\MSIS\\CAJ\\MSISME-CAJ\\Lab\\CAJ_Assignments\\src\\Lab6\\students_details.txt"
            );

            BufferedReader tempReader =
                    new BufferedReader(new FileReader(file));

            StringBuilder data = new StringBuilder();
            String student;
            boolean found = false;

            while ((student = tempReader.readLine()) != null) {
                String[] profile = student.split(" ");

                if (profile[0].equals(upregno)) {
                    data.append(updatedRecord);
                    found = true;
                } else {
                    data.append(student);
                }

                data.append(System.lineSeparator());
            }

            tempReader.close();

            if (!found) {
                System.out.println("Record Not Found.");
                return;
            }

            BufferedWriter tempWriter =
                    new BufferedWriter(new FileWriter(file));

            tempWriter.write(data.toString());
            tempWriter.close();

            System.out.println("Record Updated Successfully.");

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void deleteRecord() {
        System.out.println("Enter Registration Number to Delete");
        String regno = sc.next();

        try {
            File file = new File(
                    "D:\\Storage\\Projects\\MSIS\\CAJ\\MSISME-CAJ\\Lab\\CAJ_Assignments\\src\\Lab6\\students_details.txt"
            );

            BufferedReader tempReader =
                    new BufferedReader(new FileReader(file));

            StringBuilder data = new StringBuilder();
            String student;
            boolean found = false;

            while ((student = tempReader.readLine()) != null) {
                String[] profile = student.split(" ");

                if (profile[0].equals(regno)) {
                    found = true;
                    continue;
                }

                data.append(student);
                data.append(System.lineSeparator());
            }

            tempReader.close();

            BufferedWriter tempWriter =
                    new BufferedWriter(new FileWriter(file));

            tempWriter.write(data.toString());
            tempWriter.close();

            if (found) {
                System.out.println("Record Deleted Successfully.");
            } else {
                System.out.println("Record Not Found.");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void closeStream(){

        try {
            if(br != null){
                br.close();
            }
            if(brl != null){
                brl.close();
            }
            if(bwl != null){
                bwl.close();
            }
            if(sc != null){
                sc.close();
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        initStream();
        if(authenticate()){
            System.out.println("Valid User.");
            do {
                System.out.println("\nMENU >>>");
                System.out.println("1. Display Records");
                System.out.println("2. Insert Record");
                System.out.println("3. Update Record");
                System.out.println("4. Delete Record");
                System.out.println("5. Exit");

                System.out.print("\nEnter your option: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        displayRecord();
                        break;
                    case 2:
                        insertRecord();
                        break;
                    case 3:
                        updateRecord();
                        break;
                    case 4:
                        deleteRecord();
                        break;
                    case 5:
                        System.out.println("Thank you!");
                        System.out.println("Logging out...");
                        break;

                    default:
                        System.out.println("Invalid Option!");
                }
            } while (choice != 5);
        }
        else {
            System.out.println("Invalid User!");
        }
        System.out.println("------------- CLOSE APP -----------");
        closeStream();

    }
}