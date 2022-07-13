package com.github.pitzzahh.computing.algorithms;

@FunctionalInterface
public interface SearchinAlgorithm {

    <T extends Number> Number search(T[] arr, T whatToFind);

}
