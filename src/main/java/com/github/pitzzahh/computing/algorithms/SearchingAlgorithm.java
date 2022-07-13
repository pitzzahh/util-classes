package com.github.pitzzahh.computing.algorithms;

@FunctionalInterface
public interface SearchingAlgorithm {

    <T extends Number> Number search(T[] arr, T whatToFind);

}
