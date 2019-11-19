package Sys;

import enums.Directions;
import enums.Instructions;

public class Mower {

	private Directions currentDirection;
	private int currentXPosition;
	private int currentYPosition;
	
	/***
	 * 
	 * @param x
	 * @param y
	 * @param d
	 * @throws IllegalArgumentException
	 * Mower constructor, return a mower object or throw an exception when x or y are negative
	 */
	public Mower(int x, int y, Directions d) throws IllegalArgumentException{
		if(x < 0 || y < 0 ) {
			throw new IllegalArgumentException("Mower constructor: x or y can't be equal to 0 or negative");
		}
		this.currentDirection = d;
		this.currentXPosition = x;
		this.currentYPosition = y;
	}
	
	/***
	 * check if two Mower are at the same position and at the same direction
	 */
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(!(o instanceof Mower)) {
			return false;
		}
		Mower m = (Mower)o;
		
		return currentXPosition == m.getCurrentXPosition() && 
				currentYPosition == m.getCurrentYPosition() &&
				currentDirection == m.getCurrentDirection();
		
	}
	
	/***
	 * 
	 * @return int
	 * return current X position
	 */
	public int getCurrentXPosition() {
		return this.currentXPosition;
	}

	/***
	 * 
	 * @return int
	 * return current Y position
	 */
	public int getCurrentYPosition() {
		return this.currentYPosition;
	}
	
	

	/***
	 * 
	 * @return Directions
	 * return current direction
	 */
	public Directions getCurrentDirection() {
		return this.currentDirection;
	}
	
	/***
	 * 
	 * @param instr
	 * @throws IllegalArgumentException
	 * 
	 * execute given instruction
	 */
	public void executeInstruction(Instructions instr) throws IllegalArgumentException {
		switch(instr) {
		case D:
			this.rotateRight();
			break;
		case G:
			this.rotateLeft();
			break;
		case A:
			this.moveForward();
			break;
		default:
			throw new IllegalArgumentException("understandInstruction : Instruction not recognized");
		}
	}
	
	
	/***
	 * 
	 * @throws IllegalArgumentException
	 * 
	 * move the Mower according the direction it's pointed to
	 */
	public void moveForward() throws IllegalArgumentException {
		switch(this.currentDirection) {
			case N:
				this.moveUp();
				break;
			case S:
				this.moveDown();
				break;
			case W:
				this.moveWest();
				break;
			case E:
				this.moveEst();
				break;
			default:
				throw new IllegalArgumentException("moveForward:  directions not recognized");
				
		}
	}
	/***
	 * make the mower goes up
	 */
	public void moveUp(){
		this.currentYPosition++;
	}
	
	/***
	 * make the mower goes down
	 */
	public void moveDown(){
		if(this.currentYPosition > 0) {
			this.currentYPosition--;
		}
	}
	/***
	 * make the mower goes west
	 */
	public void moveWest() {
		if(this.currentXPosition > 0) {
			this.currentXPosition--;
		}
	}
	/***
	 * make the mower goes est
	 */
	public void moveEst() {
		this.currentXPosition++;
	}

	
/***
 * 
 * @throws IllegalArgumentException
 * 
 * make the mower rotate right
 */
	public void rotateRight() throws IllegalArgumentException{
		Directions d;
		switch(this.currentDirection) {
			case N:
				d = Directions.E;
				break;
			case E:
				d = Directions.S;
				break;
			case S:
				d = Directions.W;
				break;
			case W:
				d = Directions.N;
				break;
			default :
				throw new IllegalArgumentException("rotateRight: error when rotate");
		}
		this.currentDirection = d;
	}
	
/***
 * 	
 * @throws IllegalArgumentException
 * 
 * make the mower rotate left
 */
	public void rotateLeft() throws IllegalArgumentException{
		Directions d;
		switch(this.currentDirection) {
			case N:
				d = Directions.W;
				break;
			case E:
				d = Directions.N;
				break;
			case W:
				d = Directions.S;
				break;
			case S:
				d = Directions.E;
				break;
			default:
				throw new IllegalArgumentException("rotateLeft: error when rotate");
		}
		this.currentDirection = d;
	}

	
	
	
}
