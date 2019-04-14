package mainpkg;

public class Obstacle extends GameObject{
	int lostPoints; //points lost when hit
	
	public Obstacle(int width, int height, int xloc, int yloc, int xvel, int yvel) {
		super(width, height, xloc, yloc, xvel, yvel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPoints() {
		return -1 * lostPoints;
	}
	
}
