package graph.search;

import java.util.HashSet;

public class Tree {

	private final GraphNode node;
	private Tree parent;
	private HashSet<Tree> children;
	
	public Tree(GraphNode nd){
		node = nd;
		parent = null;
		children = new HashSet<Tree>();
	}
	
	public void addChild(Tree inChild){
		inChild.parent = this;
		children.add(inChild);
	}
	
	public Tree getParent(){
		return parent;
	}
	
	public GraphNode getNode(){return node;}
	
	public String toString(){
		if(node==null) return "NULL";
		
		String ret = node.getLabel();
		if( children.size() > 0 ){
			ret += "->";
			boolean first = true;
			for(Tree t : children){
				if(!first){
					ret += ",";
				}
				first = false;
				ret += t.node.getLabel();
			}
			for(Tree t : children){
				ret += ("\n" + t.toString());
			}
		}
		return ret;
	}
}
