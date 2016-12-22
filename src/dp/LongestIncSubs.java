package dp;

import java.util.ArrayList;

public class LongestIncSubs {

	private final int[] array;
	private int[] longestseq;
	
	public LongestIncSubs(int[] inArr){
		array = inArr;
	}
	
	public int solve(){
		
		ArrayList<Integer> heaps = new ArrayList<Integer>();
		int[] prevs = new int[array.length];
		
		boolean firstElem = true;
		int lastheaptop = 0;
		int firstheaptop = 0;
		for(int i=0; i<array.length; i++){
			int actNum = array[i];
			if(firstElem){
				//ArrayList<Integer> tmpheap = new ArrayList<Integer>();
				heaps.add(0);
				lastheaptop = actNum;
				firstheaptop = actNum;
				prevs[0] = -1;
				firstElem = false;
			} else {
				//first see if the actual number is bigger than the last heap-top OR smaller than the first heap-top
				if(actNum > lastheaptop){
					//then a new heap must born
					//ArrayList<Integer> tmpheap = new ArrayList<Integer>();
					heaps.add(i);
					prevs[i] = heaps.get(heaps.size()-2);
					lastheaptop = actNum;
				} else if(actNum < firstheaptop) {
					//then the actual number should be inserted into the first position
					heaps.set(0, i);
					prevs[i] = -1;
					firstheaptop = actNum;
				} else {
					//find the first heap (with binary search) having top element bigger than actNum
					int lo = 0;
					int hi = heaps.size()-1;
					int mid = (lo+hi) / 2;
					while( lo < mid ){
						int tmptop = array[heaps.get(mid)];
						if( actNum > tmptop ){
							lo = mid + 1;
						} else if( actNum < tmptop ){
							hi = mid - 1;
						} else {
							hi = mid;
							break;
						}
						mid = (lo+hi) / 2;
					}//wend
					//System.out.println("  binker: actNum=" + actNum + ", lo=" + lo + ", mid=" + mid + ", hi=" + hi + ", heap(lo,mid,hi)=" + heaps.get(lo).get(0) + ", " + heaps.get(mid).get(0) + ", " + heaps.get(hi).get(0));
					//now heaps[hi] >= actNum > heaps[lo]  ==>  must insert to heaps[hi]
					heaps.set(hi, i);
					prevs[i] = heaps.get(hi - 1);
					//lastheaptop changed only if this happened to be the last heap
					if(hi == heaps.size()-1){
						lastheaptop = actNum;
					}
				}//endif
			}//endif
			
			//System.out.println("    " + i + ". prevs=" + intArrToString(prevs) );
			//System.out.println("        heaps=" + heaps );
		}//next actNum from array
		
		//construct LIS
		longestseq = new int[heaps.size()];
		int idx = heaps.size()-1;
		for (int i = heaps.get(heaps.size()-1); i >= 0; i = prevs[i]){
			//System.out.println("  longestseq=" + intArrToString(longestseq)  + "  ,  i=" + i + ", array[heaps.get(i)]=" + array[heaps.get(i)]);
			longestseq[idx] = array[i];
			idx--;
		}
		
		return heaps.size();
	}
	
	public int[] getLongestSequence(){return longestseq;}
	
	private String intArrToString(int[] inArr){
		if(inArr==null){
			return "NULL";
		} else if(inArr.length==0){
			return "EMPTY";
		} else {
			String ret = Integer.toString( inArr[0] );
			for(int i=1; i<inArr.length; i++){
				ret += (", " + inArr[i]);
			}
			return ret;
		}
	}
}
