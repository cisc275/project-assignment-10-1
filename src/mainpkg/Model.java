package mainpkg;

import java.util.*;
public class Model {
	private int frameWidth;
	private int frameHeight;
	private int score;
	private Enum Scenes;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Objective> objectives;
	private Player player;
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
	public void Collision(GameObject g1, GameObject g2){
		
	}
	
	public void updateGameState(){
		
	}
	
	public void updateLocation(){
		
	}
	
	public void superPower(){
		
	}
	
	public void startFrogger(int width, int height) {
		isPlaying = true;
		int buffer = 10;
		int collums = 5;
		int rows = 5;
		int pWidth = width/collums - buffer*2;
		int pHeight = height/rows - buffer*2;
		obstacles = new ArrayList<Obstacle>();
		
		player = new Player(pWidth, pHeight, buffer, height-(buffer+pHeight), 0, 0, 0);
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	
	public ArrayList<Objective> getObjectives() {
		return objectives;
	}

}
