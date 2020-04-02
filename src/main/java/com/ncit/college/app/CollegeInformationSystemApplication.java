package com.ncit.college.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ncit.college")
@EnableAutoConfiguration
public class CollegeInformationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeInformationSystemApplication.class, args);
	}
}
