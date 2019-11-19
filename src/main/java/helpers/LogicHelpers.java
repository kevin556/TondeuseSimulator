package helpers;

import java.util.ArrayList;

import Sys.Garden;
import Sys.Mower;
import enums.Directions;

public class LogicHelpers {

	private static boolean checkEst(int currentXPosition, int gardenWidth) {
		return currentXPosition+1 <= gardenWidth;
	}
	
	private static boolean checkWest(int currentXPosition, int gardenWidth) {
		return currentXPosition-1 >= 0;
	}
	
	private static boolean checkNorth(int currentYPosition, int gardenHeight) {
		return currentYPosition+1 <= gardenHeight;
	}
	
	private static boolean checkSouth(int currentYPosition, int gardenHeight) {
		return currentYPosition-1 >= 0;
 	}
	

	public static Garden initGarden(String line) throws IllegalArgumentException {
		String [] temp = line.split(" ");
		if(temp.length == 2) {
			return new Garden(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
		} else {
			throw new IllegalArgumentException("initGarden: Argument Error ");
		}
		
	}
	
	
	public static Mower[] initMowerArray(ArrayList<String> data) throws Exception {
		Mower[] toReturn = new Mower[data.size()];
		for(int i = 0 ; i< data.size(); i++ ) {
			toReturn[i] = initMower(data.get(i));
		}
		return toReturn;
	}
	
	
	public static Mower initMower(String line) throws Exception {
		String[] temp = line.split(" ");
		return new Mower(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]), EnumTypeConvertor.convertCharToDirections(temp[2]));
	}
	
	

	public static boolean isAllowedMove(Mower mower, Garden garden) throws Exception {
		Boolean toReturn = false; 
		switch(mower.getCurrentDirection()) {
		case N:
			toReturn = checkNorth(mower.getCurrentYPosition(), garden.getHeight());
			break;
		case S:
			toReturn = checkSouth(mower.getCurrentYPosition(), garden.getHeight());
			break;
		case W:
			toReturn = checkWest(mower.getCurrentXPosition(), garden.getWidth());
			break;
		case E:
			toReturn = checkEst(mower.getCurrentXPosition(), garden.getWidth());
			break;
		default:
			throw new Exception("isAllowedMove: move not recognized");
		}
		return toReturn;
	}
	
	
	
}
