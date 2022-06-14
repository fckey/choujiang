package com.choujiang.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.choujiang.mapper.UserMapper;
import com.choujiang.resp.CommonResp;
import com.choujiang.resp.UserLoginResp;
import com.choujiang.util.LoginUserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName ActionInterceptor
 * @Description
 * @createTime 2022/06/14 14:20
 **/
@Component
public class ActionInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(ActionInterceptor.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // OPTIONS请求不做校验,
        // 前后端分离的架构, 前端会发一个OPTIONS请求先做预检, 对预检请求不做校验
        if("OPTIONS".equals(request.getMethod().toUpperCase())){
            return true;
        }

        UserLoginResp userLoginResp = LoginUserContext.getUser();
        Integer userId = userLoginResp.getUserId();
        Integer userRole = userMapper.selectByPrimaryKey(userId).getUserRole();
        // 代表管理员
        if(userRole == 0){
            return true;
        }
        LOG.info("操作被拦截");
        response.setStatus(HttpStatus.OK.value());
        CommonResp commonResp = new CommonResp();
        commonResp.setSuccess(false);
        commonResp.setMessage("操作被拦截为非管理员用户");
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSONObject.toJSON(commonResp));
        return false;
    }
}
