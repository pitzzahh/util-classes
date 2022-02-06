package lib.computing.mathematicsOfFinance.simpleInterest;

import lib.computing.mathematicsOfFinance.variables.Fields;

public final class SimpleInterest extends Fields{

    public boolean isSimpleInterest = false;
    public boolean isMaturityValue = false;
    public boolean isPrincipal = false;
    public boolean isRate = false;
    public boolean isTime = false;

    /**
     * @return the simple interest computation
     */
    public double getSimpleInterest() {
        isSimpleInterest = true;
        return P * r * t;
    }

    /**
     * @return the principal computation
     */
    public double getPrincipal() {
        isPrincipal = true;
        return I / (r * t);
    }

    /**
     * @return the rate computation
     */
    public double getRate() {
        isRate = true;
        return I / (P * t);
    }

    /**
     * @return the time computation
     */
    public double getTime() {
        isTime = true;
        return I / (P * r);
    }

    /**
     * @return the maturity value computation
     */
    public double getMaturityValue() {
        isMaturityValue = true;
        return P * (1 + r * t);
    }

    /**
     * sets the value for simpleInterest
     * @param simpleInterest the simple interest
     */
    public SimpleInterest setSimpleInterest(double simpleInterest) {
        I = simpleInterest;
        return this;
    }

    /**
     * sets the value for principal
     * @param principal the principal value
     */
    public SimpleInterest setPrincipal(double principal) {
        P = principal;
        return this;
    }

    /**
     * sets the value for rate
     * @param rate the rate
     */
    public SimpleInterest setRate(double rate) {
        r = rate/100;
        return this;
    }

    /**
     * sets the value for time
     * @param time the time to be set
     * @param type if it is a YEAR or a MONTH
     */
    public SimpleInterest setTime(double time, String type) {
        yearOrMonth = type.toUpperCase();
        switch (yearOrMonth) {
            case "YEARS" -> t = time;
            case "MONTHS" -> t = time / 12;
        }
        return this;
    }
}
