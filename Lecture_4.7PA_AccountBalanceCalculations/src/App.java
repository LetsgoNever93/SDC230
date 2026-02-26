/*
name: Angel Avila
Date: 2/20/2026
Assignment: SDC230 Performance Assessment - Account Balance Calculations
Description: Prompts for a starting balance, then repeatedly accepts credits/debits until 0 is entered.
Demonstrates InputMismatchException handling and a user-defined exception when a debit would cause a negative balance.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // Your idea: range check before applying the transaction
    public static boolean InRangeCheck(double transaction, double startingBalance) throws NumberOutOfRangeException {
        if (startingBalance + transaction < 0) {
            throw new NumberOutOfRangeException(
                "Transaction denied. This debit would cause a negative balance."
            );
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Angel Avila - Week4 PA Account Balance Calculations");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        double startingBalance = 0.0;

        // Starting balance input (handle non-numeric)
        while (true) {
            try {
                System.out.print("Enter starting balance: ");
                startingBalance = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Exception: " + e);
                System.out.println("Error: Input must be a number.");
                scanner.nextLine(); // clear bad input
                System.out.println();
            }
        }

        System.out.printf("%nThe current balance is: %.2f%n", startingBalance);

        // Main loop: keep asking for transactions until user enters 0
        while (true) {
            System.out.printf("%nThe current balance is: %.2f%n", startingBalance);
            System.out.print("Enter a credit (+) or debit (-)[Enter zero to quit]: ");

            try {
                double dVal = scanner.nextDouble();

                // Quit condition
                if (dVal == 0) {
                    break;
                }

                // Range check (throws user-defined exception if it would go negative)
                InRangeCheck(dVal, startingBalance);

                // If valid, apply and show updated balance
                startingBalance += dVal;
                System.out.printf("Update Successful! New Balance: $%.2f%n", startingBalance);

            } catch (InputMismatchException e) {
                System.out.println("Exception: " + e);
                System.out.println("Error: Input must be a number.");
                scanner.nextLine(); // clear bad input

            } catch (NumberOutOfRangeException e) {
                System.out.println("Exception: " + e);
            }
        }

        System.out.printf("Final Balance: $%.2f. Program exited.%n", startingBalance);
        scanner.close();
    }
}