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

		users.put("0", u);
	}

	
	//TODO: get single user by passind ID, currently doesn´t work, guess cause of id type string / int
	public User getUser(int id) {
		if (users.containsKey(id + "")) {
			System.out.println(users.get(id));
			return users.get(id);
		} else
			return null;
	}

	public Hashtable<String, User> getAllUser() {
		return users;
	}
}
