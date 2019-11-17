
public class Garden {
	
	static Boolean[][] garden;
	int height;
	int witdth;

	
	public Garden ( int x,int y ) {
		this.height = y;
		this.witdth = x;
		garden = new Boolean[this.witdth][this.height];
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
