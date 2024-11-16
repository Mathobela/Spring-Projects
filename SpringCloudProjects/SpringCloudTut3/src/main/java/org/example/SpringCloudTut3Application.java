package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/*
This is the discovery/eureka client.
It registers itself with eureka, when it is up, it will be displayed on the eureka ui
* */

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudTut3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTut3Application.class, args);
	}

}
