package lib.utilities;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public final class SecurityUtil {

    private static final byte KEY = -10;
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
     * Encrypts the user's username and password.
     * @param usernameFile the file of where the username contains
     * @param pinFile the file where the password contains
     * @throws IOException if the file does not exist
     */
    public static void encrypt(File usernameFile, File pinFile, String user) throws IOException {
        if (usernameFile.isFile() && pinFile.isFile()) {
            uScanner = new Scanner(usernameFile);
            pScanner = new Scanner(pinFile);
            u = uScanner.nextLine();
            p = pScanner.nextLine();
            uChar = u.toCharArray();
            pChar = p.toCharArray();
            uScanner.close();
            pScanner.close();
            for (char elements : uChar) {
                elements += (KEY * (-10));
                EU.add(elements);
            }
            for (char elements : pChar) {
                elements += (KEY * (-10) + 4);
                EP.add(elements);
            }
            u = ArrayUtil.getCharacters(EU);
            p = ArrayUtil.getCharacters(EP);
            FileUtil.writeToATextFile(u, usernameFile);
            FileUtil.writeToATextFile(p, pinFile);
            EU.clear();
            EP.clear();
            writeToBin(usernameFile, pinFile, user);
        }
        else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }
    /**
     * Checks if the username and password matched the user's credentials.
     * @param usernameFile the file of where the username contains.
     * @param pinFile the file where the password contains.
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
            uScanner.close();
            pScanner.close();
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
        } catch (FileNotFoundException ignored) {}
        return username.equals(u) && pin.equals(p) && readFromBin(usernameFile, pinFile, username, isAdmin);
    }

    /**
     * Method that reWrite the user's username to a binary file.
     * @param usernameFile the file of where the username contains.
     * @param pinFile the file where the password contains.
     * @throws IOException if the file does not exist.
     */
    private static void writeToBin(File usernameFile, File pinFile, String user) throws IOException {
        try {
            uScanner = new Scanner(usernameFile);
            pScanner = new Scanner(pinFile);
            u = uScanner.nextLine();
            p = pScanner.nextLine();
            DataOutputStream dataOutputStreamForUserName = new DataOutputStream(new FileOutputStream("C:\\Users\\Public\\Cache\\" + user + "'s Folder\\uCache.bin"));
            DataOutputStream dataOutputStreamForPin = new DataOutputStream(new FileOutputStream("C:\\Users\\Public\\Cache\\" + user + "'s Folder\\pCache.bin"));
            dataOutputStreamForUserName.writeUTF(u);
            dataOutputStreamForPin.writeUTF(p);
            dataOutputStreamForUserName.flush();
            dataOutputStreamForPin.flush();
            dataOutputStreamForUserName.close();
            dataOutputStreamForPin.close();
        } catch (FileNotFoundException ignored) {}
    }
    /**
     * Method that rechecks the user's credentials.
     * <p>Even though the user copied and pasted the username and password from the txt file, it still won't logged in
     * unless the user really know his/her credentials.</p>
     * @param usernameFile the file of where the username contains.
     * @param pinFile the file where the password contains.
     * @throws IOException if the file does not exist.
     */
    private static boolean readFromBin(File usernameFile, File pinFile, String user, boolean isAdmin) throws IOException {
        try {
            uScanner = new Scanner(usernameFile);
            pScanner = new Scanner(pinFile);
            u = uScanner.nextLine();
            p = pScanner.nextLine();
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
            uScanner.close();
            pScanner.close();
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
        }
        else {
            return "you'reNotAllowedToAccessThis  you're'NotAnAdministrator";
        }
        return u.concat(" " + p).strip();
    }
}
