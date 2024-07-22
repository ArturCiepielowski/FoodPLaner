package org.example;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

public class TestClass {

    public static void main(String[] args) {
        try {
            // Generate AES key
//            SecretKey secretKey = generateKey(128);
            String relativePath = "src/main/resources/aesKey.key";
//            saveKey(secretKey, absolutePath);
            // Original message
            SecretKey secretKey = loadKey(relativePath);
            String message = "Hello, World!";
            // Encrypt the message
            String encryptedMessage = encrypt(message, secretKey);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Decrypt the message
//            String decryptedMessage = decrypt(message, secretKey);
            String decryptedMessage = decrypt(encryptedMessage, secretKey);
            System.out.println("Decrypted Message: " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to save the key to a file
    public static void saveKey(SecretKey key, String fileName) throws Exception {
        byte[] keyBytes = key.getEncoded();
        String encodedKey = Base64.getEncoder().encodeToString(keyBytes);
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(encodedKey.getBytes());
        }
    }

    // Method to load the key from a file
    public static SecretKey loadKey(String fileName) throws Exception {
        byte[] keyBytes;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            keyBytes = fis.readAllBytes();
        }
        String encodedKey = new String(keyBytes);
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    public static SecretKey generateKey(int n) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(n);
        SecretKey key = keyGen.generateKey();
        return key;
    }

    public static String encrypt(String message, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedMessage, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

}
