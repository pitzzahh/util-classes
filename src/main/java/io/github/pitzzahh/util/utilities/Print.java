package io.github.pitzzahh.util.utilities;

/**
 * Class used to shorten printing functions.
 */
public final class Print {

    /**
     * Prints any Object and then terminate the line.
     * @param object the thing to print.
     * @param <T> the type of the {@code Object}.
     */
    public static <T> void println(T object) {
        System.out.println(object);
    }

    /**
     * Terminates the current line by writing the line separator string
     */
    public static void println() {
        System.out.println();
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
    @SafeVarargs
    public static <T> void printf(String format, T...args) {
        System.out.printf(format, (Object) args);
    }
}
