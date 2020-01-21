package helpersPackageTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import helpers.DataGetter;

class DataGetterTest {

	@Test
	void checkIfMissingFileIsHandled() {
		String fakePath="fakePath";
		Assertions.assertThrows(Exception.class, () -> {
			DataGetter dg = new DataGetter(fakePath);
		});	
	}
	
	@Test
	void checkIfReadedDataIsCorrect() {
		String filePath="src/test/resources/inputTestFile";
		ArrayList<String> rest = new ArrayList<String>();
		rest.add("5 5");
		rest.add("1 2 N");
		rest.add("GAGAGAGAA");
		rest.add("3 3 E");
		rest.add("AADAADADDA");
		rest.add("0 0 N");
		rest.add("AAAAA");
		rest.add("0 0 N");
		rest.add("DGDGDGDG");
		rest.add("0 0 N");
		rest.add("DDDD");
		rest.add("0 0 N");
		rest.add("GGGG");
		rest.add("0 0 N");
		rest.add("GAAA");
		
		try {
			DataGetter dg = new DataGetter(filePath);
			ArrayList<String> temp = dg.readDataFromFile();
			assertTrue(temp.equals(rest));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
