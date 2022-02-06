package lib.computing.mathematicsOfFinance.ordinaryAndExactInterest.ordinaryInterest;

import lib.computing.mathematicsOfFinance.variables.Fields;

public final class OrdinaryInterest extends Fields{

    /**
     * sets the value for Principal
     */
    public OrdinaryInterest setPrincipal(double p) {
        principal = p;
        return this;
    }

    /**
     * sets the value for rate
     */
    public OrdinaryInterest setRate(double r) {
        rate = r / 100;
        return this;
    }

    /**
     * sets the value for days
     */
    public void setDays(int d) {
        days = d;
    }

    /**
     * COMPUTE ORDINARY INTEREST USING ACTUAL TIME
     */
    private void ordinaryInterestUsingActualTime() {
        double t = (double) days / 360;
        Io =  principal * rate * t;
    }

    /**
     * COMPUTE ORDINARY INTEREST USING APPROXIMATE TIME
     */
    private void ordinaryInterestUsingApproximateTime() {
        double t = (double) Fields.days / 360;
        Io =  principal * rate * t;
    }

    /**
     * GET THE ORDINARY INTEREST USING ACTUAL TIME
     */
    public double getOrdinaryInterestUsingActualTime() {
        ordinaryInterestUsingActualTime();
        return Io;
    }

    /**
     * GET THE ORDINARY INTEREST USING APPROXIMATE TIME
     */
    public double getOrdinaryInterestUsingApproximateTime() {
        ordinaryInterestUsingApproximateTime();
        return Io;
    }
}
