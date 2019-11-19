package defaultPackageTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




class GardenTest {

		
	@Test
	void shouldReturnAnException() {
		Garden a = new Garden(0,0);
		Exception e = new IllegalArgumentException("height or width can't be equal to 0 or negative");
		
		
	}
	
	
	@Test	
	void test() {
		fail("Not yet implemented");
	}

}
