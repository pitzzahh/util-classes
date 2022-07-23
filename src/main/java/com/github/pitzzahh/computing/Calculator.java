package com.github.pitzzahh.computing;

import java.util.Arrays;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import com.github.pitzzahh.utilities.classes.enums.Quadrant;
import static com.github.pitzzahh.utilities.classes.enums.Quadrant.*;

/**
 * Utility Calculator class used for basic arithmetic operations.
 * @see Operation list of available arithmetic operation.
 * @param <T> the first number(any type of number)
 * @param <R> the second number(any type of number)
 */
public final class Calculator <T extends Number, R extends Number, S extends Number> implements Operation {

    private T a;
    private R b;
    private S c;
    private BigDecimal result = BigDecimal.ZERO;

    private boolean isQuadrant;

    /**
     * No args Constructor.
     */
    public Calculator() {}

    /**
     * Constructor for {@code Calculator} class. Taking only two valus. {@code T} and {@code R}
     * @param a the first number.
     * @param b the second number.
     */
    public Calculator(T a, R b) {
        this.a = a;
        this.b = b;
    }

    /**
     * All args constrcutor for {@code Calculator} class.
     * @param a the first number.
     * @param b the second number.
     * @param c the third number.
     */
    public Calculator(T a, R b, S c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Abstract method used for calculation.
     * @param operation the type of operation to be used.
     * @return the calculated number based from the operations.
     * @throws IllegalArgumentException if the operation is invalid.
     */
    @Override
    public Calculator calculate(int operation) throws IllegalArgumentException {
        if (a == null && b == null) return new Calculator<>();
        else if (a == null) throw new NullPointerException(String.format("Cannot invoke \"calculate(%s)\" because first number is null", operationUsed(operation)));
        else if (b == null) throw new NullPointerException(String.format("Cannot invoke \"calculate(%s)\" because second number is null", operationUsed(operation)));
        return getExact(operation);
    }

    /**
     * Gets the result of the calculation/s.
     * @return {@code Number} the calculated number.
     */
    public Number getCalculation() throws IllegalAccessException {
        if (isQuadrant) throw new IllegalAccessException("redundant call to getCalculation(), if op is ANALYZE_QUADRANT, no need to call getCalculation()");
        return this.result;
    }

    /**
     * Method that gets the exact result of any operation.
     * @param op the operation to be used.
     * @see Operation operation.
     * @return a {@code BigDecimal}, the calculated result.
     * @throws IllegalArgumentException if the operation is invalid.
     */
    private Calculator getExact(int op) throws IllegalArgumentException {
        if (op < MULTIPLY || op > ANALYZE_QUADRANT) throw new IllegalArgumentException("Invalid Operation type " + op);
        var a = new BigDecimal(this.a.toString());
        var b = new BigDecimal(this.b.toString());
        switch (op) {
            case MULTIPLY -> this.result = this.result.add(a.multiply(b));
            case DIVIDE -> this.result = this.result.add(a.divide(b));
            case ADD -> this.result = this.result.add(a.add(b));
            case SUBTRACT -> this.result = this.result.add(a.subtract(b));
            case HYPOTENUSE_CALCULATION -> this.result = this.result.add(getHypotenuse());
            case ANALYZE_QUADRANT -> {
                isQuadrant = true;
                result = BigDecimal.valueOf(whichQuadrant(this.a, this.b).ordinal());
            }
        }
        return this;
    }

    /**
     * Computes the hypotenuse.
     * @return the computed hypotenuse.
     */
    private BigDecimal getHypotenuse() {
        var xValue = this.a instanceof Integer ? String.valueOf(this.a.intValue()) :
                this.a instanceof Double ? String.valueOf(this.a.doubleValue()) :
                        String.valueOf(this.a.byteValue());

        var yValue = this.b instanceof Integer ? String.valueOf(this.b.intValue()) :
                this.b instanceof Double ? String.valueOf(this.b.doubleValue()) :
                        String.valueOf(this.b.byteValue());

        var x = new BigDecimal(xValue);
        var y = new BigDecimal(yValue);
        return BigDecimal.valueOf(Math.sqrt((x.doubleValue() * x.doubleValue()) + (y.doubleValue() * y.doubleValue())));
    }

    /**
     * Method that identifies which quadrant the point is.
     * @param x the x position on the board
     * @param y the y position on the board
     * @return {@code Quadrant}
     */
    private static Quadrant whichQuadrant(Number x, Number y) {
        if (x.intValue() > 0 && y.intValue()  > 0) return FIRST_QUADRANT;
        else if (x.intValue()  < 0 && y.intValue()  > 0) return SECOND_QUADRANT;
        else if (x.intValue()  < 0 && y.intValue()  < 0) return THIRD_QUADRANT;
        else if (x.intValue()  > 0 && y.intValue()  < 0) return FOURTH_QUADRANT;
        else return ORIGIN;
    }

    /**
     * Gets the name of the operation that is used.
     * @param operation the operation used.
     * @return the {@code String} representation of the operation, if operation is invalid
     */
    private String operationUsed(int operation) {
        return switch (operation) {
            case 1 -> "MULTIPLY";
            case 2 -> "DIVIDE";
            case 3 -> "ADD";
            case 4 -> "SUBTRACT";
            case 5 -> "MODULO";
            case 6 -> "HYPOTENUSE_CALCULATION";
            default -> throw new IllegalArgumentException("Invalid Operation type " + operation);
        };
    }

    /**
     * Method that sets the first and second numbers to be calculated.
     * @param firstNumber the first number.
     * @param secondNumber the second number.
     */
    public void setNumbers(T firstNumber, R secondNumber) {
        this.a = firstNumber;
        this.b = secondNumber;
    }

    /**
     * Method that sets all numbers to be calculated.
     * @param firstNumber the first number.
     * @param secondNumber the second number.
     */
    public void setNumbers(T firstNumber, R secondNumber, S thirdNumber) {
        this.a = firstNumber;
        this.b = secondNumber;
        this.c = thirdNumber;
    }

    /**
     * Gets the first parameter value.
     * @return {@code T}, the first parameter value.
     */
    public T getA() {
        return this.a;
    }

    /**
     * Gets the second parameter value.
     * @return {@code R}, the second parameter value.
     */
    public R getB() {
        return this.b;
    }

    /**
     * Gets the third parameter value.
     * @return {@code C}, the third parameter value.
     */
    public S getC() {
        return this.c;
    }

    @Override
    public String toString() {
        return isQuadrant ? Quadrant.valueOf(Arrays.stream(values()).filter(o -> o.ordinal() == result.intValue()).findAny().get().toString()).toString() : "0";
    }
}
