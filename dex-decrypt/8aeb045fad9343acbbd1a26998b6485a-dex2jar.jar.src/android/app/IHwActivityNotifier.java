package android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IHwActivityNotifier extends IInterface {
  public static final String DESCRIPTOR = "android.app.IHwActivityNotifier";
  
  void call(Bundle paramBundle);
  
  public static class Default implements IHwActivityNotifier {
    public IBinder asBinder() {
      return null;
    }
    
    public void call(Bundle param1Bundle) {}
  }
  
  public static abstract class Stub extends Binder implements IHwActivityNotifier {
    static final int TRANSACTION_call = 1;
    
    public Stub() {
      attachInterface(this, "android.app.IHwActivityNotifier");
    }
    
    public static IHwActivityNotifier asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.app.IHwActivityNotifier");
      return (iInterface == null || !(iInterface instanceof IHwActivityNotifier)) ? new Proxy(param1IBinder) : (IHwActivityNotifier)iInterface;
    }
    
    public static IHwActivityNotifier getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static String getDefaultTransactionName(int param1Int) {
      return (param1Int != 1) ? null : "call";
    }
    
    public static boolean setDefaultImpl(IHwActivityNotifier param1IHwActivityNotifier) {
      if (Proxy.sDefaultImpl == null) {
        if (param1IHwActivityNotifier == null)
          return false; 
        Proxy.sDefaultImpl = param1IHwActivityNotifier;
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
      if (param1Int1 != 1598968902) {
        if (param1Int1 != 1)
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
        param1Parcel1.enforceInterface("android.app.IHwActivityNotifier");
        if (param1Parcel1.readInt() != 0) {
          Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1);
        } else {
          param1Parcel1 = null;
        } 
        call((Bundle)param1Parcel1);
        return true;
      } 
      param1Parcel2.writeString("android.app.IHwActivityNotifier");
      return true;
    }
    
    public static class Proxy implements IHwActivityNotifier {
      public static IHwActivityNotifier sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public void call(Bundle param2Bundle) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.app.IHwActivityNotifier");
          if (param2Bundle != null) {
            parcel.writeInt(1);
            param2Bundle.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          if (this.mRemote.transact(1, parcel, null, 1) || IHwActivityNotifier.Stub.getDefaultImpl() == null) {
            parcel.recycle();
          } else {
            IHwActivityNotifier.Stub.getDefaultImpl().call(param2Bundle);
          } 
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public String getInterfaceDescriptor() {
        return "android.app.IHwActivityNotifier";
      }
    }
  }
  
  public static class Proxy implements IHwActivityNotifier {
    public static IHwActivityNotifier sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public void call(Bundle param1Bundle) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.app.IHwActivityNotifier");
        if (param1Bundle != null) {
          parcel.writeInt(1);
          param1Bundle.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        if (this.mRemote.transact(1, parcel, null, 1) || IHwActivityNotifier.Stub.getDefaultImpl() == null) {
          parcel.recycle();
        } else {
          IHwActivityNotifier.Stub.getDefaultImpl().call(param1Bundle);
        } 
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public String getInterfaceDescriptor() {
      return "android.app.IHwActivityNotifier";
    }
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8aeb045fad9343acbbd1a26998b6485a-dex2jar.jar!\android\app\IHwActivityNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */