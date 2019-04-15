package mainpkg;

import static org.junit.Assert.*;

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
		assertFalse("shouldn't collide with anything", myModel.wallCollision(myObj1));
		assertTrue("Should collide with wall",myModel.wallCollision(myObj2));
		assertTrue("Should collide with wall", myModel.wallCollision(myObj3));
		assertTrue("Should collide with wall", myModel.wallCollision(myObj4));
		assertTrue("Should collide with wall", myModel.wallCollision(myObj5));
		assertTrue("Collision should occur",myModel.collision(player, myObj1));
		
	}

}
