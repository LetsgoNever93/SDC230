/*
Name: Angel Avila
Date: 2/28/2026
Assignment SDC230L - Week 4 - Shunting-Yard & Exception Handling
*/

import java.util.EmptyStackException;
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

    // Divide (throw exception instead of printing/NaN)
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    /**
     REQUIRED SIGNATURE:
     Converts an infix expression (space-separated tokens) to postfix.
     Throws IllegalArgumentException for mismatched parentheses or invalid tokens.
     */
    public String convertToPostfix(String infix) throws IllegalArgumentException {
        if (infix == null || infix.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty.");
        }

        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String[] tokens = infix.trim().split("\\s+");

        for (String token : tokens) {

            // 1) Numbers go directly to output
            if (isNumeric(token)) {
                output.append(token).append(" ");
            }
            // 2) Left paren goes to stack
            else if (token.equals("(")) {
                stack.push('(');
            }
            // 3) Right paren: pop until '('
            else if (token.equals(")")) {
                boolean foundLeftParen = false;

                while (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (top == '(') {
                        foundLeftParen = true;
                        break; // discard '('
                    }
                    output.append(top).append(" ");
                }

                if (!foundLeftParen) {
                    throw new IllegalArgumentException("Mismatched parentheses detected.");
                }
            }
            // 4) Operators: pop while top has >= precedence
            else if (isOperator(token)) {
                char op = token.charAt(0);

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && getPrecedence(stack.peek()) >= getPrecedence(op)) {
                    output.append(stack.pop()).append(" ");
                }

                stack.push(op);
            }
            // 5) Invalid token
            else {
                throw new IllegalArgumentException("Invalid token found: " + token);
            }
        }

        // Cleanup pop remaining operators
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(') {
                throw new IllegalArgumentException("Mismatched parentheses detected.");
            }
            output.append(top).append(" ");
        }

        return output.toString().trim();
    }

    /**
     REQUIRED SIGNATURE:
     Evaluates a space-separated postfix expression.
     Throws ArithmeticException for division by zero.
     May throw EmptyStackException / IllegalArgumentException for malformed expressions.
     */
    public double evaluatePostfix(String expression) throws ArithmeticException {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty.");
        }

        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {

            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {

                // Need 2 operands
                if (stack.size() < 2) {
                    throw new EmptyStackException(); //  "too many operators"
                }

                double y = stack.pop(); // second operand
                double x = stack.pop(); // first operand
                double result;

                char op = token.charAt(0);
                switch (op) {
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break;
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        if (y == 0) {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        result = x / y;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }

                stack.push(result);
            } else {
                throw new IllegalArgumentException("Invalid token found: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Malformed postfix expression (too many operands).");
        }

        return stack.pop();
    }

    //  operator check
    private boolean isOperator(String token) {
        return token.length() == 1 &&
                (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }

    //  numeric check (supports integers + decimals + negative numbers)
    private boolean isNumeric(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }

    // precedence
    private int getPrecedence(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return -1;
    }
}