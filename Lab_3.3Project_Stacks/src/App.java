/*
Name: Angel Avila
Date: 2/26/2026
Project 3.3 - Stacks (Week 3: Postfix Integration)

This application is a menu-driven calculator.
Options 1–4 perform basic infix arithmetic.
Option 5 evaluates a space-separated postfix expression using a Stack.
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Angel Avila - Week 3 - Project");
        System.out.println("-----------------------------------------------------------");
        System.out.println("This calculator executes simple logical operators with an");
        System.out.println("added feature 'Postfix Evaluator' ");
        System.out.println("Instructions: Select an option 1-6.");
        System.out.println("-----------------------------------------------------------");

        Scanner input = new Scanner(System.in);
        menu calculator = new menu();

        int choice = 0;

        while (choice != 6) {
            System.out.println("\n--- Simple Calculator ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Postfix Evaluator");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            // Guard against non-integer menu entries
            if (!input.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number 1-6.");
                input.nextLine(); // clear bad input
                continue;
            }

            choice = input.nextInt();
            input.nextLine(); // consume newline left behind by nextInt()

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                if (!input.hasNextDouble()) {
                    System.out.println("Invalid number. Try again.");
                    input.nextLine();
                    continue;
                }
                double num1 = input.nextDouble();

                System.out.print("Enter second number: ");
                if (!input.hasNextDouble()) {
                    System.out.println("Invalid number. Try again.");
                    input.nextLine();
                    continue;
                }
                double num2 = input.nextDouble();
                input.nextLine(); // consume newline

                if (choice == 1) {
                    System.out.println("Result: " + calculator.add(num1, num2));
                } else if (choice == 2) {
                    System.out.println("Result: " + calculator.subtract(num1, num2));
                } else if (choice == 3) {
                    System.out.println("Result: " + calculator.multiply(num1, num2));
                } else { // choice == 4
                    System.out.println("Result: " + calculator.divide(num1, num2));
                }

            } else if (choice == 5) {
                System.out.print("Enter space-separated Postfix expression: ");
                String expr = input.nextLine();

                double result = calculator.evaluatePostfix(expr);

                // If result is NaN, the evaluator already printed a specific error
                if (!Double.isNaN(result)) {
                    System.out.printf("Final Result: %.2f%n", result);
                }

            } else if (choice == 6) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Please select 1-6.");
            }
        }

        input.close();
    }
}