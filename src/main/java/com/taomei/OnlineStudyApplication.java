package com.taomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OnlineStudyApplication {
	public static void main(String[] args) {
        SpringApplication.run(OnlineStudyApplication.class, args);
	}
}
