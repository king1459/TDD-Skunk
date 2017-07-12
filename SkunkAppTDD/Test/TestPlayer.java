import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	//default values are set properly
	@Test
	public void testNew(){
		Player P1=new Player("John");
		assertTrue(P1.chips==50);
		assertTrue(P1.curTotal==0);
		assertTrue(P1.curTurn==0);
		assertTrue(P1.gameTotal==0);
		assertTrue(P1.id=="John");
		assertFalse(P1.isFinal);
	}
	
	//roll score added to player correctly
	@Test
	public void updateRoll(){
		Player P1=new Player("John");
		P1.curTotal=17;
		int score=7;
		P1.updateCurScore(score);
		assertTrue(P1.curTotal==24);
		assertTrue(P1.curTurn==7);
		assertTrue(P1.gameTotal==0);
		assertTrue(P1.chips==50);
		assertTrue(P1.id=="John");
		assertFalse(P1.isFinal);
	}
	
	
	//turn score added correctly
	@Test
	public void updateTurn(){
		Player P1=new Player("John");
		P1.curTurn=18;
		P1.gameTotal=25;
		P1.curTotal=P1.curTurn+P1.gameTotal;
		
		P1.updateGameTotal();
		assertTrue(P1.gameTotal==43);
		assertTrue(P1.curTotal==43);
		assertTrue(P1.curTurn==0);
		assertTrue(P1.chips==50);
		assertTrue(P1.id=="John");
		assertFalse(P1.isFinal);
	}
	
	//test chips are removed correctly
	@Test
	public void removeChips(){
		Player P1=new Player("John");
		int chips=4;
		P1.loseChips(chips);
		assertTrue(P1.chips==50-chips);
		assertTrue(P1.curTotal==0);
		assertTrue(P1.curTurn==0);
		assertTrue(P1.gameTotal==0);
		assertTrue(P1.id=="John");
		assertFalse(P1.isFinal);
	}
	
	//test that the current scores are reset
	@Test
	public void skunkReset(){
		Player P1=new Player("John");
		
		P1.curTurn=15;
		P1.gameTotal=17;
		P1.curTotal=P1.curTurn+P1.gameTotal;
		
		P1.skunkReset();
		
		assertTrue(P1.chips==50);
		assertTrue(P1.curTotal==17);
		assertTrue(P1.curTurn==0);
		assertTrue(P1.gameTotal==17);
		assertTrue(P1.id=="John");
		assertFalse(P1.isFinal);
	}
	
	//test that the all points are reset at the end of the round
	@Test
	public void clearRound(){
		Player P1=new Player("John");
		P1.chips=43;
		P1.curTotal=99;
		P1.curTurn=3;
		P1.gameTotal=99;
		P1.isFinal=true;
		
		P1.clearRound();
		
		assertTrue(P1.chips==43);
		assertTrue(P1.curTotal==0);
		assertTrue(P1.curTurn==0);
		assertTrue(P1.gameTotal==0);
		assertTrue(P1.id=="John");
		assertFalse(P1.isFinal);
	}
}
