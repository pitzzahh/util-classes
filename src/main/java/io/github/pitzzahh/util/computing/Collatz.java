package io.github.pitzzahh.util.computing;

import java.util.stream.IntStream;
import java.util.concurrent.TimeUnit;
import io.github.pitzzahh.util.utilities.validation.Validator;

/**
 * Class used in performing collatz conjecture calculation.
 */
public final class Collatz {

    private static int number;

    /**
     * Outputs a String
     * @param withDelay {@code true} a delay will be added on printing the output.
     */
    public void runCollatzConjecture(boolean withDelay) {
        IntStream.range(1, number).forEach(i -> {
            if (number == 1) return;
            if (number % 2 != 0) {
                System.out.printf("Number %d : %d is ODD\n", i, number);
                number = (number * 3) + 1;
            }
            else {
                System.out.printf("Number %d : %d is EVEN\n", i, number);
                number = number / 2;
            }
            if (withDelay) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /**
     * Sets the number.
     * @param number the number to be set.
     * @return {@code Collatz} object.
     */
    public Collatz setNumber(Number number) {
        if (!Validator.isWholeNumber().test(String.valueOf(number))) throw new IllegalArgumentException(String.format("Invalid number: %f", number.doubleValue()));
        if (Validator.isDecimalNumber().test(String.valueOf(number))) throw new IllegalArgumentException("Only whole numbers are accepted");
        Collatz.number = (int) number;
        return this;
    }
}