package mainpkg;

import java.util.ArrayList;

public class FlappyBirdModel extends Model {

	public FlappyBirdModel(int fw, int fh, int s) {
		super(fw, fh, s);
		// TODO Auto-generated constructor stub
	}

	public void startFlappyBird() {
		isPlaying = true;
		player = new Player(50, 50, 50, 50, 0, 0, 0);
		objectives = new ArrayList<Objective>();
		objectives.add(new Objective(20, 20, frameWidth-20, frameHeight/2, 0, 0, false, 0));
	}
	
	public void updateFlappyBirdGameState() {
		if(Key.space.isDown) player.yloc-=40;
		player.yloc+=8;
		if(!wallCollision(player)) {
			player.xloc+=6;
		}
		if(collision(player, objectives.get(0))) {
			isPlaying = false;
		}
		
	}
}
