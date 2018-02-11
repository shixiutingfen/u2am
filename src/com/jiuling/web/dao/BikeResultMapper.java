package com.jiuling.web.dao;

import com.jiuling.web.model.BikeResult;
import com.jiuling.web.model.BikeResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BikeResultMapper {
    long countByExample(BikeResultExample example);

    int deleteByExample(BikeResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BikeResult record);

    int insertSelective(BikeResult record);

    List<BikeResult> selectByExample(BikeResultExample example);

    BikeResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BikeResult record, @Param("example") BikeResultExample example);

    int updateByExample(@Param("record") BikeResult record, @Param("example") BikeResultExample example);

    int updateByPrimaryKeySelective(BikeResult record);

    int updateByPrimaryKey(BikeResult record);
}