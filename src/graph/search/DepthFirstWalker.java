package graph.search;

import java.util.HashSet;
import java.util.Stack;

public class DepthFirstWalker {

	HashSet<GraphNode> visited;
	
	public DepthFirstWalker(){
		
	}
	
	public Tree getResult(UndirectedGraph inGraph, String inStartLab){
		GraphNode start = inGraph.getNode(inStartLab);
		Tree ret = new Tree( start );
		visited = new HashSet<GraphNode>();

		return recWalk(ret, inGraph);
	}
	
	private Tree recWalk(Tree inTree, UndirectedGraph inGraph){
		GraphNode nd = inTree.getNode();
		visited.add(nd);
		for(GraphNode c : inGraph.getNeighbors(nd)){
			if(!visited.contains(c)){
				Tree tmp = new Tree(c);
				//!! recursive call !!
				recWalk(tmp, inGraph);
				//add to parent
				inTree.addChild(tmp);
			}//endif
		}//next c
		return inTree;
	}
	
}
