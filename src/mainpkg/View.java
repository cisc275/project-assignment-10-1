package mainpkg;


import java.awt.Color;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.JFrame;


public class View extends JPanel{
	private int frameWidth;
	private int frameHeight;
	private int frameCount;
	static JFrame frame;
	
	private int picNum;
	private List<GameObject> gameObjects;
	
	public View(){
		frame = new JFrame();
    	frame.getContentPane().add(this);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
	}
	
	public void loadImages(){
		
	}
	
	public void update(){
		
	}
	
	public void paint(){
		
	}
	
	public int getframeWidth(){
		return frameWidth;
	}
	
	public int getframeHeight(){
		return frameHeight;
	}

}
