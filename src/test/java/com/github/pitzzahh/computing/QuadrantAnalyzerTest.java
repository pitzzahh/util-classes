package com.github.pitzzahh.computing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuadrantAnalyzerTest {

    @Test
    void shouldPassIfPointsLiesInTheFirstQuadrant() {
        var quadrant = new QuadrantAnalyzer<>(10000, 67812);
        assertEquals(QuadrantAnalyzer.Quadrant.FIRST_QUADRANT, quadrant.getQuadrant());
    }

    @Test
    void shouldPassIfPointsLiesInTheSecondQuadrant() {
        var quadrant = new QuadrantAnalyzer<>(-1, 1);
        assertEquals(QuadrantAnalyzer.Quadrant.SECOND_QUADRANT, quadrant.getQuadrant());
    }

    @Test
    void shouldPassIfPointsLiesInTheThirdQuadrant() {
        var quadrant = new QuadrantAnalyzer<>(-1, -1);
        assertEquals(QuadrantAnalyzer.Quadrant.THIRD_QUADRANT, quadrant.getQuadrant());
    }

    @Test
    void shouldPassIfPointsLiesInTheFourthQuadrant() {
        var quadrant = new QuadrantAnalyzer<>(1, -1);
        assertEquals(QuadrantAnalyzer.Quadrant.FOURTH_QUADRANT, quadrant.getQuadrant());
    }

    @Test
    void shouldPassIfPointsLiesAtTheOrigin() {
        var quadrant = new QuadrantAnalyzer<>(0, 0);
        assertEquals(QuadrantAnalyzer.Quadrant.ORIGIN, quadrant.getQuadrant());
    }
}