package com.github.pitzzahh.utilities;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersUtilTest {

    @Test
    void shouldPassIfByteArrayAreAllTheSameNumber1() {
        byte[] arr = {1, 1, 1, 1};
        assertTrue(NumbersUtil.checkIfAllNumbersAreTheSame(arr));
    }
    @Test
    void shouldPassIfByteArrayAreAllTheSameNumber2() {
        byte[] arr = {2, 2, 2, 2};
        assertTrue(NumbersUtil.checkIfAllNumbersAreTheSame(arr));
    }

    @Test
    void shouldPassIfByteArrayElementsAreNotTheSame() {
        byte[] arr = {1, 2, 3, 1};
        assertFalse(NumbersUtil.checkIfAllNumbersAreTheSame(arr));
    }

    @Test
    void shouldPassIfShortArrayAreAllTheSameNumber1() {
        short[] arr = {1, 1, 1, 1};
        assertTrue(NumbersUtil.checkIfAllNumbersAreTheSame(arr));
    }
    @Test
    void shouldPassIfShortArrayAreAllTheSameNumber2() {
        short[] arr = {2, 2, 2, 2};
        assertTrue(NumbersUtil.checkIfAllNumbersAreTheSame(arr));
    }

    @Test
    void shouldPassIfShortArrayElementsAreNotTheSame() {
        short[] arr = {1, 2, 3, 1};
        assertFalse(NumbersUtil.checkIfAllNumbersAreTheSame(arr));
    }

    @Test
    void shouldPassIfIntArrayAreAllTheSameNumber1() {
        int[] arr = {1, 1, 1, 1};
        assertTrue(NumbersUtil.checkIfAllNumbersAreTheSame(arr));
    }
    @Test
    void shouldPassIfIntArrayAreAllTheSameNumber2() {
        int[] arr = {2, 2, 2, 2};
        assertTrue(NumbersUtil.checkIfAllNumbersAreTheSame(arr));
    }

    @Test
    void shouldPassIfIntArrayElementsAreNotTheSame() {
        int[] arr = {1, 2, 3, 1};
        assertFalse(NumbersUtil.checkIfAllNumbersAreTheSame(arr));
    }

    @Test
    void getStringFromList() {
        String s = NumbersUtil.convertToString(List.of('P', 'E', 'T', 'E', 'R'));
        assertEquals("PETER", s);
    }
}