package lib.computing.daysBetweenDates.noLeapYear;

import java.util.Scanner;

/**
 * The {@code RemainingDaysNoLearYear} class computes the remaining days between dates without adding leap years.
 */
public class RemainingDaysNoLearYear {
    /**
     * Run the program.
     */
    public static void run() {

        /*  Scanner Object
         *  NAME FOR THE Scanner IS userInput
         */
        Scanner userInput = new Scanner(System.in);
        String month;        //   WE STORE OUR month INPUT HERE.
        byte day = 0;        //   WE STORE OUR day INPUT HERE.
        short year = 0;      //   WE STORE OUR year INPUT HERE.
        final byte NUMBER_OF_DAYS_IN_FEBRUARY = 28;     //    final byte FIELD, THIS CONTAINS THE NUMBER OF DAYS IN FEBRUARY, THAT WILL BE USED LATER ON.
        final short CURRENT_YEAR = 2022;                //    final byte FIELD, THIS CONTAINS THE CURRENT YEAR, THAT WILL BE USED LATER ON.
        final byte THIRTY_DAYS = 30;                    //    final byte FIELD, THIS CONTAINS THE DAYS OF SOME MONTHS, THAT DOES NOT HAVE 31 DAYS.
        final byte THIRTY_ONE_DAYS = 31;                //    final byte FIELD, THIS CONTAINS THE DAYS OF SOME MONTHS, THAT DOES HAVE 31 DAYS.
        /*  WE USE THIS FIELDS (dayCondition, yearCondition) IN ORDER TO PROCEED INTO THE NEXT STEP OF INPUTTING DATA,
         *  ORDER OF INPUTTING DATA = month -> day -> year, IF month INPUT ENCOUNTERED ERRORS,
         *  WE CHANGE THIS CONDITIONS TO false.
         */
        boolean dayCondition = true;
        boolean yearCondition = true;

        /*  IF THE USER ACCIDENTALLY INPUTTED INVALID month DATA,
         *  THIS BECAME true, AND THE dayCondition, AS WELL AS yearCondition BECOMES false
         *  WE NEED TO CHANGE THE VALUE OF THOSE CONDITIONS TO false, IN ORDER TO LEAVE THE CONDITION WHERE THE USER WILL INPUT THE DATA FOR "day" AND "year".
         *  AND ALSO FOR THE PROGRAM TO PROCEED AT THE BOTTOM.
         *  AT THE END OF THE PROGRAM, THERE IS A MULTIPLE SELECTIONS (if).
         *  IF THE VALUE OF errorInMonth BECAME true, IT WILL ENTER THE CONDITION BELOW AND STATE WHEN DID THE USER ENCOUNTERED THE PROBLEM.
         */
        boolean errorInMonth = false;
        /*  IF THE USER ACCIDENTALLY INPUTTED INVALID day DATA,
         *  THIS BECAME true, AND THE yearCondition BECOMES false
         *  WE NEED TO CHANGE THE VALUE OF THIS CONDITION TO false, IN ORDER TO LEAVE THE CONDITION WHERE THE USER WILL INPUT THE DATA "year".
         *  AND ALSO IN ORDER FOR THE PROGRAM TO PROCEED AT THE BOTTOM,
         *  AT THE END OF THE PROGRAM, THERE IS A MULTIPLE SELECTIONS (if).
         *  IF THE VALUE OF errorInDay BECAME true, IT WILL ENTER THE CONDITION BELOW AND STATE WHEN DID THE USER ENCOUNTERED THE PROBLEM.
         */
        boolean errorInDay = false;
        /*  IF THE USER ACCIDENTALLY INPUTTED INVALID year DATA,
         *  THIS BECAME true, AND THE yearCondition BECOMES false
         *  AT THE END OF THE PROGRAM, THERE IS A MULTIPLE SELECTIONS (if).
         *  IF THE VALUE OF errorInYear BECAME true, IT WILL ENTER THE CONDITION BELOW AND STATE WHEN DID THE USER ENCOUNTERED THE PROBLEM.
         */
        boolean errorInYear = false;

        System.out.println("|-----------------------------------|");
        System.out.println("|--------------GROUP_1--------------|");
        System.out.println("|-----------------------------------|");
        System.out.println("|-------WHEN IS YOUR BIRTHDAY?------|");
        System.out.println("|----------PLEASE TELL US-----------|");
        System.out.println("|-----------------------------------|");

        System.out.print("Enter Month: "); // WE USED THE print() METHOD SO THAT OUR INPUT WILL BE AT THE SAME LINE AS THIS PRINT STATEMENT
        /*
         *  THE PROGRAM WILL PAUSE HERE TO ASK FOR USER INPUT FOR "month".
         *  WE USE THE nextLine() METHOD FROM THE Scanner CLASS, BECAUSE WE ARE ASKING FOR String INPUTS,
         *  AND ALSO, WE ARE STORING THE INPUTTED DATA TO A String VARIABLE.
         *  WE ALSO PUT A DOT '.' AFTER THE nextLine() METHOD. THIS IS CALLED METHOD CHAINING.
         *  AFTER WE TAKE INPUTS, THE INPUTTED DATA WILL BE RETURNED AS AN UPPERCASE String AND STORE IT IN THE month VARIABLE NAME
         */
        month = userInput.nextLine().toUpperCase();
        /*
         *  THIS CONDITION CHECKS IF THE USER INPUTS DOES NOT MATCH ANY OF THE CONDITION
         *  WHICH ARE THE MONTHS IN A YEAR IN UPPERCASE
         *  IT IS UPPERCASE BECAUSE AT LINE 65, WE USED THE toUpperCase() METHOD FROM THE String CLASS
         *  IF THE MONTH INPUT DOES NOT MATCH FROM ANY OF THE CONDITION, THE EXECUTION WILL ENTER THE if STATEMENT
         *  AND EXECUTES THE STATEMENTS INSIDE ITS BODY
         *  THE dayCondition, yearCondition BECOMES false,
         *  SO THAT WE WILL LEAVE THE CONDITION WHERE THE USER WILL INPUT THE DATA "day" AND "year".
         *  AND ALSO THE errorInYear BECOMES true, SO THAT THE PROGRAM CAN IDENTIFY WHERE DOES THE ERROR OCCUR.
         *  AT THE END OF THE PROGRAM
         */
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
        // here
        /*
         *  THE EXECUTION WILL ENTER THIS if STATEMENT, IF THE USER DOES NOT INPUT INVALID month DATA.
         *  THIS IS THE if STATEMENT WHERE THE USER WILL INPUT THE DATA FOR "day".
         */
        if (dayCondition) {
            /*
             *  THIS SWITCH STATEMENT WILL IDENTIFY WHAT "month" DOES THE USER INPUTS
             */
            switch (month) {
                case "FEBRUARY" -> {
                    /*
                     *  IF THE month IS FEBRUARY, THE EXECUTION WILL ENTER THIS case
                     *  THE case IS UPPERCASE BECAUSE AT LINE 65, WE USED THE toUpperCase() METHOD FROM THE String CLASS
                     *  AND THE VALUE OF month IS IN UPPERCASE.
                     */
                    System.out.print("Enter Day: ");  // WE USED THE print() METHOD SO THAT OUR INPUT WILL BE AT THE SAME LINE AS THIS PRINT STATEMENT
                    /*
                     *  THE PROGRAM WILL PAUSE HERE AT LINE 109 TO ASK FOR USER INPUT FOR "day".
                     *  WE USE THE nextByte() METHOD FROM THE Scanner CLASS, BECAUSE WE ARE ASKING FOR byte INPUTS (numbers),
                     *  AND ALSO, WE ARE STORING THE INPUTTED DATA IN A byte VARIABLE.
                     */
                    day = userInput.nextByte();
                    /*
                     *  THIS IS A CONDITION THAT CHECKS IF THE "day" IS NOT A VALID "day" FOR FEBRUARY
                     *  THE "day" FOR FEBRUARY IS FROM 1 to NUMBER_OF_DAYS_IN_FEBRUARY (NUMBER_OF_DAYS_IN_FEBRUARY = 28)
                     *  IF THE "day" IS LESS THAN 0 OR GREATER THAN NUMBER_OF_DAYS_IN_FEBRUARY (NUMBER_OF_DAYS_IN_FEBRUARY = 28),
                     *  OR IN SHORT, IF THIS CONDITION EVALUATES TO true, IT WILL ENTER THE if STATEMENT
                     *  AND EXECUTES THE STATEMENTS yearCondition, AND errorInDay.
                     *  SO THAT WE WILL LEAVE THE CONDITION WHERE THE USER WILL INPUT THE DATA for "year".
                     *  AND ALSO THE errorInDay BECOMES true, SO THAT THE PROGRAM CAN IDENTIFY WHERE DOES THE ERROR OCCUR.
                     */
                    if (day < 1 || day > NUMBER_OF_DAYS_IN_FEBRUARY) {
                        yearCondition = false;
                        errorInDay = true;
                    }
                    // here
                }
                // here
                case "JANUARY", "MARCH", "MAY", "JULY", "AUGUST", "OCTOBER", "DECEMBER" -> {
                    /*
                     *  IF THE month IS JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, OR DECEMBER, THE EXECUTION WILL ENTER THIS case
                     *  THE case ARE IN UPPERCASE BECAUSE AT LINE 65, WE USED THE toUpperCase() METHOD FROM THE String CLASS
                     *  AND THE VALUE OF month IS IN UPPERCASE.
                     */
                    System.out.print("Enter Day: ");  // WE USED THE print() METHOD SO THAT OUR INPUT WILL BE AT THE SAME LINE AS THIS PRINT STATEMENT
                    /*
                     *  THE PROGRAM WILL PAUSE HERE TO ASK FOR USER INPUT FOR "day".
                     *  WE USE THE nextByte() METHOD FROM THE Scanner CLASS, BECAUSE WE ARE ASKING FOR byte INPUTS (numbers),
                     *  AND ALSO, WE ARE STORING THE INPUTTED DATA IN A byte VARIABLE.
                     */
                    day = userInput.nextByte();
                    /*
                     *  THIS IS A CONDITION THAT CHECKS IF THE "day" IS NOT A VALID "day" FOR FEBRUARY
                     *  THE "day" FOR FEBRUARY IS FROM 1 to THIRTY_ONE_DAYS (THIRTY_ONE_DAYS = 31)
                     *  IF THE "day" IS LESS THAN 0 OR GREATER THAN THIRTY_ONE_DAYS (THIRTY_ONE_DAYS = 31),
                     *  OR IN SHORT, IF THIS CONDITION EVALUATES TO true, IT WILL ENTER THE if STATEMENT
                     *  AND EXECUTES THE STATEMENTS yearCondition, AND errorInDay.
                     *  SO THAT WE WILL LEAVE THE CONDITION WHERE THE USER WILL INPUT THE DATA for "year".
                     *  AND ALSO THE errorInDay BECOMES true, SO THAT THE PROGRAM CAN IDENTIFY WHERE DOES THE ERROR OCCUR.
                     */
                    if (day < 1 || day > THIRTY_ONE_DAYS) {
                        yearCondition = false;
                        errorInDay = true;
                    }
                }
                case "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER" -> {
                    /*
                     *  IF THE month IS APRIL, JUNE, SEPTEMBER, OR NOVEMBER, THE EXECUTION WILL ENTER THIS case
                     *  THE case ARE IN UPPERCASE BECAUSE AT LINE 65, WE USED THE toUpperCase() METHOD FROM THE String CLASS
                     *  AND THE VALUE OF month IS IN UPPERCASE.
                     */
                    System.out.print("Enter Day: ");  // WE USED THE print() METHOD SO THAT OUR INPUT WILL BE AT THE SAME LINE AS THIS PRINT STATEMENT
                    /*
                     *  THE PROGRAM WILL PAUSE HERE TO ASK FOR USER INPUT FOR "day".
                     *  WE USE THE nextByte() METHOD FROM THE Scanner CLASS, BECAUSE WE ARE ASKING FOR byte INPUTS (numbers),
                     *  AND ALSO, WE ARE STORING THE INPUTTED DATA IN A byte VARIABLE.
                     */
                    day = userInput.nextByte();
                    /*
                     *  THIS IS A CONDITION THAT CHECKS IF THE DAY IS NOT A VALID DAY FOR FEBRUARY
                     *  THE "day" FOR FEBRUARY IS FROM 1 to THIRTY_DAYS (THIRTY_DAYS = 30)
                     *  IF THE "day" IS LESS THAN 0 OR GREATER THAN THIRTY_DAYS (THIRTY_DAYS = 30),
                     *  OR IN SHORT, IF THIS CONDITION EVALUATES TO true, IT WILL ENTER THE if STATEMENT
                     *  AND EXECUTES THE STATEMENTS yearCondition, AND errorInDay.
                     *  SO THAT WE WILL LEAVE THE CONDITION WHERE THE USER WILL INPUT THE DATA for "year".
                     *  AND ALSO THE errorInDay BECOMES true, SO THAT THE PROGRAM CAN IDENTIFY WHERE DOES THE ERROR OCCUR.
                     */
                    if (day < 1 || day > THIRTY_DAYS) {
                        yearCondition = false;
                        errorInDay = true;
                    }
                }
            }
            // here
        } // END OF dayCondition STATEMENT
        /*
         *  THE EXECUTION WILL ENTER THIS if STATEMENT, IF THE USER DOES NOT INPUT INVALID month DATA, AND day DATA.
         *  THIS IS THE if STATEMENT WHERE THE USER WILL INPUT THE DATA FOR "year":
         */
        if (yearCondition) {
            System.out.print("Enter Year: ");  // WE USED THE print() METHOD SO THAT OUR INPUT WILL BE AT THE SAME LINE AS THIS PRINT STATEMENT
            /*
             *  THE PROGRAM WILL PAUSE HERE TO ASK FOR USER INPUT FOR "year".
             *  WE USE THE nextShort() METHOD FROM THE Scanner CLASS, BECAUSE WE ARE ASKING FOR short INPUTS (numbers),
             *  AND ALSO, WE ARE STORING THE INPUTTED DATA IN A short VARIABLE.
             */
            year = userInput.nextShort();
            /*
             *  THIS IS A CONDITION THAT CHECKS IF THE "year" IS NOT A VALID "year"
             *  IF THE "year" IS LESS THAN 1980 OR GREATER THAN CURRENT_YEAR (CURRENT_YEAR = 2022),
             *  OR IN SHORT, IF THIS CONDITION EVALUATES TO true, IT WILL ENTER THE if STATEMENT
             *  AND EXECUTES THE STATEMENTS errorInYear TO false
             *  THE errorInYear BECOMES true, SO THAT THE PROGRAM CAN IDENTIFY WHERE DOES THE ERROR OCCUR.
             */
            if (year < 1980 || year > CURRENT_YEAR) {
                errorInYear = true;
            }
        } // END OF yearCondition STATEMENT
        /*
         *  IF THE VALUE OF errorInMonth IS CHANGED TO true DURING THE EXECUTION ABOVE, OR THE "month" THAT THE USER INPUTTED IS INVALID
         *  THE EXECUTION WILL ENTER THIS if STATEMENT AND PRINTS THE FOLLOWING INSIDE THE if STATEMENT BODY, AND ALSO PRINT OUT WHAT THE USER INPUTTED.
         */
        if (errorInMonth) {
            System.out.println("ERROR IN MONTH");
            System.out.println("INVALID MONTH: " + month.toLowerCase());
        }
        /*
         *  IF THE VALUE OF errorInDay IS CHANGED TO true DURING THE EXECUTION ABOVE, OR THE "month" THAT THE USER INPUTTED IS INVALID
         *  THE EXECUTION WILL ENTER THIS if STATEMENT AND PRINTS "ERROR IN DAY" ALSO IT WILL PROCEED TO THE switch STATEMENT
         */
        if (errorInDay) {
            System.out.println("ERROR IN DAY");
            /*
             *  THIS SWITCH STATEMENT WILL IDENTIFY WHAT "month" DOES THE USER INPUTS, AND THE "day" THAT WILL TO BE
             *  INPUTTED WILL DEPEND ON THE TOTAL DAYS OF THAT "month"
             */
            switch (month) {
                case "FEBRUARY" -> {
                    /*
                     *  IF THE month IS FEBRUARY, THE EXECUTION WILL ENTER THIS case
                     *  THE case IS UPPERCASE BECAUSE AT LINE 65, WE USED THE toUpperCase() METHOD FROM THE String CLASS
                     *  THIS PRINTS WHAT "month" DOES THE USER INPUTTED, AND TELLS THE USER HOW MANY DAYS SHOULD BE ON THAT MONTH.
                     *  IT ALSO OUTPUTS WHAT "day" THE USER INPUTTED.
                     */
                    System.out.println("THE MONTH IS " + month + "\nTHE DAY SHOULD BE BETWEEN 1 AND 28");
                    System.out.println("INPUTTED DAY: " + day);
                }
                case "JANUARY", "MARCH", "MAY", "JULY", "AUGUST", "OCTOBER", "DECEMBER" -> {
                    /*
                     *  IF THE month IS JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, OR DECEMBER, THE EXECUTION WILL ENTER THIS case
                     *  THE case ARE IN UPPERCASE BECAUSE AT LINE 65, WE USED THE toUpperCase() METHOD FROM THE String CLASS
                     *  THIS PRINTS WHAT "month" DOES THE USER INPUTTED, AND TELLS THE USER HOW MANY DAYS SHOULD BE ON THAT MONTH.
                     *  IT ALSO OUTPUTS WHAT "day" THE USER INPUTTED.
                     */
                    System.out.println("THE MONTH IS " + month + "\nTHE DAY SHOULD BE BETWEEN 1 AND 31");
                    System.out.println("INPUTTED DAY: " + day);
                }
                case "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER" -> {
                    /*
                     *  IF THE month IS APRIL, JUNE, SEPTEMBER, OR NOVEMBER, THE EXECUTION WILL ENTER THIS case
                     *  THE case ARE IN UPPERCASE BECAUSE AT LINE 65, WE USED THE toUpperCase() METHOD FROM THE String CLASS
                     *  THIS PRINTS WHAT "month" DOES THE USER INPUTTED, AND TELLS THE USER HOW MANY DAYS SHOULD BE ON THAT MONTH.
                     *  IT ALSO OUTPUTS WHAT "day" THE USER INPUTTED.
                     */
                    System.out.println("THE MONTH IS " + month + "\nTHE DAY SHOULD BE BETWEEN 1 AND 30");
                    System.out.println("INPUTTED DAY: " + day);
                }
            }
        }
        /*
         *  IF THE VALUE OF errorInYear IS CHANGED TO true DURING THE EXECUTION ABOVE.
         *  THE EXECUTION WILL ENTER THIS if STATEMENT AND PRINTS THE STATEMENTS INSIDE THE if STATEMENT BODY,
         *  IT ALSO OUTPUTS WHAT INVALID "year" THE USER INPUTTED
         */
        if (errorInYear) {
            System.out.println("ERROR IN YEAR");
            System.out.println("VALID YEARS ARE ONLY FROM 1980 UP TO 2022");
            System.out.println("INVALID YEAR: " + year);
        }
        /*
         *  IF THE VALUE OF errorInMonth, errorInDay, AND errorInYear ARE NEVER CHANGED TO true DURING THE EXECUTION ABOVE.
         *  THE EXECUTION WILL ENTER THIS if STATEMENT BECAUSE, errorInMonth, errorInDay, AND errorInYear ARE SET TO FALSE,
         *  INSIDE THE CONDITION OF if STATEMENT WE USED THE UNARY NOT OPERATOR '!', THIS REVERSE THE LOGICAL STATE OF ITS OPERANDS.
         *  IN OUT CASE !false && !false && !false, ARE EVALUATED TO true && true && true, AND IT'S LAST EVALUATION WILL BE true (true && true).
         *  true BECAUSE WE USED THE LOGICAL AND OPERATOR, THIS MEANS THAT BOTH OPERANDS SHOULD BE true, IN ORDER FOR IT TO EVALUATE TO true.
         *  IT ALSO OUTPUTS THE CURRENT "age" OF THE USER IN THE "CURRENT_YEAR".
         */
        if(!errorInMonth && !errorInDay && !errorInYear) {
            System.out.printf("YOUR BIRTHDATE IS %s %d, %d.", month, day, year);
            byte age = (byte) (CURRENT_YEAR - year);
            System.out.println("\nYOUR AGE IN THE YEAR " + CURRENT_YEAR +" IS: " + age + " years old");
        }
    }
}