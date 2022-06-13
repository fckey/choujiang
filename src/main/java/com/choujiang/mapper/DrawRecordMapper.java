package com.choujiang.mapper;

import com.choujiang.domain.DrawRecord;
import com.choujiang.domain.DrawRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrawRecordMapper {
    long countByExample(DrawRecordExample example);

    int deleteByExample(DrawRecordExample example);

    int deleteByPrimaryKey(Integer recordId);

    int insert(DrawRecord record);

    int insertSelective(DrawRecord record);

    List<DrawRecord> selectByExample(DrawRecordExample example);

    DrawRecord selectByPrimaryKey(Integer recordId);

    int updateByExampleSelective(@Param("record") DrawRecord record, @Param("example") DrawRecordExample example);

    int updateByExample(@Param("record") DrawRecord record, @Param("example") DrawRecordExample example);

    int updateByPrimaryKeySelective(DrawRecord record);

    int updateByPrimaryKey(DrawRecord record);
}