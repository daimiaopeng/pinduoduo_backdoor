package com.google.android.sd.biz_dynamic_dex.oppo_proxy.server;

import com.google.android.sd.biz_dynamic_dex.base.Crypto;
import com.google.android.sd.biz_dynamic_dex.base.INotBizProcess;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class HttpUtils implements INotBizProcess {
  private static void closeQuietly(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static String get(String paramString1, String paramString2) {
    return request(paramString1, paramString2, Method.GET);
  }
  
  public static String post(String paramString1, String paramString2) {
    return request(paramString1, paramString2, Method.POST);
  }
  
  private static String request(String paramString1, String paramString2, Method paramMethod) {
    try {
      byte[] arrayOfByte = Crypto.randomAesKey();
      String str1 = Crypto.encryptAesKey(arrayOfByte);
      String str2 = Crypto.encrypt(arrayOfByte, paramString2);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("key", str1);
      hashMap.put("data", str2);
      HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString1)).openConnection();
      boolean bool = true;
      httpURLConnection.setDoInput(true);
      if (paramMethod != Method.POST)
        bool = false; 
      httpURLConnection.setDoOutput(bool);
      httpURLConnection.setUseCaches(false);
      httpURLConnection.setRequestMethod(paramMethod.name);
      httpURLConnection.setConnectTimeout(3000);
      httpURLConnection.setReadTimeout(3000);
      httpURLConnection.setRequestProperty("Content-Type", "application/json");
      httpURLConnection.setRequestProperty("Connection", "close");
      if (paramMethod == Method.GET) {
        for (Map.Entry<Object, Object> entry : hashMap.entrySet())
          httpURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
      } else {
        JSONObject jSONObject = new JSONObject(hashMap);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(jSONObject.toString().getBytes());
        outputStream.flush();
      } 
      httpURLConnection.connect();
      return null;
    } finally {
      paramString1 = null;
    } 
  }
  
  private static String toString(InputStream paramInputStream) {
    null = new char[4096];
    StringBuilder stringBuilder = new StringBuilder();
    InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream, StandardCharsets.UTF_8);
    try {
      while (true) {
        int i = inputStreamReader.read(null, 0, 4096);
        if (i != -1) {
          stringBuilder.append(null, 0, i);
          continue;
        } 
        return stringBuilder.toString();
      } 
    } catch (IOException iOException) {
      return null;
    } finally {
      closeQuietly(inputStreamReader);
    } 
  }
  
  public enum Method {
    GET, POST;
    
    public String name;
    
    static {
      Method method1 = new Method("GET", 0, "GET");
      GET = method1;
      Method method2 = new Method("POST", 1, "POST");
      POST = method2;
      $VALUES = new Method[] { method1, method2 };
    }
    
    Method(String param1String1) {
      this.name = param1String1;
    }
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\75dcc8ea-d0f9-4222-b8dd-2a83444f9cd6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_proxy\server\HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */