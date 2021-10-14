package au.edu.sydney.web.config;

import au.edu.sydney.web.handler.RedisSessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Chris
 * @date 2021-10-13 16:28
 * @description
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    RedisSessionInterceptor redisSessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(redisSessionInterceptor).addPathPatterns("/myaccount/**").addPathPatterns("/myaccount").addPathPatterns("/orderAdd").addPathPatterns("/orderAdd/**");
//        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
