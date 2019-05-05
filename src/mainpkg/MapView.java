package mainpkg;

import java.awt.Color;
import java.util.Timer;

public class MapView extends View {
	
	public void showMap() throws InterruptedException {
		long tEnd = System.currentTimeMillis();
		frame.setBackground(Color.CYAN);
		frame.setVisible(true);
		long tStart = tEnd + 5*1000;
		while(tStart > tEnd) {
			tStart -= 1000;
			Thread.sleep(1000);
		}
	}

}
