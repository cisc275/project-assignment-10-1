package mainpkg;

import java.awt.BorderLayout;

import javax.swing.JTextArea;

public class BirdSelectorView extends View {

	public BirdSelectorView(){
		super();
		NHSelection = createImage("GamePictures/BirdSelect/NorthernHarrier.jpg");
		OspreySelection = createImage("GamePictures/BirdSelect/Osprey.jpg");
	}
	public void startBirdSelection() {
		//	frame.requestFocus();
			JTextArea title = new JTextArea("Select a bird. Press enter to proceed");
			frame.add(title, BorderLayout.PAGE_START);
			frame.setVisible(true);
		}
}
