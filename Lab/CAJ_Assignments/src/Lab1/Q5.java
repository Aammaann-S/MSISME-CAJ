package Lab1;

import java.util.Scanner;

// Q5: Palindrome
// Sample Inputs : "banana"
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String original = input.replaceAll("\\s+", "").toLowerCase();
        //  replaceAll Removes spaces: replaces all \\s (= white spaces) with ""(no space)
        System.out.println(original);

        String reversed = new StringBuilder(original).reverse().toString();
        // StringBuilder creates a mutable sequence of characters. Here, it starts with the value of original.


        if (original.equals(reversed)) {
            // equals checks the content value
            // == check iif pointing to same obj
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("It is not a palindrome.");
        }

        sc.close();
    }
}
