package com.github.pitzzahh.computing;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Utility Calculator class used for basic arithmetic operations.
 * @see Operation list of available arithmetic operation.
 * @param <T> the first number(any type of number)
 * @param <S> the second number(any type of number)
 */
@NoArgsConstructor
@AllArgsConstructor
public final class Calculator <T extends Number, S extends Number> implements Operation {

    private T firstNumber;
    private S secondNumber;

    /**
     * The method to be invoked in order to get the result.
     * @param op the operation to be used.
     * @return the result of the operation.
     * @throws IllegalArgumentException if the operation is invalid.
     * @throws NullPointerException if any of the number is {@code null}.
     */
    @Override
    public Number calculate(int op) throws IllegalArgumentException, NullPointerException {
        if (firstNumber == null) throw new NullPointerException("Cannot invoke \"calculate(int)\" because first number is null");
        else if (secondNumber == null) throw new NullPointerException("Cannot invoke \"calculate(int)\" because second number is null");
        return getExact(op);
    }

    /**
     * Method that gets the exact result of any operation.
     * @param op the operation to be used.
     * @see Operation operation.
     * @return a {@code BigDecimal}, the calculated result.
     * @throws IllegalArgumentException if the operation is invalid.
     */
    private Number getExact(int op) throws IllegalArgumentException {
        if (op < MULTIPLY || op > MODULO) {
            throw new IllegalArgumentException("Invalid Operation type");
        }
        var a = new BigDecimal(this.firstNumber.toString());
        var b = new BigDecimal(this.secondNumber.toString());
        return op == MULTIPLY ? a.multiply(b) :
                op == DIVIDE ? a.divide(b, new MathContext(RoundingMode.values().length)) :
                        op == ADD ? a.add(b):
                                op == SUBTRACT ? a.subtract(b) :
                                        a.remainder(b);
    }

    /**
     * Method that sets the numbers to be calculated.
     * @param firstNumber the first number.
     * @param secondNumber the second number.
     */
    public void setNumbers(T firstNumber, S secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
}
