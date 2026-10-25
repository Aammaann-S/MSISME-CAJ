package Lab1;

import java.util.Arrays;
import java.util.Scanner;

// Q4: SortString
// Sample Inputs : "banana"
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // converts the string into a character array
        // "CAT" to ['C','A','T']
        char[] characters = input.toCharArray();
        Arrays.sort(characters);

        System.out.println("Alphabetical order: " + new String(characters));
        // String(characters) constructs a String from the characters in the array
        // ['C','A','T'] to "CAT"
        System.out.println("Length: " + input.length());

        // Length usage diff:
        // String.length() = give string length
        // Array.length = given no of elements in the array

        sc.close();
    }
}
