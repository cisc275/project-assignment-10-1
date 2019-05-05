package mainpkg;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class FroggerView extends View {
	
	
	public FroggerView(){
		super();
		if(isOsprey){
			FroggerBackgroundO = createImage("GamePictures/Backgrounds/Frogger/OspreyBackground.jpg");
			planeLeft = createImage("GamePictures/Obstacles/AirplaneLeft.png");
			planeRight = createImage("GamePictures/Obstacles/AirplaneRight.png");
			mountainLeft = createImage("GamePictures/Obstacles/MountairnSmallonLeft.png");
			mountainRight = createImage("GamePictures/Obstacles/MountainSmallonRight.png");
		}
		else{
			FroggerBackgroundNH = createImage("GamePictures/Backgrounds/Frogger/NHBackground.png");
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
}
