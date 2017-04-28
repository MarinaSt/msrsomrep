package controller;

import model.Vehicle;

public class MoveIt {
	private Vehicle vehicle;
	
	public void setVehicle(Vehicle v){
		this.vehicle = v;
	}

	public void moveVehicle(){
		this.vehicle.move();
	}
	
	public void turnVehicle(){
		this.vehicle.turn();
	}
}
