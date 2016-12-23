package test.dp;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import dp.*;

public class TstBinSearch {

	@Test
	public void tst_ge1(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstGEIdx(4);
		int exp = 1;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_ge2(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstGEIdx(8);
		int exp = 2;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_ge3(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstGEIdx(1);
		int exp = 0;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_ge4(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstGEIdx(15);
		int exp = -1;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_ge5(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstGEIdx(3);
		int exp = 0;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_ge6(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstGEIdx(6);
		int exp = 1;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_ge7(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstGEIdx(9);
		int exp = 2;
		
		assertEquals(exp, act);
	}
	
	
	
	
	
	@Test
	public void tst_le1(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstLEIdx(4);
		int exp = 0;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_le2(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstLEIdx(8);
		int exp = 1;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_le3(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstLEIdx(1);
		int exp = -1;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_le4(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstLEIdx(15);
		int exp = 2;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_le5(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstLEIdx(3);
		int exp = 0;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_le6(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstLEIdx(6);
		int exp = 1;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_le7(){
		int[] array = new int[]{3, 6, 9};
		
		BinSearch bs = new BinSearch(array);
		
		int act = bs.getFirstLEIdx(9);
		int exp = 2;
		
		assertEquals(exp, act);
	}
	
}
