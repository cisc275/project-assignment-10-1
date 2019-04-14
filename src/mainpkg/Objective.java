package mainpkg;

import java.awt.Color;

public class Objective extends GameObject{
	private boolean superPower;
	private int points; //points gained when hit
	
	public Objective(int width, int height, int xloc, int yloc, int xvel, int yvel, 
			boolean superPower, int points) {
		super(width, height, xloc, yloc, xvel, yvel);
		this.superPower = superPower;
		this.points = points;
	}

	@Override
	public int getPoints() {
		return points;
	}
	public void setPoints(int p) {
		points = p;
	}
	public boolean isSuper() {
		return superPower;
	}
	public void toggleSuper() {
		superPower = superPower ^ true;
	}
	
	public Color getColor(){
		return Color.green;
	}
}
