package mainpkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;


public class Controller implements KeyListener,ActionListener {

	private Model model;
	private View view;
	private BirdSelectorView vBird;
	private MapView vMap;
	private FroggerView vFrogger;
	private FoodGameView vFood;
	private FlappyBirdView vFlappy;
	private QuizView vQuiz;
	private BirdSelectorModel mBird;
	private MapModel mMap;
	private FroggerModel mFrogger;
	private FoodGameModel mFood;
	private FlappyBirdModel mFlappy;
	private QuizModel mQuiz;
	public HashMap<Integer, Key> keyBindings = new HashMap<Integer, Key>();
	public static boolean other[] = new boolean[256];
	private boolean isRight=true;
	
	public Controller(){
		view = new View();
		model = new Model(view.getWidth(), view.getWidth());
		
		bind(KeyEvent.VK_ENTER, Key.enter);
		bind(KeyEvent.VK_UP, Key.up);
		bind(KeyEvent.VK_LEFT, Key.left);
		bind(KeyEvent.VK_RIGHT, Key.right);
		bind(KeyEvent.VK_DOWN, Key.down);
		bind(KeyEvent.VK_SPACE, Key.space);
	}
	
	public void start() throws InterruptedException{
		// main method for running game. Starts all the views and models for each game.
		// runs through the maps inbetween and everything. runs with booleans and while
		// loops so that you stay within a game while isPlaying is true.
		
		view.addKeyListener(this);
	
		selectBird();
		
		seeMap(1);
		
		playFrogger();
		
		takeQuiz(1);		
		
		seeMap(2);

		playFood();
		
		takeQuiz(2);
		
		seeMap(3);
		
		playFlappy();		
		
		takeQuiz(3);
		
		seeMap(4);
		
	}
	public static void main(String[] args) throws InterruptedException{
		// makes the controller and calls the start method onto it. This starts the game.
		Controller c = new Controller();
		c.start();
	}
	
	public void selectBird() {
		//BirdSelection - START
		//---------------------------------------------------------
		vBird = new BirdSelectorView();
		mBird = new BirdSelectorModel(vBird.getWidth(), vBird.getHeight());
		mBird.needInput = true;
		vBird.startBirdSelection();
		vBird.leftbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View.isOsprey = true;
				mBird.needInput = false;
			}
		});
		vBird.rightbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View.isOsprey = false;
				mBird.needInput = false;
			}
		});
		while(mBird.needInput) {
			//update model and view
			//wait for user to select bird
			vBird.update();
		}
		vBird.resetFrame();
	}
	
	public void playFrogger() {
		//Frogger - START
		//------------------------------------------------------------
		vFrogger = new FroggerView();
		vFrogger.isTutorial = true;
		vFrogger.addKeyListener(this);
		mFrogger = new FroggerModel(vFrogger.getWidth(), vFrogger.getHeight());
		startFrogger(vFrogger.isTutorial);
		int startingX = mFrogger.player.xloc;
		int startingY = mFrogger.player.yloc;
		while(mFrogger.isPlaying) {
			mFrogger.updateFroggerState(startingX, startingY, vFrogger.isTutorial);
			vFrogger.update();
		}
		vFrogger.resetFrame();
		vFrogger.isTutorial = false;
		
		vFrogger = new FroggerView();
		vFrogger.addKeyListener(this);
		mFrogger = new FroggerModel(vFrogger.getWidth(), vFrogger.getHeight());
		startFrogger(vFrogger.isTutorial);
		while(mFrogger.isPlaying) {
			mFrogger.updateFroggerState(startingX, startingY, vFrogger.isTutorial);
			vFrogger.update();
		}
		model.player.addPoints(1000);
		vFrogger.resetFrame();		
	}
	
	public void playFood() {
		//FoodGame - START
		//------------------------------------------------------------
		vFood = new FoodGameView();
		vFood.isTutorial = true;
		vFood.addKeyListener(this);
		mFood = new FoodGameModel(vFood.getframeWidth(), vFood.getframeHeight());
		startFoodGame(vFood.isTutorial);
		int timer = 5000;
		while(mFood.isPlaying){
			mFood.updateFoodGameState(timer, vFood.isTutorial);
			vFood.foodGame(mFood.getPlayer(), mFood.getObjectives());
			vFood.update();
			timer--;
		}
		vFood.isTutorial = false;
		
		vFood = new FoodGameView();
		vFood.addKeyListener(this);
		mFood = new FoodGameModel(vFood.getframeWidth(), vFood.getframeHeight());
		startFoodGame(vFood.isTutorial);
		timer = 200;
		while(mFood.isPlaying){
			mFood.updateFoodGameState(timer, vFood.isTutorial);
			vFood.foodGame(mFood.getPlayer(), mFood.getObjectives());
			vFood.update();
			timer--;
		}
		model.player.addPoints(1000);
	}
	
	public void playFlappy() {
		//FlappyBird - START
		//-------------------------------------------------------------
		vFlappy = new FlappyBirdView();
		vFlappy.isTutorial = true;
		vFlappy.addKeyListener(this);
		mFlappy = new FlappyBirdModel(vFlappy.getframeWidth(), vFlappy.getframeHeight());
		startFlappyBird(vFlappy.isTutorial);
		int startingX = mFlappy.player.xloc;
		int startingY = mFlappy.player.yloc;
		while(mFlappy.isPlaying){
			mFlappy.updateFlappyBirdGameState(startingX, startingY, vFlappy.isTutorial);
			vFlappy.update();
		}
		
		vFlappy.isTutorial = false;
		vFlappy = new FlappyBirdView();
		vFlappy.addKeyListener(this);
		mFlappy = new FlappyBirdModel(vFlappy.getframeWidth(), vFlappy.getframeHeight());
		startFlappyBird(vFlappy.isTutorial);
		startingX = mFlappy.player.xloc;
		startingY = mFlappy.player.yloc;
		while(mFlappy.isPlaying){
			mFlappy.updateFlappyBirdGameState(startingX, startingY, vFlappy.isTutorial);
			vFlappy.update();
		}
		model.player.addPoints(1000);
	}
	
	public void takeQuiz(int number) {
		boolean quizOn = true;
		if(number == 1) {
			//Quiz 1 - START
			//-----------------------------------------------------------
			vQuiz = new QuizView();
			mQuiz = new QuizModel(vQuiz.getWidth(), vQuiz.getHeight());
			vQuiz.startQuiz(number); //First quiz!
			while(quizOn) { 
				// Answer is A. 
				if (vQuiz.Answer.equals("A")) {
					model.player.addPoints(100);
					quizOn = false;
				}
				else if (vQuiz.Answer.equals("B") || vQuiz.Answer.equals("C") || vQuiz.Answer.equals("D")) {
					model.player.addPoints(-50);
					vQuiz.panel.add(vQuiz.wrong);
				}
				vQuiz.update();
			}
			vQuiz.resetFrame();
		}
		else if(number == 2) {
			//Quiz 2 - START
			//-----------------------------------------------------------
			vQuiz = new QuizView();
			mQuiz = new QuizModel(vQuiz.getWidth(), vQuiz.getHeight());
			quizOn = true;
			vQuiz.startQuiz(number); //Second quiz!
			while(quizOn) {  
				// Answer is B. 
				if (vQuiz.Answer.equals("B")) {
					model.player.addPoints(100);
					quizOn = false;
				}
				else if (vQuiz.Answer.equals("A") || vQuiz.Answer.equals("C") || vQuiz.Answer.equals("D")) {
					model.player.addPoints(-50);
					vQuiz.panel.add(vQuiz.wrong);
				}
				vQuiz.update();
			}
			vQuiz.resetFrame();
		}
		else {
			//Quiz 3 - START
			//-----------------------------------------------------------
			vQuiz = new QuizView();
			mQuiz = new QuizModel(vQuiz.getWidth(), vQuiz.getHeight());
			quizOn = true;
			vQuiz.startQuiz(number); //Last quiz!
			while(quizOn) {  
				// Answer is C. 
				if (vQuiz.Answer.equals("C")) {
					model.player.addPoints(100);
					quizOn = false;
				}
				else if (vQuiz.Answer.equals("A") || vQuiz.Answer.equals("B") || vQuiz.Answer.equals("D")) {
					model.player.addPoints(-50);
					vQuiz.panel.add(vQuiz.wrong);
				}
				vQuiz.update();
			}
			vQuiz.resetFrame();
		}
	}
	
	public void seeMap(int number) {
		//Go to Map 
		//------------------------------------------------------------	
		vMap = new MapView();
		vMap.legnum = number;
		mMap = new MapModel(vMap.getframeWidth(), vMap.getframeHeight());
		vMap.addKeyListener(this);
		vMap.showMap(false);
		vMap.resetFrame();
	}
	
	public void keyPressed(KeyEvent e){
		// passes the KeyEvent into the keyBindings collections.
		// prints out to show when a key was pressed
		other[e.getExtendedKeyCode()] = true;
		keyBindings.get(e.getKeyCode()).isDown = true;
	}
	public void keyReleased(KeyEvent e) {
		// passes KeyEvent into the keyBindings collection.
		
		other[e.getExtendedKeyCode()] = false;
	    keyBindings.get(e.getKeyCode()).isDown = false;
				
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void bind(Integer keyCode, Key key) {
		keyBindings.put(keyCode, key);
	}
	
	public void startFoodGame(boolean tutorial){
		//runs view and model for food game
		if (tutorial) {
			mFood.startFoodGameTutorial();
			vFood.foodGame(mFood.getPlayer(), mFood.getObjectives());
		}
		else {
			mFood.startFoodGame();
			vFood.foodGame(mFood.getPlayer(), mFood.getObjectives());
		}
	}
	
	public void startFrogger(boolean tutorial) {
		//runs view and model for frogger game
		if (tutorial == true) {
			mFrogger.startFroggerTutorial();
			vFrogger.startFrogger(mFrogger.getPlayer(), mFrogger.getObstacles());
		}
		else {
			mFrogger.startFrogger();
			vFrogger.startFrogger(mFrogger.getPlayer(), mFrogger.getObstacles());
		}
	}
	
	public void startFlappyBird(boolean tutorial) {
		//runs view and model for flappy game
		if (tutorial) {
			mFlappy.startFlappyBirdTutorial(View.isOsprey);
			vFlappy.startFlappyBird(mFlappy.getPlayer(), mFlappy.getObjectives(), mFlappy.getObstacles());
		}
		else {
			mFlappy.startFlappyBird(View.isOsprey);
			vFlappy.startFlappyBird(mFlappy.getPlayer(), mFlappy.getObjectives(), mFlappy.getObstacles());
		}
	}
}
