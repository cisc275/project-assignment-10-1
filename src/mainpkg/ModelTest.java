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
		GameObject myObj1 = new Obstacle(100, 100, 250, 200, 0, 0);
		GameObject myObj2 = new Obstacle(100,100,250,0,0,0);
		GameObject myObj3 = new Obstacle(100,100,250,325,0,0);
		
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
		assertFalse("myModel will not be playing before calling startFrogger", myModel.isPlaying);
		myModel.startFrogger(500, 500);
		assertTrue("Should now be playing" ,myModel.isPlaying);
		
		//Testing updateFroggerState
		myModel.updateFroggerState();
		assertTrue("isPlaying still true, froggerEnd() shouldn't pass", myModel.isPlaying);
		player.height = 201;
		myModel.setPlayer(player);
		myModel.updateFroggerState();
		assertFalse("Is playing should be false again", myModel.isPlaying);
		
		//Testing startFoodGame
		myModel.startFoodGame();
		assertTrue("back to isPlaying", myModel.isPlaying);
		assertEquals("player should have new player values. Just checking height (70)", 70, myModel.getPlayer().height);
		
		//Testing 
		
		
		
	}

}
