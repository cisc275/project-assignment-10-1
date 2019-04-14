package mainpkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.*;


public class Controller implements KeyListener,ActionListener {

	private Model model;
	private View view;
	
	public Controller(){
		view = new View();
		model = new Model(view.getframeWidth(), view.getframeHeight(), 0);
	}
	
	public void start(){
		//BirdSelection - START
		model.needInput = true;
		view.birdSelection();
		while(model.needInput) {
			//update model and view
			//wait for user to select bird
			for(int i = 0; i <10; i++) {
				view.update();
			}
			model.needInput = false;
		}
		//BirdSelection - END
		
		for (int i = 0; i<5000; i++){
			model.updateGameState();
			view.update();
		}
	}
	public static void main(String[] args){
		Controller c = new Controller();
		c.start();
	}

	public void keyPressed(KeyEvent e){
		
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
