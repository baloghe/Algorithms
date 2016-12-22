package graph.search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BreadthFirstWalker {

	private PriorityQueue<NodeRootDistance> pqueue;
	private HashSet<GraphNode> visited;
	
	public BreadthFirstWalker(){
		
	}
	
	private final class NodeRootDistance{
		private final Tree root;
		private final int distance;
		
		public NodeRootDistance(Tree inTree, int inDistance){
			root = inTree;
			distance = inDistance;
		}
		
	}
	
	
	public Tree getResult(UndirectedGraph inGraph, String inStartLab){
		pqueue = new PriorityQueue<NodeRootDistance>(
				 inGraph.getNodeNumber()
				,new Comparator<BreadthFirstWalker.NodeRootDistance>(){
						public int compare(BreadthFirstWalker.NodeRootDistance o1, BreadthFirstWalker.NodeRootDistance o2){
							return o1.distance - o2.distance;
						}
					}
				);
		
		visited = new HashSet<GraphNode>();
		Tree ret = new Tree( inGraph.getNode(inStartLab) );
		pqueue.add( new BreadthFirstWalker.NodeRootDistance(ret, 0) );
		visited.add(ret.getNode());
		
		while(!pqueue.isEmpty()){
			NodeRootDistance tmp = pqueue.poll();
			//System.out.println("BFS polled=" + tmp.root.getNode().getLabel());
			for(GraphNode c : inGraph.getNeighbors(tmp.root.getNode())){
				if(!visited.contains(c)){
					//System.out.println("  add to pqueue=" + c.getLabel());
					Tree childTree = new Tree(c);
					tmp.root.addChild(childTree);
					pqueue.add( new BreadthFirstWalker.NodeRootDistance(childTree, tmp.distance+1) );
					visited.add(c);
				}//endif
			}//next c
		}//wend
		
		return ret;
	}
	
}
