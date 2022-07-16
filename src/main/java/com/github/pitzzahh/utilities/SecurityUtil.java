package com.github.pitzzahh.utilities;

import java.io.*;
import java.util.*;
import javax.crypto.*;
import java.security.*;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.GCMParameterSpec;

/**
 * <p>The {@code SecurityUtil} class contains methods that encrypts and decrypts
 * in values of text files.</p>
 */
public final class SecurityUtil {

    private static final byte KEY = ((((10 * 3) + 4 ) / 4) * 2) - 26;
    private static List<Character> EU;
    private static List<Character> EP;
    private static Scanner uScanner;
    private static Scanner pScanner;
    private static String u;
    private static String p;
    private static char[] uChar;
    private static char[] pChar;

    /**
     * Cannot instantiate this class
     */
    private SecurityUtil() {}

    /**
     * Encrypts the user's username.
     * @param usernameFile the file of where the username contained.
     * @param user the username to encrypt.
     * @throws IOException if the file does not exist.
     */
    public static void encryptUserName(File usernameFile, String user) throws IOException {
        if (usernameFile.isFile()) {
            u = "";
            uScanner = new Scanner(usernameFile);
            u = uScanner.nextLine();
            uChar = u.toCharArray();
            EU = new ArrayList<>(uChar.length);
            for (char element : uChar) {
                element += (KEY * (-10));
                EU.add(element);
            }
            u = Utility.convertToString(EU);
            FileUtil.writeToATextFile(u, usernameFile);
            writeUserNameToBin(usernameFile, user);
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
     * @param pin the pin to encrypt.
     * @throws IOException if the file does not exist.
     */
    public static void encryptPin(File pinFile, String pin) throws IOException {
        if (pinFile.isFile()) {
            p = "";
            pScanner = new Scanner(pinFile);
            p = pScanner.nextLine();
            pChar = p.toCharArray();
            EP = new ArrayList<>(pChar.length);
            for (char element : pChar) {
                element += (KEY * (-10) + 4);
                EP.add(element);
            }
            p = Utility.convertToString(EP);
            FileUtil.writeToATextFile(p, pinFile);
            writePinToBin(pinFile, pin);
            EP.clear();
            pScanner.close();
            resetPChar(pChar);
        }
        else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }

    /**
     * Decrypts the username from a text file.
     * @param encryptedUsername the encrypted username file.
     * @return the decrypted username.
     */
    private static String decryptUserName(String encryptedUsername) {
        uChar = encryptedUsername.toCharArray();
        EU.clear();
        EU = new ArrayList<>(uChar.length);
        for (char bit : uChar) {
            bit -= (KEY * (-10));
            EU.add(bit);
        }
        resetUChar(uChar);
        return u = Utility.convertToString(EU);
    }

    /**
     * Decrypts the pin from a text file.
     * @param encryptedPin the encrypted pin file.
     * @return the decrypted pin.
     */
    private static String decryptPin(String encryptedPin) {
        pChar = encryptedPin.toCharArray();
        EP.clear();
        EP = new ArrayList<>(pChar.length);
        for (char bit : pChar) {
            bit -= (KEY * (-10) + 4);
            EP.add(bit);
        }
        resetPChar(pChar);
        return p = Utility.convertToString(EP);
    }

    /**
     * Checks if the username and password matched the user's credentials.
     * @param usernameFile the file of where the username contained.
     * @param pinFile the file where the password contained.
     * @param username the username to check
     * @param pin the pin to check.
     * @param isAdmin if is an admin or not, admins are only capable of viewing the credentials.
     * @return {@code true} if username and pin matches the username and pin arguments.
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
            EU = new ArrayList<>(uChar.length);
            EP = new ArrayList<>(pChar.length);
            for (char bit : uChar) {
                bit -= (KEY * (-10));
                EU.add(bit);
            }
            for (char bit : pChar) {
                bit -= (KEY * (-10) + 4);
                EP.add(bit);
            }
            u = Utility.convertToString(EU);
            p = Utility.convertToString(EP);
            EU.clear();
            EP.clear();
            uScanner.close();
            pScanner.close();
            resetUChar(uChar);
            resetPChar(pChar);
        } catch (FileNotFoundException ignored) {}
        return username.equals(u) && pin.equals(p) && readFromBin(username, isAdmin, username, pin);
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
            p = "";
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
    private static boolean readFromBin(String user, boolean isAdmin, String username, String pin) throws IOException {
        try {
            u = "";
            p = "";
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
            String uCache = dataInputStreamForUserName.readUTF();
            String pCache = dataInputStreamForPin.readUTF();
            u = decryptUserName(uCache);
            p = decryptPin(pCache);
            dataInputStreamForUserName.close();
            dataInputStreamForPin.close();
        } catch (FileNotFoundException ignored) {
        }
        return u.equals(username) && p.equals(pin);
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
            u = "";
            p = "";
            uScanner = new Scanner(userName);
            pScanner = new Scanner(pin);
            u = uScanner.nextLine();
            p = pScanner.nextLine();
            uChar = u.toCharArray();
            pChar = p.toCharArray();
            EU = new ArrayList<>(uChar.length);
            EP = new ArrayList<>(pChar.length);
            for (char bit : uChar) {
                bit -= (KEY * (-10));
                EU.add(bit);
            }
            for (char bit : pChar) {
                bit -= (KEY * (-10) + 4);
                EP.add(bit);
            }
            u = Utility.convertToString(EU);
            p = Utility.convertToString(EP);
            EU.clear();
            EP.clear();
            uScanner.close();
            pScanner.close();
        }
        else return "you'reNotAllowedToAccessThis  you're'NotAnAdministrator";
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

    /**
     * Utility class {@code OLD_AES} advance encryption standard that encrypts a message and decrypts the message
     */
    public static final class OLD_AES {

        private static SecretKey key; // contained the key
        private static Cipher encryptionCipher;
        private static final int T_LEN = 128;
        private static final int KEY_SIZE = 128;

        /**
         * Cannot instantiate this class
         */
        private OLD_AES() {}

        /**
         * Initialize the whole program.
         * @throws Exception if something went wrong.
         */
        public static void init() throws Exception {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(KEY_SIZE);
            key = generator.generateKey();
        }

        /**
         * Encrypts the message passed in.
         * @param message the message {@code String} to be encrypted.
         * @return the encrypted {@code String};
         * @throws Exception if anything went wrong.
         */
        public static String encrypt(String message) throws Exception {
            byte[] messageInBytes = message.getBytes();
            encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
            encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
            return encode(encryptedBytes);
        }

        /**
         * Decrypts the encrypted message passed in.
         * @param encryptedMessage the encrypted {@code String} to be decrypted.
         * @return the decrypted bytes;
         * @throws Exception if anything went wrong.
         */
        public static String decrypt(String encryptedMessage) throws Exception{
            byte[] messageInBytes = decode(encryptedMessage);
            Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec spec = new GCMParameterSpec(T_LEN, encryptionCipher.getIV());
            decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
            byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
            return new String(decryptedBytes);
        }
    }

    /**
     * Utility class {@code RSA} Rivest-Shamir-Adleman (RSA) encryption algorithm that encrypts a message and decrypts the message
     */
    public static final class RSA {
        private static PrivateKey privateKey;
        private static PublicKey publicKey;

        /**
         * Cannot instantiate this class.
         */
        private RSA(){}

        /**
         * Initialize the whole program.
         * @throws Exception if something went wrong.
         */
        public static void init() throws Exception {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            KeyPair pair = generator.generateKeyPair();
            privateKey = pair.getPrivate();
            publicKey = pair.getPublic();
        }

        /**
         * Encrypts the message passed in.
         * @param message the message {@code String} to be encrypted.
         * @return the encrypted {@code String};
         * @throws Exception if anything went wrong.
         */
        public String encrypt(String message) throws Exception{
            byte[] messageToBytes = message.getBytes();
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            byte[] encryptedBytes = cipher.doFinal(messageToBytes);
            return encode(encryptedBytes);
        }

        /**
         * Decrypts the encrypted message passed in.
         * @param encryptedMessage the encrypted {@code String} to be decrypted.
         * @return the decrypted bytes;
         * @throws Exception if anything went wrong.
         */
        public String decrypt(String encryptedMessage) throws Exception{
            byte[] encryptedBytes = decode(encryptedMessage);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
            return new String(decryptedMessage, StandardCharsets.UTF_8);
        }
    }

    /**
     * Utility class {@code AES} advance encryption standard that encrypts a message and decrypts the message.
     */
    public static final class AES {

        /**
         * Cannot instantiate this class.
         */
        private AES() {}

        /**
         * Generates a secret key that is needed in order to access the encrypted file.
         * @return {@code secretKey} containing secret key.
         */
        public static SecretKey generateKey() {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                SecretKey secretKey;
                secretKey = keyGenerator.generateKey();
                return secretKey;
            } catch (Exception error) {
                return null;
            }
        }

        /**
         * Encrypts the given {@code String}.
         * @param dataToEncrypt the {@code dataToEncrypt} to encrypt.
         * @param myKey the {@code SecretKey myKey} that is needed to access the encrypted file.
         * @param cipher cipher to cipher the text.
         * @return encryptedText in {@code byte} array.
         */
        public static byte[] encrypt(String dataToEncrypt, SecretKey myKey, Cipher cipher) {
            try {
                byte[] text = dataToEncrypt.getBytes(StandardCharsets.UTF_8);
                cipher.init(Cipher.ENCRYPT_MODE, myKey);
                byte[] encryptedText;
                encryptedText = cipher.doFinal(text);
                return encryptedText;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         * Encrypts the given {@code String}.
         * @param encryptedData the {@code dataToEncrypt} to decrypt.
         * @param myKey the {@code SecretKey myKey} that is needed to access the encrypted file.
         * @param cipher cipher to cipher the text.
         * @return result in {@code String}, the decrypted text.
         */
        public static String decrypt(byte[] encryptedData, SecretKey myKey, Cipher cipher) {
            try {
                cipher.init(Cipher.DECRYPT_MODE, myKey);
                byte[] decryptedText = cipher.doFinal(encryptedData);
                String result;
                result = new String(decryptedText);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         * Stores the key to a file.
         * @param keyToStore the {@code SecretKey keyToStore} that is going to be stored in the file, needed to access the encrypted file.
         * @param credential credential to protect the ke.
         * @param filePath filePath is the path where the file will be written or saved.
         * @throws Exception if something went wrong.
         */
        public static void storeToKeyStore(SecretKey keyToStore, String credential, String filePath) throws Exception {
            File file = new File(filePath);
            KeyStore javaKeyStore = KeyStore.getInstance("JCEKS");
//            if (!file.exists()) {
//                javaKeyStore.load(null, null);
//            }
            javaKeyStore.load(null, null);
            javaKeyStore.setKeyEntry("keyAlias", keyToStore, credential.toCharArray(), null);
            OutputStream outputStream = new FileOutputStream(filePath);
            javaKeyStore.store(outputStream, credential.toCharArray());
            outputStream.close();
        }

        /**
         * Loads the key from the keyStore.
         * @param credential credential to protect the ke.
         * @param filePath filePath is the path where the file is created / saved.
         * @return key, the key stored in the file.
         * @throws Exception if exception is caught.
         */
        public static SecretKey loadFromKeyStore(String credential, String filePath) throws Exception {
            KeyStore keyStore = KeyStore.getInstance("JCEKS");
            InputStream inputStream = new FileInputStream(filePath);
            keyStore.load(inputStream, credential.toCharArray());
            SecretKey key;
            key = (SecretKey) keyStore.getKey("keyAlias", credential.toCharArray());
            inputStream.close();
            return key;
        }
    }

    /**
     * encode the {@code byte[] data} to a String.
     * @param data the {@code byte[] data} to be encoded.
     * @return the encoded String.
     */
    private static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * decode the {@code String data} to a byte[] array.
     * @param data the encrypted {@code String} to be decrypted.
     * @return the decoded String.
     */
    private static byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }
}
