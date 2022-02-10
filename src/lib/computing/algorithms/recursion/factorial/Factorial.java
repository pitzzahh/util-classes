package lib.computing.algorithms.recursion.factorial;

import java.text.NumberFormat;

public final class Factorial {
    private long number;
    private long factorial(long number) {
        if (number != 0) {
            return number * factorial(number - 1);
        }
        else {
            return 1;
        }
    }
    public void getFactorial() {
        long result = factorial(number);
        if (number == 0) {
            System.out.println("The Factorial of " + this.number + " is: " + 0);
        }
        else {
            System.out.println("The Factorial of " + this.number + " is: " + NumberFormat.getInstance().format(result));
        }
    }
    public Factorial setNumber(long number) {
        this.number = number;
        return this;
    }
}



