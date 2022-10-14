/*
 * MIT License
 *
 * Copyright (c) 2022 pitzzahh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package io.github.pitzzahh.util.utilities;

import static java.util.Arrays.stream;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Collection;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Util class for working with numbers and arrays. This class mainly uses streams and lambdas.
 * @see Stream
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
    public static <T> boolean similar(T[] array) {
        return stream(array).distinct().count() == 1;
    }

    /**
     * Method that checks if the elements in the array are all the same.
     * @param array the {@code Object[]} array to be checked if all elements are the same.
     * @param target the target value that the array every element should be.
     * @param <T> the type that the array.
     * @return {@code true} if all elements are the same in the {@code T[]} array.
     * @see T
     */
    public static <T> boolean similar(T[] array, Supplier<T> target) {
        return stream(array).allMatch(e -> e.equals(target.get()));
    }

    /**
     * Method that checks if the elements in the list are all the same.
     * @param list the {@code List<T>} list to be checked if all elements are the same.
     * @param <T> the type that the list.
     * @return {@code true} if all elements are the same in the {@code List<T>} array.
     * @see T
     */
    public static <T> boolean similar(List<T> list) {
        return list.stream().distinct().count() == 1;
    }

    /**
     * Method that checks if the elements in the list are all the same.
     * @param list the {@code List<T>} list to be checked if all elements are the same.
     * @param target the target value that checks if all the elements in the list are equal to the target value.
     * @param <T> the type that the list.
     * @return {@code true} if all elements are the same in the {@code List<T>} array.
     * @see T
     */
    public static <T> boolean similar(List<T> list, Supplier<T> target) {
        return list.stream().allMatch(e -> e.equals(target.get()));
    }

    /**
     * Prints the {@code List} of unknown type {@code ?} as a {@code String} representation
     * @param list the {@code List<T>} to be converted to a String
     * @return the {@code String} representation of the list without the brackets
     * @see List
     */
    public static String getString(List<?> list) {
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
    public static <T extends Number> Number[] toArray(Collection<T> collection) {
        return collection.toArray(new Number[0]);
    }

    /**
     * Converts a {@code String} to a {@code String[]}
     * @param s the {@code String}
     * @return a {@code String[]}
     */
    public static String[] toArray(String s) {
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
    public static List<Character> getAsListOfCharacters(String s) {
        return IntStream.range(0, s.length())
                .mapToObj(s::charAt)
                .collect(Collectors.toList());
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
     * @param collection the collection that extends the {@code Number} class.
     * @param whatToFind the number to find in the array.
     * @return {@code true} if {@code whatToFind} is present in the array.
     * @param <T> the type that the {@code collection} and {@code whatToFind}
     * @see Number
     * @see Collection
     */
    public static <T extends Number> boolean isPresent(Collection<T> collection, T whatToFind) {
        return collection.contains(whatToFind);
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
