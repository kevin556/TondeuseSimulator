package Sys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helpers.DataGetter;
import security.Security;


public class Main {
		
	public static Logger logger = LogManager.getLogger(Main.class);

	
	public static void main(String[]args) {
		Logic logic;
		if(args.length > 1 || args.length == 0 ) {
			logger.error("Main", "erreur d'utilisation ");
		}
		else {
			if(Security.secureInput(args[0])) {
				String path = args[0];
				try {
					DataGetter dg = new DataGetter(path);
					logic = new Logic(dg.readDataFromFile());
					logic.mainLoop();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
