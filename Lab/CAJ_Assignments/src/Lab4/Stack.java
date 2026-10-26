package Lab4;

import java.util.Scanner;

public class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    public Stack() {
        arr = new int[0];
        top = -1;
        capacity = 0;
    }

    // Create a new empty stack
    public void createNew(Scanner sc) {

        System.out.print("Enter stack capacity: ");
        capacity = sc.nextInt();

        if (capacity <= 0) {
            System.out.println("Capacity must be positive.");
            arr = new int[0];
            top = -1;
            capacity = 0;
            return;
        }

        arr = new int[capacity];
        top = -1;

        System.out.println("New stack created.");
    }

    // Push an element onto the stack
    public void push(int value) {
        if (capacity == 0) {
            System.out.println("Create a stack first.");
            return;
        }

        if (top == capacity - 1) {
            System.out.println("Stack Overflow!");
            return;
        }

        arr[++top] = value;
        System.out.println(value + " pushed into stack.");
    }

    // Pop the top element
    public void pop() {
        if (capacity == 0) {
            System.out.println("Create a stack first.");
            return;
        }
        if (empty()) {
            System.out.println("Stack Underflow! Stack is empty.");
            return;
        }

        System.out.println("Popped element: " + arr[top]);
        top--;
    }

    // Display elements from top to bottom
    public void display() {
        if (capacity == 0) {
            System.out.println("Create a stack first.");
            return;
        }
        if (empty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack elements (top to bottom):");

        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    // Check whether stack is empty
    public boolean empty() {
        return top == -1;
    }
}

