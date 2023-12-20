package com.registry.Micro1ServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Micro1ServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Micro1ServiceRegistryApplication.class, args);
	}

}
