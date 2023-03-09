package android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IProcessObserver extends IInterface {
  void onForegroundActivitiesChanged(int paramInt1, int paramInt2, boolean paramBoolean);
  
  void onForegroundServicesChanged(int paramInt1, int paramInt2, int paramInt3);
  
  void onProcessDied(int paramInt1, int paramInt2);
  
  public static class Default implements IProcessObserver {
    public IBinder asBinder() {
      return null;
    }
    
    public void onForegroundActivitiesChanged(int param1Int1, int param1Int2, boolean param1Boolean) {}
    
    public void onForegroundServicesChanged(int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onProcessDied(int param1Int1, int param1Int2) {}
  }
  
  public static abstract class Stub extends Binder implements IProcessObserver {
    private static final String DESCRIPTOR = "android.app.IProcessObserver";
    
    static final int TRANSACTION_onForegroundActivitiesChanged = 1;
    
    static final int TRANSACTION_onForegroundServicesChanged = 2;
    
    static final int TRANSACTION_onProcessDied = 3;
    
    public Stub() {
      attachInterface(this, "android.app.IProcessObserver");
    }
    
    public static IProcessObserver asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.app.IProcessObserver");
      return (iInterface != null && iInterface instanceof IProcessObserver) ? (IProcessObserver)iInterface : new Proxy(param1IBinder);
    }
    
    public static IProcessObserver getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(IProcessObserver param1IProcessObserver) {
      if (Proxy.sDefaultImpl == null) {
        if (param1IProcessObserver != null) {
          Proxy.sDefaultImpl = param1IProcessObserver;
          return true;
        } 
        return false;
      } 
      throw new IllegalStateException("setDefaultImpl() called twice");
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      boolean bool;
      if (param1Int1 != 1) {
        if (param1Int1 != 2) {
          if (param1Int1 != 3) {
            if (param1Int1 != 1598968902)
              return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
            param1Parcel2.writeString("android.app.IProcessObserver");
            return true;
          } 
          param1Parcel1.enforceInterface("android.app.IProcessObserver");
          onProcessDied(param1Parcel1.readInt(), param1Parcel1.readInt());
          param1Parcel2.writeNoException();
          return true;
        } 
        param1Parcel1.enforceInterface("android.app.IProcessObserver");
        onForegroundServicesChanged(param1Parcel1.readInt(), param1Parcel1.readInt(), param1Parcel1.readInt());
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel1.enforceInterface("android.app.IProcessObserver");
      param1Int1 = param1Parcel1.readInt();
      param1Int2 = param1Parcel1.readInt();
      if (param1Parcel1.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      onForegroundActivitiesChanged(param1Int1, param1Int2, bool);
      param1Parcel2.writeNoException();
      return true;
    }
    
    static class Proxy implements IProcessObserver {
      public static IProcessObserver sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return "android.app.IProcessObserver";
      }
      
      public void onForegroundActivitiesChanged(int param2Int1, int param2Int2, boolean param2Boolean) {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          boolean bool;
          parcel1.writeInterfaceToken("android.app.IProcessObserver");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          if (param2Boolean) {
            bool = true;
          } else {
            bool = false;
          } 
          parcel1.writeInt(bool);
          if (!this.mRemote.transact(1, parcel1, parcel2, 0) && IProcessObserver.Stub.getDefaultImpl() != null) {
            IProcessObserver.Stub.getDefaultImpl().onForegroundActivitiesChanged(param2Int1, param2Int2, param2Boolean);
          } else {
            parcel2.readException();
          } 
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onForegroundServicesChanged(int param2Int1, int param2Int2, int param2Int3) {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.app.IProcessObserver");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeInt(param2Int3);
          if (!this.mRemote.transact(2, parcel1, parcel2, 0) && IProcessObserver.Stub.getDefaultImpl() != null) {
            IProcessObserver.Stub.getDefaultImpl().onForegroundServicesChanged(param2Int1, param2Int2, param2Int3);
          } else {
            parcel2.readException();
          } 
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onProcessDied(int param2Int1, int param2Int2) {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.app.IProcessObserver");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          if (!this.mRemote.transact(3, parcel1, parcel2, 0) && IProcessObserver.Stub.getDefaultImpl() != null) {
            IProcessObserver.Stub.getDefaultImpl().onProcessDied(param2Int1, param2Int2);
          } else {
            parcel2.readException();
          } 
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class Proxy implements IProcessObserver {
    public static IProcessObserver sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return "android.app.IProcessObserver";
    }
    
    public void onForegroundActivitiesChanged(int param1Int1, int param1Int2, boolean param1Boolean) {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        boolean bool;
        parcel1.writeInterfaceToken("android.app.IProcessObserver");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        if (param1Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel1.writeInt(bool);
        if (!this.mRemote.transact(1, parcel1, parcel2, 0) && IProcessObserver.Stub.getDefaultImpl() != null) {
          IProcessObserver.Stub.getDefaultImpl().onForegroundActivitiesChanged(param1Int1, param1Int2, param1Boolean);
        } else {
          parcel2.readException();
        } 
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onForegroundServicesChanged(int param1Int1, int param1Int2, int param1Int3) {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.app.IProcessObserver");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeInt(param1Int3);
        if (!this.mRemote.transact(2, parcel1, parcel2, 0) && IProcessObserver.Stub.getDefaultImpl() != null) {
          IProcessObserver.Stub.getDefaultImpl().onForegroundServicesChanged(param1Int1, param1Int2, param1Int3);
        } else {
          parcel2.readException();
        } 
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onProcessDied(int param1Int1, int param1Int2) {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.app.IProcessObserver");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        if (!this.mRemote.transact(3, parcel1, parcel2, 0) && IProcessObserver.Stub.getDefaultImpl() != null) {
          IProcessObserver.Stub.getDefaultImpl().onProcessDied(param1Int1, param1Int2);
        } else {
          parcel2.readException();
        } 
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8aeb045fad9343acbbd1a26998b6485a-dex2jar.jar!\android\app\IProcessObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */