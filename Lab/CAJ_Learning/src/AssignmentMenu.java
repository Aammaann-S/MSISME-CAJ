import java.util.Scanner;

public class AssignmentMenu {

    private static int option;
    private static int[] array;
    private static Scanner sc = null;

    // Assignment Q0
    // Construct an Array of input in values
    public static int[] constructionArray(){

        System.out.println("Give Size of the Array :");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i<size ; i++){
            System.out.println("Give element at position "+(i+1)+": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("\nOriginal Array:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        return arr;
    }

    // Assignment Q1
    // Find duplicate values in an integer array
    public static void duplicateValue(int[] args) {

        System.out.println("\nDuplicate values:");

        boolean found = false;

        for (int i = 0; i < args.length; i++) {
            // Check if this value was already processed
            boolean alreadyChecked = false;
            for (int k = 0; k < i; k++) {
                if (args[i] == args[k]) {
                    alreadyChecked = true;
                    break;
                }
            }
            if (alreadyChecked) {
                continue;
            }

            int count = 0;
            // Count occurrences
            for (int j = 0; j < args.length; j++) {
                if (args[i] == args[j]) {
                    count++;
                }
            }

            // Display only duplicates
            if (count > 1) {
                System.out.println("Number " + args[i] + " has " + count + " Duplicates");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No duplicate values found.");
        }
    }

    // Assignment Q2
    // Find Kth Smallest & Largest after sorting an array
    public static void KthValue(int[] args) {
        // Sort Array
        for (int i = 0; i < args.length - 1; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i] > args[j]) {
                    int temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }

        System.out.println("\nSorted Array:");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }

        System.out.print("\nEnter value of K: ");
        int k = sc.nextInt();

        // K-Validatation
        if (k <= 0 || k > args.length) {
            System.out.println("Invalid K. K must be between 1 and " + args.length);
            return;
        }

        // Kth values
        System.out.println("\n" + k + "th Smallest = " + args[k - 1]);
        System.out.println(k + "th Largest = " + args[args.length - k]);
    }

    // Assignment Q3
    // Move negative numbers to the left and Move positive numbers to the right
    public static void moveNegativePositiveValues(int[] args) {

        int left = 0;
        int right = args.length - 1;

        while (left <= right) {

            if (args[left] < 0) {
                left++;
            }
            else if (args[right] >= 0) {
                right--;
            }
            else {
                int temp = args[left];
                args[left] = args[right];
                args[right] = temp;

                left++;
                right--;
            }
        }

        System.out.println("\nModified Array:");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
//        System.out.println();
    }

    // Assignment Q4
    // Question with 3 attempts
    public static void questionAnswer(Scanner sc) {

        String question = "What is the capital of India?";
        String correctAnswer = "Delhi";

        int attempts = 3;

        for (int i = 1; i <= attempts; i++) {
            System.out.print("\nAttempt " + i + " - " + question + "\n");
            String answer = sc.next();
            if (answer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("************************************************");
                System.out.println("Sahi javab aap jeet gaye hain\n 7 CROOOOORE !");
                System.out.println("************************************************");
                return;
            } else {

                System.out.println("Wrong Answer");
            }
        }
        System.out.println("Correct Answer: " + correctAnswer);
    }


    // Assignment Q5(a)
    // Floyd's Triangle
    public static void floydTriangle(int rows) {
        int number = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }

    // Assignment Q5(b)
    // Binary Floyd's Triangle
    public static void binaryFloydTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void mainApp(Scanner sc){

        // ------------------------- MENU -------------------------
        do {
            System.out.println("\nMENU >>>");
            System.out.println("1. Construct an Array and Find Duplicate Values");
            System.out.println("2. Find Kth Smallest & Largest");
            System.out.println("3. Move Negative & Positive");
            System.out.println("4. Question & Answer");
            System.out.println("5. Floyd's Triangle");
            System.out.println("6. Binary Floyd's Triangle");
            System.out.println("7. Exit");

            System.out.print("\nEnter your option: ");
            option = sc.nextInt();

            switch (option) {

                case 0:
                    System.out.println("\nArray Construction Selected: ");
                    int arr[] = constructionArray();
                    System.out.println("\nOriginal Array:");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    break;


                case 1:
                    System.out.println("\nChecking Duplicate values in Array: ");
                    int arr1[] = constructionArray();
                     duplicateValue(arr1);
                    break;

                case 2:
                    System.out.println("\nFinding Kth Values in an Array: ");
                    int arr2[] = constructionArray();
                    KthValue(arr2);
                    break;

                case 3:
                    System.out.println("\nMoving Negative & Positive Values:");
                    int arr3[] = constructionArray();
                    moveNegativePositiveValues(arr3);
                    break;

                case 4:
                    System.out.println("\nQuestion & Answer:");
                    questionAnswer(sc);
                    break;

                case 5:
                    System.out.print("Enter number of rows for Floyd Triangle: ");
                    int rows1 = sc.nextInt();
                    floydTriangle(rows1);
                    break;

                case 6:
                    System.out.print("Enter number of rows for Binary Floyd Triangle: ");
                    int rows2 = sc.nextInt();
                    binaryFloydTriangle(rows2);
                    break;

                case 7:
                    System.out.println("Thank you!");
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid Option!");
            }

        } while (option != 7);
    }

    public static void main(String[] args){

        String[] user = {"admin","user"};
        String[] password = {"abc","xyz"};

        sc = new Scanner(System.in);
        System.out.println("Enter Username and Password");

        System.out.print("Enter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String enteredPassword = sc.next();

        boolean checked = false;
        for (int i = 0; i < user.length; i++) {
            if (user[i].equals(username) && password[i].equals(enteredPassword)) {
                checked = true;
                break;
            }
        }

        if (!checked) {
            System.out.println("Invalid Username or Password");
            return;
        }

        System.out.println("Login Successful!");
        System.out.println("Welcome " + username);

        mainApp(sc);

        sc.close();

    }
}
