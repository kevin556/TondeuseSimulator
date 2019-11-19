package Sys;
import enums.Instructions;
import java.util.ArrayList;

import helpers.EnumTypeConvertor;

public class Logic {

	private Garden garden;
	private Mower[] mowerArray;
	private String[] actionsList;
	
	public Garden getGarden() {
		return this.garden;
	}
	
	public Mower[] getMowerArray() {
		return this.mowerArray;
	}
	
	public String[] getActionList() {
		return this.actionsList;
	}
	
	
	public Logic(ArrayList<String> data ) throws Exception {			
		try {
			garden = helpers.LogicHelpers.initGarden(data.get(0));
			int arraySize = (data.size() - 1) /2;
			ArrayList<ArrayList<String>> splittedFromData = helpers.LogicHelpers.parseAndSplitArrayList(data);
			mowerArray = helpers.LogicHelpers.initMowerArray(splittedFromData.get(0));
			actionsList = splittedFromData.get(1).toArray(new String[arraySize]);
		}catch(Exception e) {
			throw new Exception("Logic constructor error " + e.getStackTrace());
		}
	}
	

	
	public String[] mainLoop() throws Exception {
		int actionListSize = actionsList.length;
		String[] toReturn = new String[actionListSize];
		
		for(int i = 0 ; i < actionListSize; i++ ) {
			for ( int j = 0 ; j < actionsList[i].length();j++) {
				Instructions currentInstruction = EnumTypeConvertor.convertCharToInstruction(actionsList[i].charAt(j));
				try {
					mowerArray[i].executeInstruction(currentInstruction);	
				} catch (Exception e) {
					throw new Exception("error mainLoop parameters \n\tinstruction value: " + currentInstruction);
				}
			}
			toReturn[i] = helpers.LogicHelpers.formateRes(mowerArray[i]);
		}
		return toReturn;
	}
	
	

	
	

	
	
	
}
