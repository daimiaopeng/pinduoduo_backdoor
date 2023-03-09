package com.huawei.android.app;

import android.os.IBackupSessionCallback;
import android.os.ParcelFileDescriptor;
import java.util.List;

public class PackageManagerEx {
  public static final int HW_FLAG_DISABLE_APP_VERIFY = 4;
  
  private static final String IPACKAGE_MANAGER_DESCRIPTOR = "huawei.com.android.server.IPackageManager";
  
  private static final String TAG = "PackageManagerEx";
  
  public static final int TRANSACTION_CODE_FILE_BACKUP_EXECUTE_TASK = 1019;
  
  public static final int TRANSACTION_CODE_FILE_BACKUP_FINISH_SESSION = 1020;
  
  public static final int TRANSACTION_CODE_FILE_BACKUP_START_SESSION = 1018;
  
  public static final int TRANSACTION_CODE_GET_HDB_KEY = 1011;
  
  public static final int TRANSACTION_CODE_GET_IM_AND_VIDEO_APP_LIST = 1022;
  
  public static final int TRANSACTION_CODE_GET_MAX_ASPECT_RATIO = 1013;
  
  private static final int TRANSACTION_CODE_GET_PREINSTALLED_APK_LIST = 1007;
  
  public static final int TRANSACTION_CODE_GET_PUBLICITY_DESCRIPTOR = 1015;
  
  public static final int TRANSACTION_CODE_GET_PUBLICITY_INFO_LIST = 1014;
  
  private static final int TRANSACTION_CODE_IS_NOTIFICATION_SPLIT = 1021;
  
  public static final int TRANSACTION_CODE_SET_HDB_KEY = 1010;
  
  public static final int TRANSACTION_CODE_SET_MAX_ASPECT_RATIO = 1012;
  
  @Deprecated
  public static boolean checkGmsCoreUninstalled() {
    return false;
  }
  
  @Deprecated
  public static void deleteGmsCoreFromUninstalledDelapp() {}
  
  public static int executeBackupTask(int paramInt, String paramString) {
    return 1;
  }
  
  public static int finishBackupSession(int paramInt) {
    return 1;
  }
  
  public static float getApplicationAspectRatio(String paramString1, String paramString2) {
    return 1.0F;
  }
  
  public static float getApplicationMaxAspectRatio(String paramString) {
    return 1.0F;
  }
  
  public static String getHdbKey() {
    return null;
  }
  
  public static List<String> getHwPublicityAppList() {
    return null;
  }
  
  public static ParcelFileDescriptor getHwPublicityAppParcelFileDescriptor() {
    return null;
  }
  
  public static List<String> getScanInstallList() {
    return null;
  }
  
  public static List<String> getSupportSplitScreenApps() {
    return null;
  }
  
  public static boolean isNotificationAddSplitButton(String paramString) {
    return false;
  }
  
  public static boolean scanInstallApk(String paramString) {
    return false;
  }
  
  public static boolean setApplicationAspectRatio(String paramString1, String paramString2, float paramFloat) {
    return false;
  }
  
  public static boolean setApplicationMaxAspectRatio(String paramString, float paramFloat) {
    return false;
  }
  
  public static void setHdbKey(String paramString) {}
  
  public static int startBackupSession(IBackupSessionCallback paramIBackupSessionCallback) {
    return 1;
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\6932a923-9f13-4624-bfea-1249ddfd5505-dex2jar.jar!\com\huawei\android\app\PackageManagerEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */