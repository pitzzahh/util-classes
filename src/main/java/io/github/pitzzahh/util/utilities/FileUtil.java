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

package io.github.pitzzahh.util.utilities;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Class used to some file operations.
 */
public final class FileUtil {

    /**
     * Cannot instantiate this class
     */
    private FileUtil() {}

    /**
     * Writes to a text file.
     * Text file will not be overridden when new contents is written, new contents will be written below the current content.
     * @param whatToWrite the {@code String} to be written on the file.
     * @param fileToWrite the file to be written.
     * @param writeToBottom if the string to write would be writer at the bottom line of the text file.
     * @throws IOException if the file does not exist.
     */
    public static void writeToATextFile(String whatToWrite, File fileToWrite, boolean writeToBottom) throws IOException {
        var bufferedWriter = new BufferedWriter(new FileWriter(fileToWrite, writeToBottom));
        bufferedWriter.write(whatToWrite);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    /**
     * Read the contents of a file, each line.
     * @param fileToRead the file to be read
     * @throws IOException if the file is not a valid file, or it does not exist.
     */
    @SuppressWarnings("resource")
    public static void printFileContents(File fileToRead) throws IOException {
        Objects.requireNonNull(fileToRead, "File cannot be null");
        Files.lines(Paths.get(fileToRead.getAbsolutePath()))
                .forEach(Print::println);
    }

    /**
     * Gets the file contents of each line, splits them using a delimiter and storing each line to an array.
     * @param file the file to get the contents
     * @param line what lines in the text file to skip, if 0, no lines will be skipped
     * @param separator the line separator, if null, wil throw NullPointerException. To separate
     *                  every character in each line use an empty {@code String} ""
     * @return a {@code List<String[]>} the contents of the file.
     * @throws IOException if something is wrong with file operations.
     */
    @SuppressWarnings("resource")
    public static List<String[]> getFileContents(File file, int line, String separator) throws IOException {
        Objects.requireNonNull(file, "File cannot be null");
        Objects.requireNonNull(separator, "separator cannot be null, please use an empty String to separate everything (\"\")");
        return Files.lines(Paths.get(file.getAbsolutePath()))
                .skip(line)
                .map(a -> Arrays.stream(a.split(separator)).map(String::trim).collect(Collectors.joining(separator)))
                .map(e -> e.split(separator))
                .collect(Collectors.toList());
    }
}
