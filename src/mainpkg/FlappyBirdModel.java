package mainpkg;

import java.util.ArrayList;

public class FlappyBirdModel extends Model {
	
	private final int lostPoints = 10;

	public FlappyBirdModel(int fw, int fh, int s) {
		super(fw, fh, s);
		// TODO Auto-generated constructor stub
	}

	public void startFlappyBird(int width, int height) {
		isPlaying = true;
		int xBuffer = width/100;
		int yBuffer = height/100;
		int columns = 19;
		int rows = 19;
		int pWidth = width/columns - 2*xBuffer;
		int pHeight = height/rows - 2*yBuffer;
		int yLoc = 50;
		int spacing = pHeight*8;
		
		player = new Player(pWidth, pHeight, xBuffer, yLoc, 0, 0, 0);
		objectives = new ArrayList<Objective>();
		obstacles = new ArrayList<Obstacle>();
		
		//obstacle 1
		int xLoc = 12*xBuffer+pWidth;
		int oHeight = pHeight + 6*(height/rows);
		obstacles.add(new Obstacle(pWidth, oHeight , xLoc, yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, height-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		
		
		//obstacle 2
		xLoc += 12*xBuffer+pWidth;
		oHeight = pHeight + 4*(height/rows);
		obstacles.add(new Obstacle(pWidth, oHeight, xLoc, yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, height-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		
		//obstacle 3
		xLoc += 12*xBuffer+pWidth;
		oHeight = pHeight + 7*(height/rows);
		obstacles.add(new Obstacle(pWidth, oHeight, xLoc, yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, height-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		
		//obstacle 4
		xLoc += 12*xBuffer+pWidth;
		oHeight = pHeight + 5*(height/rows);
		obstacles.add(new Obstacle(pWidth, oHeight, xLoc, yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, height-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		
		//obstacle 5
		xLoc += 12*xBuffer+pWidth;
		oHeight = pHeight + 6*(height/rows);
		obstacles.add(new Obstacle(pWidth, oHeight, xLoc, yBuffer, 0, 0, lostPoints));
		obstacles.add(new Obstacle(pWidth, height-oHeight-spacing, xLoc, oHeight+pHeight+spacing+yBuffer, 0, 0, lostPoints));
		
		//finish
		objectives.add(new Objective(pWidth, pHeight, frameWidth-pWidth-xBuffer, frameHeight/2, 0, 0, false, 0));
	}
	
	public void updateFlappyBirdGameState(int startingX, int startingY) {
		if(Key.space.isDown) {
			player.yloc-=80;
		}
		player.yloc+=20;
		if(!wallCollision(player)) {
			player.xloc+=10;
		}
		if(playerAndObstacleCollision() || wallCollision(player)) {
			player.xloc = startingX;
			player.yloc = startingY;
		}
		if(collision(player, objectives.get(0))) {
			isPlaying = false;
		}
		
	}
}
