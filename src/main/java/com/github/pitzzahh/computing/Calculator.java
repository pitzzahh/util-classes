package com.github.pitzzahh.computing;

import java.math.BigDecimal;

@Deprecated(forRemoval = true)
public class Calculator implements Operation {

    public static final int MULTIPLY = 1;
    public static final int DIVIDE = 2;
    public static final int ADD = 3;
    public static final int SUBTRACT = 4;
    public static final int MOD = 5;

    @Override
    public Number op(Number a, Number b, int op) {
        return getExact(a, b, op);
    }

    private Number getExact(Number x, Number y, int whatOp) {
        BigDecimal a = new BigDecimal(x.toString());
        BigDecimal b = new BigDecimal(y.toString());
        return whatOp == MULTIPLY ? a.multiply(b) : whatOp == DIVIDE ? a.divide(b) : whatOp == ADD ? a.add(b): whatOp == SUBTRACT ? a.subtract(b) : whatOp == MOD ? a.remainder(b) : 0;
    }

}
