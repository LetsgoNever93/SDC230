/*
Name: Angel Avila
Date: 2/26/2026
Project 3.3 - Stacks Week 3: Postfix Integration
This class contains calculator operations and a postfix evaluator.
*/

import java.util.Stack;
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

    // Divide (logic guard: no division by zero)
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero bro!");
            return Double.NaN;
        }
        return a / b;
    }

    /*
      evaluatePostfix
      Input: a space-separated postfix string (example: "10 5 + 2 *")
      Output: final evaluated result, or NaN if malformed.
     */
    public double evaluatePostfix(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            System.out.println("Error: Empty expression.");
            return Double.NaN;
        }

        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.trim().split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].trim();

            // If there are extra spaces, skip empty tokens safely
            if (token.isEmpty()) {
                continue;
            }

            // 1) If token is a number, push it
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            }
            // 2) If token is an operator, pop two operands and apply
            else if (isOperator(token)) {

                // Guard: need at least 2 numbers on stack
                if (stack.size() < 2) {
                    System.out.println("Error: Malformed Expression (Insufficient operands).");
                    return Double.NaN;
                }

                double y = stack.pop(); // second operand
                double x = stack.pop(); // first operand
                double result;

                if (token.equals("+")) {
                    result = x + y;
                } else if (token.equals("-")) {
                    result = x - y;
                } else if (token.equals("*")) {
                    result = x * y;
                } else { // token.equals("/")
                    if (y == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                        return Double.NaN;
                    }
                    result = x / y;
                }

                stack.push(result);
            }
            // 3) Otherwise invalid token
            else {
                System.out.println("Error: Invalid token found -> " + token);
                return Double.NaN;
            }
        }

        // Guard: after processing, exactly 1 value should remain
        if (stack.size() != 1) {
            System.out.println("Error: Malformed Expression.");
            return Double.NaN;
        }

        return stack.pop();
    }

    // Helper: checks if token is one of + - * /
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Helper: checks if token can be parsed as a double
    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}