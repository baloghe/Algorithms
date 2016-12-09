package percentile;

import java.util.List;

public class PercentileChooser<T extends Comparable<T>> {

	private List<T> arr;
	//private int depthCnt;
	
	public PercentileChooser(List<T> inArr){
		arr = inArr;
	}
	
	public T getNth(int inN){
		if(arr == null) return null;
		if(arr.size() < 1) return null;
		if(arr.size() < inN) return null;
		
		//depthCnt = 0;
		
		return selectNth(0, arr.size()-1, inN-1);
	}
	
	private T selectNth(int fromIdx, int toIdx, int inNidx){
		//depthCnt++;
		//System.out.println("selectNth :: fromIdx=" + fromIdx + ", toIdx=" + toIdx + ", inNidx=" + inNidx);
		if(fromIdx==toIdx /*|| depthCnt > 10*/) return arr.get(inNidx);
		
		//partition to Smaller / GEQ
		int partitionIdx = partition(fromIdx,toIdx,inNidx,false);
		//System.out.println(   "partition results: partitionIdx=" + partitionIdx + ", arr=" + arr);
		
		//inspect three subarrays independently
		if(partitionIdx > inNidx){
			//System.out.println("   partitionIdx > inNidx");
			return selectNth(fromIdx, partitionIdx-1, inNidx);
		} else {
			//System.out.println("   partitionIdx <= inNidx => see upper side ==(" + partitionIdx + "," + toIdx + ")");
			partitionIdx = partition(partitionIdx,toIdx,inNidx,true);
			//System.out.println("     new partitionIdx=" + partitionIdx + ", arr=" + arr);
			if(partitionIdx >= inNidx){
				//System.out.println("     GEQ");
				return arr.get(inNidx);
			} else {
				//System.out.println("     UPPER => rec call");
				return selectNth(partitionIdx,toIdx,inNidx);
			}
		}
	}
	
	private int partition(int fromIdx, int toIdx, int inPivotIdx, boolean inEqEnabled){
		
		//pick the pivot element
		T pivotElem = arr.get(inPivotIdx);
		
		//send pivot element to the right
		swap(inPivotIdx, toIdx);
		/* at any time: 
		 *   inEqEnabled=false =>
		 *     elems to the left from partitionIdx are smaller than pivotElem
		 *     elems at partitionIdx and to the right are equal to or greater than pivotElem
		 *    
		 *   inEqEnabled=true =>
		 *     elems at partitionIdx or left from partitionIdx are smaller than or equal to pivotElem
		 *     elems to the right from partitionIdx are greater than pivotElem
		 */
		int partitionIdx = fromIdx;
		for(int i=fromIdx; i < toIdx; i++) {
			int compres = arr.get(i).compareTo(pivotElem);
            if(compres < 0 || (inEqEnabled && compres==0) ) {
                    swap(i, partitionIdx);
                    partitionIdx++;
            }
	    }
		//place back the pivot element
		swap(partitionIdx, toIdx);
		
		return partitionIdx;
		
	}
	
	private void swap(int fromIdx, int toIdx){
		//System.out.println("swap :: f=" + fromIdx + ", t=" + toIdx);
		if(fromIdx==toIdx) return;
		T tmp = arr.get(fromIdx);
		arr.set(fromIdx, arr.get(toIdx));
		arr.set(toIdx, tmp);
	}
	
}
