package lib.computing.conversion;

public class Conversions {
    // Cannot instantiate this class
    protected Conversions() {}

    protected static int CENTIMETER = 0;
    protected static double CENTIMETER_WITH_DECIMAL = 0;
    protected static int METER = 0;
    protected static double METER_WITH_DECIMAL = 0;
    protected static String temporaryString;
    protected static boolean isDecimalNumber = false;

    // CENTIMETER CONVERSIONS

    /**
     * Converts centimeter to inch
     */
    protected static void centimeterToInch() {
        if (isDecimalNumber) {
            System.out.printf(CENTIMETER_WITH_DECIMAL + " cm to inch is %.8f in.", CENTIMETER_WITH_DECIMAL / 2.54);
        }
        else {
            System.out.printf(CENTIMETER + " cm to inch is %.8f in.", CENTIMETER / 2.54);
        }
    }
    /**
     * Converts centimeter to meter
     */
    protected static void centimeterToMeter() {
        if (isDecimalNumber) {
            System.out.printf(CENTIMETER_WITH_DECIMAL + " cm to meter is %.8f m.", CENTIMETER_WITH_DECIMAL / 100);
        }
        else {
            System.out.printf(CENTIMETER + " cm to meter is %.8f m.", CENTIMETER / 100);
        }
    }
    /**
     * Converts centimeter to kilometer
     */
    protected static void centimeterToKilometer() {
        if (isDecimalNumber) {
            System.out.printf(CENTIMETER_WITH_DECIMAL + " cm to kilometer is %.8f km.", CENTIMETER_WITH_DECIMAL / 100000);
        }
        else {
            System.out.printf(CENTIMETER + " cm to kilometer is %.8f km.", CENTIMETER / 100000);
        }
    }

    // METER CONVERSIONS

    /**
     * Converts meter to inch
     */
    protected static void meterToInch() {
        if (isDecimalNumber) {
            System.out.printf(METER_WITH_DECIMAL + " m to inch is %.8f in.", METER_WITH_DECIMAL / 39.3700787);
        }
        else {
            System.out.printf(METER + " m to inch is %.8f in.", METER / 39.3700787);
        }
    }
    /**
     * Converts meter to centimeter
     */
    protected static void meterToCentimeter() {
        if (isDecimalNumber) {
            System.out.printf(METER_WITH_DECIMAL + "meter to centimeter is %.8f cm.", METER_WITH_DECIMAL * 100);
        }
        else {
            System.out.printf(METER + "meter to meter is %.8f cm.", METER * 100);
        }
    }
    /**
     * Converts meter to kilometer
     */
    protected static void meterToKilometer() {
        if (isDecimalNumber) {
            System.out.printf(METER_WITH_DECIMAL + "meter to kilometer is %.8f km.", METER_WITH_DECIMAL / 1000);
        }
        else {
            System.out.printf(METER + "meter to kilometer is %.8f km.", METER / 1000);
        }
    }
    protected static void meterToMillimeter() {
        if (isDecimalNumber) {
            System.out.printf(METER_WITH_DECIMAL + "meter to millimeter is %.8f mm.", METER_WITH_DECIMAL * 1000);
        }
        else {
            System.out.printf(METER + "meter to millimeter is %.8f mm.", METER * 1000);
        }
    }
}
