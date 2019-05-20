package mainpkg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FoodGameModel extends Model {

	private int flyHeight;
	private int foodHeight; 
	
	
	public FoodGameModel(int fw, int fh, int s) {
		super(fw, fh, s);
		// TODO Auto-generated constructor stub
	}
	
	//Initializes everything for the food game
	// 9 rows and 9 columns wide. Game works by having a common "buffer" size
	// between all objects, the wall, etc. This is a similar system to the frogger game.
	public void startFoodGame(){
		Random rand = new Random();
		obstacles = null;
		objectives = new ArrayList<Objective>();
		isPlaying = true;
		int rows = 9;
		int columns = 9;
		int xbuffer = frameWidth/100;
		int ybuffer = frameHeight/100;
		int vel = rand.nextInt(xbuffer);
		int pHeight = frameHeight/rows - 2*ybuffer;
		int pWidth = frameWidth/columns - 2*xbuffer;
		int oXLoc = (frameWidth/columns) * ThreadLocalRandom.current().nextInt(1, columns-2);
		foodHeight = (frameHeight/rows)*7;
		flyHeight = ybuffer;
		player = new Player(pWidth,pHeight,4*pWidth,flyHeight,0,0);
		objectives.add(new Objective(50, 50, oXLoc, foodHeight,0 ,0,false, 0));
			}
	
	//updates the state of the FoodGame
	//Handles player movement/food retrieval
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
		//System.out.println(player.xloc + ", " + player.yloc);
	}
	
	//Assigns points to player when food is eaten
	//Calls collision detection
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
