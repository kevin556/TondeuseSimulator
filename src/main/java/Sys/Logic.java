package Sys;
import enums.Directions;
import enums.Instructions;
import java.util.ArrayList;

import helpers.EnumTypeConvertor;

public class Logic {

	public Garden garden;
	public Mower[] mowerArray;
	public String[] actionsList;
	

	public Logic(ArrayList<String> data ) throws Exception {
		ArrayList<String> dataMowerArray = new ArrayList<String>();
		ArrayList<String> dataActionsList = new ArrayList<String>();
		
		
		for(int i = 1 ; i < data.size(); i++ ) {
			if( i%2 == 0) {
				dataMowerArray.add(data.get(i));
			}
			if( i%2 != 0) {
				dataActionsList.add(data.get(i));
			}
		}
		try {
			System.out.println("data.get(0) " + data.get(0).toString());
			garden = helpers.LogicHelpers.initGarden(data.get(0));
			mowerArray = helpers.LogicHelpers.initMowerArray(dataMowerArray);
			actionsList = dataActionsList.toArray(new String[dataActionsList.size()]);
		}catch(Exception e) {
			throw new Exception("Logic constructor error " + e.getStackTrace());
		}
	}
	
	
	public Logic(Mower[] mower, String[] initialPosition, String[] actionsList ) {
		this.mowerArray = mower;
		this.actionsList = actionsList;
	}
	
	
	public void mainLoop() throws Exception {
		for(int i = 0 ; i < actionsList.length; i++ ) {
			for ( int j = 0 ; j < actionsList[i].length();j++) {
				Instructions currentInstruction = EnumTypeConvertor.convertCharToInstruction(actionsList[i].charAt(j));
				try {
					// Actually we don't need to check if mower can rotate since there no movement involved.
					if (currentInstruction == Instructions.A && helpers.LogicHelpers.isAllowedMove(mowerArray[i], garden)) {
						mowerArray[i].executeInstruction(currentInstruction);						
					}
				} catch (Exception e) {
					throw new Exception("error mainLoop parameters \n\tinstruction value: " + currentInstruction);
				}
			}
			System.out.println(mowerArray[i].getCurrentXPosition() + " " + mowerArray[i].getCurrentYPosition() + " " + mowerArray[i].getCurrentDirection());
		}		
	}
	
	

	
	

	
	
	
}
