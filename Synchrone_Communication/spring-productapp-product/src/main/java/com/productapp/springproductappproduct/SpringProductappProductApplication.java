package com.productapp.springproductappproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringProductappProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappProductApplication.class, args);
	}
}
