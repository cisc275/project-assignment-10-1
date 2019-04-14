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
		if (e.getKeyCode()==39){//Right arrow key pressed
			model.changeplayRight();
			model.updateLocation();
			view.update();
		}
		else if(e.getKeyCode()==37){//Left arrow key pressed
			model.changeplayLeft();
			model.updateLocation();
			view.update();
		}
		else if(e.getKeyCode()==38){//Up arrow key pressed
			model.changeplayUp();
			model.updateLocation();
			view.update();
		}
		else if(e.getKeyCode()==40){//Down arrow key pressed
			model.changeplayDown();
			model.updateLocation();
			view.update();
		}
	}
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode()==39){//Right arrow key is released
			model.updateLocation();
			view.update();
		}
		else if(arg0.getKeyCode()==37){//left arrow key is released
			model.changeplayLeft();
			model.updateLocation();
			view.update();
		}
		else if(arg0.getKeyCode()==38){//up arrow key is released
			model.changeplayUp();
			model.updateLocation();
			view.update();
		}
		else if(arg0.getKeyCode()==40){//down arrow key is released
			model.changeplayDown();
			model.updateLocation();
			view.update();
		}
		
				
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
