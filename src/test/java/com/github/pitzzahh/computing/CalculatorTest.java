package com.github.pitzzahh.computing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator CALCULATOR = new Calculator();
    @Test
    void multiply() {
        // given
        var result = CALCULATOR.op(2, 4, Calculator.MULTIPLY);
        // when
        Number expected = 8;
        assertEquals(expected, result);
    }

    @Test
    void divide() {
        // given
        var result = CALCULATOR.op(706, 20, Calculator.DIVIDE);
        // when
        Number expected = 35.3;
        // then
        assertEquals(expected, result);
    }

    @Test
    void add() {
        // given
        var result = CALCULATOR.op(4.2, 2,Calculator.ADD);
        // when
        Number expected = 6.2;
        // then
        assertEquals(expected, result);
    }

    @Test
    void subtract() {
        // given
        var result = CALCULATOR.op(4, 2, Calculator.SUBTRACT);
        // when
        Number expected = 2;
        // then
        assertEquals(expected, result);
    }

    @Test
    void mod() {
        // given
        var result = CALCULATOR.op(4, 2, Calculator.MOD);
        // when
        Number expected = 0;
        // then
        assertEquals(expected, result);
    }
}