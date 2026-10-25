package Lab2;

import java.util.Arrays;
import java.util.Scanner;

// Q8: KthElements
public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Array size must be positive.");
            sc.close();
            return;
        }

        int[] numbers = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        if (k < 1 || k > n) {
            System.out.println("Invalid k. Enter a value from 1 to " + n);
            sc.close();
            return;
        }

        Arrays.sort(numbers);

        System.out.println("Sorted array: " + Arrays.toString(numbers));
        System.out.println("Kth smallest: " + numbers[k - 1]);
        System.out.println("Kth largest: " + numbers[n - k]);

        sc.close();
    }
}
