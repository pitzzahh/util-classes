package lib.recursion.factorial;

import java.text.NumberFormat;

public final class Factorial {
    private int number;
    private int factorial(int number) {
        if (number != 0) {
            return number * factorial(number - 1);
        }
        else {
            return 1;
        }
    }
    public void getFactorial() {
        int result = factorial(number);
        if (number == 0) {
            System.out.println("The Factorial of " + this.number + " is: " + 0);
        }
        else {
            System.out.println("The Factorial of " + this.number + " is: " + NumberFormat.getInstance().format(result));
        }
    }
    public Factorial setNumber(int number) {
        this.number = number;
        return this;
    }
}



