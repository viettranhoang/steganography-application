/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staganography.app.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author NAM
 */
public class AES {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    
 
    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
           JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
        catch (UnsupportedEncodingException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
 
    public static String encrypt(String input, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
           // System.out.println("Error while encrypting: " + e.toString());
            JOptionPane.showMessageDialog(new JFrame(),"Error while encrypting: " + e.toString() );
        }
        return null;
    }
 
    public static String decrypt(String input, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(input)));
        }
        catch (Exception e)
        {
            //System.out.println("Error while decrypting: " + e.toString());
            JOptionPane.showMessageDialog(new JFrame(),"Sai mật khẩu ");
        }
        return null;
    }
}
