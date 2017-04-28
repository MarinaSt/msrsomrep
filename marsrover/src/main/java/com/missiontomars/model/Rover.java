package com.missiontomars.model;

public class Rover {

	private int roverID;
	private int startPositionX;
	private int startPositionY;
	private String startDirection;


	private String exploreInstructions;

	private int finalPositionX;
	
	public Rover() {
		// TODO Auto-generated constructor stub
	}
	public Rover( int startPositionX, int startPositionY, String startDirection, String exploreInstructions) {
		this.startPositionX = startPositionX;
		this.startPositionY = startPositionY;
		this.startDirection = startDirection;
		this.exploreInstructions = exploreInstructions;
	}
	public Rover(int roverID, int startPositionX, int startPositionY, String startDirection, String exploreInstructions,
			int finalPositionX, int finalPositionY, char finalDirection) {
		this.roverID = roverID;
		this.startPositionX = startPositionX;
		this.startPositionY = startPositionY;
		this.startDirection = startDirection;
		this.exploreInstructions = exploreInstructions;
		this.finalPositionX = finalPositionX;
		this.finalPositionY = finalPositionY;
		this.finalDirection = finalDirection;
	}


	private int finalPositionY;
	private char finalDirection;



	public int getRoverID() {
		return roverID;
	}



	public void setRoverID(int roverID) {
		this.roverID = roverID;
	}



	public int getStartPositionX() {
		return startPositionX;
	}



	public void setStartPositionX(int startPositionX) {
		this.startPositionX = startPositionX;
	}



	public int getStartPositionY() {
		return startPositionY;
	}



	public void setStartPositionY(int startPositionY) {
		this.startPositionY = startPositionY;
	}



	public String getStartDirection() {
		return startDirection;
	}



	public void setStartDirection(String startDirection) {
		this.startDirection = startDirection;
	}



	public String getExploreInstructions() {
		return exploreInstructions;
	}



	public void setExploreInstructions(String exploreInstructions) {
		this.exploreInstructions = exploreInstructions;
	}



	public int getFinalPositionX() {
		return finalPositionX;
	}



	public void setFinalPositionX(int finalPositionX) {
		this.finalPositionX = finalPositionX;
	}



	public int getFinalPositionY() {
		return finalPositionY;
	}



	public void setFinalPositionY(int finalPositionY) {
		this.finalPositionY = finalPositionY;
	}



	public char getFinalDirection() {
		return finalDirection;
	}



	public void setFinalDirection(char finalDirection) {
		this.finalDirection = finalDirection;
	}



	@Override
	public String toString() {
		return "[ID="+ roverID + "|"+ startPositionX + "," + startPositionY + " " + startDirection + " " + exploreInstructions +"]";
	}
}
