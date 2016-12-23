package dp;

public class BinSearch {

	private final int[] array;
	
	public BinSearch(int[] inArr){
		array = inArr;
	}
	
	public int getFirstGEIdx(int inNum){
		//trivia
		if(inNum <= array[0]) return 0;
		if(inNum > array[array.length-1]) return -1;
		
		//binSearch
		int lo = 0;
		int hi = array.length-1;
		int mid = (lo + hi) / 2;
		while(lo <= hi){
			int tmpnum = array[mid];
			//System.out.println("GE in: lo=" + lo + ", mid=" + mid + ", hi=" + hi + ", tmpnum=" + tmpnum);
			if( tmpnum > inNum ){
				hi = mid - 1;
			} else if(tmpnum < inNum){
				lo = mid + 1;
			} else {
				lo=mid-1;
				hi=mid-1;
				break;
			}
			mid = (lo + hi) / 2;
			//System.out.println("GE out: lo=" + lo + ", mid=" + mid + ", hi=" + hi);
		}//wend
		return hi + 1;
	}
	
	public int getFirstLEIdx(int inNum){
		//trivia
				if(inNum < array[0]) return -1;
				if(inNum >= array[array.length-1]) return array.length-1;
				
				//binSearch
				int lo = 0;
				int hi = array.length-1;
				int mid = (lo + hi) / 2;
				while(lo <= hi){
					int tmpnum = array[mid];
					System.out.println("GE in: lo=" + lo + ", mid=" + mid + ", hi=" + hi + ", tmpnum=" + tmpnum);
					if( tmpnum > inNum ){
						hi = mid - 1;
					} else if(tmpnum < inNum){
						lo = mid + 1;
					} else {
						lo=mid;
						hi=mid;
						break;
					}
					mid = (lo + hi) / 2;
					System.out.println("GE out: lo=" + lo + ", mid=" + mid + ", hi=" + hi);
				}//wend
				return hi;
	}
	
}
