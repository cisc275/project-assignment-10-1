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
	protected boolean isOsprey;
	BufferedImage[] playerRight;
	BufferedImage[] playerLeft;
	BufferedImage AmericaMap1;
	BufferedImage AmericaMap2;
	BufferedImage AmericaMap3;
	BufferedImage DelawareMap1;
	BufferedImage DelawareMap2;
	BufferedImage DelawareMap3;
	BufferedImage Background;
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
	BufferedImage fishLeft;
	BufferedImage fishRight;
	BufferedImage nest;
	BufferedImage twig;
	BufferedImage NHSelection;
	BufferedImage OspreySelection;
	
	

	protected ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	
	public View(){
		playerRight= new BufferedImage[10];
		playerLeft= new BufferedImage[10];
		//mouseLeft = new BufferedImage[10];
		//mouseRight = new BufferedImage[10];
		AmericaMap1 = createImage("GamePictures/Maps/America/Blank.jpg");
		AmericaMap2 = createImage("GamePictures/Maps/America/AfterGame1.jpg");
		AmericaMap3 = createImage("GamePictures/Maps/America/AfterGame2.jpg");
		DelawareMap1 = createImage("GamePictures/Maps/Delaware/Blank.jpg");
		DelawareMap2 = createImage("GamePictures/Maps/Delaware/AfterGame1.jpg");
		DelawareMap3 = createImage("GamePictures/Maps/Delaware/AfterGame2.jpg");
		
		
		
		
		
		
		frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		frame.setFocusable(false);
		requestFocus();
	}
	
//	public void loadImages(Objective o){
//		
//	}
//	public void loadImages(Obstacle o){
//		
//	}
//	public void loadImages(Player p){
//		
//	}
//	
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
				//g.setColor(o.getColor());
				//g.fillRect(o.xloc, o.yloc, o.width, o.height);
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
	
  
  protected void deletePlayer(){
	  for(int i=0;i<10;i++){
		  playerRight[i]=null;
		  playerLeft[i]=null;
	  }
  }
	
}
