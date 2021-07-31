package com.music.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 全局拦截监控器
 */
@Configuration
@Component
@AllArgsConstructor
public class Monitor extends WebMvcConfigurationSupport {

    private final MusicHandlerInterceptor musicHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(musicHandlerInterceptor).addPathPatterns("/music/**");
    }
    /**
     * 放行static静态文件
     * @param registry 注册器
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resource/","classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
