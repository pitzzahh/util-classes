package io.github.pitzzahh.computing;

import io.github.pitzzahh.utilities.classes.enums.Operation;
import java.math.BigDecimal;

/**
 * Interface used to make calculators.
 * @see FunctionalInterface
 * @see BigDecimal
 * @see Operation
 * @see Number
 */
@FunctionalInterface
public interface ICalculator {

    /**
     * Abstract method that calculates a calculation.
     * @param firstNumber the first number
     * @param secondNumber the second number
     * @param operation the operation to be used.
     * @return a {@code BigDecimal} containing the result of a calculation.
     */
    BigDecimal calculate(Number firstNumber, Number secondNumber, Operation operation);

}
