package Sys;
import helpers.DataGetter;
import security.Security;


public class Main {
		
	public static void main(String[]args) {
		Logic logic;
		if(args.length > 1 || args.length == 0 ) {
			System.out.println("erreur d'utilisation:\n\targument1 : fichier d'entrée");
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
