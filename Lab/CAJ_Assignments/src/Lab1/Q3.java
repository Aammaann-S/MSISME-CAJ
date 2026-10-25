package Lab1;

// Q3: SumArguments
// Sample Inputs : "10 20 30"
// Inputs come as string (even if numbers)
public class Q3 {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide 3 numbers.");
            return;
        }

        try {
            // Converts to double
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);

            // Calculate sum before concatenation
            System.out.println("Sum = " + (a + b + c));
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers.");
        }
    }
}


