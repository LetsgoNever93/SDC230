/*
Name: Angel Avila
Date: 2/13/2026
Project 2.3 - Software Design and Control Statements 

*/
public class menu {

    // Add
    public double add(double a, double b) {
        return a + b;
    }

    // Subtract
    public double subtract(double a, double b) {
        return a - b;
    }

    // Multiply
    public double multiply(double a, double b) {
        return a * b;
    }

    // Divide
    public double divide(double a, double b) {

        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }

        return a / b;
    }
}

