package mainpkg;

import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FlappyBirdView extends View {
	
	public FlappyBirdView(){
		super();
		for(int i=0; i<10; i++){
			playerRight[i] = createImage("GamePictures/PlayerAnimation/NHSideRight/Frame"+Integer.toString(i)+".png");
			playerLeft[i] = createImage("GamePictures/PlayerAnimation/NHSideLeft/Frame"+Integer.toString(i)+".png");
		}
		if(isOsprey){
			Background = createImage("GamePictures/Backgrounds/FoodAndFlappy/OspreyFoodGame.jpg");
			
		}
		else{
			Background = createImage("GamePictures/Backgrounds/FoodAndFlappy/NHFoodGame.jpg");
			powerLine = createImage("GamePictures/Obstacles/PowerLine.png");
		}
		nest = createImage("GamePictures/Objectives/Nest.png");
		twig = createImage("GamePictures/Objectives/Twig.png");
	}

	public void startFlappyBird(Player player, ArrayList<Objective> objectives, ArrayList<Obstacle> obstacles) { 
		  gameObjects = new ArrayList<GameObject>();
		  gameObjects.add(player);
		  for(Objective o: objectives){
			  System.out.println("added");
			  gameObjects.add(o);
		  }
		  for(Obstacle o: obstacles) {
			  System.out.println("added");
			  gameObjects.add(o);
		  }
	  }
	public void paint(Graphics g){ //paints the current state of the game
		if (!gameObjects.isEmpty()) {
			for (GameObject o : gameObjects) {
				
				if(o instanceof Player){
					
				}
				else if(o instanceof Obstacle){
					
				}
				else{
					g.drawImage(nest, o.xloc, o.yloc,o.width,o.height, this);
				}
				//g.setColor(o.getColor());
				//g.fillRect(o.xloc, o.yloc, o.width, o.height);
			}
		}
	}
}
