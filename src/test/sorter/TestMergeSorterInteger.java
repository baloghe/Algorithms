package test.sorter;

import sorter.*;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class TestMergeSorterInteger {

	@Test
	public void testSorter(){
		Integer[] allDifferent = new Integer[]{new Integer(3), new Integer(1), new Integer(5), new Integer(2), new Integer(7)};
		Integer[] allDiff_exp  = new Integer[]{new Integer(1), new Integer(2), new Integer(3), new Integer(5), new Integer(7)};
		
		Integer[] someEquals  = new Integer[]{new Integer(3), new Integer(1), new Integer(3), new Integer(2), new Integer(2)};
		Integer[] someEqu_exp = new Integer[]{new Integer(1), new Integer(2), new Integer(2), new Integer(3), new Integer(3)};
		
		MergeSorterInteger sorter = new MergeSorterInteger();
		Integer[] allDiff_act = sorter.sort(allDifferent);
		Integer[] someEqu_act = sorter.sort(someEquals);
		
		assertArrayEquals( allDiff_exp , allDiff_act);
		assertArrayEquals( someEqu_exp , someEqu_act);
	}
	
	@Test
	public void testSmall(){
		Integer[] lst = new Integer[]{ new Integer(3) };
		Integer[] lst_exp = new Integer[]{ new Integer(3) };
		
		MergeSorterInteger sorter = new MergeSorterInteger();
		Integer[] lst_act = sorter.sort(lst);
		
		assertArrayEquals( lst_exp , lst_act);
	}
	
	@Test
	public void testEmpty(){
		Integer[] lst = new Integer[]{ };
		Integer[] lst_exp = new Integer[]{ };
		
		MergeSorterInteger sorter = new MergeSorterInteger();
		Integer[] lst_act = sorter.sort(lst);
		
		assertArrayEquals( lst_exp , lst_act);
	}
	
	@Test
	public void testNull(){
		Integer[] lst = null;
		Integer[] lst_exp = null;
		
		MergeSorterInteger sorter = new MergeSorterInteger();
		Integer[] lst_act = sorter.sort(lst);
		
		assertArrayEquals( lst_exp , lst_act);
	}
	
}
