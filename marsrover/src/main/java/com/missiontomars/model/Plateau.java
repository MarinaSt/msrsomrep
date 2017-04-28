package com.missiontomars.model;

public class Plateau {

	private int urX;
	private int urY;
	
	private int llX = 0;
	private int llY = 0;
	
	private static Plateau plateauInstance;
	
	/**
	 * singleton
	 */
	private Plateau() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static Plateau getInstance() {
		if(Plateau.plateauInstance == null) {
			Plateau.plateauInstance = new Plateau();
		}
		return Plateau.getInstance();
	}
}
