package defaultPackageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Sys.Mower;
import enums.Directions;

class MowerTest {

	@Test
	void initCorrectMowerObject() {
		Mower a = new Mower(1,2,Directions.E);
		assertTrue(a.getCurrentXPosition() == 1);
		assertTrue(a.getCurrentYPosition() == 2);
		assertTrue(a.getCurrentDirection() == Directions.E);
	}
	
	@Test
	void initIncorrectMowerObject() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Mower a = new Mower(1,0,Directions.E);
		});
	}
	
	@Test
	void rotateLeftTest() {
		Mower m = new Mower(1,2,Directions.N);
		m.rotateLeft();
		assertTrue(m.getCurrentDirection() == Directions.W);
		m.rotateLeft();
		assertTrue(m.getCurrentDirection() == Directions.S);
		m.rotateLeft();
		assertTrue(m.getCurrentDirection() == Directions.E);
		m.rotateLeft();
		assertTrue(m.getCurrentDirection() == Directions.N);		
	}
	
	@Test
	void rotateRightTest() {
		Mower m = new Mower(1,2,Directions.N);
		m.rotateRight();
		assertTrue(m.getCurrentDirection() == Directions.E);
		m.rotateRight();
		assertTrue(m.getCurrentDirection() == Directions.S);
		m.rotateRight();
		assertTrue(m.getCurrentDirection() == Directions.W);
		m.rotateRight();
		assertTrue(m.getCurrentDirection() == Directions.N);		
	}
	
	@Test
	void moveUpTest() {
		Mower m = new Mower(1,1,Directions.N);
		m.moveUp();
		assertTrue(m.getCurrentYPosition() == 2);
	}
	
	@Test
	void moveDownTest() {
		Mower m = new Mower(1,1,Directions.N);
		m.moveDown();
		assertTrue(m.getCurrentYPosition() == 0);
	}
	
	@Test
	void moveEstTest() {
		Mower m = new Mower(1,1,Directions.N);
		m.moveEst();
		assertTrue(m.getCurrentXPosition() == 2);
	}
	
	@Test
	void moveWestTest() {
		Mower m = new Mower(1,1,Directions.N);
		m.moveWest();
		assertTrue(m.getCurrentXPosition() == 0);
	}
	
	@Test
	void moveWestTest2() {
		Mower m = new Mower(0,0,Directions.N);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			m.moveWest();	
		});
	}
	
	@Test
	void moveDownTest2() {
		Mower m = new Mower(0,0,Directions.N);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			m.moveDown();	
		});
	}
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
