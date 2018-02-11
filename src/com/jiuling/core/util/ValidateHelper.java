package com.jiuling.core.util;

import java.util.List;

/**
 * 校验工具类
 * @author admin
 *
 */
public final class ValidateHelper
{
	/**
	 * 图片格式后缀
	 */
	public static final String IMAGE_SUFFIX="BMP、JPG、JPEG、PNG、GIF";
	/**
	 * 视频格式后缀
	 */
	private static final String VIDEO_SUFFIX="MPEG、AVI、MOV、ASF、WMV、3GP、REAL VIDEO、FLV、MKV、RMVB";
	/**
	 * 语音格式后缀
	 */
	private static final String AUDIO_SUFFIX="CD、WAV、WMA、RealAudio、AAC";
    private ValidateHelper()
    {
        
    }
    
    /**
     * 判断List是否为空
     * @param list
     * @return
     */
    public static boolean isNotEmptyList(List<?> list)
    {
        if (null != list) 
        {
            if ((list.size() > 0) && !list.isEmpty()) return true;
        } 
        return false;
    }
    
    /**
     * 判断List是否为空
     * @param list
     * @return
     */
    public static boolean isEmptyList(List<?> list)
    {
        return !isNotEmptyList(list);
    }
    /**
     * 判断是否为图片格式文件
     * @param suffix
     * @return
     */
    public  static boolean isImageSuffix(String suffix){
    	if(StringUtils.isEmptyString(suffix))return false;
    	suffix=suffix.toUpperCase();
    	return ValidateHelper.IMAGE_SUFFIX.contains(suffix);
    }
    /**
     * 判断是否为视频文件格式
     * @param suffix
     * @return
     */
    public static boolean isVideoSuffix(String suffix){
    	if(StringUtils.isEmptyString(suffix))return false;
    	suffix=suffix.toUpperCase();
    	return ValidateHelper.VIDEO_SUFFIX.contains(suffix);
    }
    /**
     * 判断是否为音频格式
     * @param suffix
     * @return
     */
    public static boolean isAudioSuffix(String suffix){
    	if(StringUtils.isEmptyString(suffix))return false;
    	suffix=suffix.toUpperCase();
    	return ValidateHelper.AUDIO_SUFFIX.contains(suffix);
    }
}
