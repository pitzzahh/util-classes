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

package io.github.pitzzahh.util.computing.algorithms.recursion.fibonacci;

import java.math.BigInteger;
import java.text.NumberFormat;

/**
 * Class used for doing some fibonacci operations.
 */
public final class Fibonacci {

    private int number;
    private static final int GET_AT_NTH = 1;
    private static final int GET_UNTIL_N = 2;

    /**
     * Sets the number to be used in finding the fibonacci result.
     * @param number the number to used in the sequence.
     * @return the number.
     */
    public Fibonacci setNumber(int number) {
        this.number = number;
        return this;
    }

    /**
     * Outputs the fibonacci sequence at nth.
     */
    public void getFibonacciNumberAtNth() {
        computeFibonacci(GET_AT_NTH);
    }

    /**
     * Prints the sequence of fibonacci number, passed in at  The {@link #setNumber(int)} method
     */
    public void getFibonacciNumberUntilN() {
        computeFibonacci(GET_UNTIL_N);
    }

    /**
     * Computes the fibonacci sequence.
     * @param type the type on what to do.
     */
    private void computeFibonacci(int type) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c;
        for (int i = 1 ; i <= number ; i++) {
            c = a.add(b);
            a = b;
            b = c;
            if (type == GET_UNTIL_N) System.out.println("FIBONACCI: " + NumberFormat.getInstance().format(a));
        }
        if (type == GET_AT_NTH) System.out.println("FIBONACCI: " + NumberFormat.getInstance().format(a));
    }
}
