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

package io.github.pitzzahh.util.utilities;

import java.io.PrintStream;

/**
 * Class used to shorten printing functions.
 */
public final class Print {

    /**
     * PrintStream field to be used.
     */
    private static final PrintStream PRINT_STREAM = System.out;
    /**
     * Prints any Object and then terminate the line.
     * @param object the thing to print.
     * @param <T> the type of the {@code Object}.
     */
    public static <T> void println(T object) {
        PRINT_STREAM.println(object);
    }

    /**
     * Terminates the current line by writing the line separator string
     */
    public static void println() {
        PRINT_STREAM.println();
    }

    /**
     * Prints any Object.
     * @param object the thing to print.
     * @param <T> the type of the {@code Object}.
     */
    public static <T> void print(T object) {
        PRINT_STREAM.print(object);
    }

    /**
     * Prints a formatted String
     * @param  format
     *         A format string as described in <a
     *         href="../util/Formatter.html#syntax">Format string syntax</a>
     * @param args arguments.
     * @param <T> the type of the {@code Object}.
     */
    @SafeVarargs
    @SuppressWarnings("ConfusingArgumentToVarargsMethod")
    public static <T> void printf(String format, T...args) {
        PRINT_STREAM.printf(format, args);
    }
}
