package mainpkg;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ModelTest {

	@Test
	public void test() {
		
		int fw = 500;
		int fh = 325;
		
		Model myModel = new Model(fw, fh, 0);
		GameObject myObj1 = new Obstacle(100, 100, 250, 200, 0, 0,10);
		GameObject myObj2 = new Obstacle(100,100,250,0,0,0,10);
		GameObject myObj3 = new Obstacle(100,100,250,325,0,0,10);
		
		GameObject myObj4 = new Objective(100,100,0,200,0,0,false,0);
		GameObject myObj5 = new Objective(100,100,500,200,0,0,false,0);
		
		GameObject player = new Player(100,100,250,200,0,0,0);
		
		//wallCollision Testing
		assertFalse("shouldn't collide with anything", myModel.wallCollision(myObj1));
		assertTrue("Should collide with top wall",myModel.wallCollision(myObj2));
		assertTrue("Should collide with bottom wall", myModel.wallCollision(myObj3));
		assertTrue("Should collide with left wall", myModel.wallCollision(myObj4));
		assertTrue("Should collide with right wall", myModel.wallCollision(myObj5));
		assertTrue("Collision between player and obstacle",myModel.collision(player, myObj1));
		player.xloc =100;
		assertTrue("Collision between player and objective" ,myModel.collision(player, myObj4));
		
		//Testing startFrogger
		FroggerModel fModel = new FroggerModel(fw, fh, 0);
		assertFalse("myModel will not be playing before calling startFrogger", fModel.isPlaying);
		fModel.startFrogger();
		assertTrue("Should now be playing", fModel.isPlaying);
		
		//Testing updateFroggerState
		int startingX = 600;
		int startingY = 1000;
		fModel.updateFroggerState(startingX, startingY, false);
		assertTrue("isPlaying still true, froggerEnd() shouldn't pass", fModel.isPlaying);
		player.height = 201;
		fModel.setPlayer(player);
		fModel.updateFroggerState(startingX, startingY, false);
		assertFalse("Is playing should be false again", fModel.isPlaying);
		
		//Testing startFoodGame
		FoodGameModel gModel = new FoodGameModel(fw, fh, 0);
		gModel.startFoodGame();
		assertTrue("back to isPlaying", gModel.isPlaying);
		assertEquals("player should have new player values. Just checking height (70)", 70, gModel.getPlayer().height);
		
		//Keytesting
		Key.space.isDown = true;
		gModel.updateFoodGameState(1, false);
		Key.space.isDown = false;
		
		gModel.updateFoodGameState(1, false);
		
		Key.left.isDown = true;
		gModel.updateFoodGameState(1, false);
		Key.left.isDown = false;
		
		Key.right.isDown = true;
		gModel.updateFoodGameState(1, false);
		Key.right.isDown = false;
		
		//Testing updateFoodGameState
		gModel.updateFoodGameState(1, false);
		player = gModel.getPlayer();
		assertEquals("Point value should be 1 after collection food", 1, gModel.getPlayer().getPoints());
		
		player.yloc = 200;
		gModel.setPlayer(player);
		gModel.updateFoodGameState(1, false);
		assertFalse("isPlaying should now be false again.", gModel.isPlaying);
		
		
		//FlappyBird Testing
		FlappyBirdModel bModel = new FlappyBirdModel(fw, fh, 0);
		//bModel.startFlappyBird();
		assertTrue("isPlaying back to true.", bModel.isPlaying);
		assertEquals("Check player width value", 50, bModel.getPlayer().width);
		assertEquals("Check player height value", 50, bModel.getPlayer().height);
		
		startingX = 0;
		startingY = 100;
		bModel.updateFlappyBirdGameState(startingX, startingY);
		assertEquals("yloc after one iteration when nothing is pressed", 58, bModel.getPlayer().yloc);
		
		player = bModel.getPlayer();
		player.xloc = fw-20;
		player.yloc = fh/2;
		bModel.setPlayer(player);
		bModel.updateFlappyBirdGameState(startingX, startingY);
		assertFalse("Collision should occur, thus isPlaying returns to false", bModel.isPlaying);
		
		
	}
	

}
