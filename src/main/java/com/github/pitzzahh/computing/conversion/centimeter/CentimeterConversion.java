package com.github.pitzzahh.computing.conversion.centimeter;

import java.util.Scanner;
import com.github.pitzzahh.utilities.validation.Validator;
import com.github.pitzzahh.computing.conversion.Conversions;

public final class CentimeterConversion extends Conversions {
    /**
     * Cannot instantiate this class.
     */
    private CentimeterConversion() {
        super();
    }
    /**
     * This method runs the conversion
     */
	public static void runCentimeterConversion() {
        byte choice;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Input Centimeter: ");
            temporaryString = input.next().trim();
            if (Validator.isWholeNumber().apply(temporaryString)) {
                CENTIMETER = Integer.parseInt(temporaryString);
                break;
            }
            else if (Validator.isDecimalNumber().apply(temporaryString)) {
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
            if (Validator.isDecimalNumber().apply(temporaryString)) {
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
