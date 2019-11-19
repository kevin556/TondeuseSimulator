package helpers;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataGetter {
	
	String path;
	BufferedReader reader;
	
	public DataGetter(String path) throws FileNotFoundException{
		this.path = path;
		try {
			reader = openFile();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("DataGetter constructor error " + e);
		}
	}
	
	
	private BufferedReader openFile() throws FileNotFoundException {
		try {
			return new BufferedReader(new FileReader(path));
		} catch(FileNotFoundException e) {
			throw new FileNotFoundException("DataGetter openFile error " + e);
		}
	
	}
	
	
	public ArrayList<String> readDataFromFile() throws Exception {
		ArrayList<String> list = new ArrayList<>();
		String line;
		while((line = reader.readLine()) != null) {
			list.add(line);
		}
		closeFile();
		return list;
	}
	
	private void closeFile() throws IOException{
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
