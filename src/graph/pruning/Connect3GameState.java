package graph.pruning;

public class Connect3GameState {

	/* board cell values:
	 *   0  at startup
	 *   1  for ROOT player
	 *   2  for OPPONENT
	 */
	public static final int MARK_ROOT = 1;
	public static final int MARK_OPPONENT = 2;
	
	private int[][] table;
	
	public Connect3GameState(){
		table = new int[3][3];
	}
	
	public Connect3GameState(int[][] inTable){
		table = inTable;
	}
	
	public int[][] getTable(){
		return table.clone();
	}
	
	public void setCell(int inR, int inC, int inVal){
		table[inR][inC] = inVal;
	}
	
	public Connect3GameState deepCopy(){
		int[][] tmptbl = new int[3][3];
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				tmptbl[i][j] = table[i][j];
			}
		}
		return new Connect3GameState(tmptbl);
	}
	
	public String toString2(){
		String ret = (table[0][0]==0 ? " " : Integer.toString(table[0][0]));
		for(int c=1; c<3; c++){
			ret += ("|" + (table[0][c]==0 ? " " : Integer.toString(table[0][c])) );
		}//next c
		for(int r=1; r<3; r++){
			ret += "\n-----\n";
			ret += (table[r][0]==0 ? " " : Integer.toString(table[r][0]));
			for(int c=1; c<3; c++){
				ret += ("|" + (table[r][c]==0 ? " " : Integer.toString(table[r][c])) );
			}//next c
		}//next r
		return ret;
	}
	
	public String toString(){
		String ret = (table[0][0]==0 ? " " : Integer.toString(table[0][0]));
		for(int c=1; c<3; c++){
			ret += ( (table[0][c]==0 ? " " : Integer.toString(table[0][c])) );
		}//next c
		for(int r=1; r<3; r++){
			ret += "\n";
			ret += (table[r][0]==0 ? " " : Integer.toString(table[r][0]));
			for(int c=1; c<3; c++){
				ret += ( (table[r][c]==0 ? " " : Integer.toString(table[r][c])) );
			}//next c
		}//next r
		return ret;
	}
	
	public boolean equals(Object obj){
		if(!(obj instanceof Connect3GameState)) return false;
		int[][] objt = ((Connect3GameState)obj).getTable();
		boolean ret = true;
		for(int r = 0; r < 3; r++){
			for(int c = 0; c < 3; c++){
				ret = ret && ( table[r][c] == objt[r][c] );
			}
		}
		return ret;
	}
}
