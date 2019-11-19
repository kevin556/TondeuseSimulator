package helpersPackageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import enums.Directions;
import enums.Instructions;
import helpers.EnumTypeConvertor;

class HelpersTest {

	
	@Test
	void testConvertCharToInstructionA() {
		String src = "A";
		assertTrue(EnumTypeConvertor.convertCharToInstruction(src) == Instructions.A);
	}
	
	@Test
	void testConvertCharToInstructionD() {
		String src = "D";
		assertTrue(EnumTypeConvertor.convertCharToInstruction(src) == Instructions.D);
	}
	
	@Test
	void testConvertCharToInstructionG() {
		String src = "G";
		assertTrue(EnumTypeConvertor.convertCharToInstruction(src) == Instructions.G);
	}
	
	@Test
	void testConvertCharToInstructionW() {
		String src= "W";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			EnumTypeConvertor.convertCharToInstruction(src);
		});
		
	}
	
	@Test
	void testConvertCharToInstructionCharA() {
		char src = 'A';
		assertTrue(EnumTypeConvertor.convertCharToInstruction(src) == Instructions.A);
	}
	
	@Test
	void testConvertCharToInstructionCharD() {
		char src = 'D';
		assertTrue(EnumTypeConvertor.convertCharToInstruction(src) == Instructions.D);
	}
	
	@Test
	void testConvertCharToInstructionCharG() {
		char src = 'G';
		assertTrue(EnumTypeConvertor.convertCharToInstruction(src) == Instructions.G);
	}
	
	@Test
	void testConvertCharToInstructionCharW() {
		char src= 'W';
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			EnumTypeConvertor.convertCharToInstruction(src);
		});
		
	}
	
	
	@Test
	void testConvertCharToDirectionsN() {
		char src= 'N';
		assertTrue(EnumTypeConvertor.convertCharToDirections(src) == Directions.N);

	}
	
	@Test
	void testConvertCharToDirectionsS() {
		char src= 'S';
		assertTrue(EnumTypeConvertor.convertCharToDirections(src) == Directions.S);
	}
	
	@Test
	void testConvertCharToDirectionsE() {
		char src= 'E';
		assertTrue(EnumTypeConvertor.convertCharToDirections(src) == Directions.E);
	}
	
	@Test
	void testConvertCharToDirectionsW() {
		char src= 'W';
		assertTrue(EnumTypeConvertor.convertCharToDirections(src) == Directions.W);
	}
	
	@Test
	void testConvertCharToDirectionsG() {
		char src= 'G';
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			EnumTypeConvertor.convertCharToDirections(src);
		});
		
	}
	
	@Test
	void testConvertCharToDirectionsStringN() {
		String src= "N";
		assertTrue(EnumTypeConvertor.convertCharToDirections(src) == Directions.N);

	}
	
	@Test
	void testConvertCharToDirectionsStringS() {
		String src= "S";
		assertTrue(EnumTypeConvertor.convertCharToDirections(src) == Directions.S);
	}
	
	@Test
	void testConvertCharToDirectionsStringE() {
		String src= "E";
		assertTrue(EnumTypeConvertor.convertCharToDirections(src) == Directions.E);
	}
	
	@Test
	void testConvertCharToDirectionsStringW() {
		String src= "W";
		assertTrue(EnumTypeConvertor.convertCharToDirections(src) == Directions.W);
	}
	
	@Test
	void testConvertCharToDirectionsStringG() {
		String src= "G";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			EnumTypeConvertor.convertCharToDirections(src);
		});
		
	}

}
