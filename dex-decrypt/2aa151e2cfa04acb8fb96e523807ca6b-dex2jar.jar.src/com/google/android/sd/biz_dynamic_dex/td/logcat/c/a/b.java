package com.google.android.sd.biz_dynamic_dex.td.logcat.c.a;

public final class b {
  public String a;
  
  public a b;
  
  public long c;
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("ActivityItem{name='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", intent=");
    stringBuilder.append(this.b);
    stringBuilder.append(", time=");
    stringBuilder.append(this.c);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static final class a {
    public String a;
    
    public final String toString() {
      StringBuilder stringBuilder = new StringBuilder("IntentItem{url='");
      stringBuilder.append(this.a);
      stringBuilder.append('\'');
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\c\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */