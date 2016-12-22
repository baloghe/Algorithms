package test.graph.search;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

import graph.search.*;

public class TstTree {

	@Test
	public void tst_emptyTree(){
		Tree tr = new Tree(null);
		
		String exp = "NULL";
		String act = tr.toString();
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_Root(){
		Tree tr = new Tree( new GraphNode("R") );
	
		String exp = "R";
		String act = tr.toString();
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_Simple(){
		Tree r = new Tree( new GraphNode("R") );
		Tree a = new Tree( new GraphNode("A") );
		Tree b = new Tree( new GraphNode("B") );
		
		r.addChild(a);
		r.addChild(b);
		
		String exp1 = "R->B,A\nB\nA";
		String exp2 = "R->A,B\nA\nB";
		String act = r.toString();
		
		assertTrue(   act.equalsIgnoreCase(exp1)
				   || act.equalsIgnoreCase(exp2) );
	}
	
}
