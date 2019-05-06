package mainpkg;

import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FroggerView extends View {
	
	
	public FroggerView(){
		super();
		for(int i=0; i<10; i++){
			playerRight[i] = createImage("GamePictures/PlayerAnimation/NHSideLeft/Frame"+Integer.toString(i)+".png");
			playerLeft[i] = createImage("GamePictures/PlayerAnimation/NHSideRight/Frame"+Integer.toString(i)+".png");
		}
		if(isOsprey){
			Background = createImage("GamePictures/Backgrounds/Frogger/OspreyBackground.jpg");
			planeLeft = createImage("GamePictures/Obstacles/AirplaneLeft.png");
			planeRight = createImage("GamePictures/Obstacles/AirplaneRight.png");
			mountain = createImage("GamePictures/Obstacles/Mountain.png");
			
		}
		else{
			Background = createImage("GamePictures/Backgrounds/Frogger/NHBackground.png");
			drone = createImage("GamePictures/Obstacles/Drone.png");
			crowLeft = createImage("GamePictures/Obstacles/CrowLeft.png");
			crowRight = createImage("GamePictures/Obstacles/CrowRight.png");
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
		picNum=(picNum+1)%10;
		g.drawImage(Background, 0, 0, frameWidth, frameHeight, this);
		if (!gameObjects.isEmpty()) {
			for (GameObject o : gameObjects) {
				if(o instanceof Player){
					g.drawImage(playerRight[picNum],o.xloc,o.yloc,o.width,o.height,this);
				}
				else if(o instanceof Obstacle){
					if(isOsprey){
						if(o.xvel==0){
							g.drawImage(mountain,o.xloc,o.yloc,o.width,o.height,this);
						}
						else{
							if(o.xvel<0){
								g.drawImage(planeLeft,o.xloc,o.yloc,o.width, o.height,this);
							}
							else{
								g.drawImage(planeRight,o.xloc,o.yloc,o.width, o.height,this);
							}
						}
					}
					else{
						g.drawImage(drone,o.xloc,o.yloc,o.width, o.height, this);
					}
				}
				else{
					
				}
			}
		}
	}
}
