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
