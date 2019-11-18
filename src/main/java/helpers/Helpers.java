package helpers;

import enums.Instructions;

public class Helpers {


	public static Instructions convertCharToInstruction(char src) {
		return Instructions.valueOf(Character.toString(src));
	}
	
	
}
