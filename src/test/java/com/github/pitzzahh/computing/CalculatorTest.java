package com.github.pitzzahh.computing;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;
import com.github.pitzzahh.utilities.classes.enums.Quadrant;
import static com.github.pitzzahh.utilities.classes.enums.Quadrant.*;

class CalculatorTest {

    @Nested
    class Arithmetic {
        @Test
        void multiply() {
            // given
            var calculator = new Calculator<>(4, 2);
            // when
            var result = calculator.calculate(Operation.MULTIPLY).getCalculation();
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
            var result = calculator.calculate(Operation.DIVIDE).getCalculation();
            var expected = BigDecimal.valueOf(1);
            // then
            assertEquals(expected, result);
        }

        @Test
        void add() {
            // given
            var calculator = new Calculator<>(4.2, 2);
            // when
            var result = calculator.calculate(Operation.ADD).getCalculation();
            var expected = BigDecimal.valueOf(6.2);
            // then
            assertEquals(expected, result);
        }

        @Test
        void subtract() {
            // given
            var calculator = new Calculator<>(4, 2);
            // when
            var result = calculator.calculate(Operation.SUBTRACT).getCalculation();
            var expected = BigDecimal.valueOf(2);
            // then
            assertEquals(expected, result);
        }

        @Test
        void mod() {
            // given
            var calculator = new Calculator<>(4, 2);
            // when
            var result = calculator.calculate(Operation.MODULO).getCalculation();
            var expected = BigDecimal.ZERO;
            // then
            assertEquals(expected, result);
        }
    }

    @Nested
    class OtherCalculations {
        @Test
        void shouldPassIfPointsLiesInTheFirstQuadrant() {
            var quadrant = new Calculator<>(10000, 67812);
            assertEquals(FIRST_QUADRANT, Quadrant.valueOf(quadrant.calculate(Calculator.ANALYZE_QUADRANT).toString()));
        }

        @Test
        void shouldPassIfPointsLiesInTheSecondQuadrant() {
            var quadrant = new Calculator<>(-1, 1);
            assertEquals(SECOND_QUADRANT, Quadrant.valueOf(quadrant.calculate(Calculator.ANALYZE_QUADRANT).toString()));
        }

        @Test
        void shouldPassIfPointsLiesInTheThirdQuadrant() {
            var quadrant = new Calculator<>(-1, -1);
            assertEquals(THIRD_QUADRANT, Quadrant.valueOf(quadrant.calculate(Calculator.ANALYZE_QUADRANT).toString()));
        }

        @Test
        void shouldPassIfPointsLiesInTheFourthQuadrant() {
            var quadrant = new Calculator<>(1, -1);
            assertEquals(FOURTH_QUADRANT, Quadrant.valueOf(quadrant.calculate(Calculator.ANALYZE_QUADRANT).toString()));
        }

        @Test
        void shouldPassIfPointsLiesAtTheOrigin() {
            var quadrant = new Calculator<>(0, 0);
            assertEquals(ORIGIN, Quadrant.valueOf(quadrant.calculate(Calculator.ANALYZE_QUADRANT).toString()));
        }

        @Test
        void hypotenuse() {
            // given
            var calculator = new Calculator<>(2, 2);
            // when
            var result = calculator.calculate(Operation.HYPOTENUSE_CALCULATION).getCalculation();
            var expected = BigDecimal.valueOf(2.8284271247461903);
            // then
            assertEquals(expected, result);
        }
    }
}