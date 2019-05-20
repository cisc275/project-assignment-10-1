package mainpkg;

import java.util.ArrayList;
import java.util.Random;

public class FroggerModel extends Model {

	private final int lostPoints = 5;
	
	public FroggerModel(int fw, int fh) {
		super(fw, fh);
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
		
		obstacles = new ArrayList<Obstacle>();
		player = new Player(pWidth, pHeight, frameWidth/2, yLoc, 0, 0, Model.player.getPoints());
		
		createObstacles(6);
		
	}
	
	public void startFroggerTutorial() {
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
		player = new Player(pWidth, pHeight, xbuffer+(4*pWidth), yLoc, 0, 0, Model.player.getPoints());
		
		//row 3
		yLoc -= 5*(pHeight + 2*ybuffer);
		oWidth = pWidth*2;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, frameWidth/50, 0, lostPoints));
		
		
	}
	
	//Updates the FroggerState, if collision is detected returns player back to starting coordinates
	public void updateFroggerState(int startingX, int startingY, boolean isTutorial) {
	
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
			if(!isTutorial) {
				player.addPoints(-lostPoints);
			}
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
	
	public void createObstacles(int count) {
		int xbuffer = frameWidth/100;
		int ybuffer = frameHeight/100;
		int collums = 9;
		int rows = 9;
		int pWidth = frameWidth/collums - xbuffer*2;
		int pHeight = frameHeight/rows - ybuffer*2;
		int yLoc = frameHeight - (ybuffer+pHeight);
		int oWidth = pWidth*2;
		
		yLoc -= pHeight + 2*ybuffer;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, 0, 0, lostPoints));
		obstacles.add(new Obstacle(oWidth, pHeight, (frameWidth - oWidth) - xbuffer, yLoc, 0, 0, lostPoints));	
		
		Random rx = new Random();
		for(int i = 0; i < count; i++) {
			yLoc -= pHeight + 2*ybuffer;
			int speed = (int)(Math.random()*50 + 15);
			int x = rx.nextInt(frameWidth-oWidth);
			obstacles.add(new Obstacle(oWidth, pHeight, x, yLoc, frameWidth/speed, 0, lostPoints));
		}
	}
	

}
