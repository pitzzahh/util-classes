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

package io.github.pitzzahh.util.computing.algorithms.recursion.factorial;

import java.text.NumberFormat;

/**
 * Class used for doing some factorial operations.
 */
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



