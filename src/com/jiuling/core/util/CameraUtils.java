package com.jiuling.core.util;

public class CameraUtils {

	
	/** 
     * 计算地球上任意两点(经纬度)距离 
     *  
     * @param long1 
     *            第一点经度 
     * @param lat1 
     *            第一点纬度 
     * @param long2 
     *            第二点经度 
     * @param lat2 
     *            第二点纬度 
     * @return 返回距离 单位：米 
     */  
    public static double Distance(double long1, double lat1, double long2,double lat2) {  
        double a, b, R;  
        R = 6378137; // 地球半径  
        lat1 = lat1 * Math.PI / 180.0;  
        lat2 = lat2 * Math.PI / 180.0;  
        a = lat1 - lat2;  
        b = (long1 - long2) * Math.PI / 180.0;  
        double d;  
        double sa2, sb2;  
        sa2 = Math.sin(a / 2.0);  
        sb2 = Math.sin(b / 2.0);  
        d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));  
        return d/1000;  
    	/*double radLat1 = rad(lat1);    
        double radLat2 = rad(lat2);    
        double a = radLat1 - radLat2;    
        double b = rad(long1) - rad(long2);    
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)    
                + Math.cos(radLat1) * Math.cos(radLat2)    
                * Math.pow(Math.sin(b / 2), 2)));    
        s = s * EARTH_RADIUS;    
        s = Math.round(s * 10000d) / 10000d;
        //s = s*1000;    
        return s;*/
    }
    
    @SuppressWarnings("unused")
	private static double EARTH_RADIUS = 6378.137;    
    
    @SuppressWarnings("unused")
	private static double rad(double d) {    
        return d * Math.PI / 180.0;    
    }
    
    /** 
     * 计算地球上任意两点(经纬度)角度
     * @param lat_a 纬度1 
     * @param lng_a 经度1 
     * @param lat_b 纬度2 
     * @param lng_b 经度2 
     * @return 
     */  
    public static double getAngle1(double lat_a, double lng_a, double lat_b, double lng_b) {  
  
        double y = Math.sin(lng_b-lng_a) * Math.cos(lat_b);  
        double x = Math.cos(lat_a)*Math.sin(lat_b) - Math.sin(lat_a)*Math.cos(lat_b)*Math.cos(lng_b-lng_a);  
        double brng = Math.atan2(y, x);  
  
        brng = Math.toDegrees(brng);  
        if(brng < 0)  
            brng = brng +360;  
        return brng;  
  
    }
}
