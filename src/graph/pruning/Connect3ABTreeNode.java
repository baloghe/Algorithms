package graph.pruning;

import java.util.HashSet;

public class Connect3ABTreeNode {

	public static final int PLAYER_ROOT = 0;
	public static final int PLAYER_OPPONENT = 1;
	
	public static final int ROOT_MIN = 0;
	public static final int ROOT_MAX = 1;
	
	public static int ROOT_MIN_MAX = ROOT_MIN;
	public static Connect3GameStateEvaluator EVALUATOR;
	public static int MAX_DEPTH = 100;
	
	private Connect3GameState gameState;
	private int evalType;
	private String label;
	private int level;
	private HashSet<Connect3ABTreeNode> children;
	
	public Connect3ABTreeNode(Connect3GameState inGS, int inEvalType, int inLev, String inLab){
		gameState = inGS;
		evalType = inEvalType;
		label = inLab;
		level = inLev;
		children = new HashSet<Connect3ABTreeNode>();
	}
	
	public void createChildren(){
		//create children only when the game is still running!
		if(EVALUATOR.isEndState(gameState)) return;
		
		//otherwise: generate new game states from the given one
		HashSet<Connect3GameState> states = createNextStates();
		int i=0;
		for(Connect3GameState tmpgs : states){
			i++;
			//add result as new child
			children.add( new Connect3ABTreeNode(tmpgs, 1-evalType, level+1, Integer.toString(i)) );
		}//next i		
	}
	
	private HashSet<Connect3GameState> createNextStates(){
		HashSet<Connect3GameState> ret = new HashSet<Connect3GameState>();
		int[][] t = gameState.getTable();
		//generate all possible next moves
		//possible means we have an empty slot...
		for(int r=0; r<3; r++){
			for(int c=0; c<3; c++){
				if( t[r][c] == 0 ){
					Connect3GameState tmpgs = gameState.deepCopy();
					tmpgs.setCell(r, c, (evalType == PLAYER_ROOT ? Connect3GameState.MARK_ROOT : Connect3GameState.MARK_OPPONENT) );
					ret.add(tmpgs);
				}
			}//next c
		}//next r
		//printNextStates( ret );
		return ret;
	}
	
	private void printNextStates(HashSet<Connect3GameState> inSet){
		for(int i=0; i<3; i++){
			String s = "";
			for(Connect3GameState gs : inSet){
				int[][] t = gs.getTable();
				s += (t[i][0] + "" + t[i][1] + "" + t[i][2] + " ");
			}
			System.out.println(s);
		}
	}
	
	private int evalLeaf(){
		int ret = EVALUATOR.evaluate(gameState);
		//System.out.println( this.toString() + " evalLeaf :: " + ret);
		return ret;
	}
	
	public int evalChildren(){
		if(   children.size() == 0
		   || this.level >= MAX_DEPTH) return evalLeaf();
		
		int ret = (   (evalType == PLAYER_ROOT && ROOT_MIN_MAX == ROOT_MIN)
				   || (evalType == PLAYER_OPPONENT && ROOT_MIN_MAX == ROOT_MAX) ? Integer.MAX_VALUE : Integer.MIN_VALUE);
		//String chvalues="";
		for(Connect3ABTreeNode gs : children){
			gs.createChildren();
			//recursive call for evaluation
			int tmp = gs.evalChildren();
			//chvalues += (tmp + " ");
			if(   (evalType == PLAYER_ROOT && ROOT_MIN_MAX == ROOT_MIN && ret > tmp)
			   || (evalType == PLAYER_ROOT && ROOT_MIN_MAX == ROOT_MAX && ret < tmp)
			   || (evalType == PLAYER_OPPONENT && ROOT_MIN_MAX == ROOT_MIN && ret < tmp) 
			   || (evalType == PLAYER_OPPONENT && ROOT_MIN_MAX == ROOT_MAX && ret > tmp) ){
				ret = tmp;				
			}
		}
		//chvalues += ("-> " + ret);
		/*
		System.out.println(  this.toString() + " eval " 
		                   + (   (evalType == PLAYER_ROOT && ROOT_MIN_MAX == ROOT_MIN) 
		                      || (evalType == PLAYER_OPPONENT && ROOT_MIN_MAX == ROOT_MAX) ? "MIN" : "MAX") + " :: " + chvalues);
		*/
		return ret;
	}
	
	public int getLevel(){
		return level;
	}
	
	public String toString(){
		return level + "." + label;
	}
	
}
