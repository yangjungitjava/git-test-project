package com.baidu.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ActiveInterceptor extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截什么路径和放行什么路径
        registry.addInterceptor(new LoginInterceptor()).
                addPathPatterns("/**").excludePathPatterns("/login", "/", "/jquery/**", "/css/**");
    }
}
