package lib.utilities.misc;

public final class InputChecker {
    /**
     * Cannot instantiate this class.
     */
    private InputChecker() {}
    /**
     * Checks if user input is a valid byte number parameter is a String called input.
     * @param input the {@code String} that is passed in
     * @return true if the input is a valid byte number
     */
    public static boolean isByte(String input) {
        try {
            Byte.parseByte(input);
            return true;
        }
        catch (Exception ignored) {
        }
        return false;
    }
    /**
     * Checks if user input is a valid byte number parameter is a String called input.
     * @param yearString the {@code String} that is passed in
     * @return true if the input is a valid short number
     */
    public static boolean isShort(String yearString) {
        try {
            Short.parseShort(yearString);
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

    /**
     * Checks if user input is a valid byte number parameter is a String called input.
     * @param input the {@code String} that is passed in
     * @return true if the input is a valid integer number
     */
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (Exception ignored) {
        }
        return false;
    }
    /**
     * Checks if user input is a valid byte number parameter is a String called input.
     * @param input the {@code String} that is passed in
     * @return true if the input is a valid double floating number
     */
    public static Boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        }
        catch (Exception e) {
            System.out.print(' ');
        }
        return false;
    }
}
