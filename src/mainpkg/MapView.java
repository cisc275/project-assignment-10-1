package mainpkg;

import java.awt.Color;
import java.util.Timer;

import javax.swing.JTextArea;

public class MapView extends View {
	
	public void showMap(boolean isEnd) throws InterruptedException {
		
		long tEnd = System.currentTimeMillis();
		frame.setBackground(Color.CYAN);
		frame.setVisible(true);
		long tStart = tEnd + 5*1000;
		if(isEnd) {
			JTextArea end = new JTextArea("You Win!!!!!!");
			frame.add(end);
		}
		while(tStart > tEnd) {
			tStart -= 1000;
			Thread.sleep(1000);
		
		}
	}

}
