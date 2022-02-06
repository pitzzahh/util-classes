package lib.computing.mathematicsOfFinance.variables;

public class Fields {

    // Cannot instantiate this class

    /**
     * Simple Interest
     */
    protected static  double I;

    /**
     * Principal, total amount invested
     */
    protected static  double P;

    /**
     * Rate field
     */
    protected static  double r;

    /**
     * Time field
     */
    protected static  double t;

    /**
     * Field that determines if year or month
     */
    protected static String yearOrMonth;

    /**
     * Simple Discount field
     */
    protected static double D;

    /**
     * Amount of Maturity field
     */
    protected static double F;

    /**
     * discount rate field
     */
    protected static double d;

    /**
     * Principal field
     */
    protected static double principal;

    /**
     * Rate
     */
    protected static double rate;

    /**
     * Days field
     */
    protected static int days;

    /**
     * Ordinary Interest field
     */
    protected static double Io;

    /**
     * Exact Interest field
     */
    protected static double Ie;

    /**
     * Actual Time for the month of February
     */
    protected static final byte ACTUAL_TIME_FOR_MONTHS_OF_FEBRUARY = 28;

    /**
     * Approximate Time for all months except February
     */
    protected static final byte APPROXIMATE_TIME_DAYS_IN_MONTHS = 30;

    /**
     * Actual Time for all months except February
     */
    protected static final byte ACTUAL_TIME_DAYS_IN_MONTHS = 31;

    /**
     * Month name for first month
     */
    protected static String startingMonth;

    /**
     * Day for first month
     */
    protected static short startingDay;

    /**
     * Year for first month
     */
    protected static short startingYear;

    /**
     * Month for last month
     */
    protected static String endingMonth;

    /**
     * Day for last month
     */
    protected static short endingDay;

    /**
     * Year for last month
     */
    protected static short endingYear;

    /**
     * Count for first month
     */
    protected static byte positionOfStartingMonth;

    /**
     * Count for last month
     */
    protected static byte positionOfEndingMonth;

    /**
     * New position if starting year is not the same as the ending year
     */
    protected static byte newEndingMonthPosition;

    /**
     * Total count of actual days
     */
    protected static short totalCountOfActualDays;

    /**
     * Total count of approximated days
     */
    protected static short totalCountOfApproximateDays;

    /**
     * MONTHS array
     */
    protected static String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP","OCT", "NOV", "DEC"};
}
