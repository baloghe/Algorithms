package test.percentile;


import java.util.ArrayList;

import percentile.*;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class TestPercentileChooser {
	
	@Test
	public void test1(){
		int[] arr = new int[]{2,36,5,21,8,13,11,20,5,4,1};
		
		int median_exp = 5;
		int median_act = (new PercentileChooser<Integer>( arrToLst(arr) )).getNth(5);
		
		assertEquals(median_exp, median_act);
		
	}
	
	@Test
	public void test2(){
		int[] arr = new int[]{2,36,5,21,8,13,11,20,5,4,1};
		
		int median_exp = 11;
		int median_act = (new PercentileChooser<Integer>( arrToLst(arr) )).getNth(7);
		
		assertEquals(median_exp, median_act);
		
	}
	
	@Test
	public void test3(){
		int[] arr = new int[]{9,7,8,1,5,3,7,6,8};
		
		int median_exp = 5;
		int median_act = (new PercentileChooser<Integer>( arrToLst(arr) )).getNth(3);
		
		assertEquals(median_exp, median_act);
		
	}
	
	@Test
	public void test4(){
		int[] arr = new int[]{8,5,3,5,1};
		
		int median_exp = 5;
		int median_act = (new PercentileChooser<Integer>( arrToLst(arr) )).getNth(4);
		
		assertEquals(median_exp, median_act);
		
	}
	
	
	
	private ArrayList<Integer> arrToLst(int[] inArr){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		for(int a : inArr){
			ret.add(a);
		}
		
		return ret;
	}
	
}
