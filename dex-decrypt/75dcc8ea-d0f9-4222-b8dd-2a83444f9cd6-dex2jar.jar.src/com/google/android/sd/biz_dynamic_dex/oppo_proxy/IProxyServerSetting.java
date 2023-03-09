package com.google.android.sd.biz_dynamic_dex.oppo_proxy;

import android.content.Context;
import com.coloros.backup.sdk.v2.common.host.BREngineConfig;
import com.coloros.backup.sdk.v2.component.BRPluginHandler;

public interface IProxyServerSetting extends IProxyServerBase {
  void onCreate(Context paramContext, BRPluginHandler paramBRPluginHandler);
  
  void onCreate(Context paramContext, BRPluginHandler paramBRPluginHandler, BREngineConfig paramBREngineConfig);
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_proxy\IProxyServerSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */