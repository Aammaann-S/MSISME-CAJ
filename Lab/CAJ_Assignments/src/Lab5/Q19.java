package Lab5;

//Q19: Test
public class Q19 {
    public static void main(String[] args) {

        Calculator c = BasicCalculator.getInstance();

        System.out.println(" > TEST PUT AND READ < ");
        c.put(10);
        System.out.println("Expected: 10, Actual: " + c.read());


        System.out.println("\n > TEST NEGATION < ");
        c.clearAll();
        c.put(10).neg();
        System.out.println("Expected: -10, Actual: " + c.read());


        System.out.println("\n > TEST ADDITION < ");
        c.clearAll();
        c.put(10).put(5).add();
        System.out.println("Expected: 15, Actual: " + c.read());


        System.out.println("\n > TEST SUBTRACTION < ");
        c.clearAll();
        c.put(10).put(5).sub();
        System.out.println("Expected: 5, Actual: " + c.read());


        System.out.println("\n > TEST MULTIPLICATION < ");
        c.clearAll();
        c.put(10).put(5).mul();
        System.out.println("Expected: 50, Actual: " + c.read());


        System.out.println("\n > TEST DIVISION < ");
        c.clearAll();
        c.put(20).put(4).div();
        System.out.println("Expected: 5, Actual: " + c.read());


        System.out.println("\n > TEST CLEAR < ");
        c.clearAll();
        c.put(10).put(20);
        c.clear();
        System.out.println("Expected: 10, Actual: " + c.read());


        System.out.println("\n > TEST CLEAR ALL < ");
        c.clearAll();

        try {
            c.read();
        } catch (IllegalStateException e) {
            System.out.println("Expected empty calculator: " + e.getMessage());
        }


        System.out.println("\n > TEST METHOD CHAINING < ");
        c.put(8).put(2).mul().put(4).add();
        System.out.println("Expected: 20, Actual: " + c.read());


        System.out.println("\n > TEST DIVISION BY ZERO < ");
        c.clearAll();
        c.put(10).put(0);

        try {
            c.div();
        } catch (ArithmeticException e) {
            System.out.println("Handled correctly: " + e.getMessage());
        }

        System.out.println("Stack preserved: " + (c.read() == 0));

        System.out.println("\n > ALL TESTS COMPLETED < ");
    }
}

