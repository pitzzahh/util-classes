/*
 * MIT License
 *
 * Copyright (c) 2022 pitzzahh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package io.github.pitzzahh.util.computing;

import java.util.Objects;
import java.math.BigDecimal;
import java.math.MathContext;
import static java.math.BigDecimal.valueOf;

import io.github.pitzzahh.util.utilities.classes.enums.Operation;

/**
 * Calculator class used to perform basic calculation.
 * @see ICalculator
 * @see Number
 * @see Operation
 * @see ICalculator
 * @see BigDecimal
 */
public class Calculator implements ICalculator {

    /**
     * The first number.
     */
    private Number firstNumber;
    /**
     * The second number.
     */
    private Number secondNumber;
    /**
     * The operation used.
     */
    private Operation operation;

    private boolean isNoArgs = false;

    /**
     * No args constructor
     */
    public Calculator() {
        isNoArgs = true;
    }

    /**
     * All args constructor
     * @param a the first parameter containing the first number.
     * @param b the second parameter containing the second number.
     * @param operation the third par
     */
    public Calculator(Number a, Number b, Operation operation) {
        this.firstNumber = a;
        this.secondNumber = b;
        this.operation = operation;
    }

    /**
     * Abstract method that calculates a calculation.
     *
     * @param firstNumber  the first number
     * @param secondNumber the second number
     * @param operation    the operation to be used.
     * @return a {@code BigDecimal}
     * @see Number
     * @see Operation
     */
    @Override
    public BigDecimal calculate(Number firstNumber, Number secondNumber, Operation operation) {
        Objects.requireNonNull(firstNumber, "First number cannot be null");
        Objects.requireNonNull(secondNumber, "Second number cannot be null");
        Objects.requireNonNull(operation, "Operation cannot be null");
        var result = BigDecimal.ZERO;
        if (isNoArgs) {
            this.firstNumber = firstNumber;
            this.secondNumber = secondNumber;
            this.operation = operation;
        }
        Operation requireNonNull = Objects.requireNonNull(this.operation);
        if (requireNonNull == Operation.MULTIPLICATION) {
            result = valueOf(this.firstNumber.longValue()).multiply(valueOf(this.secondNumber.longValue()));
        } else if (requireNonNull == Operation.DIVISION) {
            result = valueOf(this.firstNumber.longValue()).divide(valueOf(this.secondNumber.longValue()), MathContext.DECIMAL64);
        } else if (requireNonNull == Operation.ADDITION) {
            result = valueOf(this.firstNumber.longValue()).add(valueOf(this.secondNumber.longValue()));
        } else if (requireNonNull == Operation.SUBTRACTION) {
            result = valueOf(this.firstNumber.longValue()).subtract(valueOf(this.secondNumber.longValue()));
        } else if (requireNonNull == Operation.MODULO) {
            result = valueOf(this.firstNumber.longValue()).remainder(valueOf(this.secondNumber.longValue()), MathContext.DECIMAL64);
        }
        return result;
    }

    /**
     * Get the first number of the operation used.
     * @return a {@code Number} containing the first number.
     */
    public Number getFirstNumber() {
        return firstNumber;
    }

    /**
     * Sets the first number to be used for the operation.
     * @param firstNumber the first number, can be any number.
     * @see Number
     */
    public void setFirstNumber(Number firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * Get the second number of the operation used.
     * @return a {@code Number} containing the second number.
     */
    public Number getSecondNumber() {
        return secondNumber;
    }

    /**
     * Sets the second number to be used for the operation.
     * @param secondNumber the second number, can be any number.
     * @see Number
     */
    public void setSecondNumber(Number secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * Get the operation used on the computation.
     * @return the operation used.
     * @see Operation
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Sets the operation of the computation.
     * @param operation the operation to be used.
     * @see Operation
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

}
