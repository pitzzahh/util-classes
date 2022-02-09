package lib.computing.mathematicsOfFinance.actualTimeAndApproximateTime.actualTime;

import lib.computing.mathematicsOfFinance.actualTimeAndApproximateTime.ComputeActualTimeAndApproximateTime;
import lib.computing.mathematicsOfFinance.variables.Fields;

@Deprecated
public final class ActualTime extends Fields {

    /**
     * Sets the values for starting month and ending month
     * @param startMonth the month when the loan started
     * @param endMonth the month when the loan will be paid
     * @return the month that is set
     */
    public ActualTime setMonth(String startMonth , String endMonth) {
        startingMonth = startMonth.toUpperCase();
        endingMonth = endMonth.toUpperCase();
        return this;
    }

    /**
     * Sets the values for starting day and ending day
     * @param startDay the day when the loan starts
     * @param endDay the day the loan will be paid
     * @return the day that is set
     */
    public ActualTime setDay(byte startDay, byte endDay) {
        startingDay = startDay;
        endingDay = endDay;
        return this;
    }

    /**
     * Sets the values for starting year and ending year
     * @param startYear the year when the loan starts
     * @param endYear the year when the loan will be paid
     * @return the year that is set
     */
    public ActualTime setYear(short startYear, short endYear) {
        startingYear = startYear;
        endingYear = endYear;
        return this;
    }

    /**
     * Method that computes the actual time between two dates
     * Issue: only computes the actual day between two dates if they have the same year
     * @see ComputeActualTimeAndApproximateTime#run()
     */
    public void computeActualTime() {
        // getting the position for starting month from 1 to 12, 1 is January, 12 is December
        for (int i = 0; i < months.length; i++) {
            for (int j = 0; j < startingMonth.length(); j++) {
                if (startingMonth.substring(0, 3).matches(months[i])) {
                    positionOfStartingMonth = (byte) (i + 1);
                    break;
                }
            }
        }
        // getting the position for ending month from 1 to 12, 1 is January, 12 is December
        for (int i = 0; i < months.length; i++) {
            for (int j = 0; j < endingMonth.length(); j++) {
                if (endingMonth.substring(0, 3).matches(months[i])) {
                    positionOfEndingMonth = (byte) (i + 1);
                    newEndingMonthPosition = (byte) (i + 1);
                    break;
                }
            }
        }

        // Actual Days Computation
        for (int i = startingYear; i <= endingYear; i++) {
            System.out.println("NEW YEAR: " + i);
            if (startingYear != endingYear) {
                newEndingMonthPosition = 12;
            }
            else {
                newEndingMonthPosition = positionOfEndingMonth;
            }
            for (int j = positionOfStartingMonth; j <= newEndingMonthPosition; j++) {
                if (j == positionOfStartingMonth) {
                    if (!startingMonth.substring(0, 3).matches("FEB")) {
                        totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS - startingDay;
                    }
                    switch (j) {
                        case 1 -> System.out.println("JANUARY: " + startingDay);
                        case 2 -> {
                            if (startingMonth.substring(0, 3).matches("FEB")) {
                                System.out.println("SECOND FEB");
                                totalCountOfActualDays += (short) ACTUAL_TIME_FOR_MONTHS_OF_FEBRUARY - startingDay;
                                System.out.println("FEBRUARY: " + totalCountOfActualDays);
                            }
                        }
                        case 3 -> System.out.println("MARCH : " + startingDay);
                        case 4 -> System.out.println("APRIL: " + startingDay);
                        case 5 -> System.out.println("MAY: " + startingDay);
                        case 6 -> System.out.println("JUNE: " + startingDay);
                        case 7 -> System.out.println("JULY: " + startingDay);
                        case 8 -> System.out.println("AUGUST: " + startingDay);
                        case 9 -> System.out.println("SEPTEMBER: " + startingDay);
                        case 10 -> System.out.println("OCTOBER: " + startingDay);
                        case 11 -> System.out.println("NOVEMBER: " + startingDay);
                        case 12 -> System.out.println("DECEMBER: " + startingDay);
                    }
                }
                else if (j == newEndingMonthPosition) {
                    switch (j) {
                        case 1 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("JANUARY: " + endingDay);
                            } else {
                                totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                                System.out.println("JANUARY: " + endingDay);
                            }
                        }
                        case 2 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("FEBRUARY: " + endingDay);
                            }
                            else {
                                totalCountOfActualDays += ACTUAL_TIME_FOR_MONTHS_OF_FEBRUARY;
                                System.out.println("FEBRUARY: " + endingDay);
                            }
                        }
                        case 3 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("MARCH: " + endingDay);
                            }
                            else {
                                totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                                System.out.println("MARCH: " + endingDay);
                            }
                        }
                        case 4 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("APRIL: " + endingDay);
                            }
                            else {
                                totalCountOfActualDays += APPROXIMATE_TIME_DAYS_IN_MONTHS;
                                System.out.println("APRIL: " + endingDay);
                            }
                        }
                        case 5 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("MAY: " + endingDay);
                            }
                            else {
                                totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                                System.out.println("MAY: " + endingDay);
                            }
                        }
                        case 6 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("JUNE: " + endingDay);
                            }
                            else {
                                totalCountOfActualDays += APPROXIMATE_TIME_DAYS_IN_MONTHS;
                                System.out.println("JUNE: " + endingDay);
                            }
                        }
                        case 7 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("JULY: " + endingDay);
                            }
                            else {
                                totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                                System.out.println("JULY: " + endingDay);
                            }
                        }
                        case 8 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("AUGUST: " + endingDay);
                            }
                            else {
                                System.out.println("END");
                                totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                                System.out.println("AUGUST: " + endingDay);
                            }
                        }
                        case 9 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("SEPTEMBER: " + endingDay);
                            }
                            else {
                                totalCountOfActualDays += APPROXIMATE_TIME_DAYS_IN_MONTHS;
                                System.out.println("SEPTEMBER: " + endingDay);
                            }
                        }
                        case 10 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("OCTOBER: " + endingDay);
                            }
                            else {
                                totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                                System.out.println("OCTOBER: " + endingDay);
                            }
                        }
                        case 11 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("NOVEMBER: " + endingDay);
                            }
                            else {
                                totalCountOfActualDays += APPROXIMATE_TIME_DAYS_IN_MONTHS;
                                System.out.println("NOVEMBER: " + endingDay);
                            }
                        }
                        case 12 -> {
                            if ((j == positionOfEndingMonth + 1) || (i == endingYear)) {
                                totalCountOfActualDays += endingDay;
                                System.out.println("DECEMBER: " + endingDay);
                            }
                            else {
                                totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                                System.out.println("DECEMBER: " + endingDay);
                            }
                        }
                    }
                }
                else {
                    switch (j) {
                        case 1 -> {
                            System.out.println("JANUARY: " + ACTUAL_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                        }
                        case 2 -> {
                            System.out.println("FEBRUARY: " + ACTUAL_TIME_FOR_MONTHS_OF_FEBRUARY);
                            totalCountOfActualDays += ACTUAL_TIME_FOR_MONTHS_OF_FEBRUARY;
                        }
                        case 3 -> {
                            System.out.println("MARCH: " + ACTUAL_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                        }
                        case 4 -> {
                            System.out.println("APRIL: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += APPROXIMATE_TIME_DAYS_IN_MONTHS;
                        }
                        case 5 -> {
                            System.out.println("MAY: " + ACTUAL_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                        }
                        case 6 -> {
                            System.out.println("JUNE: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += APPROXIMATE_TIME_DAYS_IN_MONTHS;
                        }
                        case 7 -> {
                            System.out.println("JULY: " + ACTUAL_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                        }
                        case 8 -> {
                            System.out.println("AUGUST: " + ACTUAL_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                        }
                        case 9 -> {
                            System.out.println("SEPTEMBER: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += APPROXIMATE_TIME_DAYS_IN_MONTHS;
                        }
                        case 10 -> {
                            System.out.println("OCTOBER: " + ACTUAL_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                        }
                        case 11 -> {
                            System.out.println("NOVEMBER: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += APPROXIMATE_TIME_DAYS_IN_MONTHS;
                        }
                        case 12 -> {
                            System.out.println("DECEMBER: " + ACTUAL_TIME_DAYS_IN_MONTHS);
                            totalCountOfActualDays += ACTUAL_TIME_DAYS_IN_MONTHS;
                        }
                    }
                }
            }
            System.out.println("TOTAL DAYS: " + totalCountOfActualDays);
        }
    }
}

