package mainpkg;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FoodGameView extends View {

	public FoodGameView() {
		super();
		for(int i=0; i<10; i++){
			playerRight[i] = createImage("GamePictures/PlayerAnimation/NHSideRight/Frame"+Integer.toString(i)+".png");
			playerLeft[i] = createImage("GamePictures/PlayerAnimation/NHSideLeft/Frame"+Integer.toString(i)+".png");
		}
		if(isOsprey){
			BackgroundO = createImage("GamePictures/Backgrounds/FoodAndFlappy/OspreyFoodGame.jpg");
			fishLeft = createImage("GamePictures/Objectives/FishLeft.png");
			fishRight = createImage("GamePictures/Objectives/FishRight.png");
		}
		else{
			BackgroundNH = createImage("GamePictures/Backgrounds/FoodAndFlappy/NHFoodGame.jpg");
			mouseLeft = new BufferedImage[10];
			mouseRight = new BufferedImage[10];
			for(int j=0;j<5;j++){
				mouseRight[j] = createImage("GamePictures/Objectives/MouseRight/Frame"+Integer.toString(j)+".png");
				mouseLeft[j] = createImage("GamePictures/Objectives/MouseLeft/Frame"+Integer.toString(j)+".png");
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
}
