package test.graph.pruning;

import static org.junit.Assert.*;
import graph.pruning.*;

import org.junit.Test;

public class TstGcjGameStateEvaluator {

	@Test
	public void tst_endGame1(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs  = gs0.setShip(1, 3).setCell(1, 3, 1).setCell(1, 4, 1).setCell(1, 5, 1);
		
		GcjGameStateEvaluator ev = new GcjGameStateEvaluator();
		
		boolean act = ev.isEndState(gs);
		boolean exp = true;
		
		assertTrue( act==exp );
	}
	
	@Test
	public void tst_endGame2(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs  = gs0.setShip(1, 3).setCell(1, 3, 1).setCell(1, 5, 1);
		
		GcjGameStateEvaluator ev = new GcjGameStateEvaluator();
		
		boolean act = ev.isEndState(gs);
		boolean exp = false;
		
		assertTrue( act==exp );
	}
	
	@Test
	public void tst_evaluate1(){
		GcjGameState gs = new GcjGameState(2,10,3);
		
		GcjGameStateEvaluator ev = new GcjGameStateEvaluator();
		
		int act = ev.evaluate(gs);
		int exp = 0;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_evaluate2(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs  = gs0.setShip(1, 3).setCell(1, 3, 1).setCell(1, 4, 1).setCell(1, 5, 1);
		
		GcjGameStateEvaluator ev = new GcjGameStateEvaluator();
		
		int act = ev.evaluate(gs);
		int exp = 3;
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_evaluate3(){
		GcjGameState gs0 = new GcjGameState(2,10,3);
		GcjGameState gs  = gs0.setShip(1, 3).setCell(0, 3, 1).setCell(0, 4, 1).setCell(0, 5, 1).setCell(1, 3, 1).setCell(1, 4, 1).setCell(1, 5, 1);
		
		GcjGameStateEvaluator ev = new GcjGameStateEvaluator();
		
		int act = ev.evaluate(gs);
		int exp = 6;
		
		assertEquals(exp, act);
	}
}
