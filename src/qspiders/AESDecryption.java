package qspiders;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import org.apache.commons.codec.binary.Hex;

public class AESDecryption {

    public static SecretKey getPasswordFromKey(String key, String salt) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        KeySpec spec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 1000, 256);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        return secret;
    }

    public static String encrypt(String plainText, String password) throws Exception {
        // Generate a random initialization vector (IV)
        SecureRandom secureRandom = new SecureRandom();
        byte[] initializationVector = new byte[16]; // 16 bytes = 128 bits (AES block size)
        secureRandom.nextBytes(initializationVector);

        // Derive the AES key from the password and IV
        SecretKey secretKey = getPasswordFromKey(password, new String(initializationVector));

        // Initialize the cipher for encryption
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(initializationVector));

        // Encrypt the plaintext
        byte[] encryptedData = cipher.doFinal(plainText.getBytes());

        // Combine the IV and encrypted data, and return it as a Hex-encoded string
        byte[] combined = new byte[initializationVector.length + encryptedData.length];
        System.arraycopy(initializationVector, 0, combined, 0, initializationVector.length);
        System.arraycopy(encryptedData, 0, combined, initializationVector.length, encryptedData.length);
        
        // Return the result as a Hex string
        return Hex.encodeHexString(combined);
    }

    // Method to decrypt the message
    public static String decrypt(String input, String password) throws Exception {
        byte[] encodedByteArr = Hex.decodeHex(input);

        // Extract the IV and encrypted data
        byte[] initializationVector = Arrays.copyOfRange(encodedByteArr, 0, 16);
        byte[] encodedData = Arrays.copyOfRange(encodedByteArr, 16, encodedByteArr.length);

        // Derive the AES key from the password and IV
        SecretKey secretKey = getPasswordFromKey(password, new String(initializationVector));

        // Initialize the cipher for decryption
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(initializationVector));

        // Decrypt the data
        byte[] decodedData = cipher.doFinal(encodedData);

        // Return the decrypted data as a string
        return new String(decodedData);
    }

    public static void main(String[] args) {
        try {
            String plainText = "This is a secret message!";
            String password = "ZC_TRAM";

            // Encrypt the message
            String encryptedText = encrypt(plainText, password);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decrypt the message
            String decryptedText = decrypt(encryptedText, password);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
