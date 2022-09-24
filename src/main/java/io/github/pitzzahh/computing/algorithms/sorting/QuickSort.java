package io.github.pitzzahh.computing.algorithms.sorting;

import java.util.Random;

/**
 * The {@code QuickSort} class contains overloaded methods that can sort
 * primitive data types are not allowed, use the wrapper class instead.
 */
public final class QuickSort {

    // cannot instantiate this class
    private QuickSort() {
    }

    /**
     * Sort the int array
     * @param <T> the type of the array, the type should extend the {@code Number} class
     * @param array the array to sort.
     * @see Number
     */
    public static <T extends Number> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * The Algorithm that sort the T[]
     * @param arrayToSort the array to sort
     * @param lowIndex the arrayToSort at index 0
     * @param highIndex the last index of the arrayToSort T[]
     */
    private static <T extends Number> void quickSort(T[] arrayToSort, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        T pivot = arrayToSort[pivotIndex];
        swap(arrayToSort, pivotIndex, highIndex);
        int leftPointer = partition(arrayToSort, lowIndex, highIndex, pivot);
        quickSort(arrayToSort, lowIndex, leftPointer - 1);
        quickSort(arrayToSort, leftPointer + 1, highIndex);
    }

    /**
     * The Algorithm that partitions the T[]
     * @param arrayToSort the array to sort
     * @param lowIndex the arrayToSort at index 0
     * @param highIndex the last index of the arrayToSort array
     * @param pivot the position that is selected in the array that will be compared to the sub arrays
     */
    private static <T extends Number> int partition(T[] arrayToSort, int lowIndex, int highIndex, T pivot) {
        int rightPointer = highIndex;
        int leftPointer = lowIndex;
        while (leftPointer < rightPointer) {
            while ( arrayToSort[leftPointer].intValue() <= pivot.intValue() && leftPointer < rightPointer) {
                leftPointer++;
            }
            while ( arrayToSort[rightPointer].intValue() >= pivot.intValue() && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arrayToSort, leftPointer, rightPointer);
        }
        swap(arrayToSort, leftPointer, highIndex);
        return leftPointer;
    }

    /**
     * Method that swaps the T[]
     * @param arrayToSwap the T[] to swap
     * @param index1 the first index
     * @param index2 the second index
     */
    private static <T extends Number> void swap(T[] arrayToSwap, int index1, int index2) {
        T temporary = arrayToSwap[index1];
        arrayToSwap[index1] = arrayToSwap[index2];
        arrayToSwap[index2] = temporary;
    }

}
