package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/***
 * 
 * @author kevin556
 *	this class is used to read the data from a file
 *
 */

public class DataGetter {
	
	String path;
	BufferedReader reader;
	
	
	/***
	 * @param path
	 * @throws FileNotFoundException
	 * 
	 * This constructor check if the file given in the path exist
	 * 
	 */
	public DataGetter(String path) throws FileNotFoundException{
		this.path = path;
		try {
			reader = openFile();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("DataGetter constructor error " + e);
		}
	}
	
	/***
	 * @param path
	 * @throws FileNotFoundException
	 * 
	 * This method is used to get the BufferedReader in order to read the file
	 * 
	 */
	private BufferedReader openFile() throws FileNotFoundException {
		try {
			return new BufferedReader(new FileReader(path));
		} catch(FileNotFoundException e) {
			throw new FileNotFoundException("DataGetter openFile error " + e);
		}
	
	}
	
	/***
	 * @param path
	 * @throws FileNotFoundException
	 * 
	 * This method is used to read the line from the BufferedReader
	 * 
	 */
	public ArrayList<String> readDataFromFile() throws IOException {
		ArrayList<String> list = new ArrayList<>();
		String line;
		while((line = reader.readLine()) != null) {
			list.add(line);
		}
		closeFile();
		return list;
	}
	
	/***
	 * @param path
	 * @throws FileNotFoundException
	 * 
	 * This method is used to close the BufferedReader
	 * 
	 */
	private void closeFile() throws IOException{
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
