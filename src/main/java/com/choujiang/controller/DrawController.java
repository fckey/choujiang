package com.choujiang.controller;

import com.choujiang.domain.DrawRecord;
import com.choujiang.req.DrawQueryReq;
import com.choujiang.req.DrawRecordReq;
import com.choujiang.req.DrawSaveReq;
import com.choujiang.resp.CommonResp;
import com.choujiang.resp.DrawQueryResp;
import com.choujiang.resp.PageResp;
import com.choujiang.service.DrawService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawController
 * @Description 抽签活动管理
 * @createTime 2022/06/14 13:40
 **/
@RestController
@RequestMapping("/draw")
public class DrawController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Resource
    private DrawService drawService;
    /**
      * @author: fangshaolei
      * @description: 不能修改配额
      * @Date: 2022/6/14 16:06
      * @params: 
      * @return: 
      **/
    @PostMapping("/save")
    public CommonResp save(DrawSaveReq req){
        CommonResp resp = new CommonResp();
        drawService.save(req);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 返回活动列表
      * @Date: 2022/6/14 16:47
      * @params:
      * @return:
      **/
    @GetMapping("/list")
    public CommonResp list(DrawQueryReq req){
        CommonResp<PageResp<DrawQueryResp>> resp = new CommonResp<>();
        PageResp<DrawQueryResp> list = drawService.list(req);
        // 设置内容
        resp.setContent(list);
        // 直接返回
        if(list == null) resp.setMessage("列表为空");
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 用户抽取的时候，抽取的单一的签， drawId表示参加的是哪一次活动,
     * 表示生成或者是取消签或者是确认签
      * @Date: 2022/6/14 16:47
      * @params:
      * @return:
      **/

    @GetMapping("/randomDraw")
    public CommonResp randomSingletonDrawGenerator(DrawRecordReq req){
        CommonResp resp = new CommonResp();
        // 生成一个单一的随机签
        DrawRecord drawRecord = drawService.randomSingletonDrawGenerator(req);
        return resp;
    }
}
