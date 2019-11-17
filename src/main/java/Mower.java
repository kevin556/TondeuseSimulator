import enums.Directions;

public class Mower {

	Directions currentDirection;
	int currentXPosition;
	int currentYPosition;
	
	
	public Mower(int x, int y, Directions d){
		this.currentDirection = d;
		this.currentXPosition = x;
		this.currentYPosition = y;
	}
	
	
	public void showMowerPositionAndDirections() {
		System.out.println("mower " +
	this.currentXPosition +  " y " + this.currentYPosition + " directions " + this.currentDirection);
	}
	
	public void moveForward() {
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
				break;
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
	
	public void rotateRight() {
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
				d = this.currentDirection;
				break;
		}
		this.currentDirection = d;
	}
	
	
	public void rotateLeft() {
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
				d = this.currentDirection;
				break;
		}
		this.currentDirection = d;
	}

	
	
	
}
