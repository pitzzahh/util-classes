package com.github.pitzzahh.computing.algorithms.sorting.quickSort;

import java.util.Random;
/**
 * The {@code QuickSort} class contains overloaded methods that can sort
 * primitive byte, short, int, and double array.
 */
public final class QuickSort {

    // cannot instantiate this class
    private QuickSort() {
    }
    /**
     * Sort the byte array
     * @param array the byte array that will be sorted
     */
    public static void sort(byte[] array) {
        System.out.println("********************************************");
        System.out.println("* QUICK SORT ALGORITHM THAT SORTS AN ARRAY *");
        System.out.println("********************************************");
        System.out.print("BEFORE SORTING: ");
        printArray(array);
        quickSort(array, 0, array.length - 1);
        System.out.print("\nAFTER SORTING : ");
        printArray(array);
    }
    /**
     * Sort the short array
     * @param array short array that will be sorted
     */
    public static void sort(short[] array) {
        System.out.println("********************************************");
        System.out.println("* QUICK SORT ALGORITHM THAT SORTS AN ARRAY *");
        System.out.println("********************************************");
        System.out.print("BEFORE SORTING: ");
        printArray(array);
        quickSort(array, 0, array.length - 1);
        System.out.print("\nAFTER SORTING : ");
        printArray(array);
    }
    /**
     * Sort the int array
     * @param array int array that will be sorted
     */
    public static void sort(int[] array) {
        System.out.println("********************************************");
        System.out.println("* QUICK SORT ALGORITHM THAT SORTS AN ARRAY *");
        System.out.println("********************************************");
        System.out.print("BEFORE SORTING: ");
        printArray(array);
        quickSort(array, 0, array.length - 1);
        System.out.print("\nAFTER SORTING : ");
        printArray(array);
    }
    /**
     * Sort the double array
     * @param array double array that will be sorted
     */
    public static void sort(double[] array) {
        System.out.println("********************************************");
        System.out.println("* QUICK SORT ALGORITHM THAT SORTS AN ARRAY *");
        System.out.println("********************************************");
        System.out.print("BEFORE SORTING: ");
        printArray(array);
        quickSort(array, 0, array.length - 1);
        System.out.print("\nAFTER SORTING : ");
        printArray(array);
    }
    /**
     * The Algorithm that sort the byte array.
     * @param arrayToSort the array to sort.
     * @param lowIndex the arrayToSort at index 0
     * @param highIndex the last index of the arrayToSort byte array.
     */
    private static void quickSort(byte[] arrayToSort, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arrayToSort[pivotIndex];
        swap(arrayToSort, pivotIndex, highIndex);
        int leftPointer = partition(arrayToSort, lowIndex, highIndex, pivot);
        quickSort(arrayToSort, lowIndex, leftPointer - 1);
        quickSort(arrayToSort, leftPointer + 1, highIndex);
    }
    /**
     * The Algorithm that sort the short array
     * @param arrayToSort the array to sort
     * @param lowIndex the arrayToSort at index 0
     * @param highIndex the last index of the arrayToSort short array
     */
    private static void quickSort(short[] arrayToSort, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arrayToSort[pivotIndex];
        swap(arrayToSort, pivotIndex, highIndex);
        int leftPointer = partition(arrayToSort, lowIndex, highIndex, pivot);
        quickSort(arrayToSort, lowIndex, leftPointer - 1);
        quickSort(arrayToSort, leftPointer + 1, highIndex);
    }
    /**
     * The Algorithm that sort the int array
     * @param arrayToSort the array to sort
     * @param lowIndex the arrayToSort at index 0
     * @param highIndex the last index of the arrayToSort int array
     */
    private static void quickSort(int[] arrayToSort, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arrayToSort[pivotIndex];
        swap(arrayToSort, pivotIndex, highIndex);
        int leftPointer = partition(arrayToSort, lowIndex, highIndex, pivot);
        quickSort(arrayToSort, lowIndex, leftPointer - 1);
        quickSort(arrayToSort, leftPointer + 1, highIndex);
    }
    /**
     * The Algorithm that sort the int array
     * @param arrayToSort the array to sort
     * @param lowIndex the arrayToSort at index 0
     * @param highIndex the last index of the arrayToSort int array
     */
    private static void quickSort(double[] arrayToSort, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        double pivot = arrayToSort[pivotIndex];
        swap(arrayToSort, pivotIndex, highIndex);
        int leftPointer = partition(arrayToSort, lowIndex, highIndex, pivot);
        quickSort(arrayToSort, lowIndex, leftPointer - 1);
        quickSort(arrayToSort, leftPointer + 1, highIndex);
    }
    /**
     * The Algorithm that partitions the byte array
     * @param arrayToSort the array to sort
     * @param lowIndex the arrayToSort at index 0
     * @param highIndex the last index of the arrayToSort array
     * @param pivot the position that is selected in the array that will be compared to the sub arrays
     */
    private static int partition(byte[] arrayToSort, int lowIndex, int highIndex, int pivot) {
        int rightPointer = highIndex;
        int leftPointer = lowIndex;
        while (leftPointer < rightPointer) {
            while (arrayToSort[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arrayToSort[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arrayToSort, leftPointer, rightPointer);
        }
        swap(arrayToSort, leftPointer, highIndex);
        return leftPointer;
    }
    /**
     * The Algorithm that partitions the short array
     * @param arrayToSort the array to sort
     * @param lowIndex the arrayToSort at index 0
     * @param highIndex the last index of the arrayToSort array
     * @param pivot the position that is selected in the array that will be compared to the sub arrays
     */
    private static int partition(short[] arrayToSort, int lowIndex, int highIndex, int pivot) {
        int rightPointer = highIndex;
        int leftPointer = lowIndex;
        while (leftPointer < rightPointer) {
            while (arrayToSort[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arrayToSort[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arrayToSort, leftPointer, rightPointer);
        }
        swap(arrayToSort, leftPointer, highIndex);
        return leftPointer;
    }
    /**
     * The Algorithm that partitions the int array
     * @param arrayToSort the array to sort
     * @param lowIndex the arrayToSort at index 0
     * @param highIndex the last index of the arrayToSort array
     * @param pivot the position that is selected in the array that will be compared to the sub arrays
     */
    private static int partition(int[] arrayToSort, int lowIndex, int highIndex, int pivot) {
        int rightPointer = highIndex;
        int leftPointer = lowIndex;
        while (leftPointer < rightPointer) {
            while (arrayToSort[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arrayToSort[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arrayToSort, leftPointer, rightPointer);
        }
        swap(arrayToSort, leftPointer, highIndex);
        return leftPointer;
    }
    /**
     * The Algorithm that partitions the double array
     * @param arrayToSort the array to sort
     * @param lowIndex the arrayToSort at index 0
     * @param highIndex the last index of the arrayToSort array
     * @param pivot the position that is selected in the array that will be compared to the sub arrays
     */
    private static int partition(double[] arrayToSort, int lowIndex, int highIndex, double pivot) {
        int rightPointer = highIndex;
        int leftPointer = lowIndex;
        while (leftPointer < rightPointer) {
            while (arrayToSort[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arrayToSort[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arrayToSort, leftPointer, rightPointer);
        }
        swap(arrayToSort, leftPointer, highIndex);
        return leftPointer;
    }
    /**
     * Method that swaps the byte array
     * @param arrayToSwap the byte array to swap
     * @param index1 the first index
     * @param index2 the second index
     */
    private static void swap(byte[] arrayToSwap, int index1, int index2) {
        byte temporary = arrayToSwap[index1];
        arrayToSwap[index1] = arrayToSwap[index2];
        arrayToSwap[index2] = temporary;
    }
    /**
     * Method that swaps the short array
     * @param arrayToSwap the short array to swap
     * @param index1 the first index
     * @param index2 the second index
     */
    private static void swap(short[] arrayToSwap, int index1, int index2) {
        short temporary = arrayToSwap[index1];
        arrayToSwap[index1] = arrayToSwap[index2];
        arrayToSwap[index2] = temporary;
    }
    /**
     * Method that swaps the double array
     * @param arrayToSwap the double array to swap
     * @param index1 the first index
     * @param index2 the second index
     */
    private static void swap(double[] arrayToSwap, int index1, int index2) {
        double temporary = arrayToSwap[index1];
        arrayToSwap[index1] = arrayToSwap[index2];
        arrayToSwap[index2] = temporary;
    }
    /**
     * Method that swaps the int array
     * @param arrayToSwap the int array to swap
     * @param index1 the first index
     * @param index2 the second index
     */
    private static void swap(int[] arrayToSwap, int index1, int index2) {
        int temporary = arrayToSwap[index1];
        arrayToSwap[index1] = arrayToSwap[index2];
        arrayToSwap[index2] = temporary;
    }
    /**
     * Method that prints the byte array
     * @param arrayToPrint the byte array to be printed
     */
    private static void printArray(byte[] arrayToPrint) {
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.print(arrayToPrint[i]);
            if (i != arrayToPrint.length - 1) {
                System.out.print(", ");
            }
        }
    }
    /**
     * Method that prints the short array
     * @param arrayToPrint the short array to be printed
     */
    private static void printArray(short[] arrayToPrint) {
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.print(arrayToPrint[i]);
            if (i != arrayToPrint.length - 1) {
                System.out.print(", ");
            }
        }
    }
    /**
     * Method that prints the int array
     * @param arrayToPrint the int array to be printed
     */
    private static void printArray(int[] arrayToPrint) {
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.print(arrayToPrint[i]);
            if (i != arrayToPrint.length - 1) {
                System.out.print(", ");
            }
        }
    }
    /**
     * Method that prints the double array
     * @param arrayToPrint the double array to be printed
     */
    private static void printArray(double[] arrayToPrint) {
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.print(arrayToPrint[i]);
            if (i != arrayToPrint.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
