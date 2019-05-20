package mainpkg;

import java.util.ArrayList;

public class FlappyBirdModel extends Model {
	
	private final int lostPoints = 10;

	public FlappyBirdModel(int fw, int fh) {
		super(fw, fh);
		// TODO Auto-generated constructor stub
	}

	//Takes width and height to set buffers
	//begins FlappyBird game
	public void startFlappyBird(boolean isOsprey) {
		isPlaying = true;
		int xBuffer = frameWidth/100;
		int yBuffer = frameHeight/100;
		int columns = 10;
		int rows = 10;
		int pWidth = frameWidth/columns - 2*xBuffer;
		int pHeight = frameHeight/rows - 2*yBuffer;
		int yLoc = 50;
		
		player = new Player(pWidth, pHeight, xBuffer, frameHeight*2/10, 0, 0, Model.player.getPoints());
		objectives = new ArrayList<Objective>();
		obstacles = new ArrayList<Obstacle>();
		
		createObstacles(isOsprey, 4);
	}
	
	public void startFlappyBirdTutorial(boolean isOsprey) {
		isPlaying = true;
		int xBuffer = frameWidth/100;
		int yBuffer = frameHeight/100;
		int columns = 10;
		int rows = 10;
		int pWidth = frameWidth/columns - 2*xBuffer;
		int pHeight = frameHeight/rows - 2*yBuffer;
		int yLoc = 50;
		
		player = new Player(pWidth, pHeight, xBuffer, frameHeight*2/10, 0, 0, Model.player.getPoints());
		objectives = new ArrayList<Objective>();
		obstacles = new ArrayList<Obstacle>();
		
		createObstacles(isOsprey, 1);
	}
	
	//Updates the FlappyBirdGameState with starting x and y locations.
	//If player collides, will reset player back to starting coordinates
	public void updateFlappyBirdGameState(int startingX, int startingY, boolean isTutorial) {
		if(Key.space.isDown) {
			player.yloc-=80;
		}
		player.yloc+=20;
		if(!wallCollision(player)) {
			player.xloc+=10;
		}
		if(playerAndObstacleCollision()) {
			// sets player back to beginning if they hit a wall or obstacle
			player.xloc = startingX;
			player.yloc = startingY;
			if(!isTutorial) {
				player.addPoints(-lostPoints);
			}
		}
		if(wallCollision(player)) {
			//No lost points for hitting wall
			player.xloc = startingX;
			player.yloc = startingY;
		}
		if(collision(player, objectives.get(0))) {
			// if you hit the top, the game finishes
			isPlaying = false;
		}	
	}
	
	public void createObstacles(boolean isOsprey, int count) {
		int xBuffer = frameWidth/100;
		int yBuffer = frameHeight/100;
		int columns = 10;
		int rows = 10;
		int pWidth = frameWidth/columns - 2*xBuffer;
		int pHeight = frameHeight/rows - 2*yBuffer;
		int spacing = frameHeight*1/3;
		int xLoc = 0;
		int spacerY = 0;
		
		//all obstacles
		for(int i = 0; i < count; i++) {
			xLoc += 10*xBuffer+pWidth;
			spacerY = (int)(Math.random()*3 + 1);
			int oHeight = pHeight + spacerY*(frameHeight/rows);
			obstacles.add(new Obstacle(pWidth, oHeight , xLoc, yBuffer, 0, 0, lostPoints));
			obstacles.add(new Obstacle(pWidth, frameHeight-oHeight-yBuffer, xLoc, oHeight+spacing+yBuffer, 0, 0, lostPoints));
		}
		
		//finish
		if(isOsprey) {
			obstacles.add(new Obstacle(pWidth, frameHeight-frameHeight/2-yBuffer, frameWidth-pWidth-xBuffer, frameHeight-(spacing+yBuffer+pHeight), 0,0,lostPoints));
			objectives.add(new Objective(pWidth, pHeight, frameWidth-pWidth-xBuffer, frameHeight/2, 0, 0, false, 0));
		}
		else {
			objectives.add(new Objective(pWidth, pHeight, frameWidth-pWidth-xBuffer, frameHeight-pHeight-yBuffer-spacerY, 0,0, false, 0));
		}
	}
}
