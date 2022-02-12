package lib.computing.conversion.centimeter;

import lib.computing.conversion.Conversions;
import lib.utilities.misc.InputChecker;
import java.util.Scanner;

public final class CentimeterConversion extends Conversions{
    /**
     * Cannot instantiate this class.
     */
    private CentimeterConversion() {
        super();
    }
    /**
     * This method runs the conversion
     * @throws InterruptedException if the thread is Interrupted
     */
	public static void runCentimeterConversion() throws InterruptedException {
        byte choice;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Input Centimeter: ");
            temporaryString = input.next().trim();
            if (InputChecker.isInteger(temporaryString)) {
                CENTIMETER = Integer.parseInt(temporaryString);
                break;
            }
            else if (InputChecker.isDouble(temporaryString)) {
                CENTIMETER_WITH_DECIMAL = Double.parseDouble(temporaryString);
                isDecimalNumber = true;
                break;
            }
            else {
                System.out.println("PLEASE ENTER A NUMBER");
            }
        }
        while (true) {
            System.out.println(": 1 : Convert Centimeter to Inch.");
            System.out.println(": 2 : Convert Centimeter to Meter.");
            System.out.println(": 3 : Convert Centimeter to Kilometer.");

            System.out.print("Choice: ");
            temporaryString = input.next().trim();
            if (InputChecker.isByte(temporaryString)) {
                choice = Byte.parseByte(temporaryString);
                break;
            }
            else {
                System.out.println("PLEASE ENTER A NUMBER FROM THE CHOICES ABOVE");
            }
        }
        switch (choice) {
            case 1 -> centimeterToInch();
            case 2 -> centimeterToMeter();
            case 3 -> centimeterToKilometer();
        }
        input.close();
	}
}
