package lib.utilities;

import lib.systems.studentManagementSystem.studentConstruct.Student;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public final class FileUtil {
    /**
     * Cannot instantiate this class
     */
    private FileUtil() {
    }
    /**
     * Writes to a text file
     * @param whatToWrite the {@code String} to be written on the file
     * @param fileToWrite the file to be written.
     * @throws IOException if the file does not exist.
     */
    public static void writeToATextFile(String whatToWrite, File fileToWrite) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToWrite));
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
    /**
     * Converts the ArrayList studentsList into a text file, <file name>.txt
     * @param list of all students that will write to file.
     * @param path directory where the student list will be saved.
     */
    public static void writeFile(final ArrayList<Student> list, final String path) {
        try {
            // creates a file stream in UTF-8
            FileOutputStream fileOutputStream = new FileOutputStream(path + ".txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            // write list
            for (Student student : list) {
                bufferedWriter.write(student.toString());
                bufferedWriter.newLine();
            }
            // close file
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();

        }
        catch (Exception ignored) {
        }
        // return false if any error.
    }
    /**
     * Reads the .bin files to be exported in the ArrayList studentsList
     * @param path of the file that needs to be imported
     * @return studentsList a list of student read from the file
     */
    public static ArrayList<Student> readFileBinary(final String path, final String fileName) {
        Student temporaryStudent;
        ArrayList<Student> studentsList = new ArrayList<>();

        try {
            // create file
            DataInputStream data_input_stream = new DataInputStream(new FileInputStream(path + fileName + ".bin"));

            // read size of list
            int size = data_input_stream.readInt();

            // read all
            for (int i = 0; i < size; i++) {
                temporaryStudent = new Student();
                temporaryStudent.setId(data_input_stream.readUTF());
                temporaryStudent.setFirstName(data_input_stream.readUTF());
                temporaryStudent.setLastName(data_input_stream.readUTF());
                temporaryStudent.setAge(data_input_stream.readByte());
                temporaryStudent.setGender((data_input_stream.readUTF()));
                temporaryStudent.setSchool(data_input_stream.readUTF());
                temporaryStudent.setCourse(data_input_stream.readUTF());
                studentsList.add(temporaryStudent);
            }
            data_input_stream.close();
        }
        catch (Exception ignored) {
        }
        // returns student data.
        return studentsList;
    }
    /**
     * Converts the ArrayList studentsList into a binary file, <file name>.bin
     * @param list of all students.
     * @param path that need to write.
     */
    public static void writeFileBinary(final ArrayList<Student> list, final String path) {
        try {
            // open file in binary mode, added .bin extension because the file when exported is already .bin file with the txt file(readable txt file)
            DataOutputStream data_output_stream = new DataOutputStream(new FileOutputStream("src\\lib\\systems\\studentManagementSystem\\username.txt"));
            // determines the size of the arrayList to be used
            data_output_stream.writeInt(list.size());
            // list
            for (Student student : list) {
                data_output_stream.writeUTF(student.getId());
                data_output_stream.writeUTF(student.getFirstName());
                data_output_stream.writeUTF(student.getLastName());
                data_output_stream.writeByte(student.getAge());
                data_output_stream.writeUTF(student.getGender());
                data_output_stream.writeUTF(student.getSchool());
                data_output_stream.writeUTF(student.getCourse());
            }
            // close
            data_output_stream.flush();
            data_output_stream.close();
        }
        catch (Exception ignored) {
        }
    }
}
