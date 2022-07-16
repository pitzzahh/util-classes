package com.github.pitzzahh.computing.algorithms.recursion.sumOfAllNumbers;

import java.math.BigInteger;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.stream.IntStream;

/**
 * Class used to sum a sequence of numbers.
 */
@NoArgsConstructor
@AllArgsConstructor
public final class SumOfAllNumbers <T extends Number> {
    private T number;

    private <S extends Number> Number sumOfALlNumbers(S number) {
        return IntStream.range(1, number.intValue() + 1).reduce(0, Integer::sum);
    }

    /**
     * Computes the sum of numbers between 1 and the number that is set.
     * @return the sum.
     */
    public Number getSumOfAllNumbers() {
        return this.number.intValue() != 0 ? sumOfALlNumbers(number) : BigInteger.ZERO;
    }

}
