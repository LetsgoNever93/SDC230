/*
Name: Angel Avila
Date: 2/13/2026
Assignment Project 1.5 User Interactions and I/O
*/

import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Angel Avila - Week 1 - 1.5 Project: User Interactions and I/O");
        System.out.println();
        System.out.println("URC: Unit Readiness  Calculator ");
        System.out.println("Tactical Decision Support System");
        System.out.println("Instructions: Enter the number of sit-ups and push-ups you can do in 2 minutes. ");
        System.out.println("This will calculate your first score. Then enter total miles and target miles in 20 minutes for your second score.");

        Scanner input = new Scanner(System.in);

    //user inputs two integers
        System.out.println("Enter the number of sit-ups:  ");
        int situps = input.nextInt();
        System.out.println("Enter the number of push-ups:  ");
        int pushups = input.nextInt();
        int scoreOne = situps + pushups;
        System.out.printf("Here is your first score: %d", scoreOne);
        System.out.println();

        //user inputs two floating points
        System.out.println("Enter the number of miles (in decimal form) ran in 20 minutes:  ");
        double totalMiles = input.nextDouble();
        System.out.println("Enter the number of miles (in decimal form) you are targeting in 20 minutes:  ");
        double targetMiles = input.nextDouble();
        double scoreTwo = totalMiles - targetMiles;
        System.out.printf("Here is your second score: %.2f%n", scoreTwo);
        System.out.println("Thank you for using my fitness calculator!");








    } 
}
