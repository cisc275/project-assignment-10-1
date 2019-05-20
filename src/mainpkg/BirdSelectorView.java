package mainpkg;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BirdSelectorView extends View{
	
	public JButton leftbutton;
	public JButton rightbutton;
	
	public BirdSelectorView(){
		super();
		//NHSelection = createImage("GamePictures/BirdSelect/NorthernHarrier.jpg");
		//OspreySelection = createImage("GamePictures/BirdSelect/Osprey.jpg");
		Selection = createImage("GamePictures/BirdSelect/Background.jpg");
	}
	
	public void startBirdSelection() {
	//	frame.requestFocus();
		frame.paint(getGraphics());
		JTextArea title = new JTextArea("Select a bird.");
		this.leftbutton = new JButton();
		this.rightbutton = new JButton();
		this.leftbutton.setHorizontalTextPosition(JButton.CENTER);
		this.leftbutton.setVerticalTextPosition(JButton.CENTER);
		
		this.leftbutton.setFont(new Font("Arial", Font.PLAIN, 50));
		this.rightbutton.setFont(new Font("Arial", Font.PLAIN, 50));
		
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.setLayout(null);
		
		ImageIcon Osprey = new ImageIcon("GamePictures/BirdSelect/Osprey.jpg");
		ImageIcon NH = new ImageIcon("GamePictures/BirdSelect/NorthernHarrier2.jpg");
		
		//Set size and location of buttons here
		//this.leftbutton.setSize(500,100);
	    //this.leftbutton.setLocation(frameWidth/4, frameHeight/4);
	    //this.rightbutton.setSize(500,100);
	    //this.rightbutton.setLocation(frameWidth - (frameWidth/2), frameHeight - (frameHeight/2));
		this.leftbutton.setSize(frameWidth/2, frameHeight);
		this.leftbutton.setLocation(0,0);
		this.rightbutton.setSize(frameWidth/2,frameHeight);
		this.rightbutton.setLocation(frameWidth/2,0);
		this.leftbutton.setIcon(new ImageIcon(Osprey.getImage().getScaledInstance(frameWidth/2, frameHeight, java.awt.Image.SCALE_SMOOTH)));
	    this.rightbutton.setIcon(new ImageIcon(NH.getImage().getScaledInstance(frameWidth/2, frameHeight, java.awt.Image.SCALE_SMOOTH)));
		panel.add(leftbutton);
		panel.add(rightbutton);
		frame.add(panel);
		frame.add(title, BorderLayout.PAGE_START);
		frame.setVisible(true);
		
	}
//	public void paint(Graphics g){
//		g.drawImage(Selection,0,0,frameWidth,frameHeight,this);
//	}
}