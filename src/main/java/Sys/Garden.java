package Sys;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Garden {
	
	private int height;
	private int witdth;

	public static Logger logger = LogManager.getLogger(Garden.class);

	
	/**
	 * 
	 * @param width
	 * @param height
	 * @throws IllegalArgumentException
	 * constructor of garden object. Exceptions are raised when width or height are negative or equal to 0
	 */
	
	public Garden ( int width ,int height ) throws IllegalArgumentException {
		if( logger.isDebugEnabled()) {
			logger.debug("Garden constructor ", "width", width, "height", height);
		}
		
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
	
	public String toString() {
		return "width " + this.witdth + " height " + this.height;
	}

}
