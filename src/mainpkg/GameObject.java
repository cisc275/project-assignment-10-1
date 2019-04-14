package mainpkg;

public abstract class GameObject {
	private int width;
	private int height;
	private int xloc;
	private int yloc;
	private int xvel;
	private int yvel;
	
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

}
