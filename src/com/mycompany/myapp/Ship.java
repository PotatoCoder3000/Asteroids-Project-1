package com.mycompany.myapp;


public class Ship extends MovableObj implements ISteerable {
	private int missles;
	private int direction;
	private Location shipPoint = new Location(512,384);
	
	public Ship(){
		super();
	}
	
	public Ship(Location location, int color, int speed, int direction){
		super(location, color, speed, direction);
		missles = 10;
		
	}
	
	public void setSpeed(int speed){
		super.setSpeed(speed);
	}
	
	public void accelerate(){
		setSpeed(getSpeed() + 2);
	}
	
	public void decelerate() {
		if (getSpeed() > 2)
			setSpeed(getSpeed() - 2);
		else if (getSpeed() <= 2)
			setSpeed(0);
	}
	
	//set missles
	public void setMissles(int missles) {
		this.missles = missles;
	}
	
	//get missles
	public int getMissles() {
		return missles;
	}
	
	public void fireMissle() {
		setMissles(getMissles() - 1);
		//Objects.add(new Missles(location, ColorUtil.rgb(0, 255, 0), speed + 2, r.nextInt(359)));
	}
	
	//steer left
	public void steerLeft(){
		if(getDirection() > 5 )
			setDirection(getDirection() - 5);
		}
	
	//steer right
	public void steerRight(){
		if( direction < 360 )
			setDirection(getDirection() + 5);
	}
	
	public void shipJump(){
		setLocation(shipPoint);
	}
	
	public void refillMissles(){
		setMissles(10);
	}
	
	//toString
	public String toString(){
		return "Ship: " + super.toString() + " Missles= " + getMissles();
	}

}
