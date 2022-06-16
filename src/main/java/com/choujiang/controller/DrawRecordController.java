package com.choujiang.controller;

import com.choujiang.domain.DrawRecord;
import com.choujiang.req.DrawRecordQueryReq;
import com.choujiang.req.DrawRecordReq;
import com.choujiang.resp.CommonResp;
import com.choujiang.resp.DrawRecordQueryResp;
import com.choujiang.resp.PageResp;
import com.choujiang.service.DrawRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawRecordController
 * @Description 对于签的所有controller业务
 * @createTime 2022/06/15 14:38
 **/
@RestController
@RequestMapping("/record")
public class DrawRecordController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Resource
    private DrawRecordService drawRecordService;
    /**
      * @author: fangshaolei
      * @description: 随机的抽取一个签，抽签的核心接口
      * @Date: 2022/6/15 14:40
      * @params: 
      * @return: 
      **/
    @GetMapping("/randomDraw")
    public CommonResp randomSingletonDrawGenerator(DrawRecordReq req){
        CommonResp resp = new CommonResp();
        // 生成一个单一的随机签
        DrawRecord drawRecord = drawRecordService.randomSingletonDrawGenerator(req);
        resp.setContent(drawRecord);
        if(drawRecord == null) resp.setMessage("没有获取到签");
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 展示用户所抽的签,如果是管理员展示所有,如果不是管理员就会展示当前用户下的所有签。但是活动的id是必须的。
      * @Date: 2022/6/15 14:44
      * @params:
      * @return:
      **/
    @GetMapping("/list")
    public CommonResp list(@Valid DrawRecordQueryReq req){
        CommonResp resp = new CommonResp();
        // 带有分页条件
        PageResp<DrawRecordQueryResp> list = drawRecordService.list(req);
        resp.setContent(list);
        return resp;
    }

    /**
      * @author: fangshaolei
      * @description: 重置签的状态，带上签的id
      * @Date: 2022/6/16 8:33
      * @params:
      * @return:
      **/
    @GetMapping("/reset")
    public CommonResp resetDrawRecord(DrawRecordReq req) {
        CommonResp resp = new CommonResp();
        drawRecordService.resetDrawRecord(req);
        return resp;
    }


}
