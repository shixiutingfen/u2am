package com.jiuling.core.feature.color;


/**
 * 颜色code转换工具类
 * @author xiaochangqing
 *
 */

public class ColorUtils {

	/**
	 * 将RBG int转成16进制的BGR
	 * @param color RBG int
	 * @return
	 */
	public static XColor transToXColor(int color)
	{
	     String upColorStr = Integer.toHexString(color);	     
	     XColor xColor = null;
	     if (upColorStr.length() >= 6) 
	     {
		     String b = upColorStr.substring(4, 6);
		     String g = upColorStr.substring(2, 4);
		     String r = upColorStr.substring(0, 2);
		     
		     xColor = new XColor();
		     int bNum = Integer.parseInt(b, 16);
		     int gNum = Integer.parseInt(g, 16);
		     int rNum = Integer.parseInt(r, 16);
		     
		     xColor.setB(bNum);
		     xColor.setG(gNum);
		     xColor.setR(rNum);
		     return xColor;
		}
	     else
		{
			return null;
		}
	}
	
    /**
     * 将BGR int转成XColor
     * @param color RBG int
     * @return
     */
    public static XColor bgrTransToXColor(int color)
    {
         String upColorStr = Integer.toHexString(color);
         XColor xColor = null;
         if (upColorStr.length() >= 6) 
         {
             String b = upColorStr.substring(0, 2);
             String g = upColorStr.substring(2, 4);
             String r = upColorStr.substring(4, 6);
             
             xColor = new XColor();
             int bNum = Integer.parseInt(b, 16);
             int gNum = Integer.parseInt(g, 16);
             int rNum = Integer.parseInt(r, 16);
             
             xColor.setB(bNum);
             xColor.setG(gNum);
             xColor.setR(rNum);
             return xColor;
        }
         else
        {
            return new XColor();
        }
    }
    
	
	/**
	 * 将RBG int转成16进制的BGR
	 * @param color RBG int
	 * @return
	 */
	public static String transColorToBGRString(int color)
	{
	     String upColorStr = Integer.toHexString(color);	     
	     if (upColorStr.length() >= 6) 
	     {
		     String b = upColorStr.substring(4, 6);
		     String g = upColorStr.substring(2, 4);
		     String r = upColorStr.substring(0, 2);
		     
		     return b + g + r;
		}
	     else
		{
			return null;
		}
	}
	
	
	/**
	 * 页面颜色初始化使用
	 * @param key
	 * @return
	 */
	public static String getColorRemarkById(String key)
	{
        switch( key)
        {
            case "1": return "黄色";
            case "2": return "黄橙色";
            case "3": return "橙色";
            case "4": return "红橙色";
            case "5": return "红色";
            case "6": return "红紫色";
            case "7": return "紫色";
            case "8": return "蓝紫色";
            case "9": return "蓝色";
            case "10": return "蓝绿色";
            case "11": return "绿色";
            case "12": return "黄绿色";
            case "13": return "黑色";
            case "14": return "褐色";
            case "15": return "粉红色";
            case "16": return "白色";
        }
        
        return null;
	}
	

    public static int getPersonColorTag(String key)
    {
        switch( key)
        {
            case "1": return 16776960;
            case "2": return 15977507;
            case "3": return 16737536;
            case "4": return 16724736;
            case "5": return 16711680;
            case "6": return 9961573;
            case "7": return 10027161;
            case "8": return 6750361;
            case "9": return 255;
            case "10": return 39065;
            case "11": return 39168;
            case "12": return 65280;
            case "13": return 0;
            case "14": return 4194304;
            case "15": return 16744640;
            case "16": return 16777215;
        }
        
        return 0;
    }
    

    /**
     * 根据RGB int获取颜色名称
     * @param key RGB
     * @return
     */
    public static String getPersonColorTagName(int key)
    {
        switch( key)
        {
            case 16776960: return "黄色";
            case 15977507: return "黄橙色";
            case 16737536: return "橙色";
            case 16724736: return "红橙色";
            case 16711680: return "红色";
            case 9961573: return "红紫色";
            case 10027161: return "紫色";
            case 6750361: return "蓝紫色";
            case 255: return "蓝色";
            case 39065: return "蓝绿色";
            case 39168: return "绿色";
            case 65280: return "黄绿色";
            case 0: return "黑色";
            case 4194304: return "褐色";
            case 16744640: return "粉红色";
            case 16777215: return "白色";
        }
        
        return "未知";
        
    }
    
    /**
     * 根据BGR int获取颜色名称
     * @param key BGR
     * @return
     */
    public static String getColorByBGR(int key)
    {
        switch( key)
        {
            case 65535: return "黄色";
            case 2346227: return "黄橙色";
            case 26111: return "橙色";
            case 13311: return "红橙色";
            case 255: return "红色";
            case 6619288: return "红紫色";
            case 10027161: return "紫色";
            case 10027111: return "蓝紫色";
            case 16711680: return "蓝色";
            case 10065920: return "蓝绿色";
            case 39168: return "绿色";
            case 65280: return "黄绿色";
            case 0: return "黑色";
            case 64: return "褐色";
            case 12615935: return "粉红色";
            case 16777215: return "白色";
        }
        
        return "未知";
        
    }
    
    /**
     * 车辆颜色转换
     * @param key
     * @return
     */
    public static String getCarColor(String key)
    {
        switch( key)
        {
            case "1": return "黄";
            case "2": return "黄";
            case "3": return "橙";
            case "4": return "红";
            case "5": return "红";
            case "6": return "红";
            case "7": return "紫";
            case "8": return "蓝";
            case "9": return "蓝";
            case "10": return "蓝";
            case "11": return "绿";
            case "12": return "黄";
            case "13": return "黑";
            case "14": return "褐";
            case "15": return "粉";
            case "16": return "白";
        }
        
        return null;
    }
    
	
    
	

}
