package mainpkg;

import java.awt.BorderLayout;

import javax.swing.JTextArea;

public class BirdSelectorView extends View {

	

	public void startBirdSelection() {
		//	frame.requestFocus();
			frame.setVisible(true);
			JTextArea title = new JTextArea("Select a bird. Press enter to proceed");
			frame.add(title, BorderLayout.PAGE_START);
		}
}
