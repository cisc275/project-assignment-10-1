package mainpkg;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FroggerView extends View {
	public boolean isTutorial = false;

	
	public FroggerView(){
		super();
		for(int i=0; i<10; i++){
			playerRight[i] = createImage("GamePictures/PlayerAnimation/NHSideLeft/Frame"+Integer.toString(i)+".png"); //Loads animation frames for the player facing left
			playerLeft[i] = createImage("GamePictures/PlayerAnimation/NHSideRight/Frame"+Integer.toString(i)+".png"); //Loads the animation frames for the player facing right
		}
		arrowKeys = createImage("GamePictures/TutorialPics/arrowkeys.png");
		if(isOsprey){
			Background = createImage("GamePictures/Backgrounds/Frogger/OspreyBackground.jpg"); //Loads the osprey frogger background
			planeLeft = createImage("GamePictures/Obstacles/AirplaneLeft.png"); //Loads the image for the airplane moving to the left
			planeRight = createImage("GamePictures/Obstacles/AirplaneRight.png"); //Loads the image for the airplane moving to the right
			mountain = createImage("GamePictures/Obstacles/Mountain.png"); //Loads the image for the mountain
			
		}
		else{
			Background = createImage("GamePictures/Backgrounds/Frogger/NHBackground.png"); //Loads the northern harrier frogger background image
			drone = createImage("GamePictures/Obstacles/Drone.png"); //Loads the image of the drone
			//crowLeft = createImage("GamePictures/Obstacles/CrowLeft.png"); //Loads the image of a crow facing to the left
			//crowRight = createImage("GamePictures/Obstacles/CrowRight.png");//Loads the image of a crow facing to the right
			for(int i=0; i<10; i++){
				foxRight[i] = createImage("GamePictures/Obstacles/FoxRightPNG/Frame"+Integer.toString(i)+".png");
				foxLeft[i] = createImage("GamePictures/Obstacles/FoxLeftPNG/Frame"+Integer.toString(i)+".png");
			}
		}
	}
	
	public void startFrogger(Player player, ArrayList<Obstacle> obstacles) { //Creates a composite arraylist of all game objects
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(player);
		for(Obstacle o : obstacles) {
			gameObjects.add(o);
		}
	}
	public void paint(Graphics g){
		picNum=(picNum+1)%10; //Cycles through the frame numbers
		checkDirect();
		g.drawImage(Background, 0, 0, frameWidth, frameHeight, this); //Draws the background on the bottom layer
		if (isTutorial) {
			g.setFont(new Font("Times New Roman", Font.BOLD, 26));
			g.drawImage(arrowKeys, frameWidth*88/100, frameHeight*2/100, frameWidth*1/10, frameHeight*1/10, this);
			g.drawString("Arrow Keys to move.", frameWidth*86/100,frameHeight*15/100);
			g.drawString("Get to the top!", frameWidth*86/100, frameHeight*17/100);
		}
		if (!gameObjects.isEmpty()) { //Makes sure there are objects in the game
			for (GameObject o : gameObjects) {
				if(o instanceof Player){
					if(isRight){
						g.drawImage(playerRight[picNum],o.xloc,o.yloc,o.width,o.height,this); //Cycles through the player animation frames and draws them
					}
					else{
						g.drawImage(playerLeft[picNum],o.xloc,o.yloc,o.width,o.height,this); //Cycles through the player animation frames and draws them
					}
					
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
						if(o.xvel<0){
							g.drawImage(foxLeft[picNum],o.xloc,o.yloc,o.width,o.height,this);
						}
						else if(o.xvel>0){
							g.drawImage(foxRight[picNum],o.xloc,o.yloc,o.width,o.height,this);
						}
						else{
							g.drawImage(drone,o.xloc,o.yloc,o.width, o.height, this); //If it is a Northern Harrier, draw all stationary obstacles as drones
						}
						
					}
				}
				
			}
		}
		if(!isTutorial) {
			g.setFont(new Font("Times New Roman", Font.BOLD, 48));
			g.drawString("Score: " + Model.player.getPoints(), frameWidth-(frameWidth*16/100), frameHeight*7/100);
		}
	}
}
