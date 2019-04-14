package mainpkg;

public class Objective extends GameObject{
	public boolean superPower;
	public int points; //points gained when hit
	
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
	
	
}
