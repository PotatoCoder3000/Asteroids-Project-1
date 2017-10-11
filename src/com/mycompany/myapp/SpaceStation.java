package com.mycompany.myapp;


public class SpaceStation extends FixedObj{
	private int blinkrate;
	
	public SpaceStation(){
		super();
		blinkrate = r.nextInt(9);
		
	}
	
	public SpaceStation(Location location, int color){
		super(location, color);
		blinkrate = r.nextInt(9);
	}
	
	public void setRate(int blinkrate){
		this.blinkrate = blinkrate;
	}
	
	public int getRate(){
		return blinkrate;
	}
	
	public String toString(){
		return "Station: " + super.toString() + " Rate: " + getRate();
	}

}
