package com.jiuling.core.feature.color;

/**
 * 颜色名称类
 * @author xiaochangqing
 *
 */
public class XColorName {

    private String s1;
    private String s2;
    private String s3;
    
    public XColorName()
    {
    }
    public XColorName(String s1, String s2)
    {
    	this.s1 = s1;
    	this.s2 = s2;
    }
    
    public XColorName(String s1, String s2, String s3)
    {
    	this.s1 = s1;
    	this.s2 = s2;
    	this.s3 = s3;
    }
    
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public String getS3() {
		return s3;
	}
	public void setS3(String s3) {
		this.s3 = s3;
	}

}
