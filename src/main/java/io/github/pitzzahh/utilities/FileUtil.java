package io.github.pitzzahh.utilities;

import java.io.*;
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
    public static void printFileContents(File fileToRead) throws IOException {
        Objects.requireNonNull(fileToRead, "File cannot be null");
        Files.lines(Paths.get(fileToRead.getAbsolutePath()))
                .forEach(Print::println);
    }

    /**
     * Gets the file contents of each line, splits them using a delimiter and storing each line to an array.
     * @param file the file to get the contents
     * @param line what lines in the text file to skip, if 0, no lines will be skipped
     * @param delimiter the line separator
     * @return a {@code List<String[]>} the contents of the file.
     * @throws IOException if something is wrong with file operations.
     */
    public static List<String[]> getFileContents(File file, int line, String delimiter) throws IOException {
        Objects.requireNonNull(file, "File cannot be null");
        return Files.lines(Paths.get(file.getAbsolutePath()))
                .skip(line)
                .map(s -> s.split(delimiter))
                .collect(Collectors.toList());
    }
}
