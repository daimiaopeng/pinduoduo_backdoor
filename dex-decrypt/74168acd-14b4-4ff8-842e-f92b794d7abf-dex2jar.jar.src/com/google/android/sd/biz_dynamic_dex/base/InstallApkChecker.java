package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import com.google.android.sd.utils.DataUtils;
import java.io.File;

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
  
  private static File getCheckTmpApkFile() {
    return new File(DynamicUtils.getExtWorkDir(), "taf_check.dat2");
  }
  
  private static boolean hasApkVersionChecked(File paramFile) {
    long l1 = paramFile.lastModified();
    long l2 = DataUtils.getLong("com.google.android.sd.last_check_file_t", 0L);
    return (l2 == 0L) ? false : (!(l2 < l1));
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\74168acd-14b4-4ff8-842e-f92b794d7abf-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\InstallApkChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */