package mainpkg;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FoodGameView extends View {

	public FoodGameView() {
		super();
		for(int i=0; i<10; i++){
			playerRight[i] = createImage("GamePictures/PlayerAnimation/NHSideRight/Frame"+Integer.toString(i)+".png"); //Loads all of the player images facing right
			playerLeft[i] = createImage("GamePictures/PlayerAnimation/NHSideLeft/Frame"+Integer.toString(i)+".png"); //Loads all of the player images facing left
		}
		if(isOsprey){
			Background = createImage("GamePictures/Backgrounds/FoodAndFlappy/OspreyFoodGame.jpg"); //Loads in the osprey foodgame background
			fishLeft = createImage("GamePictures/Objectives/FishLeft.png"); //Loads the left facing fish image
			fishRight = createImage("GamePictures/Objectives/FishRight.png"); //Loads the right facing fish image
		}
		else{
			Background = createImage("GamePictures/Backgrounds/FoodAndFlappy/NHFoodGame.jpg"); //Loads in the northern harrier background
			mouseLeft = new BufferedImage[10]; 
			mouseRight = new BufferedImage[10];
			for(int j=0;j<5;j++){
				mouseRight[j] = createImage("GamePictures/Objectives/MouseRight/Frame"+Integer.toString(j)+".png"); //Loads in the right facing mouse images
				mouseLeft[j] = createImage("GamePictures/Objectives/MouseLeft/Frame"+Integer.toString(j)+".png"); //Loads in the left facing mouse images
			}
		}
		
		
	}
	public void foodGame(Player player, ArrayList<Objective> objectives){
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(player);
		for(Objective o: objectives){
			gameObjects.add(o);
		}
	}
	public void paint(Graphics g){ //paints the current state of the game
		picNum= (picNum+1) % 10; //Cycles through frames for the player
		picNum2 = (picNum2+1)%5; //Cycles through frames for the mouse objective
		if (!gameObjects.isEmpty()) {
			g.drawImage(Background, 0, 0, frameWidth, frameHeight, this); //Draws the background on the bottom layer
			for (GameObject o : gameObjects) {
				
				if(o instanceof Player){
					g.drawImage(playerRight[picNum],o.xloc,o.yloc,o.width,o.height,this); //Draws the player using the animation frames
				}
				else if(o instanceof Obstacle){
					
				}
				else{
					if(isOsprey){ //Checks to see what bird player is playing as
						if(o.xvel>0){
							g.drawImage(fishRight, o.xloc, o.yloc, o.width, o.height, this); //If the objective is moving right, use the right image for the fish
						}
						else{
							g.drawImage(fishLeft, o.xloc, o.yloc, o.width, o.height, this); //If the objective is moving left, use the right image for the fish
						}
					}
					else{
						if(o.xvel>0){
							g.drawImage(mouseRight[picNum2],o.xloc,o.yloc,o.width,o.height,this); //Draws the objective as a mouse moving right, using the animation frames
						}
						else{
							g.drawImage(mouseLeft[picNum2],o.xloc,o.yloc,o.width,o.height,this); //Draws the objective as a mouse moving to the left using the animation frames
						}
					}
				}
				//g.setColor(o.getColor());
				//g.fillRect(o.xloc, o.yloc, o.width, o.height);
			}
		}
	}
}
