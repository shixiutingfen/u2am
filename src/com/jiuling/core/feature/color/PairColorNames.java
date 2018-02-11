package com.jiuling.core.feature.color;


public class PairColorNames {

    public XColor first;
    public XColorName second;
    
    public PairColorNames(XColor first, XColorName second)
    {
    	this.first = first;
    	this.second = second;
    }
    
    public XColor getXColor()
    {
    	return this.first;
    }
    
    public XColor getFirst() {
		return first;
	}

	public void setFirst(XColor first) {
		this.first = first;
	}

	public XColorName getSecond() {
		return second;
	}

	public void setSecond(XColorName second) {
		this.second = second;
	}

	public XColorName getXColorName()
    {
    	return this.second;
    }

}
