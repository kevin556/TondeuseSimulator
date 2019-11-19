package Sys;


public class Garden {
	
	private int height;
	private int witdth;

	/**
	 * 
	 * @param width
	 * @param height
	 * @throws IllegalArgumentException
	 * constructor of garden object. Exceptions are raised when width or height are negative or equal to 0
	 */
	public Garden ( int width ,int height ) throws IllegalArgumentException {
		if (height <= 0 || width <= 0) {
			throw new IllegalArgumentException("height or width can't be equal to 0 or negative");
		}		
		this.height = height;
		this.witdth = width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.witdth;
	}

}
