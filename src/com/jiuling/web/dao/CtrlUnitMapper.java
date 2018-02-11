package com.jiuling.web.dao;

import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.web.model.CtrlUnit;
import com.jiuling.web.model.CtrlUnitExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CtrlUnitMapper {
    int countByExample(CtrlUnitExample example);

    int deleteByExample(CtrlUnitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CtrlUnit record);

    int insertSelective(CtrlUnit record);

    List<CtrlUnit> selectByExample(CtrlUnitExample example);

    CtrlUnit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CtrlUnit record, @Param("example") CtrlUnitExample example);

    int updateByExample(@Param("record") CtrlUnit record, @Param("example") CtrlUnitExample example);

    int updateByPrimaryKeySelective(CtrlUnit record);

    int updateByPrimaryKey(CtrlUnit record);
    
    /**
     * 分页查询
     * @param page
     * @param example
     * @return
     */
    List<CtrlUnit> selectByExample(Page<CtrlUnit> page,CtrlUnitExample example);
    
    /**
     * 根据pid查询当前节点的所有子节点
     * @param pid
     * @return
     */
    @SuppressWarnings("rawtypes")
	List<CtrlUnit> queryChildTreeNode(Map map);
    /**
     * 根据节点id查询节点信息
     * @param id
     * @return
     */
    @SuppressWarnings("rawtypes")
	List<CtrlUnit> getTreeNode(Map map);
    
    /**
     * 查询长沙下所有节点信息
     * @param id
     * @return
     */
    List<CtrlUnit> initTreeNode();
    
    List<CtrlUnit> selectCtrlUnitsByPageNew(Page<CtrlUnit> page, Map<String, String> map);
}