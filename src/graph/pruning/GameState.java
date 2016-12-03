package graph.pruning;

import java.util.Random;

public class GameState {
	public static int COUNTER = 0;
	
	private int value;
	
	public GameState(){
		COUNTER++;
		value = COUNTER;
	}
	
	public GameState(int initVal){
		COUNTER++;
		value = initVal;
	}
	
	public GameState deepCopy(){
		return new GameState(value);
	}
	
	public void increaseValue(){
		value += (new Random()).nextInt(10);
	}
	
	public int getValue(){
		return value;
	}
	
}
