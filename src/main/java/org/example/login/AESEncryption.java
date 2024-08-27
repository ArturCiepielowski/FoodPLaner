package org.example.login;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.util.Base64;

public class AESEncryption {
    private final static String KEY_PATH = "src/main/resources/aesKey.key";
    public static SecretKey loadKey() throws Exception {
        byte[] keyBytes;
        try (FileInputStream fis = new FileInputStream(KEY_PATH)) {
            keyBytes = fis.readAllBytes();
        }
        String encodedKey = new String(keyBytes);
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }
    public static String encrypt(String message) throws Exception {
        SecretKey secretKey = loadKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    public static String decrypt(String encryptedMessage) throws Exception {
        SecretKey secretKey = loadKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }
}
