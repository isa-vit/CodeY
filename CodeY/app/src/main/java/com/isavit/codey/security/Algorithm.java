package com.isavit.codey.security;

import android.util.Base64;

import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Algorithm {

    private String key = "";

    public static String encryption(String plainText) {

        String encryptedText = "";

        return encryptedText;
    }

    public static String decryption(String cipherText) {

        String decryptedText = "";


        return decryptedText;

    }

    public static String getHash(String text) {

        // Generate a 512-bit key
        final int outputKeyLength = 512;

        char[] chars = new char[text.length()];
        text.getChars(0, text.length(), chars, 0);
        byte[] salt = "PBKDF2WithHmacSHA1".getBytes();

        byte[] hashedPassBytes = new byte[0];
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            KeySpec keySpec = new PBEKeySpec(chars, salt, 1000, outputKeyLength);

            hashedPassBytes = secretKeyFactory.generateSecret(keySpec).getEncoded();
        } catch (Exception shouldNotHappen) {
        }

        return Base64.encodeToString(hashedPassBytes, Base64.DEFAULT);

    }

}
