package lib.utilities.misc;

public final class Decorations {
    /**
     * Cannot instantiate this class.
     */
    private Decorations() {}

    public static final Prompt show = new Prompt();

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";
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
        System.out.print(Decorations.TEXT_GREEN + "LOADING" + Decorations.TEXT_RESET);
    }
}
