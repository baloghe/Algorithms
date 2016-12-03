package test.graph.pruning;

import graph.pruning.*;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class TstConnect3GameStateEvaluator {

	@Test
	public void test_GameStat_toString(){
		int[][] tbl = new int[][]{
				 new int[]{1,1,1}
				,new int[]{0,0,2}
				,new int[]{2,2,1}
		};
		Connect3GameState gs = new Connect3GameState( tbl );
		System.out.println( gs );
	}
	
	@Test
	public void test_isEndState1(){
		int[][] tbl = new int[][]{
				 new int[]{1,1,1}
				,new int[]{0,0,2}
				,new int[]{2,2,1}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		boolean act_isEndState = gse.isEndState(gs);
		boolean exp_isEndState = true;
		
		assertTrue( act_isEndState == exp_isEndState );
	}
	
	@Test
	public void test_isEndState2(){
		int[][] tbl = new int[][]{
				 new int[]{1,2,1}
				,new int[]{1,0,2}
				,new int[]{1,2,2}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		boolean act_isEndState = gse.isEndState(gs);
		boolean exp_isEndState = true;
		
		assertTrue( act_isEndState == exp_isEndState );
	}
	
	@Test
	public void test_isEndState3(){
		int[][] tbl = new int[][]{
				 new int[]{0,0,0}
				,new int[]{0,0,0}
				,new int[]{0,0,0}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		boolean act_isEndState = gse.isEndState(gs);
		boolean exp_isEndState = false;
		
		assertTrue( act_isEndState == exp_isEndState );
	}
	
	@Test
	public void test_isEndState4(){
		int[][] tbl = new int[][]{
				 new int[]{1,0,2}
				,new int[]{0,1,0}
				,new int[]{2,0,1}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		boolean act_isEndState = gse.isEndState(gs);
		boolean exp_isEndState = true;
		
		assertTrue( act_isEndState == exp_isEndState );
	}
	
	@Test
	public void test_isEndState5(){
		int[][] tbl = new int[][]{
				 new int[]{1,0,2}
				,new int[]{0,2,0}
				,new int[]{2,0,1}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		boolean act_isEndState = gse.isEndState(gs);
		boolean exp_isEndState = true;
		
		assertTrue( act_isEndState == exp_isEndState );
	}
	
	@Test
	public void test_isEndState6(){
		int[][] tbl = new int[][]{
				 new int[]{1,0,2}
				,new int[]{0,1,0}
				,new int[]{2,0,2}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		boolean act_isEndState = gse.isEndState(gs);
		boolean exp_isEndState = false;
		
		assertTrue( act_isEndState == exp_isEndState );
	}
	
	@Test
	public void test_isEndState7(){
		int[][] tbl = new int[][]{
				 new int[]{1,1,2}
				,new int[]{2,2,1}
				,new int[]{2,1,2}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		boolean act_isEndState = gse.isEndState(gs);
		boolean exp_isEndState = true;
		
		assertTrue( act_isEndState == exp_isEndState );
	}
	
	@Test
	public void test_evaluate1(){
		int[][] tbl = new int[][]{
				 new int[]{0,0,0}
				,new int[]{0,0,0}
				,new int[]{0,0,0}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		//System.out.println("test_evaluate1");
		int act_eval = gse.evaluate( gs );
		int exp_eval = 0;
		
		assertEquals(exp_eval , act_eval);
	}
	
	@Test
	public void test_evaluate2(){
		int[][] tbl = new int[][]{
				 new int[]{0,1,0}
				,new int[]{0,0,0}
				,new int[]{0,0,0}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		//System.out.println("test_evaluate2");
		int act_eval = gse.evaluate( gs );
		int exp_eval = 2;
		
		assertEquals(exp_eval , act_eval);
	}
	
	@Test
	public void test_evaluate3(){
		int[][] tbl = new int[][]{
				 new int[]{0,2,0}
				,new int[]{0,0,0}
				,new int[]{0,0,0}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		//System.out.println("test_evaluate3");
		int act_eval = gse.evaluate( gs );
		int exp_eval = -2;
		
		assertEquals(exp_eval , act_eval);
	}
	
	@Test
	public void test_evaluate4(){
		int[][] tbl = new int[][]{
				 new int[]{0,1,1}
				,new int[]{0,0,0}
				,new int[]{0,0,0}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		//System.out.println("test_evaluate4");
		int act_eval = gse.evaluate( gs );
		int exp_eval = 22;
		
		assertEquals(exp_eval , act_eval);
	}
	
	@Test
	public void test_evaluate5(){
		int[][] tbl = new int[][]{
				 new int[]{0,2,2}
				,new int[]{0,0,0}
				,new int[]{0,0,0}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		//System.out.println("test_evaluate5");
		int act_eval = gse.evaluate( gs );
		int exp_eval = -22;
		
		assertEquals(exp_eval , act_eval);
	}
	
	@Test
	public void test_evaluate6(){
		int[][] tbl = new int[][]{
				 new int[]{1,1,1}
				,new int[]{0,0,0}
				,new int[]{0,0,0}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		//System.out.println("test_evaluate6");
		int act_eval = gse.evaluate( gs );
		int exp_eval = 103;
		
		assertEquals(exp_eval , act_eval);
	}
	
	@Test
	public void test_evaluate7(){
		int[][] tbl = new int[][]{
				 new int[]{2,2,2}
				,new int[]{0,0,0}
				,new int[]{0,0,0}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		//System.out.println("test_evaluate7");
		int act_eval = gse.evaluate( gs );
		int exp_eval = -103;
		
		assertEquals(exp_eval , act_eval);
	}
	
	@Test
	public void test_evaluate8(){
		int[][] tbl = new int[][]{
				 new int[]{0,0,1}
				,new int[]{0,1,0}
				,new int[]{1,0,0}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		//System.out.println("test_evaluate8");
		int act_eval = gse.evaluate( gs );
		int exp_eval = 106;
		
		assertEquals(exp_eval , act_eval);
	}
	
	@Test
	public void test_evaluate9(){
		int[][] tbl = new int[][]{
				 new int[]{0,0,2}
				,new int[]{0,2,1}
				,new int[]{2,1,1}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		//System.out.println("test_evaluate9");
		int act_eval = gse.evaluate( gs );
		int exp_eval = -102;
		
		assertEquals(exp_eval , act_eval);
	}
	
	@Test
	public void test_evaluate10(){
		int[][] tbl = new int[][]{
				 new int[]{1,1,1}
				,new int[]{1,1,1}
				,new int[]{1,1,1}
		};
		
		Connect3GameState gs = new Connect3GameState( tbl );
		Connect3GameStateEvaluator gse = new Connect3GameStateEvaluator();
		
		//System.out.println("test_evaluate10");
		int act_eval = gse.evaluate( gs );
		int exp_eval = 800;
		
		assertEquals(exp_eval , act_eval);
	}
}
