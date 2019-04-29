package mainpkg;

import java.awt.Color;

public class Player extends GameObject{
	private int totalPoints;
	public int froggerStartX;
	public int froggerStartY;
	
	public Player(int width, int height, int xloc, int yloc, int xvel, int yvel, int totalPoints) {
		super(width, height, xloc, yloc, xvel, yvel);
		this.totalPoints = totalPoints;
		froggerStartX = xloc;
		froggerStartY = yloc;
	}

	public void flap(){
		yvel = height*2; //placeholder
		move();
		yvel = 0;
	}
	
	public void xJump(boolean isRight){
		int buffer = 10; //placeholder
		//Difference of the player's heigh/width to the frogger grid
		//This will be changed and can be separated. 
		xvel = width + buffer; 
		if(!isRight) xvel *= -1;
		move();
		xvel = 0;
	}
	public void yJump(boolean isUp){
		int buffer = 10; //placeholder
		//Difference of the player's heigh/width to the frogger grid
		//This will be changed and can be separated. 
		yvel = height + buffer; 
		if(isUp) yvel *= -1;
		move();
		yvel = 0;
	}
	
	public void dive(int targetHeight) {
		yloc = targetHeight;
	}

	@Override
	public int getPoints() {
		return totalPoints;
	}
	
	public void setPoints(int p) {
		totalPoints = p;
	}
	
	public void addPoints(int p) {
		totalPoints += p;
	}
	
	//Alpha only
	public Color getColor() {
		return Color.blue;
	}

}
