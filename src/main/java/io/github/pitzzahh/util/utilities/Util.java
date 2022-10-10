package io.github.pitzzahh.util.utilities;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.stream.Stream;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

/**
 * Util class for working with numbers and arrays.
 */
public final class Util {

    /**
     * Cannot instantiate this class.
     */
    private Util() {}

    /**
     * Method that checks if the elements in the array are all the same.
     * @param array the {@code Object[]} array to be checked if all elements are the same.
     * @param <T> the type that the array.
     * @return {@code true} if all elements are the same in the {@code T[]} array.
     * @see T
     */
    public static <T> boolean areAllTheSame(T[] array) {
        return range(0, array.length).allMatch(e -> array[e].hashCode() == array[0].hashCode());
    }

    /**
     * Method that checks if the elements in the array are all the same.
     * @param array the {@code Object[]} array to be checked if all elements are the same.
     * @param target the target value that the array every element should be.
     * @param <T> the type that the array.
     * @return {@code true} if all elements are the same in the {@code T[]} array.
     * @see T
     */
    public static <T> boolean areAllTheSame(T[] array, Supplier<T> target) {
        return stream(array).allMatch(e -> e.hashCode() == target.get().hashCode());
        //return IntStream.range(0, array.length).allMatch(i -> target.get().hashCode() == array[i].hashCode());
    }

    /**
     * Method that checks if the elements in the list are all the same.
     * @param list the {@code List<T>} list to be checked if all elements are the same.
     * @param <T> the type that the list.
     * @return {@code true} if all elements are the same in the {@code List<T>} array.
     * @see T
     */
    public static <T> boolean areAllTheSame(List<T> list) {
        return range(0, list.size()).allMatch(i -> list.get(0).hashCode() == list.get(i).hashCode());
    }

    /**
     * Method that checks if the elements in the list are all the same.
     * @param list the {@code List<T>} list to be checked if all elements are the same.
     * @param target the target value that checks if all the elements in the list are equal to the target value.
     * @param <T> the type that the list.
     * @return {@code true} if all elements are the same in the {@code List<T>} array.
     * @see T
     */
    public static <T> boolean areAllTheSame(List<T> list, Supplier<T> target) {
        return list.stream().allMatch(e -> e.equals(target));
    }

    /**
     * Prints the {@code List} of {@code Integers} as a sorted {@code Integer} representation
     * @param list the {@code List<Integers>} of {@code Integers}.
     * @return the {@code String} representation of the (sorted) list without the brackets
     * @see List
     */
    public static String convertToString(List<?> list) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**
     * Converts a {@code Collection} of numbers to a {@code Number[]}.
     * @param collection the collection to be converted.
     * @return a {@code Number[]}.
     * @param <T> the data type / the {@code Collection} that extends the {@code Number} class.
     * @see Number
     * @see Collection
     */
    public static <T extends Number> Number[] convertToArray(Collection<T> collection) {
        return collection.toArray(new Number[0]);
    }

    /**
     * Converts a {@code String} to a {@code String[]}
     * @param s the {@code String}
     * @return a {@code String[]}
     */
    public static String[] convertToArray(String s) {
        return Stream.of(s)
                .iterator()
                .next()
                .split("");
    }

    /**
     * Converts a {@code String} to a {@code List<Character>}
     * @param s the {@code String} to be converted.
     * @return a {@code List<Character>}
     */
    @Deprecated(forRemoval = true)
    public static List<Character> convertToListOfCharacters(String s) {
        ArrayList<Character> characters = new ArrayList<>(s.length());
        characters.forEach(e -> characters.add(s.charAt(e)));
        return characters;
    }

    /**
     * Method that sums the numbers from a {@code Collection}.
     * It is a generified method, so it can accept any type of {@code Collection}.
     * @param numbers the {@code Collection}
     * @param predicate used for validation if you want to sum even, odd, numbers or just sum everything.
     * @return a {@code BigDecimal} containing the sum
     * @param <T> the data type / the class that extends the {@code Number} class.
     * @param <U> the type of collection that extends the {@code Collection} class.
     * @see Number
     * @see Collection
     * @see BigDecimal
     * @see Predicate
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
     * @see Number
     */
    public static <T extends Number> boolean isPresent(T[] arr, T whatToFind) {
        return Arrays.asList(arr).contains(whatToFind);
    }

    /**
     * Method that checks if a number is an even number.
     * @return {@code true} if a number is an even number
     * @param <T> the data type / the class that extends the {@code Number} class.
     * @see Number
     * @see Predicate
     */
    public static <T extends Number> Predicate<T> evenNumbers() {
        return e -> (e instanceof Integer ? e.intValue() : (e instanceof Double ? e.doubleValue() : e.floatValue())) % 2 == 0;
    }

    /**
     * Method that checks if a number is an odd number.
     * @return {@code true} if a number is an odd number
     * @param <T> the data type / the class that extends the {@code Number} class.
     * @see Number
     * @see Predicate
     */
    public static <T extends Number> Predicate<T> oddNumbers() {
        return  e -> (e instanceof Integer ? e.intValue()  : (e instanceof Double ? e.doubleValue() : e.floatValue())) % 2 != 0;
    }

    /**
     * Method that accepts anything.
     * @param <T> the type used, the type should extend the {@code Number} class
     * @return always {@code true}
     * @see Number
     * @see Predicate
     */
    public static <T extends Number> Predicate<T> allowAll() {
        return e -> true;
    }
}
