package mainpkg;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FlappyBirdView extends View {
	public boolean isTutorial = false;
	
	public FlappyBirdView(){
		super();
		spaceBar = createImage("GamePictures/TutorialPics/spacebar.jpg");
		for(int i=0; i<10; i++){
			playerRight[i] = createImage("GamePictures/PlayerAnimation/NHSideLeft/Frame"+Integer.toString(i)+".png"); //Loads the frames for the player facing right animation
					}
		if(isOsprey){
			Background = createImage("GamePictures/Backgrounds/FoodAndFlappy/OspreyFoodGame.jpg"); //Loads the osprey flappy bird game background image
			tree = createImage("GamePictures/Obstacles/Tree2.png"); //Loads the tree image for the obstacles
			
		}
		else{
			Background = createImage("GamePictures/Backgrounds/FoodAndFlappy/NHFoodGame.jpg"); //Loads the northern harrier flappy bird game background image
			powerLine = createImage("GamePictures/Obstacles/PowerLine.png"); //Loads the power line image for the obstacles
		}
		nest = createImage("GamePictures/Objectives/Nest.png"); //Loads the image of the nest 
		twig = createImage("GamePictures/Objectives/Twig.png"); //Loads the image of the twig
	}

	public void startFlappyBird(Player player, ArrayList<Objective> objectives, ArrayList<Obstacle> obstacles) { //Creates a composite arraylist of all gameobjects at the start of the game
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(player);
		for(Objective o: objectives){
			System.out.println("added");
			gameObjects.add(o);
		}
		for(Obstacle o: obstacles) {
			System.out.println("added");
			gameObjects.add(o);
		}
	}
	
	public void paint(Graphics g){ //paints the current state of the game
		picNum=(picNum+1)%10; //Cycles through frame numbers
		g.drawImage(Background, 0, 0, frameWidth, frameHeight, this); //Draws the background on the bottom layer
		if (!gameObjects.isEmpty()) {
			if (isTutorial) {
				g.drawImage(spaceBar, frameWidth*88/100, frameHeight*14/100, frameWidth*1/10, frameHeight*1/10, this);
				g.drawString("Space to flap!", frameWidth*88/100, frameHeight*25/100);
				g.drawString("Make it to the end", frameWidth*88/100, frameHeight*28/100);
			}
			for (GameObject o : gameObjects) {
				if(o instanceof Player){
					g.drawImage(playerRight[picNum], o.xloc, o.yloc, o.width, o.height, this); //Draws the player, cycling through the frames to make it animated
				}
				else if(o instanceof Obstacle){
					if(isOsprey){ //Checks to see what bird the person is playing as
						g.drawImage(tree, o.xloc, o.yloc, o.width, o.height, this); //Draw obstacle as tree if osprey
					}
					else{
						g.drawImage(powerLine, o.xloc, o.yloc, o.width, o.height, this); //Draw obstacles as powerline if Northern Harrier
					}
				}
				else{
					g.drawImage(nest, o.xloc, o.yloc,o.width,o.height, this); //Draw the objective as the nest
				}
				//g.setColor(o.getColor());
				//g.fillRect(o.xloc, o.yloc, o.width, o.height);
			}
		}
		//if(!Tutorial) {
			g.setFont(new Font("Times New Roman", Font.BOLD, 48));
			g.drawString("Score: " + Model.player.getPoints(), frameWidth-(frameWidth*10/100), frameHeight*7/100);
		//}
	}
}
