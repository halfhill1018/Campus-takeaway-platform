package com.graduation.campustakeawayplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@AutoConfiguration
@EnableCaching
public class CampusTakeawayPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusTakeawayPlatformApplication.class, args);
    }

}
