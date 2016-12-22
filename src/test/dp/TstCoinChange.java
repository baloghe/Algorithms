package test.dp;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import dp.*;

public class TstCoinChange {

	private ArrayList<Integer> intArrToLst(int[] arr){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(int i : arr){
			ret.add(i);
		}
		return ret;
	}
	
	
	@Test
	public void tst_solve1(){
		
		int[] array = new int[]{1,2,3,4};
		
		CoinChange sb = new CoinChange(array);
		
		int act = sb.solve(10);
		int exp = 3;
		
		assertEquals(exp, act);		
	}
	
	@Test
	public void tst_used1(){
		
		int[] array = new int[]{1,2,3,4};
		
		CoinChange sb = new CoinChange(array);
		sb.solve(10);
		
		int[] act = sb.getUsed();
		int[] exp1 = new int[]{0,0,2,1};
		int[] exp2 = new int[]{0,1,0,2};
		
		ArrayList<Integer> actl = intArrToLst(act); 
		ArrayList<Integer> exp1l = intArrToLst(exp1);
		ArrayList<Integer> exp2l = intArrToLst(exp2);
		
		//System.out.println("actl=" + actl);
		
		assertTrue(   exp1l.equals(actl)
				   || exp2l.equals(actl));
	}
	
	@Test
	public void tst_auto1(){
		
		int[] array = new int[]{1,2,5,10,20};
		
		Random rand = new Random();
		int target_amount = rand.nextInt(100);
		
		CoinChange sb = new CoinChange(array);
		sb.solve(target_amount);
		
		int[] used = sb.getUsed();
		int calc_amount = 0;
		for(int i=0; i<used.length; i++){
			calc_amount += used[i] * array[i];
		}
		
		assertEquals(target_amount, calc_amount);
	}
	
	@Test
	public void tstArticle(){
		
		int[] array = new int[]{1,5,10,25};
		
		CoinChange sb = new CoinChange(array);
		
		int act = sb.solve(100);
		int exp = 4;
		
		assertEquals(exp, act);		
	}
	
	@Test
	public void tstArticle2(){
		
		//article: J. Shallit. "What this country needs is an 18c piece" (https://cs.uwaterloo.ca/~shallit/Papers/change2.pdf)
		
		int[] array = new int[]{1,5,10,25};
		
		CoinChange sb = new CoinChange(array);
		
		double nominator = 0.0;
		for(int i=1; i<=100; i++){
			//System.out.println("i=" + i);
			nominator += (double)sb.solve(i);
		}
		double act = nominator / 100.0;
		
		double exp = 4.74;
		
		assertEquals(exp, act, 0.01);		
	}
	
	@Test
	public void tstArticle3(){
		
		int[] array = new int[]{1,5,10,25};
		
		CoinChange sb = new CoinChange(array);
		
		int act = sb.solve(3);
		int exp = 3;
		
		assertEquals(exp, act);		
	}
	
	
	
	@Test
	public void tst_used2(){
		
		int[] array = new int[]{1,2,5,10,20};
		
		CoinChange sb = new CoinChange(array);
		sb.solve(36);
		
		int[] act = sb.getUsed();
		int[] exp1 = new int[]{1,0,1,1,1};
		
		ArrayList<Integer> actl = intArrToLst(act); 
		ArrayList<Integer> exp1l = intArrToLst(exp1);
		
		//System.out.println("actl=" + actl);
		
		assertTrue( exp1l.equals(actl) );
	}
	
	@Test
	public void tstArticle4(){
		
		//article: J. Shallit. "What this country needs is an 18c piece" (https://cs.uwaterloo.ca/~shallit/Papers/change2.pdf)
		
		int[] array = new int[]{1,2,5,10,20};
		
		CoinChange sb = new CoinChange(array);
		
		double nominator = 0.0;
		for(int i=1; i<=99; i++){
			//System.out.println("i=" + i);
			nominator += (double)sb.solve(i);
		}
		double act = nominator / 100.0;
		
		double exp = 4.2;
		
		assertEquals(exp, act, 0.01);
	}
	
	
}
