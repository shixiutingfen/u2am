package com.jiuling.core.feature.color;

import java.util.ArrayList;
import java.util.List;


public class XColorMapper {


    private List<PairColorNames> colorPaletteList = new ArrayList<PairColorNames>();
    //初始化
    public void init()
    {
    	colorPaletteList.add(new PairColorNames(new XColor(255, 255, 255 ), new XColorName("白","White")));
    	colorPaletteList.add(new PairColorNames(new XColor(242, 242, 242), new XColorName("白","Concrete")));
    	colorPaletteList.add(new PairColorNames(new XColor(216, 216, 216 ), new XColorName("白","Alto")));
    	colorPaletteList.add(new PairColorNames(new XColor(191, 191, 191), new XColorName("灰","Silver")));
    	colorPaletteList.add(new PairColorNames(new XColor(165, 165, 165 ), new XColorName("灰","Silver Chalice")));
    	colorPaletteList.add(new PairColorNames(new XColor(127, 127, 127 ), new XColorName("灰","Gray")));
        
        //        { 0, 0, 0 },                // black
        //        { 128, 128, 128 },          // Dark Gray
        //        { 90, 90, 90 },             // Very Dark Gray
        //        { 64, 64, 64 },             // Dove Gray
        //        { 39, 39, 39 },             // Mine Shaft
        //        { 13, 13, 13 },             // Cod Gray
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 0, 0 ), new XColorName("黑","Black")));
    	colorPaletteList.add(new PairColorNames(new XColor(128, 128, 128 ), new XColorName("灰","Dark Gray")));
    	colorPaletteList.add(new PairColorNames(new XColor(90, 90, 90), new XColorName("黑","Very Dark Gray")));
    	colorPaletteList.add(new PairColorNames(new XColor(64, 64, 64), new XColorName("黑","Dove Gray")));
    	colorPaletteList.add(new PairColorNames(new XColor(39, 39, 39 ), new XColorName("黑","Mine Shaft")));
    	colorPaletteList.add(new PairColorNames(new XColor(13, 13, 13 ), new XColorName("黑","Cod Gray")));
    	
    	//        { 225, 236, 238 },          // Satin Linen
        //        { 195, 217, 221 },          // Tana
        //        { 195, 217, 221 },          // Tana
        //        { 151, 190, 197 },          // Coral Reef
        //        { 84, 139, 148 },           // Barley Corn
        //        { 42, 69, 74 },             // Judge Gray
        //        { 17, 27, 29 },             // Rangoon Green

    	colorPaletteList.add(new PairColorNames(new XColor(225, 236, 238 ), new XColorName("白","Satin Linen")));
    	colorPaletteList.add(new PairColorNames(new XColor(195, 217, 221), new XColorName("白","Tana")));
    	colorPaletteList.add(new PairColorNames(new XColor(151, 190, 197), new XColorName("黄","Coral Reef")));
    	colorPaletteList.add(new PairColorNames(new XColor( 84, 139, 148 ), new XColorName("黄","Barley Corn")));
    	colorPaletteList.add(new PairColorNames(new XColor(42, 69, 74 ), new XColorName("黄","Judge Gray")));
    	colorPaletteList.add(new PairColorNames(new XColor(17, 27, 29 ), new XColorName("黑","Rangoon Green")));
    	


        //        { 125, 73, 31 },            // Blumine
        //        { 241, 217, 197 },          // Link Water
        //        { 227, 180, 141 },          // Cornflower
        //        { 213, 142, 83 },           // Havelock Blue
        //        { 93, 55, 23 },             // Biscay
        //        { 63, 37, 15 },             // Blue Zodiac
        
    	colorPaletteList.add(new PairColorNames(new XColor(125, 73, 31 ), new XColorName("蓝","Blumine")));
    	colorPaletteList.add(new PairColorNames(new XColor( 241, 217, 197 ), new XColorName("白","Link Water")));
    	colorPaletteList.add(new PairColorNames(new XColor( 227, 180, 141 ), new XColorName("蓝","Cornflower")));
    	colorPaletteList.add(new PairColorNames(new XColor( 213, 142, 83 ), new XColorName("蓝","Havelock Blue")));
    	colorPaletteList.add(new PairColorNames(new XColor( 93, 55, 23 ), new XColorName("蓝","Biscay")));
    	colorPaletteList.add(new PairColorNames(new XColor( 63, 37, 15 ), new XColorName("黑","Blue Zodiac")));
    	

        
        //        { 189, 129, 79 },           // Steel Blue
        //        { 241, 229, 219 },          // Periwinkle Gray
        //        { 228, 204, 184 },          // Light Grayish Blue
        //        { 215, 179, 149 },          // Polo Blue
        //        { 145, 96, 55 },            // Chambray
        //        { 97, 64, 37 },             // Cello

    	colorPaletteList.add(new PairColorNames(new XColor( 189, 129, 79 ), new XColorName("蓝","Steel Blue")));
    	colorPaletteList.add(new PairColorNames(new XColor( 241, 229, 219 ), new XColorName("白","Periwinkle Gray")));
    	colorPaletteList.add(new PairColorNames(new XColor( 228, 204, 184 ), new XColorName("蓝","Light Grayish Blue")));
    	colorPaletteList.add(new PairColorNames(new XColor( 215, 179, 149 ), new XColorName("蓝","Polo Blue")));
    	colorPaletteList.add(new PairColorNames(new XColor( 145, 96, 55 ), new XColorName("蓝","Chambray")));
    	colorPaletteList.add(new PairColorNames(new XColor( 97, 64, 37 ), new XColorName("蓝","Cello")));
 
        
        //        { 77, 80, 192 },            // Fuzzy Wuzzy Brown
        //        { 220, 221, 242 },          // Pot Pourri
        //        { 184, 185, 230 },          // Rose Fog
        //        { 149, 151, 217 },          // Petite Orchid
        //        { 53, 55, 149 },            // El Salva
        //        { 35, 37, 99 },             // Irish Coffee
    	colorPaletteList.add(new PairColorNames(new XColor( 77, 80, 192 ), new XColorName("红","Fuzzy Wuzzy Brown")));
    	colorPaletteList.add(new PairColorNames(new XColor( 220, 221, 242 ), new XColorName("白","Pot Pourri")));
    	colorPaletteList.add(new PairColorNames(new XColor( 184, 185, 230 ), new XColorName("红","Rose Fog")));
    	colorPaletteList.add(new PairColorNames(new XColor( 149, 151, 217 ), new XColorName("红","Petite Orchid")));
    	colorPaletteList.add(new PairColorNames(new XColor( 53, 55, 149 ), new XColorName("红","El Salva")));
    	colorPaletteList.add(new PairColorNames(new XColor( 35, 37, 99 ), new XColorName("红","Irish Coffee")));
    	

        //        { 89, 187, 155 },           // Celery
        //        { 221, 241, 234 },          // Loafer
        //        { 188, 228, 215 },          // Beryl Green
        //        { 154, 214, 194 },          // Deco
        //        { 60, 146, 117 },           // Sycamore
        //        { 40, 98, 79 },             // Woodland
    	colorPaletteList.add(new PairColorNames(new XColor( 89, 187, 155 ), new XColorName("绿","Celery")));
    	colorPaletteList.add(new PairColorNames(new XColor( 221, 241, 234 ), new XColorName("白","Loafer")));
    	colorPaletteList.add(new PairColorNames(new XColor( 188, 228, 215 ), new XColorName("绿","Beryl Green")));
    	colorPaletteList.add(new PairColorNames(new XColor( 154, 214, 194 ), new XColorName("绿","Deco")));
    	colorPaletteList.add(new PairColorNames(new XColor( 60, 146, 117 ), new XColorName("绿","Sycamore")));
    	colorPaletteList.add(new PairColorNames(new XColor( 40, 98, 79 ), new XColorName("绿","Woodland")));

        
        //        { 162, 100, 128 },          // Deluge
        //        { 236, 224, 229 },          // Snuff
        //        { 218, 192, 204 },          // Lavender Gray
        //        { 199, 161, 178 },          // Logan
        //        { 123, 73, 96 },            // Mulled Wine
        //        { 81, 49, 63 },             // Martinique

    	colorPaletteList.add(new PairColorNames(new XColor( 162, 100, 128 ), new XColorName("紫","Deluge")));
    	colorPaletteList.add(new PairColorNames(new XColor( 236, 224, 229 ), new XColorName("白","Snuff")));
    	colorPaletteList.add(new PairColorNames(new XColor( 218, 192, 204 ), new XColorName("白","Lavender Gray")));
    	colorPaletteList.add(new PairColorNames(new XColor( 199, 161, 178 ), new XColorName("紫","Logan")));
    	colorPaletteList.add(new PairColorNames(new XColor( 123, 73, 96 ), new XColorName("紫","Mulled Wine")));
    	colorPaletteList.add(new PairColorNames(new XColor( 81, 49, 63 ), new XColorName("紫","Martinique")));
       
        
        //        { 198, 172, 75 },           // Pelorous
        //        { 243, 238, 219 },          // Iceberg
        //        { 232, 221, 182 },          // Powder Blue
        //        { 221, 205, 147 },          // Morning Glory
        //        { 155, 132, 49 },           // Astral
        //        { 103, 88, 33 },            // Blue Dianne
    	colorPaletteList.add(new PairColorNames(new XColor( 198, 172, 75 ), new XColorName("青","Pelorous")));
    	colorPaletteList.add(new PairColorNames(new XColor( 243, 238, 219 ), new XColorName("白","Iceberg")));
    	colorPaletteList.add(new PairColorNames(new XColor( 232, 221, 182 ), new XColorName("青","Powder Blue")));
    	colorPaletteList.add(new PairColorNames(new XColor( 221, 205, 147 ), new XColorName("青","Morning Glory")));
    	colorPaletteList.add(new PairColorNames(new XColor( 155, 132, 49 ), new XColorName("青","Astral")));
    	colorPaletteList.add(new PairColorNames(new XColor( 103, 88, 33 ), new XColorName("青","Blue Dianne")));

        
        //        { 70, 150, 247 },           // Tan Hide
        //        { 217, 233, 253 },          // Cinderella
        //        { 180, 213, 252 },          // Light Apricot
        //        { 144, 192, 250 },          // Corvette
        //        { 10, 109, 228 },           // Christine
        //        { 7, 72, 151 },             // Oregon

    	colorPaletteList.add(new PairColorNames(new XColor( 70, 150, 247 ), new XColorName("橙","Tan Hide")));
    	colorPaletteList.add(new PairColorNames(new XColor( 217, 233, 253 ), new XColorName("白","Cinderella")));
    	colorPaletteList.add(new PairColorNames(new XColor( 180, 213, 252 ), new XColorName("橙","Light Apricot")));
    	colorPaletteList.add(new PairColorNames(new XColor( 144, 192, 250 ), new XColorName("橙","Corvette")));
    	colorPaletteList.add(new PairColorNames(new XColor( 10, 109, 228 ), new XColorName("橙","Christine")));
    	colorPaletteList.add(new PairColorNames(new XColor( 7, 72, 151 ), new XColorName("黄","Oregon")));
    	
        
        
        //        { 0, 0, 192 },              // Guardsman Red
        //        { 0, 0, 255 },              // Red
        //        { 0, 192, 255 },            // Amber
        //        { 0, 255, 255 },            // Yellow
        //        { 80, 208, 146 },           // Conifer
        //        { 80, 176, 0 },             // Jade
        //        { 240, 176, 0 },            // Cerulean
        //        { 192, 112, 0 },            // Lochmara
        //        { 96, 32, 0 },              // Midnight Blue
        //        { 160, 48, 112 }            // Royal Purple

    	colorPaletteList.add(new PairColorNames(new XColor( 0, 0, 192 ), new XColorName("红","Guardsman Red")));
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 0, 255 ), new XColorName("红","Red")));
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 192, 255 ), new XColorName("黄","Amber")));
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 255, 255 ), new XColorName("黄","Yellow")));
    	colorPaletteList.add(new PairColorNames(new XColor( 80, 208, 146 ), new XColorName("绿","Conifer")));
    	colorPaletteList.add(new PairColorNames(new XColor( 80, 176, 0 ), new XColorName("绿","Jade")));
    	colorPaletteList.add(new PairColorNames(new XColor( 240, 176, 0 ), new XColorName("蓝","Cerulean")));
    	colorPaletteList.add(new PairColorNames(new XColor( 192, 112, 0 ), new XColorName("蓝","Lochmara")));
    	colorPaletteList.add(new PairColorNames(new XColor( 96, 32, 0 ), new XColorName("蓝","Midnight Blue")));
    	colorPaletteList.add(new PairColorNames(new XColor( 160, 48, 112 ), new XColorName("紫","Royal Purple")));
    	
        // ================================================== 70-Color Palette (End)  ==================================================
        // =================================================== Ideal Color (Start)  ====================================================
        // (Only include the ideal colors that were not listed in the 70-Color Palette)
        // REF: http://www.rapidtables.com/web/color/RGB_Color.htm

    	colorPaletteList.add(new PairColorNames(new XColor( 0, 255, 0 ), new XColorName("绿","Light Green")));
    	colorPaletteList.add(new PairColorNames(new XColor( 255, 0, 0 ), new XColorName("蓝","Blue")));
    	colorPaletteList.add(new PairColorNames(new XColor( 255, 255, 0 ), new XColorName("青","Cyan")));
    	colorPaletteList.add(new PairColorNames(new XColor( 255, 0, 255 ), new XColorName("紫","Magenta")));
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 0, 128 ), new XColorName("黄","Maroon")));
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 128, 128 ), new XColorName("黄","Olive")));
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 128, 0 ), new XColorName("绿","Green")));
    	colorPaletteList.add(new PairColorNames(new XColor( 192, 112, 0 ), new XColorName("蓝","Lochmara")));
    	colorPaletteList.add(new PairColorNames(new XColor( 128, 0, 128 ), new XColorName("紫","Purple")));
    	colorPaletteList.add(new PairColorNames(new XColor( 128, 128, 0 ), new XColorName("青","Teal")));
    	colorPaletteList.add(new PairColorNames(new XColor( 128, 0, 0 ), new XColorName("蓝","Navy")));
 
        // ==================================================== Ideal Color (End)  =====================================================

        // =============================================== Yellow Color Series (Start)  ================================================
        // REF: http://www.workwithcolor.com/yellow-color-hue-range-01.htm

    	colorPaletteList.add(new PairColorNames(new XColor( 240, 255, 255 ), new XColorName("白","Ivory")));
    	colorPaletteList.add(new PairColorNames(new XColor( 208, 253, 255 ), new XColorName("白","Cream")));
    	colorPaletteList.add(new PairColorNames(new XColor( 150, 253, 253 ), new XColorName("黄","Pastel Yellow")));
    	colorPaletteList.add(new PairColorNames(new XColor( 220, 245, 245 ), new XColorName("白","Beige")));
    	colorPaletteList.add(new PairColorNames(new XColor( 49, 255, 255 ), new XColorName("黄","Daffodil")));
    	
    	colorPaletteList.add(new PairColorNames(new XColor( 94, 247, 252 ), new XColorName("黄","Icterine")));
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 247, 255 ), new XColorName("黄","Lemon")));
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 239, 255 ), new XColorName("黄","Canary Yellow")));
    	colorPaletteList.add(new PairColorNames(new XColor( 142, 233, 247 ), new XColorName("黄","Flavescent")));
    	colorPaletteList.add(new PairColorNames(new XColor( 93, 236, 251 ), new XColorName("黄","Corn")));
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 223, 255 ), new XColorName("黄","Golden Yellow")));
 
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 230, 238 ), new XColorName("黄","Titanium Yellow")));
    	colorPaletteList.add(new PairColorNames(new XColor( 48, 225, 240 ), new XColorName("黄","Dandelion")));
    	colorPaletteList.add(new PairColorNames(new XColor( 0, 226, 230 ), new XColorName("黄","Peridot")));
    	colorPaletteList.add(new PairColorNames(new XColor( 111, 217, 228 ), new XColorName("黄","Straw")));
    	colorPaletteList.add(new PairColorNames(new XColor( 64, 213, 236 ), new XColorName("黄","Sandstorm")));
    	colorPaletteList.add(new PairColorNames(new XColor( 196, 207, 207 ), new XColorName("灰","Pastel Gray")));    	

    	colorPaletteList.add(new PairColorNames(new XColor( 10, 208, 228 ), new XColorName("黄","Citrine")));
    	colorPaletteList.add(new PairColorNames(new XColor( 107, 183, 189 ), new XColorName("黄","Dark Khaki")));
    	colorPaletteList.add(new PairColorNames(new XColor( 66, 166, 181 ), new XColorName("黄","Brass")));   
         
    }
    //清除
    public void clear()
    {
    	this.colorPaletteList.clear();
    }

    public boolean isInitialized()
    {
      return this.colorPaletteList.size() > 0;
    }

    class LAB_CLASS
	{
	   private double l;
	   private double a;
	   private double b;
	   
	   public double getL() {
		return l;
	}

	public void setL(double l) {
		this.l = l;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public LAB_CLASS(double l,double a,double b)
	   {
		   this.l = l;
		   this.a = a;
		   this.b = b;
	   }

	public LAB_CLASS() {
		
	}
	}

	public void BGR2Lab(double[] bgr, LAB_CLASS lab )
	{
		//BGR2XYZ( $BGR, $XYZ );
		double r = bgr[2];
		double g = bgr[1];
		double b = bgr[0];

		if (r > 0.04045) 
		{
			r = Math.pow((r + 0.055) / 1.055, 2.4);
		}
		else 
		{
			r = r / 12.92; 
		}

		if ( g > 0.04045)
		{
			g = Math.pow((g + 0.055) / 1.055, 2.4); 
		}
		else 
		{ 
			g = g / 12.92; 
		}

		if (b > 0.04045)
		{ 
			b = Math.pow((b + 0.055) / 1.055, 2.4); 
		}
		else 
		{	
			b = b / 12.92; 
		}

		r = r * 100.0;
		g = g * 100.0;
		b = b * 100.0;

		double[] XYZ = new double[3];
		XYZ[0] = r * 0.4124 + g * 0.3576 + b * 0.1805;
		XYZ[1] = r * 0.2126 + g * 0.7152 + b * 0.0722;
		XYZ[2] = r * 0.0193 + g * 0.1192 + b * 0.9505;
		
		//XYZ2Lab( $XYZ, $Lab );
		double refx = 95.047;
		double refy = 100.000;
		double refz = 108.883;

		double x = XYZ[0] / refx;
		double y = XYZ[1] / refy;
		double z = XYZ[2] / refz;

		if ( x > 0.008856 ) { x = Math.pow( x , 1.0/3.0 ); }
		else { x = ( 7.787 * x ) + ( 16.0/116.0 ); }
		
		if ( y > 0.008856 ) { y = Math.pow( y , 1.0/3.0 ); }
		else { y = ( 7.787 * y ) + ( 16.0/116.0 ); }

		if ( z > 0.008856 ) { z = Math.pow( z , 1.0/3.0 ); }
		else { z = ( 7.787 * z ) + ( 16.0/116.0 ); }

		lab.setL(( 116.0 * y ) - 16.0);
		lab.setA(500.0 * ( x - y ));
		lab.setB(200.0 * ( y - z ));
	}

	public double _CIEDE2000(LAB_CLASS lab1, LAB_CLASS lab2)
	{
		double k_L = 1.0; 
		double k_C = 1.0; 
		double k_H = 1.0;
		
		// PHP 方法deg2Rad
	    double deg360InRad = Math.toRadians(360.0);
	    double deg180InRad = Math.toRadians(180.0);
	    double pow25To7 = 6103515625.0;  /* pow(25, 7) */

	    /*
	     * Step 1
	     */
	    
	    /* Equation 2 */
	    double C1 = Math.sqrt(lab1.getA() * lab1.getA() + lab1.getB() * lab1.getB());
	    double C2 = Math.sqrt(lab2.getA() * lab2.getA() + lab2.getB() * lab2.getB());
	    
	    /* Equation 3 */
	    double barC = (C1 + C2) / 2.0;
	    
	    /* Equation 4 */
	    double G = 0.5 * (1 - Math.sqrt(Math.pow(barC, 7) / (Math.pow(barC, 7) + pow25To7)));
	    
	    /* Equation 5 */
	    double a1Prime = (1.0 + G) * lab1.getA();
	    double a2Prime = (1.0 + G) * lab1.getA();
	    
	    /* Equation 6 */
	    double CPrime1 = Math.sqrt((a1Prime * a1Prime) + (lab1.getB() * lab1.getB()));
	    double CPrime2 = Math.sqrt((a2Prime * a2Prime) + (lab2.getB() * lab2.getB()));
	    
	    /* Equation 7 */
	    double hPrime1;
	    if (lab1.getB() == 0 && a1Prime == 0)
	    {
	        hPrime1 = 0.0;
	    }
	    else 
	    {
	        hPrime1 = Math.atan2(lab1.getB(), a1Prime);
	        /*
	         * This must be converted to a hue angle in degrees between 0
	         * and 360 by addition of 2􏰏 to negative hue angles.
	         */
	        if (hPrime1 < 0)
	            hPrime1 += deg360InRad;
	    }
	    double hPrime2 = 0.0;
	    
	    if (lab1.getB() == 0 && a2Prime == 0)
	        hPrime2 = 0.0;
	    else {
	        hPrime2 = Math.atan2(lab2.getB(), a2Prime);
	        /*
	         * This must be converted to a hue angle in degrees between 0
	         * and 360 by addition of 2􏰏 to negative hue angles.
	         */
	        if (hPrime2 < 0)
	            hPrime2 += deg360InRad;
	    }
	    
	    /*
	     * Step 2
	     */
	    /* Equation 8 */
	    double deltaLPrime = lab2.getL() - lab1.getL();
	    /* Equation 9 */
	    double deltaCPrime = CPrime2 - CPrime1;
	    /* Equation 10 */
	    double deltahPrime = 0;
	    double CPrimeProduct = CPrime1 * CPrime2;
	    
	    if (CPrimeProduct == 0)
	        deltahPrime = 0;
	    else {
	        /* Avoid the fabs() call */
	        deltahPrime = hPrime2 - hPrime1;
	        if (deltahPrime < -deg180InRad)
	            deltahPrime += deg360InRad;
	        else if (deltahPrime > deg180InRad)
	            deltahPrime -= deg360InRad;
	    }
	    /* Equation 11 */
	    double deltaHPrime = 2.0 * Math.sqrt(CPrimeProduct) *Math.sin(deltahPrime / 2.0);
	    
	    
	    /*
	     * Step 3
	     */
	    /* Equation 12 */
	    double barLPrime = (lab1.getL() + lab2.getL()) / 2.0;
	    /* Equation 13 */
	    double barCPrime = (CPrime1 + CPrime2) / 2.0;
	    /* Equation 14 */
	    double barhPrime;
	    double hPrimeSum = hPrime1 + hPrime2;
	    if (CPrime1 * CPrime2 == 0) {
	        barhPrime = hPrimeSum;
	    } else {
	        if (Math.abs(hPrime1 - hPrime2) <= deg180InRad)
	            barhPrime = hPrimeSum / 2.0;
	        else {
	            if (hPrimeSum < deg360InRad)
	                barhPrime = (hPrimeSum + deg360InRad) / 2.0;
	            else
	                barhPrime = (hPrimeSum - deg360InRad) / 2.0;
	        }
	    }
	    /* Equation 15 */
	    double T = 1.0 - (0.17 * Math.cos(barhPrime - Math.toRadians(30.0))) +
	    (0.24 * Math.cos(2.0 * barhPrime)) +
	    (0.32 * Math.cos((3.0 * barhPrime) + Math.toRadians(6.0))) -
	    (0.20 * Math.cos((4.0 * barhPrime) - Math.toRadians(63.0)));
	    /* Equation 16 */
	    double deltaTheta = Math.toRadians(30.0) *
	    		Math.exp(-Math.pow((barhPrime - Math.toRadians(275.0)) / Math.toRadians(25.0), 2.0));
	    /* Equation 17 */
	    double R_C = 2.0 * Math.sqrt(Math.pow(barCPrime, 7.0) /
	                            (Math.pow(barCPrime, 7.0) + pow25To7));
	    /* Equation 18 */
	    double S_L = 1 + ((0.015 * Math.pow(barLPrime - 50.0, 2.0)) /
	    		Math.sqrt(20 + Math.pow(barLPrime - 50.0, 2.0)));
	    /* Equation 19 */
	    double S_C = 1 + (0.045 * barCPrime);
	    /* Equation 20 */
	    double S_H = 1 + (0.015 * barCPrime * T);
	    /* Equation 21 */
	    double R_T = (-Math.sin(2.0 * deltaTheta)) * R_C;
	    
	    /* Equation 22 */
	    double deltaE = Math.sqrt(
	    		Math.pow(deltaLPrime / (k_L * S_L), 2.0) +
	                         Math.pow(deltaCPrime / (k_C * S_C), 2.0) +
	                         Math.pow(deltaHPrime / (k_H * S_H), 2.0) + 
	                         (R_T * (deltaCPrime / (k_C * S_C)) * (deltaHPrime / (k_H * S_H))));
	    
		return deltaE;
	}

    /**
     * 核心算法
     * @param bgr1
     * @param bgr2
     * @return
     */  
	public double CIEDE2000(double[] bgr1, double[]  bgr2)
	{
	    LAB_CLASS lab1 = new LAB_CLASS();
	    LAB_CLASS lab2 = new LAB_CLASS();
	    
	    BGR2Lab( bgr1, lab1 );
	    BGR2Lab( bgr2, lab2 );
	    
	    return _CIEDE2000(lab1, lab2 );
	}
	
    public PairColorNames mapColor(XColor inputBGR, boolean isRangeIn255)
    {
    	// 判断是否已经初始化
    	if(!isInitialized())
    	{
    		System.out.println("The color List are not initialized!");
    		return null;
    	}
      	
    	double minDist = 0;
    	int minDistIdx = 0;
       
    	// 输入颜色
   		XColor xColor1 = inputBGR;
   		double r1 = xColor1.getR();
   		double g1 = xColor1.getG();
   		double b1 = xColor1.getB();
       
   		double[] bgr1= {b1, g1, r1};
       
   		if(isRangeIn255)
        {
    	   bgr1[0] = bgr1[0] / 255.0;
    	   bgr1[1] = bgr1[1] / 255.0;
    	   bgr1[2] = bgr1[2] / 255.0;
        }
    
   		for (int i=0; i<colorPaletteList.size(); i++) 
   		{
	    	XColor xColorTemp = colorPaletteList.get(i).getXColor();
	    	double r = xColorTemp.getR();
	    	double g= xColorTemp.getG();
	    	double b = xColorTemp.getB();
    	
	    	double[] bgr2 =  {b/255.0, g/255.0, r/255.0};
	    	
	    	// 相似度
	    	double thisDist = CIEDE2000(bgr1, bgr2);
	        if(i == 0 )
	        {
	            minDist = thisDist;
	            minDistIdx = i;
	        }
	        else if( thisDist < minDist )
	        {
	            minDist = thisDist;
	            minDistIdx = i;
	        }		    	
	}
    
    if( isRangeIn255 )
    {
    	//outputBGR = colorPaletteList.get(minDistIdx).getXColor();
    }
    else
    {
    	XColor outputBGRTemp = colorPaletteList.get(minDistIdx).getXColor();
    	
    	outputBGRTemp.setB(outputBGRTemp.getB()/255.0);
    	outputBGRTemp.setR(outputBGRTemp.getR()/255.0);
    	outputBGRTemp.setG(outputBGRTemp.getG()/255.0);
    	colorPaletteList.get(minDistIdx).setFirst(outputBGRTemp);
    }

    System.out.println("最小距离：" + minDist);
    
     // 结果返回
     PairColorNames pairColorName =  colorPaletteList.get(minDistIdx);
     return pairColorName;
    }
    
    
    /**
     * 根据输入颜色inputBGR 对inputBGRList中的颜色根据匹配度排序
     * @param inputBGR
     * @param inputBGRList
     * @return List<XColor> 已排序的颜色列表
     */
    public List<XColor> sortColorList(XColor inputBGR, List<XColor> inputBGRList)
    {
    	List<XColor> outputBGRList = new ArrayList<XColor>();
    	while(inputBGRList.size() > 0)
    	{
    		eliminate(inputBGR, inputBGRList, outputBGRList);	
    	}
    	
    	return outputBGRList;
    	
    }
    
    
	private void eliminate(XColor inputBGR, List<XColor> inputBGRList, List<XColor> otputBGRList)
	{
		
		double minDist = 0;
    	int minDistIdx = 0;
       
    	// 输入颜色
   		XColor xColor1 = inputBGR;
   		double r1 = xColor1.getR();
   		double g1 = xColor1.getG();
   		double b1 = xColor1.getB();
       
   		double[] bgr1= {b1, g1, r1};       
	    bgr1[0] = bgr1[0] / 255.0;
	    bgr1[1] = bgr1[1] / 255.0;
	    bgr1[2] = bgr1[2] / 255.0;
	    
   		for (int i=0; i< inputBGRList.size(); i++) 
   		{
	    	XColor xColorTemp = inputBGRList.get(i);
	    	
	    	double r = xColorTemp.getR();
	    	double g = xColorTemp.getG();
	    	double b = xColorTemp.getB();
    	
	    	double[] bgr2 =  {b/255.0, g/255.0, r/255.0};
	    	
	    	// 相似度
	    	double thisDist = CIEDE2000(bgr1, bgr2);
	        if(i == 0 )
	        {
	            minDist = thisDist;
	            minDistIdx = i;
	        }
	        else if( thisDist < minDist )
	        {
	            minDist = thisDist;
	            minDistIdx = i;
	        }		    	
   		}
   		// 输出结果list增加
   		otputBGRList.add(inputBGRList.get(minDistIdx));
   		
   		// 剔除已匹配的记录
   		inputBGRList.remove(minDistIdx);
   		
	}

}
