package lib.computing.mathematicsOfFinance.simpleDiscount;

import lib.computing.mathematicsOfFinance.variables.Fields;

public final class SimpleDiscount extends Fields{

    public boolean isTimeOrTermOfDiscount = false;
    public boolean isAmountOfMaturity = false;
    public boolean isSimpleDiscount = false;
    public boolean isDiscountRate = false;
    public boolean isPresentValue = false;

    /**
     * returns the simple discount computation
     */
    public double getSimpleDiscount() {
        isSimpleDiscount = true;
        return F * d * t;
    }

    /**
     * returns the P computation
     */
    public double getPresentValue() {
        isPresentValue = true;
        return F * (1 - d * t);
    }

    /**
     * returns the discount rate computation
     */
    public double getDiscountRate() {
        isDiscountRate = true;
        return d / (F * t);
    }

    /**
     * returns the time or term of discount computation
     */
    public double getTimeOrTermOfDiscount() {
        isTimeOrTermOfDiscount = true;
        return D / (F * d);
    }

    /**
     * returns the amount of maturity computation
     */
    public double getAmountOfMaturity() {
        isAmountOfMaturity = true;
        isDiscountRate = true;
        return D / (d * t);
    }

    /**
     * sets the value for simple discount
     */
    public SimpleDiscount setSimpleDiscount(double simpleDiscount) {
        D = simpleDiscount;
        return this;
    }

    /**
     * sets the value for amount of maturity
     */
    public SimpleDiscount setAmountOfMaturity(double amountOfMaturity) {
        F = amountOfMaturity;
        return this;
    }

    /**
     * sets the value for discount rate
     */
    public SimpleDiscount setDiscountRate(double discountRate) {
        d = discountRate;
        return this;
    }

    /**
     * sets the value for time or term of discount
     */
    public SimpleDiscount setTimeOrTermOfDiscount(double timeOrTermOfDiscount) {
        t = timeOrTermOfDiscount;
        return this;
    }
}
