package mainpkg;

public class Player extends GameObject{
	int totalPoints;
	
	public Player(int width, int height, int xloc, int yloc, int xvel, int yvel) {
		super(width, height, xloc, yloc, xvel, yvel);
		
	}

	public void flap(){
		
	}
	
	public void jump(){
		
	}
	
	public void dive(){
		
	}

	@Override
	public int getPoints() {
		return totalPoints;
	}
	

}
