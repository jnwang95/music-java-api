package com.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MusicJavaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicJavaApiApplication.class, args);
    }

}
