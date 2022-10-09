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
