package com.github.pitzzahh.utilities.misc;

public final class Decorations {
    /**
     * Cannot instantiate this class.
     */
    private Decorations() {}

    public static final Prompt show = new Prompt();

    /**
     * Inserts a line above and below descriptions.
     */
    public static void line() {
        System.out.println(":---------------------------------------------:");
    }
    /**
     * Prints a loading text in color green.
     */
    public static void printLoading() {
        System.out.print(Color.GREEN.getColor() + "LOADING" + Color.RESET);
    }

    /**
     * Enum can be used for coloring Strings.
     */
    public enum Color {
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        BLUE("\u001B[34m"),
        YELLOW("\u001B[33m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        RESET("\u001B[0m");
        public final String value;
        Color(String description) {
            this.value = description;
        }
        public String getColor() {
            return value;
        }
    }
}
