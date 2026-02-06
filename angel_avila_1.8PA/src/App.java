/*
Name: Angel Avila
Date: 1/31/2026
SDC230 Performance Assessment - IO & Operators
*/

import java.util. Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Angel Avila - Week 1 PA IO & Operators");
        Scanner input = new Scanner(System.in);
    
        //Here is a blank space
        System.out.println();
        
        //Intergers
        //User is prompted for valueOne
        System.out.println("Enter an integer value: ");
        int valueOne = input.nextInt();

        //User is prompted for valueTwo
        System.out.println("Enter a second integer value: ");
        int valueTwo = input.nextInt();

        //Addition
        int sum = valueOne + valueTwo;
        //Display addition
        System.out.printf("The sum of %d and %d is %d.%n", valueOne, valueTwo, sum);

        //Equal or not equal
        if( valueOne == valueTwo){
            System.out.printf("%d is equal to %d.%n", valueOne, valueTwo);
        } else if( valueOne != valueTwo) {
            System.out.printf("%d is not equal to %d.%n", valueOne, valueTwo);
        }

        
        //Is greater than or less than
        if( valueOne > valueTwo){
            System.out.printf("%d is greater than %d.%n", valueOne, valueTwo);
        } else if( valueOne < valueTwo){
            System.out.printf("%d is less than %d.%n", valueOne, valueTwo);
        }
        //Is less than or equal to || Is greater than or equal to
        if( valueOne <= valueTwo){
            System.out.printf("%d is less than or equal to %d.%n", valueOne, valueTwo);
        } else if( valueOne >= valueTwo){
            System.out.printf("%d is greater than or equal to %d.%n", valueOne, valueTwo);
        }
        //Here is a blank space
        System.out.println();

        //***************************************************************************************** */

        //Floating Points
        //User is prompted for floating point valueOne
        System.out.println("Enter a floating point value: ");
        double fltVal1 = input.nextDouble(); //fltVal1 and fltVal2

        //User is prompted for floating point valueTwo
        System.out.println("Enter a second floating point value: ");
        double fltVal2 = input.nextDouble();

        //sum total calculation
        double total = fltVal1 + fltVal2;
        
        //display sum total calculation
        System.out.printf("The sum of %.4f and %.4f is %.4f.%n", fltVal1, fltVal2, total);

        //Equality: equal or not equal
        if( fltVal1 == fltVal2){
            System.out.printf("%.4f is not equal to %.4f.%n", fltVal1, fltVal2);
        } else if(fltVal1 != fltVal2) {
            System.out.printf("%.4f is not equal to %.4f.%n", fltVal1, fltVal2);
        }
        //Is greater than
        if( fltVal1 > fltVal2){
            System.out.printf("%.4f is greater than %.4f.%n", fltVal1, fltVal2);
        }
        //Is greater than or equal
        if( fltVal1 >= fltVal2){
            System.out.printf("%.4f is greater than or equal to %.4f.%n", fltVal1, fltVal2);
        }
        input.close();


    }
}
