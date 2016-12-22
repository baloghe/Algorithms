package dp;

public class CoinChange {

	private int[] values;
	private int[] used;
	
	public CoinChange(int[] inValues){
		values = inValues;
	}
	
	public int solve(int inAmountToChg){
		
		int[][] dyntbl = new int[values.length][1+inAmountToChg];
		
		for(int i=0; i<values.length; i++){
			for(int j=1; j<=inAmountToChg; j++){
				//trivial case: only coin=1 is available
				if(i==0) {
					dyntbl[i][j] = j;
				} else if(j==values[i]) {
					//case 1: there is such a coin that equals to the Amount => 1 coin suffices
					dyntbl[i][j] = 1;
				} else if(j < values[i]) {
					//case 2: ith coin value > amount  => previous solution (with coins up to (i-1)th) is OK
					dyntbl[i][j] = dyntbl[i-1][j];
				} else {
					//case 3 & 4: ith coin value < amount  => either previous solution (with coins up to (i-1)th)   -> leave
					//                                        or     with the use of the ith coin                   -> take
					//            whichever is smaller
					int leave = dyntbl[i-1][j];
					int take  = 1 + dyntbl[i][j-values[i]];
					dyntbl[i][j] = ( leave < take ? leave : take );
					//System.out.println("i=" + i + ", j=" + j + ", leave=" + leave + ", take=" + take);
				}
				
			}//next j
		}//next i
		
		//calc which elems have been used
		used = new int[values.length];
		int j=inAmountToChg;
		int i=values.length-1;
		//System.out.println("calc used  i=" + i + ", j=" + j);
		while(i>=0){
			
			if(i==0){
				used[0] += j;
				j=0;
				i=-1;
				//System.out.println("i==0  => i=" + i + ", j=" + j + ", used[0]=" + used[0]);
			} else if(j==values[i]){
				used[i]++;
				j-=values[i];
				i--;
				//System.out.println("j==values[i]  => i=" + i + ", j=" + j + ", used[i]=" + used[i]);
			} else if(j < values[i]) {
				i--;
				//System.out.println("j < values[i]  => i=" + i + ", j=" + j);
			} else {
				int leave = dyntbl[i-1][j];
				int take  = 1 + dyntbl[i][j-values[i]];
				if(take < leave){
					used[i]++;
					j-=values[i];
					//System.out.println("take < leave  => i=" + i + ", j=" + j + ", used[i]=" + used[i]);
				} else {
					i--;
					//System.out.println("take >= leave  => i=" + i + ", j=" + j);
				}
			}
		}//wend
		
		return dyntbl[values.length-1][inAmountToChg];
	}
	
	public int[] getUsed(){
		return used;
	}
	
}
