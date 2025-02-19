package com.ikoyski.webtools.iplocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCaching
@EnableDiscoveryClient
public class WebtoolsIpLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtoolsIpLocationApplication.class, args);
	}

}
