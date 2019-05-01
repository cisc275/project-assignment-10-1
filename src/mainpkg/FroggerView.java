package mainpkg;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class FroggerView extends View {
	
	public void startFrogger(Player player, ArrayList<Obstacle> obstacles) {
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(player);
		for(Obstacle o : obstacles) {
			gameObjects.add(o);
		}
		
	}
}
