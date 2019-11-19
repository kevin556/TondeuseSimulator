package security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helpers.LogicHelpers;

public class Security {

	public static Logger logger = LogManager.getLogger(Security.class);

	
/***
 * 
 * @param src
 * @return boolean
 * 
 * check user input
 */
	public static boolean secureInput(String src) {
/* actually it does nothing since there are no security rules involved but there should be
 *  some security in here since user can give input
*/
		return true;
	}
	
	
	
}
