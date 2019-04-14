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
		for (int i = 0; i<5000; i++){
			model.updateGameState();
			view.update();
		}
	}
	public void main(String[] args){
		
	}

	public void keyPressed(KeyEvent e){
		if (e.getKeyCode()==39){//Right arrow key pressed
			
		}
		else if(e.getKeyCode()==37){//Left arrow key pressed
			
		}
		view.repaint();
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
