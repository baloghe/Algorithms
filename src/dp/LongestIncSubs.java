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
				} else if(actNum <= firstheaptop) {
					//then the actual number should be inserted into the first position
					heaps.set(0, i);
					prevs[i] = -1;
					firstheaptop = actNum;
				} else {
					//find the first heap (with binary search) having top element bigger than actNum
					int firstGEIdx = getFirstGEIdx(heaps, actNum);
					//System.out.println("      binSearch: actNum=" + actNum + ", heaps=" + heaps + ", firstGEIdx=" + firstGEIdx + ", firstheaptop=" + firstheaptop + ", lastheaptop=" + lastheaptop);
					heaps.set(firstGEIdx, i);
					prevs[i] = heaps.get(firstGEIdx - 1);
					//lastheaptop changed only if this happened to be the last heap
					if(firstGEIdx == heaps.size()-1){
						lastheaptop = actNum;
					}
				}//endif
			}//endif
			if(heaps.size()==1){
				firstheaptop = array[heaps.get(0)];
				lastheaptop = firstheaptop;
			}
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
	
	private int getFirstGEIdx(ArrayList<Integer> inList, int inNum){
		//trivia
		if(inNum <= array[inList.get(0)]) return 0;
		if(inNum > array[inList.get(inList.size()-1)]) return -1;
		
		//binSearch
		int lo = 0;
		int hi = inList.size()-1;
		int mid = (lo + hi) / 2;
		while(lo <= hi){
			int tmpnum = array[inList.get(mid)];
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
}
