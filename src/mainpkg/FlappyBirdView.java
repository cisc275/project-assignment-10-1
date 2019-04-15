package mainpkg;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class FlappyBirdView extends View {

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
