package percentile;

import java.util.ArrayList;

public class PercentileChooserInteger {

	private ArrayList<Integer> arr;
	private int depthCnt;
	
	public PercentileChooserInteger(int[] inArr){
		arr = new ArrayList<Integer>();
		for(int a : inArr){
			arr.add(a);
		}
	}
	
	public int getNth(int inN){
		return quickSelectNth(arr, inN);
	}
	
	public int getNth_inPlace(int inN){
		depthCnt = 0;
		return quickSelectNth_inPlace(0, arr.size()-1, inN-1);
	}
	
	private int quickSelectNth(ArrayList<Integer> inArr, int inNth){
		
		ArrayList<Integer> lower = new ArrayList<Integer>();
		ArrayList<Integer> higher = new ArrayList<Integer>();
		int sameNum = 0;
		
		int pivot = inArr.get(inArr.size()/2);
		
		for(int a : inArr){
			if(a < pivot){
				lower.add(new Integer(a));
			} else if(a > pivot) {
				higher.add(new Integer(a));
			} else {
				sameNum++;
			}
		}//next elem from inArr
		
		if(inNth <= lower.size()){
			return quickSelectNth(lower, inNth);
		} else if(inNth <= lower.size() + sameNum){
			return pivot;
		} else {
			return quickSelectNth(higher, inNth - lower.size() - sameNum);
		}
		
	}
	
	private int quickSelectNth_inPlace(int idxFrom, int idxTo, int inNth){
		//System.out.println("quickSelectNth_inPlace :: f=" + idxFrom + ", t=" + idxTo + ", n=" + inNth + ", arr=" + arr.toString() );
		depthCnt++;
		if(idxFrom==idxTo || depthCnt>10) return arr.get(idxFrom);
		
		//1st pass: split to smaller and greater-or-equal subarrays
		int pivotIdx = partitionSmaller(idxFrom, idxTo, inNth);
		//System.out.println("   after partitionSmaller :: f=" + idxFrom + ", t=" + idxTo + ", n=" + inNth + ", piv=" + pivotIdx);
		
		if(pivotIdx > inNth){
			//System.out.println("   pivotIdx > inNth");
			return quickSelectNth_inPlace(idxFrom, pivotIdx-1, inNth);
		} else {
			//2nd pass: split the greater-or-equal subarray into an equal and a greater part
			//System.out.println("   pivotIdx <= inNth");
			pivotIdx = partitionGEQ(pivotIdx, idxTo, inNth);
			//System.out.println("   after partitionGEQ :: f=" + idxFrom + ", t=" + idxTo + ", n=" + inNth + ", piv=" + pivotIdx);
			if(pivotIdx >= inNth){
				return arr.get(inNth);
			} else {
				return quickSelectNth_inPlace(pivotIdx, idxTo, inNth - pivotIdx );
			}
		}
	}
	
	private int partitionSmaller(int idxFrom, int idxTo, int inPivotIdx){
		//System.out.println("partitionSmaller :: f=" + idxFrom + ", t=" + idxTo + ", pivIdx=" + inPivotIdx + ", arr=" + arr.toString() );
		
		if(idxFrom==idxTo) return idxFrom;
		
		
		//pick a pivot element
		int pivot = arr.get(inPivotIdx);
		
		//send pivot element to the right
		swap(inPivotIdx, idxTo);
		
		//
		int partitionIdx = idxFrom;
		for(int i=idxFrom; i < idxTo; i++) {
            if(arr.get(i) < pivot) {
                    swap(i, partitionIdx);
                    partitionIdx++;
            }
	    }
		//place back the pivot element
		swap(partitionIdx, idxTo);
		//System.out.println("   results: partitionIdx=" + partitionIdx + ", arr=" + arr.toString());
		
		return partitionIdx;
	}
	
	private int partitionGEQ(int idxFrom, int idxTo, int inPivotIdx){
		//System.out.println("partitionGEQ :: f=" + idxFrom + ", t=" + idxTo + ", pivIdx=" + inPivotIdx + ", arr=" + arr.toString() );
		
		if(idxFrom==idxTo) return idxFrom;
		
		
		//pick a pivot element
		int pivot = arr.get(inPivotIdx);
		
		//send pivot element to the right
		swap(inPivotIdx, idxTo);
		
		//
		int partitionIdx = idxFrom;
		for(int i=idxFrom; i < idxTo; i++) {
            if(arr.get(i) <= pivot) {
                    swap(i, partitionIdx);
                    partitionIdx++;
            }
	    }
		//place back the pivot element
		swap(partitionIdx, idxTo);
		//System.out.println("   results: partitionIdx=" + partitionIdx + ", arr=" + arr.toString());
		
		return partitionIdx;
	}
	
	private void swap(int fromIdx, int toIdx){
		//System.out.println("swap :: f=" + fromIdx + ", t=" + toIdx);
		if(fromIdx==toIdx) return;
		int tmp = arr.get(fromIdx);
		arr.set(fromIdx, arr.get(toIdx));
		arr.set(toIdx, tmp);
	}
	
}
