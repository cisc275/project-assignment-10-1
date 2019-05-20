package mainpkg;


import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextArea;

public class MapView extends View {
	
	public int legnum;
	
	
	public void showMap(boolean isEnd) {
		// Map shown inbetween games. Works by grabbing the system time in milliseconds,
		// adding 5000, and then counting down 1 second every second. Effectively keeping
		// the map screen up for 5 seconds.
		long tEnd = System.currentTimeMillis();
		frame.setVisible(true);
		long tStart = tEnd + 3*1000;
		while(tStart > tEnd) {
			tStart -= 1000;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	public void paint(Graphics g) {
		// putting the map image on the screen during the duration of the timer.
		if(isOsprey){
			if(legnum==1){
				g.drawImage(AmericaMap1, 0, 0, frameWidth, frameHeight, this);
			}
			else if(legnum==2){
				g.drawImage(AmericaMap2, 0, 0, frameWidth, frameHeight, this);
			}
			else if (legnum==3){
				g.drawImage(AmericaMap3, 0, 0, frameWidth, frameHeight, this);
			}
			else{
				g.drawImage(OspreyEnd,0,0,frameWidth,frameHeight,this);
				g.drawImage(Win,frameWidth/2,frameHeight/2,frameWidth/4,frameHeight/4,this);
				g.setFont(new Font("Times New Roman", Font.BOLD, 48));
				g.drawString("Score: " + Model.player.getPoints(), (frameWidth/2)-frameWidth*30/100, (frameHeight/2));
			}
		}
		else{
			if(legnum==1){
				g.drawImage(DelawareMap1, 0, 0, frameWidth, frameHeight, this);
			}
			else if(legnum==2){
				g.drawImage(DelawareMap2, 0, 0, frameWidth, frameHeight, this);
			}
			else if (legnum==3){
				g.drawImage(DelawareMap3, 0, 0, frameWidth, frameHeight, this);
			}
			else{
				g.drawImage(NHEnd,0,0,frameWidth,frameHeight,this);
				g.drawImage(Win,frameWidth/2,frameHeight/2,frameWidth/4,frameHeight/4,this);
				g.setFont(new Font("Times New Roman", Font.BOLD, 48));
				g.drawString("Score: " + Model.player.getPoints(), (frameWidth/2)-frameWidth*15/100, frameWidth/2);
				
			}
		}
	}
}
		
