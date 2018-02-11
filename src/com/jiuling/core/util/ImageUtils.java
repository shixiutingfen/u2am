package com.jiuling.core.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.springframework.util.StreamUtils;

import com.jiuling.core.feature.image.PolygonPoint;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * 图片缩放工具类.<br>
 * 
 * @see <a href="http://luoyahu.iteye.com/blog/1312043">http://luoyahu.iteye.com/blog/1312043</a>
 */
public class ImageUtils {

	public static void resize(File originalFile, File resizedFile,
			int newWidth, float quality) throws IOException {

		if (quality > 1) {
			throw new IllegalArgumentException(
					"Quality has to be between 0 and 1");
		}

		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;

		int iWidth = i.getWidth(null);
		int iHeight = i.getHeight(null);

		if (iWidth > iHeight) {
			resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)
					/ iWidth, Image.SCALE_SMOOTH);
		} else {
			resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight,
					newWidth, Image.SCALE_SMOOTH);
		}

		// This code ensures that all the pixels in the image are loaded.
		Image temp = new ImageIcon(resizedImage).getImage();

		// Create the buffered image.
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
				temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

		// Copy image to buffered image.
		Graphics g = bufferedImage.createGraphics();

		// Clear background and paint the image.
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();

		// Soften.
		float softenFactor = 0.05f;
		float[] softenArray = { 0, softenFactor, 0, softenFactor,
				1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
		Kernel kernel = new Kernel(3, 3, softenArray);
		ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		bufferedImage = cOp.filter(bufferedImage, null);

		// Write the jpeg to a file.
		FileOutputStream out = new FileOutputStream(resizedFile);

		// Encodes image as a JPEG data stream
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

		JPEGEncodeParam param = encoder
				.getDefaultJPEGEncodeParam(bufferedImage);

		param.setQuality(quality, true);

		encoder.setJPEGEncodeParam(param);
		encoder.encode(bufferedImage);
		out.flush();
		out.close();
	} // Example usage

	/**
	 * 图片转化成base64字符串
	 * 
	 * @param picPath
	 *            待处理的图片绝对路径
	 * @return 返回Base64编码过的字节数组字符串
	 */
	public static String image2Str(String picPath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		String imgFile = picPath;// 待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * base64字符串转化成图片
	 * 
	 * @param imgStr
	 *            Base64编码过的字节数组字符串
	 * @param imgFilePath
	 *            新生成的图片路径
	 * @return true 成功，false失败
	 */
	public static boolean str2Image(String imgStr, String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 图片截取缩略图
	 * @param approot 根路径
	 * @param filePath 文件路径
	 * @param picType 新文件后缀
	 * @return
	 * @throws IOException
	 */
	public static String snapshotPic(String approot, String filePath, String picType) throws IOException {
		String smallFilePath;
		String ffmpegPath = approot + "3nd\\ffmpeg.exe";
		//String resPath = PropertiesUtil.getFtpPackey("file.service.path").substring(1,PropertiesUtil.getFtpPackey("file.service.path").length());
		String fileName = filePath.substring(filePath.lastIndexOf("/") + 1,filePath.lastIndexOf('.')) + "-" + picType + ".jpg";
		smallFilePath= approot  +"\\" + fileName;
		List<String> commend = new java.util.ArrayList<String>();
		commend.add(ffmpegPath);
		commend.add("-i");
		commend.add(filePath);
		commend.add("-y");
		commend.add("-f");
		commend.add("image2");
		commend.add("-ss");
		commend.add("1");
		if (picType.equals("small")) {
			commend.add("-s");
			commend.add("120x120");
		}
		commend.add(smallFilePath);
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			builder.redirectErrorStream(true);
			System.out.println("视频截图开始" + commend.toString());
			Process process = builder.start();
			InputStream in = process.getInputStream();
			String info = StreamUtils.copyToString(in, Charset.defaultCharset());
	        System.out.println("result:" + info);	
	        in.close();
			process.destroy();
			System.out.println("视频截图完成...");
		} catch (Exception e) {
			 e.printStackTrace();  
	         System.out.println("视频截图失败！");
		}
		return smallFilePath;
	}

	public static void main(String[] args) throws IOException {
		/*// File originalImage = new File("C:\\11.jpg");
		// resize(originalImage, new File("c:\\11-0.jpg"),150, 0.7f);
		// resize(originalImage, new File("c:\\11-1.jpg"),150, 1f);
		String pathname = "c:\\1.png";
		String small = "c:\\1-small.png";
		File originalImage = new File(pathname);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			resize(originalImage, new File(small), 800, 1f);
		}
		long end = System.currentTimeMillis() - start;
		System.out.println(end);*/

		// String strImg =
		String strImg = "";
		// System.out.println(strImg);
		strImg = image2Str("C:\\Users\\Administrator\\Desktop\\1.jpg");
		System.out.println(strImg);

		str2Image(strImg, "d:/a.jpg");
	}
	
	
	/**
     * 将图片的白色区域设置成透明
     * @param srcImagePath 原图片路径
     * @param destImagePath 目标图片路径
     */
    public static void convert(String srcImagePath, String destImagePath) {
        try {  
            BufferedImage image = ImageIO.read(new File(srcImagePath));  
            ImageIcon imageIcon = new ImageIcon(image);  
            BufferedImage bufferedImage = new BufferedImage(  
                    imageIcon.getIconWidth(), imageIcon.getIconHeight(),  BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();  
            g2D.drawImage(imageIcon.getImage(), 0, 0,  
                    imageIcon.getImageObserver());  
            int alpha = 0;  
            for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {  
                for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {  
                    int rgb = bufferedImage.getRGB(j2, j1);  
                    if (colorInRange(rgb))  
                        alpha = 0;  
                    else  
                        alpha = 255;  
                    rgb = (alpha << 24) | (rgb & 0x00ffffff);  
                    bufferedImage.setRGB(j2, j1, rgb);
                }  
            }
            g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());
            
            // 生成图片为PNG  
            String outFile = destImagePath.substring(0, destImagePath.lastIndexOf(".")); 
            
            ImageIO.write(bufferedImage, "png", new File(outFile + ".png"));
            
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    
    public static boolean colorInRange(int color) {  
        int red = (color & 0xff0000) >> 16;  
        int green = (color & 0x00ff00) >> 8;  
        int blue = (color & 0x0000ff);  
        if (red >= color_range && green >= color_range && blue >= color_range)  
            return true;  
        return false;  
    } 
    
    public static int color_range = 210;
    
    /**
     * 截取图片: 背景设置成白色
     * 
     * @param srcImageFile
     *            原图片地址
     * @param x
     *            截取时的x坐标
     * @param y
     *            截取时的y坐标
     * @param desWidth
     *            截取的宽度
     * @param desHeight
     *            截取的高度
     */
    public static String imgCut(String srcImageFile, int x, int y, int desWidth, int desHeight) {
        String resultFileName = "";
        try {
            Image img;
            ImageFilter cropFilter;
            BufferedImage bi = ImageIO.read(new File(srcImageFile));
            int srcWidth = bi.getWidth();
            int srcHeight = bi.getHeight();
            if (srcWidth >= desWidth && srcHeight >= desHeight) {
                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
                cropFilter = new CropImageFilter(x, y, desWidth, desHeight);
                img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
                
                if(desWidth == 0 )
                {
                    desWidth = 1;
                }
                if(desHeight == 0 )
                {
                    desHeight = 1;
                }
                
                BufferedImage tag = new BufferedImage(desWidth, desHeight, BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0,Color.WHITE, null);
                g.dispose();
                
                resultFileName = srcImageFile.substring(0, srcImageFile.lastIndexOf(".")) + "_" + System.currentTimeMillis() + "_cut.png";// 输出文件

                ImageIO.write(tag, "png", new File(resultFileName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultFileName;
    }
    
    /**
     * 将图片不相干区域填成白色
     * @param areaType 画图模式
     * @param width 感兴趣区/非感兴趣区宽度
     * @param height 感兴趣区/非感兴趣区高度
     * @param polygons 感兴趣区/非感兴趣区坐标
     * @param destImagePath  目标图标路径
     * @param file 源文件
     * @throws IOException 
     */
    public static void reDrawPNG(int width, int height, PolygonPoint[][] polygons, String destImagePath, File file) throws IOException {
        
        // 创建BufferedImage对象
        //BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        FileInputStream fileIput = new FileInputStream(file);
        //BufferedImage image = new BufferedImage(fileIput);
        BufferedImage image = ImageIO.read(fileIput);
        
        // 获取Graphics2D
        Graphics2D g2d = image.createGraphics();
        
        Color color  = new Color(255, 255, 255);
        g2d.setPaint(color);
        
        Rectangle r = new Rectangle(0, 0, width, height);
        Area a = new Area(r);
        
        Area roi = new Area();
        for (int i = 0; i < polygons.length; i++) {
            Polygon p = new Polygon();
            PolygonPoint[] polygon = polygons[i];

            for (int j = 0; j < polygon.length; j++) {
                PolygonPoint pp = polygon[j];
                if (null != pp) {
                    p.addPoint(pp.getX(), pp.getY());
                }
            }
            roi.add(new Area(p));
        }
        
        Area fillArea  = a;
        fillArea.subtract(roi);
        
        g2d.setClip(fillArea);
        g2d.fillRect(0, 0, width, height);
        
        //释放对象
        g2d.dispose();
        
        // 保存文件
        try {
            ImageIO.write(image, "png", new File(destImagePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("生成png图片失败!");
        }
    }
}
