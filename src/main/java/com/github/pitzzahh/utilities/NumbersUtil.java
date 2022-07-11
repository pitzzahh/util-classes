package com.github.pitzzahh.utilities;

import java.util.List;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.function.Predicate;

/**
 * Utility class for checking
 */
public final class NumbersUtil {

    private static boolean[] booleans; // stores true boolean values

    /**
     * Cannot instantiate this class.
     */
    private NumbersUtil() {}

    /**
     * Method that checks if the elements in the array are all the same
     * @param array the {@code byte} array to be checked if all elements are the same
     * @return {@code true} if all elements are the same in the {@code byte} array
     */
    public static boolean checkIfAllNumbersAreTheSame(byte[] array) {
        byte trueCount = 0;
        if (array.length != 0) {
            byte firstElement = array[0];
            booleans = new boolean[array.length];

            IntStream.range(0, array.length).filter(i -> array[i] == firstElement).forEach(i -> booleans[i] = true);

            for (boolean e : booleans) {
                if (e) {
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
            booleans = new boolean[array.length];

            IntStream.range(0, array.length).filter(i -> array[i] == firstElement).forEach(i -> booleans[i] = true);

            for (boolean e : booleans) {
                if (e) {
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
            booleans = new boolean[array.length];

            IntStream.range(0, array.length).filter(i -> array[i] == firstElement).forEach(i -> booleans[i] = true);

            for (boolean e : booleans) {
                if (e) {
                    trueCount++;
                }
            }
        }
        else return false;
        return trueCount == array.length;
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
    public static String getString(List<Character> list) {
        return list.stream().map(Object::toString).reduce("", String::concat);
    }

    /**
     * Method that sums the numbers from a {@code Collection}.
     * It is a generified method, so it can accept any type of {@code Collection}.
     * @param numbers the {@code Collection}
     * @param predicate used for validation if you want to sum even, odd, numbers or just sum everything.
     * @return a {@code BigDecimal} containing the sum
     * @param <T> the data type / the class that extends the {@code Number} class.
     * @param <U> the type of collection that extends the {@code Collection} class.
     */
    public static <T extends Number, U extends Collection<T>> BigDecimal sum(U numbers, Predicate<T> predicate) {
        return numbers
                .stream()
                .filter(predicate)
                .map(Number::toString)
                .map(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Method that checks if a number is an even number.
     * @return {@code true} if a number is an even number
     * @param <T> the data type / the class that extends the {@code Number} class.
     */
    public static <T extends Number> Predicate<T> evenNumbers() {
        return e -> (e instanceof Integer ? e.intValue() : (e instanceof Double ? e.doubleValue() : e.floatValue())) % 2 == 0;
    }

    /**
     * Method that checks if a number is an odd number.
     * @return {@code true} if a number is an odd number
     * @param <T> the data type / the class that extends the {@code Number} class.
     */
    public static <T extends Number> Predicate<T> oddNumbers() {
        return  e -> (e instanceof Integer ? e.intValue()  : (e instanceof Double ? e.doubleValue() : e.floatValue())) % 2 != 0;
    }

    /**
     * Method that accepts anything.
     * @return always {@code true}
     */
    public static <T extends Number> Predicate<T> sumAll() {
        return e -> true;
    }
}
