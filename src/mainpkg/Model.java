package mainpkg;

import java.util.*;
public class Model {
	private int frameWidth;
	private int frameHeight;
	private int score;
	private Enum Scenes;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Objective> objectives;
	public Player player;
	private boolean playLeft=false;
	private boolean playRight=false;
	private boolean playUp=false;
	private boolean playDown=false;
  public boolean needInput = false;
  public boolean isPlaying = false;
	
	public Model(int fw, int fh, int s){
		frameWidth=fw;
		frameHeight=fh;
		score=s;
	}
	public boolean Collision(GameObject g1, GameObject g2){
		if(g1.xloc+g1.width==g2.xloc||g1.xloc==g2.xloc-g2.width){
			if(g1.yloc-g1.height==g2.yloc||g1.yloc==g2.yloc-g2.height){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public void updateGameState(){
		
	}
	
	public void updateLocation(){
		
	}
	
	public void superPower(){
		
	}
	
	public void main(String[] args){
		
	}
	public void changeplayLeft(){
		playLeft^=true;
	}
	public void changeplayRight(){
		playRight^=true;
	}
	public void changeplayUp(){
		playUp^=true;
	}
	public void changeplayDown(){
		playDown^=true;
	}
	public void startFoodGame(){
		isPlaying = true;
		player = new Player(100,100,250,50,0,0,0);
		objectives.add(new Objective(50, 50, 300, 250, 0,0,false, 0));
	}
	public void updateFoodGameState() throws InterruptedException{
		if(Key.space.isDown) player.dive(player.height, 250);
		if(Key.left.isDown) player.xJump(false);
		if(Key.right.isDown) player.xJump(true);
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
