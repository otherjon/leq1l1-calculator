/*
 * Calculator.java
 * Author: Leqi Li
 *
 * Allows the user to type in an arithmetic expression, and then prints the
 * result.  The arithmetic expression must have exactly two integers, and
 * one operation in between them.
 *
 * Valid operations are:    +  -  *  /
 *
 * Sample input:
 *      2 + 3
 *      4 - 17
 *     -8 * -3
 *     11 / 7
 *     
 */
package org.leqili.calculatorproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Calculator {
    /*
     * Read a line of text from the terminal, assuming the user is entering
     * an arithmetic expression such as "1 + 1".  Split the resulting string
     * at each space character, and return the resulting array of words.
     *
     * Caution: This method does not verify user input in any way!
     *
     * Parameters: None
     * Return: array of Strings
     */
    public String[] getCalculationFromUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an arithmetic expression: ");
        System.out.flush();
        String input_line = "";
        try {
            input_line = reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException caught, aborting...");
            System.exit(1);
        }
        String[] words = input_line.split(" ", 0);
	return words;
    }

    /*
     * Perform the arithmetic calculation specified by the parameters, and
     * return the result.
     *
     * Parameters:
     *   num1, num2 (int) -- two numbers to be added, subtracted, multiplied, or
     *       divided
     *   operation (String) -- the arithmetic operation to be performed; must
     *       be either "+", "-", "*", or "/"
     *
     * Return:
     *   (double) the result of the given arithmetic calculation.  May be a
     *   non-integer if operation is "/".
     *
     * Throws:
     *   IllegalArgumentException if operation is not one of the valid values
     *     listed above ("+", "-", "*", or "/")
     *   ArithmeticException if operation is "/" and num2 is 0
     */
    public double calculate(int num1, int num2, String operation)
            throws IllegalArgumentException {
        double result;
        if (operation.equals("+")) {
            result = num1 + num2;
        } else if (operation.equals("-")) {
            result = num1 - num2;
        } else if (operation.equals("*")) {
            result = num1 * num2;
        } else if (operation.equals("/")) {
            result = (double) num1 / num2;
        } else {
            String errorMessage = "Bad operator: '" + operation + "'";
            throw new IllegalArgumentException(errorMessage);
        }        
        return result;
    }

    /*
     * Main program
     */
    public static void main(String args[]) {
        Calculator myApp = new Calculator();
	String[] words;
        double answer;
	words = myApp.getCalculationFromUser();
        try {
            int firstNum = Integer.parseInt(words[0]);
            String operator = words[1];
            int secondNum = Integer.parseInt(words[2]);
            answer = myApp.calculate(firstNum, secondNum, operator);
            System.out.println("answer is " + answer);
        } catch (NumberFormatException e1) {
	    /* The first or third word doesn't seem to be a number */
            System.out.println("Couldn't interpret input as a number");
        } catch (ArrayIndexOutOfBoundsException e2) {
	    /* We didn't get three separate words */
            System.out.println("Input didn't contain at least 3 words");
        } catch (IllegalArgumentException e3) {
	    /* The operation wasn't one of "+", "-", "*", or "/" */
            System.out.print("Invalid operation given: ");
            System.out.println(e3.toString());
        }
    }
}
