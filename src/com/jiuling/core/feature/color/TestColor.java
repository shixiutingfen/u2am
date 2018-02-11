package com.jiuling.core.feature.color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jiuling.core.util.ValidateHelper;


public class TestColor {
	
	@SuppressWarnings("resource")
	public void test1() throws NumberFormatException, IOException
	{
		FileReader reader = new FileReader("E://u2s_Code//colorTest.txt");
        BufferedReader br = new BufferedReader(reader);
       
        String str = null;
        List<XColor> inputList = new ArrayList<XColor>();
        while((str = br.readLine()) != null) 
        {
        	
        	String colorStr = str.trim();
        	String[] strArray = colorStr.split(",");
        	
    		XColor inputBGR = new XColor(Double.valueOf(strArray[0]), Double.valueOf(strArray[1]), Double.valueOf(strArray[2]));
    		inputList.add(inputBGR);   
        }
        
        XColorMapper xColorMapper = new XColorMapper();
        List<XColor> xColorList = xColorMapper.sortColorList(inputList.get(0), inputList);
        
        if (ValidateHelper.isNotEmptyList(xColorList)) {
        	for (XColor inputBGR: xColorList ) {
            	System.out.println("输入颜色BGR：" + new Double(inputBGR.getB()).intValue() + "," + new Double(inputBGR.getG()).intValue() + "," + new Double(inputBGR.getR()).intValue()) ;
            	
			}
        }
        
	}
	
	@SuppressWarnings("resource")
	public void test2() throws NumberFormatException, IOException
	{
		XColorMapper xColorMapper = new XColorMapper();
		xColorMapper.init();
		
		FileReader reader = new FileReader("E://u2s_Code//colorTest.txt");
        BufferedReader br = new BufferedReader(reader);
       
        String str = null;
       int i =0;
        while((str = br.readLine()) != null) 
        {
        	System.out.println("实例" + ++i + ":");
        	
        	String colorStr = str.trim();
        	String[] strArray = colorStr.split(",");
        	
    		XColor inputBGR = new XColor(Double.valueOf(strArray[0]), Double.valueOf(strArray[1]), Double.valueOf(strArray[2]));
    		
    		
    		System.out.println("输入颜色BGR：" + new Double(inputBGR.getB()).intValue() + "," + new Double(inputBGR.getG()).intValue() + "," + new Double(inputBGR.getR()).intValue()) ;

    		PairColorNames pairColorName = xColorMapper.mapColor(inputBGR, true);
    		
    		if (null != pairColorName) {
    			System.out.println("匹配的颜色为：" + pairColorName.getXColorName().getS1() + ":" +  pairColorName.getXColorName().getS2());

    		}
    		
    		System.out.println();
              
        }
		xColorMapper.clear();
	}
	
	public static void main(String[] args) throws IOException{
		TestColor testColor = new TestColor();
		testColor.test1();
		
	}
}
