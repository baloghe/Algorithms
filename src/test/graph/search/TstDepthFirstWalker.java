package test.graph.search;

import java.util.HashSet;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import graph.search.*;

public class TstDepthFirstWalker {

	@Ignore
	public void tst_root(){
		
		GraphNode r = new GraphNode("R");
		GraphNode a = new GraphNode("A");
		
		HashSet<GraphEdge> edges = new HashSet<GraphEdge>();
		edges.add(new GraphEdge(r,a));
		UndirectedGraph g = new UndirectedGraph( edges );
		
		DepthFirstWalker w = new DepthFirstWalker();
		Tree dft = w.getResult(g, "R");
		
		String act = dft.toString();
		String exp = "R->A\nA";
		
		assertEquals(exp, act);
	}
	
	@Test
	public void tst_triangle(){
		
		GraphNode a = new GraphNode("A");
		GraphNode b = new GraphNode("B");
		GraphNode c = new GraphNode("C");
		
		HashSet<GraphEdge> edges = new HashSet<GraphEdge>();
		edges.add(new GraphEdge(a,b));
		edges.add(new GraphEdge(b,c));
		edges.add(new GraphEdge(c,a));
		UndirectedGraph g = new UndirectedGraph( edges );
		
		DepthFirstWalker w = new DepthFirstWalker();
		Tree dft = w.getResult(g, "A");
		
		String act = dft.toString();
		String exp1 = "A->B\nB->C\nC";
		String exp2 = "A->C\nC->B\nB";
		
		assertTrue(   act.equalsIgnoreCase(exp1)
				   || act.equalsIgnoreCase(exp2) );
	}
	
	@Test
	public void tst_pentagon(){
		
		GraphNode a = new GraphNode("A");
		GraphNode b = new GraphNode("B");
		GraphNode c = new GraphNode("C");
		GraphNode d = new GraphNode("D");
		GraphNode e = new GraphNode("E");
		
		HashSet<GraphEdge> edges = new HashSet<GraphEdge>();
		edges.add(new GraphEdge(a,b));
		edges.add(new GraphEdge(b,c));
		edges.add(new GraphEdge(c,d));
		edges.add(new GraphEdge(d,e));
		edges.add(new GraphEdge(e,a));
		UndirectedGraph g = new UndirectedGraph( edges );
		
		DepthFirstWalker w = new DepthFirstWalker();
		Tree dft = w.getResult(g, "A");
		
		String act = dft.toString();
		String exp1 = "A->B\nB->C\nC->D\nD->E\nE";
		String exp2 = "A->E\nE->D\nD->C\nC->B\nB";
		
		assertTrue(   act.equalsIgnoreCase(exp1)
				   || act.equalsIgnoreCase(exp2) );
	}
	
}
