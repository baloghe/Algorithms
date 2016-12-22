package dp;

public class MaxSubarray {

	private final int[] array;
	private boolean[] used; 
	
	public MaxSubarray(int[] inArr){
		array = inArr;
	}
	
	public int solve(){
		
		int maxM = array[0];
		int maxIdx = 0;
		int[] m = new int[array.length];
		m[0] = maxM;
		
		for(int i=1; i<array.length; i++){
			if(m[i-1] + array[i] > array[i]){
				//take
				m[i] = m[i-1] + array[i];
			} else {
				//start new window at i
				m[i] = array[i];
			}
			if(m[i] > maxM){
				maxIdx = i;
				maxM = m[i];
			}
		}
		
		//determine what was used
		used = new boolean[array.length];
		boolean found = true;
		int i=maxIdx;
		while(found){
			used[i] = true;
			found = (m[i-1] + array[i] == m[i]);
			i--;
		}		
		
		return maxM;
	}
	
	public boolean[] getUsed(){ return used;}
	
}
