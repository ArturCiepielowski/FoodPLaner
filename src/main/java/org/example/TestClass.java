package org.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        System.out.println("TEST");
        System.out.println("\033c");
//        try {
//            // Generate AES key
//            SecretKey secretKey = generateKey(128);
//
//            // Original message
//            String message = "Hello, World!";
//
//            // Encrypt the message
//            String encryptedMessage = encrypt(message, secretKey);
//            System.out.println("Encrypted Message: " + encryptedMessage);
//            System.out.println(generateKey(128).toString());
//
//            // Decrypt the message
//            String decryptedMessage = decrypt(encryptedMessage, secretKey);
//            System.out.println("Decrypted Message: " + decryptedMessage);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
