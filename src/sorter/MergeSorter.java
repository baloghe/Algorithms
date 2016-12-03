package sorter;

import java.util.List;

/**
 * In-place merge sorter for Lists containing Comparable items. Uses recursion
 * Based on S. Dasgupta, C. H. Papadimitriou, and U. V. Vazirani: Algorithms, 7/18/2006, p. 56.
 *
 * @param <T> list items' type
 */
public class MergeSorter<T extends Comparable<T>> {

	private List<T> listToSort;
	
	/**
	 * sorts the list and returns it
	 * @param inCollection
	 * @return sorted list
	 */
	public List<T> sort(List<T> inCollection){
		listToSort = inCollection;
		sortInPlace(0, listToSort.size() - 1);
		return listToSort;
	}
	
	/**
	 * recursively sorts the list segment between indices [fromIdx, toIdx]
	 * @param fromIdx segment start (inclusive)
	 * @param toIdx segment end (inclusive)
	 */
	private void sortInPlace(int fromIdx, int toIdx){
		//trivia
		if(fromIdx==toIdx) return;
		
		//divide
		int up = fromIdx + (toIdx - fromIdx) / 2;
		//System.out.println("sortInPlace :: fromIdx=" + fromIdx + ", toIdx=" + toIdx + ", up=" + up);
		sortInPlace(fromIdx, up);
		sortInPlace(up+1 , toIdx);
		
		//conquer
		merge(fromIdx, up, up+1 , toIdx);
	}
	
	/**
	 * recursively merges two neighboring list segments
	 * @param fromIdx1 segment 1 start (inclusive)
	 * @param toIdx1 segment 1 end (inclusive)
	 * @param fromIdx2 segment 2 start (inclusive) == toIdx1+1
	 * @param toIdx2 segment 2 end (inclusive)
	 */
	private void merge(int fromIdx1, int toIdx1, int fromIdx2, int toIdx2){
		//System.out.println("merge :: fromIdx1=" + fromIdx1 + ", toIdx1=" + toIdx1 + ", fromIdx2=" + fromIdx2 + ", toIdx2=" + toIdx2);
		//if either part is void, do nothing
		if(fromIdx1>toIdx1 || fromIdx2>toIdx2) return;
		
		//otherwise: inspect the first elements
		//and bring 
		if( listToSort.get(fromIdx1).compareTo(listToSort.get(fromIdx2)) < 0 ){
			//elem at fromIdx1 left intact
			//fromIdx1 step forward
			//fromIdx2, toIdx2 unchanged
			fromIdx1++;
			//System.out.println("   -> 1st branch, result: " + toString());
		} else {
			//elem at fromIdx1 left intact
			//elem at fromIdx2 brought to (fromIdx1+1)
			//former (fromIdx1+1,...,toIdx1) shifted to the right by 1
			//fromIdx1, toIdx1, fromIdx2 step forward
			T tmp = listToSort.get(fromIdx2);
			//shift
			for(int i=fromIdx2; i>fromIdx1; i--){
				listToSort.set(i, listToSort.get(i-1));
			}//next i
			listToSort.set(fromIdx1, tmp);
			fromIdx1++;
			toIdx1++;
			fromIdx2++;
			//System.out.println("   -> 2nd branch, result: " + toString());
		}
		//recursive call
		merge(fromIdx1, toIdx1, fromIdx2, toIdx2);
	}
	
	public String toString(){
		return listToSort.toString();
	}
}
