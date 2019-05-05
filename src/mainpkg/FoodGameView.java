package mainpkg;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class FoodGameView extends View {

	public void foodGame(Player player, ArrayList<Objective> objectives){
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(player);
		for(Objective o: objectives){
			gameObjects.add(o);
		}
	}
}
