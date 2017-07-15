
import static org.junit.Assert.*;

import org.junit.Test;

public class TestSkunkApp {

	@Test
	public void testPlayerGen() {
		String name = "bob";
		Player curPlayer = new Player(name);
		assertTrue(curPlayer.id == name);
		assertTrue(curPlayer.chips == 50);
		assertTrue(curPlayer.curTotal == 0);
		assertTrue(curPlayer.curTurn == 0);
		assertTrue(curPlayer.gameTotal == 0);
		assertTrue(curPlayer.isFinal == false);
	}

	@Test
	public void testPrintSummary(){
		String name = "bob";
		Player p1 = new Player(name);
		Kitty kit=new Kitty();
		SkunkApp.turnSummary(p1, kit);
	}
}
