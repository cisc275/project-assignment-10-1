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
		model = new Model(view.getWidth(), view.getWidth(), 0);
		
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
		//BirdSelection - START
		//---------------------------------------------------------

		System.out.println("start bird selection");
		vBird = new BirdSelectorView();
		mBird = new BirdSelectorModel(vBird.getWidth(), vBird.getHeight(), 0);
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
			//if(Key.enter.isDown) //move this to model or have it call a method
				//mBird.needInput = false;
		}
		vBird.resetFrame();
		//System.out.println("end of bird selection");
	
		//Go to Map 
		//------------------------------------------------------------	
		//System.out.println("map is showing");
		vMap = new MapView();
		vMap.legnum = 1;
		mMap = new MapModel(vMap.getframeWidth(), vMap.getframeHeight(), 0);
		vMap.addKeyListener(this);
		vMap.showMap(false);
		vMap.resetFrame();
		//Go to Map - START
		//------------------------------------------------------------
		
		
		
		//Frogger - START
		//------------------------------------------------------------
		System.out.println("Start of frogger tutorial");
		vFrogger = new FroggerView();
		vFrogger.isTutorial = true;
		vFrogger.addKeyListener(this);
		mFrogger = new FroggerModel(vFrogger.getWidth(), vFrogger.getHeight(), 0);
		startFrogger(true);
		int startingX = mFrogger.player.xloc;
		int startingY = mFrogger.player.yloc;
		while(mFrogger.isPlaying) {
			mFrogger.updateFroggerState(startingX, startingY);
			vFrogger.update();
		}
		//vFrogger.delete();
		vFrogger.resetFrame();
		
		
		System.out.println("start of frogger");
		vFrogger = new FroggerView();
		vFrogger.addKeyListener(this);
		mFrogger = new FroggerModel(vFrogger.getWidth(), vFrogger.getHeight(), 0);
		startFrogger(false);
		while(mFrogger.isPlaying) {
			mFrogger.updateFroggerState(startingX, startingY);
			vFrogger.update();
		}
		//vFrogger.delete();
		model.player.addPoints(1000);
		vFrogger.resetFrame();
		//System.out.println("end of frogger");
		
		

		//Quiz 1 - START
		//-----------------------------------------------------------
		
		
		//System.out.println("Quiz 1");
		vQuiz = new QuizView();
		mQuiz = new QuizModel(vQuiz.getWidth(), vQuiz.getHeight(), 0);
		boolean quizOn = true;
		vQuiz.startQuiz(1); //First quiz!
		
		while(quizOn) { // Answer is A. Will expand this so that it's more obvious when you answer incorrectly
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
		//System.out.println("end of quiz");
		
		
		
		//Go to Map 
		//------------------------------------------------------------			
		//System.out.println("map is showing");
		vMap = new MapView();
		vMap.legnum=2;
		mMap = new MapModel(vMap.getframeWidth(), vMap.getframeHeight(), 0);
		vMap.addKeyListener(this);
		vMap.showMap(false);
		vMap.resetFrame();

		
		//FoodGame - START
		//------------------------------------------------------------
		//tutorial
		vFood = new FoodGameView();
		vFood.isTutorial = true;
		vFood.addKeyListener(this);
		mFood = new FoodGameModel(vFood.getframeWidth(), vFood.getframeHeight(), 0);
		startFoodGame(true);
		int timer = 100;
		while(mFood.isPlaying){
			mFood.updateFoodGameState(timer);
			vFood.foodGame(mFood.getPlayer(), mFood.getObjectives());
			vFood.update();
			timer--;
			System.out.println(timer);
		}
		
		//System.out.println("start foodGame");
		vFood = new FoodGameView();
		vFood.addKeyListener(this);
		mFood = new FoodGameModel(vFood.getframeWidth(), vFood.getframeHeight(), 0);
		startFoodGame(false);
		timer = 200;
		while(mFood.isPlaying){
			mFood.updateFoodGameState(timer);
			vFood.foodGame(mFood.getPlayer(), mFood.getObjectives());
			vFood.update();
			timer--;
			System.out.println(timer);
		}
		//vFood.delete();
		//System.out.println("end foodGame");
		model.player.addPoints(1000);
		
		
		
		//Quiz 2 - START
		//-----------------------------------------------------------
		
		
		//System.out.println("Quiz 2");
		vQuiz = new QuizView();
		mQuiz = new QuizModel(vQuiz.getWidth(), vQuiz.getHeight(), 0);
		quizOn = true;
		vQuiz.startQuiz(2); //Second quiz!
		
		while(quizOn) {  // Answer is B. Will expand this so that it's more obvious when you answer incorrectly
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
		//System.out.println("end of quiz");
		
		//Go to Map 
		//------------------------------------------------------------			
		//System.out.println("map is showing");
		vMap = new MapView();
		vMap.legnum=3;
		mMap = new MapModel(vMap.getframeWidth(), vMap.getframeHeight(), 0);
		vMap.addKeyListener(this);
		vMap.showMap(false);
		vMap.resetFrame();
		
		//FlappyBird - START
		//-------------------------------------------------------------
		//tutorial
		vFlappy = new FlappyBirdView();
		vFlappy.isTutorial = true;
		vFlappy.addKeyListener(this);
		mFlappy = new FlappyBirdModel(vFlappy.getframeWidth(), vFlappy.getframeHeight(), 0);
		startFlappyBird(true);
		startingX = mFlappy.player.xloc;
		startingY = mFlappy.player.yloc;
		while(mFlappy.isPlaying){
			mFlappy.updateFlappyBirdGameState(startingX, startingY);
			vFlappy.update();
		}
		
		//System.out.println("Start flappy");
		vFlappy = new FlappyBirdView();
		vFlappy.addKeyListener(this);
		mFlappy = new FlappyBirdModel(vFlappy.getframeWidth(), vFlappy.getframeHeight(), 0);
		startFlappyBird(false);
		startingX = mFlappy.player.xloc;
		startingY = mFlappy.player.yloc;
		while(mFlappy.isPlaying){
			mFlappy.updateFlappyBirdGameState(startingX, startingY);
			vFlappy.update();
		}
		//vFlappy.delete();
		model.player.addPoints(1000);
		//System.out.println("end flappy");
		
		
		//Quiz 3 - START
		//-----------------------------------------------------------
		System.out.println("Quiz 3");
		vQuiz = new QuizView();
		mQuiz = new QuizModel(vQuiz.getWidth(), vQuiz.getHeight(), 0);
		quizOn = true;
		vQuiz.startQuiz(3); //Last quiz!
		
		while(quizOn) {  // Answer is C. Will expand this so that it's more obvious when you answer incorrectly
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
		//System.out.println("end of quiz");
		
		//Go to Map 
		//------------------------------------------------------------
		//System.out.println("map is showing");
		vMap.legnum=4;
		vMap.showMap(true);
		
		vMap.resetFrame();
		

		//System.out.println("END OF GAME");

	}
	public static void main(String[] args) throws InterruptedException{
		// makes the controller and calls the start method onto it. This starts the game.
		Controller c = new Controller();
		c.start();
	}
	
	
	public void keyPressed(KeyEvent e){
		// passes the KeyEvent into the keyBindings collections.
		// prints out to show when a key was pressed
		//System.out.println("pressed");
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
	public void actionPerformed(ActionEvent e) {
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
			mFrogger.startFroggerTutorial(view.getWidth(), view.getHeight());
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
