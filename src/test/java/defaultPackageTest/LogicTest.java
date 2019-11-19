package defaultPackageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import Sys.Garden;
import Sys.Logic;
import Sys.Mower;
import enums.Directions;
import helpers.DataGetter;

class LogicTest {
	static ArrayList<String> liste;
	
	
	@BeforeAll
	static void before(){
		DataGetter dg;
		try {
			dg = new DataGetter("src/test/resources/inputTestFile");
			liste = dg.readDataFromFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void LogicConstructorTest(){
		String[] correctActionList = new String[2];
		correctActionList[0] = "GAGAGAGAA";
		correctActionList[1] = "AADAADADDA";
		Mower[] mw = new Mower[2];
		mw[0] = new Mower(1, 2, Directions.N);
		mw[1] = new Mower(3, 3, Directions.E);
		try {
			Logic l = new Logic(liste);
			Garden g = l.getGarden();
			assertTrue(g.getHeight() == 5);
			assertTrue(g.getWidth() == 5);
			String[] al = l.getActionList();
			Mower[] mw2 = l.getMowerArray();
			assertTrue(Arrays.deepEquals(al, correctActionList));
			for(int i = 0 ; i< mw.length; i++ ) {
				assertTrue(mw[i].equals(mw2[i]));
			}			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void mainLoopTest() {
		String[] correctRetour = new String[2];
		correctRetour[0] = "1 3 N";
		correctRetour[1] = "5 1 E";
		try {
			Logic l = new Logic(liste);
			String[] retour = l.mainLoop();
			assertTrue(Arrays.deepEquals(correctRetour, retour));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
