package com.github.pitzzahh.computing.algorithms.recursion.factorial;

import java.text.NumberFormat;

public final class Factorial {

    private byte number;

    private long factorial(long number) {
        if (number != 0) return number * factorial(number - 1);
        else return 1;
    }

    /**
     * Outputs the factorial of the given {@code number}.
     * THE LIMIT IS ONLY AT 25th Factorial.
     */
    public void getFactorial() {
        long result = factorial(number);
        if (this.number <= 0 || this.number > 25) System.out.println("THE NUMBER GOES BEYOND THE LIMIT, THE RESULT IS NOT SHOWN\nTHIS IS CAUSED BY THE LIMITATION OF LONG PRIMITIVE TYPE\nTHE NUMBER THAT IS PASSED IN IS GREATER THAN 24\nTHE LIMIT OF THIS METHOD IS ONLY AT 93rd SEQUENCE");
        else System.out.println("The Factorial of " + this.number + " is: " + NumberFormat.getInstance().format(result));

    }
    /**
     * Sets the number to be used in finding the factorial result.
     * @param number the number should be between 1 and 23. Or the result will be inaccurate dues to the limitations of long data type.
     * @return the number.
     */
    public Factorial setNumber(byte number) {
        this.number = number;
        return this;
    }
}



