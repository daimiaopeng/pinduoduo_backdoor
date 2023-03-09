package com.google.android.sd.biz_dynamic_dex.oppo_proxy;

import android.content.Context;
import android.os.Bundle;

public interface IProxyServerBase {
  public static final String EXECUTE = "innerExecute";
  
  void init(Context paramContext);
  
  Bundle innerExecute(Bundle paramBundle);
  
  void innerExecute(Bundle paramBundle, InnerExecuteCallback paramInnerExecuteCallback);
  
  public static interface InnerExecuteCallback {
    void onExecute(Bundle param1Bundle);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_proxy\IProxyServerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */