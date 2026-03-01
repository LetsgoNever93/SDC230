/*
Name: Angel Avila
Date: 2/28/2026
Assignment SDC230L - Week 4 - Shunting-Yard & Exception Handling
*/

import java.util.EmptyStackException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("Angel Avila - Week 4 Project ");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Menu Calculator Project");
        System.out.println("-----------------------------------------------------------");

        Scanner input = new Scanner(System.in);
        menu calculator = new menu();

        int choice = 0;

        while (choice != 7) {
            System.out.println("\n--- Calculator Menu ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Postfix Evaluator");
            System.out.println("6. Infix Expression Solver");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");

            // Guard against non-integer menu entries
            if (!input.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number 1-7.");
                input.nextLine();
                continue;
            }

            choice = input.nextInt();
            input.nextLine(); // consume newline

            // Options 1–4: basic arithmetic
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

                try {
                    double result;
                    if (choice == 1) {
                        result = calculator.add(num1, num2);
                    } else if (choice == 2) {
                        result = calculator.subtract(num1, num2);
                    } else if (choice == 3) {
                        result = calculator.multiply(num1, num2);
                    } else {
                        result = calculator.divide(num1, num2); // may throw ArithmeticException
                    }
                    System.out.printf("Result: %.2f%n", result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }
            // Option 5: Postfix Evaluator (now with exceptions)
            else if (choice == 5) {
                System.out.print("Enter space-separated Postfix expression: ");
                String expr = input.nextLine();

                try {
                    double result = calculator.evaluatePostfix(expr);
                    System.out.printf("Final Result: %.2f%n", result);
                } catch (EmptyStackException e) {
                    System.out.println("Error: Malformed postfix expression (too many operators).");
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }
            // Option 6: Infix Solver (PIPELINE: infix -> postfix -> evaluate)
            else if (choice == 6) {
                System.out.print("Enter space-separated Infix expression: ");
                String infix = input.nextLine();

                try {
                    System.out.println("\nStep 1: Converting to Postfix...");
                    String postfix = calculator.convertToPostfix(infix);
                    System.out.println("Result: " + postfix);

                    System.out.println("Step 2: Evaluating...");
                    double result = calculator.evaluatePostfix(postfix);
                    System.out.printf("Final Result: %.2f%n", result);

                } catch (EmptyStackException e) {
                    System.out.println("Error: Malformed expression (too many operators / not enough operands).");
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }
            // Quit
            else if (choice == 7) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Please select 1-7.");
            }
        }

        input.close();
    }
}