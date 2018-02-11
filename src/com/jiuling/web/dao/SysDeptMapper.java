package com.jiuling.web.dao;

import com.jiuling.core.base.BaseDao;
import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.web.model.SysDept;
import com.jiuling.web.model.SysDeptExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysDeptMapper extends BaseDao<SysDept, Long>{
    int countByExample(SysDeptExample example);

    int deleteByExample(SysDeptExample example);

    int deleteByPrimaryKey(Long deptId);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    List<SysDept> selectByExample(SysDeptExample example);

    SysDept selectByPrimaryKey(Long deptId);
    
    SysDept selectByUserId(String userId);

    int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
    
    /**
     * 查询子部门列表
     * @param deptId
     * @return
     */
   List<SysDept> selectChildren(Long deptId);
    
    /**
     * 分页查询
     * @param example
     * @return
     */
    List<SysDept> selectByExample(Page<SysDept> page,SysDeptExample example);
}