package com.github.pitzzahh.computing.algorithms.recursion.sumOfAllNumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfAllNumbersTest {

    @Test
    void getSumOfAllNumbers() {
        SumOfAllNumbers sumOfAllNumbers = new SumOfAllNumbers().setNumber(5);
        sumOfAllNumbers.getSumOfAllNumbers();
    }
}