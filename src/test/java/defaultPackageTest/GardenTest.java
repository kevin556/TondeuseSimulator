package defaultPackageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Sys.Garden;



class GardenTest {

		
	@Test
	void shouldReturnIllegalArgumentsException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Garden a = new Garden(0,0);
		});
	}
	@Test
	void shouldReturnIllegalArgumentsException2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Garden a = new Garden(-12,0);
		});
	}
	
	@Test
	void shouldReturnInitiatedGardenObject() {
		Garden a = new Garden(1,2);
		assertTrue(a.getHeight() == 1);
		assertTrue(a.getWidth() == 2);
	}
	
	@Test
	void shouldReturnInitiatedGardenObject2() {
		Garden a = new Garden(12,23);
		assertTrue(a.getHeight() == 12);
		assertTrue(a.getWidth() == 23);
	}
	

}
