package com.google.android.sd.biz_dynamic_dex.usage_event_all;

public final class a {
  long a;
  
  int b;
  
  public a(long paramLong, int paramInt) {
    this.a = paramLong;
    this.b = paramInt;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("{\"log_ts\":\"");
    stringBuilder.append(this.a);
    stringBuilder.append("\",\"type\":\"");
    stringBuilder.append(this.b);
    stringBuilder.append("\"}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\35604479f8854b5d90bc800e912034fc-dex2jar.jar!\com\google\android\sd\biz_dynamic_de\\usage_event_all\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */