package com.jiuling.web.dao;

import com.jiuling.web.model.TaskFile;
import com.jiuling.web.model.TaskFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskFileMapper {
    long countByExample(TaskFileExample example);

    int deleteByExample(TaskFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaskFile record);

    int insertSelective(TaskFile record);

    List<TaskFile> selectByExample(TaskFileExample example);

    TaskFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaskFile record, @Param("example") TaskFileExample example);

    int updateByExample(@Param("record") TaskFile record, @Param("example") TaskFileExample example);

    int updateByPrimaryKeySelective(TaskFile record);

    int updateByPrimaryKey(TaskFile record);
}