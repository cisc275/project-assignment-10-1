package mainpkg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class FoodGameModel extends Model {

	private int flyHeight; 
	private int foodHeight = frameHeight - (frameHeight/7);	
	
	
	public FoodGameModel(int fw, int fh) {
		super(fw, fh);
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
		flyHeight = ybuffer;
		player = new Player(pWidth,pHeight,4*pWidth,flyHeight,0,0, Model.player.getPoints());
		createFish(5);
	}
	
	public void startFoodGameTutorial() {
		Random rand = new Random();
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
		player = new Player(pWidth,pHeight,4*pWidth,flyHeight,0,0, Model.player.getPoints());
		createFish(1);
	}
	
	//updates the state of the FoodGame
	//Handles player movement/food retrieval
	public void updateFoodGameState(int timer, boolean isTutorial){
		
		int x = player.xloc;
		int y = player.yloc;
		updateFoodObjectives();
		
		if(player.yloc == foodHeight) {
			player.dive(flyHeight);
		}
		else {
			if (Key.space.isDown) {
				player.dive(foodHeight);
				if(!isTutorial) {
					eatFood();
				}
				else {
					timer = eatFoodTutorial(timer);
				}
			}
			if (Key.left.isDown)
				player.xJump(false,frameWidth);
			if (Key.right.isDown)
				player.xJump(true,frameWidth);
			if(timer <= 0) {
				isPlaying = false;
			}
		}
		if(wallCollision(player)) {
			player.xloc = x;
			player.yloc = y;
		}
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
				break;
			}
		}
	}
	
	//Ends tutorial when objective is eaten
	public int eatFoodTutorial(int timer) {
		Iterator<Objective> objIt = objectives.iterator();
		Objective o;
		boolean flag = false;
		while(objIt.hasNext()) {
			o = objIt.next();
			if(collision(o, player)) {
				objectives.remove(o); 
				flag = true;
				break;
			}
		}
		if(flag) {
			return 0;
		}
		else {
			return timer;
		}
	}
	
	//Creates the objectives
	public void createFish(int amount) {
		int rows = 9;
		int columns = 9;
		int xbuffer = frameWidth/100;
		int ybuffer = frameHeight/100;
		int pHeight = frameHeight/rows - 2*ybuffer;
		int pWidth = frameWidth/columns - 2*xbuffer;
		
		Random rx = new Random();
		for(int i = 0; i < amount; i++) {
			int x = rx.nextInt(frameWidth-pWidth);
			int speed = (int)(Math.random()*60 + 15);
			objectives.add(new Objective(pWidth/2, pHeight/2, x, foodHeight, frameWidth/speed, 0, false, 10));
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
	
	
}
