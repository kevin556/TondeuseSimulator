import enums.Directions;
import enums.Instructions;

public class Logic {

	public static Garden garden;
	public Mower[] mowerArray;
	public String[] initialPosition;
	public String[] actionsList;
	
	
	
	public Logic(Mower[] mower, String[] initialPosition, String[] actionsList ) {
		this.mowerArray = mower;
		this.initialPosition = initialPosition;
		this.actionsList = actionsList;
	}
	
	
	public void mainLoop() throws Exception {
		for(int i = 0 ; i < actionsList.length; i++ ) {
			for ( int j = 0 ; j < actionsList[i].length();j++) {
				Instructions currentInstruction = convertCharToInstruction(actionsList[i].charAt(j));
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
	
	// todo: put in helpers class
	
	private static Instructions convertCharToInstruction(char src) {
		return Instructions.valueOf(Character.toString(src));
	}
	
	private static boolean isAllowedMove(Mower mower) throws Exception {
		int currentHeight = mower.getCurrentYPosition();
		int currentWidth = mower.getCurrentXPosition();
		Directions direction = mower.getCurrentDirection();
		switch(direction) {
		case NORTH:
			return checkNorth(currentHeight, garden.getHeight());
		case SOUTH:
			return checkSouth(currentHeight, garden.getHeight());
		case WEST:
			return checkWest(currentWidth, garden.getWidth());
		case EST:
			return checkEst(currentWidth, garden.getWidth());
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
