package lib.computing.mathematicsOfFinance.actualTimeAndApproximateTime.approximateTime;

import lib.computing.mathematicsOfFinance.variables.Fields;
@Deprecated
public final class ApproximateTime extends Fields {

    public ApproximateTime() { }
    /**
     * Sets the values for starting month and ending month
     * @param startMonth the month when the loan started
     * @param endMonth the month when the loan will be paid
     * @return the month that is set
     */
    public ApproximateTime setMonth(String startMonth , String endMonth) {
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
    public ApproximateTime setDay(byte startDay, byte endDay) {
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
    public ApproximateTime setYear(short startYear, short endYear) {
        startingYear = startYear;
        endingYear = endYear;
        return this;
    }

    private void computeApproximateTime(String fromMonthName, String toMonthName) {
        // getting the count for first month
        for (int i = 0; i < months.length; i++) {
            for (int j = 0; j < fromMonthName.length(); j++) {
                if (fromMonthName.substring(0, 3).matches(months[i])) {
                    positionOfStartingMonth = (byte) (i + 1);
                    break;
                }
            }
        }

        // getting the count for last month
        for (int i = 0; i < months.length; i++) {
            for (int j = 0; j < toMonthName.length(); j++) {
                if (toMonthName.substring(0, 3).matches(months[i])) {
                    positionOfEndingMonth = (byte) (i + 1);
                    break;
                }
            }
        }
        for (int i = positionOfStartingMonth; i <= positionOfEndingMonth; i++) {

            if (startingMonth.equals(endingMonth)) {
                for (int j = startingDay; j <= endingDay; j++) {
                    totalCountOfApproximateDays += 1;
                }
            }
            else if (i == positionOfStartingMonth) {
                if (startingDay == ACTUAL_TIME_FOR_MONTHS_OF_FEBRUARY) {
                    totalCountOfApproximateDays = 0;
                    System.out.println("FEBRUARY: " + totalCountOfApproximateDays);
                }
                else {
                    totalCountOfApproximateDays += APPROXIMATE_TIME_DAYS_IN_MONTHS - startingDay;
                    switch (i) {
                        case 1 -> System.out.println("JANUARY: " + totalCountOfApproximateDays);
                        case 2 -> System.out.println("FEBRUARY: " + totalCountOfApproximateDays);
                        case 3 -> System.out.println("MARCH : " + totalCountOfApproximateDays);
                        case 4 -> System.out.println("APRIL: " + totalCountOfApproximateDays);
                        case 5 -> System.out.println("MAY: " + totalCountOfApproximateDays);
                        case 6 -> System.out.println("JUNE: " + totalCountOfApproximateDays);
                        case 7 -> System.out.println("JULY: " + totalCountOfApproximateDays);
                        case 8 -> System.out.println("AUGUST: " + totalCountOfApproximateDays);
                        case 9 -> System.out.println("SEPTEMBER: " + totalCountOfApproximateDays);
                        case 10 -> System.out.println("OCTOBER: " + totalCountOfApproximateDays);
                        case 11 -> System.out.println("NOVEMBER: " + totalCountOfApproximateDays);
                        case 12 -> System.out.println("DECEMBER: " + totalCountOfApproximateDays);
                    }
                }
            }
            else if (i == positionOfEndingMonth) {
                totalCountOfApproximateDays += endingDay;
                switch (i) {
                    case 1 -> System.out.println("JANUARY: " + endingDay);
                    case 2 -> System.out.println("FEBRUARY: " + endingDay);
                    case 3 -> System.out.println("MARCH: " + endingDay);
                    case 4 -> System.out.println("APRIL: " + endingDay);
                    case 5 -> System.out.println("MAY: " + endingDay);
                    case 6 -> System.out.println("JUNE: " + endingDay);
                    case 7 -> System.out.println("JULY: " + endingDay);
                    case 8 -> System.out.println("AUGUST: " + endingDay);
                    case 9 -> System.out.println("SEPTEMBER: " + endingDay);
                    case 10 -> System.out.println("OCTOBER: " + endingDay);
                    case 11 -> System.out.println("NOVEMBER: " + endingDay);
                    case 12 -> System.out.println("DECEMBER: " + endingDay);
                }
            }
            else{
                totalCountOfApproximateDays += APPROXIMATE_TIME_DAYS_IN_MONTHS;
                switch (i) {
                    case 1 -> System.out.println("JANUARY: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                    case 2 -> System.out.println("FEBRUARY: " + ACTUAL_TIME_FOR_MONTHS_OF_FEBRUARY);
                    case 3 -> System.out.println("MARCH: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                    case 4 -> System.out.println("APRIL: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                    case 5 -> System.out.println("MAY: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                    case 6 -> System.out.println("JUNE: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                    case 7 -> System.out.println("JULY: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                    case 8 -> System.out.println("AUGUST: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                    case 9 -> System.out.println("SEPTEMBER: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                    case 10 -> System.out.println("OCTOBER: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                    case 11 -> System.out.println("NOVEMBER: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                    case 12 -> System.out.println("DECEMBER: " + APPROXIMATE_TIME_DAYS_IN_MONTHS);
                }
            }
        }
    }
    public void getApproximateTime() {
        computeApproximateTime(startingMonth, endingMonth);
    }
}


