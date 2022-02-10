package lib.computing.daysBetweenDates.withLeapYear;
import java.util.Scanner;
/**
 * The {@code RemainingDaysWithLeapYear} class computes the remaining days between dates with leap years.
 */
public final class RemainingDaysWithLeapYear {
    /**
     * Run the program.
     */
    public static void run() {

        Scanner userInput = new Scanner(System.in);
        String month;
        byte day = 0;
        short year = 0;
        final byte NUMBER_OF_DAYS_IN_FEBRUARY_DURING_LEAP_YEAR = 29;
        final byte NUMBER_OF_DAYS_IN_FEBRUARY = 28;
        final byte THIRTY_ONE_DAYS = 31;
        final short CURRENT_YEAR = 2021;
        final byte THIRTY_DAYS = 30;
        boolean errorInDay = false;
        boolean dayCondition = true;
        boolean errorInYear = false;
        boolean errorInMonth = false;
        boolean yearCondition = true;

        System.out.println("|-----------------------------------|");
        System.out.println("|--------------GROUP_1--------------|");
        System.out.println("|-----------------------------------|");
        System.out.println("|-------WHEN IS YOUR BIRTHDAY?------|");
        System.out.println("|----------PLEASE TELL US-----------|");
        System.out.println("|-----------------------------------|");

        System.out.print("Enter Month: ");
        month = userInput.nextLine().toUpperCase();
        if (!month.equals("JANUARY")   && !month.equals("FEBRUARY") &&
            !month.equals("MARCH")     && !month.equals("APRIL")    &&
            !month.equals("MAY")       && !month.equals("JUNE")     &&
            !month.equals("JULY")      && !month.equals("AUGUST")   &&
            !month.equals("SEPTEMBER") && !month.equals("OCTOBER")  &&
            !month.equals("NOVEMBER")  && !month.equals("DECEMBER")) {
            dayCondition = false;
            yearCondition = false;
            errorInMonth = true;
        }
        if (dayCondition) {
            switch (month) {
                case "FEBRUARY" -> {
                    System.out.print("Enter Day: ");
                    day = userInput.nextByte();
                    if (day < 1 || day > NUMBER_OF_DAYS_IN_FEBRUARY_DURING_LEAP_YEAR) {
                        errorInDay = true;
                        yearCondition = false;
                    }
                }
                case "JANUARY", "MARCH", "MAY", "JULY", "AUGUST", "OCTOBER", "DECEMBER" -> {
                    System.out.print("Enter Day: ");
                    day = userInput.nextByte();
                    if (day < 1 || day > THIRTY_ONE_DAYS) {
                        errorInDay = true;
                        yearCondition = false;
                    }
                }
                case "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER" -> {
                    System.out.print("Enter Day: ");
                    day = userInput.nextByte();
                    if (day < 1 || day > THIRTY_DAYS) {
                        yearCondition = false;
                        errorInDay = true;
                    }
                }
                default -> {
                    errorInDay = true;
                    System.out.println("INVALID DAY");
                }
            }
        }
        if (yearCondition) {
            System.out.print("Enter Year: ");
            year = userInput.nextShort();
            if (year < 1980 || year > CURRENT_YEAR) {
                errorInYear = true;
            }
            if (year == 1996 || year == 2000 ||
                year == 2004 || year == 2008 ||
                year == 2012 || year == 2016 ||
                year == 2020) {
                System.out.println("IT IS LEAP YEAR");
            }
            else  {
                if (day == 29 && month.equals("FEBRUARY")) {
                    errorInDay = true;
                }
            }
        }
        if (errorInYear) {
            System.out.println("ERROR IN YEAR");
            System.out.println("UNKNOWN YEAR: " + year);
        }
        else if (errorInMonth) {
            System.out.println("ERROR IN MONTH");
            System.out.println("UNKNOWN MONTH: " + month);
        }
        else if (errorInDay) {
            System.out.println("ERROR IN DAY");
            switch (month) {
                case "FEBRUARY" -> {
                    if (day >= 1 && day <= NUMBER_OF_DAYS_IN_FEBRUARY_DURING_LEAP_YEAR) {
                        System.out.println("IT IS NOT LEAP YEAR");
                        System.out.println("THE MONTH IS " + month + "\nTHE DAY SHOULD BE BETWEEN 1 AND " + NUMBER_OF_DAYS_IN_FEBRUARY);
                        System.out.println("INPUTTED DAY: " + day);
                    }
                    else {
                        System.out.println("THE MONTH IS " + month + "\nTHE DAY SHOULD BE BETWEEN 1 AND " + NUMBER_OF_DAYS_IN_FEBRUARY);
                        System.out.println("INPUTTED DAY: " + day);
                    }
                }
                case "JANUARY", "MARCH", "MAY", "JULY", "AUGUST", "OCTOBER", "DECEMBER" -> {
                    System.out.println("THE MONTH IS " + month + "\nTHE DAY SHOULD BE BETWEEN 1 AND 31");
                    System.out.println("INPUTTED DAY: " + day);
                }
                case "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER" -> {
                    System.out.println("THE MONTH IS " + month + "\nTHE DAY SHOULD BE BETWEEN 1 AND 30");
                    System.out.println("INPUTTED DAY: " + day);
                }
            }
        }
        else {
            System.out.printf("YOUR BIRTHDATE IS %s %d, %d.", month, day, year);
            byte age = (byte) (CURRENT_YEAR - year);
            System.out.println("\nYOUR AGE IN THE YEAR " + CURRENT_YEAR +" IS: " + age + " years old");
        }
    }
}