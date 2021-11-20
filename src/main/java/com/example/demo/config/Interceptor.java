package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author :LiXiangJie
 * @description : TODO
 * @date :2021/11/20 21:58
 */
@Configuration
public class Interceptor implements WebMvcConfigurer {

    @Bean
    LoginAuthInterceptor loginAuthInterceptor() {
        return new LoginAuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，排除登录url
        registry.addInterceptor(loginAuthInterceptor())
                .excludePathPatterns("/user/login");
    }
}