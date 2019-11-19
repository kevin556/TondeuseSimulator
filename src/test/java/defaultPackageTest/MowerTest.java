package defaultPackageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Sys.Mower;
import enums.Directions;
import enums.Instructions;
import helpers.EnumTypeConvertor;

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
			Mower a = new Mower(-1,0,Directions.E);
		});
	}
	
	@Test
	void initIncorrectMowerObject1() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Mower a = new Mower(0,-1,Directions.E);
		});
	}	
	
	@Test
	void initIncorrectMowerObject3() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Mower a = new Mower(0,0,EnumTypeConvertor.convertCharToDirections("G"));
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
		assertTrue(m.getCurrentXPosition() == 0);
	}
	
	@Test
	void moveDownTest2() {
		Mower m = new Mower(0,0,Directions.N);
		assertTrue(m.getCurrentYPosition() == 0);
	}
	
	
	@Test
	void moveForwardNorthTest() {
		Mower m = new Mower(0,0,Directions.N);
		m.moveForward();
		assertTrue(m.getCurrentDirection() == Directions.N);
		assertTrue(m.getCurrentXPosition() == 0);
		assertTrue(m.getCurrentYPosition() == 1);
	}
	
	@Test
	void moveForwardEstTest() {
		Mower m = new Mower(0,0,Directions.E);
		m.moveForward();
		assertTrue(m.getCurrentDirection() == Directions.E);
		assertTrue(m.getCurrentXPosition() == 1);
		assertTrue(m.getCurrentYPosition() == 0);
	}
	
	@Test
	void moveForwardWestTest() {
		Mower m = new Mower(1,0,Directions.W);
		m.moveForward();
		assertTrue(m.getCurrentDirection() == Directions.W);
		assertTrue(m.getCurrentXPosition() == 0);
		assertTrue(m.getCurrentYPosition() == 0);
	}
	
	@Test
	void moveForwardSouthTest() {
		Mower m = new Mower(0,1,Directions.S);
		m.moveForward();
		assertTrue(m.getCurrentDirection() == Directions.S);
		assertTrue(m.getCurrentXPosition() == 0);
		assertTrue(m.getCurrentYPosition() == 0);
	}
	
	@Test
	void moveForwardSouthTest2() {
		Mower m = new Mower(0,0,Directions.S);
		m.moveForward();
		assertTrue(m.getCurrentDirection() == Directions.S);
		assertTrue(m.getCurrentXPosition() == 0);
		assertTrue(m.getCurrentYPosition() == 0);
	}
	
	
	@Test
	void moveForwardWestTest2() {
		Mower m = new Mower(0,0,Directions.W);
		m.moveForward();
		assertTrue(m.getCurrentDirection() == Directions.W);
		assertTrue(m.getCurrentXPosition() == 0);
		assertTrue(m.getCurrentYPosition() == 0);
	}
	
	
	@Test
	void executeInstructionTest() {
		Mower m = new Mower(0,0,Directions.N);
		Instructions instr = EnumTypeConvertor.convertCharToInstruction("A");
		m.executeInstruction(instr);
		assertTrue(m.getCurrentDirection() == Directions.N);
		assertTrue(m.getCurrentXPosition() == 0);
		assertTrue(m.getCurrentYPosition() == 1);
	}
	
	@Test
	void executeInstructionTest1() {
		Mower m = new Mower(0,0,Directions.N);
		Instructions instr = EnumTypeConvertor.convertCharToInstruction("G");
		m.executeInstruction(instr);
		assertTrue(m.getCurrentDirection() == Directions.W);
		assertTrue(m.getCurrentXPosition() == 0);
		assertTrue(m.getCurrentYPosition() == 0);
	}
	
	@Test
	void executeInstructionTest2() {
		Mower m = new Mower(0,0,Directions.N);
		Instructions instr = EnumTypeConvertor.convertCharToInstruction("D");
		m.executeInstruction(instr);
		assertTrue(m.getCurrentDirection() == Directions.E);
		assertTrue(m.getCurrentXPosition() == 0);
		assertTrue(m.getCurrentYPosition() == 0);
	}
	

}
