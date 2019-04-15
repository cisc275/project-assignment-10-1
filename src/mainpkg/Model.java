package mainpkg;

import java.util.*;
public class Model {
	protected int frameWidth;
	protected int frameHeight;
	protected int score;
	protected Enum Scenes;
	protected ArrayList<Obstacle> obstacles;
	protected ArrayList<Objective> objectives;

	protected Player player;
//	private boolean playLeft=false;
//	private boolean playRight=false;
//	private boolean playUp=false;
//	private boolean playDown=false;
	public boolean isPlaying = false;
	public boolean needInput = false;
	
	public Model(int fw, int fh, int s){
		frameWidth=fw;
		frameHeight=fh;
		score=s;
	}

	public boolean wallCollision(GameObject o) {
		if(o.xloc < 0
				|| o.xloc > (frameWidth - o.width)
				|| o.yloc < 0
				|| o.yloc > (frameHeight - o.height)) {
			System.out.println("Collided");
			return true;
		}
		return false;
	}
	public boolean playerAndObsticleCollision() {
		for(Obstacle o : obstacles) {
			if(collision(player, o))
					return true;
		}
		return false;
	}
	public boolean collision(GameObject g1, GameObject g2){
		int x1Low = g1.xloc;
		int x2Low = g2.xloc;
		int x1High = g1.xloc + g1.width;
		int x2High = g2.xloc + g2.width;
		int y1Low = g1.yloc;
		int y2Low = g2.yloc;
		int y1High = g1.yloc + g1.height;
		int y2High = g2.yloc + g2.height;

		if((x1Low <= x2High && x1High >= x2Low) 
				&& (y1Low <= y2High && y1High >= y2Low)) {
			System.out.println("collision");
			return true;
		}
		return false;
	}
	
	public void updateGameState(){
		
	}
	
	public void updateLocation(){
		
	}
	
	public void superPower(){
		
	}
	
	
	public Player getPlayer(){
		return player;
	}
	public ArrayList<Objective> getObjectives(){
		return objectives;
	}
	public ArrayList<Obstacle> getObstacles(){
		return obstacles;
	}


}
