package com.github.pitzzahh.computing.algorithms.sorting.quickSort;

import java.util.Arrays;

import com.github.pitzzahh.computing.algorithms.sorting.QuickSort;
import com.github.pitzzahh.utilities.Utility;
import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    void shouldSortAByteArray() {
        // given
        var array = new Byte[] { 3, 1, 2 };
        // when
        QuickSort.sort(array);
        // then
        System.out.println(Arrays.toString(array));
    }

    @Test
    void shouldSortAIntegerArray() {
        // given
        var array = new Integer[] { 3, 1, 2 };
        // when
        QuickSort.sort(array);
        // then
        System.out.println(Arrays.toString(array));
    }

    @Test
    void shouldSortADoubleArray() {
        // given
        var array = new Double[] { 3.5, 1.5, 2.5 };
        // when
        QuickSort.sort(array);
        // then
        System.out.println(Arrays.toString(array));
    }
}