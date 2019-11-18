import enums.Directions;
import enums.Instructions;

public class Mower {

	private Directions currentDirection;
	private int currentXPosition;
	private int currentYPosition;
	
	
	public Mower(int x, int y, Directions d){
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
	
	
	public void executeInstruction(Instructions instr) throws Exception {
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
			throw new Exception("understandInstruction : Instruction not recognized");
		}
	}
	
	public void moveForward() throws Exception {
		switch(this.currentDirection) {
			case NORTH:
				this.moveUp();
				break;
			case SOUTH:
				this.moveDown();
				break;
			case WEST:
				this.moveWest();
				break;
			case EST:
				this.moveEst();
				break;
			default:
				throw new Exception("moveForward:  directions not recognized");
				
		}
	}
	
	public void moveUp(){
		this.currentYPosition++;
	}
	
	public void moveDown(){
		this.currentYPosition--;
	}
	
	public void moveWest() {
		this.currentXPosition--;
	}
	
	public void moveEst() {
		this.currentXPosition++;
	}

	
// todo: refactor these two methods 
	
	public void rotateRight() throws Exception{
		Directions d;
		switch(this.currentDirection) {
			case NORTH:
				d = Directions.EST;
				break;
			case EST:
				d = Directions.SOUTH;
				break;
			case SOUTH:
				d = Directions.WEST;
				break;
			case WEST:
				d = Directions.NORTH;
				break;
			default :
				throw new Exception("rotateRight: error when rotate");
		}
		this.currentDirection = d;
	}
	
	
	public void rotateLeft() throws Exception{
		Directions d;
		switch(this.currentDirection) {
			case NORTH:
				d = Directions.WEST;
				break;
			case EST:
				d = Directions.NORTH;
				break;
			case WEST:
				d = Directions.SOUTH;
				break;
			case SOUTH:
				d = Directions.EST;
				break;
			default:
				throw new Exception("rotateLeft: error when rotate");
		}
		this.currentDirection = d;
	}

	
	
	
}
