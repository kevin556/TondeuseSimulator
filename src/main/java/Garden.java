
public class Garden {
	
	static Boolean[][] garden;
	private int height;
	private int witdth;

	
	public Garden ( int x,int y ) throws Exception {
		if (this.height <= 0 || this.witdth <= 0) {
			throw new IllegalArgumentException("height or width can't be equal to 0 or negative");
		}		
		this.height = y;
		this.witdth = x;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.witdth;
	}
	
	
	public void showGarden() {
		for(int i = 0 ; i < garden.length; i++ ) {
			for ( int j = 0 ; j < garden[0].length; j++ ) {
				System.out.print(garden[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
}
