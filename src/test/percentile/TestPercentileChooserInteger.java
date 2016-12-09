package test.percentile;

import percentile.*;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class TestPercentileChooserInteger {

	@Test
	public void test1(){
		
		int[] arr = new int[]{2,36,5,21,8,13,11,20,5,4,1};
		
		int median_exp = 5;
		int median_act = new PercentileChooserInteger(arr).getNth(5);
		
		assertEquals(median_exp, median_act);
		
	}
	
	@Test
	public void test2(){
		
		int[] arr = new int[]{2,36,5,21,8,13,11,20,5,4,1};
		
		int nth_exp = 11;
		int nth_act = new PercentileChooserInteger(arr).getNth(7);
		
		assertEquals(nth_exp, nth_act);
		
	}
	
	@Test
	public void test3(){
		
		int[] arr = new int[]{9,7,8,1,5,3,7,6,8};
		
		int nth_exp = 5;
		int nth_act = new PercentileChooserInteger(arr).getNth_inPlace(3);
		
		assertEquals(nth_exp, nth_act);
		
	}
	
	@Test
	public void test4(){
		
		//int[] arr = new int[]{2,36,5,21,8,13,11,20,5,4,1};
		int[] arr = new int[]{8,5,3,5,1};
		
		int nth_exp = 5;
		int nth_act = new PercentileChooserInteger(arr).getNth_inPlace(4);
		
		assertEquals(nth_exp, nth_act);
		
	}
	
	@Test
	public void test5(){
		
		int[] arr = new int[]{2,36,5,21,8,13,11,20,5,4,1};
				
		int nth_exp = 5;
		int nth_act = new PercentileChooserInteger(arr).getNth_inPlace(5);
		
		assertEquals(nth_exp, nth_act);
		
	}
}
