package com.baidu.intercepeter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class ActiveIntercepeter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepeter()).addPathPatterns("/**")
                .excludePathPatterns("/login","/","/jquery/**","/css/**");
    }
}
