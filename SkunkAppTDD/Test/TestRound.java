import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestRound {

	
	@Test 
	public void testWinner(){
		ArrayList<Player> players=new ArrayList<Player>();
		Player p1=new Player("Bob");
		Player p2= new Player("John");
		
		p1.gameTotal=101;
		p2.gameTotal=102;
		
		players.add(p1);
		players.add(p2);
		
		assertTrue(p2.equals(Round.getWinner(players)));
	}
	
	@Test
	public void testWinnerUpdates(){
		ArrayList<Player> players=new ArrayList<Player>();
		Player p1=new Player("Bob");
		Player p2= new Player("John");
		Kitty kit=new Kitty();
		kit.chips=7;
		Player winner=p2;
		players.add(p1);
		players.add(p2);
		
		Round.winnerUpdates(players, kit, winner);
		
		assertTrue(winner.chips==57);
		assertTrue(kit.chips==0);
	}
}
