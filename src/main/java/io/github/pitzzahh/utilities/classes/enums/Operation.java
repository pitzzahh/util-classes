package io.github.pitzzahh.utilities.classes.enums;

/**
 * Enum of operations.
 */
public enum Operation {

    /**
     * Used to multiply
     */
    MULTIPLICATION("Used multiply"),
    /**
     * Used to divide.
     */
    DIVISION("Used to divide"),
    /**
     * Used to add.
     */
    ADDITION("Used to add"),
    /**
     * Used to subtract.
     */
    SUBTRACTION("Used to subtract"),
    /**
     * Used to get the remainder of a division
     */
    MODULO("Used to get the remainder");

    /**
     * Contains the info about an enum.
     */
    private final String INFORMATION;

    /**
     * Sets the info about an enum.
     * @param info the info of the enum.
     */
    Operation(String info) {
        this.INFORMATION = info;
    }

    /**
     * Gets the information about the enum.
     * @return a {@code String} containing the info about the enum.
     */
    public String getInformation() {
        return this.INFORMATION;
    }

}
