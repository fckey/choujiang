package com.choujiang.mapper;

import com.choujiang.domain.Organization;
import com.choujiang.domain.OrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {
    long countByExample(OrganizationExample example);

    int deleteByExample(OrganizationExample example);

    int deleteByPrimaryKey(Integer orgCode);

    int insert(Organization record);

    int insertSelective(Organization record);

    List<Organization> selectByExample(OrganizationExample example);

    Organization selectByPrimaryKey(Integer orgCode);

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    int selectByOrganizationQuotas(@Param("id")Integer id);
}