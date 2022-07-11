package com.github.pitzzahh.computing;

import com.github.pitzzahh.computing.HypotenuseCalculator;
import org.junit.jupiter.api.Test;

class HypotenuseCalculatorTest {

    @Test
    void runComputeHypotenuse() {
        var hypotenuseCalculator = new HypotenuseCalculator<>(2.1, 2.1);
        var bigDecimal = hypotenuseCalculator.getHypotenuse();
        System.out.println("hypotenuse = " + bigDecimal.doubleValue());
    }
}