package com.missiontomars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.missiontomars.controller", "com.missiontomars.service"})
public class MissionToMarsWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionToMarsWebAppApplication.class, args);
	}
	
}
