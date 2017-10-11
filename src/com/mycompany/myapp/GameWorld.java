package com.mycompany.myapp;

import java.util.*;
import java.util.Iterator;
//import java.util.Collection;

import com.codename1.charts.util.ColorUtil;

public class GameWorld {
	//GameObjectCollections Objects = new GameObjectCollections();
	Random r = new Random();
	
	private int lives, clock, score;
	private Location shipPoint = new Location(512,384);
	private Location asteroidPoint;
	private Location basePoint;
	private Ship ship;
	private Vector<GameObjects> Objects = new Vector<GameObjects>();
	
	public void init() {
		score = 0;
		clock = 0;
		lives = 3;
		
	}
	
	public void newAsteroid(){
		asteroidPoint = new Location(r.nextInt(1024),r.nextInt(768));
		Objects.add(new Asteroids(asteroidPoint, ColorUtil.rgb(255, 0, 0), r.nextInt(10), r.nextInt(359)));
	}
	
	public void newStation(){
		basePoint = new Location(r.nextInt(1024),r.nextInt(768));
		Objects.add(new SpaceStation(basePoint, ColorUtil.rgb(0, 0, 255)));
	}
	
	public void newShip(){
		ship = new Ship(shipPoint, ColorUtil.rgb(0, 255, 0), 0, 0);
		Objects.add(ship);
	}
	
	public void shipAccelerate(){
		ship.accelerate();
	}
	
	public void shipDecelerate(){
		ship.decelerate();
	}
	
	public void shipLeft(){
		ship.steerLeft();
	}
	
	public void shipRight(){
		ship.steerRight();
	}
	
	public void fire(){
		for(int i =0; i < Objects.size(); i++){
			if(Objects.elementAt(i) instanceof Ship){
				if(ship.getMissles() > 0){
					ship.fireMissle();
					System.out.println("Ship has fired a missle");
					Objects.add(new Missles(ship.getLocation(), ColorUtil.rgb(0, 255, 0), ship.getSpeed(), ship.getDirection()));
				} else {
					System.out.println("Ship is out of missles");
				}
			}
		}
	}
	
	public void jump(){
		ship.shipJump();
	}
	
	public void refill(){
		ship.refillMissles();
	}
	
	public void kill(){
		for(int i =0; i <Objects.size(); i++){
			if(Objects.elementAt(i) instanceof Asteroids){
				ship.fireMissle();
				Objects.removeElementAt(i);
				break;
			}
		}
	}
	
	public void collide(){
		for(int i =0; i < Objects.size(); i++){
			if(Objects.elementAt(i) instanceof Asteroids){
				Objects.removeElementAt(i);
			}
		}		
	}
	
	public void crash(){
		for (int i = 0; i < Objects.size(); i++) {
			if (Objects.elementAt(i) instanceof MovableObj) {
				if (Objects.elementAt(i) instanceof Ship) {
					Objects.removeElementAt(i);
					loseLife();
				}
				
				if (Objects.elementAt(i) instanceof Asteroids) {
					Objects.removeElementAt(i);
				}
			}
		}
	}
	
	public void tick() {
		System.out.println("Time:" + this.clock);
		clock++;
		System.out.println("Elapsed time:" + this.clock);
		for (int i = 0; i < Objects.size(); i++) {

			if (Objects.elementAt(i) instanceof Ship) {
				Ship ship = (Ship) Objects.elementAt(i);
				ship.move();
				System.out.println("The ship has moved. " + ship.toString());
			}

			if (Objects.elementAt(i) instanceof Asteroids) {
				Asteroids asteroid = (Asteroids) Objects.elementAt(i);
				asteroid.move();
				System.out.println("The asteroid has moved. " + asteroid.toString());

			}

			if (Objects.elementAt(i) instanceof Missles) {
				Missles missle = (Missles) Objects.elementAt(i);
				if (missle.getFuel() > 0) {
					missle.move();
					System.out.println("The missile has moved. " + missle.toString());
				}
				if (missle.getFuel() == 0)
					System.out.println("Missile ran out of fuel. " + missle.toString());
				Objects.removeElementAt(i);
			}
		}
	}
	
	public void printGameState(){
		int missleCount = 0;
		for (int i = 0; i < Objects.size(); i++) {
			if (Objects.elementAt(i) instanceof Ship) {
				Ship ship = (Ship) Objects.elementAt(i);
				missleCount = ship.getMissles();

			}
		}
		System.out.println("Score: " + this.score + " Time: " + this.clock + ": " + missleCount);
	}
	
	public String printTextMap(){
		
		Iterator<GameObjects> iterator = Objects.iterator();
		String map = "";
		String newLine = "\n";
		while (iterator.hasNext()) {
			GameObjects item = iterator.next();
			map = map + item.toString() +newLine;
		}
		return map;
	}
	
	public void loseLife(){
		if (lives == 0){
			System.out.println("You are out of lives");
			System.exit(0);
		}
		lives--;
	}
}
