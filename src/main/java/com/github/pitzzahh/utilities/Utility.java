package com.github.pitzzahh.utilities;

import java.util.List;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.function.Predicate;

/**
 * Utility class for working with numbers and arrays.
 */
public final class Utility {

    /**
     * Cannot instantiate this class.
     */
    private Utility() {}

    /**
     * Method that checks if the elements in the array are all the same.
     * @param array the {@code Object[]} array to be checked if all elements are the same.
     * @return {@code true} if all elements are the same in the {@code Object[]} array.
     */
    public static boolean areAllTheSame(Object[] array) {
        return IntStream.range(0, array.length).allMatch(e -> array[e].hashCode() == array[0].hashCode());
    }

    /**
     * Prints the {@code List} of {@code Integers} as a sorted {@code Integer} representation
     * @param list the {@code List<Integers>} of {@code Integers}.
     * @return the {@code String} representation of the (sorted) list without the brackets
     */
    public static String convertToString(List<?> list) {
        return list.stream()
                   .map(String::valueOf)
                   .collect(Collectors.joining());
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
     * Method that searches an array, returns true if the value is present, otherwise false.
     * @param arr the array that extends the {@code Number} class.
     * @param whatToFind the number to find in the array.
     * @return {@code true} if {@code whatToFind} is present in the array.
     * @param <T> the type that the {@code arr} and {@code whatToFind}
     */
    public static <T extends Number> boolean isPresent(T[] arr, T whatToFind) {
        return IntStream.range(0, arr.length)
                .anyMatch(i -> arr[i].hashCode() == whatToFind.hashCode());
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
    public static <T extends Number> Predicate<T> allowAll() {
        return e -> true;
    }
}
