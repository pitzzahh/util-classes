package lib.computing.algorithms.recursion.fibonacci;

import java.text.NumberFormat;

public final class Fibonacci {
    private byte number;
    private static long[] fibonacciCache;
    private long fibonacci(int number) {
        if (number <= 1) {
            return number;
        }
        if (fibonacciCache[number] != 0) {
            return fibonacciCache[number];
        }
        long nthFibonacciNumber = fibonacci(number - 1) + fibonacci(number - 2);
        fibonacciCache[number] = nthFibonacciNumber;
        return nthFibonacciNumber;
    }

    /**
     * Sets the number to be used in finding the fibonacci result.
     * @param number the number should be between 1 and 93. Or the result will be inaccurate dues to the limitations of long data type.
     * @return the number.
     */
    public Fibonacci setNumber(byte number) {
        this.number = number;
        fibonacciCache = new long[this.number + 1];
        return this;
    }
    public void getFibonacciNumberAtNth() {
        System.out.println("FIBONACCI: " + NumberFormat.getInstance().format(fibonacci(number)));
    }
    /**
     * Prints the sequence of fibonacci number, passed in at  The {@link #setNumber(byte)} method
     * THE LIMIT IS ONLY AT 93rd SEQUENCE OF THE FIBONACCI SERIES
     */
    public void getFibonacciNumberUntilN() {
        if (this.number > 93) {
            System.out.println("THE NUMBER GOES BEYOND THE LIMIT, THE RESULT IS NOT SHOWN\nTHIS IS CAUSED BY THE LIMITATION OF LONG PRIMITIVE TYPE\nTHE NUMBER THAT IS PASSED IN IS GREATER THAN 93\nTHE LIMIT OF THIS METHOD IS ONLY AT 93rd SEQUENCE");
        }
        else {
            for (int i = 0; i <= this.number; i++) {
                System.out.println("FIBONACCI: " + NumberFormat.getInstance().format(fibonacci(i)));
            }
        }
    }
}
