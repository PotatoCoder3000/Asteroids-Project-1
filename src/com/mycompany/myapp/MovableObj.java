package com.mycompany.myapp;


public abstract class MovableObj extends GameObjects{
	
	private int direction;
	private int speed;

	
	public MovableObj(){
		super();
		direction = (r.nextInt(359));
		speed = (r.nextInt(10));
	}
	
	public MovableObj(Location location, int color,  int speed, int direction) {
		super(location, color);
		this.direction = direction;
		this.speed = speed;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void move(){
		int angle = 90 - direction;
		float dX = (((float)Math.cos( Math.toRadians(angle))) * (float)speed);
		float dY = (((float)Math.sin( Math.toRadians(angle))) * (float)speed);
		move(dX, dY); 
	}
	
	public String toString(){	
		return super.toString() + " Speed= " + getSpeed() +" Direction= " + getDirection();
		}
}
