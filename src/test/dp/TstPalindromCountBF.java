package test.dp;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import dp.*;

public class TstPalindromCountBF {

	@Test
	public void tst_isPalindrom(){
		
		assertTrue( (new PalindromCountBF()).isPalindromic("QQ") );
		
	}
	
	@Test
	public void tst_isPalindrom2(){
		
		assertTrue( (new PalindromCountBF()).isPalindromic("PAP") );
		
	}
	
	@Test
	public void tst_isPalindrom3(){
		
		assertTrue( (new PalindromCountBF()).isPalindromic("PAPBBPAP") );
		
	}
	
	@Test
	public void tst_isPalindrom4(){
		
		assertTrue( !(new PalindromCountBF()).isPalindromic("AB") );
		
	}
	
	@Test
	public void tst_isPalindrom5(){
		
		assertTrue( !(new PalindromCountBF()).isPalindromic("BABQ") );
		
	}
	
	@Test
	public void tst_count1(){
		int exp = 0;
		int act = (new PalindromCountBF()).count("AB");
		
		assertEquals( exp, act );
	}
	
	@Test
	public void tst_count2(){
		int exp = 1;
		int act = (new PalindromCountBF()).count("ABA");
		
		assertEquals( exp, act );
	}
	
	@Test
	public void tst_count3(){
		int exp = 2;
		
		//System.out.println("tst_count3 start");
		int act = (new PalindromCountBF()).count("ABBA");
		//System.out.println("tst_count3 end");
		
		assertEquals( exp, act );
	}
	
	@Test
	public void tst_count4(){
		int exp = 3;
		int act = (new PalindromCountBF()).count("PABBAP");
		
		assertEquals( exp, act );
	}
	
	@Test
	public void tst_count5(){
		int exp = 1;
		int act = (new PalindromCountBF()).count("PQBBAP");
		
		assertEquals( exp, act );
	}
	
	@Test
	public void tst_count6(){
		int exp = 0;
		int act = (new PalindromCountBF()).count("PQBZAP");
		
		assertEquals( exp, act );
	}
	
}
