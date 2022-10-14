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
import java.util.*;
import javax.crypto.*;
import java.security.*;
import java.util.stream.IntStream;
import java.nio.charset.StandardCharsets;

/**
 * <p>The {@code SecurityUtil} class contains methods that encrypts and decrypts
 * in values of text files.</p>
 */
public final class SecurityUtil {

    /**
     * Cannot instantiate this class
     */
    private SecurityUtil() {
    }

    /**
     * encode the {@code byte[] data} to a String.
     * @param data the {@code String} to be encoded.
     * @return the encoded String.
     * @throws IllegalArgumentException if the data to be encrypted is empty.
     */
    public static String encrypt(String data) throws IllegalArgumentException {
        if (data.trim().isEmpty()) throw new IllegalArgumentException("Text to be encrypted cannot be empty");
        var b = Base64.getEncoder().encode(data.getBytes(StandardCharsets.UTF_8));
        return IntStream.range(0, b.length).map(i -> b[i]).mapToObj(Character::toString).reduce("", String::concat);
    }

    /**
     * Decodes the {@code String data} to a decoded {@code String}
     * @param data the encrypted {@code String} to be decrypted.
     * @return the decoded String.
     * @throws IllegalArgumentException if the encrypted data is empty.
     */
    public static String decrypt(String data) throws IllegalArgumentException {
        if (data.trim().isEmpty()) throw new IllegalArgumentException("Text to be decrypted cannot be empty");
        var b = Base64.getDecoder().decode(data);
        return IntStream.range(0, b.length).map(i -> b[i]).mapToObj(Character::toString).reduce("", String::concat);
    }

    /**
     * Util class {@code RSA} Rivest-Shamir-Adleman (RSA) encryption algorithm that encrypts a message and decrypts the message
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
     * Util class {@code AES} advance encryption standard that encrypts a message and decrypts the message.
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
