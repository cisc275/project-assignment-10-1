package mainpkg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FoodGameModel extends Model {

	private int flyHeight; 
	
	public FoodGameModel(int fw, int fh, int s) {
		super(fw, fh, s);
		// TODO Auto-generated constructor stub
	}
	
	//Initializes everything for the food game
	// 9 rows and 9 columns wide. Game works by having a common "buffer" size
	// between all objects, the wall, etc. This is a similar system to the frogger game.
	public void startFoodGame(){
		obstacles = null;
		objectives = new ArrayList<Objective>();
		isPlaying = true;
		int rows = 9;
		int columns = 9;
		int xbuffer = frameWidth/100;
		int ybuffer = frameHeight/100;
		int pHeight = frameHeight/rows - 2*ybuffer;
		int pWidth = frameWidth/columns - 2*xbuffer;
		flyHeight = ybuffer;
		player = new Player(pWidth,pHeight,4*pWidth,flyHeight,0,0,0);
		
		createFish(5);

	}
	
	//updates the state of the FoodGame
	//Handles player movement/food retrieval
	public void updateFoodGameState(){

		int x = player.xloc;
		int y = player.yloc;
		updateFoodObjectives();
		int speed = objectives.get(0).xvel;
		
		if(player.yloc == frameHeight) {
			player.dive(flyHeight, false);
			//startAnimation(speed);
		}
		else {
			if (Key.space.isDown) {
				//stopAnimation();
				System.out.println("Space bar press recieved");
				player.dive(frameHeight, true);
				System.out.println("Player should be at bottom");
				eatFood();
			}
			if (Key.left.isDown)
				player.xJump(false,frameWidth);
			if (Key.right.isDown)
				player.xJump(true,frameWidth);
			if (player.getPoints() > 100) {
				isPlaying = false;
			}
		}
		if(wallCollision(player)) {
			player.xloc = x;
			player.yloc = y;
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
				player.addPoints(o.getPoints());
				objectives.remove(o); 
				createFish(1);
			}
		}
	}
	
	//Creates the objectives
	public void createFish(int amount) {
		Random rx = new Random();
		for(int i = 0; i < amount; i++) {
			int x = rx.nextInt(frameWidth);
			int y = ThreadLocalRandom.current().nextInt((frameHeight-300), frameHeight);
			//System.out.println(y);
			objectives.add(new Objective(50, 50, x, y, 50, 0, false, 10));
		}
	}
	
	//Moves the fish
	public void updateFoodObjectives() {
		for(Objective o : objectives) {
			o.move();
			if(wallCollision(o)) {
				o.xvel *= -1;
			}
		}
	}
	
	public void stopAnimation() {
		for(Objective o : objectives) {
			o.xvel = 0;
		}
	}
	public void startAnimation(int speed) {
		for(Objective o : objectives) {
			o.xvel = speed;
		}
	}
	
	
}
