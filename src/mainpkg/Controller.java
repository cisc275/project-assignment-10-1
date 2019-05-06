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
	private BirdSelectorModel mBird;
	private MapModel mMap;
	private FroggerModel mFrogger;
	private FoodGameModel mFood;
	private FlappyBirdModel mFlappy;
	public HashMap<Integer, Key> keyBindings = new HashMap<Integer, Key>();
	public static boolean other[] = new boolean[256];
	
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
				model.isOsprey = true;
				mBird.needInput = false;
			}
		});

		vBird.rightbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.isOsprey = false;
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
		System.out.println("end of bird selection");
		
		//Go to Map 
		//------------------------------------------------------------	
		System.out.println("map is showing");
		vMap = new MapView();
		mMap = new MapModel(vMap.getframeWidth(), vMap.getframeHeight(), 0);
		vMap.addKeyListener(this);
		vMap.showMap(false);
		vMap.resetFrame();
		
		//Frogger - START
		//------------------------------------------------------------
		System.out.println("start of frogger");
		vFrogger = new FroggerView();
		vFrogger.addKeyListener(this);
		mFrogger = new FroggerModel(vFrogger.getWidth(), vFrogger.getHeight(), 0);
		startFrogger();
		int startingX = mFrogger.player.xloc;
		int startingY = mFrogger.player.yloc;
		while(mFrogger.isPlaying) {
			mFrogger.updateFroggerState(startingX, startingY);
			vFrogger.update();
		}
		vFrogger.deletePlayer();
		vFrogger.resetFrame();
		System.out.println("end of frogger");
		
		//Go to Map 
		//------------------------------------------------------------			
		System.out.println("map is showing");
		vMap.showMap(false);
		vMap.resetFrame();
		
		//FoodGame - START
		//------------------------------------------------------------
		System.out.println("start foodGame");
		vFood = new FoodGameView();
		vFood.addKeyListener(this);
		mFood = new FoodGameModel(vFood.getframeWidth(), vFood.getframeHeight(), 0);
		startFoodGame();
		while(mFood.isPlaying){
			mFood.updateFoodGameState();
			vFood.foodGame(mFood.getPlayer(), mFood.getObjectives());
			vFood.update();
		}
		vFood.deletePlayer();
		System.out.println("end foodGame");
		
		//Go to Map 
		//------------------------------------------------------------			
		System.out.println("map is showing");
		vMap.showMap(false);
		vMap.resetFrame();
		
		//FlappyBird - START
		//-------------------------------------------------------------
		System.out.println("Start flappy");
		vFlappy = new FlappyBirdView();
		vFlappy.addKeyListener(this);
		mFlappy = new FlappyBirdModel(vFlappy.getframeWidth(), vFlappy.getframeHeight(), 0);
		startFlappyBird();
		startingX = mFlappy.player.xloc;
		startingY = mFlappy.player.yloc;
		while(mFlappy.isPlaying){
			mFlappy.updateFlappyBirdGameState(startingX, startingY);
			vFlappy.update();
		}
		vFlappy.deletePlayer();
		System.out.println("end flappy");
		
		//Go to Map 
		//------------------------------------------------------------
		System.out.println("map is showing");
		vMap.showMap(true);
		vMap.resetFrame();
		
		
		System.out.println("END OF GAME");
	}
	public static void main(String[] args) throws InterruptedException{
		Controller c = new Controller();
		c.start();
	}
	
	
	public void keyPressed(KeyEvent e){
		System.out.println("pressed");
		other[e.getExtendedKeyCode()] = true;
		keyBindings.get(e.getKeyCode()).isDown = true;
	}
	public void keyReleased(KeyEvent e) {
		
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
	public void startFoodGame(){
		mFood.startFoodGame();
		vFood.foodGame(mFood.getPlayer(), mFood.getObjectives());
	}
	
	public void startFrogger() {
		mFrogger.startFrogger(view.getWidth(), view.getHeight());
		vFrogger.startFrogger(mFrogger.getPlayer(), mFrogger.getObstacles());
	}
	
	public void startFlappyBird() {
		mFlappy.startFlappyBird(view.getWidth(), view.getHeight());
		vFlappy.startFlappyBird(mFlappy.getPlayer(), mFlappy.getObjectives(), mFlappy.getObstacles());
	}
}
