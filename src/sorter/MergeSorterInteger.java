package sorter;

public class MergeSorterInteger {

	public Integer[] sort(Integer[] inArray){
		if(inArray==null) return null;
		if(inArray.length < 2) return inArray;
		int up = inArray.length / 2;
		Integer[] lower = new Integer[up];
		Integer[] upper = new Integer[inArray.length - up];
		for(int i=0; i<up; i++){
			lower[i] = inArray[i];
		}
		for(int i=up; i<inArray.length; i++){
			upper[i - up] = inArray[i];
		}
		//System.out.println("sort: lower.length=" + lower.length + ", upper.length=" + upper.length);
		return merge( sort(lower), sort(upper) );
	}
	
	
	public Integer[] merge(Integer[] inArr1 , Integer[] inArr2){
		//System.out.println("merge: inArr1.length=" + inArr1.length + ", inArr2.length=" + inArr2.length);
		if(inArr1.length == 0) return inArr2;
		if(inArr2.length == 0) return inArr1;
		if( inArr1[0] < inArr2[0] ){
			Integer[] inArr1Rem = new Integer[inArr1.length - 1];
			for(int i=1; i<inArr1.length; i++){
				inArr1Rem[i-1] = inArr1[i];
			}
			return concat( new Integer[]{inArr1[0]} , merge(inArr1Rem, inArr2) );
		} else {
			Integer[] inArr2Rem = new Integer[inArr2.length - 1];
			for(int i=1; i<inArr2.length; i++){
				inArr2Rem[i-1] = inArr2[i];
			}
			return concat( new Integer[]{inArr2[0]} , merge(inArr1, inArr2Rem) );
		}
		
	}
	
	public Integer[] concat(Integer[] inArr1 , Integer[] inArr2){
		Integer[] ret = new Integer[inArr1.length + inArr2.length];
		
		for(int i=0; i<inArr1.length; i++){
			ret[i] = inArr1[i];
		}
		for(int i=inArr1.length; i<inArr1.length + inArr2.length; i++){
			ret[i] = inArr2[i-inArr1.length];
		}
		
		return ret;
	}
	
}
