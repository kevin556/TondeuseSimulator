import java.io.FileReader;
import helpers.DataGetter;


public class Main {


	FileReader fr;
	
	
	public static void main(String[]args) {
		System.out.println("hello world");
		if(args.length > 1 || args.length == 0 ) {
			System.out.println("erreur d'utilisation, fichier d'entrée manquant");
		}
		else {
			if(secureInput(args[0])) {
				
			}
		}
		
	}

	
	private static boolean secureInput(String src) {
		System.out.println("actually it does nothing since there are no security rules involved but there should be some security "
				+ "in here since user can give input");
		return true;
	}
	
	
	private static String readFile(String path) {
		DataGetter dg = new DataGetter(path);
	
	
	}
	
	
	

}
