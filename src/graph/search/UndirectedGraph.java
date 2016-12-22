package graph.search;

import java.util.HashMap;
import java.util.HashSet;

public class UndirectedGraph {

	private HashMap<String,GraphNode> nodes;
	private HashSet<GraphEdge> edges;
	
	public UndirectedGraph(HashSet<GraphEdge> inEdges){
		
		nodes = new HashMap<String, GraphNode>();
		edges = new HashSet<GraphEdge>();
		
		for(GraphEdge e : inEdges){
			edges.add(e);
			nodes.put(e.from().getLabel(), e.from());
			nodes.put(e.to().getLabel(), e.to());
		}
	}
	
	public GraphNode getNode(String inLabel){
		return nodes.get(inLabel);
	}
	
	public HashSet<GraphEdge> edgesFrom(String inFromLabel){
		GraphNode nd = nodes.get(inFromLabel);
		if(nd==null) 
			return null;
		else return edgesFrom(nd);
	}
	
	public HashSet<GraphEdge> edgesFrom(GraphNode inFromNode){
		HashSet<GraphEdge> ret = new HashSet<GraphEdge>();
		
		for(GraphEdge e : edges){
			if(   e.from().equals(inFromNode)
			   || e.to().equals(inFromNode)){
				ret.add(e);
			}
		}
		
		return ret;
	}
	
	public HashSet<GraphNode> getNeighbors(String inLabel){
		return getNeighbors(getNode(inLabel));
	}
	
	public HashSet<GraphNode> getNeighbors(GraphNode inNode){
		HashSet<GraphNode> ret = new HashSet<GraphNode>();
		
		for(GraphEdge e : edges){
			if( e.from().equals(inNode) ) 
				ret.add(e.to());
			if( e.to().equals(inNode) ) 
				ret.add(e.from());
		}
		
		return ret;
	}
	
	public int getNodeNumber(){
		return nodes.size();
	}
}
