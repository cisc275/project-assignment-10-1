package mainpkg;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class View extends JPanel{
	private int frameWidth = 500; //TODO: have this adjust per display
	private int frameHeight = 325;
	private int frameCount;
	static JFrame frame;
	private int picNum;

	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	
	public View(){
		resetFrame();
	}
	
	public void loadImages(){
		
	}
	
	public void update(){
		try {
			frame.repaint();
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		if (!gameObjects.isEmpty()) {
			for (GameObject o : gameObjects) {
				g.setColor(o.getColor());
				g.fillRect(o.xloc, o.yloc, o.width, o.height);
			}
		}
	}
	
	public int getframeWidth(){
		return frameWidth;
	}
	
	public int getframeHeight(){
		return frameHeight;
	}

	public void startBirdSelection() {
	//	frame.requestFocus();
		frame.setVisible(true);
		JTextArea title = new JTextArea("Select a bird. Press enter to proceed");
		frame.add(title, BorderLayout.PAGE_START);
	}
	
	public void resetFrame() {
		frame = new JFrame();
    	frame.getContentPane().add(this);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	frame.setFocusable(false);
    	requestFocus();
	}

	public void startFrogger(Player player, ArrayList<Obstacle> obsticles) {
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(player);
		for(Obstacle o : obsticles) {
			gameObjects.add(o);
		}
		
	}
  public void startFoodGame(Player player, ArrayList<Objective> objectives){
		gameObjects.add(player);
		for(Objective o: objectives){
			gameObjects.add(o);
		}
	}
  public void startFlappyBird(Player player) { // we can add obstacles after alpha
	  gameObjects.add(player);
  }
	
}
