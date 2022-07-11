package com.github.pitzzahh.computing.conversion.meter;

import java.util.Scanner;
import com.github.pitzzahh.utilities.validation.Validator;
import com.github.pitzzahh.computing.conversion.Conversions;

public final class MeterConversion extends Conversions {
    /**
     * Cannot instantiate this class.
     */
    private MeterConversion() {
        super();
    }
	public static void runMeterConversion() {
        byte choice;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Input Meter: ");
            temporaryString = input.next().trim();
            if (Validator.isWholeNumber().apply(temporaryString)) {
                METER = Integer.parseInt(temporaryString);
                break;
            }
            else if (Validator.isDecimalNumber().apply(temporaryString)) {
                METER_WITH_DECIMAL = Double.parseDouble(temporaryString);
                isDecimalNumber = true;
                break;
            }
            else {
                System.out.println("PLEASE ENTER A NUMBER");
            }
        }
        while (true) {
            System.out.println(": 1 : Convert Meter to Inch.");
            System.out.println(": 2 : Convert Meter to Centimeter.");
            System.out.println(": 3 : Convert Meter to Kilometer.");

            System.out.print("Choice: ");
            temporaryString = input.next().trim();
            if (Validator.isWholeNumber().apply(temporaryString)) {
                choice = Byte.parseByte(temporaryString);
                break;
            }
            else {
                System.out.println("PLEASE ENTER A NUMBER FROM THE CHOICES ABOVE");
            }
        }
        switch (choice) {
            case 1 -> meterToInch();
            case 2 -> meterToCentimeter();
            case 3 -> meterToKilometer();
        }
        input.close();
	}
}
