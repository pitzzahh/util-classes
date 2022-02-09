package lib.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public final class SecurityUtil {

    private static final byte KEY = ((((10 * 3) + 4 ) / 4) * 2) - 26;
    private static final List<Character> EU = new ArrayList<>();
    private static final List<Character> EP = new ArrayList<>();
    private static Scanner uScanner;
    private static Scanner pScanner;
    private static String u;
    private static String p;
    private static String uCache;
    private static String pCache;
    private static char[] uChar;
    private static char[] pChar;
    /**
     * Cannot instantiate this class
     */
    private SecurityUtil() {
    }
    /**
     * Encrypts the user's username.
     * @param usernameFile the file of where the username contained.
     * @throws IOException if the file does not exist.
     */
    public static void encryptUserName(File usernameFile, String user) throws IOException {
        if (usernameFile.isFile()) {
            uScanner = new Scanner(usernameFile);
            u = uScanner.nextLine();
            uChar = u.toCharArray();
            for (char element : uChar) {
                element += (KEY * (-10));
                EU.add(element);
            }
            writeUserNameToBin(usernameFile, user);
            u = ArrayUtil.getCharacters(EU);
            FileUtil.writeToATextFile(u, usernameFile);
            EU.clear();
            uScanner.close();
            resetUChar(uChar);
        }
        else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }
    /**
     * Encrypts the user's pin.
     * @param pinFile the file where the pin contained.
     * @throws IOException if the file does not exist.
     */
    public static void encryptPin(File pinFile, String user) throws IOException {
        if (pinFile.isFile()) {
            pScanner = new Scanner(pinFile);
            p = pScanner.nextLine();
            pChar = p.toCharArray();
            for (char element : pChar) {
                element += (KEY * (-10) + 4);
                EP.add(element);
            }
            writePinToBin(pinFile, user);
            p = ArrayUtil.getCharacters(EP);
            FileUtil.writeToATextFile(p, pinFile);
            EP.clear();
            pScanner.close();
            resetPChar(pChar);
        }
        else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }
    /**
     * Checks if the username and password matched the user's credentials.
     * @param usernameFile the file of where the username contained.
     * @param pinFile the file where the password contained.
     * @throws IOException if the file does not exist.
     */
    public static boolean checkCredentials(File usernameFile, File pinFile, String username, String pin, boolean isAdmin) throws IOException {
        try {
            uScanner = new Scanner(usernameFile);
            pScanner = new Scanner(pinFile);
            u = uScanner.nextLine();
            p = pScanner.nextLine();
            uChar = u.toCharArray();
            pChar = p.toCharArray();
            for (char bit : uChar) {
                bit -= (KEY * (-10));
                EU.add(bit);
            }
            for (char bit : pChar) {
                bit -= (KEY * (-10) + 4);
                EP.add(bit);
            }
            u = ArrayUtil.getCharacters(EU);
            p = ArrayUtil.getCharacters(EP);
            EU.clear();
            EP.clear();
            uScanner.close();
            pScanner.close();
            resetUChar(uChar);
            resetPChar(pChar);
        } catch (FileNotFoundException ignored) {}
        return username.equals(u) && pin.equals(p) && readFromBin(username, isAdmin);
    }

    /**
     * Method that reWrite the user's username to a binary file.
     * @param usernameFile the file of where the username contained.
     * @throws IOException if the file does not exist.
     */
    private static void writeUserNameToBin(File usernameFile, String user) throws IOException {
        try {
            uScanner = new Scanner(usernameFile);
            u = uScanner.nextLine();
            DataOutputStream dataOutputStreamForUserName = new DataOutputStream(new FileOutputStream("C:\\Users\\Public\\Cache\\" + user + "'s Folder\\uCache.bin"));
            dataOutputStreamForUserName.writeUTF(u);
            dataOutputStreamForUserName.flush();
            dataOutputStreamForUserName.close();
            uScanner.close();
        } catch (FileNotFoundException ignored) {}
    }
    /**
     * Method that reWrite the user's pin to a binary file.
     * @param pinFile the file where the pin contained.
     * @throws IOException if the file does not exist.
     */
    private static void writePinToBin(File pinFile, String user) throws IOException {
        try {
            pScanner = new Scanner(pinFile);
            p = pScanner.nextLine();
            DataOutputStream dataOutputStreamForPin = new DataOutputStream(new FileOutputStream("C:\\Users\\Public\\Cache\\" + user + "'s Folder\\pCache.bin"));
            dataOutputStreamForPin.writeUTF(p);
            dataOutputStreamForPin.flush();
            dataOutputStreamForPin.close();
            pScanner.close();
        } catch (FileNotFoundException ignored) {}
    }
    /**
     * Method that rechecks the user's credentials.
     * <p>Even though the user copied and pasted the username and password from the txt file, it still won't logged in
     * unless the user really know his/her credentials.</p>
     * @param user the username of the user.
     * @param isAdmin checks if the person who wants to log in is as admin.
     * @throws IOException if the file does not exist.
     */
    private static boolean readFromBin(String user, boolean isAdmin) throws IOException {
        try {
            DataInputStream dataInputStreamForUserName;
            DataInputStream dataInputStreamForPin;
            if (isAdmin) {
                dataInputStreamForUserName = new DataInputStream(new FileInputStream("C:\\Users\\Public\\Cache\\auth\\uCache.bin"));
                dataInputStreamForPin = new DataInputStream(new FileInputStream("C:\\Users\\Public\\Cache\\auth\\pCache.bin"));
            }
            else {
                dataInputStreamForUserName = new DataInputStream(new FileInputStream("C:\\Users\\Public\\Cache\\" + user + "'s Folder\\uCache.bin"));
                dataInputStreamForPin = new DataInputStream(new FileInputStream("C:\\Users\\Public\\Cache\\" + user + "'s Folder\\pCache.bin"));
            }
            uCache = dataInputStreamForUserName.readUTF();
            pCache = dataInputStreamForPin.readUTF();
            dataInputStreamForUserName.close();
            dataInputStreamForPin.close();
        } catch (FileNotFoundException ignored) {
        }
        return u.equals(uCache) && p.equals(pCache);
    }
    /**
     * Method that used by an admin to view users credentials by decrypting all users credentials.
     * @param userName the username file to be decrypted.
     * @param pin the pin file to be decrypted.
     * @param isAdmin checks if the one that use this is an admin
     * @return a {@code String} that contains the user's username and pin.
     * @throws FileNotFoundException if the credentials file does not exist
     */
    public static String viewCredentials(File userName, File pin, boolean isAdmin) throws FileNotFoundException {
        if (isAdmin) {
            uScanner = new Scanner(userName);
            pScanner = new Scanner(pin);
            u = uScanner.nextLine();
            p = pScanner.nextLine();
            uChar = u.toCharArray();
            pChar = p.toCharArray();
            for (char bit : uChar) {
                bit -= (KEY * (-10));
                EU.add(bit);
            }
            for (char bit : pChar) {
                bit -= (KEY * (-10) + 4);
                EP.add(bit);
            }
            u = ArrayUtil.getCharacters(EU);
            p = ArrayUtil.getCharacters(EP);
            EU.clear();
            EP.clear();
            uScanner.close();
            pScanner.close();
        }
        else {
            return "you'reNotAllowedToAccessThis  you're'NotAnAdministrator";
        }
        return u.concat(" " + p).strip();
    }
    /**
     * Resets the username char array.
     * @param uChar the username char to be refilled with empty space.
     */
    private static void resetUChar(char[] uChar) {
        Arrays.fill(uChar, ' ');
    }
    /**
     * Resets the pin char array.
     * @param pChar the pin char to be refilled with empty space.
     */
    private static void resetPChar(char[] pChar) {
        Arrays.fill(pChar, ' ');
    }
}
