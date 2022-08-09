package com.github.pitzzahh.utilities;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void shouldPassIfByteArrayAreAllTheSameNumber1() {
        var arr = new Byte[] {1, 1, 1, 1};
        assertTrue(Util.areAllTheSame(arr));
    }
    @Test
    void shouldPassIfByteArrayAreAllTheSameNumber2() {
        var arr = new Byte[] {2, 2, 2, 2};
        assertTrue(Util.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfByteArrayAreAllTheSameNumber3() {
        var arr = new Byte[] {1, 1, 1, 1};
        assertTrue(Util.areAllTheSame(arr, () -> 1));
    }
    @Test
    void shouldPassIfByteArrayAreAllTheSameNumber4() {
        var arr = new Byte[] {2, 2, 2, 2};
        assertTrue(Util.areAllTheSame(arr, () -> 2));
    }

    @Test
    void shouldPassIfByteArrayElementsAreNotTheSame() {
        var arr = new Byte[] {1, 2, 3, 1};
        assertFalse(Util.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfByteArrayElementsAreNotTheSame1() {
        var arr = new Byte[] {1, 2, 3, 1};
        assertFalse(Util.areAllTheSame(arr, () -> 1));
    }

    @Test
    void shouldPassIfShortArrayAreAllTheSameNumber1() {
        var arr = new Short[] {1, 1, 1, 1};
        assertTrue(Util.areAllTheSame(arr));
    }
    @Test
    void shouldPassIfShortArrayAreAllTheSameNumber2() {
        var arr = new Short[] {2, 2, 2, 2};
        assertTrue(Util.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfShortArrayElementsAreNotTheSame() {
        var arr = new Short[] {1, 2, 3, 1};
        assertFalse(Util.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfIntArrayAreAllTheSameNumber1() {
        var arr = new Integer[] {1, 1, 1, 1};
        assertTrue(Util.areAllTheSame(arr));
    }
    @Test
    void shouldPassIfIntArrayAreAllTheSameNumber2() {
        var arr = new Integer[] {2, 2, 2, 2};
        assertTrue(Util.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfIntArrayElementsAreNotTheSame() {
        var arr = new Integer[] {1, 2, 3, 1};
        assertFalse(Util.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfBooleanArrayElementsAreAllTheSame1() {
        var arr = new Boolean[] { true, true, true, true };
        assertTrue(Util.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfBooleanArrayElementsAreAllTheSame2() {
        var arr = new Boolean[] { false, false, false, false };
        assertTrue(Util.areAllTheSame(arr));
    }

    @Test
    void shouldPassIfBooleanArrayElementsAreNotTheSame() {
        // given
        var arr = new Boolean[] { true, false, true, false };
        // when
        var result = Util.areAllTheSame(arr);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfBooleanArrayElementsAreAllTheSame3() {
        var arr = new Boolean[] { false, false, false, false };
        assertTrue(Util.areAllTheSame(arr, () -> false));
    }

    @Test
    void shouldPassIfBooleanArrayElementsAreNotTheSame3() {
        // given
        var arr = new Boolean[] { true, false, true, true };
        // when
        var result = Util.areAllTheSame(arr, () -> true);
        // then
        assertFalse(result);
    }

    @Test
    void shouldPassIfSumIsTheSame() {
        // given
        var list = List.of(10, 20, 30, 40);
        // when
        var result = Util.sum(list, Util.allowAll());
        var expected = BigDecimal.valueOf(100);
        // then
        assertEquals(expected, result);
    }

    @Test
    void convertListToString() {
        String s = Util.convertToString(List.of('P', 'E', 'T', 'E', 'R'));
        assertEquals("PETER", s);
    }
}