package mainpkg;

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
			BackgroundO = createImage("GamePictures/Backgrounds/FoodAndFlappy/OspreyFoodGame.jpg");
			
		}
		else{
			BackgroundNH = createImage("GamePictures/Backgrounds/FoodAndFlappy/NHFoodGame.jpg");
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
}
