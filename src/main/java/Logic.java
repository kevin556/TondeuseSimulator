import enums.Directions;
import enums.Instructions;
import java.util.ArrayList;
import helpers.Helpers;

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
			garden = initGarden(data.get(0));
			mowerArray = initMowerArray(dataMowerArray);
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
				Instructions currentInstruction = Helpers.convertCharToInstruction(actionsList[i].charAt(j));
				try {
					// Actually we don't need to check if mower can rotate since there no movement involved.
					if (currentInstruction == Instructions.A && isAllowedMove(mowerArray[i])) {
						mowerArray[i].executeInstruction(currentInstruction);						
					}
				} catch (Exception e) {
					throw new Exception("error mainLoop parameters \n\tinstruction value: " + currentInstruction);
				}
			}
		}		
	}
	
	
	private Garden initGarden(String line) throws Exception {
		String [] temp = line.split(" ");
		return new Garden(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
	}
	
	
	private Mower[] initMowerArray(ArrayList<String> data) throws Exception {
		Mower[] toReturn = new Mower[data.size()];
		for(int i = 0 ; i< data.size(); i++ ) {
			toReturn[i] = initMower(data.get(i));
		}
		return toReturn;
	}
	
	
	private Mower initMower(String line) throws Exception {
		String[] temp = line.split(" ");
		return new Mower(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]), Helpers.convertCharToDirections(temp[2]));
	}
	
	
	private boolean isAllowedMove(Mower mower) throws Exception {
		int currentHeight = mower.getCurrentYPosition();
		int currentWidth = mower.getCurrentXPosition();
		Directions direction = mower.getCurrentDirection();
		switch(direction) {
		case N:
			return checkNorth(currentHeight, this.garden.getHeight());
		case S:
			return checkSouth(currentHeight, this.garden.getHeight());
		case W:
			return checkWest(currentWidth, this.garden.getWidth());
		case E:
			return checkEst(currentWidth, this.garden.getWidth());
		default:
			throw new Exception("isAllowedMove: move not recognized");
		}
	}
	
	
	private static boolean checkEst(int currentXPosition, int gardenWidth) {
		return currentXPosition+1 < gardenWidth;
	}
	
	private static boolean checkWest(int currentXPosition, int gardenWidth) {
		return currentXPosition-1 >= 0;
	}
	
	private static boolean checkNorth(int currentYPosition, int gardenHeight) {
		return currentYPosition+1 < gardenHeight;
	}
	
	private static boolean checkSouth(int currentYPosition, int gardenHeight) {
		return currentYPosition-1 >= 0;
 	}
	
	
	
}
