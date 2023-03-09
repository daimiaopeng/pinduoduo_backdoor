package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

public class FileFpUtil {
  private static final int READ_BUFFER_SIZE = 8192;
  
  public static Uri buildGrantedUri(Uri paramUri, String paramString) {
    Uri uri = paramUri;
    if (paramUri != null) {
      if (TextUtils.isEmpty(paramString))
        return paramUri; 
      Uri.Builder builder = paramUri.buildUpon();
      String str = paramString;
      if (paramString.startsWith("/"))
        str = paramString.substring(1); 
      uri = builder.appendEncodedPath(str).build();
    } 
    return uri;
  }
  
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
  
  public static boolean checkHasPermission(Context paramContext, Uri paramUri) {
    return (paramContext.checkCallingOrSelfUriPermission(paramUri, 3) == 0);
  }
  
  public static boolean copyFile(Context paramContext, Uri paramUri, File paramFile) {
    Exception exception1;
    ParcelFileDescriptor parcelFileDescriptor = getPfdByUri(paramContext, paramUri, "r");
    boolean bool1 = false;
    boolean bool2 = false;
    if (parcelFileDescriptor == null)
      return false; 
    Exception exception3 = null;
    Exception exception2 = null;
    try {
      Exception exception4;
      Exception exception5;
      FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
      if (fileDescriptor == null)
        return bool1; 
      FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
      try {
        FileInputStream fileInputStream1;
        FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
        try {
          bool2 = copyFileByStream(fileInputStream, fileOutputStream);
          if (bool2)
            bool1 = true; 
        } catch (Exception null) {
        
        } finally {
          exception2 = null;
          fileInputStream1 = fileInputStream;
        } 
        safetyClose(fileOutputStream);
        safetyClose(fileInputStream1);
        safetyClosePfd(parcelFileDescriptor);
        throw exception4;
      } catch (Exception null) {
      
      } finally {
        exception3 = null;
        exception1 = exception2;
        exception5 = exception4;
      } 
      safetyClose((Closeable)exception1);
      safetyClose((Closeable)exception5);
      safetyClosePfd(parcelFileDescriptor);
      throw exception4;
    } catch (Exception exception) {
    
    } finally {
      paramFile = null;
      exception1 = exception2;
      safetyClose((Closeable)exception1);
      safetyClose((Closeable)paramFile);
      safetyClosePfd(parcelFileDescriptor);
    } 
    safetyClose((Closeable)exception1);
    safetyClose((Closeable)paramContext);
    safetyClosePfd(parcelFileDescriptor);
    return false;
  }
  
  public static boolean copyFile(Context paramContext, File paramFile, Uri paramUri) {
    FileOutputStream fileOutputStream1;
    FileOutputStream fileOutputStream2;
    if (!paramFile.exists())
      return false; 
    ParcelFileDescriptor parcelFileDescriptor = getPfdByUri(paramContext, paramUri, "w");
    if (parcelFileDescriptor == null)
      return false; 
    paramUri = null;
    try {
      FileOutputStream fileOutputStream;
      FileDescriptor fileDescriptor1;
      FileInputStream fileInputStream2;
      FileDescriptor fileDescriptor2 = parcelFileDescriptor.getFileDescriptor();
      if (fileDescriptor2 == null)
        return false; 
      FileInputStream fileInputStream1 = new FileInputStream(paramFile);
      try {
        FileDescriptor fileDescriptor;
        FileOutputStream fileOutputStream3 = new FileOutputStream(fileDescriptor2);
        try {
          return true;
        } catch (Exception exception) {
        
        } finally {
          fileDescriptor2 = null;
          fileInputStream2 = fileInputStream1;
          fileOutputStream = fileOutputStream3;
        } 
        safetyClose(fileOutputStream);
        safetyClose(fileInputStream2);
        safetyClosePfd(parcelFileDescriptor);
        throw fileDescriptor;
      } catch (Exception exception) {
      
      } finally {
        paramFile = null;
        fileDescriptor2 = null;
        fileOutputStream2 = fileOutputStream;
      } 
      safetyClose((Closeable)fileDescriptor1);
      safetyClose(fileOutputStream2);
      safetyClosePfd(parcelFileDescriptor);
      throw paramFile;
    } catch (Exception exception) {
    
    } finally {
      fileOutputStream2 = null;
      fileOutputStream1 = fileOutputStream2;
      safetyClose(fileOutputStream1);
      safetyClose(fileOutputStream2);
      safetyClosePfd(parcelFileDescriptor);
    } 
    safetyClose((Closeable)paramFile);
    safetyClose(fileOutputStream1);
    safetyClosePfd(parcelFileDescriptor);
    return false;
  }
  
  private static boolean copyFileByStream(FileInputStream paramFileInputStream, FileOutputStream paramFileOutputStream) {
    try {
      byte[] arrayOfByte = new byte[8192];
      while (true) {
        int i = paramFileInputStream.read(arrayOfByte);
        if (i > 0) {
          paramFileOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        paramFileOutputStream.flush();
        return true;
      } 
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static String copyFileStr(Context paramContext, File paramFile, Uri paramUri) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual exists : ()Z
    //   4: ifne -> 10
    //   7: ldc 'source_file_not_exist'
    //   9: areturn
    //   10: aload_0
    //   11: aload_2
    //   12: ldc 'w'
    //   14: invokestatic getPfdByUri : (Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   17: astore #5
    //   19: aload #5
    //   21: ifnonnull -> 27
    //   24: ldc 'get_dest_pdf_fail'
    //   26: areturn
    //   27: aconst_null
    //   28: astore_2
    //   29: aconst_null
    //   30: astore_3
    //   31: aconst_null
    //   32: astore #4
    //   34: aload #5
    //   36: invokevirtual getFileDescriptor : ()Ljava/io/FileDescriptor;
    //   39: astore #6
    //   41: aload #6
    //   43: ifnonnull -> 64
    //   46: ldc 'get_dest_fd_fail'
    //   48: astore_0
    //   49: aconst_null
    //   50: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   53: aconst_null
    //   54: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   57: aload #5
    //   59: invokestatic safetyClosePfd : (Landroid/os/ParcelFileDescriptor;)V
    //   62: aload_0
    //   63: areturn
    //   64: new java/io/FileInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial <init> : (Ljava/io/File;)V
    //   72: astore_0
    //   73: aload_0
    //   74: astore_1
    //   75: new java/io/FileOutputStream
    //   78: dup
    //   79: aload #6
    //   81: invokespecial <init> : (Ljava/io/FileDescriptor;)V
    //   84: astore_3
    //   85: aload_0
    //   86: aload_3
    //   87: invokestatic copyFileByStream : (Ljava/io/FileInputStream;Ljava/io/FileOutputStream;)Z
    //   90: ifne -> 111
    //   93: ldc 'copy_fail'
    //   95: astore_1
    //   96: aload_3
    //   97: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   100: aload_0
    //   101: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   104: aload #5
    //   106: invokestatic safetyClosePfd : (Landroid/os/ParcelFileDescriptor;)V
    //   109: aload_1
    //   110: areturn
    //   111: ldc 'success'
    //   113: astore_1
    //   114: goto -> 96
    //   117: astore_2
    //   118: goto -> 217
    //   121: astore_1
    //   122: aload_3
    //   123: astore #4
    //   125: aload_1
    //   126: astore_3
    //   127: goto -> 143
    //   130: astore_3
    //   131: goto -> 143
    //   134: astore_2
    //   135: aconst_null
    //   136: astore_0
    //   137: goto -> 217
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_0
    //   143: aload_0
    //   144: astore_1
    //   145: aload #4
    //   147: astore_2
    //   148: new java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial <init> : ()V
    //   155: astore #6
    //   157: aload_0
    //   158: astore_1
    //   159: aload #4
    //   161: astore_2
    //   162: aload #6
    //   164: ldc 'copy_error_'
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_0
    //   171: astore_1
    //   172: aload #4
    //   174: astore_2
    //   175: aload #6
    //   177: aload_3
    //   178: invokevirtual getMessage : ()Ljava/lang/String;
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_0
    //   186: astore_1
    //   187: aload #4
    //   189: astore_2
    //   190: aload #6
    //   192: invokevirtual toString : ()Ljava/lang/String;
    //   195: astore_3
    //   196: aload #4
    //   198: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   201: aload_0
    //   202: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   205: aload_3
    //   206: astore_0
    //   207: goto -> 57
    //   210: astore_0
    //   211: aload_2
    //   212: astore_3
    //   213: aload_0
    //   214: astore_2
    //   215: aload_1
    //   216: astore_0
    //   217: aload_3
    //   218: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   221: aload_0
    //   222: invokestatic safetyClose : (Ljava/io/Closeable;)V
    //   225: aload #5
    //   227: invokestatic safetyClosePfd : (Landroid/os/ParcelFileDescriptor;)V
    //   230: aload_2
    //   231: athrow
    // Exception table:
    //   from	to	target	type
    //   34	41	140	java/lang/Exception
    //   34	41	134	finally
    //   64	73	140	java/lang/Exception
    //   64	73	134	finally
    //   75	85	130	java/lang/Exception
    //   75	85	210	finally
    //   85	93	121	java/lang/Exception
    //   85	93	117	finally
    //   148	157	210	finally
    //   162	170	210	finally
    //   175	185	210	finally
    //   190	196	210	finally
  }
  
  public static String getFileMd5(Context paramContext, Uri paramUri) {
    if (paramUri == null)
      return null; 
    ParcelFileDescriptor parcelFileDescriptor = getPfdByUri(paramContext, paramUri, "r");
    return (parcelFileDescriptor == null) ? null : getFileMd5(paramContext, parcelFileDescriptor);
  }
  
  public static String getFileMd5(Context paramContext, ParcelFileDescriptor paramParcelFileDescriptor) {
    if (paramParcelFileDescriptor == null)
      return null; 
    try {
      FileDescriptor fileDescriptor = paramParcelFileDescriptor.getFileDescriptor();
      if (fileDescriptor == null)
        return null; 
      String str = getStreamMd5(new FileInputStream(fileDescriptor));
      boolean bool = TextUtils.isEmpty(str);
    } catch (Exception exception) {
    
    } finally {
      safetyClosePfd(paramParcelFileDescriptor);
    } 
    safetyClosePfd(paramParcelFileDescriptor);
    return null;
  }
  
  public static ParcelFileDescriptor getPfdByUri(Context paramContext, Uri paramUri, String paramString) {
    try {
      return paramContext.getContentResolver().openFileDescriptor(paramUri, paramString);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static String getStreamMd5(FileInputStream paramFileInputStream) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte = new byte[8192];
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
      return null;
    } finally {
      safetyClose(paramFileInputStream);
    } 
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
  
  public static void safetyClosePfd(ParcelFileDescriptor paramParcelFileDescriptor) {
    if (paramParcelFileDescriptor != null)
      try {
        paramParcelFileDescriptor.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static boolean writeFile(Context paramContext, String paramString, Uri paramUri) {
    StringBuilder stringBuilder;
    ParcelFileDescriptor parcelFileDescriptor = getPfdByUri(paramContext, paramUri, "w");
    if (parcelFileDescriptor == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("get dest pdf fail: ");
      stringBuilder.append(paramUri);
      DynamicUtils.debugLog(stringBuilder.toString());
      return false;
    } 
    try {
      FileDescriptor fileDescriptor = stringBuilder.getFileDescriptor();
      if (fileDescriptor == null) {
        DynamicUtils.debugLog("get dest fd fail.");
        safetyClosePfd((ParcelFileDescriptor)stringBuilder);
        return false;
      } 
      if (!writeFileByStream(paramString, new FileOutputStream(fileDescriptor))) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("write file fail: ");
        stringBuilder2.append(paramUri);
        DynamicUtils.debugLog(stringBuilder2.toString());
        safetyClosePfd((ParcelFileDescriptor)stringBuilder);
        return false;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("write file success: ");
      stringBuilder1.append(paramUri);
      DynamicUtils.debugLog(stringBuilder1.toString());
      safetyClosePfd((ParcelFileDescriptor)stringBuilder);
      return true;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("write file error: ");
      stringBuilder1.append(paramUri);
      DynamicUtils.debugLog(stringBuilder1.toString(), exception);
      safetyClosePfd((ParcelFileDescriptor)stringBuilder);
      return false;
    } finally {}
    safetyClosePfd((ParcelFileDescriptor)stringBuilder);
    throw paramString;
  }
  
  private static boolean writeFileByStream(String paramString, FileOutputStream paramFileOutputStream) {
    try {
      paramFileOutputStream.write(paramString.getBytes());
      paramFileOutputStream.flush();
      safetyClose(paramFileOutputStream);
      return true;
    } catch (Exception exception) {
      DynamicUtils.debugLog("write file by stream error.", exception);
      safetyClose(paramFileOutputStream);
      return false;
    } finally {}
    safetyClose(paramFileOutputStream);
    throw paramString;
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\da60112a4b2848adba2ac11f412cccc7-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\FileFpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */