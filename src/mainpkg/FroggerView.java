package mainpkg;

import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FroggerView extends View {
	
	
	public FroggerView(){
		super();
		for(int i=0; i<10; i++){
			playerRight[i] = createImage("GamePictures/PlayerAnimation/NHSideLeft/Frame"+Integer.toString(i)+".png"); //Loads animation frames for the player facing left
			playerLeft[i] = createImage("GamePictures/PlayerAnimation/NHSideRight/Frame"+Integer.toString(i)+".png"); //Loads the animation frames for the player facing right
		}
		if(isOsprey){
			Background = createImage("GamePictures/Backgrounds/Frogger/OspreyBackground.jpg"); //Loads the osprey frogger background
			planeLeft = createImage("GamePictures/Obstacles/AirplaneLeft.png"); //Loads the image for the airplane moving to the left
			planeRight = createImage("GamePictures/Obstacles/AirplaneRight.png"); //Loads the image for the airplane moving to the right
			mountain = createImage("GamePictures/Obstacles/Mountain.png"); //Loads the image for the mountain
			
		}
		else{
			Background = createImage("GamePictures/Backgrounds/Frogger/NHBackground.png"); //Loads the northern harrier frogger background image
			drone = createImage("GamePictures/Obstacles/Drone.png"); //Loads the image of the drone
			crowLeft = createImage("GamePictures/Obstacles/CrowLeft.png"); //Loads the image of a crow facing to the left
			crowRight = createImage("GamePictures/Obstacles/CrowRight.png"); //Loads the image of a crow facing to the right
		}
	}
	
	public void startFrogger(Player player, ArrayList<Obstacle> obstacles) {
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(player);
		for(Obstacle o : obstacles) {
			gameObjects.add(o);
		}
	}
	public void paint(Graphics g){
		picNum=(picNum+1)%10; //Cycles through the frame numbers
		g.drawImage(Background, 0, 0, frameWidth, frameHeight, this); //Draws the background on the bottom layer
		if (!gameObjects.isEmpty()) { //Makes sure there are objects in the game
			for (GameObject o : gameObjects) {
				if(o instanceof Player){
					g.drawImage(playerRight[picNum],o.xloc,o.yloc,o.width,o.height,this); //Cycles through the player animation frames and draws them
				}
				else if(o instanceof Obstacle){
					if(isOsprey){ //Checks to see which bird the player is playing as
						if(o.xvel==0){
							g.drawImage(mountain,o.xloc,o.yloc,o.width,o.height,this); //If the obstacle isn't moving draw it as a mountain
						}
						else{
							if(o.xvel<0){ 
								g.drawImage(planeLeft,o.xloc,o.yloc,o.width, o.height,this); //IF obstacle is moving to the left draw it as the proper airplane
							}
							else{
								g.drawImage(planeRight,o.xloc,o.yloc,o.width, o.height,this); //If obstacle is moving to the right, draw it as the proper airplane
							}
						}
					}
					else{
						g.drawImage(drone,o.xloc,o.yloc,o.width, o.height, this); //If it is a Northern Harrier, draw all obstacles as drones
					}
				}
			}
		}
	}
}
