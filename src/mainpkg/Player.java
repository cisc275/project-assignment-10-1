package mainpkg;

import java.awt.Color;

public class Player extends GameObject{
	static int totalPoints=0;
	public int froggerStartX;
	public int froggerStartY;
	
	//Player constructor, initializes all relevant variables.
	public Player(int width, int height, int xloc, int yloc, int xvel, int yvel) {
		super(width, height, xloc, yloc, xvel, yvel);
		froggerStartX = xloc;
		froggerStartY = yloc;
	}
	
	//Moves the player in the xDirection when called in various games
	public void xJump(boolean isRight, int fwidth){
		int buffer = fwidth/100; //placeholder
		//Difference of the player's heigh/width to the frogger grid
		//This will be changed and can be separated. 
		xvel = width + 2*buffer;
		if(!isRight) xvel *= -1;
		move();
		xvel = 0;
	}
	
	//Moves player in yDirection when called in various games
	public void yJump(boolean isUp, int fheight){
		int buffer = fheight/100; //placeholder
		//Difference of the player's heigh/width to the frogger grid
		//This will be changed and can be separated. 
		yvel = height + 2*buffer; 
		if(isUp) yvel *= -1;
		move();
		yvel = 0;
	}
	
	//Moves player down to the targetHeight paramater
	public void dive(int targetHeight) {
		yloc = targetHeight;
	}

	
	//Retrieves player points
	@Override
	public int getPoints() {
		return totalPoints;
	}
	
	//Used to update player points
	public void setPoints(int p) {
		totalPoints = p;
	}
	
	//Adds directly to the current player points
	public void addPoints(int p) {
		totalPoints += p;
	}
	
	//Alpha only
	public Color getColor() {
		return Color.blue;
	}

}
