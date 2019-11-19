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
	void shouldReturnIllegalArgumentsException3() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Garden a = new Garden(0,-12);
		});
	}
	
	@Test
	void shouldReturnIllegalArgumentsException4() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Garden a = new Garden(1,-12);
		});
	}
	
	@Test
	void shouldReturnIllegalArgumentsException5() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Garden a = new Garden(-12,3);
		});
	}
	
	
	
	@Test
	void shouldReturnInitiatedGardenObject() {
		Garden a = new Garden(1,2);
		assertTrue(a.getWidth() == 1);
		assertTrue(a.getHeight() == 2);
	}
	
	@Test
	void shouldReturnInitiatedGardenObject2() {
		Garden a = new Garden(12,23);
		assertTrue(a.getWidth() == 12);
		assertTrue(a.getHeight() == 23);
	}
	

}
