package com.jiuling.web.dao;

import com.jiuling.web.model.PersonResult;
import com.jiuling.web.model.PersonResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonResultMapper {
    long countByExample(PersonResultExample example);

    int deleteByExample(PersonResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PersonResult record);

    int insertSelective(PersonResult record);

    List<PersonResult> selectByExampleWithBLOBs(PersonResultExample example);

    List<PersonResult> selectByExample(PersonResultExample example);

    PersonResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PersonResult record, @Param("example") PersonResultExample example);

    int updateByExampleWithBLOBs(@Param("record") PersonResult record, @Param("example") PersonResultExample example);

    int updateByExample(@Param("record") PersonResult record, @Param("example") PersonResultExample example);

    int updateByPrimaryKeySelective(PersonResult record);

    int updateByPrimaryKeyWithBLOBs(PersonResult record);

    int updateByPrimaryKey(PersonResult record);
}