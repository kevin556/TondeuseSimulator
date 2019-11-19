package helpers;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Sys.Garden;
import Sys.Mower;

public class LogicHelpers {
	
	public static Logger logger = LogManager.getLogger(LogicHelpers.class);

	
	/***
	 * 
	 * @param currentXPosition
	 * @param gardenWidth
	 * @return
	 * 
	 * check if est movement is possible
	 */

	private static boolean checkEst(int currentXPosition, int gardenWidth) {
		if(logger.isDebugEnabled()) {
			logger.debug("checkEst ", "currentXposition ", currentXPosition, "gardenWidth ", gardenWidth );
		}		
		return currentXPosition+1 <= gardenWidth;
	}
	
	/***
	 * 
	 * @param currentXPosition
	 * @param gardenWidth
	 * @return
	 * 
	 * check if west movement is possible
	 */
	
	private static boolean checkWest(int currentXPosition, int gardenWidth) {
		if(logger.isDebugEnabled()) {
			logger.debug("checkWest ", "currentXposition ", currentXPosition, "gardenWidth ", gardenWidth );
		}		
		return currentXPosition-1 >= 0;
	}
	
	/***
	 * 
	 * @param currentXPosition
	 * @param gardenWidth
	 * @return
	 * 
	 * check if north movement is possible
	 */
	
	private static boolean checkNorth(int currentYPosition, int gardenHeight) {
		if(logger.isDebugEnabled()) {
			logger.debug("checkNorth ", "currentYPosition ", currentYPosition, "gardenHeight ", gardenHeight );
		}		
		return currentYPosition+1 <= gardenHeight;
	}
	
	/***
	 * 
	 * @param currentXPosition
	 * @param gardenWidth
	 * @return
	 * 
	 * check if south movement is possible
	 */
	
	private static boolean checkSouth(int currentYPosition, int gardenHeight) {
		if(logger.isDebugEnabled()) {
			logger.debug("checkSouth ", "currentYPosition ", currentYPosition, "gardenHeight ", gardenHeight );
		}		
		return currentYPosition-1 >= 0;
 	}
	
	
	/***
	 * 
	 * @param line
	 * @return Garden
	 * @throws IllegalArgumentException
	 * 
	 * Init a garden with the parameter given as a line
	 */

	public static Garden initGarden(String line) throws IllegalArgumentException {
		if(logger.isDebugEnabled()) {
			logger.debug("initGarden ", "line ", line);
		}
		String [] temp = line.split(" ");
		if(logger.isDebugEnabled()) {
			logger.debug("initGarden ", "temp ", temp);
		}
		
		if(temp.length == 2) {
			return new Garden(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
		} else {
			throw new IllegalArgumentException("initGarden: Argument Error ");
		}
		
	}
	
	/***
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 * 
	 * Init an array of Mower object, the initial mowers position and directions are given as an arrayList of String
	 */
	
	public static Mower[] initMowerArray(ArrayList<String> data) throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("initMowerArray ", "data ", data);
		}
		Mower[] toReturn = new Mower[data.size()];
		for(int i = 0 ; i< data.size(); i++ ) {
			toReturn[i] = initMower(data.get(i));
		}
		return toReturn;
	}
	
	/***
	 * 
	 * @param line
	 * @return
	 * @throws Exception
	 * 
	 *  return a mower object according the parameter given in the parameter
	 */
	public static Mower initMower(String line) throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("initMower ", "line ", line);
		}
		String[] temp = line.split(" ");
		return new Mower(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]), EnumTypeConvertor.convertCharToDirections(temp[2]));
	}
	
	
	/***
	 * 
	 * @param mower
	 * @param garden
	 * @return boolean
	 * @throws Exception
	 * 
	 * check if a movement is allowed
	 */

	public static boolean isAllowedMove(Mower mower, Garden garden) throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("isAllowedMove ", "mower ", mower, "garden", garden);
		}
		
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
		if(logger.isDebugEnabled()) {
			logger.debug("isAllowedMove", "toReturn ", toReturn);
		}

		
		return toReturn;
	}
	
	
	/***
	 * 
	 * @param data
	 * @return ArrayList<ArrayList<String>>
	 * 
	 * return an arrayList of an ArrayList: 
	 * first arrayList of the global arrayList contains the Mower data
	 * second arrayList of the global arrayList contains the action data
	 * 
	 */
	
	public static ArrayList<ArrayList<String>> parseAndSplitArrayList(ArrayList<String> data) {
		ArrayList<ArrayList<String>> toReturn = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> dataMowerArray = new ArrayList<String>();
		ArrayList<String> dataActionsList = new ArrayList<String>();
		
		for(int i = 1 ; i < data.size(); i++ ) {
			if( i%2 != 0) {
				dataMowerArray.add(data.get(i));
			}
			if( i%2 == 0) {
				dataActionsList.add(optimizeInstructions(data.get(i)));
			}
		}		
		toReturn.add(dataMowerArray);
		toReturn.add(dataActionsList);
		return toReturn;
	}
	
	/***
	 * 
	 * @param path
	 * @return String
	 * 
	 * this method optimize the instruction data actually when the mower do a full turn. it removes it from the instruction, since no movement is involved
	 */
	public static String optimizeInstructions(String path) {
		path = path.replaceAll("D{4}", "");
		path = path.replaceAll("G{4}", "");
		return path;
	}
	
	/***
	 * 
	 * @param mower
	 * @return String
	 * 
	 * return the correct formated final position of a mower
	 */
	public static String formateRes(Mower mower) {
		StringBuilder sb = new StringBuilder();
		sb.append(mower.getCurrentXPosition());
		sb.append(" ");
		sb.append(mower.getCurrentYPosition());
		sb.append(" ");
		sb.append(mower.getCurrentDirection());
		return sb.toString();
	}
	
	
}
