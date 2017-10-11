package com.mycompany.myapp;

public class Missles extends MovableObj {
	private int fuel;
	
	public Missles(Location location, int color, int speed, int direction){
		super(location, color, speed, direction);
		fuel = 10;
	}
	
	public void setFuel(int fuel){
		this.fuel = fuel;
	}
	
	public int getFuel() {
		return fuel;
	}
	
	public String toString() {
		return "Missles: " + super.toString() + " Fuel " + getFuel();
	}
}
