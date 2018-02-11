package com.jiuling.web.dao;

import com.jiuling.web.model.VsdTask;
import com.jiuling.web.model.VsdTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VsdTaskMapper {
    long countByExample(VsdTaskExample example);

    int deleteByExample(VsdTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VsdTask record);

    int insertSelective(VsdTask record);

    List<VsdTask> selectByExample(VsdTaskExample example);

    VsdTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VsdTask record, @Param("example") VsdTaskExample example);

    int updateByExample(@Param("record") VsdTask record, @Param("example") VsdTaskExample example);

    int updateByPrimaryKeySelective(VsdTask record);

    int updateByPrimaryKey(VsdTask record);
}