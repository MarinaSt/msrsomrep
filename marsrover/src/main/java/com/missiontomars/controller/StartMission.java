package com.missiontomars.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.namedparam.ParsedSql;

import com.missiontomars.model.Rover;
import com.missiontomars.model.RoverDAO;
import com.missiontomars.model.User;
import com.missiontomars.model.UsersDAO;

public class StartMission {
	private static ApplicationContext context;
	private static HashMap<String, Rover> rovers;

	private static String startPositions;
	private static String sequence;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		context = new ClassPathXmlApplicationContext("com/missiontomars/beans/jdbcbeans.xml");
		initialize();
//		deployRovers();
		// showResult();
		((ClassPathXmlApplicationContext) context).close();
	}

	private static void initialize() {
		

		System.out.println("Hello!");
		readInput();
		
		String[]pos = startPositions.split(" ");
		
		int x = Integer.parseInt(pos[0]);
		int y = Integer.parseInt(pos[1]);
		
		createNewRover(x, y, pos[2], sequence);
		/*
		 * default settings for two Rovers via beans Rover r1 = (Rover)
		 *
		 * context.getBean("rover1"); Rover r2 = (Rover)
		 * context.getBean("rover2");
		 * 
		 * rovers = new HashMap<String, Rover>(); rovers.put("rover1", r1);
		 * rovers.put("rover2", r2);
		 */

	}

	private void storeInDB() {

	}

	private static void deployRovers() {
		// Set rovers to plateau
		// call check method to verify positions on plateau
		Iterator it = rovers.entrySet().iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
			it.remove();
		}

	}

	private void moveRovers() {

	}

	private static void showResult() {
		context = new ClassPathXmlApplicationContext("com/missiontomars/beans/jdbcbeans.xml");
		// read from DB
		UsersDAO usersDao = (UsersDAO) context.getBean("usersDAO");

		// returns list of users
		List<User> users = usersDao.getUsers();

		for (User user : users) {
			System.out.println(user);
		}
		((ClassPathXmlApplicationContext) context).close();
	}


	private static void readInput() {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("please enter coordinates and rover-sequence:");
		// 1 3 N
		startPositions = reader.nextLine();
		
		// LMLMMMLMMM
		sequence = reader.nextLine();
		
	}
	
	
	private static void createNewRover(int x, int y, String direction, String sequence){
		try {
			RoverDAO roverDao = (RoverDAO) context.getBean("roverDAO");

			Rover newRover = new Rover(x, y, direction, sequence);

			// roverDao.delete(4);
			if (roverDao.create(newRover)) {
				System.out.println("Created new Rover");
			}

			// returns list of users
			List<Rover> rovers = roverDao.getRovers();

			for (Rover rover : rovers) {
				System.out.println(rover);
			}


		} catch (CannotGetJdbcConnectionException jdbcex) {
			System.out.println("Cannot get database connection. Please check jdbc.properties");
		} catch (DataAccessException daex) {
			System.out.println(daex.getMessage() + "\n" + daex.getClass());
		}

	}
}
