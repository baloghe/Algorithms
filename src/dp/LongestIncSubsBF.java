package dp;

public class LongestIncSubsBF {

	private final int[] array;
	private int[] maxs;
	private int[] prvs;
	
	private int[] longestseq;
	
	public LongestIncSubsBF(int[] inArr){
		array = inArr;
	}
	
	public int solve(){
		
		maxs = new int[array.length];
		prvs = new int[array.length];
		
		maxs[0] = 1;
		prvs[0] = -1;
		int maxlen = 1;
		int maxendidx = 0;
		
		for(int i=1; i<array.length; i++){
			int tmp = -1;
			int tmpidx = -1;
			for(int j=0; j<i; j++){
				/* maxker for MAXS(<i) supposed ARRAY[i] > ARRAY[<i] */
				if(   array[i] > array[j]
				   && maxs[j] + 1 > tmp){
					tmp = maxs[j] + 1;
					tmpidx = j;
				}
			}//next j
			/* if no such j found then new sequence is opened (currently ending at i) */
			if(tmp < 0){
				tmp = 1;
				tmpidx = -1;
			}
			/* length of Longest Increasing Subsequence ending at i */
			maxs[i] = tmp;
			prvs[i] = tmpidx;
			/* bookkeeping for len(LIS) so far */
			if( maxs[i] > maxlen ){
				maxlen = maxs[i];
				maxendidx = i;
			}
		}//next i
		
		/* Construct longest sequence */
		if(maxlen > 1){
			longestseq = new int[maxlen];
			int tmpidx = maxendidx;
			//System.out.println("maxlen=" + maxlen + ", tmpidx=" + tmpidx);
			for(int i=maxlen-1; i>0; i--){
				longestseq[i] = array[tmpidx];
				tmpidx = (prvs[tmpidx] >= 0 ? prvs[tmpidx] : tmpidx);
				//System.out.println("  tmpidx=" + tmpidx);
			}
			//last index
			longestseq[0] = array[tmpidx];
		} else {
			longestseq = new int[]{ array[maxendidx] };
		}
		return maxlen;
	}
	
	public int[] getLongestSequence(){return longestseq;}
	
}
