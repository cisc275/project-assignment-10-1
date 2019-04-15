package mainpkg;

import java.awt.Color;

public abstract class GameObject {
	protected int width;
	protected int height;
	protected int xloc;
	protected int yloc;
	protected int xvel;
	protected int yvel;
	
	public GameObject(int width, int height, int xloc, int yloc, int xvel, int yvel) {
		this.width = width;
		this.height = height;
		this.xloc = xloc;
		this.yloc = yloc;
		this.xvel = xvel;
		this.yvel = yvel;
	}
	
	//updates loc based on vel
	public void move() {
		xloc += xvel;
		yloc += yvel;
	}
	
	
	public abstract int getPoints();
	public abstract Color getColor();

}
