package com.missiontomars.service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.missiontomars.model.User;

@Service
public class UserService {
	Hashtable<String, User> users = new Hashtable<String, User>();

	public UserService() {
		User u = new User();
		u.setId(0);
		u.setEmail("mst@t.com");
		u.setName("me");
		u.setPassword("w3");
	}
	
	public User getUser(int id){
		return users.get(id);
	}
	
	public Hashtable<String, User> getAllUser(){
		return users;
	}
}
