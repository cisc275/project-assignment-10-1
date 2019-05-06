package mainpkg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class FoodGameModel extends Model {

	private int flyHeight;
	private int foodHeight; 
	
	public FoodGameModel(int fw, int fh, int s) {
		super(fw, fh, s);
		foodHeight = frameHeight*9/10; 
		flyHeight = frameHeight/10;
		// TODO Auto-generated constructor stub
	}
	
	public void startFoodGame(){
		obstacles = null;
		objectives = new ArrayList<Objective>();
		isPlaying = true;
		player = new Player(70,70,250,flyHeight,0,0,0);
		int objXloc = ThreadLocalRandom.current().nextInt(0, frameWidth-40);
		objectives.add(new Objective(50, 50, objXloc , foodHeight, 0,0,false, 0));
	}
	
	public void updateFoodGameState(){
		if(player.yloc == foodHeight) {
			eatFood();
			player.dive(flyHeight);
		}
		else {
			if (Key.space.isDown) {
				player.dive(foodHeight);
			}
			if (Key.left.isDown)
				player.xJump(false,frameWidth);
			if (Key.right.isDown)
				player.xJump(true,frameWidth);
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
