package com.choujiang.controller;

import com.choujiang.domain.Organization;
import com.choujiang.req.OrganizationQueryReq;
import com.choujiang.req.OrganizationSaveReq;
import com.choujiang.resp.CommonResp;
import com.choujiang.resp.PageResp;
import com.choujiang.service.OrganizationService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName OrganizationController
 * @Description
 * @createTime 2022/06/14 13:05
 **/
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Resource
    private OrganizationService organizationService;
    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/14 13:21
      * @params: 
      * @return: 
      **/
    @GetMapping("/list")
    public CommonResp list(@Valid OrganizationQueryReq req){
        CommonResp<PageResp<Organization>> resp = new CommonResp<>();
        PageResp<Organization> list = organizationService.list(req);
        resp.setContent(list);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/14 13:21
      * @params: 
      * @return: 
      **/
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Integer id){
        CommonResp resp = new CommonResp<>();
        organizationService.delete(id);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 保存和修改
      * @Date: 2022/6/14 13:21
      * @params: 
      * @return: 
      **/
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody OrganizationSaveReq req){
        CommonResp resp = new CommonResp<>();
        organizationService.save(req);
        return resp;
    }

}
