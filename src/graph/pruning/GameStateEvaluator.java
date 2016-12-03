package graph.pruning;

public class GameStateEvaluator {

	public GameStateEvaluator(){
		
	}
	
	public int evaluate(GameState inGS){
		return inGS.getValue();
	}
	
	public boolean isEndState(GameState inGS){
		//for testing: approve only a predefined Value to be reached
		return (inGS.getValue() > 10);
	}
	
}
