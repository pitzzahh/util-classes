/*
 * MIT License
 *
 * Copyright (c) 2022 pitzzahh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

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
