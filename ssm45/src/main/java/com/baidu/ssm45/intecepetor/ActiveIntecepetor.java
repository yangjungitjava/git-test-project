package com.baidu.ssm45.intecepetor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class ActiveIntecepetor extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntecepetor()).addPathPatterns("/**").
                excludePathPatterns("/login","/","/css/**","/jquery/**");
    }
}
