package io.github.pitzzahh.computing.algorithms;

/**
 * Interface used by searching algorithms.
 * @see Number
 */
@FunctionalInterface
public interface SearchingAlgorithm {

    /**
     * Abstract method used for searching a certain value in an array T[].
     * @param arr the array to search for.
     * @param whatToFind the value / element to search in the array T[].
     * @return a {@code Number} the searched number if present.
     * @param <T> the type to be used that extends the Number class.
     */
    <T extends Number> Number search(T[] arr, T whatToFind);

}
