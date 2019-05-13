package mainpkg;

import java.awt.Graphics;

import javax.swing.JTextArea;

public class MapView extends View {
	
	public void showMap(boolean isEnd) throws InterruptedException {
		// Map shown inbetween games. Works by grabbing the system time in milliseconds,
		// adding 5000, and then counting down 1 second every second. Effectively keeping
		// the map screen up for 5 seconds.

		long tEnd = System.currentTimeMillis();
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
	
	public void paint(Graphics g) {
		// putting the map image on the screen during the duration of the timer.
		g.drawImage(AmericaMap1, 0, 0, frameWidth, frameHeight, this);
	}

}
