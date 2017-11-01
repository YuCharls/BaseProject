package com.example.yc.mvpdemo.utils;


import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    private static final String IV_STRING = "16-Bytes--String";

    public static String encode(String content, String key) {
        byte[] encryptedBytes = null;
        try {
            byte[] byteContent = content.getBytes("UTF-8");

            byte[] enCodeFormat = key.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");

            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);

            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            encryptedBytes = cipher.doFinal(byteContent);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 同样对加密后数据进行 base64 编码
        return Base64.encodeToString(encryptedBytes, Base64.DEFAULT).replaceAll("\r|\n", "");
    }

    public static String decode(String content, String key) {
        try {
            // base64 解码
            byte[] encryptedBytes = Base64.decode(content, Base64.DEFAULT);

            byte[] enCodeFormat = key.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");

            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

            byte[] result = cipher.doFinal(encryptedBytes);
            return new String(result, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}