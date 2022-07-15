package com.github.pitzzahh.computing;

/**
 * Interface used for managing calculations.
 */
@FunctionalInterface
public interface Operation {

    /**
     * Abstract method used for calculation.
     * @param operation the type of operation to be used.
     * @return the calculated number based from the operations.
     * @throws IllegalArgumentException if the operation is invalid.
     */
     Number calculate(int operation) throws IllegalArgumentException;

     int MULTIPLY = 1;
     int DIVIDE = 2;
     int ADD = 3;
     int SUBTRACT = 4;
     int MODULO = 5;
}
