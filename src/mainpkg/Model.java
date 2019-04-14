package mainpkg;

import java.util.*;
public class Model {
	private int frameWidth;
	private int frameHeight;
	private int score;
	private Enum Scenes;
	private List<Obstacle> obstacles;
	private List<Objective> objectives;
	private boolean playLeft=false;
	private boolean playRight=false;
	private boolean playUp=false;
	private boolean playDown=false;
	
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

}
