package mainpkg;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class View extends JPanel{
	
	private Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	private int frameWidth = screensize.width; //TODO: have this adjust per display
	private int frameHeight = screensize.height;
	private int frameCount;
	static JFrame frame;
	private int picNum;

	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	
	public View(){
		frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		frame.setFocusable(false);
		requestFocus();
	}
	
	public void loadImages(){
		
	}
	
	public void update(){ //updates the visual state of the game
		try {
			frame.repaint();
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){ //paints the current state of the game
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

	public void startBirdSelection() { //begins the visuals for the bird selection portion of the game
	//	frame.requestFocus();
		JTextArea title = new JTextArea("Select a bird. Press enter to proceed");
		frame.add(title, BorderLayout.PAGE_START);
		frame.setVisible(true);
	}
	
	public void resetFrame() {
	//frame = new JFrame();
	frame.getContentPane().removeAll();
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
  public void foodGame(Player player, ArrayList<Objective> objectives){
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(player);
		for(Objective o: objectives){
			gameObjects.add(o);
		}
	}
  
  public void startFlappyBird(Player player, ArrayList<Objective> objectives) { // we can add obstacles after alpha
	  gameObjects = new ArrayList<GameObject>();
	  gameObjects.add(player);
	  for(Objective o: objectives){
		  System.out.println("added");
			gameObjects.add(o);
		}
  }
	
}
