package com.mycompany.myapp;
//Created by Chris Dong
//Pointer Class for location
public class Location{ 
	private float X;
	private float Y;
	
	//Create Point
	public Location(float X, float Y){
		this.X = X;
		this.Y = Y;
	}
	
	//get X 
	public float getX(){
		return X;
	}
	
	//set X
	public void setX(float X){
		this.X = X;
	}
	
	//get Y
	public float getY(){
		return Y;
	}

	//set Y
	public void setY(float Y){
		this.Y = Y;
	}
	
	//set location
	public void setLocation(float X, float Y){
		setX(X);
		setY(Y);
	}
}