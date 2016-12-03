package graph.pruning;

import java.util.HashSet;

public class ABTreeNode {

	public static final int NUM_CHILDREN = 3;
	
	public static final int PLAYER_ROOT = 0;
	public static final int PLAYER_OPPONENT = 1;
	
	public static GameStateEvaluator EVALUATOR;
	
	private GameState gameState;
	private int evalType;
	private String label;
	private int level;
	private HashSet<ABTreeNode> children;
	
	public ABTreeNode(GameState inGS, int inEvalType, int inLev, String inLab){
		gameState = inGS;
		evalType = inEvalType;
		label = inLab;
		level = inLev;
		children = new HashSet<ABTreeNode>();
	}
	
	public void createChildren(){
		//create children only when the game is still running!
		if(EVALUATOR.isEndState(gameState)) return;
		
		//otherwise: generate new game states from the given one
		HashSet<GameState> states = createNextStates();
		int i=0;
		for(GameState tmpgs : states){
			i++;
			//add result as new child
			children.add( new ABTreeNode(tmpgs, 1-evalType, level+1, Integer.toString(i)) );
		}//next i		
	}
	
	private HashSet<GameState> createNextStates(){
		HashSet<GameState> ret = new HashSet<GameState>();
		for(int i=0; i<NUM_CHILDREN; i++){
			GameState tmpgs = gameState.deepCopy();
			//simulate player step
			tmpgs.increaseValue();
			ret.add(tmpgs);
		}
		return ret;
	}
	
	private int evalLeaf(){
		int ret = EVALUATOR.evaluate(gameState);
		System.out.println( this.toString() + " evalLeaf :: " + ret);
		return ret;
	}
	
	public int evalChildren(){
		if(children.size() == 0) return evalLeaf();
		
		int ret = (evalType == PLAYER_ROOT ? Integer.MAX_VALUE : Integer.MIN_VALUE);
		String chvalues="";
		for(ABTreeNode gs : children){
			gs.createChildren();
			//recursive call for evaluation
			int tmp = gs.evalChildren();
			chvalues += (tmp + " ");
			if(   (evalType == PLAYER_ROOT && ret > tmp) 
			   || (evalType == PLAYER_OPPONENT && ret < tmp) ){
				ret = tmp;				
			}
		}
		chvalues += ("-> " + ret);
		System.out.println( this.toString() + " eval " + (evalType == PLAYER_ROOT ? "MIN" : "MAX") + " :: " + chvalues);
		return ret;
	}
	
	public int getLevel(){
		return level;
	}
	
	public String toString(){
		return level + "." + label;
	}
	
}
