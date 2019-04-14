package mainpkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.*;


public class Controller implements KeyListener,ActionListener {

	private Model Model;
	private View View;
	
	public Controller(){
		View = new View();
		Model = new Model(View.getframeWidth(), View.getframeHeight(), 0);
	}
	
	public void start(){
		
	}
	public void main(String[] args){
		
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
