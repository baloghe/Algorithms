package graph.search;

public class GraphNode {

	private String label;
	
	public GraphNode(String inLab){
		label = inLab;
	}
	
	public boolean equals(Object inObj){
		if(inObj==this) return true;
		
		if(!(inObj instanceof GraphNode)) return false;
		
		return this.label.equalsIgnoreCase( ((GraphNode)inObj).label );
	}
	
	public int hashCode(){
		return label.hashCode();
	}
	
	public String getLabel(){return label;}
	
}
