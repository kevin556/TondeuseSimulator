package Sys;

import enums.Directions;
import enums.Instructions;

public class Mower {

	private Directions currentDirection;
	private int currentXPosition;
	private int currentYPosition;
	
	
	public Mower(int x, int y, Directions d) throws IllegalArgumentException{
		if(x <= 0 || y <= 0 ) {
			throw new IllegalArgumentException("Mower constructor: x or y can't be equal to 0 or negative");
		}
		this.currentDirection = d;
		this.currentXPosition = x;
		this.currentYPosition = y;
	}
	
	
	public int getCurrentXPosition() {
		return this.currentXPosition;
	}
	
	public int getCurrentYPosition() {
		return this.currentYPosition;
	}
	
	public Directions getCurrentDirection() {
		return this.currentDirection;
	}
	
	public void showMowerPositionAndDirections() {
		System.out.println("mower " +
	this.currentXPosition +  " y " + this.currentYPosition + " directions " + this.currentDirection);
	}
	
	
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
	
	public void moveUp(){
		this.currentYPosition++;
	}
	
	public void moveDown(){
		if(this.currentYPosition > 0) {
			this.currentYPosition--;
		}
	}
	
	public void moveWest() {
		if(this.currentXPosition > 0) {
			this.currentXPosition--;
		}
	}
	
	public void moveEst() {
		this.currentXPosition++;
	}

	
// todo: refactor these two methods 
	
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
