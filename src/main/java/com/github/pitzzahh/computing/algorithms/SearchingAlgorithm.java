package com.github.pitzzahh.computing.algorithms;

/**
 * Interface used by searching algorithms.
 */
@FunctionalInterface
public interface SearchingAlgorithm {

    <T extends Number> Number search(T[] arr, T whatToFind);

}
