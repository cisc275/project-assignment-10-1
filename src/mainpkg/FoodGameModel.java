package mainpkg;

import java.util.ArrayList;
import java.util.Iterator;

public class FoodGameModel extends Model {

	public FoodGameModel(int fw, int fh, int s) {
		super(fw, fh, s);
		// TODO Auto-generated constructor stub
	}
	
	public void startFoodGame(){
		obstacles = null;
		objectives = new ArrayList<Objective>();
		isPlaying = true;
		player = new Player(70,70,250,50,0,0,0);
		objectives.add(new Objective(50, 50, 300, 250, 0,0,false, 0));
	}
	
	public void updateFoodGameState(){
		int flyHeight = 50;
		int foodHeight = 250;
		if(player.yloc == foodHeight) {
			eatFood();
			player.dive(flyHeight);
		}
		else {
			if (Key.space.isDown) {
				player.dive(foodHeight);
			}
			if (Key.left.isDown)
				player.xJump(false);
			if (Key.right.isDown)
				player.xJump(true);
			if (player.getPoints() > 0) {
				isPlaying = false;
			}
		}
		System.out.println(player.xloc + ", " + player.yloc);
	}
	
	public void eatFood() {
		Iterator<Objective> objIt = objectives.iterator();
		Objective o;
		while(objIt.hasNext()) {
			o = objIt.next();
			if(collision(o, player)) {
				player.addPoints(1);
				//objectives.remove(o); 
			}
		}
	}
}
