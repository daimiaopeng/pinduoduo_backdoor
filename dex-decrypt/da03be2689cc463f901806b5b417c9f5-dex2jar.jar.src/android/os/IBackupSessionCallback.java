package android.os;

public interface IBackupSessionCallback extends IInterface {
  void onTaskStatusChanged(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public static abstract class Stub extends Binder implements IBackupSessionCallback {
    private static final String DESCRIPTOR = "android.os.IBackupSessionCallback";
    
    static final int TRANSACTION_onTaskStatusChanged = 1;
    
    public Stub() {
      attachInterface(this, "android.os.IBackupSessionCallback");
    }
    
    public static IBackupSessionCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.os.IBackupSessionCallback");
      return (iInterface == null || !(iInterface instanceof IBackupSessionCallback)) ? new Proxy(param1IBinder) : (IBackupSessionCallback)iInterface;
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      if (param1Int1 == 1) {
        param1Parcel1.enforceInterface("android.os.IBackupSessionCallback");
        onTaskStatusChanged(param1Parcel1.readInt(), param1Parcel1.readInt(), param1Parcel1.readInt(), param1Parcel1.readString());
        return true;
      } 
      if (param1Int1 != 1598968902)
        return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
      param1Parcel2.writeString("android.os.IBackupSessionCallback");
      return true;
    }
    
    static class Proxy implements IBackupSessionCallback {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return "android.os.IBackupSessionCallback";
      }
      
      public void onTaskStatusChanged(int param2Int1, int param2Int2, int param2Int3, String param2String) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.os.IBackupSessionCallback");
          parcel.writeInt(param2Int1);
          parcel.writeInt(param2Int2);
          parcel.writeInt(param2Int3);
          parcel.writeString(param2String);
          this.mRemote.transact(1, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
    }
  }
  
  static class Proxy implements IBackupSessionCallback {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return "android.os.IBackupSessionCallback";
    }
    
    public void onTaskStatusChanged(int param1Int1, int param1Int2, int param1Int3, String param1String) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.os.IBackupSessionCallback");
        parcel.writeInt(param1Int1);
        parcel.writeInt(param1Int2);
        parcel.writeInt(param1Int3);
        parcel.writeString(param1String);
        this.mRemote.transact(1, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\da03be2689cc463f901806b5b417c9f5-dex2jar.jar!\android\os\IBackupSessionCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */