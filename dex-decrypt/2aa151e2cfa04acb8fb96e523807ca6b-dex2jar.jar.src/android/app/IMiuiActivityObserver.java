package android.app;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IMiuiActivityObserver extends IInterface {
  void activityDestroyed(Intent paramIntent);
  
  void activityIdle(Intent paramIntent);
  
  void activityPaused(Intent paramIntent);
  
  void activityResumed(Intent paramIntent);
  
  void activityStopped(Intent paramIntent);
  
  public static class a implements IMiuiActivityObserver {
    public void activityDestroyed(Intent param1Intent) {}
    
    public void activityIdle(Intent param1Intent) {}
    
    public void activityPaused(Intent param1Intent) {}
    
    public void activityResumed(Intent param1Intent) {}
    
    public void activityStopped(Intent param1Intent) {}
    
    public IBinder asBinder() {
      return null;
    }
  }
  
  public static abstract class b extends Binder implements IMiuiActivityObserver {
    private static final String f474a = "android.app.IMiuiActivityObserver";
    
    public static final int f475b = 1;
    
    public static final int f476c = 2;
    
    public static final int f477d = 3;
    
    public static final int f478e = 4;
    
    public static final int f479f = 5;
    
    public b() {
      attachInterface(this, "android.app.IMiuiActivityObserver");
    }
    
    public static IMiuiActivityObserver asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.app.IMiuiActivityObserver");
      return (iInterface == null || !(iInterface instanceof IMiuiActivityObserver)) ? new a(param1IBinder) : (IMiuiActivityObserver)iInterface;
    }
    
    public static IMiuiActivityObserver getDefaultImpl() {
      return a.f480b;
    }
    
    public static boolean setDefaultImpl(IMiuiActivityObserver param1IMiuiActivityObserver) {
      if (a.f480b == null) {
        if (param1IMiuiActivityObserver == null)
          return false; 
        a.f480b = param1IMiuiActivityObserver;
        return true;
      } 
      throw new IllegalStateException("setDefaultImpl() called twice");
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      Intent intent;
      Parcel parcel2 = null;
      Parcel parcel3 = null;
      Parcel parcel4 = null;
      Parcel parcel5 = null;
      Parcel parcel1 = null;
      if (param1Int1 == 1) {
        param1Parcel1.enforceInterface("android.app.IMiuiActivityObserver");
        param1Parcel2 = parcel1;
        if (param1Parcel1.readInt() != 0)
          intent = (Intent)Intent.CREATOR.createFromParcel(param1Parcel1); 
        activityIdle(intent);
        return true;
      } 
      if (param1Int1 == 2) {
        param1Parcel1.enforceInterface("android.app.IMiuiActivityObserver");
        param1Parcel2 = parcel2;
        if (param1Parcel1.readInt() != 0)
          intent = (Intent)Intent.CREATOR.createFromParcel(param1Parcel1); 
        activityResumed(intent);
        return true;
      } 
      if (param1Int1 == 3) {
        param1Parcel1.enforceInterface("android.app.IMiuiActivityObserver");
        param1Parcel2 = parcel3;
        if (param1Parcel1.readInt() != 0)
          intent = (Intent)Intent.CREATOR.createFromParcel(param1Parcel1); 
        activityPaused(intent);
        return true;
      } 
      if (param1Int1 == 4) {
        param1Parcel1.enforceInterface("android.app.IMiuiActivityObserver");
        param1Parcel2 = parcel4;
        if (param1Parcel1.readInt() != 0)
          intent = (Intent)Intent.CREATOR.createFromParcel(param1Parcel1); 
        activityStopped(intent);
        return true;
      } 
      if (param1Int1 == 5) {
        param1Parcel1.enforceInterface("android.app.IMiuiActivityObserver");
        param1Parcel2 = parcel5;
        if (param1Parcel1.readInt() != 0)
          intent = (Intent)Intent.CREATOR.createFromParcel(param1Parcel1); 
        activityDestroyed(intent);
        return true;
      } 
      if (param1Int1 != 1598968902)
        return super.onTransact(param1Int1, param1Parcel1, (Parcel)intent, param1Int2); 
      intent.writeString("android.app.IMiuiActivityObserver");
      return true;
    }
    
    public static class a implements IMiuiActivityObserver {
      public static IMiuiActivityObserver f480b;
      
      private IBinder f481a;
      
      public a(IBinder param2IBinder) {
        this.f481a = param2IBinder;
      }
      
      public void activityDestroyed(Intent param2Intent) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.app.IMiuiActivityObserver");
          if (param2Intent != null) {
            parcel.writeInt(1);
            param2Intent.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (this.f481a.transact(5, parcel, null, 1) || IMiuiActivityObserver.b.getDefaultImpl() == null) {
            parcel.recycle();
          } else {
            IMiuiActivityObserver.b.getDefaultImpl().activityDestroyed(param2Intent);
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void activityIdle(Intent param2Intent) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.app.IMiuiActivityObserver");
          if (param2Intent != null) {
            parcel.writeInt(1);
            param2Intent.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (this.f481a.transact(1, parcel, null, 1) || IMiuiActivityObserver.b.getDefaultImpl() == null) {
            parcel.recycle();
          } else {
            IMiuiActivityObserver.b.getDefaultImpl().activityIdle(param2Intent);
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void activityPaused(Intent param2Intent) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.app.IMiuiActivityObserver");
          if (param2Intent != null) {
            parcel.writeInt(1);
            param2Intent.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (this.f481a.transact(3, parcel, null, 1) || IMiuiActivityObserver.b.getDefaultImpl() == null) {
            parcel.recycle();
          } else {
            IMiuiActivityObserver.b.getDefaultImpl().activityPaused(param2Intent);
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void activityResumed(Intent param2Intent) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.app.IMiuiActivityObserver");
          if (param2Intent != null) {
            parcel.writeInt(1);
            param2Intent.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (this.f481a.transact(2, parcel, null, 1) || IMiuiActivityObserver.b.getDefaultImpl() == null) {
            parcel.recycle();
          } else {
            IMiuiActivityObserver.b.getDefaultImpl().activityResumed(param2Intent);
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void activityStopped(Intent param2Intent) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.app.IMiuiActivityObserver");
          if (param2Intent != null) {
            parcel.writeInt(1);
            param2Intent.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (this.f481a.transact(4, parcel, null, 1) || IMiuiActivityObserver.b.getDefaultImpl() == null) {
            parcel.recycle();
          } else {
            IMiuiActivityObserver.b.getDefaultImpl().activityStopped(param2Intent);
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.f481a;
      }
      
      public String getInterfaceDescriptor() {
        return "android.app.IMiuiActivityObserver";
      }
    }
  }
  
  public static class a implements IMiuiActivityObserver {
    public static IMiuiActivityObserver f480b;
    
    private IBinder f481a;
    
    public a(IBinder param1IBinder) {
      this.f481a = param1IBinder;
    }
    
    public void activityDestroyed(Intent param1Intent) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.app.IMiuiActivityObserver");
        if (param1Intent != null) {
          parcel.writeInt(1);
          param1Intent.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (this.f481a.transact(5, parcel, null, 1) || IMiuiActivityObserver.b.getDefaultImpl() == null) {
          parcel.recycle();
        } else {
          IMiuiActivityObserver.b.getDefaultImpl().activityDestroyed(param1Intent);
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void activityIdle(Intent param1Intent) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.app.IMiuiActivityObserver");
        if (param1Intent != null) {
          parcel.writeInt(1);
          param1Intent.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (this.f481a.transact(1, parcel, null, 1) || IMiuiActivityObserver.b.getDefaultImpl() == null) {
          parcel.recycle();
        } else {
          IMiuiActivityObserver.b.getDefaultImpl().activityIdle(param1Intent);
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void activityPaused(Intent param1Intent) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.app.IMiuiActivityObserver");
        if (param1Intent != null) {
          parcel.writeInt(1);
          param1Intent.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (this.f481a.transact(3, parcel, null, 1) || IMiuiActivityObserver.b.getDefaultImpl() == null) {
          parcel.recycle();
        } else {
          IMiuiActivityObserver.b.getDefaultImpl().activityPaused(param1Intent);
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void activityResumed(Intent param1Intent) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.app.IMiuiActivityObserver");
        if (param1Intent != null) {
          parcel.writeInt(1);
          param1Intent.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (this.f481a.transact(2, parcel, null, 1) || IMiuiActivityObserver.b.getDefaultImpl() == null) {
          parcel.recycle();
        } else {
          IMiuiActivityObserver.b.getDefaultImpl().activityResumed(param1Intent);
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void activityStopped(Intent param1Intent) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.app.IMiuiActivityObserver");
        if (param1Intent != null) {
          parcel.writeInt(1);
          param1Intent.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (this.f481a.transact(4, parcel, null, 1) || IMiuiActivityObserver.b.getDefaultImpl() == null) {
          parcel.recycle();
        } else {
          IMiuiActivityObserver.b.getDefaultImpl().activityStopped(param1Intent);
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.f481a;
    }
    
    public String getInterfaceDescriptor() {
      return "android.app.IMiuiActivityObserver";
    }
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\android\app\IMiuiActivityObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */