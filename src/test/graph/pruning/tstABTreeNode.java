package test.graph.pruning;

import graph.pruning.*;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class tstABTreeNode {

	@Test
	public void test1(){
		GameStateEvaluator gse = new GameStateEvaluator();
		ABTreeNode.EVALUATOR = gse;
		GameState start = new GameState();
		ABTreeNode root = new ABTreeNode(start, ABTreeNode.PLAYER_ROOT, 0, "ROOT");
		
		root.createChildren();
		int actRV = root.evalChildren();
		
		System.out.println("TEST RESULT: actRV=" + actRV);
	}
	
}
