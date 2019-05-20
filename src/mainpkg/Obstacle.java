package mainpkg;

import java.awt.Color;

public class Obstacle extends GameObject{
	private int lostPoints; //points lost when hit
	
	public Obstacle(int width, int height, int xloc, int yloc, int xvel, int yvel, int points) {
		super(width, height, xloc, yloc, xvel, yvel);
		// TODO Auto-generated constructor stub
		lostPoints = points;
	}

	@Override
	public int getPoints() {
		return -1 * lostPoints;
	}
  
	public Color getColor() {
		return Color.red;
	}
}
