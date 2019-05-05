package mainpkg;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FoodGameView extends View {

	public FoodGameView() {
		super();
		if(isOsprey){
			BackgroundO = createImage("GamePictures/Backgrounds/FoodAndFlappy/OspreyFoodGame.jpg");
			fishLeft = createImage("GamePictures/Objectives/FishLeft.png");
			fishRight = createImage("GamePictures/Objectives/FishRight.png");
		}
		else{
			BackgroundNH = createImage("GamePictures/Backgrounds/FoodAndFlappy/NHFoodGame.jpg");
			mouseLeft = new BufferedImage[10];
			mouseRight = new BufferedImage[10];
		}
		
		
	}
	public void foodGame(Player player, ArrayList<Objective> objectives){
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(player);
		for(Objective o: objectives){
			gameObjects.add(o);
		}
	}
}
