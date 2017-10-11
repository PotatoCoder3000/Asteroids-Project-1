package com.mycompany.myapp;

public abstract class FixedObj extends GameObjects{
	
	//create fixed object
	public FixedObj(){
		super();
	}
	
	//create fixed object with fixed location, color and blinkrate
	public FixedObj(Location location, int color){
		super(location, color);
	}
	
	//fixed object can NOT move
	public void move(){
		
	}
}
