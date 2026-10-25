package Lab2;

import java.util.Scanner;
//Q10: QuizProgram
public class Q10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String question = "What is the capital of India?";
        String correctAnswer = "Delhi";

        int attempts = 3;

        for (int i = 1; i <= attempts; i++) {
            System.out.print("\nAttempt " + i + " - " + question + "\n");
            String answer = sc.next();
            if (answer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Your Answer is Correct !");
                return;
            } else {
                System.out.println("Wrong Answer");
            }
        }
        System.out.println("Correct Answer: " + correctAnswer);

        sc.close();
    }
}

