package com.github.pitzzahh.computing.algorithms.recursion.sumOfAllNumbers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SumOfAllNumbersTest {

    @Test
    void shouldPassIfSumOfASequenceOfNumbersAreEqual() {
        var sumOfAllNumbers = new SumOfAllNumbers<>(3); // sum numbers from 1 to 3: 1 + 2 + 3 = 6
        var sum = sumOfAllNumbers.getSumOfAllNumbers();
        assertEquals(6, sum.intValue());
    }

}