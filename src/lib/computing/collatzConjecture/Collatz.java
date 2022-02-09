package lib.computing.collatzConjecture;

import lib.utilities.InputChecker;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public final class Collatz {
    // Cannot instantiate this class
    private Collatz() {}

    public static void runCollatzConjecture() throws InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            String userInput;
            int number = 0;
            boolean inputChecker = true;
            while (inputChecker) {
                System.out.print("Enter a number: ");
                userInput = scanner.next().trim();
                if (InputChecker.isInteger(userInput)) {
                    number = Integer.parseInt(userInput);
                    if (number >= 1)
                        inputChecker = false;
                    else
                        System.out.println("Enter a number that is greater than or equal to 1");
                }
                else
                    System.out.println("PLEASE ENTER A NUMBER");
            }
            for (int i = 1; number != 1; i++) {
                if (number % 2 != 0) {
                    number = (number * 3) + 1;
                    System.out.printf("Number %d : %d is ODD", i , number);
                }
                else {
                    number = number / 2;
                    System.out.printf("Number %d : %d is EVEN", i, number);
                }
                System.out.println();
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (NumberFormatException ignored) {
        }
    }
}