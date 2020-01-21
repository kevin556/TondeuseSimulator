package Sys;
import enums.Instructions;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helpers.EnumTypeConvertor;

public class Logic {

	private Garden garden;
	private Mower[] mowerArray;
	private String[] actionsList;
	
	public static Logger logger = LogManager.getLogger(Logic.class);

	
	public Garden getGarden() {
		return this.garden;
	}
	
	public Mower[] getMowerArray() {
		return this.mowerArray;
	}
	
	public String[] getActionList() {
		return this.actionsList;
	}
	
	/***
	 * 
	 * @param data
	 * @throws Exception
	 * 
	 * This method init the Logic Object
	 * It's used to initiate the object needed to run the mainLoop part
	 * 
	 */
	
	public Logic(ArrayList<String> data ) throws Exception {			
		try {
			logger.debug("Logic constructor ", "initialValue" , data );
			garden = helpers.LogicHelpers.initGarden(data.get(0));
			int arraySize = (data.size() - 1) /2;
			ArrayList<ArrayList<String>> splittedFromData = helpers.LogicHelpers.parseAndSplitArrayList(data);
			mowerArray = helpers.LogicHelpers.initMowerArray(splittedFromData.get(0));
			actionsList = splittedFromData.get(1).toArray(new String[arraySize]);
			
			logger.debug("Logic constructor ", "garden" , garden, "mowerArray",mowerArray, "actionsList", actionsList );


		
		}catch(Exception e) {
			throw new Exception("Logic constructor error " + e.getStackTrace());
		}
	}
	
	
/***
 * 
 * @return String[] it return an array of the position where the mowers are.
 * @throws Exception
 * 
 * This function is the core of the program. It's used to make the mower move by understanding the instruction given in the inputFile
 * 
 */
	
	public String[] mainLoop() throws Exception {
		int actionListSize = actionsList.length;
		String[] toReturn = new String[actionListSize];
		logger.debug("Logic mainLoop ", "toReturn" , toReturn );

		for(int i = 0 ; i < actionListSize; i++ ) {
			for ( int j = 0 ; j < actionsList[i].length();j++) {
				Instructions currentInstruction = EnumTypeConvertor.convertCharToInstruction(actionsList[i].charAt(j));
				try {
					// Actually we don't need to check if mower can rotate since there no movement involved.
					if (currentInstruction == Instructions.A && helpers.LogicHelpers.isAllowedMove(mowerArray[i], garden)) {
						mowerArray[i].executeInstruction(currentInstruction);	
					}
					else if(currentInstruction != Instructions.A) {
						mowerArray[i].executeInstruction(currentInstruction);	
					}
				} catch (Exception e) {
					throw new Exception("error mainLoop parameters \n\tinstruction value: " + currentInstruction);
				}
			}
			System.out.println(mowerArray[i].getCurrentXPosition() + " " + mowerArray[i].getCurrentYPosition() + " " + mowerArray[i].getCurrentDirection());
			logger.debug("Logic mainLoop ", "toReturn["+i+"]" , toReturn[i] );
			toReturn[i] = helpers.LogicHelpers.formateRes(mowerArray[i]);
		}
		return toReturn;
	}
	
	

	
	

	
	
	
}
