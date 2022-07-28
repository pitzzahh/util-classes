package com.github.pitzzahh.utilities;

/**
 * Class used to shorten printing functions.
 */
public final class Print<T> {

    /**
     * Prints any Object and then terminate the line.
     * @param object the thing to print.
     * @param <T> the type of the {@code Object}.
     */
    public static <T> void println(T object) {
        System.out.println(object);
    }

    /**
     * Prints any Object.
     * @param object the thing to print.
     * @param <T> the type of the {@code Object}.
     */
    public static <T> void print(T object) {
        System.out.print(object);
    }

    /**
     * Prints a formatted String
     * @param  format
     *         A format string as described in <a
     *         href="../util/Formatter.html#syntax">Format string syntax</a>
     * @param args arguments.
     * @param <T> the type of the {@code Object}.
     */
    public static <T> void printf(String format, T...args) {
        System.out.printf(format, args);
    }
}
