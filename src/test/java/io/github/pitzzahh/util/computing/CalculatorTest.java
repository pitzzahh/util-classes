package io.github.pitzzahh.util.computing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.github.pitzzahh.util.utilities.classes.enums.Operation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class CalculatorTest {

    @Nested
    class Arithmetic {
        @Test
        void multiply() {
            // given
            var calculator = new Calculator();
            // when
            var result = calculator.calculate(4, 2, Operation.MULTIPLICATION);
            var expected = BigDecimal.valueOf(8);
            // then
            assertEquals(expected, result);
        }

        @Test
        void divide() {
            // given
            var calculator = new Calculator();
            // when
            var result = calculator.calculate(5, 5, Operation.DIVISION);
            var expected = BigDecimal.valueOf(1);
            // then
            assertEquals(expected, result);
        }

        @Test
        void add() {
            // given
            var calculator = new Calculator();
            // when
            var result = calculator.calculate(4,2, Operation.ADDITION);
            var expected = BigDecimal.valueOf(6);
            // then
            assertEquals(expected, result);
        }

        @Test
        void subtract() {
            // given
            var calculator = new Calculator();
            // when
            var result = calculator.calculate(4, 2, Operation.SUBTRACTION);
            var expected = BigDecimal.valueOf(2);
            // then
            assertEquals(expected, result);
        }

        @Test
        void mod() {
            // given
            var calculator = new Calculator();
            // when
            var result = calculator.calculate(4, 2, Operation.MODULO);
            var expected = BigDecimal.ZERO;
            // then
            assertEquals(expected, result);
        }
    }

}