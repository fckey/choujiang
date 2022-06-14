package com.choujiang.config;

import com.choujiang.interceptor.ActionInterceptor;
import com.choujiang.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName SpringMvcConfig
 * @Description
 * @createTime 2022/06/13 22:38
 **/
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;
    @Resource
    private ActionInterceptor actionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/user/login/**"
//                        "/user/save"
                );

        registry.addInterceptor(actionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login/**");
    }
}
