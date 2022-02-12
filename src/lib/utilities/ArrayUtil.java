package lib.utilities;

import java.util.stream.Collectors;
import java.util.List;

public final class ArrayUtil {
    private static boolean[] check; // stores true boolean values

    /**
     * Cannot instantiate this class.
     */
    private ArrayUtil() {}

    /**
     * Method that checks if the elements in the array are all the same
     * @param array the {@code byte} array to be checked if all elements are the same
     * @return {@code true} if all elements are the same in the {@code byte} array
     */
    public static boolean checkIfAllNumbersAreTheSame(byte[] array) {
        byte trueCount = 0;
        if (array.length != 0) {
            byte firstElement = array[0];
            check = new boolean[array.length];
            for (int i = 0; i < array.length; i++) {
                if (array[i] == firstElement) { // this will evaluate to true at the very beginning
                    check[i] = true;
                }
            }
            for (boolean elements : check) {
                if (elements) {
                    trueCount++;
                }
            }
        }
        else return false;
        return trueCount == array.length;
    }
    /**
     * Method that checks if the elements in the array are all the same
     * @param array the {@code short} array to be checked if all elements are the same
     * @return {@code true} if all elements are the same in the {@code short} array
     */
    public static boolean checkIfAllNumbersAreTheSame(short[] array) {
        byte trueCount = 0;
        if (array.length != 0) {
            short firstElement = array[0];
            check = new boolean[array.length];
            for (int i = 0; i < array.length; i++) {
                if (array[i] == firstElement) { // this will evaluate to true at the very beginning
                    check[i] = true;
                }
            }
            for (boolean elements : check) {
                if (elements) {
                    trueCount++;
                }
            }
        }
        else return false;
        return trueCount == array.length;
    }
    /**
     * Method that checks if the elements in the array are all the same
     * @param array the {@code int} array to be checked if all elements are the same
     * @return {@code true} if all elements are the same in the {@code int} array
     */
    public static boolean checkIfAllNumbersAreTheSame(int[] array) {
        byte trueCount = 0;
        if (array.length != 0) {
            int firstElement = array[0];
            check = new boolean[array.length];
            for (int i = 0; i < array.length; i++) {
                if (array[i] == firstElement) { // this will evaluate to true at the very beginning
                    check[i] = true;
                }
            }
            for (boolean elements : check) {
                if (elements) {
                    trueCount++;
                }
                System.out.println("ELEMENTS: " + elements);
            }
        }
        else return false;
        return trueCount == array.length;
    }

    /**
     * Adds all the even numbers in a {@code List<Integers>} of {@code Integers} and doubling the total sum.
     * @param list the {@code List<Integers>} that has numbers to be scanned for integers.
     * @return the sum of the total of even numbers
     */
    public static int doubleTheSumOfTheEvenNumbers(List<Integer> list) {
        return list.stream()
                   .filter(e -> e % 2 == 0)
                   .mapToInt(e -> e * 2)
                   .sum();
    }

    /**
     * Prints the {@code List} of {@code Integers} as a sorted {@code Integer} representation
     * @param list the {@code List<Integers>} of {@code Integers}.
     * @return the {@code String} representation of the (sorted) list without the brackets
     */
    public static String getIntegers(List<Integer> list) {
        return list.stream()
                   .map(String::valueOf)
                   .sorted()
                   .collect(Collectors.joining());
    }
    /**
     * Prints the {@code List} of {@code Characters} as a {@code String} representation
     * @param list the {@code List<Characters>} of {@code Characters}.
     * @return the {@code String} representation of the (sorted) list without the brackets
     */
    public static String getCharacters(List<Character> list) {
        char[] values = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i);
        }
        return String.valueOf(values);
    }
}
