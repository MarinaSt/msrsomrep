package com.missiontomars.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class WebdemoApplication {

	
	@ResponseBody
	@RequestMapping("/user")
	public String userAuth(){
		return "User";
	}
	public static void main(String[] args) {
		SpringApplication.run(WebdemoApplication.class, args);
	}
}
