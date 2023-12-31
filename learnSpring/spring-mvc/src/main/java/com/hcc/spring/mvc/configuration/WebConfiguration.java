package com.hcc.spring.mvc.configuration;

import com.hcc.spring.mvc.interceptor.MyInterceptor1;
import com.hcc.spring.mvc.interceptor.MyInterceptor2;
import com.hcc.spring.mvc.interceptor.MyInterceptor3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public MyInterceptor3 myInterceptor3() {
        return new MyInterceptor3();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1())
                .addPathPatterns("/account/queryAccountV2");
        registry.addInterceptor(new MyInterceptor2())
                .addPathPatterns("/account/queryAccountV2");
        registry.addInterceptor(myInterceptor3())
                .addPathPatterns("/account/queryAccountV2");
    }
}
