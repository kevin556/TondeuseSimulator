package helpersPackageTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Sys.Garden;
import Sys.Mower;
import enums.Directions;
import helpers.LogicHelpers;

class LogicHelpersTest {

	@Test
	void testInitGarden() {
		try {
			Garden g = helpers.LogicHelpers.initGarden("5 5");
			assertTrue(g.getHeight() == 5);
			assertTrue(g.getWidth() == 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInitGarden2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Garden g = helpers.LogicHelpers.initGarden("0 0");
		});
	}

	@Test
	void testInitGarden3() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Garden g = helpers.LogicHelpers.initGarden("-1 0");
		});
	}

	@Test
	void testInitGarden4() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Garden g = helpers.LogicHelpers.initGarden("0");
		});
	}

	@Test
	void testInitGarden5() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Garden g = helpers.LogicHelpers.initGarden("A 0");
		});
	}

	@Test
	void initMowerTest() {
		try {
			Mower m = helpers.LogicHelpers.initMower("1 2 N");
			assertTrue(m.getCurrentXPosition() == 1);
			assertTrue(m.getCurrentYPosition() == 2);
			assertTrue(m.getCurrentDirection() == Directions.N);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void initMowerTest2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Mower m = helpers.LogicHelpers.initMower("-1 2 N");
		});
	}

	@Test
	void initMowerTest3() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Mower m = helpers.LogicHelpers.initMower("0 2 L");
		});
	}

	@Test
	void initMowerArrayTest() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("1 2 N");
		temp.add("3 3 E");
		try {
			Mower[] array = helpers.LogicHelpers.initMowerArray(temp);
			assertTrue(array.length == 2);
			assertTrue(array[0].getCurrentDirection() == Directions.N);
			assertTrue(array[0].getCurrentXPosition() == 1);
			assertTrue(array[0].getCurrentYPosition() == 2);
			assertTrue(array[1].getCurrentDirection() == Directions.E);
			assertTrue(array[1].getCurrentXPosition() == 3);
			assertTrue(array[1].getCurrentYPosition() == 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void initMowerArrayTest2() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("1 2 N");
		temp.add("-3 3 E");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Mower[] array = null;
			array = helpers.LogicHelpers.initMowerArray(temp);
			assertTrue(array == null);
		});
	}

	@Test
	void initMowerArrayTest3() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("1 2 N");
		temp.add("");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Mower[] array = null;
			array = helpers.LogicHelpers.initMowerArray(temp);
			assertTrue(array == null);
		});
	}

	@Test
	void initMowerArrayTest4() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("2 A");
		temp.add("-3 3 E");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Mower[] array = null;
			array = helpers.LogicHelpers.initMowerArray(temp);
			assertTrue(array == null);
		});
	}

	@Test
	void isAllowedMoveTest() {
		Mower m = new Mower(0, 0, Directions.N);
		Garden g = new Garden(1, 1);
		try {
			assertTrue(helpers.LogicHelpers.isAllowedMove(m, g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void isAllowedMoveTest2() {
		Mower m = new Mower(1, 1, Directions.N);
		Garden g = new Garden(1, 1);
		try {
			assertFalse(helpers.LogicHelpers.isAllowedMove(m, g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void isAllowedMoveTest3() {
		Mower m = new Mower(0, 1, Directions.S);
		Garden g = new Garden(1, 1);
		try {
			assertTrue(helpers.LogicHelpers.isAllowedMove(m, g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void isAllowedMoveTest4() {
		Mower m = new Mower(0, 0, Directions.S);
		Garden g = new Garden(1, 1);
		try {
			assertFalse(helpers.LogicHelpers.isAllowedMove(m, g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void isAllowedMoveTest5() {
		Mower m = new Mower(0, 0, Directions.E);
		Garden g = new Garden(1, 1);
		try {
			assertTrue(helpers.LogicHelpers.isAllowedMove(m, g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void isAllowedMoveTest6() {
		Mower m = new Mower(1, 0, Directions.E);
		Garden g = new Garden(1, 1);
		try {
			assertFalse(helpers.LogicHelpers.isAllowedMove(m, g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void isAllowedMoveTest7() {
		Mower m = new Mower(1, 0, Directions.W);
		Garden g = new Garden(1, 1);
		try {
			assertTrue(helpers.LogicHelpers.isAllowedMove(m, g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void isAllowedMoveTest8() {
		Mower m = new Mower(0, 0, Directions.W);
		Garden g = new Garden(1, 1);
		try {
			assertFalse(helpers.LogicHelpers.isAllowedMove(m, g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void parseAndSplitArrayListTest() {
		ArrayList<String> data = new ArrayList<String>();
		data.add("5 5");
		data.add("1 2 N");
		data.add("GAGAGAGAA");
		data.add("3 3 E");
		data.add("AADAADADDA");

		ArrayList<String> mowerData = new ArrayList<String>();
		ArrayList<String> instructionData = new ArrayList<String>();

		mowerData.add("1 2 N");
		mowerData.add("3 3 E");

		instructionData.add("GAGAGAGAA");
		instructionData.add("AADAADADDA");

		ArrayList<ArrayList<String>> temp = helpers.LogicHelpers.parseAndSplitArrayList(data);
		assertTrue(temp.get(0).equals(mowerData));
		assertTrue(temp.get(1).equals(instructionData));

	}

	@Test
	void formateResTest() {
		Mower m = new Mower(1, 2, Directions.N);
		assertTrue(helpers.LogicHelpers.formateRes(m).equals("1 2 N"));
	}
	
	@Test
	void optimizePartTest() {
		String path = "DDDDA";
		assertTrue(helpers.LogicHelpers.optimizeInstructions(path).contentEquals("A"));
	}
	
	@Test
	void optimizePartTest2() {
		String path = "GGGGA";
		assertTrue(helpers.LogicHelpers.optimizeInstructions(path).equals("A"));
	}
	
	@Test
	void optimizePartTest3() {
		String path = "DDA";
		assertTrue(helpers.LogicHelpers.optimizeInstructions(path).equals("DDA"));
	}
	
	@Test
	void optimizePartTest4() {
		String path = "DADADADA";
		assertTrue(helpers.LogicHelpers.optimizeInstructions(path).equals("DADADADA"));
	}

	

}
