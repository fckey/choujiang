package com.choujiang.interceptor;

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
import javax.servlet.http.HttpSession;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName LoginInterceptor
 * @Description
 * @createTime 2022/06/14 11:06
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);
    @Resource
    private HttpSession httpSession;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("------------- LoginInterceptor 开始 -------------"); // OPTIONS请求不做校验,
        // 前后端分离的架构, 前端会发一个OPTIONS请求先做预检, 对预检请求不做校验
        if(request.getMethod().toUpperCase().equals("OPTIONS")){
            return true;
        }
        //获取header的token参数
        String token = request.getHeader("token");
        LOG.info("登录校验开始，token：{}", token);
        if (token == null || token.isEmpty()) {
            LOG.info( "token为空，请求被拦截" );
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        UserLoginResp userLoginResp = (UserLoginResp) httpSession.getAttribute(token);
        LOG.info("httpsession,{}", httpSession);
        if(userLoginResp == null){
            LOG.warn( "token无效，请求被拦截" );
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }else{
            LOG.info("已登录：{}", userLoginResp);
            LoginUserContext.setUser(userLoginResp);
            return true;
        }



    }
}
