package Lab1;

// Q2: PrintArguments
// Sample Inputs : "Aman Java CAJ"
public class Q2 {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide 3 arguments.");
            return;
        }
        System.out.println("Argument 1: " + args[0]);
        System.out.println("Argument 2: " + args[1]);
        System.out.println("Argument 3: " + args[2]);
    }
}
