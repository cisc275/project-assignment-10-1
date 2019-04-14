package mainpkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.*;


public class Controller implements KeyListener,ActionListener {

	private Model model;
	private View view;
	public HashMap<Integer, Key> keyBindings = new HashMap<Integer, Key>();
	public static boolean other[] = new boolean[256];
	
	public Controller(){
		view = new View();
		model = new Model(view.getframeWidth(), view.getframeHeight(), 0);
		
		bind(KeyEvent.VK_ENTER, Key.enter);
		bind(KeyEvent.VK_UP, Key.up);
		bind(KeyEvent.VK_LEFT, Key.left);
		bind(KeyEvent.VK_RIGHT, Key.right);
		bind(KeyEvent.VK_DOWN, Key.down);
	}
	
	public void start(){
		view.addKeyListener(this);
		
		//BirdSelection - START
		
		System.out.println("start bird selection");
		model.needInput = true;
		view.startBirdSelection();
		while(model.needInput) {
			//update model and view
			//wait for user to select bird
			view.update();
			if(Key.enter.isDown) //move this to model or have it call a method
				model.needInput = false;
		}
		view.resetFrame();
		System.out.println("end of bird selection");
		//BirdSelection - END
		startFoodGame();
		while(model.isPlaying){
			if(Key.space.isDown){
				model.player.dive(model.player.height,250);
				model.updateGameState();
				view.update();
			}
			else if(Key.right.isDown){
				model.player.xJump();
				model.updateGameState();
				view.update();
			}
			else if(Key.left.isDown){
				model.player.xJump();
				model.updateGameState();
				view.update();
			}
			else{
				model.updateGameState();
				view.update();
			}
			
		}
		
		
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
		System.out.println("pressed");
		other[e.getExtendedKeyCode()] = true;
		keyBindings.get(e.getKeyCode()).isDown = true;
//		
//		if (e.getKeyCode()==39){//Right arrow key pressed
//			model.changeplayRight();
//			model.updateLocation();
//			view.update();
//		}
//		else if(e.getKeyCode()==37){//Left arrow key pressed
//			model.changeplayLeft();
//			model.updateLocation();
//			view.update();
//		}
//		else if(e.getKeyCode()==38){//Up arrow key pressed
//			model.changeplayUp();
//			model.updateLocation();
//			view.update();
//		}
//		else if(e.getKeyCode()==40){//Down arrow key pressed
//			model.changeplayDown();
//			model.updateLocation();
//			view.update();
//		}
	}
	public void keyReleased(KeyEvent e) {
		
		other[e.getExtendedKeyCode()] = false;
	    keyBindings.get(e.getKeyCode()).isDown = false;
	    
//		if(e.getKeyCode()==39){//Right arrow key is released
//			model.updateLocation();
//			view.update();
//		}
//		else if(e.getKeyCode()==37){//left arrow key is released
//			model.changeplayLeft();
//			model.updateLocation();
//			view.update();
//		}
//		else if(e.getKeyCode()==38){//up arrow key is released
//			model.changeplayUp();
//			model.updateLocation();
//			view.update();
//		}
//		else if(e.getKeyCode()==40){//down arrow key is released
//			model.changeplayDown();
//			model.updateLocation();
//			view.update();
//		}
		
				
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void bind(Integer keyCode, Key key) {
		keyBindings.put(keyCode, key);
	}
	public void startFoodGame(){
		model.startFoodGame();
		view.startFoodGame(model.getPlayer(), model.getObjectives());
	}
	
}
