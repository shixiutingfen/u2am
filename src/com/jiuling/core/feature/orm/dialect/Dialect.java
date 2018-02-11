package com.jiuling.core.feature.orm.dialect;

/**
 * 数据库方言抽象类
 * 
 * @author YangXQ
 * @since 2016/1/11/11:00
 **/
public abstract class Dialect {

    /**
     * 得到分页sql
     * 
 	 * @param sql 原始查询SQL
	 * @param offset 偏移量 : 第一条数据在表中的位置（当前开始位置）
	 * @param limit 每页数量
     * @return
     */
    public abstract String getLimitString(String sql, int offset, int limit);

    /**
     * 得到总数量 sql
     * 
     * @param sql 原始查询SQL
     * @return
     */
    public abstract String getCountString(String sql);

}
