package com.github.pitzzahh.utilities;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public final class FileUtil {

    /**
     * Cannot instantiate this class
     */
    private FileUtil() {}
    /**
     * Writes to a text file
     * @param whatToWrite the {@code String} to be written on the file
     * @param fileToWrite the file to be written.
     * @throws IOException if the file does not exist.
     */
    public static void writeToATextFile(String whatToWrite, File fileToWrite) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToWrite, true));
        bufferedWriter.write(whatToWrite);
        bufferedWriter.close();
    }

    /**
     *
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
}
