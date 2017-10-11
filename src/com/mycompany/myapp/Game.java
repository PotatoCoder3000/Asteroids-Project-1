package com.mycompany.myapp;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;
import com.codename1.ui.Form;
import java.util.Iterator;

public class Game extends Form{
	private GameWorld gw;
	
	public Game(){
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	private void play(){
		//create Label and TextField for entering command
		Label myLabel=new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		//final String gameDetails;
		//get commands from textField
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String sCommand=myTextField.getText().toString();
				myTextField.clear();

				
				//cases of commands
				switch (sCommand.charAt(0)) {
					case 'a':
						TextField myTextField2=new TextField("A new asteroid has been created");
						addComponent(myTextField2);
						System.out.println("A new asteroid has been created");
						gw.newAsteroid();
						break;
				
					case 'b':
						TextField myTextField3=new TextField("A new blinking station has been created");
						addComponent(myTextField3);
						System.out.println("A new blinking station has been created");
						gw.newStation();
						break;
						
					case 's':
						TextField myTextField4=new TextField("A new ship has been created");
						addComponent(myTextField4);
						System.out.println("A new ship has been created");
						gw.newShip();
						break;
						
					case 'i':
						TextField myTextField5=new TextField("Your ship has increased its speed");
						addComponent(myTextField5);
						System.out.println("Your ship has increased its speed");
						gw.shipAccelerate();
						break;
						
					case 'd':
						TextField myTextField6=new TextField("Your ship has decreased its speed");
						addComponent(myTextField6);
						System.out.println("Your ship has decreased its speed");
						gw.shipDecelerate();
						break;
						
					case 'l':
						TextField myTextField7=new TextField("Ship is now turning left");
						addComponent(myTextField7);
						System.out.println("Ship is now turning left");
						gw.shipLeft();
						break;
						
					case 'r':
						TextField myTextField8=new TextField("Ship is now turning right");
						addComponent(myTextField8);
						System.out.println("Ship is now turning right");
						gw.shipRight();
						break;
						
					case 'f':
						TextField myTextField21=new TextField("Ship has fired a missle");
						addComponent(myTextField21);
						//System.out.println("Ship has fired a missle");
						gw.fire();
						break;
						
					case 'j':
						TextField myTextField9=new TextField("Ship has jumped through hyperspace");
						addComponent(myTextField9);
						System.out.println("Ship has jumped through hyperspace");
						gw.jump();
						break;
						
					case 'n':
						TextField myTextField10=new TextField("Ship has refilled its missles");
						addComponent(myTextField10);
						System.out.println("Ship has refilled its missles");
						gw.refill();
						break;
						
					case 'k':
						TextField myTextField11=new TextField("Ship has killed an asteroid");
						addComponent(myTextField11);
						System.out.println("Ship has killed an asteroid");
						gw.kill();
						break;
						
					case 'x':
						TextField myTextField13=new TextField("Two asteroids have collided");
						addComponent(myTextField13);
						System.out.println("Two asteroids have collided");
						gw.collide();
						break;
						
						
					case 'c':
						TextField myTextField12=new TextField("Ship has crashed");
						addComponent(myTextField12);
						System.out.println("Ship has crashed");
						gw.crash();
						break;
						
					case 't':
						TextField myTextField14=new TextField("The game clock has ticked");
						addComponent(myTextField14);
						System.out.println("The game clock has ticked");
						gw.tick();
						break;
						
					case 'p':
						Label myTextField15=new Label("Game State=");
						addComponent(myTextField15);
						System.out.println("Game State=");
						gw.printGameState();
						break;
					
					case 'm':
						Label myTextField17=new Label("Map contains=");
						addComponent(myTextField17);
						System.out.println("Map contains=");
						Label myTextField18=new Label(gw.printTextMap());
						addComponent(myTextField18);
						System.out.println(gw.printTextMap());
						break;
						
					case 'q':
						TextField myTextField19=new TextField("Are you sure you want to Quit the game");
						addComponent(myTextField19);
						System.out.println("Are you sure you want to Quit the game?");
						myTextField.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent evt) {
								String sCommand=myTextField.getText().toString();
								myTextField.clear();
								// ask for input 'y' for yes and 'n' for no
								switch (sCommand.charAt(0)){
									case 'y':
										System.exit(0);
										break;
									case 'n':
										break;
								}
							}
						});
						break;
						
					//default case: invalid input
					default:
						TextField myTextField20=new TextField("Invalid command");
						addComponent(myTextField20);
						
				}
			}//add code to handle rest of the commands
		}); //switch
	} //actionPerformed
}
		
		
		
		
		
		
		
		
	

