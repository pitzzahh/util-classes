package lib.utilities.arrayUtils;

public class ArrayUtil {
    private static boolean[] check;
    // Cannot instantiate this class
     private ArrayUtil() {}

    /**
     * Method that checks if the elements in the array are all the same
     * @param array the {@code byte} array to be checked if all elements are the same
     * @return {@code true} if all elements are the same in the {@code byte} array
     */
    public static boolean checkIfAllNumbersAreTheSame(byte[] array) {
        byte trueCount = 0;
        if (array.length != 0) {
            byte firstElement = array[0];
            check = new boolean[array.length];
            for (int i = 0; i < array.length; i++) {
                if (array[i] == firstElement) { // this will evaluate to true at the very beginning
                    check[i] = true;
                }
            }
            for (boolean elements : check) {
                if (elements) {
                    trueCount++;
                }
            }
        }
        else return false;
        return trueCount == array.length;
    }
    /**
     * Method that checks if the elements in the array are all the same
     * @param array the {@code short} array to be checked if all elements are the same
     * @return {@code true} if all elements are the same in the {@code short} array
     */
    public static boolean checkIfAllNumbersAreTheSame(short[] array) {
        byte trueCount = 0;
        if (array.length != 0) {
            short firstElement = array[0];
            check = new boolean[array.length];
            for (int i = 0; i < array.length; i++) {
                if (array[i] == firstElement) { // this will evaluate to true at the very beginning
                    check[i] = true;
                }
            }
            for (boolean elements : check) {
                if (elements) {
                    trueCount++;
                }
            }
        }
        else return false;
        return trueCount == array.length;
    }
    /**
     * Method that checks if the elements in the array are all the same
     * @param array the {@code int} array to be checked if all elements are the same
     * @return {@code true} if all elements are the same in the {@code int} array
     */
    public static boolean checkIfAllNumbersAreTheSame(int[] array) {
        byte trueCount = 0;
        if (array.length != 0) {
            int firstElement = array[0];
            check = new boolean[array.length];
            for (int i = 0; i < array.length; i++) {
                if (array[i] == firstElement) { // this will evaluate to true at the very beginning
                    check[i] = true;
                }
            }
            for (boolean elements : check) {
                if (elements) {
                    trueCount++;
                }
                System.out.println("ELEMENTS: " + elements);
            }
        }
        else return false;
        return trueCount == array.length;
    }
}
