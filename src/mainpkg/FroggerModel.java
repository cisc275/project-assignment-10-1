package mainpkg;

import java.util.ArrayList;

public class FroggerModel extends Model {

	public FroggerModel(int fw, int fh, int s) {
		super(fw, fh, s);
		// TODO Auto-generated constructor stub
	}

	public void startFrogger(int width, int height) {
		isPlaying = true;
		int buffer = 10;
		int collums = 5;
		int rows = 5;
		int pWidth = width/collums - buffer*2;
		int pHeight = height/rows - buffer*2;
		int yLoc = height - (buffer+pHeight);
		obstacles = new ArrayList<Obstacle>();
		//row 0
		player = new Player(pWidth, pHeight, buffer, yLoc, 0, 0, 0);
		// row 1
		yLoc -= pHeight + buffer;
		int oWidth = width/2 - pWidth/2 - buffer*3;
		obstacles.add(new Obstacle(oWidth, pHeight, 0, yLoc, 0, 0, 10));
		obstacles.add(new Obstacle(oWidth, pHeight, width - oWidth, yLoc, 0, 0, 10));
		// row 3
		yLoc -= (pHeight + buffer)*2;
		oWidth = pWidth;
		obstacles.add(new Obstacle(oWidth, pHeight, buffer, yLoc, 10, 0, 10));
		//row 4
		yLoc -= (pHeight + buffer);
		oWidth = pWidth*2;
		obstacles.add(new Obstacle(oWidth, pHeight, buffer, yLoc, 20, 0, 10));
	}
	
	public void updateFroggerState(int startingX, int startingY) {
	
		if(Key.up.isDown) player.yJump(true);
		if(Key.left.isDown) player.xJump(false);
		if(Key.right.isDown) player.xJump(true);
		if(Key.down.isDown) player.yJump(false);
		
		updateFroggerObstacles();
		
		if(wallCollision(player) || playerAndObstacleCollision()) {
			player.xloc = startingX;
			player.yloc = startingY;
		}
		
		if(froggerEnd()) {
			isPlaying = false;
		}
	}
	
	private boolean froggerEnd() {
		if(player.yloc < player.height)
			return true;
		return false;
	}
	
	public void updateFroggerObstacles() {
		for(Obstacle o : obstacles) {
			o.move();
			if(wallCollision(o)) o.xvel *= -1;
		}
	}
}
