/*
Name: Angel Avila
Date: 2/26/2026
Assignment: SDC230 Performance Assessment - Calculations & Unique Numbers
Description:
This program collects 10 integers from the user into an array, stores unique values
in an ArrayList, and displays the count, sum, and average for both collections.
It demonstrates arrays, ArrayLists, method overloading, and basic calculations.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Required header line (take screenshot of this step)
        System.out.println("Angel Avila - Week 3 PA Calculations & Unique Numbers");
        System.out.println();

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[10];
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();

        // Get 10 integer values from the user
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Please enter an integer value: ");
            int value = input.nextInt();

            numbers[i] = value;

            // Store unique values in ArrayList using contains()
            if (!uniqueNumbers.contains(value)) {
                uniqueNumbers.add(value);
            }
        }

        System.out.println();

        // Display results for the array (take screenshot of this step)
        int arrayCount = numbers.length;
        int arraySum = sum(numbers);
        int arrayAvg = arraySum / arrayCount; // int average to match sample output style

        System.out.println("The count of integers entered is: " + arrayCount);
        System.out.println("The sum of integers entered is: " + arraySum);
        System.out.println("The average of integers entered is: " + arrayAvg);
        System.out.println();

        // Display results for the ArrayList (unique)
        int uniqueCount = uniqueNumbers.size();
        int uniqueSum = sum(uniqueNumbers);
        int uniqueAvg = uniqueSum / uniqueCount; // safe because at least 1 unique if 10 inputs

        System.out.println("The count of unique integers entered is: " + uniqueCount);
        System.out.println("The sum of unique integers entered is: " + uniqueSum);
        System.out.println("The average of unique integers entered is: " + uniqueAvg);

        input.close();
    }

    // Method to calculate the sum of integers in an array
    public static int sum(int[] values) {
        int total = 0;
        for (int v : values) {
            total += v;
        }
        return total;
    }

    // Overloaded method to calculate the sum of integers in an ArrayList
    public static int sum(ArrayList<Integer> values) {
        int total = 0;
        for (int v : values) {
            total += v;
        }
        return total;
    }
}