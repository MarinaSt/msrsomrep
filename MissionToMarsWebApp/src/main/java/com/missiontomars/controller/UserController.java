package com.missiontomars.controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.missiontomars.model.User;
import com.missiontomars.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService us;
	
	@RequestMapping("/all")
	public Hashtable<String, User> getA(){
		return us.getAllUser();
	}
	
	@RequestMapping("{id}")
	public User getUser(@PathVariable("id") int id){
		return us.getUser(id);
		}
}
