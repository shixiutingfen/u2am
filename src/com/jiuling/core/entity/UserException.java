package com.jiuling.core.entity;

/**
 * UserException : 用户自定义异常
 *
 * @author YangXQ
 * @since 2016/1/11/14:30
 */
public class UserException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8684798381744691387L;
	/**
     * 异常发生时间
     */
    private long date = System.currentTimeMillis();

    public long getDate() {
        return date;
    }
}
