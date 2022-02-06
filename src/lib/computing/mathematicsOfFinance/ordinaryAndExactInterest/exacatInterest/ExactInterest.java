package lib.computing.mathematicsOfFinance.ordinaryAndExactInterest.exacatInterest;

import lib.computing.mathematicsOfFinance.variables.Fields;

public final class ExactInterest extends Fields{

    /**
     * sets the value for Principal
     */
    public ExactInterest setPrincipal(double p) {
        principal = p;
        return this;
    }

    /**
     * sets the value for rate
     */
    public ExactInterest setRate(double r) {
        rate = r / 100;
        return this;
    }

    /**
     * sets the value for day
     */
    public void setDays(int d) {
        days = d;
    }

    /**
     * COMPUTE EXACT INTEREST USING ACTUAL TIME
     */
    private void exactInterestUsingActualTime() {
        double t = (double) days / 365;
        Ie = principal * rate * t;
    }

    /**
     * COMPUTE EXACT INTEREST USING APPROXIMATE TIME
     */
    private void exactInterestUsingApproximateTime() {
        double t = (double) days / 365;
        Ie = principal * rate * t;
    }
    /**
     * COMPUTE USING ACTUAL TIME
     */
    public double getExactInterestUsingActualTime() {
        exactInterestUsingActualTime();
        return Ie;
    }
    /**
     * COMPUTE USING APPROXIMATE TIME
     */
    public double getExactInterestUsingApproximateTime() {
        exactInterestUsingApproximateTime();
        return Ie;
    }
}
