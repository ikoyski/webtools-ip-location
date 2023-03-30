package com.ikoyski.webtoolsiplocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WebtoolsIpLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtoolsIpLocationApplication.class, args);
	}

}
