package graph.pruning;


/**
 * Game state object for Google Code Jam 2015 / Round 1C / Problem A: Brattleship
 * 
 * An Battleship game is played with a single horizontal ship. ROOT guesses a cell. OPPONENT might move the ship before reporting whether it was a HIT or a MISS.
 * However, OPPONENT can only move the ship to a position which conforms to previous guesses and their reported results.
 * The game ends when the ship is sunk (== number of reported HITs equals to the ship length).
 */
public class GcjGameState {

	/* board cell values:
	 *   0  at startup
	 *   1  for Guessing but MISSed
	 *   2  for Guessing and HIT
	 */
	public static final int MARK_ROOT = 1;
	public static final int MARK_OPPONENT = 2;
	
	private int[][] table;
	private int shipLen;
	private int rowNum;
	private int colNum;
	
	/**
	 * 1 by inColNum board and a ship with given inShipLen
	 * @param inColNum number of board columns
	 * @param inShipLen length of ship
	 */
	public GcjGameState(int inColNum, int inShipLen){
		table = new int[1][inColNum];
		rowNum = 1;
		colNum = inColNum;
		shipLen = inShipLen;
	}
	
	/**
	 * inRowNum by inColNum board and a ship with given inShipLen
	 * @param inRowNum number of board rows
	 * @param inColNum number of board columns
	 * @param inShipLen length of ship
	 */
	public GcjGameState(int inRowNum, int inColNum, int inShipLen){
		table = new int[inRowNum][inColNum];
		rowNum = inRowNum;
		colNum = inColNum;
		shipLen = inShipLen;
	}
	
	/**
	 * create an object with a given board and a ship with given inShipLen
	 * @param inTable board
	 * @param inShipLen length of ship
	 */
	public GcjGameState(int[][] inTable, int inShipLen){
		table = inTable;
		rowNum = table.length;
		colNum = table[0].length;
		shipLen = inShipLen;
	}
	
	/**
	 * sets a given board cell to a given value
	 * @param inR row position of the cell
	 * @param inC column position of the cell
	 * @param inVal value to be set
	 */
	public void setCell(int inR, int inC, int inVal){
		table[inR][inC] = inVal;
	}
	
	/**
	 * inspect a cell whether it can or cannot be a HIT (taking into account that our little brother is able to move the ship as long as new ship position conforms with previous guesses made)
	 * @param inR row position of the cell
	 * @param inC column position of the cell
	 * @return 0 if both a HIT and a MISS can occur; 1 if it can only be a MISS; 2 if it can only be a HIT; -1 if the ship cannot be placed in a valid position on the board
	 */
	public int guess(int inR, int inC){
		int ret = -1;
		boolean canBeHIT = false;
		boolean canBeMISS = false;
		for(int r=0; r<rowNum; r++){
			for(int c=0; c<colNum-shipLen+1; c++){
				if(shipPositionValid(r,c)){
					//first valid ship position found => at least the guess will be either a HIT or a MISS
					if(ret<0) ret = 0;
					
					//check if the guess overlaps with the ship
					if(r==inR && c <= inC && inC <= c+shipLen-1){
						canBeHIT = true;
					} else {
						canBeMISS = true;
					}
				}//valid ship position found
			}//next c
		}//next r
		if(ret > 0 && canBeHIT && (!canBeMISS)) ret = 2;
		else if(ret > 0 && canBeMISS && (!canBeHIT)) ret = 1;
		
		return ret;
	}
	
	/**
	 * tells if a board cell has been guessed already
	 * @param inR row position of the cell
	 * @param inC column position of the cell
	 * @return TRUE if a guess has been made so far; FALSE otherwise
	 */
	public boolean guessedAlready(int inR, int inC){
		return (table[inR][inC] > 0);
	}
	
	/**
	 * a horizontal ship CAN HAVE its first cell at (inR, inC) IF
	 *   1) the ship fits into the board, that is: cell inC+ShipLen-1 <= colNum 
	 *   2) all cells in range [(inR, inC) .. (inR, inC+ShipLen-1)] are either a HIT or have not been guessed so far
	 * @param inR
	 * @param inC
	 * @return
	 */
	public boolean shipPositionValid(int inR, int inC){
		if(colNum <= inC+shipLen-1) return false;
		for(int c=inC; c<=inC+shipLen-1; c++){
			if( table[inR][c] == 1 ) return false;
		}
		//if no violation so far, it must be a valid position
		return true;
	}
	
	public int[][] getTable(){return table;}
	public int getRowNum(){return rowNum;}
	public int getColNum(){return colNum;}
	public int getShipLen(){return shipLen;}
	
	/**
	 * copy entire board & ship length
	 * @return hardcopy of game state
	 */
	public GcjGameState deepCopy(){
		int[][] tmptbl = new int[rowNum][colNum];
		for(int i=0; i<rowNum; i++){
			for(int j=0; j<colNum; j++){
				tmptbl[i][j] = table[i][j];
			}
		}
		return new GcjGameState(tmptbl, shipLen);
	}
	
	public String toString(){
		String ret = "";
		for(int c=0; c<colNum; c++){
			ret += ( (table[0][c]==0 ? "_" : Integer.toString(table[0][0])) );
		}//next c
		for(int r=1; r<rowNum; r++){
			ret += "\n";
			for(int c=0; c<colNum; c++){
				ret += ( (table[r][c]==0 ? "_" : Integer.toString(table[0][0])) );
			}//next c
		}//next r
		return ret;
	}
	
	public boolean equals(Object obj){
		if(!(obj instanceof GcjGameState)) return false;
		
		int[][] objt = ((GcjGameState)obj).getTable();
		int ro = objt.length;
		int co = objt[0].length;
		int sl = ((GcjGameState)obj).getShipLen();
		
		//check if board dimensions and ship lengths equal
		if(ro!=rowNum || co!=colNum || sl != shipLen) return false;
		
		//moreover: compare board cell-by-cell
		boolean ret = true;
		for(int r = 0; r < rowNum; r++){
			for(int c = 0; c < colNum; c++){
				ret = ret && ( table[r][c] == objt[r][c] );
			}
		}
		return ret;
	}
	
}
