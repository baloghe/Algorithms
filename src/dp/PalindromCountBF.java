package dp;

public class PalindromCountBF {

	public PalindromCountBF(){
		
	}
	
	public int count(String s){
		int ret = 0;
		
		for(int i=0; i<=s.length()-2; i++){
			for(int j=i+2; j<=s.length(); j++){
				String tst = s.substring(i, j);
				boolean b = isPalindromic( tst );
				//System.out.println( "tst=" + tst + " -> b=" + b );
				if( b ) ret++;
			}
		}
		
		return ret;
	}
	
	public boolean isPalindromic(String s){
		int i=0;
		int j=s.length()-1;
		boolean ret = true;
		
		while(ret && i<=j){
			ret = ( s.substring(i, i+1).equalsIgnoreCase( s.substring(j, j+1) ) );
			i++;
			j--;
		}
		
		return ret;
	}
	
}
