package com.google.android.sd.biz_dynamic_dex.check_aster;

import android.content.Context;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.TrackUtils;
import com.google.android.sd.utils.Utils;
import java.util.HashMap;
import org.json.JSONObject;

public class CheckAsterExecutor extends DynamicCmdExecutor {
  private final int CMD = 76;
  
  private void track(Context paramContext, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("status", "1");
    hashMap.put("details", paramString);
    TrackUtils.submitTrack(paramContext, 76, hashMap);
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    paramString = (new JSONObject(paramString)).getString("uuid");
    track(paramContext, paramString);
    CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(new CmdData(76, paramString, "client"), new JSONObject(), null));
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\561341f5f7976e13efce7491887f1306-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\check_aster\CheckAsterExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */