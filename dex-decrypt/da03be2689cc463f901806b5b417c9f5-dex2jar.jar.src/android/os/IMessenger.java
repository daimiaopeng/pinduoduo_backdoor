package android.os;

public interface IMessenger extends IInterface {
  void send(Message paramMessage);
  
  public static class Default implements IMessenger {
    public IBinder asBinder() {
      return null;
    }
    
    public void send(Message param1Message) {}
  }
  
  public static abstract class Stub extends Binder implements IMessenger {
    private static final String DESCRIPTOR = "android.os.IMessenger";
    
    static final int TRANSACTION_send = 1;
    
    public Stub() {
      attachInterface(this, "android.os.IMessenger");
    }
    
    public static IMessenger asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.os.IMessenger");
      return (iInterface == null || !(iInterface instanceof IMessenger)) ? new Proxy(param1IBinder) : (IMessenger)iInterface;
    }
    
    public static IMessenger getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static String getDefaultTransactionName(int param1Int) {
      return (param1Int != 1) ? null : "send";
    }
    
    public static boolean setDefaultImpl(IMessenger param1IMessenger) {
      if (Proxy.sDefaultImpl == null) {
        if (param1IMessenger == null)
          return false; 
        Proxy.sDefaultImpl = param1IMessenger;
        return true;
      } 
      throw new IllegalStateException("setDefaultImpl() called twice");
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public String getTransactionName(int param1Int) {
      return getDefaultTransactionName(param1Int);
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      if (param1Int1 == 1) {
        param1Parcel1.enforceInterface("android.os.IMessenger");
        if (param1Parcel1.readInt() != 0) {
          Message message = (Message)Message.CREATOR.createFromParcel(param1Parcel1);
        } else {
          param1Parcel1 = null;
        } 
        send((Message)param1Parcel1);
        return true;
      } 
      if (param1Int1 != 1598968902)
        return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
      param1Parcel2.writeString("android.os.IMessenger");
      return true;
    }
    
    public static class Proxy implements IMessenger {
      public static IMessenger sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return "android.os.IMessenger";
      }
      
      public void send(Message param2Message) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.os.IMessenger");
          if (param2Message != null) {
            parcel.writeInt(1);
            param2Message.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (this.mRemote.transact(1, parcel, null, 1) || IMessenger.Stub.getDefaultImpl() == null) {
            parcel.recycle();
          } else {
            IMessenger.Stub.getDefaultImpl().send(param2Message);
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
    }
  }
  
  public static class Proxy implements IMessenger {
    public static IMessenger sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return "android.os.IMessenger";
    }
    
    public void send(Message param1Message) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.os.IMessenger");
        if (param1Message != null) {
          parcel.writeInt(1);
          param1Message.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (this.mRemote.transact(1, parcel, null, 1) || IMessenger.Stub.getDefaultImpl() == null) {
          parcel.recycle();
        } else {
          IMessenger.Stub.getDefaultImpl().send(param1Message);
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\da03be2689cc463f901806b5b417c9f5-dex2jar.jar!\android\os\IMessenger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */