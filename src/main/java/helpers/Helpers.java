package helpers;

import enums.Directions;
import enums.Instructions;

public class Helpers {


	public static Instructions convertCharToInstruction(char src) {
		return Instructions.valueOf(Character.toString(src));
	}
	
	public static Instructions convertCharToInstruction(String src) {
		return Instructions.valueOf(src);
	}
	
	public static Directions convertCharToDirections(char src) {
		return Directions.valueOf(Character.toString(src));
	}
	
	public static Directions convertCharToDirections(String src) {
		return Directions.valueOf(src);
	}
	
}
