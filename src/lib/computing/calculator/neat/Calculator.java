package lib.computing.calculator.neat;

import lib.utilities.InputChecker;
import java.text.NumberFormat;
import java.util.Scanner;

public final class Calculator {
    static String temporaryString = "";
    static int firstNumber = 0;
    static int secondNumber = 0;
    static char operator = ' ';
    static int multiplicationResult = 0;
    static int wholeDivisionResult = 0;
    static int additionResult = 0;
    static int subtractionResult = 0;
    static int wholeDecimal = 0;
    static double roundedDivisionResult = 0.0;
    static boolean first = true;
    static boolean second = true;
    static boolean operation = true;
    static boolean tryAgain = true;
    static boolean isNotExit = true;
    static NumberFormat numberFormat = NumberFormat.getInstance();
	public void runCalculator() {
        while (isNotExit) {
            reset();
            Scanner userInput = new Scanner(System.in);
            System.out.println(":----------------------------------------------------:");
            System.out.println(":                 SIMPLE CALCULATOR                  :");
            System.out.println(":----------------------------------------------------:");
            while(first) {
                System.out.println(":-----------------------------:");
                System.out.println(":      ENTER FIRST NUMBER     :");
                System.out.println(":-----------------------------:");
                System.out.print("   >>>>: ");
                temporaryString = userInput.next().trim(); // 10
                if (InputChecker.isInteger(temporaryString)) {
                    firstNumber = Integer.parseInt(temporaryString); // "10" --> 10
                    first = false;
                }
                else
                    System.out.println("\t  THAT IS NOT A NUMBER (!)");
            }
            while(second) {
                System.out.println(":-----------------------------:");
                System.out.println(":     ENTER SECOND NUMBER     : ");
                System.out.println(":-----------------------------:");
                System.out.print("   >>>>: ");
                temporaryString = userInput.next().trim();
                if (InputChecker.isInteger(temporaryString)) {
                    secondNumber = Integer.parseInt(temporaryString);
                    second = false;
                }
                else {
                    System.out.println("\t  THAT IS NOT A NUMBER (!)");
                }
            }
            while(operation) {
                System.out.println(":-----------------------------:");
                System.out.println(":     ENTER WHAT OPERATION    : ");
                System.out.println(":-----------------------------:");
                System.out.print("   >>>>: "); // + - * /
                temporaryString = userInput.next().trim();
                if (temporaryString.equals("+") || temporaryString.equals("-") || temporaryString.equals("*") || temporaryString.equals("/")) {
                    operator = temporaryString.charAt(0); // "+" --> '+'
                    operation = false;
                }
                else {
                    System.out.println("\t  THAT IS NOT AN OPERATION (!)");
                }
            }
            // solving
            switch (operator) {
                case '*' -> multiplication(firstNumber, secondNumber);
                case '/' -> division(firstNumber, secondNumber);
                case '+' -> addition(firstNumber, secondNumber);
                case '-' -> subtraction(firstNumber, secondNumber);
            }
            while (tryAgain) {
                char exitResponse;
                System.out.println("DO YOU WANT TO SOLVE AGAIN? ");
                System.out.println(": Y : for yes : N : for no");
                System.out.print(">>> ");
                exitResponse = userInput.next().toUpperCase().charAt(0);
                switch (exitResponse) {
                    case 'Y' -> tryAgain = false;
                    case 'N' -> {
                        tryAgain = false;
                        isNotExit = false;
                        userInput.close();
                    }
                    default -> System.out.println("INVALID INPUT");
                }
            } // end of loop try again
        } // end of loop whole condition
        System.out.println("==================================");
        System.out.println(": THANK YOU FOR USING MY PROGRAM :");
        System.out.println("==================================");
	}
    private void reset() {
        temporaryString = "";
        operator = ' ';
        firstNumber = 0;
        secondNumber = 0;
        additionResult = 0;
        subtractionResult = 0;
        multiplicationResult = 0;
        wholeDivisionResult = 0;
        wholeDecimal = 0;
        roundedDivisionResult = 0.0;
        first = true;
        second = true;
        tryAgain = true;
        isNotExit = true;
        operation = true;
    }
	private void addition(int firstNumber, int secondNumber) {
        additionResult = firstNumber + secondNumber;
        System.out.println("=================================");
        System.out.println("\t   " + firstNumber + " " + operator + " " + secondNumber + " = " + numberFormat.format(additionResult));
        System.out.println("=================================");
	}
	private void subtraction(int firstNumber, int secondNumber) {
	    subtractionResult = firstNumber - secondNumber;
        System.out.println("=================================");
        System.out.println("\t   " + firstNumber + " " + operator + " " + secondNumber + " = " + numberFormat.format(subtractionResult));
        System.out.println("=================================");
	}
	private void multiplication(int firstNumber, int secondNumber) {
		multiplicationResult = firstNumber * secondNumber;
        System.out.println("=================================");
        System.out.println("\t   " + firstNumber + " " + operator + " " + secondNumber + " = " + numberFormat.format(multiplicationResult));
        System.out.println("=================================");
	}
    private void division(double firstNumber, double secondNumber) {
        double result;
		result = firstNumber / secondNumber;
        roundedDivisionResult = Math.round(result * 100.0) / 100.0;
        if (firstNumber == secondNumber || firstNumber % secondNumber == 0 || secondNumber == 1) {
            wholeDecimal = (int) Math.floor(roundedDivisionResult);
            if (secondNumber % 3 != 0) {
                if (roundedDivisionResult == wholeDecimal) {
                    wholeDecimal = (int)roundedDivisionResult;
                    System.out.println("=================================");
                    System.out.println("\t   " + (int)firstNumber + " " + operator + " " + (int)secondNumber + " = " + wholeDecimal);
                    System.out.println("=================================");
                }
                else {
                    System.out.println("=================================");
                    System.out.println("\t   " + firstNumber + " " + operator + " " + secondNumber + " = " + roundedDivisionResult);
                    System.out.println("=================================");
                }
            }
            else if (roundedDivisionResult != wholeDecimal) {
                System.out.println("=================================");
                System.out.println("\t   " + firstNumber + " " + operator + " " + secondNumber + " = " + roundedDivisionResult);
                System.out.println("=================================");
            }
            else {
                wholeDecimal = (int) roundedDivisionResult;
                System.out.println("=================================");
                System.out.println("\t   " + (int)firstNumber + " " + operator + " " + (int)secondNumber + " = " + wholeDecimal);
                System.out.println("=================================");
            }
        }
        else {
            System.out.println("=================================");
            System.out.println("\t   " + (int)firstNumber + " " + operator + " " + (int)secondNumber + " = " + roundedDivisionResult);
            System.out.println("=================================");
        }
    }
}