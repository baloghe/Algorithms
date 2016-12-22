package graph.search;

public class GraphEdge {

	private GraphNode fromNode;
	private GraphNode toNode;
	
	public GraphEdge(GraphNode inFrom, GraphNode inTo){
		fromNode = inFrom;
		toNode = inTo;
	}
	
	public GraphEdge(GraphNode inFrom, GraphNode inTo, double inWeight){
		fromNode = inFrom;
		toNode = inTo;
	}
	
	public GraphNode from(){return fromNode;}
	public GraphNode to(){return toNode;}
	
	public GraphEdge getOpposite(){
		return new GraphEdge(this.toNode , this.fromNode);
	}
		
}
