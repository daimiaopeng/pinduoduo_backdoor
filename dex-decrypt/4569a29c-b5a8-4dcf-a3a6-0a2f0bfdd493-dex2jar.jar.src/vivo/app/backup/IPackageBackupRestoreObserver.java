package vivo.app.backup;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPackageBackupRestoreObserver extends IInterface {
  void onEnd(String paramString, int paramInt) throws RemoteException;
  
  void onError(String paramString, int paramInt1, int paramInt2) throws RemoteException;
  
  void onProgress(String paramString, int paramInt, long paramLong1, long paramLong2) throws RemoteException;
  
  void onStart(String paramString, int paramInt) throws RemoteException;
  
  public static class Default implements IPackageBackupRestoreObserver {
    public IBinder asBinder() {
      return null;
    }
    
    public void onEnd(String param1String, int param1Int) throws RemoteException {}
    
    public void onError(String param1String, int param1Int1, int param1Int2) throws RemoteException {}
    
    public void onProgress(String param1String, int param1Int, long param1Long1, long param1Long2) throws RemoteException {}
    
    public void onStart(String param1String, int param1Int) throws RemoteException {}
  }
  
  public static abstract class Stub extends Binder implements IPackageBackupRestoreObserver {
    private static final String DESCRIPTOR = "vivo.app.backup.IPackageBackupRestoreObserver";
    
    static final int TRANSACTION_onEnd = 2;
    
    static final int TRANSACTION_onError = 4;
    
    static final int TRANSACTION_onProgress = 3;
    
    static final int TRANSACTION_onStart = 1;
    
    public Stub() {
      attachInterface(this, "vivo.app.backup.IPackageBackupRestoreObserver");
    }
    
    public static IPackageBackupRestoreObserver asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("vivo.app.backup.IPackageBackupRestoreObserver");
      return (iInterface != null && iInterface instanceof IPackageBackupRestoreObserver) ? (IPackageBackupRestoreObserver)iInterface : new Proxy(param1IBinder);
    }
    
    public static IPackageBackupRestoreObserver getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(IPackageBackupRestoreObserver param1IPackageBackupRestoreObserver) {
      if (Proxy.sDefaultImpl == null) {
        if (param1IPackageBackupRestoreObserver != null) {
          Proxy.sDefaultImpl = param1IPackageBackupRestoreObserver;
          return true;
        } 
        return false;
      } 
      throw new IllegalStateException("setDefaultImpl() called twice");
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1) {
        if (param1Int1 != 2) {
          if (param1Int1 != 3) {
            if (param1Int1 != 4) {
              if (param1Int1 != 1598968902)
                return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
              param1Parcel2.writeString("vivo.app.backup.IPackageBackupRestoreObserver");
              return true;
            } 
            param1Parcel1.enforceInterface("vivo.app.backup.IPackageBackupRestoreObserver");
            onError(param1Parcel1.readString(), param1Parcel1.readInt(), param1Parcel1.readInt());
            param1Parcel2.writeNoException();
            return true;
          } 
          param1Parcel1.enforceInterface("vivo.app.backup.IPackageBackupRestoreObserver");
          onProgress(param1Parcel1.readString(), param1Parcel1.readInt(), param1Parcel1.readLong(), param1Parcel1.readLong());
          param1Parcel2.writeNoException();
          return true;
        } 
        param1Parcel1.enforceInterface("vivo.app.backup.IPackageBackupRestoreObserver");
        onEnd(param1Parcel1.readString(), param1Parcel1.readInt());
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel1.enforceInterface("vivo.app.backup.IPackageBackupRestoreObserver");
      onStart(param1Parcel1.readString(), param1Parcel1.readInt());
      param1Parcel2.writeNoException();
      return true;
    }
    
    private static class Proxy implements IPackageBackupRestoreObserver {
      public static IPackageBackupRestoreObserver sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return "vivo.app.backup.IPackageBackupRestoreObserver";
      }
      
      public void onEnd(String param2String, int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("vivo.app.backup.IPackageBackupRestoreObserver");
          parcel1.writeString(param2String);
          parcel1.writeInt(param2Int);
          if (!this.mRemote.transact(2, parcel1, parcel2, 0) && IPackageBackupRestoreObserver.Stub.getDefaultImpl() != null) {
            IPackageBackupRestoreObserver.Stub.getDefaultImpl().onEnd(param2String, param2Int);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onError(String param2String, int param2Int1, int param2Int2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("vivo.app.backup.IPackageBackupRestoreObserver");
          parcel1.writeString(param2String);
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          if (!this.mRemote.transact(4, parcel1, parcel2, 0) && IPackageBackupRestoreObserver.Stub.getDefaultImpl() != null) {
            IPackageBackupRestoreObserver.Stub.getDefaultImpl().onError(param2String, param2Int1, param2Int2);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onProgress(String param2String, int param2Int, long param2Long1, long param2Long2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("vivo.app.backup.IPackageBackupRestoreObserver");
          parcel1.writeString(param2String);
          parcel1.writeInt(param2Int);
          parcel1.writeLong(param2Long1);
          parcel1.writeLong(param2Long2);
          try {
            if (!this.mRemote.transact(3, parcel1, parcel2, 0) && IPackageBackupRestoreObserver.Stub.getDefaultImpl() != null) {
              IPackageBackupRestoreObserver.Stub.getDefaultImpl().onProgress(param2String, param2Int, param2Long1, param2Long2);
              parcel2.recycle();
              parcel1.recycle();
              return;
            } 
            parcel2.readException();
            parcel2.recycle();
            parcel1.recycle();
            return;
          } finally {}
        } finally {}
        parcel2.recycle();
        parcel1.recycle();
        throw param2String;
      }
      
      public void onStart(String param2String, int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("vivo.app.backup.IPackageBackupRestoreObserver");
          parcel1.writeString(param2String);
          parcel1.writeInt(param2Int);
          if (!this.mRemote.transact(1, parcel1, parcel2, 0) && IPackageBackupRestoreObserver.Stub.getDefaultImpl() != null) {
            IPackageBackupRestoreObserver.Stub.getDefaultImpl().onStart(param2String, param2Int);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements IPackageBackupRestoreObserver {
    public static IPackageBackupRestoreObserver sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return "vivo.app.backup.IPackageBackupRestoreObserver";
    }
    
    public void onEnd(String param1String, int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("vivo.app.backup.IPackageBackupRestoreObserver");
        parcel1.writeString(param1String);
        parcel1.writeInt(param1Int);
        if (!this.mRemote.transact(2, parcel1, parcel2, 0) && IPackageBackupRestoreObserver.Stub.getDefaultImpl() != null) {
          IPackageBackupRestoreObserver.Stub.getDefaultImpl().onEnd(param1String, param1Int);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onError(String param1String, int param1Int1, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("vivo.app.backup.IPackageBackupRestoreObserver");
        parcel1.writeString(param1String);
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        if (!this.mRemote.transact(4, parcel1, parcel2, 0) && IPackageBackupRestoreObserver.Stub.getDefaultImpl() != null) {
          IPackageBackupRestoreObserver.Stub.getDefaultImpl().onError(param1String, param1Int1, param1Int2);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onProgress(String param1String, int param1Int, long param1Long1, long param1Long2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("vivo.app.backup.IPackageBackupRestoreObserver");
        parcel1.writeString(param1String);
        parcel1.writeInt(param1Int);
        parcel1.writeLong(param1Long1);
        parcel1.writeLong(param1Long2);
        try {
          if (!this.mRemote.transact(3, parcel1, parcel2, 0) && IPackageBackupRestoreObserver.Stub.getDefaultImpl() != null) {
            IPackageBackupRestoreObserver.Stub.getDefaultImpl().onProgress(param1String, param1Int, param1Long1, param1Long2);
            parcel2.recycle();
            parcel1.recycle();
            return;
          } 
          parcel2.readException();
          parcel2.recycle();
          parcel1.recycle();
          return;
        } finally {}
      } finally {}
      parcel2.recycle();
      parcel1.recycle();
      throw param1String;
    }
    
    public void onStart(String param1String, int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("vivo.app.backup.IPackageBackupRestoreObserver");
        parcel1.writeString(param1String);
        parcel1.writeInt(param1Int);
        if (!this.mRemote.transact(1, parcel1, parcel2, 0) && IPackageBackupRestoreObserver.Stub.getDefaultImpl() != null) {
          IPackageBackupRestoreObserver.Stub.getDefaultImpl().onStart(param1String, param1Int);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\4569a29c-b5a8-4dcf-a3a6-0a2f0bfdd493-dex2jar.jar!\vivo\app\backup\IPackageBackupRestoreObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */