package com.github.pitzzahh.utilities;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
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
     * Text file will not be overriden when new contents is written, new contents will be written below the current content.
     * @param whatToWrite the {@code String} to be written on the file.
     * @param fileToWrite the file to be written.
     * @throws IOException if the file does not exist.
     */
    public static void writeToATextFile(String whatToWrite, File fileToWrite) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToWrite, true));
        bufferedWriter.write(whatToWrite);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    /**
     * Read the contents of a file, each line.
     * @param fileToRead the file to be read
     * @throws IOException if the file does not exist.
     */
    public static void readFile(File fileToRead) throws IOException {
        if (fileToRead.exists() && fileToRead.isFile()) {
            Scanner fileScanner = new Scanner(fileToRead);
            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();
                System.out.println(data);
            }
            fileScanner.close();
        }
        else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }

    /**
     * Reads a file and adds it to a {@code List<String>}.
     * A delimeter can be used.
     * @param file the file to read.
     * @param delimeter the delimeter
     * @return a {@code List<String>} containing the contents of the file.
     * @throws FileNotFoundException if the file does not exist.
     */
    public static List<String> getFileContents(File file, String delimeter) throws FileNotFoundException {
        return new Scanner(file).useDelimiter(delimeter).tokens().toList();
    }
}
