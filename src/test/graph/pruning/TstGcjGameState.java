package test.graph.pruning;

import graph.pruning.*;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class TstGcjGameState {

	@Test
	public void tst_Empty1row(){
		GcjGameState gs = new GcjGameState(10,3);
		
		String act = gs.toString();
		String exp = "SSS_______";
		
		//System.out.println("tst_Empty1row: " + act);
		
		assertTrue( act.equalsIgnoreCase(exp) );
	}
	
	@Test
	public void tst_EmptyNrow(){
		GcjGameState gs = new GcjGameState(3,10,4);
		
		String act = gs.toString();
		String exp = "SSSS______\n__________\n__________";
		
		//System.out.println("tst_Empty1row: " + act);
		
		assertTrue( act.equalsIgnoreCase(exp) );
	}
	
	@Test
	public void tst_setCell1(){
		GcjGameState gs0 = new GcjGameState(10,3);
		GcjGameState gs = gs0.setCell(0, 8, 2);
		
		String act = gs.toString();
		String exp = "SSS_____M_";
		
		//System.out.println("tst_Empty1row: " + act);
		
		assertTrue( act.equalsIgnoreCase(exp) );
	}
	
	@Test
	public void tst_setCell2(){
		GcjGameState gs0 = new GcjGameState(10,3);
		GcjGameState gs = gs0.setCell(0, 3, 1);
		
		String act = gs.toString();
		String exp = "SSSH______";
		
		//System.out.println("tst_Empty1row: " + act);
		
		assertTrue( act.equalsIgnoreCase(exp) );
	}
	
	@Test
	public void tst_setCell3(){
		GcjGameState gs0 = new GcjGameState(10,3);
		GcjGameState gs1 = gs0.setCell(0, 8, 2);
		GcjGameState gs = gs1.setCell(0, 3, 1);
		
		String gs0s = "SSS_______";
		String gs1s = "SSS_____M_";
		String act = gs.toString();
		String exp = "SSSH____M_";
		
		/*
		System.out.println("tst_Empty1row: ");
		System.out.println("  gs0: " + gs0 + " vs " + gs0s);
		System.out.println("  gs1: " + gs1 + " vs " + gs1s);
		System.out.println("  act: " + gs + " vs " + exp);
		*/
		
		assertTrue(   gs0s.equalsIgnoreCase(gs0.toString())
				   && gs1s.equalsIgnoreCase(gs1.toString())
				   && act.equalsIgnoreCase(exp) );
	}
	
	@Test
	public void tst_setCell4(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs1 = gs0.setCell(0, 8, 2);
		GcjGameState gs = gs1.setCell(1, 3, 1);
		
		String gs0s = "SSS_______\n__________";
		String gs1s = "SSS_____M_\n__________";
		String act = gs.toString();
		String exp = "SSS_____M_\n___H______";
		
		/*
		System.out.println("tst_Empty1row: ");
		System.out.println("  gs0: " + gs0 + " vs " + gs0s);
		System.out.println("  gs1: " + gs1 + " vs " + gs1s);
		System.out.println("  act: " + gs + " vs " + exp);
		*/
		
		assertTrue(   gs0s.equalsIgnoreCase(gs0.toString())
				   && gs1s.equalsIgnoreCase(gs1.toString())
				   && act.equalsIgnoreCase(exp) );
	}
	
	@Test
	public void tst_moveShip1(){
		GcjGameState gs0 = new GcjGameState(10,3);
		GcjGameState gs = gs0.setShip(0, 3);
		
		String gs0s = "SSS_______";
		String act = gs.toString();
		String exp = "___SSS____";
		
		//System.out.println("tst_Empty1row: " + act);
		
		assertTrue(   gs0s.equalsIgnoreCase(gs0.toString())
				   && act.equalsIgnoreCase(exp) );
	}
	
	@Test
	public void tst_moveShip2(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs = gs0.setShip(1, 3);
		
		String gs0s = "SSS_______\n__________";
		String act = gs.toString();
		String exp = "__________\n___SSS____";
		
		//System.out.println("tst_Empty1row: " + act);
		
		assertTrue(   gs0s.equalsIgnoreCase(gs0.toString())
				   && act.equalsIgnoreCase(exp) );
	}
	
	@Test
	public void tst_isHit1(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs = gs0.setShip(1, 3);
		
		boolean act00 = gs.isHit(0, 0);
		boolean exp00 = false;
		
		boolean act01 = gs.isHit(0, 1);
		boolean exp01 = false;
		
		boolean act02 = gs.isHit(0, 2);
		boolean exp02 = false;
		
		boolean act03 = gs.isHit(0, 3);
		boolean exp03 = false;
		
		boolean act04 = gs.isHit(0, 4);
		boolean exp04 = false;
		
		boolean act10 = gs.isHit(1, 2);
		boolean exp10 = false;
		
		boolean act11 = gs.isHit(1, 3);
		boolean exp11 = true;
		
		boolean act12 = gs.isHit(1, 4);
		boolean exp12 = true;
		
		boolean act13 = gs.isHit(1, 5);
		boolean exp13 = true;
		
		boolean act14 = gs.isHit(1, 6);
		boolean exp14 = false;
		
		assertTrue(   act00==exp00 && act01==exp01 && act02==exp02 && act03==exp03 && act04==exp04
				   && act10==exp10 && act11==exp11 && act12==exp12 && act13==exp13 && act14==exp14);
	}
	
	@Test
	public void tst_shipPosVal1(){
		GcjGameState gs = new GcjGameState(2,10,3);
		
		boolean act = gs.shipPositionValid(0, 0);
		boolean exp = true;
		
		assertTrue(act==exp);
	}
	
	@Test
	public void tst_shipPosVal2(){
		GcjGameState gs = new GcjGameState(2,10,3);
		
		boolean act = gs.shipPositionValid(0, 9);
		boolean exp = false;
		
		assertTrue(act==exp);
	}
	
	@Test
	public void tst_shipPosVal3(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs = gs0.setShip(1, 3);
		
		boolean act = gs.shipPositionValid(0, 7);
		boolean exp = true;
		
		assertTrue(act==exp);
	}
	
	@Test
	public void tst_shipPosVal4(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs = gs0.setShip(1, 3);
		
		boolean act = gs.shipPositionValid(1, 7);
		boolean exp = true;
		
		assertTrue(act==exp);
	}
	
	@Test
	public void tst_shipPosVal5(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs = gs0.setShip(1, 3).setCell(1, 3, 1);
		
		boolean act = gs.shipPositionValid(1, 7);
		boolean exp = false;
		
		assertTrue(act==exp);
	}
	
	@Test
	public void tst_shipPosVal6(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs = gs0.setShip(1, 3).setCell(1, 3, 1);
		
		boolean act = gs.shipPositionValid(1, 2);
		boolean exp = true;
		
		assertTrue(act==exp);
	}
	
	@Test
	public void tst_guess1(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs = gs0.setShip(1, 3);
		
		int act1 = gs.guess(0, 0);
		int exp1 = 0;
		
		int act2 = gs.guess(1, 3);
		int exp2 = 0;
		
		int act3 = gs.guess(1, 6);
		int exp3 = 0;
		
		int act4 = gs.guess(1, 9);
		int exp4 = 0;
		
		assertTrue(   act1==exp1 && act2==exp2
				   && act3==exp3 && act4==exp4);
	}
	
	@Test
	public void tst_guess2(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs  = gs0.setShip(1, 3).setCell(1, 3, 1).setCell(1, 5, 1);
		
		
		int act1 = gs.guess(0, 0);
		int exp1 = 2;
		
		int act2 = gs.guess(1, 3);
		int exp2 = 1;
		
		int act3 = gs.guess(1, 4);
		int exp3 = 1;
		
		int act4 = gs.guess(1, 5);
		int exp4 = 1;
		
		int act5 = gs.guess(1, 6);
		int exp5 = 2;
		
		assertTrue(   act1==exp1 && act2==exp2
				   && act3==exp3 && act4==exp4 && act5==exp5);
		
	}
	
	@Test
	public void tst_guessedAlready1(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs  = gs0.setShip(1, 3).setCell(1, 3, 1).setCell(1, 5, 1);
		
		boolean act1 = gs.guessedAlready(0, 0);
		boolean exp1 = false;
		
		boolean act2 = gs.guessedAlready(1, 3);
		boolean exp2 = true;
		
		boolean act3 = gs.guessedAlready(1, 5);
		boolean exp3 = true;
		
		boolean act4 = gs.guessedAlready(1, 4);
		boolean exp4 = false;
		
		assertTrue(   act1==exp1 && act2==exp2
				   && act3==exp3 && act4==exp4);
	}
}
