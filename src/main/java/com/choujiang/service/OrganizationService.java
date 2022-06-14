package com.choujiang.service;

import com.choujiang.domain.Organization;
import com.choujiang.domain.OrganizationExample;
import com.choujiang.exception.BusinessException;
import com.choujiang.exception.BusinessExceptionCode;
import com.choujiang.mapper.OrganizationMapper;
import com.choujiang.req.OrganizationQueryReq;
import com.choujiang.req.OrganizationSaveReq;
import com.choujiang.resp.PageResp;
import com.choujiang.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName OrganizationService
 * @Description
 * @createTime 2022/06/14 13:05
 **/
@Service
public class OrganizationService {
    private static final Logger LOG = LoggerFactory.getLogger(OrganizationService.class);
    @Resource
    private OrganizationMapper organizationMapper;

    public PageResp<Organization> list(OrganizationQueryReq req) {
        OrganizationExample organizationExample = new OrganizationExample();
        // 看是否有条件
        OrganizationExample.Criteria criteria = organizationExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getOrgName())){
            criteria.andOrgNameLike(req.getOrgName());
        }
        // 分页逻辑
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Organization> organizations = organizationMapper.selectByExample(organizationExample);
        PageInfo<Organization> pageInfo = new PageInfo<>(organizations);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        // 返回
        PageResp<Organization> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(organizations);
        return pageResp;
    }
    /**
      * @author: fangshaolei
      * @description: 删除
      * @Date: 2022/6/14 13:38
      * @params:
      * @return:
      **/
    public void delete(Integer id) {
        organizationMapper.deleteByPrimaryKey(id);
    }
    /**
      * @author: fangshaolei
      * @description: 保存和更新
      * @Date: 2022/6/14 13:38
      * @params:
      * @return:
      **/
    public void save(OrganizationSaveReq req) {
        Organization organization = CopyUtil.copy(req, Organization.class);
        // 添加
        if (ObjectUtils.isEmpty(req.getOrgCode())) {
            Organization organizationdb = selectByOrgName(req.getOrgName());
            if(ObjectUtils.isEmpty(organizationdb)){
                // 新增
                organizationMapper.insert(organization);
            }else{
                throw new BusinessException(BusinessExceptionCode.ORGANIZATION_NAME_EXIST);
            }
        }else{
            organizationMapper.updateByPrimaryKeySelective(organization);
        }
    }


    public Organization selectByOrgName(String name){
        OrganizationExample organizationExample = new OrganizationExample();
        OrganizationExample.Criteria criteria = organizationExample.createCriteria();
        criteria.andOrgNameEqualTo(name);
        List<Organization> organizations = organizationMapper.selectByExample(organizationExample);
        if(CollectionUtils.isEmpty(organizations)) return null;
        return organizations.get(0);
    }
}
