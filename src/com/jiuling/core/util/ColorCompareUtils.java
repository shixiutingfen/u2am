package com.jiuling.core.util;

import com.jiuling.core.feature.color.XColor;

public class ColorCompareUtils {
	
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
	 * 将16进制的BGR 转成int RBG 
	 * @param color RBG int
	 * @return
	 */
	public static int XColorTransToRGB(XColor xcolor)
	{
		int rgb = 0;
		if (null != xcolor)
		{
			double r = xcolor.getR();
			double g = xcolor.getG();
			double b = xcolor.getB();
			
			double bgr = r+ g * 256 + b * 256 * 256;
			rgb = (int)bgr;
		}
		
	    return rgb;
	}

	

}
