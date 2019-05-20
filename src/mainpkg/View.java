package mainpkg;


import java.awt.BorderLayout;
import java.awt.CardLayout;
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
	protected int frameWidth = screensize.width; //TODO: have this adjust per display
	protected int frameHeight = screensize.height;
	private int frameCount;
	protected JFrame frame;
	protected int picNum;
	protected int picNum2;
	protected static boolean isOsprey;
	static BufferedImage[] playerRight;
	static BufferedImage[] playerLeft;
	static BufferedImage AmericaMap1;
	static BufferedImage AmericaMap2;
	static BufferedImage AmericaMap3;
	static BufferedImage DelawareMap1;
	static BufferedImage DelawareMap2;
	static BufferedImage DelawareMap3;
	static BufferedImage Background;
	static BufferedImage mountain;
	static BufferedImage drone;
	static BufferedImage powerLine;
	static BufferedImage planeRight;
	static BufferedImage planeLeft;
	static BufferedImage tree;
	static BufferedImage[] mouseLeft;
	static BufferedImage[] mouseRight;
	static BufferedImage[] foxRight;
	static BufferedImage[] foxLeft;
	static BufferedImage fishLeft;
	static BufferedImage fishRight;
	static BufferedImage nest;
	static BufferedImage twig;
	static BufferedImage Selection;
	static BufferedImage OspreyEnd;
	static BufferedImage NHEnd;
	static BufferedImage Win;
	static BufferedImage arrowKeys;
	static BufferedImage spaceBar;
	protected boolean isRight=true;
	

	protected ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	
	public View(){
		picNum = 0;
		picNum2 = 0;
		playerRight= new BufferedImage[10];
		playerLeft= new BufferedImage[10];
		foxRight = new BufferedImage[10];
		foxLeft = new BufferedImage[10];
		AmericaMap1 = createImage("GamePictures/Maps/America/Blank2.jpg");
		AmericaMap2 = createImage("GamePictures/Maps/America/Leg1.jpg");
		AmericaMap3 = createImage("GamePictures/Maps/America/Leg2.jpg");
		DelawareMap1 = createImage("GamePictures/Maps/Delaware/Blank.jpg");
		DelawareMap2 = createImage("GamePictures/Maps/Delaware/AfterGame1.jpg");
		DelawareMap3 = createImage("GamePictures/Maps/Delaware/AfterGame2.jpg");
		OspreyEnd = createImage("GamePictures/EndScreens/Osprey.jpg");
		NHEnd = createImage("GamePictures/EndScreens/NH.jpg");
		Win = createImage("GamePictures/EndScreens/uwin.png");
		mouseLeft = new BufferedImage[5];
		mouseRight = new BufferedImage[5];
		
		
		frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		frame.setFocusable(false);
		requestFocus();
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
				
				if(o instanceof Player){
					
				}
				else if(o instanceof Obstacle){
					
				}
				else{
					
				}
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
		frame = new JFrame();
		frame.getContentPane().removeAll();
    	frame.getContentPane().add(this);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	frame.setFocusable(false);
    	frame.dispose();
    	requestFocus();

	}
	public void checkDirect(){
		if(Key.left.isDown){
			isRight=false;
		}
		if(Key.right.isDown){
			isRight=true;
		}
	}
	protected BufferedImage createImage(String file){
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
