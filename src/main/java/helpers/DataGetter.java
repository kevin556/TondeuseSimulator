package helpers;

import java.util.Scanner;
import java.util.ArrayList;

public class DataGetter {
	
	
	String path;
	Scanner sc;
	
	
	public DataGetter(String path) {
		this.path = path;
	}
	
	
	private Scanner openFile() throws Exception {
		try {
			sc = new Scanner(path);
		}catch (Exception e) {
			throw new Exception("openFile: error when opening file " + e.getStackTrace());
		}
		return sc;
	}
	
	
	public ArrayList<String> readDataFromFile() throws Exception {
		ArrayList<String> list = new ArrayList<>();
		Scanner sc = openFile();
		while(sc.hasNext()) {
			list.add(sc.nextLine());
		}
		//todo: check if closeFile should be called here
		closeFile();
		return list;
	}
	
	private void closeFile() {
		sc.close();
	}
	
	
	

}
