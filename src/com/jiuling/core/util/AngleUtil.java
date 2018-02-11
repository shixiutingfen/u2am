package com.jiuling.core.util;

public class AngleUtil {

	/**
	* 求B点经纬度
	* @param A 已知点的经纬度，
	* @param distance   AB两地的距离  单位km
	* @param angle  AB连线与正北方向的夹角（0~360）
	* @return  B点的经纬度
	*/
	final static double Rc=6378137;
	final static double Rj=6356725;
	double m_LoDeg,m_LoMin,m_LoSec;
	double m_LaDeg,m_LaMin,m_LaSec;
	double m_Longitude,m_Latitude;
	double m_RadLo,m_RadLa;
	double Ec;
	double Ed;
	
	public AngleUtil(double longitude,double latitude){
		m_LoDeg=(int)longitude;
		m_LoMin=(int)((longitude-m_LoDeg)*60);
		m_LoSec=(longitude-m_LoDeg-m_LoMin/60.)*3600;
	
		m_LaDeg=(int)latitude;
		m_LaMin=(int)((latitude-m_LaDeg)*60);
		m_LaSec=(latitude-m_LaDeg-m_LaMin/60.)*3600;
	
		m_Longitude=longitude;
		m_Latitude=latitude;
		m_RadLo=longitude*Math.PI/180.;
		m_RadLa=latitude*Math.PI/180.;
		Ec=Rj+(Rc-Rj)*(90.-m_Latitude)/90.;
		Ed=Ec*Math.cos(m_RadLa);
	}

	/** 
     * 求B点经纬度 
     * @param A 已知点的经纬度， 
     * @param distance   AB两地的距离  单位km 
     * @param angle  AB连线与正北方向的夹角（0~360） 
     * @return  B点的经纬度 
     */ 
	public static String[] getMyLatLng(AngleUtil A,double distance,double angle){//方法
		double dx = distance*1000*Math.sin(Math.toRadians(angle));
		double dy= distance*1000*Math.cos(Math.toRadians(angle));
		double bjd=(dx/A.Ed+A.m_RadLo)*180./Math.PI;
		double bwd=(dy/A.Ec+A.m_RadLa)*180./Math.PI;
		String[] lnglat={""+bjd,""+bwd};
		return lnglat;
	}
	
	/** 
     * 获取AB连线与正北方向的角度 
     * @param A  A点的经纬度 
     * @param B  B点的经纬度 
     * @return  AB连线与正北方向的角度（0~360） 
     */  
    public  static double getAngle(AngleUtil A,AngleUtil B){  
        double dx=(B.m_RadLo-A.m_RadLo)*A.Ed;  
        double dy=(B.m_RadLa-A.m_RadLa)*A.Ec;  
        if(dx == 0 && dy == 0){
        	return 0;
        }
        double angle=0.0;  
        angle=Math.atan(Math.abs(dx/dy))*180./Math.PI;    
        double dLo=B.m_Longitude-A.m_Longitude;  
        double dLa=B.m_Latitude-A.m_Latitude;  
        if(dLo>0&&dLa<=0){  
            angle=(90.0-angle)+90;  
        }
        else if(dLo<=0&&dLa<0){  
            angle=angle+180.0;  
        }else if(dLo<0&&dLa>=0){  
            angle= (90.0-angle)+270;  
        }  
        return angle;
    }
}
