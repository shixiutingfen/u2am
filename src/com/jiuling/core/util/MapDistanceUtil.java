package com.jiuling.core.util;

public class MapDistanceUtil {

private static double EARTH_RADIUS = 6378.137; 
    
    private static double rad(double d) { 
        return d * Math.PI / 180.0; 
    }
      
    /**
     * 根据两个位置的经纬度，来计算两地的距离（单位为KM）
     * 参数为String类型
     * @param lat1 用户经度
     * @param lng1 用户纬度 
     * @param lat2 商家经度
     * @param lng2 商家纬度
     * @return
     */
    public static Integer getDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str,String radius) {
        Double lat1 = Double.parseDouble(lat1Str);
        Double lng1 = Double.parseDouble(lng1Str);
        Double lat2 = Double.parseDouble(lat2Str);
        Double lng2 = Double.parseDouble(lng2Str);
        Double radiusd = Double.parseDouble(radius)*1000;
          
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double difference = radLat1 - radLat2;
        double mdifference = rad(lng1) - rad(lng2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mdifference / 2), 2)));
        distance = distance * EARTH_RADIUS*1000;
        if(distance > radiusd){
        	return -1;
        }
        //distance = Math.round(distance * 10000) / 10000;
        String distanceStr = distance+"";
        distanceStr = distanceStr.substring(0, distanceStr.indexOf("."));
          
        return Integer.valueOf(distanceStr);
    }
}
