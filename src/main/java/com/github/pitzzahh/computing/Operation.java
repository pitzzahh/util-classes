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

     /**
      * Choose this if you want to multiply.
      */
     int MULTIPLY = 1;
     /**
      * Choose this if you want to divide.
      */
     int DIVIDE = 2;
     /**
      * Choose this if you want to add.
      */
     int ADD = 3;
     /**
      * Choose this if you want to subtract.
      */
     int SUBTRACT = 4;
     /**
      * Choose this if you want to modulo.
      */
     int MODULO = 5;
}
