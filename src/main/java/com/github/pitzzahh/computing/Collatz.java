package com.github.pitzzahh.computing;

import lombok.NoArgsConstructor;
import java.util.stream.IntStream;
import java.util.concurrent.TimeUnit;
import com.github.pitzzahh.utilities.validation.Validator;

@NoArgsConstructor
public final class Collatz {

    private static int number;

    /**
     * Outputs a String
     * @param withDelay {@code true} a delay will be added on printing the output.
     */
    public void runCollatzConjecture(boolean withDelay) {
        IntStream.range(1, number).forEach(i -> {
            if (number % 2 != 0) {
                number = (number * 3) + 1;
                System.out.printf("Number %d : %d is ODD\n", i, number);
            }
            else {
                number = number / 2;
                System.out.printf("Number %d : %d is EVEN\n", i, number);
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
     */
    public Collatz setNumber(Number number) {
        if (!Validator.isWholeNumber().apply(String.valueOf(number))) throw new IllegalArgumentException(String.format("Invalid number: %f", number.doubleValue()));
        if (Validator.isDecimalNumber().apply(String.valueOf(number))) throw new IllegalArgumentException("Only whole numbers are accepted");
        Collatz.number = (int) number;
        return this;
    }
}