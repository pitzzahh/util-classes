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

package io.github.pitzzahh.util.utilities.classes;

import static java.util.Objects.requireNonNull;
import static java.util.stream.IntStream.range;
import static java.lang.String.format;
import java.util.stream.StreamSupport;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.Arrays.*;
import java.util.stream.Stream;
import java.util.*;

/**
 * Class that functions same as an array but the size increases.
 * @param <T> the type of the dynamic array.
 */
public class DynamicArray<T> {

    /**
     * The default constructor.
     */
    public DynamicArray() {
    }

    /**
     * The array where the elements are stored.
     * Called balloon because balloon expands as you add air to it.
     */
    transient Object[] balloon = {};

    /**
     * placeholder for any insert modification in the dynamic array.
     */
    transient int modificationCount;

    /**
     * Insert an element in the dynamic array.
     * @param element the element to be inserted.
     * @return {@code true} if inserted successfully.
     */
    public boolean insert(T element) {
        modificationCount++;
        return this.add(element);
    }

    /**
     * Inserts an array of elements in the dynamic array.
     * @param elements the element to be inserted.
     * @return {@code true} if inserted successfully.
     */
    @SafeVarargs
    public final boolean insert(T... elements) {
        modificationCount += elements.length;
        Arrays.stream(elements).forEachOrdered(this::add);
        return size() == elements.length;
    }

    /**
     * Removes an element in the dynamic array.
     * @param element the element to be removed.
     * @return {@code true} if removed successfully.
     */
    public boolean remove(T element) {
        requireNonNull(element, "Argument cannot be null");
        var index = indexOf(element);
        if (index == -1) return false;
        this.balloon[index] = null;
        return trimAndGrow();
    }

    /**
     * Removes an element in the dynamic array and returns it.
     * If the element is not found, returns -1.
     * @param element the element to be removed.
     * @return {@code T} the removed element.
     * @throws IllegalArgumentException if the element to be removed and get is not in the dynamic array.
     */
    @SuppressWarnings("unchecked")
    public T removeAndGet(T element) throws IllegalArgumentException {
        requireNonNull(element, "Argument cannot be null");
        final var index = indexOf(element);
        var toBeRemoved = (T) new Object();
        if (index != -1) toBeRemoved = get(index);
        else throw new IllegalArgumentException(format("%s is not in the dynamic array", element));
        this.balloon[index] = null;
        trimAndGrow();
        return toBeRemoved;
    }

    /**
     * Removes an element in a specific index.
     * @param index the index of the element to be removed.
     * @return {@code true} if the element has been removed.
     */
    public boolean remove(int index) {
        checkBounds(index);
        this.balloon[index] = null;
        return trimAndGrow();
    }

    /**
     * Removes all the elements in the dynamicArray.
     */
    public void removeAll() {
        this.balloon = new Object[] {};
    }

    /**
     * Returns the index of the element in the dynamic array.
     * @param element the element to search for the index.
     * @return the index of the element in the dynamic array. If index is not present, returns -1.
     */
    public int indexOf(T element) {
        requireNonNull(element, "Argument cannot be null");
        return getIndex(element);
    }

    /**
     * Get the element at a specific index.
     * @param index the index of the element.
     * @return the element {@link  T} in the dynamic array.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkBounds(index);
        return (T) this.balloon[index];
    }

    /**
     * Get the size of the dynamic array.
     * @return {@code int} contains the size of the dynamic array.
     */
    public int size() {
        return this.balloon.length;
    }

    /**
     * Sorts the dynamic array.
     * @param ascending if sorting is ascending, otherwise descending.
     */
    public void sort(boolean ascending) {
        removeNulls();
        checkTypes();
        if (!ascending) this.balloon = this.stream()
                .sorted(Collections.reverseOrder())
                .toArray();
        else this.balloon = this.stream()
                .sorted()
                .toArray();
    }

    /**
     * Puts the dynamic array to abstraction.
     * @return a {@code Stream<T>} of objects.
     * @see Stream
     * @see Spliterators
     * @see StreamSupport
     */
    public Stream<T> stream() {
        return StreamSupport.stream(
                Spliterators.spliterator(
                        this.balloon,
                        0,
                        size(),
                        Spliterator.ORDERED | Spliterator.IMMUTABLE
                ), false
        );
    }

    /**
     * Internal implementation that checks if the dynamic array contains different types.
     * @throws IllegalStateException if the data types in the dynamic array are not all the same.
     */
    private void checkTypes() throws IllegalStateException {
        var differentTypes = Arrays.stream(this.balloon)
                .anyMatch(e -> !e.getClass().equals(this.balloon[0].getClass())); // mutability, for removal or change.
        if (differentTypes) throw new IllegalStateException("Cannot sort different types in a dynamic array");
    }

    /**
     * Internal implementation of getting the index of an element in the dynamic array.
     * @param element the element to search for the index.
     * @return the index of the element in the dynamic array. If index is not present, returns -1.
     */
    private int getIndex(T element) {
        return range(0, size())
                .filter(i -> this.balloon[i] != null)
                .filter(i -> this.balloon[i].equals(element))
                .findAny()
                .orElse(-1);
    }

    /**
     * Internal implementation of adding element in the dynamic array.
     * @param element the element to be added.
     * @return {@code true} if the element index is same as the index where it should be.
     */
    private boolean add(T element) {
        requireNonNull(element, "Argument cannot be null");
        var size = getCurrentSize.get();
        if (isFull.test(size)) trimAndGrow();
        balloon[size] = element;
        return size == indexOf(element);
    }

    /**
     * Internal implementation that trims the dynamic array and grow the length by 10.
     * @return {@code true} if the dynamic array has been trimmed and grown.
     */
    private boolean trimAndGrow() {
        var size = getCurrentSize.get();
        removeNulls();
        this.balloon = copyOf(this.stream().toArray(), size + modificationCount);
        modificationCount = 0;
        return size() == size;
    }

    /**
     * Internal implementation that removes null from the dynamic array.
     */
    private void removeNulls() {
        this.balloon = this.stream()
                .filter(Objects::nonNull)
                .toArray();
    }

    /**
     * Internal utility method, checks if index is out of bound.
     * @param index the index to be checked.
     */
    private void checkBounds(int index) {
        if (isOutOfBounds.apply(index)) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    /**
     * Internal implementation that checks filters non-null objects and count them.
     */
    private final Supplier<Integer> getCurrentSize = () -> (int) this.stream()
            .filter(Objects::nonNull)
            .count();

    /**
     * Internal implementation that checks if the dynamic array is full.
     */
    private final Predicate<Integer> isFull = currentElements -> currentElements >= size();

    /**
     * Internal implementation that checks if the index is out of bounds.
     */
    private final Function<Integer, Boolean> isOutOfBounds = index -> index > getCurrentSize.get() || index < 0;

    @Override
    public String toString() {
        return this.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
