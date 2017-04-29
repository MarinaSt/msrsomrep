package com.missiontomars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableAutoConfiguration
@ComponentScan	
@Controller	
public class MissionToMarsWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionToMarsWebAppApplication.class, args);
	}
	
	@ResponseBody
	@RequestMapping("/")
	String entry(){
		return "home";
	}
}
