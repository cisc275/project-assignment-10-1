package mainpkg;

import java.awt.Color;

public class Player extends GameObject{
	private int totalPoints;
	
	public Player(int width, int height, int xloc, int yloc, int xvel, int yvel, int totalPoints) {
		super(width, height, xloc, yloc, xvel, yvel);
		this.totalPoints = totalPoints;
	}

	public void flap(){
		yvel = height*2; //placeholder
		move();
		yvel = 0;
	}
	
	public void xJump(){
		int buffer = 10; //placeholder
		//Difference of the player's heigh/width to the frogger grid
		//This will be changed and can be separated. 
		xvel = width + buffer; 
		move();
		xvel = 0;
	}
	public void yJump(){
		int buffer = 10; //placeholder
		//Difference of the player's heigh/width to the frogger grid
		//This will be changed and can be separated. 
		yvel = height + buffer; 
		move();
		yvel = 0;
	}
	
	public void dive(int flyheight, int fishheight) throws InterruptedException{
		yvel=(flyheight-fishheight)/2;
		move();
		try{
			Thread.sleep(10);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		move();
		try{
			Thread.sleep(10);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		yvel=-yvel;
		try{
			Thread.sleep(10);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		move();
		try{
			Thread.sleep(10);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//TODO: figure out. Probably use a series of move() methods
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
	
	public Color getColor(){
		return Color.blue;
	}

}
