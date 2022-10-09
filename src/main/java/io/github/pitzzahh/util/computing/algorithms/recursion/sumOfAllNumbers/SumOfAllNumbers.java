package io.github.pitzzahh.util.computing.algorithms.recursion.sumOfAllNumbers;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Class used to sum a sequence of numbers.
 */

public final class SumOfAllNumbers <T extends Number> {

    private T number;

    /**
     * All args constructor.
     * @param number sets the max number.
     */
    public SumOfAllNumbers(T number) {
        this.number = number;
    }

    /**
     * No args constructor.
     */
    public SumOfAllNumbers() {
    }

    /**
     * Sums the numbers between 1 and the number that is set.
     * @param number the max number.
     * @return {@code Number}, the sum between 1 and the number that is set.
     * @param <S> the data type that extends the {@code Number} class.
     */
    private <S extends Number> Number sumOfALlNumbers(S number) {
        return IntStream.rangeClosed(1, number.intValue()).reduce(0, Integer::sum);
    }

    /**
     * Computes the sum of numbers between 1 and the number that is set.
     * @return the sum.
     */
    public Number getSumOfAllNumbers() {
        return this.number.intValue() != 0 ? sumOfALlNumbers(number) : BigInteger.ZERO;
    }

}
