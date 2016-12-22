package test.dp;

import java.util.Random;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import dp.*;

public class TstMaxSubarray {
	
	@Test
	public void tstWiki(){
		
		int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		MaxSubarray sb = new MaxSubarray(array);
		
		int act = sb.solve();
		int exp = 6;
		
		assertEquals(exp, act);		
	}
	
	@Test
	public void tstWiki2(){
		
		int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		MaxSubarray sb = new MaxSubarray(array);
		sb.solve();
		
		boolean[] act = sb.getUsed();
		boolean[] exp = new boolean[]{false,false,false,true,true,true,true,false,false};
		
		boolean isTrue = true;
		for(int i=0; i<act.length; i++){
			isTrue = isTrue && ( act[i]==exp[i] );
		}
		
		assertTrue( isTrue );
	}
	
	@Test
	public void tst10(){
		
		int[] array = new int[]{-4,	-10, 8, -2, 3, -1, 5, -7, -4, -2};
		
		MaxSubarray sb = new MaxSubarray(array);
		sb.solve();
		
		boolean[] act = sb.getUsed();
		boolean[] exp = new boolean[]{false,false,true,true,true,true,true,false,false,false};
		
		boolean isTrue = true;
		for(int i=0; i<act.length; i++){
			isTrue = isTrue && ( act[i]==exp[i] );
		}
		
		assertTrue( isTrue );
	}
	
	
	@Test
	public void tst_Random(){
		
		int n=10;
		int maxV=20;
						
		int[] array = new int[n];
		
		Random rand = new Random();
		
		String sarr = "";
		for(int i=0; i<n; i++){
			array[i] = rand.nextInt(maxV) - maxV/2;
			sarr += (", " + array[i]);
		}
		System.out.println(sarr);
		
		MaxSubarray ks = new MaxSubarray( array );
		
		int act = ks.solve();
		
		boolean[] used = ks.getUsed();
		int controlSum = (used[0] ? array[0] : 0);
		String s = Boolean.toString(used[0]);
		for(int i=1; i<used.length; i++){
			s += ( ", " + Boolean.toString(used[i]) );
			if(used[i]) 
				controlSum += array[i];
		}
		//System.out.println(s);
		
		assertEquals(controlSum , act);
	}
	
}
