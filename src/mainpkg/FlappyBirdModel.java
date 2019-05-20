package mainpkg;

import java.util.ArrayList;

public class FlappyBirdModel extends Model {
	
	private final int lostPoints = 10;

	public FlappyBirdModel(int fw, int fh, int s) {
		super(fw, fh, s);
		// TODO Auto-generated constructor stub
	}

	//Takes width and height to set buffers
	//begins FlappyBird game
	public void startFlappyBird() {
		isPlaying = true;
		int xBuffer = frameWidth/100;
		int yBuffer = frameHeight/100;
		int columns = 10;
		int rows = 10;
		int pWidth = frameWidth/columns - 2*xBuffer;
		int pHeight = frameHeight/rows - 2*yBuffer;
		int yLoc = 50;
		int spacing = pHeight*8;
		
		player = new Player(pWidth, pHeight, xBuffer, yLoc, 0, 0);
		objectives = new ArrayList<Objective>();
		obstacles = new ArrayList<Obstacle>();
		
		//obstacle 1
		int xLoc = 12*xBuffer+pWidth;
		int oHeight = pHeight + 3*(frameHeight/rows);
		obstacles.add(new Obstacle(pWidth, oHeight , xLoc, yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, frameHeight-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, oHeight , xLoc, frameHeight-oHeight, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, frameHeight-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		
		
		//obstacle 2
		xLoc += 12*xBuffer+pWidth;
		oHeight = pHeight + 2*(frameHeight/rows);
		obstacles.add(new Obstacle(pWidth, oHeight, xLoc, yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, frameHeight-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		
		//obstacle 3
		xLoc += 12*xBuffer+pWidth;
		oHeight = pHeight + 3*(frameHeight/rows);
		obstacles.add(new Obstacle(pWidth, oHeight, xLoc, yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, frameHeight-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		
		//obstacle 4
		xLoc += 12*xBuffer+pWidth;
		oHeight = pHeight + 2*(frameHeight/rows);
		obstacles.add(new Obstacle(pWidth, oHeight, xLoc, yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, frameHeight-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		
		//obstacle 5
		xLoc += 12*xBuffer+pWidth;
		oHeight = pHeight + 3*(frameHeight/rows);
		obstacles.add(new Obstacle(pWidth, oHeight, xLoc, yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, frameHeight-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		
		//finish
		obstacles.add(new Obstacle(pWidth, frameHeight-frameHeight/2+pHeight, frameWidth-pWidth-xBuffer, frameHeight-frameHeight/2, 0,0,lostPoints));
		objectives.add(new Objective(pWidth, pHeight, frameWidth-pWidth-xBuffer, frameHeight/2, 0, 0, false, 0));
	}
	
	//Updates the FlappyBirdGameState with starting x and y locations.
	//If player collides, will reset player back to starting coordinates
	public void updateFlappyBirdGameState(int startingX, int startingY) {
		if(Key.space.isDown) {
			player.yloc-=80;
		}
		player.yloc+=20;
		if(!wallCollision(player)) {
			player.xloc+=10;
		}
		if(playerAndObstacleCollision() || wallCollision(player)) {
			// sets player back to beginning if they hit a wall or obstacle
			player.xloc = startingX;
			player.yloc = startingY;
		}
		if(collision(player, objectives.get(0))) {
			// if you hit the top, the game finishes
			isPlaying = false;
		}
		
	}
}
