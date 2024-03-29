package com.baidu.intercepetor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class ActiveIntercepetor extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepetor()).addPathPatterns("/**").
                excludePathPatterns("/login","/","/css/**","/jquery/**");


    }
}
