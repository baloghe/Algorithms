package test.dp;

import java.util.Random;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import dp.*;

public class TstKnapsack {

	@Test
	public void tst_Knapsack(){
		int[] weights = new int[]{5,4,6,3};
		int[] values = new int[]{10,40,30,50};
		
		Knapsack ks = new Knapsack( weights, values );
		
		int act = ks.solve(10);
		int exp = 90;
		
		assertEquals(exp , act);
	}
	
	@Test
	public void tst_Knapsack2(){
		int[] weights = new int[]{5,4,6,3};
		int[] values = new int[]{10,40,30,50};
		
		Knapsack ks = new Knapsack( weights, values );
		ks.solve(10);
		
		boolean[] act = ks.getUsed();
		boolean[] exp = new boolean[]{false,true,false,true};
		
		boolean isTrue = true;
		for(int i=0; i<act.length; i++){
			isTrue = isTrue && ( act[i]==exp[i] );
		}
		
		assertTrue( isTrue );
	}
	
	@Test
	public void tst_Coins(){
		int[] weights = new int[]{1,2,5,10};
		int[] values = new int[]{1,2,5,10};
		
		Knapsack ks = new Knapsack( weights, values );
		
		int act = ks.solve(12);
		int exp = 12;
		
		boolean[] used = ks.getUsed();
		String s = Boolean.toString(used[0]);
		for(int i=1; i<used.length; i++)
			s += ( ", " + Boolean.toString(used[i]) );
		//System.out.println(s);
		
		assertEquals(exp , act);
	}
	
	@Test
	public void tst_Random(){
		
		int n=10;
		int maxW=10;
		int maxV=20;
						
		int[] weights = new int[n];
		int[] values = new int[n];
		
		Random rand = new Random();
		
		for(int i=0; i<n; i++){
			weights[i] = rand.nextInt(maxW);
			values[i] = rand.nextInt(maxV);
		}
		int thrsW = 3 * maxW;
		
		Knapsack ks = new Knapsack( weights, values );
		
		int act = ks.solve(thrsW);
		
		boolean[] used = ks.getUsed();
		int controlSum = values[0];
		String s = Boolean.toString(used[0]);
		for(int i=1; i<used.length; i++){
			s += ( ", " + Boolean.toString(used[i]) );
			if(used[i]) 
				controlSum += values[i];
		}
		//System.out.println(s);
		
		assertEquals(controlSum , act);
	}
	
}
