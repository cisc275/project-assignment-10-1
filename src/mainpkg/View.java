package mainpkg;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
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
	BufferedImage[] playerRight;
	BufferedImage[] playerLeft;
	BufferedImage mountainLeft;
	BufferedImage mountainRight;
	BufferedImage drone;
	BufferedImage powerLine;
	BufferedImage planeRight;
	BufferedImage planeLeft;
	BufferedImage crowLeft;
	BufferedImage crowRight;
	BufferedImage[] mouseLeft;
	BufferedImage[] mouseRight;
	BufferedImage NHSelection;
	BufferedImage OspreySelection;
	
	

	protected ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	
	public View(){
		playerRight= new BufferedImage[10];
		playerLeft= new BufferedImage[10];
		mountainLeft = createImage("GamePictures/Obstacles/MountairnSmallonLeft.png");
		mountainRight = createImage("GamePictures/Obstacles/MountainSmallonRight.png");
		drone = createImage("GamePictures/Obstacles/Drone.jpg");
		powerLine = createImage("GamePictures/Obstacles/PowerLine.png");
		planeLeft = createImage("GamePictures/Obstacles/AirplaneLeft.png");
		planeRight = createImage("GamePictures/Obstacles/AirplaneRight.png");
		crowLeft = createImage("GamePictures/Obstacles/CrowLeft.png");
		crowRight = createImage("GamePictures/Obstacles/CrowRight.png");
		NHSelection = createImage("GamePictures/BirdSelect/NortherHarrier.jpg");
		OspreySelection = createImage("GamePictures/BirdSelect/Osprey.jpg");
		
		
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

	private BufferedImage createImage(String file){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(file));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	}
	
  
  
	
}
