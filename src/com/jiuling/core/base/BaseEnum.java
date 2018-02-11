package com.jiuling.core.base;

/**
 * 所有自定义枚举类型实现该接口
 * 
 * @author YangXQ
 * @since 2016/1/11/11:00
 **/
public interface BaseEnum {

    /**
     * value: 为保存在数据库中的值
     */
    public String getValue();

    /**
     * text : 为前端显示值
     */
    public String getText();

}
