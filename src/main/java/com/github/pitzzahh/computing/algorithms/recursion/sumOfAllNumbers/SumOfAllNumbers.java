package com.github.pitzzahh.computing.algorithms.recursion.sumOfAllNumbers;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.stream.IntStream;

@NoArgsConstructor
@AllArgsConstructor
public final class SumOfAllNumbers <T extends Number> {
    private T number;

    private <S extends Number> Number sumOfALlNumbers(S number) {
        return IntStream.range(1, number.intValue() + 1).reduce(0, Integer::sum);
    }

    public Number getSumOfAllNumbers() {
        return this.number.intValue() != 0 ? sumOfALlNumbers(number) : BigInteger.ZERO;
    }

}
