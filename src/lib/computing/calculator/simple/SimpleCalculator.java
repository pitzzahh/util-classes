package lib.computing.calculator.simple;

import java.util.Scanner;

public final class SimpleCalculator {
    // Cannot instantiate this class
    private SimpleCalculator() {}

    public static void run() {
        double firstNumber;
        double secondNumber;
        char operator;
        double result;
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("ENTER FIRST NUMBER: ");
            firstNumber = scanner.nextDouble();

            System.out.println("ENTER WHAT OPERATION TO BE USED");
            System.out.println(" : * : / : + : - :");
            operator = scanner.next().charAt(0);

            System.out.print("ENTER SECOND NUMBER: ");
            secondNumber = scanner.nextDouble();
        }
        switch (operator) {
            case '*' -> {
                result = firstNumber * secondNumber;
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
            }
            case '/' -> {
                result = firstNumber / secondNumber;
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
            }
            case '+' -> {
                result = firstNumber + secondNumber;
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
            }
            case '-' -> {
                result = firstNumber - secondNumber;
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
            }
        }
    }
}
