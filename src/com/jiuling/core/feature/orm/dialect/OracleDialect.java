package com.jiuling.core.feature.orm.dialect;

/**
 * oracle数据库方言
 * @author YangXQ
 * @since 2016/1/11/11:00
 **/
public class OracleDialect extends Dialect {

	/**
	 *  得到分页的SQL
	 * @param sql 原始查询SQL
	 * @param offset 偏移量 : 第一条数据在表中的位置（当前开始位置）
	 * @param limit 每页数量
	 */
    @Override
    public String getLimitString(String sql, int offset, int limit) {

    	return OraclePageHepler.getLimitString(sql, offset, limit);
    }
    
    /**
     * Oracle分页查询
     * @param sql 原始查询SQL
     */
    @Override
    public String getCountString(String sql) {
        return OraclePageHepler.getCountString(sql);
    }
}
