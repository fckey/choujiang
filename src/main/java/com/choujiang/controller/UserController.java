package com.choujiang.controller;

import com.choujiang.req.UserLoginReq;
import com.choujiang.req.UserQueryReq;
import com.choujiang.req.UserResetPasswordReq;
import com.choujiang.req.UserSaveReq;
import com.choujiang.resp.CommonResp;
import com.choujiang.resp.PageResp;
import com.choujiang.resp.UserLoginResp;
import com.choujiang.resp.UserQueryResp;
import com.choujiang.service.UserService;
import com.choujiang.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserController
 * @Description
 * @createTime 2022/06/14 9:27
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @Resource
    private SnowFlake snowFlake;

    /**
      * @author: fangshaolei
      * @description: 保存
      * @Date: 2022/6/14 9:55
      * @params: 
      * @return: 
      **/
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody UserSaveReq req){
        // 增加密码的校验
        req.setUserPwd(DigestUtils.md5DigestAsHex(req.getUserPwd().getBytes()));
        CommonResp r = new CommonResp();
        userService.save(req);
        return r;
    }
    /**
      * @author: fangshaolei
      * @description: 列表
      * @Date: 2022/6/14 10:55
      * @params: 
      * @return: 
      **/
    @GetMapping("/list")
    public CommonResp list(@Valid UserQueryReq req){
        CommonResp<PageResp<UserQueryResp>> resp = new CommonResp<>();
        PageResp<UserQueryResp> list = userService.list(req);
        resp.setContent(list);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 登录
      * @Date: 2022/6/14 10:56
      * @params: 
      * @return: 
      **/
    @PostMapping("/login")
    public CommonResp login(@Valid @RequestBody UserLoginReq req, HttpSession session){
        req.setUserPwd(DigestUtils.md5DigestAsHex(req.getUserPwd().getBytes()));
        CommonResp<UserLoginResp> resp = new CommonResp<>();
        UserLoginResp userLoginResp = userService.login(req);
        // 放入session中
        String token = String.valueOf(snowFlake.nextId());
        LOG.info("生成登录token{}", token);
//
        userLoginResp.setToken(token);
        // 把userloginresp放入到session中
        session.setAttribute(token, userLoginResp);
        session.setMaxInactiveInterval(60*30);
        resp.setContent(userLoginResp);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 退出登录
      * @Date: 2022/6/14 12:51
      * @params:
      * @return:
      **/
    @GetMapping("/logout/{token}")
    public CommonResp logout(@PathVariable String token, HttpSession session) {
        CommonResp resp = new CommonResp<>();
        session.removeAttribute(token);
        LOG.info("从session中删除token: {}", token);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 重置密码
      * @Date: 2022/6/14 12:51
      * @params:
      * @return: 
      **/
    @PostMapping("/reset-password")
    public CommonResp resetPassword(@Valid @RequestBody UserResetPasswordReq req) {
        req.setUserPwd(DigestUtils.md5DigestAsHex(req.getUserPwd().getBytes()));
        CommonResp resp = new CommonResp<>();
        userService.resetPassword(req);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description:
      * @Date: 2022/6/14 12:51
      * @params: 删除
      * @return:
      **/
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Integer id) {
        CommonResp resp = new CommonResp<>();
        userService.delete(id);
        return resp;
    }
}
