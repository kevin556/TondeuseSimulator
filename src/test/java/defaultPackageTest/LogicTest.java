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
		String[] correctActionList = new String[6];
		correctActionList[0] = "GAGAGAGAA";
		correctActionList[1] = "AADAADADDA";
		correctActionList[2] = "AAAAA";
		correctActionList[3] = "DGDGDGDG";
		correctActionList[4] = "DDDD";
		correctActionList[5] = "GGGG";
		
		
		Mower[] mw = new Mower[6];
		mw[0] = new Mower(1, 2, Directions.N);
		mw[1] = new Mower(3, 3, Directions.E);
		mw[2] = new Mower(0, 0, Directions.N);
		mw[3] = new Mower(0, 0, Directions.N);
		mw[4] = new Mower(0, 0, Directions.N);
		mw[5] = new Mower(0, 0, Directions.N);
		
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
		String[] correctRetour = new String[6];
		correctRetour[0] = "1 3 N";
		correctRetour[1] = "5 1 E";
		correctRetour[2] = "0 5 N";
		correctRetour[3] = "0 0 N";
		correctRetour[4] = "0 0 N";
		correctRetour[5] = "0 0 N";
		
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
