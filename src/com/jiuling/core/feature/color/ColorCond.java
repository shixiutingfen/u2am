package com.jiuling.core.feature.color;

public class ColorCond
{
    private String id;
    
    private String name;
    
    private int rbg;

    public ColorCond(String id, String name)
    {
        this.id = id;
        this.name = name;
    };
    
    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getRbg()
    {
        return rbg;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setRbg(int rbg)
    {
        this.rbg = rbg;
    }
}
