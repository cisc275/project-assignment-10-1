package mainpkg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class FoodGameModel extends Model {

	private int flyHeight;
	private int foodHeight; 
	
	public FoodGameModel(int fw, int fh, int s) {
		super(fw, fh, s);
		// TODO Auto-generated constructor stub
	}
	
	public void startFoodGame(){
		obstacles = null;
		objectives = new ArrayList<Objective>();
		isPlaying = true;
		int rows = 9;
		int columns = 9;
		int xbuffer = frameWidth/100;
		int ybuffer = frameHeight/100;
		int pHeight = frameHeight/columns - 2*ybuffer;
		int pWidth = frameWidth/rows - 2*xbuffer;
		player = new Player(pWidth,pHeight,4*pWidth,0+ybuffer,0,0,0);
		objectives.add(new Objective(50, 50, 300, 250, 0,0,false, 0));
		flyHeight = pHeight;
		foodHeight = 250;
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
