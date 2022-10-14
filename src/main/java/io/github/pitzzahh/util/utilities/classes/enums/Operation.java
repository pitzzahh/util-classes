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

package io.github.pitzzahh.util.utilities.classes.enums;

/**
 * Enum of operations.
 */
public enum Operation {

    /**
     * Used to multiply
     */
    MULTIPLICATION("Used multiply"),
    /**
     * Used to divide.
     */
    DIVISION("Used to divide"),
    /**
     * Used to add.
     */
    ADDITION("Used to add"),
    /**
     * Used to subtract.
     */
    SUBTRACTION("Used to subtract"),
    /**
     * Used to get the remainder of a division
     */
    MODULO("Used to get the remainder");

    /**
     * Contains the info about an enum.
     */
    private final String INFORMATION;

    /**
     * Sets the info about an enum.
     * @param info the info of the enum.
     */
    Operation(String info) {
        this.INFORMATION = info;
    }

    /**
     * Gets the information about the enum.
     * @return a {@code String} containing the info about the enum.
     */
    public String getInformation() {
        return this.INFORMATION;
    }

}
