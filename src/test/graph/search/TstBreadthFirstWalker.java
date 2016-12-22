package test.graph.search;

import java.util.HashSet;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import graph.search.*;

public class TstBreadthFirstWalker {

	@Test
	public void tst_root(){
		
		GraphNode r = new GraphNode("R");
		GraphNode a = new GraphNode("A");
		
		HashSet<GraphEdge> edges = new HashSet<GraphEdge>();
		edges.add(new GraphEdge(r,a));
		UndirectedGraph g = new UndirectedGraph( edges );
		
		BreadthFirstWalker w = new BreadthFirstWalker();
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
		
		BreadthFirstWalker w = new BreadthFirstWalker();
		Tree dft = w.getResult(g, "A");
		
		String act = dft.toString();
		String exp1 = "A->B,C\nB\nC";
		String exp2 = "A->C,B\nC\nB";
		
		//System.out.println("tst_triangle :: act=\n" + act);
		
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
		
		BreadthFirstWalker w = new BreadthFirstWalker();
		Tree dft = w.getResult(g, "A");
		
		String act = dft.toString();
		String exp1 = "A->B,E\nB->C\nC\nE->D\nD";
		String exp2 = "A->E,B\nE->D\nD\nB->C\nC";
		
		//System.out.println("tst_triangle :: act=\n" + act);
		
		assertTrue(   act.equalsIgnoreCase(exp1)
				   || act.equalsIgnoreCase(exp2) );
	}
	
}
