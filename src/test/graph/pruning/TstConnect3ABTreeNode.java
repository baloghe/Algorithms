package test.graph.pruning;

import graph.pruning.*;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class TstConnect3ABTreeNode {
	
	@Test
	public void tstTable1(){
		int[][] tbl_0 = new int[][]{
				 new int[]{1,2,1}
				,new int[]{0,0,2}
				,new int[]{1,2,1}
		};
		
		Connect3GameState gs_0 = new Connect3GameState( tbl_0 );
		
		Connect3ABTreeNode.ROOT_MIN_MAX = Connect3ABTreeNode.ROOT_MAX;
		Connect3ABTreeNode.MAX_DEPTH = 100;
		Connect3ABTreeNode.EVALUATOR = new Connect3GameStateEvaluator();
		Connect3ABTreeNode root = new Connect3ABTreeNode(gs_0,Connect3ABTreeNode.PLAYER_ROOT,0,"R");
		root.createChildren();
		
		int eval_act = root.evalChildren();
		int eval_exp = 220;
		
		assertEquals( eval_exp , eval_act );
	}
	
	@Test
	public void tstTable2(){
		int[][] tbl_0 = new int[][]{
				 new int[]{1,2,1}
				,new int[]{0,0,2}
				,new int[]{1,2,1}
		};
		
		Connect3GameState gs_0 = new Connect3GameState( tbl_0 );
		
		Connect3ABTreeNode.ROOT_MIN_MAX = Connect3ABTreeNode.ROOT_MIN;
		Connect3ABTreeNode.MAX_DEPTH = 100;
		Connect3ABTreeNode.EVALUATOR = new Connect3GameStateEvaluator();
		Connect3ABTreeNode root = new Connect3ABTreeNode(gs_0,Connect3ABTreeNode.PLAYER_ROOT,0,"R");
		root.createChildren();
		
		int eval_act = root.evalChildren();
		int eval_exp = 80;
		
		assertEquals( eval_exp , eval_act );
	}
	
	@Test
	public void tstTable3(){
		int[][] tbl_0 = new int[][]{
				 new int[]{1,2,1}
				,new int[]{0,0,2}
				,new int[]{1,2,1}
		};
		
		Connect3GameState gs_0 = new Connect3GameState( tbl_0 );
		
		Connect3ABTreeNode.ROOT_MIN_MAX = Connect3ABTreeNode.ROOT_MAX;
		Connect3ABTreeNode.MAX_DEPTH = 100;
		Connect3ABTreeNode.EVALUATOR = new Connect3GameStateEvaluator();
		Connect3ABTreeNode root = new Connect3ABTreeNode(gs_0,Connect3ABTreeNode.PLAYER_OPPONENT,0,"R");
		root.createChildren();
		
		int eval_act = root.evalChildren();
		int eval_exp = -100;
		
		assertEquals( eval_exp , eval_act );
	}
	
	@Test
	public void tstTable4(){
		int[][] tbl_0 = new int[][]{
				 new int[]{1,2,1}
				,new int[]{0,0,2}
				,new int[]{1,2,1}
		};
		
		Connect3GameState gs_0 = new Connect3GameState( tbl_0 );
		
		Connect3ABTreeNode.ROOT_MIN_MAX = Connect3ABTreeNode.ROOT_MIN;
		Connect3ABTreeNode.MAX_DEPTH = 100;
		Connect3ABTreeNode.EVALUATOR = new Connect3GameStateEvaluator();
		Connect3ABTreeNode root = new Connect3ABTreeNode(gs_0,Connect3ABTreeNode.PLAYER_OPPONENT,0,"R");
		root.createChildren();
		
		int eval_act = root.evalChildren();
		int eval_exp = 200;
		
		assertEquals( eval_exp , eval_act );
	}	
	
	@Test
	public void tst2Steps1(){
		
		int[][] tbl = new int[][]{
				 new int[]{1,2,1}
				,new int[]{0,0,0}
				,new int[]{1,2,2}
		};
		
		System.out.println("--- tst2Steps1()  START ---");
		
		Connect3GameState gs = new Connect3GameState( tbl );
		
		Connect3ABTreeNode.ROOT_MIN_MAX = Connect3ABTreeNode.ROOT_MAX;
		Connect3ABTreeNode.MAX_DEPTH = 100;
		Connect3ABTreeNode.EVALUATOR = new Connect3GameStateEvaluator();
		Connect3ABTreeNode root = new Connect3ABTreeNode(gs,Connect3ABTreeNode.PLAYER_ROOT,0,"R");
		root.createChildren();
		
		int eval_act = root.evalChildren();
		int eval_exp = 121;
		
		System.out.println("--- tst2Steps1()  END   ---");
		
		assertEquals( eval_exp , eval_act );
	}
	
	@Test
	public void tstMaxDepth1(){
		
		int[][] tbl = new int[][]{
				 new int[]{1,0,0}
				,new int[]{0,2,0}
				,new int[]{2,0,1}
		};
		
		System.out.println("--- tstMaxDepth1()  START ROOT expected to win from here! ---");
		
		Connect3GameState gs = new Connect3GameState( tbl );
		
		Connect3ABTreeNode.ROOT_MIN_MAX = Connect3ABTreeNode.ROOT_MAX;
		Connect3ABTreeNode.MAX_DEPTH = 1;
		Connect3ABTreeNode.EVALUATOR = new Connect3GameStateEvaluator();
		Connect3ABTreeNode root = new Connect3ABTreeNode(gs,Connect3ABTreeNode.PLAYER_ROOT,0,"R");
		root.createChildren();
		
		int eval_act = root.evalChildren();
		
		System.out.println("--- tstMaxDepth1()  END   ---");
		
		assertTrue( eval_act > 0 );
	}
	
	@Test
	public void tstFullGame1(){
		
		int[][] tbl = new int[][]{
				 new int[]{1,0,0}
				,new int[]{0,2,0}
				,new int[]{2,0,1}
		};
		
		System.out.println("--- tstFullGame1()  START : ROOT expected to win from here! ---");
		
		Connect3GameState gs = new Connect3GameState( tbl );
		
		Connect3ABTreeNode.ROOT_MIN_MAX = Connect3ABTreeNode.ROOT_MAX;
		Connect3ABTreeNode.MAX_DEPTH = 100;
		Connect3ABTreeNode.EVALUATOR = new Connect3GameStateEvaluator();
		Connect3ABTreeNode root = new Connect3ABTreeNode(gs,Connect3ABTreeNode.PLAYER_ROOT,0,"R");
		root.createChildren();
		
		int eval_act = root.evalChildren();
		
		System.out.println("--- tstFullGame1()  END   ---");
		
		assertTrue( eval_act > 0 );
	}	
	
	@Test
	public void tstFullGame2(){
		
		System.out.println("--- tstFullGame2()  START : ROOT has a non-loosing strategy---");
		
		Connect3GameState gs = new Connect3GameState( );
		
		Connect3ABTreeNode.ROOT_MIN_MAX = Connect3ABTreeNode.ROOT_MAX;
		Connect3ABTreeNode.EVALUATOR = new Connect3GameStateEvaluator();
		Connect3ABTreeNode.MAX_DEPTH = 100;
		Connect3ABTreeNode root = new Connect3ABTreeNode(gs,Connect3ABTreeNode.PLAYER_ROOT,0,"R");
		root.createChildren();
		
		int eval_act = root.evalChildren();
		int eval_exp = 0;
		
		System.out.println("--- tstFullGame2()  END   ---");
		
		assertEquals( eval_exp , eval_act );
	}
	
}
