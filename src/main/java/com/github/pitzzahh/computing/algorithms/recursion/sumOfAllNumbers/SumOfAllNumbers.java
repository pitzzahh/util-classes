package com.github.pitzzahh.computing.algorithms.recursion.sumOfAllNumbers;

import java.text.NumberFormat;

public final class SumOfAllNumbers {
    private int number;

    private int sumOfALlNumbers(int number) {
        if (number != 1) return number + sumOfALlNumbers(number - 1);
        else return 1;
    }

    public void getSumOfAllNumbers() {
        if (this.number == 0) System.out.println("The Sum from 1 to " + this.number + " is: " + 0);
        else {
            int result = sumOfALlNumbers(number);
            System.out.println("The Sum from 1 to " + this.number + " is: " + NumberFormat.getInstance().format(result));
        }
    }

    public SumOfAllNumbers setNumber(int number) {
        this.number = number;
        return this;
    }
}
