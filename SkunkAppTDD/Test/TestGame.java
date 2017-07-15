import java.util.ArrayList;

import org.junit.Test;

public class TestGame {
	
	@Test
	public void testValPlayerList(){
		ArrayList<Player> players=new ArrayList<Player>();
		Player p1=new Player("Bob");
		Player p2= new Player("John");
		
		players.add(p1);
		players.add(p2);
		
		Game.validatePlayerList(players);
		
		players.remove(p1);
		//Game.validatePlayerList(players);
		
	}
}
