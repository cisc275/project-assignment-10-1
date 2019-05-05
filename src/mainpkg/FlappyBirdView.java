package mainpkg;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class FlappyBirdView extends View {
	
	public FlappyBirdView(){
		super();
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
