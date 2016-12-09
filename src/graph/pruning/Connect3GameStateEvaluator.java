package graph.pruning;

public class Connect3GameStateEvaluator {
	
	public Connect3GameStateEvaluator(){
		
	}
	
	public int evaluate(Connect3GameState inGS){
		int[][] t = inGS.getTable();
		
		int ret = 0;
		
		//eval lines & cols for winner
		for(int r=0; r<3; r++){
			if(   t[r][0] == Connect3GameState.MARK_ROOT 
			   && t[r][1] == Connect3GameState.MARK_ROOT 
			   && t[r][2] == Connect3GameState.MARK_ROOT) ret += 100;
			
			if(   t[0][r] == Connect3GameState.MARK_ROOT 
			   && t[1][r] == Connect3GameState.MARK_ROOT 
			   && t[2][r] == Connect3GameState.MARK_ROOT) ret += 100;
			
			if(   t[r][0] == Connect3GameState.MARK_OPPONENT 
			   && t[r][1] == Connect3GameState.MARK_OPPONENT 
			   && t[r][2] == Connect3GameState.MARK_OPPONENT) ret -= 100;
					
			if(   t[0][r] == Connect3GameState.MARK_OPPONENT 
			   && t[1][r] == Connect3GameState.MARK_OPPONENT 
			   && t[2][r] == Connect3GameState.MARK_OPPONENT) ret -= 100;
		}
		//System.out.println("  eval :: after lines & cols for winner: ret=" + ret);
		
		//eval diagonals for winner
		if(   t[0][0] == Connect3GameState.MARK_ROOT 
		   && t[1][1] == Connect3GameState.MARK_ROOT 
		   && t[2][2] == Connect3GameState.MARK_ROOT) ret += 100;
		if(   t[2][0] == Connect3GameState.MARK_ROOT 
		   && t[1][1] == Connect3GameState.MARK_ROOT 
		   && t[0][2] == Connect3GameState.MARK_ROOT) ret += 100;
		if(   t[0][0] == Connect3GameState.MARK_OPPONENT 
		   && t[1][1] == Connect3GameState.MARK_OPPONENT 
		   && t[2][2] == Connect3GameState.MARK_OPPONENT) ret -= 100;
		if(   t[2][0] == Connect3GameState.MARK_OPPONENT 
		   && t[1][1] == Connect3GameState.MARK_OPPONENT 
		   && t[0][2] == Connect3GameState.MARK_OPPONENT) ret -= 100;
		//System.out.println("  eval :: after diagonals for winner: ret=" + ret);
		
		//eval lines for 1 and 2 marks & an empty space
		for(int r=0; r<3; r++){
			int cnt = 0;
			int tmp = 0;
			//row-by-row
			for(int c=0; c<3; c++){
				//System.out.println("       t["+r+"]["+c+"]=" + t[r][c]);
				if(t[r][c]==Connect3GameState.MARK_ROOT){
					tmp += 1;
					cnt++;
				} else if(t[r][c]==Connect3GameState.MARK_OPPONENT){
					tmp -= 1;
					cnt++;
				}
			}//next c
			//two marks awarded with a factor of 10
			if(cnt==2) tmp*=10;
			if(cnt<3) ret += tmp;
			//System.out.println("    r=" + r + ", cnt=" + cnt + ", tmp=" + tmp);
		}
		//System.out.println("  eval :: after lines for 1 and 2 marks: ret=" + ret);
		
		//eval columns for 1 and 2 marks & an empty space
		for(int c=0; c<3; c++){
			int cnt = 0;
			int tmp = 0;
			//col-by-col
			for(int r=0; r<3; r++){
				if(t[r][c]==Connect3GameState.MARK_ROOT){
					tmp += 1;
					cnt++;
				} else if(t[r][c]==Connect3GameState.MARK_OPPONENT){
					tmp -= 1;
					cnt++;
				}
			}//next r
			//two marks awarded with a factor of 10
			if(cnt==2) tmp*=10;
			if(cnt<3) ret += tmp;
			//System.out.println("    c=" + c + ", cnt=" + cnt + ", tmp=" + tmp);
		}
		//System.out.println("  eval :: after columns for 1 and 2 marks: ret=" + ret);
		
		return ret;
	}
	
	public boolean isEndState(Connect3GameState inGS){
		int[][] t = inGS.getTable();
		       
		return //check verticals for winner   
				  (t[0][0]!=0 && t[0][0]==t[0][1] && t[0][1]==t[0][2])
		       || (t[1][0]!=0 && t[1][0]==t[1][1] && t[1][1]==t[1][2])
		       || (t[2][0]!=0 && t[2][0]==t[2][1] && t[2][1]==t[2][2])
		       //check horizontals for winner
		       || (t[0][0]!=0 && t[0][0]==t[1][0] && t[1][0]==t[2][0])
		       || (t[0][1]!=0 && t[0][1]==t[1][1] && t[1][1]==t[2][1])
		       || (t[0][2]!=0 && t[0][2]==t[1][2] && t[1][2]==t[2][2])
		       //check diagonals for winner
		       || (t[0][0]!=0 && t[0][0]==t[1][1] && t[1][1]==t[2][2])
		       || (t[2][0]!=0 && t[2][0]==t[1][1] && t[1][1]==t[0][2])
		       //check table filled
		       || (   t[0][0]!=0 && t[0][1]!=0 && t[0][2]!=0
		           && t[1][0]!=0 && t[1][1]!=0 && t[1][2]!=0
		           && t[2][0]!=0 && t[2][1]!=0 && t[2][2]!=0)
		       ;
	}
	
}
