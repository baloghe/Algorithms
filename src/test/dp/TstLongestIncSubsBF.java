package test.dp;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import dp.*;

public class TstLongestIncSubsBF {
	
	@Test
	public void tst_res1(){
		
		int[] arr = new int[]{3};
		LongestIncSubsBF s = new LongestIncSubsBF(arr);
		
		System.out.println("tst_res1:");
		
		int exp = 1;
		int act = s.solve();
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_res2(){
		
		int[] arr = new int[]{3, 4, 1, 5};
		LongestIncSubsBF s = new LongestIncSubsBF(arr);
		
		System.out.println("tst_res2:");
		
		int exp = 3;
		int act = s.solve();
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_slen1(){
		
		System.out.println("tst_slen1:");
		
		int[] arr = new int[]{3};
		LongestIncSubsBF s = new LongestIncSubsBF(arr);
		s.solve();
		
		int exp = 1;
		int act = s.getLongestSequence().length;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_slen2(){
		
		System.out.println("tst_slen2:");
		
		int[] arr = new int[]{3, 4, 1, 5};
		LongestIncSubsBF s = new LongestIncSubsBF(arr);
		s.solve();
		
		int exp = 3;
		int act = s.getLongestSequence().length;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_scont1(){
		
		System.out.println("tst_scont1:");
		
		int[] arr = new int[]{3};
		LongestIncSubsBF s = new LongestIncSubsBF(arr);
		s.solve();
		
		int[] exp = new int[]{3};
		int[] act = s.getLongestSequence();
		
		ArrayList<Integer> lexp = arrToLst(exp);
		ArrayList<Integer> lact = arrToLst(act);
		
		assertEquals(lexp, lact);
	}
	
	@Test
	public void tst_scont2(){
		
		System.out.println("tst_scont2:");
		
		int[] arr = new int[]{3,4,1,5};
		LongestIncSubsBF s = new LongestIncSubsBF(arr);
		s.solve();
		
		int[] exp = new int[]{3,4,5};
		int[] act = s.getLongestSequence();
		
		ArrayList<Integer> lexp = arrToLst(exp);
		ArrayList<Integer> lact = arrToLst(act);
		
		assertEquals(lexp, lact);
	}
	
	@Test
	public void tst_scont3(){
		
		System.out.println("tst_scont2:");
		
		int[] arr = new int[]{3, 7, 16, 19, 2, 8, 1, 14, 7, 9};
		LongestIncSubsBF s = new LongestIncSubsBF(arr);
		s.solve();
		
		int[] exp = new int[]{3, 7, 16, 19};
		int[] act = s.getLongestSequence();
		
		ArrayList<Integer> lexp = arrToLst(exp);
		ArrayList<Integer> lact = arrToLst(act);
		
		assertEquals(lexp, lact);
	}
	
	@Test
	public void tst_aut100(){
		
		System.out.println("tst_aut100:");
		
		int[] arr = genRandArray(100, 200);
		LongestIncSubsBF s = new LongestIncSubsBF(arr);
		s.solve();
		
		int[] act = s.getLongestSequence();
		boolean b = true;
		int lag = act[0];
		for(int i=1; i<act.length; i++){
			b = b && ( lag <= act[i] );
			lag = act[i];
		}
		
		assertTrue( b );
	}
	
	@Test
	public void tst_aut10000(){
		
		System.out.println("tst_aut10000:");
		
		int[] arr = genRandArray(10000, 20000);
		LongestIncSubsBF s = new LongestIncSubsBF(arr);
		s.solve();
		
		int[] act = s.getLongestSequence();
		boolean b = true;
		int lag = act[0];
		for(int i=1; i<act.length; i++){
			b = b && ( lag <= act[i] );
			lag = act[i];
		}
		
		assertTrue( b );
	}
	
	@Ignore
	public void tst_aut1000000(){
		
		System.out.println("tst_aut1000000:");
		
		int[] arr = genRandArray(1000000, 2000000);
		LongestIncSubsBF s = new LongestIncSubsBF(arr);
		s.solve();
		
		int[] act = s.getLongestSequence();
		boolean b = true;
		int lag = act[0];
		for(int i=1; i<act.length; i++){
			b = b && ( lag <= act[i] );
			lag = act[i];
		}
		
		assertTrue( b );
	}
	
	private ArrayList<Integer> arrToLst(int[] inArr){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(int i : inArr){
			ret.add(i);
		}
		return ret;
	}
	
	private int[] genRandArray(int inLen, int inThrs){
		int[] ret = new int[inLen];
		
		Random rand = new Random();
		
		for(int i=0; i<inLen; i++){
			ret[i] = rand.nextInt(inThrs);
		}
		
		return ret;
	}
	
}
