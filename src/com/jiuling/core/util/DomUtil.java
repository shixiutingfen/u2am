package com.jiuling.core.util;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomUtil {
    /**
     *
     * <User ID="515202" FacePart="1457,0,1042,1159" outFile="515202_2016_05_11_21_35_42_325"
     * MatchFile="C:\fea\515202_[1]_.jpg  C:\fea\515202_[2]_.jpg  "Register=Success/>
     * 
     * @param result
     * @return
     */
    public static String formatRegisteResult(String result) {
        if (result.contains("Register=") && !result.contains("Register=\"")) {
            result = result.replace("Register=", " Register=\"");
            result = result.replace("/>", "\"/>");
        }
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?><root>" + result + "</root>";
    }

    public static String parseRegisteResult(String formatXML, String attr) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(formatXML.getBytes()));
            Element element = document.getDocumentElement();
            NodeList nodes = element.getElementsByTagName("User");
            Element userElement = (Element) nodes.item(0);
            return userElement.getAttribute(attr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    /**
     * 识别返回解析 <SourceImage="D:\face\P60329-204107.jpg" FaceCount="2" ResultImages="D:\face\P60329-204107_[1]_.jpg D:\face\P60329-204107_[2]_.jpg "/>
     * 
     * @param result
     * @return
     */
    public static String formatDetectResult(String result) {
        result = result.replace("<SourceImage", "<User SourceImage");
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?><root>" + result + "</root>";
    }

    public static String parseDetectResult(String formatXML, String attr) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(formatXML.getBytes()));
            Element element = document.getDocumentElement();
            NodeList nodes = element.getElementsByTagName("User");
            Element userElement = (Element) nodes.item(0);
            return userElement.getAttribute(attr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    /**
     * 检索返回值 <Result> <User ID="443305" Score=46 FaceImage="D:\face\P60329-204107.jpg_[2]_.jpg" MarkPoint=[ (345,293) (742,231) (600,588) (445,784)
     * (879,694) ]/></Result>
     * 
     * @param result
     * @return
     */
    public static String formatMatchResult(String result) {
        if (result.contains("Score=") && !result.contains("Score=\"")) {
            result = result.replace("Score=", "Score=\"");
            result = result.replace("FaceImage=", "\"FaceImage=");
            result = result.replace("MarkPoint=", "MarkPoint=\"");
            result = result.replace("/>", "\"/>");
        }
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + result;
    }

    public static String parseMatchResult(String formatXML, String attr) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(formatXML.getBytes()));
            Element element = document.getDocumentElement();
            NodeList nodes = element.getElementsByTagName("User");
            Element userElement = (Element) nodes.item(0);
            if (null == userElement) {
                return null;
            }

            return userElement.getAttribute(attr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String parseResult(String formatXML, String rootName, String nodeName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(formatXML.getBytes()));

            Node result = (Node) document.getElementsByTagName(rootName).item(0);

            String resultval = null;

            NodeList childNodes = result.getChildNodes();
            if (null != childNodes) {
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node node = childNodes.item(j);
                    if (node.getNodeName().equals(nodeName)) {
                        resultval = node.getTextContent();
                    }
                }
            }

            //System.out.println(nodeName + ":" + resultval);

            return resultval;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String args[]) {
        /*
         * String result =
         * "<User ID=\"515202\" FacePart=\"1457,0,1042,1159\" outFile=\"515202_2016_05_11_21_35_42_325\" MatchFile=\"C:\\\\fea\\\\515202_[1]_.jpg  C:\\\\fea\\\\515202_[2]_.jpg  \"Register=Success/>"
         * ; String formatXML = formatRegisteResult(result); //System.out.println(formatXML); String value = parseRegisteResult(formatXML,"outFile");
         * String MatchFile = parseRegisteResult(formatXML,"MatchFile"); //System.out.println(MatchFile); //System.out.println(value);
         */
        // String detectRet =
        // "<?xml version=\"1.0\" encoding=\"utf-8\"?><root><SourceImage=\"D:\\face\\P60329-204107.jpg\" FaceCount=\"2\" ResultImages=\"D:\\face\\P60329-204107_[1]_.jpg  D:\\face\\P60329-204107_[2]_.jpg  \"/>";
    }
}
