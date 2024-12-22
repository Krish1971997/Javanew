package qspiders;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class PasswordEncryption {

    // Method to encrypt the password
    public static String encrypt(String password, String key) throws Exception {
        // Create a new SecretKeySpec
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        
        // Create a Cipher object and initialize it for encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        // Encrypt the password
        byte[] encryptedPassword = cipher.doFinal(password.getBytes());
        
        // Return the encrypted password as a Base64 encoded string
        return Base64.getEncoder().encodeToString(encryptedPassword);
    }

    // Method to decrypt the password
    public static String decrypt(String encryptedPassword, String key) throws Exception {
        // Create a new SecretKeySpec
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        
        // Create a Cipher object and initialize it for decryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        // Decode the encrypted password from Base64
        byte[] decodedPassword = Base64.getDecoder().decode(encryptedPassword);
        
        // Decrypt the password
        byte[] originalPassword = cipher.doFinal(decodedPassword);
        
        // Return the decrypted password as a string
        return new String(originalPassword);
    }

    public static void main(String[] args) {
        try {
            String password = "mySuperSecretPassword";
            String key = "1234567890123456"; // Key must be 16 bytes for AES-128

            // Encrypt the password
            String encryptedPassword = encrypt(password, key);
            System.out.println("Encrypted Password: " + encryptedPassword);

            // Decrypt the password
            String decryptedPassword = decrypt(encryptedPassword, key);
            System.out.println("Decrypted Password: " + decryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
