package com.github.pitzzahh.utilities;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void shouldPassIfByteArrayAreAllTheSameNumber1() {
        var arr = new Byte[] {1, 1, 1, 1};
        assertTrue(Utility.areAllTheSame(arr));
    }
    @Test
    void shouldPassIfByteArrayAreAllTheSameNumber2() {
        var arr = new Byte[] {2, 2, 2, 2};
        assertTrue(Utility.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfByteArrayElementsAreNotTheSame() {
        var arr = new Byte[] {1, 2, 3, 1};
        assertFalse(Utility.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfShortArrayAreAllTheSameNumber1() {
        var arr = new Short[] {1, 1, 1, 1};
        assertTrue(Utility.areAllTheSame(arr));
    }
    @Test
    void shouldPassIfShortArrayAreAllTheSameNumber2() {
        var arr = new Short[] {2, 2, 2, 2};
        assertTrue(Utility.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfShortArrayElementsAreNotTheSame() {
        var arr = new Short[] {1, 2, 3, 1};
        assertFalse(Utility.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfIntArrayAreAllTheSameNumber1() {
        var arr = new Integer[] {1, 1, 1, 1};
        assertTrue(Utility.areAllTheSame(arr));
    }
    @Test
    void shouldPassIfIntArrayAreAllTheSameNumber2() {
        var arr = new Integer[] {2, 2, 2, 2};
        assertTrue(Utility.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfIntArrayElementsAreNotTheSame() {
        var arr = new Integer[] {1, 2, 3, 1};
        assertFalse(Utility.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfBooleanArrayElementsAreAllTheSame1() {
        var arr = new Boolean[] { true, true, true, true };
        assertTrue(Utility.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfBooleanArrayElementsAreAllTheSame2() {
        var arr = new Boolean[] { false, false, false, false };
        assertTrue(Utility.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfBooleanArrayElementsAreNotTheSame() {
        // given
        var arr = new Boolean[] { true, false, true, false };
        // when
        var result = Utility.areAllTheSame(arr);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfSumIsTheSame() {
        // given
        var list = List.of(10, 20, 30, 40);
        // when
        var result = Utility.sum(list, Utility.allowAll());
        var expected = BigDecimal.valueOf(100);
        // then
        assertEquals(expected, result);
    }

    @Test
    void convertListToString() {
        String s = Utility.convertToString(List.of('P', 'E', 'T', 'E', 'R'));
        assertEquals("PETER", s);
    }
}