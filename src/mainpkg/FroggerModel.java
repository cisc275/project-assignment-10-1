package mainpkg;

import java.util.ArrayList;

public class FroggerModel extends Model {

	private final int lostPoints = 5;
	
	public FroggerModel(int fw, int fh, int s) {
		super(fw, fh, s);
		// TODO Auto-generated constructor stub
	}

	//Begins frogger game, initializes screen with width height used in various calculations
	public void startFrogger() {
		isPlaying = true;
		int xbuffer = frameWidth/100;
		int ybuffer = frameHeight/100;
		int collums = 9;
		int rows = 9;
		int pWidth = frameWidth/collums - xbuffer*2;
		int pHeight = frameHeight/rows - ybuffer*2;
		int yLoc = frameHeight - (ybuffer+pHeight);
		int oWidth = pWidth + 2*(frameWidth/collums);
		obstacles = new ArrayList<Obstacle>();
		//row 0
		player = new Player(pWidth, pHeight, frameWidth/2, yLoc, 0, 0, Model.player.getPoints());
		
		// row 1
		yLoc -= pHeight + 2*ybuffer;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, 0, 0, lostPoints));
		obstacles.add(new Obstacle(oWidth, pHeight, (frameWidth - oWidth) - xbuffer, yLoc, 0, 0, lostPoints));
		
		// row 2
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, frameWidth/100, 0, lostPoints));
		
		//row 3
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth*2;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, frameWidth/50, 0, lostPoints));
		
		//row 4
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth*4;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, frameWidth/200, 0, lostPoints));
		
		//row 5
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth*2;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, frameWidth/15, 0, lostPoints));
		
		//row 6
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth*3;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, frameWidth/30, 0, lostPoints));
		
		//row 7
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, frameWidth/75, 0, lostPoints));
	}
	
	public void startFroggerTutorial(int width, int height) {
		isPlaying = true;
		int xbuffer = width/100;
		int ybuffer = height/100;
		int collums = 9;
		int rows = 9;
		int pWidth = width/collums - xbuffer*2;
		int pHeight = height/rows - ybuffer*2;
		int yLoc = height - (ybuffer+pHeight);
		int oWidth = pWidth + 2*(width/collums);
		obstacles = new ArrayList<Obstacle>();
		
		//row 0
		player = new Player(pWidth, pHeight, xbuffer+(4*pWidth), yLoc, 0, 0, Model.player.getPoints());
		
		//row 3
		yLoc -= 5*(pHeight + 2*ybuffer);
		oWidth = pWidth*2;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, width/50, 0, lostPoints));
		
		
	}
	
	//Updates the FroggerState, if collision is detected returns player back to starting coordinates
	public void updateFroggerState(int startingX, int startingY) {
	
		int x = player.xloc;
		int y = player.yloc;
		
		if(Key.up.isDown) player.yJump(true,frameHeight);
		if(Key.left.isDown) player.xJump(false,frameWidth);
		if(Key.right.isDown) player.xJump(true,frameWidth);
		if(Key.down.isDown) player.yJump(false,frameHeight);
		
		updateFroggerObstacles();
		
		if(playerAndObstacleCollision()) {
			// moves player back to beginning if they hit an obstacle
			player.xloc = startingX;
			player.yloc = startingY;
			player.addPoints(-lostPoints);
		}
		if(wallCollision(player)) {
			// no points lost for running into wall
			player.xloc = x;
			player.yloc = y;
		}
		
		if(froggerEnd()) {
			isPlaying = false;
		}
	}
	
	//Ends frogger game if the player is at the end of the screen
	private boolean froggerEnd() {
		if(player.yloc < player.height){
			return true;
		}
		return false;
	}
	
	//Handles Obstacle movement
	public void updateFroggerObstacles() {
		for(Obstacle o : obstacles) {
			o.move();
			if(wallCollision(o)) o.xvel *= -1;
		}
	}
	

}
