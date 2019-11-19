package Sys;


public class Garden {
	
	private int height;
	private int witdth;

	
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
