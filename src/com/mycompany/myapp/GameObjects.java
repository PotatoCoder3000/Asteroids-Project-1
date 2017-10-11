package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;
import java.util.Random;
//Created by Chris Dong
public abstract class GameObjects extends GameWorld{
	static Random r = new Random();
	private int size;
	private int blinkrate;
	private int missles;
	private Location location;
	private int color;
	
	//create GameObjects with Random location, color, and size
	public GameObjects(){
		this.location = new Location((float)r.nextInt(1024), (float)r.nextInt(768));
		this.color = ColorUtil.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	//create GameObjects with fixed location, color, and size
	public GameObjects(Location location, int color){
		this.location = location;
		this.color = color;
	}
	
	//return location
	public Location getLocation(){
		return location;
	}
	
	//set location
	public void setLocation(Location newLocation){
		this.location = newLocation;
	}
	
	public int getBlinkrate(){
		return blinkrate;
	}
	
	//get size
	public int getSize(){
		return size;
	}
	
	public int getMissles(){
		return missles;
	}
	
	//return color
	public int getColor(){
		return color;
	}
	
	//set color
	public void setColor(int r, int g, int b){
		this.color = ColorUtil.rgb(r, g, b);
	}
	
	//make object move
	public void move(float X, float Y){
		
		float newX = location.getX() + X;
		float newY = location.getY() + Y;
		
		location.setLocation(newX, newY);
	}
	//toString for every class objects
	public String toString() {
		double X = Math.round(this.getLocation().getX()*10.0)/10.0;
		double Y = Math.round(this.getLocation().getY()*10.0)/10.0;
		String Color = "[" + ColorUtil.red(getColor()) + ","+ ColorUtil.green(getColor()) + ","+ ColorUtil.blue(getColor()) + "]";
	
		return "Location=" +X +"," +Y + " Color: " + Color;
	}
	
	
}
