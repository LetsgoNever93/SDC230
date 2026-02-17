/*
Name: Angel Avila
Date: 2/10/2026
Assignment SDC230 Performance Assessment - Smallest number
We will be going over loop structures to find the smallest number of the inputed set.
*/
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Angel Avila - Week 2 PA Smallest Number");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("Finding the Smallest Value: ");
        System.out.println("How many integers will you enter: ");
        int count = input.nextInt();
        int smallest = 0;
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter an integer value: ");
            int inVal = input.nextInt();

            if (i == 1) {
                smallest = inVal;
            }

            else {
                if (inVal < smallest) {
                    smallest = inVal;
                }
            }
        }
        
        System.out.println("The smallest value entered is: " + smallest);
        input.close();

    }
}
