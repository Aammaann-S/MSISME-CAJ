package Lab4;

import java.util.Scanner;

//Q16: Stack
public class Q16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();

        int choice;

        do {
            System.out.println("\n===== STACK MENU =====");
            System.out.println("1. Create New Stack");
            System.out.println("2. Push");
            System.out.println("3. Pop");
            System.out.println("4. Display");
            System.out.println("5. Check Empty");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    stack.createNew(sc);
                    break;

                case 2:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;

                case 3:
                    stack.pop();
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    if (stack.empty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you!");
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
