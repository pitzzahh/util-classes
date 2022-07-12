package com.github.pitzzahh.computing.algorithms.recursion.sumOfAllNumbers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SumOfAllNumbersTest {

    @Test
    void getSumOfAllNumbers() {
        var sumOfAllNumbers = new SumOfAllNumbers<>(3);
        var sum = sumOfAllNumbers.getSumOfAllNumbers();
        assertEquals(6, sum.intValue());
    }


}