package lib.computing.conversion.meter;

import lib.computing.conversion.Conversions;
import lib.utilities.misc.Loading;
import lib.utilities.misc.InputChecker;

import java.util.Scanner;

public final class MeterConversion extends Conversions {
    // Cannot instantiate this class
    private MeterConversion() {
        super();
    }
	public static void runMeterConversion() throws InterruptedException {
        byte choice;
        Scanner input = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            while (true) {
                System.out.print("Input Meter: ");
                temporaryString = input.next().trim();
                if (InputChecker.isInteger(temporaryString)) {
                    METER = Integer.parseInt(temporaryString);
                    break;
                }
                else if (InputChecker.isDouble(temporaryString)) {
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
                if (InputChecker.isByte(temporaryString)) {
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
            boolean check = true;
            while (check) {
                System.out.println("\nDO YOU WANT TO CONVERT AGAIN? ");
                System.out.println(": 1 : Yes");
                System.out.println(": 2 : No");
                System.out.print(">>>: ");
                temporaryString = input.next().trim();
                if (InputChecker.isInteger(temporaryString)) {
                    choice = Byte.parseByte(temporaryString);
                    switch (choice) {
                        case 1 -> {
                            check = false;
                            System.out.print("RETURNING TO MAIN MENU");
                            Loading.dotLoading();
                        }
                        case 2 -> {
                            check = false;
                            isExit = true;
                            System.out.print("EXITING THE PROGRAM");
                            Loading.dotLoading();
                        }
                    }
                }
                else {
                    System.out.println("PLEASE ENTER A NUMBER FROM THE CHOICES ABOVE");
                }
            }
        }

    input.close();
	}
}
