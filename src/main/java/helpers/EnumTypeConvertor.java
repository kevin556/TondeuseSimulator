package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import enums.Directions;
import enums.Instructions;

/***
 * 
 * @author kevin556
 *
 *	This class contains methods used to convert string to enums based data.
 */

public class EnumTypeConvertor {
	public static Logger logger = LogManager.getLogger(EnumTypeConvertor.class);


	public static Instructions convertCharToInstruction(char src) {
		logger.debug("convertCharToInstruction src ", src );
		return Instructions.valueOf(Character.toString(src));
	}
	
	public static Instructions convertCharToInstruction(String src) {
		logger.debug("convertCharToInstruction src ", src );
		return Instructions.valueOf(src);
	}
	
	public static Directions convertCharToDirections(char src) {
		logger.debug("convertCharToDirections src ", src );
		return Directions.valueOf(Character.toString(src));
	}
	
	public static Directions convertCharToDirections(String src) {
		logger.debug("convertCharToDirections src ", src );
		return Directions.valueOf(src);
	}
	
}
