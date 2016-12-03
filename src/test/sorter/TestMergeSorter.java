package test.sorter;

import java.util.ArrayList;

import sorter.*;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class TestMergeSorter {
	
	@Test
	public void testSorter(){
		ArrayList<Integer> lst = new ArrayList<Integer>();
		lst.add(new Integer(1));
		lst.add(new Integer(3));
		lst.add(new Integer(5));
		lst.add(new Integer(7));
		lst.add(new Integer(2));
		lst.add(new Integer(4));
		lst.add(new Integer(6));
		lst.add(new Integer(8));
		
		ArrayList<Integer> lst_exp = new ArrayList<Integer>();
		lst_exp.add(new Integer(1));
		lst_exp.add(new Integer(2));
		lst_exp.add(new Integer(3));
		lst_exp.add(new Integer(4));
		lst_exp.add(new Integer(5));
		lst_exp.add(new Integer(6));
		lst_exp.add(new Integer(7));
		lst_exp.add(new Integer(8));
		
		MergeSorter<Integer> sorter = new MergeSorter<Integer>();
		sorter.sort(lst);
		System.out.println("testSorter: " + sorter.toString());
		
		assertEquals( lst_exp , lst);
	}
	
}
