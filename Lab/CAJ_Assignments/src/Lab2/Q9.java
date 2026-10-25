package Lab2;

//Q9: RearrangeNumbers
public class Q9 {
    public static void main(String[] args) {
        int[] numbers = {12, -7, 5, -3, 9, -1, 4};

        int j = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                j++;
            }
        }

        System.out.println("\nModified Array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}

