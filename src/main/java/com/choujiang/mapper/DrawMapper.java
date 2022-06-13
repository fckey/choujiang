package com.choujiang.mapper;

import com.choujiang.domain.Draw;
import com.choujiang.domain.DrawExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrawMapper {
    long countByExample(DrawExample example);

    int deleteByExample(DrawExample example);

    int deleteByPrimaryKey(Integer drawId);

    int insert(Draw record);

    int insertSelective(Draw record);

    List<Draw> selectByExample(DrawExample example);

    Draw selectByPrimaryKey(Integer drawId);

    int updateByExampleSelective(@Param("record") Draw record, @Param("example") DrawExample example);

    int updateByExample(@Param("record") Draw record, @Param("example") DrawExample example);

    int updateByPrimaryKeySelective(Draw record);

    int updateByPrimaryKey(Draw record);
}