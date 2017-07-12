import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestRoll {

	@Test
	public void canRollDie(){
		int value=Roll.die();
		assertTrue(value<=6);
		assertTrue(value>=1);
	}
	
	@Test
	public void validRoll(){
		Roll curRoll = new Roll();
		curRoll.roll();
		assertTrue(curRoll.die1<=6);
		assertTrue(curRoll.die1>=1);
		assertTrue(curRoll.die2<=6);
		assertTrue(curRoll.die2>=1);
		assertTrue(curRoll.total<=12);
		assertTrue(curRoll.total>=2);
	}
}
