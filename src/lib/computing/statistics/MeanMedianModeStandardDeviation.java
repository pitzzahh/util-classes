package lib.computing.statistics;

import java.util.Arrays;

public final class MeanMedianModeStandardDeviation {
    /**
     * Cannot instantiate this class
     */
    private MeanMedianModeStandardDeviation() {}

    private static int length;
    private static double mean;

    /**
     * Calculates the mean of the array
     * @param numberArray the array to be computed
     * @return the mean of the array
     */
    private static double calculateMean(double[] numberArray) {
        double sum = 0.0;
        length = numberArray.length;
        for(double num : numberArray) {
            sum += num;
        }
        mean = sum / length;
        return mean;
    }
    /**
     * Calculates the median of the array
     * @param numberArray the array to be computed
     * @return the median of the array
     */
    private static double calculateMedian(double[] numberArray) {
        double[] arrCopy = numberArray.clone();
        Arrays.sort(arrCopy);
        double median;
        int n = arrCopy.length;
        if (n % 2 == 1) {
            median = arrCopy[n / 2];
        } else {
            median = (arrCopy[n / 2] + arrCopy[n / 2 - 1]) / 2.0;
        }
        return median;
    }
    /**
     * Calculates the mode of the array
     * @param numberArray the array to be computed
     * @return the mode of the array
     */
    private static double calculateMode(double[] numberArray) {
        double maxValue = 0;
        double maxCount = 0;
        for(int i = 0; i < length; ++i) {
            int count = 0;
            for(int j = 0; j < length; ++j) {
                if(numberArray[j] == numberArray[i]) {
                    ++count;
                }
                if(count > maxCount) {
                    maxCount = count;
                    maxValue = numberArray[i];
                }
            }
        }
        return maxValue;
    }
    /**
     * Calculates the standard deviation of the array
     * @param numberArray the array to be computed
     * @return the standard deviation of the array
     */
    private static double calculateStandardDeviation(double[] numberArray) {
        double standardDeviation = 0.0;
        for(double num : numberArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation / length);
    }
    public static void computeMeanMedianModeStandardDeviation(double[] numberArray) {
        if (calculateMean(numberArray) % 2 == 0) {
            System.out.println("MEAN              : " + (int)calculateMean(numberArray));
        }
        else {
            System.out.printf("MEAN              : %.6f\n", calculateMean(numberArray));
        }
        if (calculateMedian(numberArray) % 2 == 0) {
            System.out.println("MEDIAN            : " + (int)calculateMedian(numberArray));
        }
        else {
            System.out.printf("MEDIAN              : %.6f\n", calculateMean(numberArray));
        }
        if (calculateMode(numberArray) % 2 == 0) {
            System.out.println("MODE              : " + (int)calculateMode(numberArray));
        }
        else {
            System.out.printf("MODE                : %.6f\n", calculateMode(numberArray));
        }
        System.out.printf("STANDARD DEVIATION: %.6f", calculateStandardDeviation(numberArray));
    }
}
