package io.github.pitzzahh.util.computing.algorithms;

import java.util.stream.IntStream;

/**
 * Class used for doing linear searching in an array.
 */
public final class LinearSearch implements SearchingAlgorithm {

    /**
     * Method that searches an array, returns the position of that number in the array.
     * @param arr the array that extends the {@code Number} class.
     * @param whatToFind the number to find in the array.
     * @return the position of that number in the array, if {@code whatToFind} is present in the array, otherwise return -1.
     * @param <T> the type that the {@code arr} and {@code whatToFind}
     * @see T
     */
    @Override
    public <T extends Number> Number search(T[] arr, T whatToFind) {
        return IntStream.range(0, arr.length)
                .parallel()
                .filter(i -> arr[i].hashCode() == whatToFind.hashCode())
                .findFirst()
                .orElse(-1);
    }

}
