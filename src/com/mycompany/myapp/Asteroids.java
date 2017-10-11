package com.mycompany.myapp;


public class Asteroids extends MovableObj {
	private int size;
	
	public Asteroids() {
		super();
		this.size = 10+r.nextInt(20);
	} 
	
	public Asteroids(Location location, int color, int speed, int direction){
		super(location, color, speed, direction);
		this.size = 10 + r.nextInt(20);
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		return "Asteroid: " + super.toString() + " Size: " + getSize();
	}

}
