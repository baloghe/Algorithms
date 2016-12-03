package sorter;

public class HeapSorterInteger {

	private int[] arr;
	
	public HeapSorterInteger(int[] inArr){
		arr = inArr;
	}
	
	public int[] sort(){
		sortArray();
		return arr;
	}
	
	private void sortArray(){
		
	}
	
	private void initHeap(int inRootIdx){
		int leftIdx = leftChildIndex( inRootIdx );
		int rightIdx  = rightChildIndex( inRootIdx );
		if( leftIdx < arr.length ){
			initHeap( leftIdx );
		}
		if( rightIdx < arr.length ){
			initHeap( rightIdx );
		}
		sink(inRootIdx);
	}
	
	private void sink(int inRootIdx){
		int leftIdx = leftChildIndex( inRootIdx );
		int rightIdx  = rightChildIndex( inRootIdx );
		int dirIdx;
		
		//determine if sinking is needed
		if( leftIdx > arr.length ) return;
		
		//determine sinking direction
		if( rightIdx > arr.length ){
			dirIdx = leftIdx;
		} else {
			if( arr[leftIdx] > arr[rightIdx] ){
				dirIdx = leftIdx;
			} else {
				dirIdx = rightIdx;
			}
		}
		
		//sink if needed
		if( arr[inRootIdx] < arr[dirIdx] ){
			int swapElem = arr[inRootIdx];
			arr[inRootIdx] = arr[dirIdx];
			arr[dirIdx] = swapElem;
			
			sink(dirIdx);
		}
	}
	
	private int leftChildIndex(int inIdx){
		return 2 * inIdx;
	}
	
	private int rightChildIndex(int inIdx){
		return 2 * inIdx + 1;
	}
	
	private int parentIndex(int inIdx){
		return inIdx / 2;
	}
}
