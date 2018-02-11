package com.jiuling.core.feature.color;

/**
 * bgr颜色定义类
 * @author xiaochangqing
 *
 */
public class XColor {

	private String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private  double b;
    private  double g;
    private  double r;
    
    public XColor(){
    	
    }
    
    public XColor(double b, double g, double r)
    {
    	this.b = b;
    	this.g = g;
    	this.r = r;
    }

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	
}
