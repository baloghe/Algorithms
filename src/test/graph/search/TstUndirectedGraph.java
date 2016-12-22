package test.graph.search;

import java.util.HashSet;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import graph.search.*;

public class TstUndirectedGraph {

	@Test
	public void tst_emptyGraph(){
		
		HashSet<GraphEdge> edges = new HashSet<GraphEdge>();
		UndirectedGraph g = new UndirectedGraph(edges);		
		
	}
	
	@Test
	public void tst_oneNode(){
		
		HashSet<GraphEdge> edges = new HashSet<GraphEdge>();
		edges.add( new GraphEdge( new GraphNode("R") , new GraphNode("R") ) );
		UndirectedGraph g = new UndirectedGraph(edges);		
		
	}
	
	@Test
	public void tst_twoNodes(){
		
		HashSet<GraphEdge> edges = new HashSet<GraphEdge>();
		
		GraphNode a = new GraphNode("A");
		GraphNode b = new GraphNode("B");
		
		edges.add( new GraphEdge( a , b ) );
		UndirectedGraph g = new UndirectedGraph(edges);		
		
		HashSet<GraphNode> exp = new HashSet<GraphNode>();
		exp.add(b);
		
		HashSet<GraphNode> act = g.getNeighbors(a);
		
		assertEquals(exp,act);
	}
	
	@Test
	public void tst_threeNodes(){
		
		HashSet<GraphEdge> edges = new HashSet<GraphEdge>();
		
		GraphNode r = new GraphNode("R");
		GraphNode a = new GraphNode("A");
		GraphNode b = new GraphNode("B");
		
		edges.add( new GraphEdge( r , a ) );
		edges.add( new GraphEdge( r , b ) );
		UndirectedGraph g = new UndirectedGraph(edges);		
		
		HashSet<GraphNode> exp = new HashSet<GraphNode>();
		exp.add(a);
		exp.add(b);
		
		HashSet<GraphNode> act = g.getNeighbors(r);
		
		assertEquals(exp,act);
	}
	
	@Test
	public void tst_triangle(){
		
		HashSet<GraphEdge> edges = new HashSet<GraphEdge>();
		
		GraphNode a = new GraphNode("A");
		GraphNode b = new GraphNode("B");
		GraphNode c = new GraphNode("C");
		
		edges.add( new GraphEdge( a , b ) );
		edges.add( new GraphEdge( a , c ) );
		edges.add( new GraphEdge( b , c ) );
		UndirectedGraph g = new UndirectedGraph(edges);		
		
		HashSet<GraphNode> exp = new HashSet<GraphNode>();
		exp.add(a);
		exp.add(b);
		
		HashSet<GraphNode> act = g.getNeighbors(c);
		
		assertEquals(exp,act);
	}
	
}
