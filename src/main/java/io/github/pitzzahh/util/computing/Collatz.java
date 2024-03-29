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

package io.github.pitzzahh.util.computing;

import java.util.stream.IntStream;
import java.util.concurrent.TimeUnit;
import io.github.pitzzahh.util.utilities.validation.Validator;

/**
 * Class used in performing collatz conjecture calculation.
 */
public final class Collatz {

    /**
     * The default constructor.
     */
    public Collatz() {
    }

    private static int number;

    /**
     * Outputs a String
     * @param withDelay {@code true} a delay will be added on printing the output.
     */
    public void runCollatzConjecture(boolean withDelay) {
        IntStream.range(1, number).forEach(i -> {
            if (number == 1) return;
            if (number % 2 != 0) {
                System.out.printf("Number %d : %d is ODD\n", i, number);
                number = (number * 3) + 1;
            }
            else {
                System.out.printf("Number %d : %d is EVEN\n", i, number);
                number = number / 2;
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
     * @return {@code Collatz} object.
     */
    public Collatz setNumber(Number number) {
        if (!Validator.isWholeNumber().test(String.valueOf(number))) throw new IllegalArgumentException(String.format("Invalid number: %f", number.doubleValue()));
        if (Validator.isDecimalNumber().test(String.valueOf(number))) throw new IllegalArgumentException("Only whole numbers are accepted");
        Collatz.number = (int) number;
        return this;
    }
}