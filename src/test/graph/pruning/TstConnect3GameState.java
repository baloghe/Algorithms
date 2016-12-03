package test.graph.pruning;

import graph.pruning.*;

import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class TstConnect3GameState {

	@Test
	public void tstTable1(){
		
		int[][] tbl_0 = new int[][]{
				 new int[]{1,1,1}
				,new int[]{0,0,2}
				,new int[]{2,2,1}
		};
		
		int[][] tbl_1 = new int[][]{
				 new int[]{1,1,1}
				,new int[]{0,1,2}
				,new int[]{2,2,1}
		};
		
		Connect3GameState gs_0 = new Connect3GameState( tbl_0 );
		
		//step into (1,1)
		Connect3GameState gs_act = gs_0.deepCopy();
		gs_act.setCell(1, 1, 1);
		
		Connect3GameState gs_exp = new Connect3GameState( tbl_1 );
		
		assertEquals( gs_exp , gs_act );
	}
	
	@Test
	public void tstTable2(){
		int[][] tbl_0 = new int[][]{
				 new int[]{1,1,1}
				,new int[]{0,0,2}
				,new int[]{2,2,1}
		};
		
		int[][] tbl_1 = new int[][]{
				 new int[]{1,1,1}
				,new int[]{0,0,2}
				,new int[]{2,2,1}
		};
		
		assertArrayEquals( tbl_0 , tbl_1 );
	}
	
}
