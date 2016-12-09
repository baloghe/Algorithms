package test.graph.pruning;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.HashSet;

import graph.pruning.*;

public class TstGcjABTreeNode {

	@Test
	public void tst_root1(){
		GcjGameState gs0 = new GcjGameState(1,5,3);
		GcjGameState gs  = gs0.setShip(0, 1).setCell(0, 1, 1).setCell(0, 3, 1);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		HashSet<GcjGameState> act = nd.createNextStates();
		
		/*
		System.out.println("Root:" + gs);
		System.out.println("Children:");
		for(GcjGameState s : act){
			System.out.println(" " + s.toString());
		}
		*/
		
		HashSet<GcjGameState> exp = new HashSet<GcjGameState>();
		//exp.add(gs.setCell(0, 0, 3));    //wouldn't be meaningful
		exp.add(gs.setCell(0, 2, 3));
		//exp.add(gs.setCell(0, 4, 3));    //wouldn't be meaningful
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_opp1(){
		GcjGameState gs0 = new GcjGameState(1,5,3);
		GcjGameState gs  = gs0.setShip(0, 1).setCell(0, 1, 1).setCell(0, 2, 3).setCell(0, 3, 1);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_OPPONENT, 0);
		HashSet<GcjGameState> act = nd.createNextStates();
		
		/*
		System.out.println("Root:" + gs);
		System.out.println("Children:");
		for(GcjGameState s : act){
			System.out.println(" " + s.toString());
		}
		*/
		
		HashSet<GcjGameState> exp = new HashSet<GcjGameState>();
		exp.add(gs.setCell(0, 2, 1));
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_opp2(){
		GcjGameState gs0 = new GcjGameState(1,5,3);
		GcjGameState gs  = gs0.setShip(0, 2).setCell(0, 0, 2).setCell(0, 1, 3);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_OPPONENT, 0);
		HashSet<GcjGameState> act = nd.createNextStates();
		
		/*
		System.out.println("Root:" + gs);
		System.out.println("Children:");
		for(GcjGameState s : act){
			System.out.println(" " + s.toString());
		}
		*/
		
		HashSet<GcjGameState> exp = new HashSet<GcjGameState>();
		exp.add( gs.setShip(0, 1).setCell(0, 1, 1) ); //ship moved to (0,1) and consequently guess for (0,1) answered as HIT
		exp.add( gs.setShip(0, 2).setCell(0, 1, 2) ); //ship moved to (0,2) and consequently guess for (0,1) answered as MISS
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_2rounds(){
		GcjGameState gs0 = new GcjGameState(1,5,3);
		GcjGameState gs  = gs0.setShip(0, 2).setCell(0, 0, 2).setCell(0, 1, 2).setCell(0, 2, 1).setCell(0, 3, 1);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 5;		
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_3rounds(){
		GcjGameState gs0 = new GcjGameState(1,5,3);
		GcjGameState gs  = gs0.setShip(0, 2).setCell(0, 0, 1);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 3;		
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_empty1(){
		GcjGameState gs = new GcjGameState(1,5,3);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 4;		
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_empty2(){
		GcjGameState gs = new GcjGameState(1,4,2);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 3;		
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_empty3(){
		GcjGameState gs = new GcjGameState(1,7,7);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 7;		
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_empty4(){
		GcjGameState gs0 = new GcjGameState(1,10,2);
		//that would run too long...
		//some help: when both players want to win:
		//	ROOT would try {[0,1],[0,3],[0,5],[0,7]} without success (as OPPONENT would always place the ship at the right end of the table)
		//  but afterwards another 2 tries would suffice
		//  making 6 tries altogether
		GcjGameState gs = gs0.setShip(0, 8).setCell(0, 1, 2).setCell(0, 3, 2).setCell(0, 5, 2).setCell(0, 7, 2);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 6;		
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_empty5(){
		GcjGameState gs0 = new GcjGameState(1,10,2);
		//that would run too long...
		//some help: when both players want to win:
		//	ROOT would try {[0,1],[0,3],[0,5]} without success (as OPPONENT would always place the ship at the right end of the table)
		//  but afterwards another 3 tries would suffice: 
		//		EITHER [0,7] would be a MISS, but then [0,9] and [0,8] must be both HITs
		//		OR     [0,7] would be a HIT, but then EITHER [0,6] OR [0,8] would be a HIT and the ship is sunk (both must be tried!)
		//  making 6 tries altogether
		GcjGameState gs = gs0.setShip(0, 8).setCell(0, 1, 2).setCell(0, 3, 2).setCell(0, 5, 2);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 6;		
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_empty6(){
		GcjGameState gs0 = new GcjGameState(1,10,3);
		GcjGameState gs = gs0.setShip(0, 7).setCell(0, 2, 2).setCell(0, 5, 2);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 6;		
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_empty7(){
		GcjGameState gs0 = new GcjGameState(1,10,3);
		GcjGameState gs = gs0.setShip(0, 7).setCell(0, 2, 2);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 6;		
		
		assertEquals( exp , act );
	}
	
	@Test
	public void tst_empty8(){
		GcjGameState gs0 = new GcjGameState(1,10,9);
		GcjGameState gs = gs0.setShip(0, 1).setCell(0, 8, 1);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		HashSet<GcjGameState> act = nd.createNextStates();
		
		
		System.out.println("Root:" + gs);
		System.out.println("Children:");
		for(GcjGameState s : act){
			System.out.println(" " + s.toString());
		}
		
		
		/*
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 6;		
		
		assertEquals( exp , act );
		*/
	}
	
	@Test
	public void tst_empty10(){
		GcjGameState gs = new GcjGameState(1,5,2);
		
		GcjABTreeNode.EVALUATOR = new GcjGameStateEvaluator();
		
		GcjABTreeNode nd = new GcjABTreeNode(gs, GcjABTreeNode.PLAYER_ROOT, 0);
		nd.createChildren();
		
		int act = nd.evalChildren();
		int exp = 4;		
		
		assertEquals( exp , act );
	}
	
}
