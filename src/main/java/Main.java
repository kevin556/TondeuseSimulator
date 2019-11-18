import helpers.DataGetter;
import security.Security;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	static Garden garden;
	
	
		
	public static void main(String[]args) {
		Logic logic;
		System.out.println("hello world");
		if(args.length > 1 || args.length == 0 ) {
			System.out.println("erreur d'utilisation:\n\targument1 : fichier d'entrée");
		}
		else {
			if(Security.secureInput(args[0])) {
				String path = args[0];
				
				DataGetter dg = new DataGetter(path);
				// initDataFromFile(args[0]);
				// Mower[] mower, String[] actionsList
				logic = new Logic(dg.readDataFromFile());
				logic.mainLoop();
			}
		}
		
	}

	
	
	

}
