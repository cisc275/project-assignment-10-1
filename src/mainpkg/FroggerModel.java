package mainpkg;

import java.util.ArrayList;

public class FroggerModel extends Model {

	public FroggerModel(int fw, int fh, int s) {
		super(fw, fh, s);
		// TODO Auto-generated constructor stub
	}

	public void startFrogger(int width, int height) {
		isPlaying = true;
		int xbuffer = width/100;
		int ybuffer = height/100;
		int collums = 9;
		int rows = 9;
		int pWidth = width/collums - xbuffer*2;
		int pHeight = height/rows - ybuffer*2;
		int yLoc = height - (ybuffer+pHeight);
		obstacles = new ArrayList<Obstacle>();
		//row 0
		player = new Player(pWidth, pHeight, xbuffer, yLoc, 0, 0, 0);
		// row 1
		//yLoc -= pHeight + ybuffer;
		yLoc -= pHeight + 2*ybuffer;
		//int oWidth = width/2 - pWidth/2 - xbuffer*3;
		int oWidth = pWidth + 2*(width/collums);
		obstacles.add(new Obstacle(oWidth, pHeight, 0+xbuffer, yLoc, 0, 0, 10));
		obstacles.add(new Obstacle(oWidth, pHeight, (width - oWidth) - xbuffer, yLoc, 0, 0, 10));
		// row 2
		//yLoc -= (pHeight + ybuffer)*2;
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, width/100, 0, 10));
		//row 3
		//yLoc -= (pHeight + ybuffer);
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth*2;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, width/50, 0, 10));
		//row 4
		//yLoc -= (pHeight + ybuffer);
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth*4;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, width/200, 0, 10));
		//row 5
		//yLoc -= (pHeight + ybuffer);
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth*2;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, width/15, 0, 10));
		//row 6
		//yLoc -= (pHeight + ybuffer);
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth*3;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, width/30, 0, 10));
		//row 7
		//yLoc -= (pHeight + ybuffer);
		yLoc -= pHeight + 2*ybuffer;
		oWidth = pWidth;
		obstacles.add(new Obstacle(oWidth, pHeight, xbuffer, yLoc, width/75, 0, 10));
	}
	
	public void updateFroggerState(int startingX, int startingY) {
	
		if(Key.up.isDown) player.yJump(true,frameHeight);
		if(Key.left.isDown) player.xJump(false,frameWidth);
		if(Key.right.isDown) player.xJump(true,frameWidth);
		if(Key.down.isDown) player.yJump(false,frameHeight);
		
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
		if(player.yloc < player.height){
			return true;
		}
		return false;
	}
	
	public void updateFroggerObstacles() {
		for(Obstacle o : obstacles) {
			o.move();
			if(wallCollision(o)) o.xvel *= -1;
		}
	}
}
