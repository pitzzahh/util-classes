package com.github.pitzzahh.computing;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void multiply() {
        // given
        var calculator = new Calculator<>(4, 2);
        // when
        var result = calculator.calculate(Operation.MULTIPLY);
        var expected = BigDecimal.valueOf(8);
        // then
        assertEquals(expected, result);
    }

    @Test
    void divide() {
        // given
        var calculator = new Calculator<>();
        calculator.setNumbers(706, 20);
        calculator.setNumbers(5, 5);
        // when
        var result = calculator.calculate(Operation.DIVIDE);
        var expected = BigDecimal.valueOf(1);
        // then
        assertEquals(expected, result);
    }

    @Test
    void add() {
        // given
        var calculator = new Calculator<>(4.2, 2);
        // when
        var result = calculator.calculate(Operation.ADD);
        var expected = BigDecimal.valueOf(6.2);
        // then
        assertEquals(expected, result);
    }

    @Test
    void subtract() {
        // given
        var calculator = new Calculator<>(4, 2);
        // when
        var result = calculator.calculate(Operation.SUBTRACT);
        var expected = BigDecimal.valueOf(2);
        // then
        assertEquals(expected, result);
    }

    @Test
    void mod() {
        // given
        var calculator = new Calculator<>(4, 2);
        // when
        var result = calculator.calculate(Operation.MOD);
        Number expected = BigDecimal.ZERO;
        // then
        assertEquals(expected, result);
    }
}