package com.jiuling.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import oracle.sql.CLOB;

/**
 * 字符串处理类
 * 
 * @author YANGXQ
 * @since 2016/1/17/16:20
 *
 */
public class StringUtils {

    private static Logger log = Logger.getLogger(StringUtils.class.getName());

    /***
     * 随机产生32位16进制字符串
     * 
     * @return
     */
    public static String getRandom32PK() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 替换字符串中的逗号
     * 
     * @param str
     * @return
     */
    public static String replaceStr(String str) {
        if (str == null || "".equals(str)) {
            str = "0";
        }
        if (str.contains(",")) {
            str = str.replace(",", "");
        }
        return str;
    }

    /**
     * 得到一个字符在另一个字符串中出现的次数
     * 
     * @param text
     *            文本
     * @param ch
     *            字符
     */
    public static int getIndexOfCount(String text, char ch) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            count = (text.charAt(i) == ch) ? count + 1 : count;
        }
        return count;
    }

    /**
     * 判断字符串是否为空或者空字符串
     * 
     * @param str
     * @return
     */
    public static boolean isNotEmptyString(String str) {
        if (str == null || "".equals(str)) {
            return false;
        } else if ("null".equals(str)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断字符串是否为空或者空字符串
     * 
     * @param str
     * @return
     */
    public static boolean isEmptyString(String str) {
        return !isNotEmptyString(str);
    }

    /**
     * 判断str是否为null或空字符串，若是，则返回空字符串，否则返回str.trim()。
     * 
     * @param str
     * @return
     */
    public static String objToStr(String str) {
        if (str == null || "".equals(str)) {
            return "";
        } else {
            return str.trim();
        }
    }

    /**
     * 替换用科学计算法显示的数据
     * 
     * @param str
     * @return
     */
    public static String repStr(String str) {
        BigDecimal bigDecimal = new BigDecimal(str);
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(bigDecimal);
    }

    /**
     * 字符串转换成金额的一般表示方法
     * 
     * @param str
     * @return
     */
    public static String repAmount(String str) {
        BigDecimal bigDecimal1 = new BigDecimal(str);
        BigDecimal bigDecimal2 = new BigDecimal(10000);
        // DecimalFormat df = new DecimalFormat("###,###,###0.00");
        bigDecimal1 = bigDecimal1.divide(bigDecimal2);
        // return df.format(bigDecimal1);
        return bigDecimal1.toString();
    }

    /**
     * 金额相加
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static String addAmount(String str1, String str2) {
        if (isNotEmptyString(str1) && str1.contains(",")) {
            str1 = str1.replaceAll(",", "");
        }
        if (isNotEmptyString(str2) && str2.contains(",")) {
            str2 = str2.replaceAll(",", "");
        }
        BigDecimal bigDecimal1 = new BigDecimal(str1);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        bigDecimal1 = bigDecimal1.add(bigDecimal2);
        return bigDecimal1.toString();
    }

    /**
     * 金额相除并转换成百分比形式
     * 
     * @param str1
     * @param str2
     * @param scale
     * @return
     */
    public static String divAmount(String str1, String str2, int scale) {
        BigDecimal bigDecimal1 = new BigDecimal(str1);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        double d = (bigDecimal1.divide(bigDecimal2, scale, BigDecimal.ROUND_HALF_UP).doubleValue());
        // NumberFormat nFromat = NumberFormat.getPercentInstance();
        // String rates = nFromat.format(d);
        DecimalFormat df = new DecimalFormat("0.00%");
        String r = "";
        if (isNotEmptyString(d + "")) {
            r = df.format(d);
        }
        return isNotEmptyString(r) ? r : "0.00%";
    }

    /**
     * 金额的差额
     * 
     * @param str
     * @return
     */
    public static String getMargin(String str1, String str2) {
        if (isNotEmptyString(str1) && str1.contains(",")) {
            str1 = str1.replaceAll(",", "");
        }
        if (isNotEmptyString(str2) && str2.contains(",")) {
            str2 = str2.replaceAll(",", "");
        }
        BigDecimal bigDecimal1 = new BigDecimal(str1);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        // DecimalFormat df = new DecimalFormat("###,###,###0.00");
        bigDecimal1 = bigDecimal1.subtract(bigDecimal2);
        // return df.format(bigDecimal1);
        return bigDecimal1.toString();
    }

    /**
     * 把金额用千分位显示
     * 
     * @param str
     * @return
     */
    public static String showAmount(String str) {
        BigDecimal bigDecimal1 = new BigDecimal(str);
        DecimalFormat df = new DecimalFormat("###,###,###,###.00");
        return df.format(bigDecimal1);
    }

    /**
     * 正则表达式获取连个值之间的值
     * 
     * @param b
     * @param e
     * @param c
     * @return
     */
    public static String getRankVal(String b, String e, String c) {
        log.info("getRankVal b :=>" + b);
        log.info("getRankVal e :=>" + e);
        log.info("getRankVal c :=>" + c);

        Pattern psrjc = Pattern.compile("(?<=" + b + "=)[\\w|-]+(?=" + e + ")");
        Matcher msrjc = psrjc.matcher(c);
        if (msrjc.find()) {
            log.info("getRankVal msrjc.find() true ");
            String srjc = msrjc.group(0);
            log.info("getRankVal srjc :=> " + srjc);
            return srjc.trim();
        }
        return "";
    }

    /**
     * 匹配中文
     * 
     * @param str
     * @return
     */
    public static boolean regZh(String str) {
        String reg = "[\u4E00-\u9FA5]+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 字符串转成UTF-8
     * 
     * @param str
     * @return
     */
    public static String regZh2utf_8(String str) {
        if (regZh(str)) {
            try {
                return new String(str.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                 e.printStackTrace();
            }
        }
        return str;
    }

    /**
     * 字符串数组 转 字符串
     * 
     * @param arr
     * @return
     */
    public static String arrToStr(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static final String inputStream2String(InputStream is) throws IOException {
        StringBuffer sb = new StringBuffer();
        InputStreamReader reader = new InputStreamReader(is, "utf-8");
        char[] buff = new char[1024];
        int length = 0;
        while ((length = reader.read(buff)) != -1) {
            sb.append(new String(buff, 0, length));
        }
        return sb.toString();
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static boolean isMessyCode(String strName) {
        Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
        Matcher m = p.matcher(strName);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        char[] ch = temp.trim().toCharArray();
        float chLength = 0;
        float count = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!Character.isLetterOrDigit(c)) {
                if (!isChinese(c)) {
                    count = count + 1;
                }
                chLength++;
            }
        }
        float result = count / chLength;
        if (result > 0.4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 字符串转ascii码
     * 
     * @param value
     * @return
     */
    public static String stringToAscii(String value) {

        if (StringUtils.isEmptyString(value)) {
            // log.error(StringUtils.class.getName(), "stringToAscii", "传入的字符为空");
            return "";
        }

        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if (j != chars.length - 1) {
                sbu.append((int) chars[j]).append(",");
            } else {
                sbu.append((int) chars[j]);
            }
        }

        return sbu.toString();
    }

    /**
     * 
     * @param selfLongNumber
     * @param splitChar
     * @return
     */
    public static String replaceStrWithLevel(String str, String splitStr, Integer level, String replaceStr) {
        String[] strArry = str.split(splitStr);
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < strArry.length; i++) {
            if (i == level - 1) {
                strArry[i] = replaceStr;
            }
            if (i == strArry.length - 1) {
                result.append(strArry[i]);
            } else {
                result.append(strArry[i]).append(splitStr);
            }
        }
        return result.toString();
    }

    public static String getParentLongNumber(String selfLongNumber, String splitChar) {
        if (isNotEmptyString(selfLongNumber) && selfLongNumber.split(splitChar).length > 0) {
            String[] ss = selfLongNumber.split(splitChar);
            StringBuffer parentLongNumber = new StringBuffer();
            for (int i = 0, len = ss.length - 1; i < len; i++) {
                parentLongNumber.append((i == 0 ? "" : splitChar) + ss[i]);
            }
            return parentLongNumber.toString();
        } else {
            return null;
        }
    }

    public static String getInSql(List<Long> paramList) {
        StringBuffer sb = new StringBuffer("(");
        for (int i = 0; i < paramList.size(); i++) {
            if (i == (paramList.size() - 1)) {
                sb.append(paramList.get(i));
            } else {
                sb.append(paramList.get(i)).append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    // //////////////////////////字符处理//////////////////////////////////////////////////////////
    public static char toUpperCase(char c) {
        if (c >= 'a' && c <= 'z') {
            c -= 32;
        }
        return c;
    }

    public static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            c += 32;
        }
        return c;
    }
    
    /**
     * clob对象转string
     * @param clob
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public static String ClobToString(CLOB clob) throws SQLException, IOException { 

    	if (null == clob || clob.length() == 0)
    	{
    		return "";
    	}
    	String reString = ""; 
    	Reader is = clob.getCharacterStream();// 得到流 
    	BufferedReader br = new BufferedReader(is); 
    	String s = br.readLine(); 
    	StringBuffer sb = new StringBuffer(); 
    	while (s != null) {// 执行循环将字符串全部取出付值给 StringBuffer由StringBuffer转成STRING 
    	sb.append(s); 
    	s = br.readLine(); 
    	} 
    	reString = sb.toString(); 
    	return reString; 
    	}
    
    /**
     * 
     * @return
     */
    public static String getNetAddress(HttpServletRequest request){
    	String url = "";
    	String ip = "";
    	String port = "";
    	String serverName = "";
		ip = request.getServerName();
		port = request.getServerPort()+"";
		serverName = request.getContextPath();
		url = "http://"+ip+":"+port+serverName;
		
    	return url;
    }

    public static void main(String[] args) {
        List<Long> list = new ArrayList<Long>();
        list.add(1l);
        list.add(2l);
        list.add(3l);
        //System.out.println(getInSql(list));

    }
    
    /** 
     * 正则替换所有特殊字符 
     * @param orgStr 
     * @return 
     */  
    public static String replaceSpecStr(String orgStr){  
        if (null!=orgStr&&!"".equals(orgStr.trim())) {  
            String regEx="[\\s~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";  
            Pattern p = Pattern.compile(regEx);  
            Matcher m = p.matcher(orgStr);  
            return m.replaceAll("");  
        }  
        return null;  
    } 
    
    /** 
     * 正则替换双引号 
     * @param orgStr 
     * @return 
     */  
    public static String replaceYinhaoStr(String orgStr){  
        if (null!=orgStr&&!"".equals(orgStr.trim())) {  
            String regEx="\"";  
            Pattern p = Pattern.compile(regEx);  
            Matcher m = p.matcher(orgStr);  
            return m.replaceAll("&quot;");  
        }  
        return null;  
    } 
}
