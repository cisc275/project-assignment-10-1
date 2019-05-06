package mainpkg;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;


public JButton leftbutton;
public JButton rightbutton;

public BirdSelectorView(){
		super();
		NHSelection = createImage("GamePictures/BirdSelect/NorthernHarrier.jpg");
		OspreySelection = createImage("GamePictures/BirdSelect/Osprey.jpg");
}
	
	
	public void startBirdSelection() {
		//	frame.requestFocus();
			JTextArea title = new JTextArea("Select a bird.");
			this.leftbutton = new JButton("Osprey");
			this.rightbutton = new JButton("Northern Harrier");
			
			this.leftbutton.setFont(new Font("Arial", Font.PLAIN, 50));
			this.rightbutton.setFont(new Font("Arial", Font.PLAIN, 50));
			JPanel panel = new JPanel(new GridLayout(1, 2));
			
			panel.add(leftbutton);
			panel.add(rightbutton);
			frame.add(panel);
			frame.add(title, BorderLayout.PAGE_START);
			frame.setVisible(true);
		}
}