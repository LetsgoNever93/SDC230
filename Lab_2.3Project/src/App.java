/*
Name: Angel Avila
Date: 2/13/2026
Project 2.3 - Software Design and Control Statements 

*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("===========================================================");
        System.out.println("Project Week 2: Java Arithmetic Project - Angel Avila");
        System.out.println("===========================================================");
        System.out.println("Welcome: This application performs basic math with logic guards.");
        System.out.println("Instructions: Select an option 1-5.");
        System.out.println("--Main Menu---");


        Scanner input = new Scanner(System.in);
        menu calculator = new menu();

        int choice = 0;

        while (choice != 6) {

            System.out.println("\n=== Simple Calculator ===");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Subtract");
            System.out.println("5. Divide");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            if (choice >= 1 && choice <= 5) {

                System.out.print("Enter first number: ");
                double num1 = input.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = input.nextDouble();

                if (choice == 1) {
                    System.out.println("Result: " + calculator.add(num1, num2));
                }
                else if (choice == 2) {
                    System.out.println("Result: " + calculator.subtract(num1, num2));
                }
                else if (choice == 3) {
                    System.out.println("Result: " + calculator.multiply(num1, num2));
                }
                else if (choice == 4) {
                    System.out.println("Result: " + calculator.subtract(num1, num2));
                }
                else if (choice == 5) {
                    System.out.println("Result: " + calculator.divide(num1, num2));
                }

            } else if (choice == 6) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid.");
            }
        }

        input.close();
    }
}
