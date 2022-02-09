package lib.computing.mathematicsOfFinance.actualTimeAndApproximateTime;

import lib.computing.mathematicsOfFinance.actualTimeAndApproximateTime.approximateTime.ApproximateTime;
import lib.computing.mathematicsOfFinance.actualTimeAndApproximateTime.actualTime.ActualTime;
import lib.computing.mathematicsOfFinance.variables.Fields;
import lib.utilities.InputChecker;
import java.util.Scanner;

public final class ComputeActualTimeAndApproximateTime extends Fields {
    static String startingMonth;
    static byte startingDay;
    static short startingYear;
    static String endingMonth;
    static byte endingDay;
    static short endingYear;
    static String temporaryString;
    static String computationChoice;
    static boolean isExit = false;
    static boolean userInputs;
    static boolean isFebruary = false;
    static boolean actualTimeCondition = false;
    static boolean approximateTimeCondition = false;
    static boolean retryLoop = true;
    static boolean inputMonthsLoop = true;
    static boolean inputDaysLoop = true;
    static boolean inputYearsLoop = true;
    public void run() {
        Scanner scanner = new Scanner(System.in);
        actualTimeAndApproximateTimeComputation(scanner);
    } // end of main method
    /**
     * @param scanner user input
     * @see ActualTime#computeActualTime()
     */
    private static void actualTimeAndApproximateTimeComputation(Scanner scanner) {
        while (!isExit) {
            System.out.println("WHAT COMPUTATION DO YOU WANT TO DO?");
            System.out.println("FOR ACTUAL TIME COMPUTATION TYPE : ACT :");
            System.out.println("FOR APPROXIMATE TIME COMPUTATION TYPE : APP :");
            System.out.print(">>>: ");
            temporaryString = scanner.nextLine().toUpperCase().trim();
            computationChoice = temporaryString;

            switch (computationChoice) {
                case "ACT" -> {
                    userInputs = true;
                    actualTimeCondition = true;
                }
                case "APP" -> {
                    userInputs = true;
                    approximateTimeCondition = true;
                }
                default -> {
                    System.out.println("INVALID CHOICE (!)");
                    System.out.println("THE PROGRAM WILL EXIT");
                    isExit = true;
                    retryLoop = false;
                }
            }
            while (userInputs) {
                // months
                while (inputMonthsLoop) {
                    byte i = 1;
                    while (i <= 2) {
                        boolean isMonth = false;
                        switch (i) {
                            case 1 -> {
                                System.out.print("Enter starting Month: ");
                                temporaryString = scanner.nextLine().toUpperCase().trim();
                                startingMonth = temporaryString;
                            }
                            case 2 -> {
                                System.out.print("Enter ending Month: ");
                                temporaryString = scanner.nextLine().toUpperCase().trim();
                                endingMonth = temporaryString;
                            }
                        }
                        switch (i) {
                            case 1 -> {
                                try {
                                    for (String months : months) {
                                        if (startingMonth.substring(0, 3).matches(months)) {
                                            isMonth = true;
                                            break;
                                        }
                                    }
                                } catch (StringIndexOutOfBoundsException ignored) {
                                }
                                if (isMonth) {
                                    if (startingMonth.substring(0, 3).matches("FEB")) {
                                        isFebruary = true;
                                    }
                                    inputMonthsLoop = false;
                                    i++;
                                } else {
                                    System.out.println("INVALID MONTH");
                                }
                            }
                            case 2 -> {
                                try {
                                    for (String months : months) {
                                        if (endingMonth.substring(0, 3).matches(months)) {
                                            isMonth = true;
                                            break;
                                        }
                                    }
                                } catch (StringIndexOutOfBoundsException ignored) {
                                }
                                if (isMonth) {
                                    if (endingMonth.substring(0, 3).matches("FEB")) {
                                        isFebruary = true;
                                    }
                                    inputMonthsLoop = false;
                                    i++;
                                } else {
                                    System.out.println("INVALID MONTH");
                                }
                            }
                        }
                    }
                }
                while (inputDaysLoop) {
                    byte j = 1;
                    while(j <= 2){
                        if (isFebruary) {
                            switch (j) {
                                case 1:
                                    try {
                                        if (startingMonth.substring(0, 3).matches("FEB")) {
                                            System.out.println("The starting month is February, the day should only between 1 and 28");
                                            System.out.print("Enter starting day: ");
                                        }
                                        else {
                                            System.out.print("Enter starting day: ");
                                        }
                                        temporaryString = scanner.nextLine().trim();
                                        startingDay = Byte.parseByte(temporaryString);
                                    } catch (NumberFormatException ignored) {
                                        System.out.println("THAT IS NOT A DAY");
                                    }
                                    break;
                                case 2:
                                    try {
                                        if (endingMonth.substring(0, 3).matches("FEB")) {
                                            System.out.println("The ending month is February, the day should only between 1 and 28");
                                            System.out.print("Enter ending day: ");
                                        }
                                        else {
                                            System.out.print("Enter ending day: ");
                                        }
                                        temporaryString = scanner.nextLine().trim();
                                        endingDay = Byte.parseByte(temporaryString);
                                    } catch (NumberFormatException ignored) {
                                        System.out.println("THAT IS NOT A DAY");
                                    }
                                break;
                            }
                            if (InputChecker.isByte(temporaryString)) {
                                if (temporaryString.length() == 1 || temporaryString.length() == 2) {
                                    switch (j) {
                                        case 1:
                                            if (startingDay >= 1 && startingDay <= 28) {
                                                inputDaysLoop = false;
                                                j++;
                                            } 
                                            else {
                                                System.out.println("FEBRUARY ONLY HAVE 28 days");
                                            }
                                            break;
                                        case 2:
                                            if (endingDay >= 1 && endingDay <= 28) {
                                                inputDaysLoop = false;
                                                j++;
                                            } 
                                            else {
                                                System.out.println("FEBRUARY ONLY HAVE 28 days");
                                            }
                                        break;
                                    }
                                } 
                                else {
                                    System.out.println("A DAY ONLY HAVE ONE OR TWO DIGITS");
                                }
                            } 
                            else {
                                System.out.println("PLEASE ENTER THE FIELDS PROPERLY");
                            }
                        }
                        else{
                            switch (j) {
                                case 1 -> {
                                    System.out.print("Enter starting day: ");
                                    temporaryString = scanner.nextLine().trim();
                                    startingDay = Byte.parseByte(temporaryString);
                                }
                                case 2 -> {
                                    System.out.print("Enter ending day: ");
                                    temporaryString = scanner.nextLine().trim();
                                    endingDay = Byte.parseByte(temporaryString);
                                }
                            }
                            if (InputChecker.isByte(temporaryString)) {
                                switch (j) {
                                    case 1:
                                        if (startingMonth.substring(0,3).matches("APR") || 
                                            startingMonth.substring(0,3).matches("JUN") || 
                                            startingMonth.substring(0,3).matches("SEP") || 
                                            startingMonth.substring(0,3).matches("NOV")) {
                                            if (startingDay >= 1 && startingDay <= 30) {
                                                inputDaysLoop = false;
                                                j++;
                                            } 
                                            else {
                                                System.out.println("THE MONTH OF APRIL, JUNE, SEPTEMBER, AND NOVEMBER ONLY HAVE 30 DAYS");
                                                startingDay = 0;
                                            }
                                        }
                                        else {
                                            if (startingDay >= 1 && startingDay <= 31) {
                                                inputDaysLoop = false;
                                                j++;
                                            } 
                                            else {
                                                System.out.println("THE MONTH OF JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, AND DECEMBER\nONLY HAVE 31 DAYS");
                                                startingDay = 0;
                                            }
                                        }
                                        break;
                                    case 2:
                                        if (endingMonth.substring(0,3).matches("APR") || 
                                            endingMonth.substring(0,3).matches("JUN") || 
                                            endingMonth.substring(0,3).matches("SEP") || 
                                            endingMonth.substring(0,3).matches("NOV")
                                            ) {
                                            if (endingDay >= 1 && endingDay <= 30) {
                                                inputDaysLoop = false;
                                                j++;
                                            } 
                                            else {
                                                System.out.println("THE MONTH OF APRIL, JUNE, SEPTEMBER, AND NOVEMBER ONLY HAVE 30 DAYS");
                                                endingDay = 0;
                                            }
                                        }
                                        else {
                                            if (endingDay >= 1 && endingDay <= 31) {
                                                inputDaysLoop = false;
                                                j++;
                                            } 
                                            else {
                                                System.out.println("THE MONTH OF JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, AND DECEMBER\nONLY HAVE 31 DAYS");
                                                endingDay = 0;
                                            }
                                        }
                                    break;
                                }                         
                            } 
                            else {
                                System.out.println("PLEASE ENTER THE FIELDS PROPERLY");
                            }
                        }
                    }
                }
                while (inputYearsLoop) {
                    byte k = 1;
                    while (k <= 2) {
                        switch (k) {
                            case 1 -> System.out.print("Enter starting year: ");
                            case 2 -> System.out.print("Enter ending year: ");
                        }
                        temporaryString = scanner.nextLine().trim();
                        if (InputChecker.isShort(temporaryString)) {
                            if (temporaryString.length() == 4) {
                                switch (k) {
                                    case 1 -> {
                                        startingYear = Short.parseShort(temporaryString);
                                        inputYearsLoop = false;
                                        k++;
                                    }
                                    case 2 -> {
                                        endingYear = Short.parseShort(temporaryString);
                                        inputYearsLoop = false;
                                        k++;
                                    }
                                }
                            }
                            else {
                                System.out.println("A YEAR ONLY HAVE 4 DIGITS");
                            }
                        } 
                        else {
                            System.out.println("PLEASE ENTER THE FIELDS PROPERLY");
                        }
                    }
                }
                if (!inputMonthsLoop && !inputDaysLoop) {
                    userInputs = false;
                } 
            } // end of userInputs loop
            if (actualTimeCondition) {
                System.out.println("----------------------------------------");
                ActualTime actualTime = new ActualTime();
                actualTime.setMonth(startingMonth, endingMonth)
                          .setDay(startingDay, endingDay)
                          .setYear(startingYear, endingYear)
                          .computeActualTime();
                System.out.printf("\nFROM %s %d, %d to %s %d, %d", startingMonth, startingDay, startingYear, endingMonth,  endingDay,  endingYear);
                System.out.printf("\nTHE TOTAL ACTUAL TIME IS : %d days", totalCountOfActualDays);
            }
            else if(approximateTimeCondition) {
                System.out.println("----------------------------------------");
                ApproximateTime approximateTime = new ApproximateTime();
                approximateTime.setMonth(startingMonth, endingMonth)
                               .setDay(startingDay, endingDay)
                               .setYear(startingYear, endingYear)
                               .getApproximateTime();
                System.out.printf("\nFROM %s %d, %d to %s %d, %d", startingMonth, startingDay, startingYear, endingMonth,  endingDay,  endingYear);
                System.out.printf("\nTHE TOTAL APPROXIMATE TIME IS : %d days", totalCountOfApproximateDays);
            }
            while (retryLoop) {
                System.out.println("\nDO YOU WANT TO TAKE ANOTHER COMPUTATION ?");
                System.out.println(": Y : for yes : N : for no");
                System.out.print(">>>: ");
                temporaryString = scanner.nextLine().toUpperCase().trim();
                char retryChoice = temporaryString.charAt(0);
                switch (retryChoice) {
                    case 'Y' -> retryLoop = false;
                    case 'N' -> {
                        retryLoop = false;
                        isExit = true;
                        scanner.close();
                    }
                    default -> System.out.println("INVALID CHOICE");
                }
            }
            resetFields();
        } // end of isExit loop
    }// end of actualAndApproximateComputations
    private static void resetFields() {
        retryLoop = true;
        userInputs = false;
        actualTimeCondition = false;
        approximateTimeCondition = false;
        inputMonthsLoop = true;
        inputDaysLoop = true;
        inputYearsLoop = true;
        totalCountOfActualDays = 0;
        totalCountOfApproximateDays = 0;
    }
}