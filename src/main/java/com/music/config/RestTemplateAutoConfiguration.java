package com.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateAutoConfiguration {

    /**
     * 功能描述：注册restTemplate服务
     */
    @Bean
    public RestTemplate registerTemplate() {
        return new RestTemplate();
    }
}
