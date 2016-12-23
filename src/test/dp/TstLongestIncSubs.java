package test.dp;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import dp.*;

public class TstLongestIncSubs {
	
	@Test
	public void tst_res1(){
		
		int[] arr = new int[]{3};
		LongestIncSubs s = new LongestIncSubs(arr);
		
		System.out.println("tst_res1:");
		
		int exp = 1;
		int act = s.solve();
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_res2(){
		
		int[] arr = new int[]{3, 4, 1, 5};
		LongestIncSubs s = new LongestIncSubs(arr);
		
		System.out.println("tst_res2:");
		
		int exp = 3;
		int act = s.solve();
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_slen1(){
		
		System.out.println("tst_slen1:");
		
		int[] arr = new int[]{3};
		LongestIncSubs s = new LongestIncSubs(arr);
		s.solve();
		
		int exp = 1;
		int act = s.getLongestSequence().length;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_slen2(){
		
		System.out.println("tst_slen2:");
		
		int[] arr = new int[]{3, 4, 1, 5};
		LongestIncSubs s = new LongestIncSubs(arr);
		s.solve();
		
		int exp = 3;
		int act = s.getLongestSequence().length;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_scont1(){
		
		System.out.println("tst_scont1:");
		
		int[] arr = new int[]{3};
		LongestIncSubs s = new LongestIncSubs(arr);
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
		LongestIncSubs s = new LongestIncSubs(arr);
		s.solve();
		
		int[] exp = new int[]{3,4,5};
		int[] act = s.getLongestSequence();
		
		ArrayList<Integer> lexp = arrToLst(exp);
		ArrayList<Integer> lact = arrToLst(act);
		
		assertEquals(lexp, lact);
	}
	
	@Test
	public void tst_aut10(){
		
		//int[] arr = new int[]{7, 14, 10, 3, 18, 5, 12, 18, 13, 10};
		//int[] arr = new int[]{7, 19, 17, 17, 2, 14, 15, 16, 18, 10};
		//int[] arr = new int[]{18, 15, 5, 0, 7, 13, 3, 6, 19, 15};
		//int[] arr = new int[]{1, 9, 8, 3, 10, 4, 1, 13, 6, 6};
		int[] arr = genRandArray(10, 20);
		System.out.println("tst_aut10: " + intArrToString(arr) );
		
		LongestIncSubs s = new LongestIncSubs(arr);
		s.solve();
		
		int[] act = s.getLongestSequence();
		System.out.println("   ret: " + intArrToString(act) );
		boolean b = true;
		int lag = act[0];
		for(int i=1; i<act.length; i++){
			b = b && ( lag <= act[i] );
			lag = act[i];
		}
		
		assertTrue( b );
	}
	
	@Test
	public void tst_aut100000(){
		
		int[] arr = genRandArray(100000, 200000);
		System.out.println("tst_aut100000:");
		
		LongestIncSubs s = new LongestIncSubs(arr);
		s.solve();
		
		int[] act = s.getLongestSequence();
		//System.out.println("   ret: " + intArrToString(act) );
		boolean b = true;
		int lag = act[0];
		for(int i=1; i<act.length; i++){
			b = b && ( lag <= act[i] );
			lag = act[i];
		}
		
		assertTrue( b );
	}
	
	@Test
	public void tst_aut1000000(){
		
		int[] arr = genRandArray(1000000, 2000000);
		System.out.println("tst_aut1000000:");
		
		LongestIncSubs s = new LongestIncSubs(arr);
		s.solve();
		
		int[] act = s.getLongestSequence();
		//System.out.println("   ret: " + intArrToString(act) );
		boolean b = true;
		int lag = act[0];
		for(int i=1; i<act.length; i++){
			b = b && ( lag <= act[i] );
			lag = act[i];
		}
		
		assertTrue( b );
	}
	
	@Test
	public void tst_aut100(){
		
		System.out.println("tst_aut100:");
		
		int[] arr = genRandArray(100, 200);
				
		LongestIncSubs s = new LongestIncSubs(arr);
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
				
		LongestIncSubs s = new LongestIncSubs(arr);
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
	
	private String intArrToString(int[] inArr){
		if(inArr==null){
			return "NULL";
		} else if(inArr.length==0){
			return "EMPTY";
		} else {
			String ret = Integer.toString( inArr[0] );
			for(int i=1; i<inArr.length; i++){
				ret += (", " + inArr[i]);
			}
			return ret;
		}
	}
	
}
