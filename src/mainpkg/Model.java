package mainpkg;

import java.util.*;
public class Model {
	private int frameWidth;
	private int frameHeight;
	private int score;
	private Enum Scenes;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Objective> objectives;

	private Player player;
//	private boolean playLeft=false;
//	private boolean playRight=false;
//	private boolean playUp=false;
//	private boolean playDown=false;
	public boolean isPlaying = false;
	public boolean needInput = false;
	
	public Model(int fw, int fh, int s){
		frameWidth=fw;
		frameHeight=fh;
		score=s;
	}

	public boolean wallCollision(GameObject o) { //Returns true if a game object collides with the wall
		if(o.xloc <= 0
				|| o.xloc > (frameWidth - o.width)
				|| o.yloc <= 0
				|| o.yloc > (frameHeight - o.height)) {
			if (o instanceof Player) {
				System.out.println("pWallCollide");
			}
			return true;
		}
		return false;
	}
	public boolean playerAndObsticleCollision() { //Returns true if a player object collides with an obstacle object
		for(Obstacle o : obstacles) {
			if(collision(player, o))
					return true;
		}
		return false;
	}
	public boolean collision(GameObject g1, GameObject g2){ //General collision function between two game objects
		int x1Low = g1.xloc;
		int x2Low = g2.xloc;
		int x1High = g1.xloc + g1.width;
		int x2High = g2.xloc + g2.width;
		int y1Low = g1.yloc;
		int y2Low = g2.yloc;
		int y1High = g1.yloc + g1.height;
		int y2High = g2.yloc + g2.height;

		if((x1Low <= x2High && x1High >= x2Low) 
				&& (y1Low <= y2High && y1High >= y2Low)) {
			System.out.println("collision");
			return true;
		}
		return false;
	}
	
	public void updateGameState(){
		
	}
	
	public void updateLocation(){
		
	}
	
	public void superPower(){ //detects if the player has collided with an objective object and responds accordingly
		for(Objective o: objectives){
			if(collision(player, o)){
				
			}
		}
	}
	
	public void startFrogger(int width, int height) { //Begins the logic for the first game, frogger 
		isPlaying = true;
		int buffer = 10;
		int collums = 5;
		int rows = 5;
		int pWidth = width/collums - buffer*2;
		int pHeight = height/rows - buffer*2;
		int yLoc = height - (buffer+pHeight);
		obstacles = new ArrayList<Obstacle>();
		//row 0
		player = new Player(pWidth, pHeight, buffer, yLoc, 0, 0, 0);
		// row 1
		yLoc -= pHeight + buffer;
		int oWidth = width/2 - pWidth/2 - buffer*3;
		obstacles.add(new Obstacle(oWidth, pHeight, 0, yLoc, 0, 0));
		obstacles.add(new Obstacle(oWidth, pHeight, width - oWidth, yLoc, 0, 0));
		// row 3
		yLoc -= (pHeight + buffer)*2;
		oWidth = pWidth;
		obstacles.add(new Obstacle(oWidth, pHeight, buffer, yLoc, 10, 0));
		//row 4
		yLoc -= (pHeight + buffer);
		oWidth = pWidth*2;
		obstacles.add(new Obstacle(oWidth, pHeight, buffer, yLoc, 20, 0));
		
	}
	
	public void updateFroggerState() { //Updates the logical state of the frogger game
		int oldX = player.xloc;
		int oldY = player.yloc;
		
		if(Key.up.isDown) player.yJump(true);
		if(Key.left.isDown) player.xJump(false);
		if(Key.right.isDown) player.xJump(true);
		if(Key.down.isDown) player.yJump(false);
		
		updateFroggerObsticles();
		
		if(wallCollision(player)) { //If the player collides with a wall, they appear not to move
			player.xloc = oldX;
			player.yloc = oldY;
		}
		
		else if (playerAndObsticleCollision()) { //If the player collides with an obstacle, they return to start
			player.xloc = player.froggerStartX;
			player.yloc = player.froggerStartY;
		}
		
		if(froggerEnd()) { //When the player reaches the end, the game stops
			isPlaying = false;
		}
	}

	private boolean froggerEnd() {
		if(player.yloc < player.height)
			return true;
		return false;
	}
	
	public void updateFroggerObsticles() { //Updates the logical locations of the frogger obstacles
		boolean collide;
		for(Obstacle o : obstacles) {
			o.move();
			if(wallCollision(o)) o.xvel *= -1;
		}
	}
	
	public void startFoodGame(){ //Begins the logic necessary for the food diving game
		obstacles = null;
		objectives = new ArrayList<Objective>();
		isPlaying = true;
		player = new Player(70,70,250,50,0,0,0);
		objectives.add(new Objective(50, 50, 300, 250, 0,0,false, 0));
	}
	public void updateFoodGameState(){ //Updates the logical state of the food diving game
		int flyHeight = 50;
		int foodHeight = 250;
		if(player.yloc == foodHeight) {
			eatFood();
			player.dive(flyHeight);
		}
		else {
			if (Key.space.isDown) {
				player.dive(foodHeight);
			}
			if (Key.left.isDown)
				player.xJump(false);
			if (Key.right.isDown)
				player.xJump(true);
			if (player.getPoints() > 0) {
				isPlaying = false;
			}
		}
		System.out.println(player.xloc + ", " + player.yloc);
	}
	public void eatFood() { //Detects to see if player has collided with objective and takes appropriate action
		Iterator<Objective> objIt = objectives.iterator();
		Objective o;
		while(objIt.hasNext()) {
			o = objIt.next();
			if(collision(o, player)) {
				player.addPoints(1);
				//objectives.remove(o); 
			}
		}
	}
	public void startFlappyBird() { //Begins logic for flappy bird game
		isPlaying = true;
		player = new Player(50, 50, 50, 50, 0, 0, 0);
		objectives = new ArrayList<Objective>();
		objectives.add(new Objective(20, 20, frameWidth-20, frameHeight/2, 0, 0, false, 0));
	}
	
	public void updateFlappyBirdGameState() { //Updates logic for flappy bird game
		if(Key.space.isDown) player.yloc-=40;
		player.yloc+=8;
		if(!wallCollision(player)) {
			player.xloc+=6;
		}
		if(collision(player, objectives.get(0))) {
			isPlaying = false;
		}
		
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void setPlayer(GameObject go) {
		this.player=(Player)go;
	}
	public ArrayList<Objective> getObjectives(){
		return objectives;
	}
	public ArrayList<Obstacle> getObstacles(){
		return obstacles;
	}
	



}
